package by.grodno.pvt.site.webappsample.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import by.grodno.pvt.site.webappsample.domain.OldUser;
import by.grodno.pvt.site.webappsample.dto.UserDTO;

@Component
public class UserDomainToDTOConverter implements Converter<OldUser, UserDTO> {

	@Override
	public UserDTO convert(OldUser source) {
		UserDTO userDto = new UserDTO();
		userDto.setId(source.getId());
		userDto.setFirstName(source.getFirstName());
		userDto.setLastName(source.getLastName());
		userDto.setMale(source.getMale());
		return userDto;
	}

}
