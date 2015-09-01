/**
 * 
 */
package world.we.deserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * @author Miguel Ángel Dev (miguelangelprogramacion@gmail.com)
 *
 */

//@SpringBootApplication// same as @Configuration @EnableAutoConfiguration @ComponentScan
@Configuration @EnableAutoConfiguration @ComponentScan
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
