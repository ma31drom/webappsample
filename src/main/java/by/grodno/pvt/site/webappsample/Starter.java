package by.grodno.pvt.site.webappsample;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.grodno.pvt.site.webappsample.service.UserRepository;

public class Starter {

	public static void main(String[] args) {
		ApplicationContext container = new ClassPathXmlApplicationContext("context.xml");

		UserRepository bean = container.getBean(UserRepository.class);

		System.out.println(bean.getUsers());
	}
}
