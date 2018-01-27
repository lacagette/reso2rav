package hello.service;

import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest("service.message=Hello")
public class MyServiceTest {

	// @Autowired
	// private MyService myService;
	//
	// @Test
	// public void contextLoads() {
	// assertThat(myService.message()).isNotNull();
	// }

	@SpringBootApplication
	static class TestConfiguration {
	}

}
