package by.grodno.pvt.site.webappsample.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import by.grodno.pvt.site.webappsample.domain.Car;
import by.grodno.pvt.site.webappsample.domain.CarRent;
import by.grodno.pvt.site.webappsample.domain.User;
import by.grodno.pvt.site.webappsample.repo.CarRentRepo;
import by.grodno.pvt.site.webappsample.repo.CarRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarRentService implements InitializingBean {

	
	private final CarRentRepo carRentRepo;
	private final CarRepo carRepo;

	public List<Car> availableCars() {
		return carRepo.findByFree(true);
	};

	public List<Car> busyExpiredCars() {
		
		List<CarRent> findByRentEndTimeBefore = carRentRepo.findByRentEndTimeBefore(new Date());
		return findByRentEndTimeBefore.stream().map(CarRent::getCar).collect(Collectors.toList());
	};

	public void rentCar(User user, Integer car, Date start, Date end) {

		Car findById = carRepo.findById(car).get();

		CarRent carRent = new CarRent();

		carRent.setUser(user);
		carRent.setRentStartTime(start);
		carRent.setRentEndTime(end);
		carRent.setCar(findById);

		carRentRepo.save(carRent);
		findById.setFree(false);
		carRepo.save(findById);

	}

	public void save(List<Car> busy) {
		carRepo.saveAll(busy);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		carRepo.save(new Car(null, "ВАЗ", true, null));
		carRepo.save(new Car(null, "Москвич", true, null));
		carRepo.save(new Car(null, "ЗАЗ", true, null));
	}

}
