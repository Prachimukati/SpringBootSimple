package com.rays.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.DemoResponse;
import com.rays.common.ORSResponse;
import com.rays.dto.Person;

@RestController
@RequestMapping(value = "Demo")
public class DemoCtl {

	@GetMapping("display")
	public String display() {
		return "Spring Boot Application";
	}

	@GetMapping("display1")
	public Person display1() {

		Person person = new Person();

		person.setFirstName("Prachi");
		person.setLastName("Mukati");
		person.setLoginId("prachi@gmail.com");
		person.setPassword("123");
		return person;

	}

	@GetMapping("display2")
	public DemoResponse display2() {

		DemoResponse res = new DemoResponse();

		Person dto1 = new Person();

		dto1.setFirstName("Prachi");
		dto1.setLastName("Mukati");
		dto1.setLoginId("prachi@gmail.com");
		dto1.setPassword("123");

		Person dto2 = new Person();

		dto2.setFirstName("Chanda");
		dto2.setLastName("Mukati");
		dto2.setLoginId("chanda@gmail.com");
		dto2.setPassword("321");

		
		Map map = new HashMap() ;
		map.put("dto1", dto1);
		map.put("dto2", dto2);

		res.setResult(map);
		res.setData("Peson object");
		res.setMessage("data added successfully");
		
		return res;

	}
	
	@GetMapping("display3")
	public ORSResponse display3() {

		ORSResponse res = new ORSResponse();

		Map errors = new HashMap();
		
		errors.put("firstName", "first name is required");
		errors.put("lastName", "last name is required");
		errors.put("loginId", "login id is required");
		errors.put("password", "password is required");

		res.addInputError(errors);
		
		Person dto = new Person();
		
		dto.setFirstName("Prachi");
		dto.setLastName("Mukati");
		dto.setLoginId("Prachi@gmail.com");
		dto.setPassword("1234");
		
		Person dto1 = new Person();
		
		dto1.setFirstName("Sonali");
		dto1.setLastName("Patel");
		dto1.setLoginId("sonali@gmail.com");
		dto1.setPassword("321");
		
		Person dto2 = new Person();
		dto2.setFirstName("Siya");
		dto2.setLastName("Muakti");
		dto2.setLoginId("siya@gmail.com");
		dto2.setPassword("124");
		
		List list = new ArrayList();
		
		list.add(dto);
		list.add(dto1);
		list.add(dto2);
		
		res.addData(list);
		res.addMessage("loginId and password is invalide");
		res.addResult("token", "highcfc1tr4564465ghcgf");
		res.setSuccess(true);
		
		return res;

	}

	@PostMapping("submit")
	public ORSResponse submit(@RequestBody Person person) {
		
		ORSResponse res = new ORSResponse();
		res.addData(person);
		
		return res;
		
	}
}
