package Hackathon.controllers.interfaces;

import Hackathon.entities.Company;

import java.util.List;

public interface CompanyControllerInterface {

    List<Company> getCompanies();

    List<Company> getCompaniesBySize();

    List<Company> getCompaniesByCreationDate();

    List<List<Object[]>> getCounts();

}
