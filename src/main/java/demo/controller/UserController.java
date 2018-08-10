package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.dao.User;
import demo.service.UserService;


@Controller
public class UserController {
    @Autowired
    UserService service;
    
    @RequestMapping(path="/index")
    public String index() {
        return "index";
    }

    @ResponseBody
    @RequestMapping(path="/query")
    public String query() {
        System.out.println("========query");
    	List<User> list = service.query();
    	String str = "";
    	for(User user:list) {
    		str = str+user.getId().toString()+","+user.getUserName()+","+user.getPassword()+"</br>";
    	}
        return str;
    }
    
    @ResponseBody
    @RequestMapping(path="/selectUsers")
    public String selectUsers() {
    	System.out.println("========selectUsers");
    	List<User> list = service.selectUsers();
    	String str = "";
    	for(User user:list) {
    		str = str+user.getId().toString()+","+user.getUserName()+","+user.getPassword()+"</br>";
    	}
        return str;
    }
    
    @ResponseBody
    @RequestMapping(path="/selectUsersMapper")
    public String selectUsersMapper() {
    	System.out.println("========selectUsersMapper");
    	List<User> list = service.selectUsersMapper();
    	String str = "";
    	for(User user:list) {
    		str = str+user.getId().toString()+","+user.getUserName()+","+user.getPassword()+"</br>";
    	}
        return str;
    }
    
}