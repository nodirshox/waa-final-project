package uz.spiders.propertymanagement.entities;


import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.time.LocalDateTime;

@Data
@Entity
public class Application {

    @EmbeddedId
    private UserPropertyCompositeId id;

    private LocalDateTime submittedAt;

    private LocalDateTime deletedAt = null;

    @ManyToOne
    @MapsId("propertyId")
    private Property property;

    @ManyToOne
    @MapsId("userId")
    private User user;

}
