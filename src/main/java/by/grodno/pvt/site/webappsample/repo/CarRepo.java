package by.grodno.pvt.site.webappsample.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import by.grodno.pvt.site.webappsample.domain.Car;

public interface CarRepo extends JpaRepository<Car, Integer> {

	List<Car> findByFree(Boolean free);
	
}
