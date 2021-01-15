package by.grodno.pvt.site.webappsample.dto;

import java.util.List;

import by.grodno.pvt.site.webappsample.domain.User;
import lombok.Data;

@Data
public class CartOfUsers {

	private List<User> usersToSell;
	
}
