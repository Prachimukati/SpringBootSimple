package com.rays.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponse;
import com.rays.dto.UserDTO;
import com.rays.form.LoginForm;
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserService;

@RestController
@RequestMapping(value = "Auth")
public class LoginCtl {

	@Autowired
	public UserService service;

	@PostMapping("signUp")
	public ORSResponse signUp(@RequestBody UserRegistrationForm form) {

		ORSResponse res = new ORSResponse();

		UserDTO dto = new UserDTO();
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLoginId(form.getLoginId());
		dto.setPassword(form.getPassword());
		dto.setDob(form.getDob());

		Long pk = service.add(dto);

		res.addData(pk);
		res.addMessage("User  Register successfully ...");

		return res;

	}
	
	@PostMapping("login")
	public  ORSResponse login(@RequestBody LoginForm form ) {
		
		ORSResponse res = new ORSResponse() ;
		
		UserDTO dto = service.authenticate(form.getLoginId(), form.getPassword());
		
		if (dto != null ) {
			res.addData(dto);
		} else {
            res.addMessage("Login & password invalide ");
		}
		return res;
		
	}
}