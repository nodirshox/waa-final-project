package uz.spiders.propertymanagement.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Application {

    public Application(Property property, User user) {
        this.id = new UserPropertyCompositeId();
        this.submittedAt = LocalDateTime.now();
        this.property = property;
        this.user = user;
    }

    @EmbeddedId
    private UserPropertyCompositeId id;

    @CreationTimestamp
    private LocalDateTime submittedAt;

    private LocalDateTime deletedAt = null;

    @ManyToOne
    @MapsId("propertyId")
    private Property property;

    @ManyToOne
    @MapsId("userId")
    private User user;

}
