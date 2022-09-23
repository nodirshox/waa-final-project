package uz.spiders.propertymanagement.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class PropertyView {

    @EmbeddedId
    private UserPropertyCompositeId id;

    private LocalDateTime viewedAt;

    @ManyToOne
    @MapsId("propertyId")
    private Property property;

    @ManyToOne
    @MapsId("userId")
    private User user;

}
