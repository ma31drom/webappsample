package by.grodno.pvt.site.webappsample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import by.grodno.pvt.site.webappsample.config.ContextConfig;
import by.grodno.pvt.site.webappsample.service.ReportingService;

public class Starter {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(ContextConfig.class);

		ReportingService bean1 = container.getBean(ReportingService.class);

		System.out.println(bean1.getAllUsersCount());

		container.close();
	}
}
