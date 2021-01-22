package by.grodno.pvt.site.webappsample.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import by.grodno.pvt.site.webappsample.domain.CarRent;

public interface CarRentRepo extends JpaRepository<CarRent, Integer> {

	List<CarRent> findByRentEndTimeBefore(Date date);

	List<CarRent> findByRentEndTimeBeforeAndFree(Date date, boolean b);

}
