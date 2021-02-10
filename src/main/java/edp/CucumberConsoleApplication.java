package edp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edp.core.runner.CustomRunner;

@SpringBootApplication
public class CucumberConsoleApplication implements CommandLineRunner {

    private static final String[] COMMON_CUCUMBER_OPTIONS = new String[]{
        "-p", "timeline:build/cucumber-parallel-report",
        "-p", "html:build/cucumber-report/smoketest",
        "-p", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
        "-g", "edp.stepdefs", "-g", "edp.types",
        "-g", "epd.cucumber"
    };

    public static void main(String[] args) {
        System.setProperty("allure.results.directory", "allure-results/" + System.getProperty("spring.profiles.active"));
        SpringApplication.run(CucumberConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        CustomRunner.main(generateCucumberOptions(args));
    }

    private String[] generateCucumberOptions(String... args) {
        List<String> listOfCommonOptions = Stream
            .of(COMMON_CUCUMBER_OPTIONS)
            .collect(Collectors.toList());
        listOfCommonOptions.addAll(Arrays.asList(args));
        String[] cucumberOptions = new String[listOfCommonOptions.size()];
        for (int i = 0; i < cucumberOptions.length; i++) {
            cucumberOptions[i] = listOfCommonOptions.get(i);
        }
        return cucumberOptions;
    }
}
