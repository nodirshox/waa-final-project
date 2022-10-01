package uz.spiders.propertymanagement.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String email;

    private String name;

    @Enumerated
    private UserType type;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    private List<PropertyView> views;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    @JsonManagedReference
    private List<Property> properties;

    @ManyToMany
    private List<Property> favouriteProperties;

    public static enum UserType {
        ADMIN,
        OWNER,
        CUSTOMER
    }
}
