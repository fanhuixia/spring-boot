package cn.itlaobing.springboot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.jms.JndiConnectionFactoryAutoConfiguration.class,
		org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration.class })
public class SpringbootDemoApplication {

	private static Log log = LogFactory.getLog(SpringbootDemoApplication.class);
	

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringbootDemoApplication.class, args);
		log.info("Spring applicationContext className:" + ctx.getClass().getName());

	}

	
}
