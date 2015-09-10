package be.vdab.dao;

import java.io.File;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:dao.properties")
public class CreateDAOBeans {
	
	@Value("${persoonDAOCSV}")
	private File csvBestand;
	
	@Value("${persoonDAOTXT}")
	private File txtBestand;
	
	@Bean
	@Qualifier("CSV")
	public PersoonDAO persoonDAOCSV(){
		return new PersoonDAOCSV(csvBestand);
	}
	
	@Bean
	@Qualifier("TXT")
	public PersoonDAO persoonDAOTXT(){
		return new PersoonDAOMeerdereRegels(txtBestand);
	}
}
