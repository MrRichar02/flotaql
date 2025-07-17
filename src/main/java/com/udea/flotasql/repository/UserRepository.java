package  com.udea.flotasql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udea.flotasql.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
