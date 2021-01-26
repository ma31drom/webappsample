package by.grodno.pvt.site.webappsample.dto;

import java.util.List;

import by.grodno.pvt.site.webappsample.domain.Car;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CarsListDTO {

	List<Car> cars;
}
