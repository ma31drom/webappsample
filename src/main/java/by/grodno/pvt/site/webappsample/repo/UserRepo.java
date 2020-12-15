package by.grodno.pvt.site.webappsample.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import by.grodno.pvt.site.webappsample.domain.OldUser;

public interface UserRepo extends JpaRepository<OldUser, Integer> {

	List<OldUser> findByFirstName(String firstName);

	Optional<OldUser> findByUsername(String userName);

}
