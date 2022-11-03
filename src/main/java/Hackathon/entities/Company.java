package Hackathon.entities;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    private String id;
    private String website;
    private String name;
    @Nullable
    private Integer founded;
    private String size;
    private String locality;
    private String region;
    private String country;
    private String industry;
    private String linkedin_url;

}
