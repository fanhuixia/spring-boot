package cn.itlaobing.springboot;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
//省略import
@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testHello() throws Exception {
		String url="/hello";
		String viewName="hello";
		String attributeName="msg";
		String attributeValue="Hello spring boot!";
		
		RequestBuilder request=get(url).accept(MediaType.TEXT_HTML);
		ResultActions resultAction= mvc.perform(request);
		resultAction
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name(is(viewName)))
		.andExpect(model().attributeExists(attributeName))
		.andExpect(model().attribute(attributeName,attributeValue));
		
		
		
	}
}
