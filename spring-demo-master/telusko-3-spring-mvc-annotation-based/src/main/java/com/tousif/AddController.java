package com.tousif;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.service.AddService;

@Controller
public class AddController {
	
	@RequestMapping("/add")
	
	public ModelAndView adding( @RequestParam("t1") int i, @RequestParam("t2") int j ) {
		
		System.out.println("I'm in Controller");

		
		AddService as = new AddService();
		int k = as.add(i, j);
		
		ModelAndView modelAndView = new ModelAndView();
		
//		modelAndView.setViewName("display.jsp"); //8.
		
		modelAndView.setViewName("display"); //9. We shouldn't give extension such as .jsp because what if we switch to any other technology from jsp
//		10.Go to tousifServletServletXMLAlternative
		modelAndView.addObject("result",k);
		
		return modelAndView;
	}

}
 
