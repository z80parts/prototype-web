package web.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import web.model.User;

@ExtendWith(MockitoExtension.class)
public class MockitoDemoApplicationTests {

	@Mock
	private ProductService productService;

	@InjectMocks
	OrderService orderService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {

		Mockito.when(productService.getProductName())
				.thenReturn("Mock Product Name");
		String testName = orderService.getProductName();
		assertEquals("Mock Product Name", testName);
	}

	@Test
	public void testRestTemplate() {

		RestTemplate restTemplate = new RestTemplate();
		final String url = "https://api.e-stat.go.jp/rest/3.0/app/json/getStatsList?appId=e62bc4b6e9ddd4742de927ec92be2557f06c5674&lang=J&openYears=2019&statsField=0201";

		String jsonString = restTemplate.getForObject(url, String.class);
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode jNode = mapper.readTree(jsonString);
			JsonNode jn = jNode.get("GET_STATS_LIST").get("DATALIST_INF");
			System.out.println(jNode);
			System.out.println(jn);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		ResponseEntity<Stats> response = restTemplate.exchange(url,
//				HttpMethod.GET, null, Stats.class);
//		System.out.println("Result:" + response.getBody());

	}

	@Test
	public void test() {

		RestTemplate restTemplate = new RestTemplate();
		MockRestServiceServer mockServer = MockRestServiceServer
				.createServer(restTemplate);

		String url = "https://server.to/api/user/12345";
		mockServer.expect(requestTo(url)).andRespond(withSuccess(
				"{\"id\":\"12345\", \"name\":\"山田　太郎\", \"age\":26}",
				MediaType.APPLICATION_JSON));

		User user = restTemplate.getForObject(url, User.class);
		System.out.println(user.getName());
		System.out.println(user.getAge());

	}

}