package Hackathon.controllers;

import Hackathon.controllers.interfaces.CompanyControllerInterface;
import Hackathon.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Hackathon.services.interfaces.CompanyServiceInterface;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/companies")
public class CompanyController implements CompanyControllerInterface {

    @Autowired
    private CompanyServiceInterface companyService;

    @GetMapping
    public List<Company> getCompanies() {
        return companyService.getCompanies();
    }

    // endpoint for getting the companies ordered by size:
    @GetMapping("/by-size")
    public List<Company> getCompaniesBySize() {
        return companyService.getCompaniesBySize();
    }

    // endpoint for getting the companies ordered by creation date:
    @GetMapping("/by-year")
    public List<Company> getCompaniesByCreationDate() {
        return companyService.getCompaniesByCreationDate();
    }

    // endpoint for getting the company count by industry, by size and by creation year:
    @GetMapping("/count")
    public List<List<Object[]>> getCounts() {
        return Arrays.asList(companyService.countCompanyByIndustry(), companyService.countCompanyBySize(), companyService.countCompanyByCreationDate());
    }
}
