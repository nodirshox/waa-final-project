package uz.spiders.propertymanagement.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class UserPropertyCompositeId implements Serializable {

    @Column(name = "property_id")
    private Long propertyId;

    @Column(name = "user_id")
    private Long userId;
}
