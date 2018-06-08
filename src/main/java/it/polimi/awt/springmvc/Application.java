package it.polimi.awt.springmvc;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import it.polimi.awt.springmvc.domain.RegisterByDistrict;
import it.polimi.awt.springmvc.service.EnergyDataExchangeFormatService;
import it.polimi.awt.springmvc.service.RegisterByDistrictService;
import it.polimi.awt.springmvc.service.RegisterService;
import it.polimi.awt.springmvc.util.WrapperRegister;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private RegisterByDistrictService registerByDistrictService;

	@Autowired
	private EnergyDataExchangeFormatService energyDataService;
	
	public static void main(final String args[]) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class);
		ctx.close();
	}

	@Override
	public void run(String... args) throws Exception {

		// Register r = new Register ("abc",new Date());
		// registerService.saveRegister(r);
		// registerService.retrieveRegisterByMeteringPointId("abc");

		Date startDate = new Date();
		System.out.println("--- AVVIO PROCEDURA --" + startDate + "\n");

		System.out.println("-- Estrazione file da cartella... ");
		WrapperRegister wrapperRegister = energyDataService.loadXMLFiles();
		if (wrapperRegister != null && !wrapperRegister.getRegisters().isEmpty()) {
			
			//encompass.register_by_meteringpointid
			System.out.println("Attendere: Sto salvando " + wrapperRegister.getRegisters().size() +" registrazioni su Cassandra ...");
			Boolean result = registerService.saveRegisters(wrapperRegister.getRegisters());
			
			//encompass.register_by_district
			List <RegisterByDistrict> registersByDistrict = registerByDistrictService.mapIntoRegisterByDistrict(wrapperRegister.getRegisters());
			System.out.println("Attendere: Sto salvando " + registersByDistrict.size() +" registrazioni per district su Cassandra ...");
			Boolean result2 = registerByDistrictService.saveRegistersByDistrict(registersByDistrict);
			
			if (result && result2) {
				System.out.println("\n-- Registrazioni salvate in register_by_metering_point_name");
				System.out.println("-- buone: " + wrapperRegister.getRegisters().size());
				System.out.println("-- negative: " + wrapperRegister.getNegativeRegisters().size());
				System.out.println("-- troppo alte: " + wrapperRegister.getHighRegisters().size());
				
				System.out.println("\n-- Registrazioni salvate in register_by_district");
				System.out.println("-- buone: " + registersByDistrict.size());
				System.out.println("-- nulle: " + (wrapperRegister.getRegisters().size() - registersByDistrict.size()));
				
			} else
				System.err.println("-- Salvataggio su database fallito");

			
		}else {
			System.err.println("-- Nessun file trovato");
		
		}
		Date endDate = new Date();
		System.out.println("\n-- Tempo di esecuzione in ms: " + (endDate.getTime() - startDate.getTime()));
		System.out.println("\n--- FINE PROCEDURA  ---" + endDate);
	
	}
	
}
