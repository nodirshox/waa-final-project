package uz.spiders.propertymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.spiders.propertymanagement.entities.Picture;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PictureDTO {
    private Long id;

    private String awsUrl;

    private Picture.PictureType type;
}
