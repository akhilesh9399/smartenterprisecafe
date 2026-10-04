package corporate.Scafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScafeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScafeApplication.class, args);
		System.out.println("Application start");
		System.out.println("git is enabled in IntelliJ id");
        try {
            Thread.sleep(89000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Git Hub work properly developer add all these functionality!");



    }
    public void employee(){
        System.out.println("Bring Employee files");
    }

}
