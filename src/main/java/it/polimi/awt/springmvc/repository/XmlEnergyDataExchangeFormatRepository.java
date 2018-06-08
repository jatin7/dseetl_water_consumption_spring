package it.polimi.awt.springmvc.repository;

import it.polimi.awt.springmvc.mapper.EnergyDataExchangeFormatType;


import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Repository;

@Repository
public class XmlEnergyDataExchangeFormatRepository implements EnergyDataExchangeFormatRepository {

	@Autowired
	private ResourceLoader resourceLoader;
	
	@Value("${import.folder.path}")
	private String folderPath;
	
	// JAXBContext is thread safe and can be created once
	private static JAXBContext jaxbContext = null;
	private EnergyDataExchangeFormatType energyDataExchangeFormatType;

	//singleton
	public static JAXBContext getInstance() {
		if (jaxbContext == null) {
			try {
				jaxbContext = JAXBContext.newInstance(EnergyDataExchangeFormatType.class);
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
			return jaxbContext;
		}else
			return jaxbContext;
	}

	public EnergyDataExchangeFormatType importEnergyData(String xmlStringPath) {
		try {

			System.out.println("Apro file " + xmlStringPath + "...");
			File file = new File(xmlStringPath);
			Unmarshaller unmarshaller = getInstance().createUnmarshaller();
			energyDataExchangeFormatType = (EnergyDataExchangeFormatType) unmarshaller.unmarshal(file);
			System.out.println("n. di misurazioni: "
					+ energyDataExchangeFormatType.getDynamicData().getRegisters().getRegister().size());

		} catch (JAXBException e) {
			System.err.println("La procedura si è interrotta in fase di unmarshalling : ");
			e.printStackTrace();
		}

		return energyDataExchangeFormatType;

	}

	@Override
	public Resource[] getXMLFilesFromFileSystem() {
		Resource[] resources = null;
		try {
			//aggiungere qui un riferimento a application.properties
			resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources(folderPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resources;
	}

}
