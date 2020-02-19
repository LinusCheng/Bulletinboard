package bulletinboard.bulletinboard_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BulletinboardBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BulletinboardBeApplication.class, args);
		System.out.println("==== Ready ====");
	}

	//can be autowired
	@Bean
//	@Scope()
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
