package uz.spiders.propertymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.spiders.propertymanagement.entities.User;
import uz.spiders.propertymanagement.entities.UserPropertyCompositeId;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDTO {

    private UserPropertyCompositeId id;

    private LocalDateTime submittedAt;

    private LocalDateTime deletedAt = null;

    private User user;

}
