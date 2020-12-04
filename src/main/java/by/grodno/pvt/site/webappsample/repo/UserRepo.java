package by.grodno.pvt.site.webappsample.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import by.grodno.pvt.site.webappsample.domain.OldUser;

public interface UserRepo extends JpaRepository<OldUser, Integer> {

	List<OldUser> findByFirstName(String firstName);

}
