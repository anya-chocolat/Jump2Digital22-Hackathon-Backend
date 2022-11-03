package Hackathon;

import Hackathon.repositories.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
class HackathonApplicationTests {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @DisplayName("get mapping '/companies' returns the list of companies")
    void getCompanies_works() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/companies")).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("1803-artisan-deer"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("2100happiness-aps"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("zooma-simplicity-by-design"));
    }

    @Test
    @DisplayName("get mapping '/companies/by-size' returns the list of companies ordered by size")
    void getCompaniesBySize_works() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/companies/by-size")).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().startsWith("[{\"id\":\"gpo---grupo-de-profissionais-oracle\""));
    }

    @Test
    @DisplayName("get mapping '/companies/by-year' returns the list of companies ordered by size")
    void getCompaniesByCreationDate_works() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/companies/by-year")).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().startsWith("[{\"id\":\"washington-academy\""));
    }

    @Test
    @DisplayName("get mapping '/companies/count' returns the number of companies per industry, per size range and per creation year")
    void getCounts_works() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/companies/count")).andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("[\"accounting\",11]"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("[\"1-10\",305]"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("1792,1"));
    }

}
