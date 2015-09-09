/**
 * 
 */
package world.we.deserve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * @author Miguel Ángel Dev (miguelangelprogramacion@gmail.com)
 *
 */

// @SpringBootApplication// same as @Configuration @EnableAutoConfiguration
// @ComponentScan
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableWebMvcSecurity
@EnableWebMvc
public class Application extends WebSecurityConfigurerAdapter  {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**/secure").
        authenticated().anyRequest().permitAll().
        and().httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");

    }
}
