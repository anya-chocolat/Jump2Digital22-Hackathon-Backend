package Hackathon.services.interfaces;

import Hackathon.entities.Company;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface CompanyServiceInterface {

    void saveCompanies(List<Company> companies);

    List<Company> getCompanies();

    List<Company> getCompaniesBySize();

    List<Company> getCompaniesByCreationDate();

    List<Object[]> countCompanyByIndustry();

    List<Object[]> countCompanyBySize();

    List<Object[]> countCompanyByCreationDate();
}
