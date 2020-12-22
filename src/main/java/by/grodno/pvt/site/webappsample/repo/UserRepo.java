package by.grodno.pvt.site.webappsample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import by.grodno.pvt.site.webappsample.domain.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findByEmail(String email);

	@Modifying
	@Query("UPDATE User SET firstName=:uname WHERE id=:id")
	void updateUserName(@Param("uname") String username, @Param("id") Integer userId);

}
