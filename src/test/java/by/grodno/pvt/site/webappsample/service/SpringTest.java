package by.grodno.pvt.site.webappsample.service;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

import org.junit.Test;

import by.grodno.pvt.site.webappsample.domain.OldUser;
import io.micrometer.core.annotation.Counted;

public class SpringTest {

	@Test
	public void test() {

		OldUser u = new OldUser(1, "fn", "ln", new Date(), true);

		
		//"select * from old_user_table where isMale = ?"
		
		Class<OldUser> class1 = OldUser.class;
		
		
		
	}

}
