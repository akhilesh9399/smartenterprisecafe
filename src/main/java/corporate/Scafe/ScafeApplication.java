package corporate.Scafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScafeApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ScafeApplication.class, args);
		System.out.println("Application start");
		System.out.println("git is enabled in IntelliJ id");
	    System.out.println("now i connected new feature ");
       Thread.sleep(2000);

    }

}
