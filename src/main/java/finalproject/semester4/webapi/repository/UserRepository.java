package finalproject.semester4.webapi.repository;

import finalproject.semester4.webapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by gerli on 16/05/2018.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
    User findById(int id);
}
