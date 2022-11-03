package Hackathon;

import Hackathon.entities.Company;
import Hackathon.services.CompanyService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class HackathonApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackathonApplication.class, args);
	}

	// a method for adding the data from the JSON file to the DB:
	@Bean
	CommandLineRunner runner(CompanyService companyService){
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Company>> typeReference = new TypeReference<List<Company>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/companies.json");
			try {
				List<Company> companies = mapper.readValue(inputStream, typeReference);
				companyService.saveCompanies(companies);
				System.out.println("Companies imported from the JSON file");
			} catch (IOException e){
				System.err.println("Unable to import from JSON file: " + e.getMessage());
			}
		};
	}
}
