/**
 * 
 */
package world.we.deserve.controller;

import static org.junit.Assert.fail;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import world.we.deserve.Application;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.*;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

/**
 * @author Miguel Ángel Dev (miguelangelprogramacion@gmail.com)
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class SecureControllerTest {
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

	
    private MockMvc mockMvc;
    
    @Autowired
    private WebApplicationContext webApplicationContext;

    
	@Before
	public void setUp() throws Exception {
		this.mockMvc =MockMvcBuilders.<StandaloneMockMvcBuilder>webAppContextSetup(webApplicationContext).apply(springSecurity()).build();
	}

	@Test
	public void testAuthorized() throws Exception {
		mockMvc.perform(get("/secure").with(httpBasic("user","password"))).andExpect(status().isOk());
	}
	
	@Test
	public void testUnauthorized() throws Exception {
		mockMvc.perform(get("/secure").with(httpBasic("user","passwoasasrd"))).andExpect(status().isUnauthorized());
	}

}
