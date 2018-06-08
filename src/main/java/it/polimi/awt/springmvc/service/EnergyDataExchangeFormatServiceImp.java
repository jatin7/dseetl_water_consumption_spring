package it.polimi.awt.springmvc.service;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.google.common.io.Files;

import it.polimi.awt.springmvc.domain.Register;
import it.polimi.awt.springmvc.mapper.EnergyDataExchangeFormatType;
import it.polimi.awt.springmvc.mapper.RegisterType;
import it.polimi.awt.springmvc.repository.EnergyDataExchangeFormatRepository;
import it.polimi.awt.springmvc.util.MyComparator;
import it.polimi.awt.springmvc.util.WrapperRegister;

@Service
public class EnergyDataExchangeFormatServiceImp implements EnergyDataExchangeFormatService {

	public final static Integer ORDER_OF_MAGNITUDE = 2;

	private EnergyDataExchangeFormatRepository energyDataExchangeFormatRepository;
	
	@Value("${import.folder.processed.out}")
	private String folderForProcessedFiles;
	
	@Value("${import.folder.processed.error}")
	private String folderForErrorFiles;
	
	  @Autowired 
	  public EnergyDataExchangeFormatServiceImp(EnergyDataExchangeFormatRepository energyDataExchangeFormatRepository){
		  this.energyDataExchangeFormatRepository = energyDataExchangeFormatRepository; 
	  }
	 

	public EnergyDataExchangeFormatType getEnergyDataExchangeFormatFromFile(String path) {
		return energyDataExchangeFormatRepository.importEnergyData(path);
	}

	public Map<String, List<RegisterType>> groupByMeteringPointName(
			EnergyDataExchangeFormatType energyDataExchangeFormat) {
		System.out.println("-- Raggruppo per metering point name ...");
		return energyDataExchangeFormat.getDynamicData().getRegisters().getRegister().stream().filter(x -> x != null)
				.collect(Collectors.groupingBy(RegisterType::getMeteringPointName));
	}

	public WrapperRegister computeDelta(Map<String, List<RegisterType>> registersGrouped) {
		WrapperRegister wrapperRegister = new WrapperRegister();

		List<RegisterType> registerTypes = new ArrayList<RegisterType>();

		for (Entry<String, List<RegisterType>> entry : registersGrouped.entrySet()) {
			registerTypes = entry.getValue();
			System.out.println("\n-- Seleziono metering point " + entry.getKey());

			System.out.println("-- Ordino misurazioni per timestamp2 DESC");
			Collections.sort(registerTypes, new MyComparator());

			registerTypes = registerTypes.stream().filter(x -> x.getUnit() != "").collect(Collectors.toList());
			System.out.println("-- Rimuovo misurazioni indesiderate... rimosse "
					+ (entry.getValue().size() - registerTypes.size()));

			System.out.println("-- Calcolo Δ ");

			// index +1 avoid out of bound array
			for (int index = 0; index + 1 < registerTypes.size(); index++) {
				RegisterType registerType = registerTypes.get(index);

				Register register = new Register(registerType.getMeteringPointId(), registerType.getMeteringPointName(),
						// compute delta
						registerType.getValue() - registerTypes.get(index + 1).getValue(), registerType.getStatus(),
						registerType.getTimestamp2().toGregorianCalendar().getTime(), registerType.getUnit(),
						registerType.getTransformerRatio());

				// add register to list
				if (register.getValue() < 0) {
					System.out.println("NEGATIVE REGISTER ! " + register.getTimestamp() + " - " + register.getValue()
							+ " " + register.getUnit());
					wrapperRegister.getNegativeRegisters().add(register);
				} else { // positive, too high case
					if (register.getValue() / (10 ^ ORDER_OF_MAGNITUDE) > registerTypes.get(index + 1).getValue()) {
						System.out.println("TOO HIGH REGISTER ! " + register.getTimestamp() + " - "
								+ register.getValue() + " " + register.getUnit());
						wrapperRegister.getHighRegisters().add(register);
					} else {// positive, normal case
						System.out.println(
								register.getTimestamp() + " - " + register.getValue() + " " + register.getUnit());
						wrapperRegister.getRegisters().add(register);
					}
				}

			}
		}

		return wrapperRegister;
	}


	@Override
	public WrapperRegister loadXMLFiles() throws IOException {
		WrapperRegister tempWrapperRegister = new WrapperRegister();
		WrapperRegister wrapperRegister = new WrapperRegister();
		EnergyDataExchangeFormatType energyDataExchangeFormatType = null;
		Resource[] resources = energyDataExchangeFormatRepository.getXMLFilesFromFileSystem();
		
		if (resources != null) {
			for (Resource resource : resources) {
				
				try {
					energyDataExchangeFormatType = getEnergyDataExchangeFormatFromFile(resource.getFile().getAbsolutePath());
					//move file in OUT folder
					Files.move(resource.getFile(),Paths.get(folderForProcessedFiles+resource.getFile().getName()).toFile());
				} catch (IOException e) {
					System.err.println("Errore su import file " + resource.getFile().getAbsolutePath());
					//move file in ERROR folder
					Files.move(resource.getFile(),Paths.get(folderForErrorFiles+resource.getFile().getName()).toFile());
					e.printStackTrace();
					return null;
				}
				
				Map<String, List<RegisterType>> registersGrouped = groupByMeteringPointName(energyDataExchangeFormatType);
				tempWrapperRegister = computeDelta(registersGrouped);
				
				if (!tempWrapperRegister.getHighRegisters().isEmpty())
					wrapperRegister.getHighRegisters().addAll(tempWrapperRegister.getHighRegisters());
				if (!tempWrapperRegister.getNegativeRegisters().isEmpty())
					wrapperRegister.getNegativeRegisters().addAll(tempWrapperRegister.getNegativeRegisters());
				if (!tempWrapperRegister.getRegisters().isEmpty())
					wrapperRegister.getRegisters().addAll(tempWrapperRegister.getRegisters());
			}
			
			return wrapperRegister;
		}else
			return null;
	}


}