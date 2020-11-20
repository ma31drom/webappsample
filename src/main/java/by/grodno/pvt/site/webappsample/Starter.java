package by.grodno.pvt.site.webappsample;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.grodno.pvt.site.webappsample.service.ReportingService;

public class Starter {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("context.xml");

		//UserRepository bean = container.getBean(UserRepository.class);

		//System.out.println(bean.getUsers());

		ReportingService bean1 = container.getBean(ReportingService.class);

		System.out.println(bean1.getAllUsersCount());
		
		container.close();
	}
}
