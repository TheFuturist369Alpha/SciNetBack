package com.sci_books.project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import static com.jalvis.SciNet.utils.Test.add_nums;

@SpringBootTest
class SciNetApplicationTests {

	@Test
	void contextLoads() {
		int expected=7;
		int actual=add_nums(4,3);
		Assertions.assertEquals(expected, actual);
	}

}
