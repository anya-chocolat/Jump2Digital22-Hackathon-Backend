package Hackathon.services;

import Hackathon.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import Hackathon.repositories.CompanyRepository;
import Hackathon.services.interfaces.CompanyServiceInterface;

import java.util.List;
import java.util.Map;

@Service
public class CompanyService implements CompanyServiceInterface {

    @Autowired
    CompanyRepository companyRepository;

    public void saveCompanies(List<Company> companies) {
        for (Company company : companies) {
            companyRepository.save(company);
        }
    }

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public List<Company> getCompaniesBySize() {
        return companyRepository.orderBySize();
    }

    public List<Company> getCompaniesByCreationDate() {
        return companyRepository.orderByCreationDate();
    }

    public List<Object[]> countCompanyByIndustry() {
        return companyRepository.countCompanyByIndustry();
    }

    public List<Object[]> countCompanyBySize() {
        return companyRepository.countCompanyBySize();
    }

    public List<Object[]> countCompanyByCreationDate() {
        return companyRepository.countCompanyByCreationDate();
    }

}
