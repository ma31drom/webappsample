package by.grodno.pvt.site.webappsample.dto;

import java.util.List;

import by.grodno.pvt.site.webappsample.domain.Car;
import by.grodno.pvt.site.webappsample.domain.UserRole;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DropDownDTO {

	UserRole first;
	UserRole second;

}
