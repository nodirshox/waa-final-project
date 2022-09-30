package uz.spiders.propertymanagement.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.spiders.propertymanagement.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findTop10ByTypeOrderByCreatedAtDesc(User.UserType type);

    List<User> findAllByEmail(String email);
}
