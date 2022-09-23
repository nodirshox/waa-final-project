package uz.spiders.propertymanagement.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Picture {

    @Id
    @GeneratedValue
    private Long id;

    private String awsUrl;

    private PictureType type;

    @ManyToOne
    private Property property;

    public static enum PictureType{
        NORMAL,
        MAIN
    }
}
