
package com.tungduong.springdemo.repository;
import java.util.Optional;
import com.tungduong.springdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByName(String name);

	Optional<User> findByEmail(String email);

	Optional<User> findByNameAndEmail(String name, String email);

	boolean existsByEmail(String email);
}
