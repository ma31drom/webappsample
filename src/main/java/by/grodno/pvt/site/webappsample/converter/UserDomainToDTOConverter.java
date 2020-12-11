package by.grodno.pvt.site.webappsample.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import by.grodno.pvt.site.webappsample.domain.OldUser;
import by.grodno.pvt.site.webappsample.dto.UserDTO;

@Component
public class UserDomainToDTOConverter implements Converter<OldUser, UserDTO> {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	@Override
	public UserDTO convert(OldUser source) {
		
		MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		MAPPER.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL);
		return MAPPER.convertValue(source, UserDTO.class);
	}

}
