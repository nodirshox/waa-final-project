package uz.spiders.propertymanagement.entities;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Data
@Embeddable
public class UserPropertyCompositeId implements Serializable {

    private Long propertyId;

    private Long userId;
}
