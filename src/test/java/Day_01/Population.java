package Day_01;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Population {
   static WebDriver driver;

    public static void main(String[] args) {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get( "https://www.worldometers.info/world-population/" );
        LocalDateTime then = LocalDateTime.now();
        List<WebElement> list = new ArrayList<>();
        list.add(driver.findElement( By.cssSelector( "span[rel='current_population']" ) ));
        list.add(driver.findElement( By.cssSelector( "span[rel='births_today']" )) );
        list.add(driver.findElement( By.cssSelector( "span[rel='births_this_year']" )) );
        list.add(driver.findElement( By.cssSelector( "span[rel='dth1s_today']" ) ));
        list.add(driver.findElement( By.cssSelector( "span[rel='dth1s_this_year']" )) );
        list.add(driver.findElement( By.cssSelector( "span[rel='absolute_growth']" )) );
        list.add(driver.findElement( By.cssSelector( "span[rel='absolute_growth_year']" )) );

        do {
            Methods.printThePopulation( list );
            System.out.println("-------------------------------------");
            Methods.waiting( 500 );
        } while (ChronoUnit.SECONDS.between( then, LocalDateTime.now() ) < 5);
    }
}
