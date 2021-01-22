package by.grodno.pvt.site.webappsample.scheduling;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import by.grodno.pvt.site.webappsample.domain.Car;
import by.grodno.pvt.site.webappsample.service.impl.CarRentService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserExpirationHandler {

	@Autowired
	private CarRentService service;

	@Scheduled(fixedRate = 10 * 1000)
	public void invalidateUsers() {

		List<Car> busy = service.busyExpiredCars();
		busy.forEach(c -> c.setFree(true));
		service.save(busy);
		log.info("Cars released: " + busy.stream().map(Car::getName).collect(Collectors.joining(", ")));
	}

}
