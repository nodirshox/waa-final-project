package uz.spiders.propertymanagement.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "user")
    private List<PropertyView> views;

    @ManyToMany
    private List<Property> favouriteProperties;
}
