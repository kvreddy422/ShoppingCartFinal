package com.emc.shoppingcartfinal.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emc.shoppingcartfinal.dao.UserDao;
import com.emc.shoppingcartfinal.dao.UserDaoImpl;
import com.emc.shoppingcartfinal.model.User;

@Component
public class LoginServicesIMPL implements LoginServices  {

	@Autowired
	UserDao CorrectUser;
	@Override
	public Map<String,Object> Login(String Username, String Password) {
		// TODO Auto-generated method stub
		User user;
		Map<String,Object> mapA = new HashMap();

		//UserDao CorrectUser=new UserDaoImpl();
		try{
			user=CorrectUser.getUserByEmailId(Username);
			System.out.println(user.getFname());
			if(user.getPassword().equals(Password))
			{
				//System.out.println("hi");
				mapA.put("User", user);
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			mapA.put("ErrorMessage", e);
		}
		return mapA;
		
	}

	@Override
	public List<User> GetAllUser() {
		// TODO Auto-generated method stub
		UserDao AllUser=new UserDaoImpl();
		List<User> userlist=AllUser.getAllUser();
		return userlist;
	}
	
	
	
	
	
	

}
