package uz.spiders.propertymanagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.spiders.propertymanagement.entities.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
