package uz.spiders.propertymanagement.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
public class Property {

    @Id
    @GeneratedValue
    private Long id;

    private double price;

    private int numberOfRooms;

    @Enumerated
    private ListingType listingType;

    @Enumerated
    private PropertyType type;

    @Enumerated
    private PropertyStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt = null;

    private LocalDateTime deletedAt = null;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Address address;

    @OneToMany(mappedBy = "property")
    private List<Picture> pictures;

    @ManyToOne
    private User owner;

    public static enum PropertyType{
        HOUSE,
        CONDO,
        APARTMENT
    }

    public static enum PropertyStatus{
        OPEN,
        HIDDEN,
        RENTED,
        DELETED
    }

    public static enum ListingType{
        RENT,
        SALE
    }
}
