package com.emc.shoppingcartfinal;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.emc.shoppingcartfinal.dao.ProductDao;
import com.emc.shoppingcartfinal.dao.UserDao;
import com.emc.shoppingcartfinal.dao.UserDaoImpl;
import com.emc.shoppingcartfinal.model.Product;
import com.emc.shoppingcartfinal.model.User;
import com.emc.shoppingcartfinal.services.CreateServicesImpl;
import com.emc.shoppingcartfinal.services.LoginServices;
import com.emc.shoppingcartfinal.services.LoginServicesIMPL;

@Controller
@RequestMapping(value = "/")
public class ShoppingCartController {

	@Autowired
	LoginServices loginuser;
	@Autowired
	UserDaoImpl ui;
	@Autowired
	LoginServicesIMPL oi;
	@Autowired
	CreateServicesImpl serv;

	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(Model model) {
		User userLoginDetails = new User();
		model.addAttribute("userLogin", userLoginDetails);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute(value = "userLogin") User user, Model model) {

		User user1;
		// user1=loginuser.Login(user.getEmailId(), user.getPassword());*/
		// user1=ui.getUserByEmailId("admin1");
		// User user2=new User("anshul", "kalra", "anshul@gmail.com",
		// "bangalore", "", "bangalore", "karnataka", "India", 8123, "admin",2);

		Map<String, Object> mapuser = new HashMap();
		mapuser = oi.Login(user.getEmailId(), user.getPassword());
		user1 = (User) mapuser.get("User");
		if (user1 != null) {
			System.out.println(user1.getFname());

		} else {
			Exception e;
			e = (Exception) mapuser.get("ErrorMessage");
			System.out.println(e.getMessage());
		}

		return "login";
	}

	@RequestMapping(value = "/registration1", method = RequestMethod.POST)
	public String Registration(@ModelAttribute(value = "registerUser") User user, Model model) {

		// System.out.println(user.getFname());
		return "registration";

	}

	@RequestMapping(value = "/registration2", method = RequestMethod.POST)
	public String RegistrationUser(@Valid @ModelAttribute(value = "registerUser") User user, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "registration";
		}
		user.setRoleID(2);
		serv.UserRegistration(user);
		return "registration";

	}

}
