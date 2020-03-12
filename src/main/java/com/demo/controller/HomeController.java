/**
 * 
 */
package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Mehul
**/

@Controller
public class HomeController {

	@GetMapping("/")
	public String getHome() {
		return "index";
	}
}
