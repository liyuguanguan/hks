package com.moji.hks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HksApplicationTests {

	public static void main(String[] args) {

		System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));;

	}
	@Test
	public void contextLoads() {
	}

}
