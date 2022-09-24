package uz.spiders.propertymanagement.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated
    private UserType type;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    private List<PropertyView> views;

    @ManyToMany
    private List<Property> favouriteProperties;

    public static enum UserType {
        ADMIN,
        OWNER,
        CUSTOMER
    }
}
