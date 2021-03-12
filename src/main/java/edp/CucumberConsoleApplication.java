package edp;

import edp.consts.Cucumber;
import edp.core.runner.CustomRunner;
import lombok.extern.log4j.Log4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j
@SpringBootApplication
public class CucumberConsoleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        System.setProperty("allure.results.directory", "allure-results/" + System.getProperty("namespace"));
        SpringApplication.run(CucumberConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        CustomRunner.main(Cucumber.COMMON_CUCUMBER_OPTIONS);
    }

}
