package com.Ravitech.OTPGenerat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController
{


	@RequestMapping(value="/Arg",method=RequestMethod.GET)
	public String Demovalue()
	{
		return "Demo";
		
	}
	
	
}
