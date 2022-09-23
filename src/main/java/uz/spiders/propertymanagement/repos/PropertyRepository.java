package uz.spiders.propertymanagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.spiders.propertymanagement.entities.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
}
