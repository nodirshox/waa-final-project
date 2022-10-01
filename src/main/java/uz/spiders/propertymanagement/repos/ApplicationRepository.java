package uz.spiders.propertymanagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.spiders.propertymanagement.entities.Application;
import uz.spiders.propertymanagement.entities.User;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
