package uz.spiders.propertymanagement.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 2)
    private String state;

    private String city;

    private String street;

    private String zip;
}
