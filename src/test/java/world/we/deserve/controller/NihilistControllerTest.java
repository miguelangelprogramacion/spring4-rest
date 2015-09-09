/**
 * 
 */
package world.we.deserve.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

import junit.framework.Assert;
import world.we.deserve.Application;
import world.we.deserve.dto.Nihilist;

/**
 * @author Miguel Ángel Dev (miguelangelprogramacion@gmail.com)
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class NihilistControllerTest {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;
    
    private HttpMessageConverter mappingJackson2HttpMessageConverter;
    
    @Autowired
    private WebApplicationContext webApplicationContext;

    
	@Before
	public void setUp() throws Exception {
		this.mockMvc =MockMvcBuilders.<StandaloneMockMvcBuilder>webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testgetSimpleNihilist() throws Exception {
		 mockMvc.perform(get("/nihilist")).andExpect(status().isOk());
	}

	@Test
	public void testNihilistByIdOK() throws Exception {
		 mockMvc.perform(get("/nihilist/1")).andExpect(status().isOk());
	}
	
	@Test
	public void testNihilistByIdNotFound() throws Exception {
		 mockMvc.perform(get("/nihilist/2")).andExpect(status().isNotFound());
	}
	
	@Test
	public void testPostNihilist() throws IOException, Exception
	{
		Nihilist nihilist = new Nihilist();
		mockMvc.perform(post("/nihilist")
				 .content(this.json(nihilist))
	                .contentType(contentType))
	                .andExpect(status().isCreated());
	}
	
	protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
	
	 @Autowired
	    void setConverters(HttpMessageConverter<?>[] converters) {

	        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream().filter(
	                hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();

	        Assert.assertNotNull("the JSON message converter must not be null",
	                this.mappingJackson2HttpMessageConverter);
	    }

}
