package uz.spiders.propertymanagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import uz.spiders.propertymanagement.dto.AddressDTO;
import uz.spiders.propertymanagement.entities.Property;
import uz.spiders.propertymanagement.entities.Property.ListingType;
import uz.spiders.propertymanagement.entities.Property.PropertyType;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>, QuerydslPredicateExecutor {
    List<Property> findTop10ByStatusOrderByCreatedAtDesc(Property.PropertyStatus property);

}
