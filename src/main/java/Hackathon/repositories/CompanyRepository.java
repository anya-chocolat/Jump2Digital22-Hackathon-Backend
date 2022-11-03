package Hackathon.repositories;

import Hackathon.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

    @Query("SELECT c FROM Company c ORDER BY (CASE c.size WHEN '10001+' THEN 1 WHEN '5001-10000' THEN 2 WHEN '1001-5000' THEN 3 WHEN '501-1000' THEN 4 WHEN '201-500' THEN 5 WHEN '51-200' THEN 6 WHEN '11-50' THEN 7 WHEN '1-10' THEN 8 ELSE 9 END)")
    List<Company> orderBySize();

    @Query("SELECT c FROM Company c ORDER BY c.founded NULLS LAST")
    List<Company> orderByCreationDate();

    @Query("SELECT c.industry, COUNT(c.id) FROM Company c GROUP BY c.industry ORDER BY c.industry NULLS LAST")
    List<Object[]> countCompanyByIndustry();

    @Query("SELECT c.size, COUNT(c.id) FROM Company c GROUP BY c.size ORDER BY c.size NULLS LAST")
    List<Object[]> countCompanyBySize();

    @Query("SELECT c.founded, COUNT(c.id) FROM Company c GROUP BY c.founded ORDER BY c.founded NULLS LAST")
    List<Object[]> countCompanyByCreationDate();
}

