package com.niit.frontend.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.laptopsbackend.dao.IProductDAO;
import com.niit.laptopsbackend.dao.IUserDAO;
import com.niit.laptopsbackend.model.Product;
import com.niit.laptopsbackend.model.User;

@Controller
public class HomeController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	IUserDAO userDAO;
	
	@Autowired
	User user;
	
	@Autowired
	IProductDAO productDAO;
	
	@ModelAttribute
	public User returnObj()
	{
		return new User();
	}
	
		@RequestMapping("/")
	public ModelAndView showHome()
	{
		 ModelAndView mv=new ModelAndView("mainpage");
		 
		return mv; 
	}
	@RequestMapping("/Login")
	public ModelAndView showLogin()
	{
		 ModelAndView mv=new ModelAndView("Login");
		 
		return mv; 
	}
	@RequestMapping("/ViewProducts")
	public ModelAndView showProducts()
	{
		 ModelAndView mv=new ModelAndView("ViewProducts");
		  
		return mv; 
	}
	
	@RequestMapping("/{id}/ViewProfile")
	public String showProfile(@PathVariable Integer id,ModelMap model)
	{
		model.addAttribute("user",userDAO.getbyid(id));
		 
		return "ViewProfile" ;
	}
	
	
	@RequestMapping("/Register")
	public ModelAndView showRegister()
	{
		 ModelAndView mv=new ModelAndView("Register");
		 
		 
		return mv; 
	}
	@RequestMapping("/Index")
	public ModelAndView showIndex()
	{
		 ModelAndView mv=new ModelAndView("Index");
		 
		return mv; 
	}
	@RequestMapping("/mainpage")
	public ModelAndView showMainpage()
	{
		 ModelAndView mv=new ModelAndView("mainpage");
		 
		return mv; 
	}
	@RequestMapping("/Contactus")
	public ModelAndView showContactus()
	{
		 ModelAndView mv=new ModelAndView("Contactus");
		 
		return mv; 
	}
	
	
	@RequestMapping("/Welcome")
	public ModelAndView showWelcome()
	{
		 ModelAndView mv=new ModelAndView("Welcome");
		 
		return mv; 
	}
	@RequestMapping("/chkLogin")
	public ModelAndView chkLogin(@RequestParam("txtemail")String mail,@RequestParam("txtpass")String pass)
	{
		 ModelAndView mv;
		 if(mail.equals("user@gmail.com")&&pass.equals("user1"))
				 {
			      mv=new ModelAndView("Welcome");
			      mv.addObject("loggedInUser","user");
			      return mv;
				 }
		 else if(mail.equals("admin@gmail.com")&&pass.equals("admin"))
		 {
			 mv=new ModelAndView("AdminHome");
			 mv.addObject("loggedInUser","admin");
			 return mv;
				 }
		 else
		 {
			 mv=new ModelAndView("Login");
			 return mv;
		 }
	}
	@RequestMapping("/Signout")
	public ModelAndView showLogout()
	{
		ModelAndView mv=new ModelAndView("mainpage");
		return mv;
	}
	@RequestMapping("/perform_logout")
	public ModelAndView showLogout(HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		System.out.println("logout");
		ModelAndView mv=new ModelAndView("mainpage");
		session.invalidate();
		session=request.getSession(true);
		mv.addObject("logOutMessage", "u have successfully loggedout");
		mv.addObject("loggedOut", "true");
		
		return mv;
		
		
		
	}
	
	
	@RequestMapping(value="/login_session_attributes")
	public String login_session_attributes(HttpSession session, Model model,@RequestParam(value="username")String id) {
		String name=SecurityContextHolder.getContext().getAuthentication().getName();
		
		System.out.println("inside security check");
		session.setAttribute("name", name);
		System.out.println(name);
		user=userDAO.get(id);
		int x=user.getUserid();
		System.out.println(user.getUserid());
		session.setAttribute("email", user.getEmailid());
		session.setAttribute("loggedInUser", user.getUsername());
		session.setAttribute("loggedInUserID",x);
		session.setAttribute("LoggedIn","true");
		
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities=(Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		
		String role="ROLE_USER";
		for(GrantedAuthority authority : authorities) {
			if(authority.getAuthority().equals(role)) {
				System.out.println(role);
/*				model.addAttribute("userList",userDAO.get(id));
*/				
				return "LoginDisplay";
			}else {
				session.setAttribute("isAdmin", "true");
			}
		}
		return "AdminHome";
	}
	
	@RequestMapping(value="/addus",method=RequestMethod.POST)
	public String addUSer(@Valid @ModelAttribute("user")User user,BindingResult result, HttpServletRequest request,HttpSession session,Model model)throws IOException {
		System.out.println(user.getCpassword());
		System.out.println(user.getPassword());
		
		if(result.hasErrors()) {
			return "Register";
		}
		else {
			
		
		user.setEnabled("true");
		user.setRole("ROLE_USER");
		
		if(user.getCpassword().equals(user.getPassword())) {
			userDAO.addUser(user);
		
		session=request.getSession(false);
		session.setAttribute("email",user.getEmailid());
		session.setAttribute("loggedInUser",user.getUsername());
		String email1=(String)session.getAttribute("email");
		String username=(String)session.getAttribute("loggedInUser");
		//String email1="saikiranreddy04@gmail.com";
		 String recipientAddress=email1;
		 String subject="User Registration";
		 String message="User Registered Sucesfully";
		 
		 //create a simple email obj
		 SimpleMailMessage email=new SimpleMailMessage();
		 email.setTo(recipientAddress);
		 email.setSubject(subject);
		 email.setText(message);
		 //sends the e-mail
		 mailSender.send(email);
		 
		 MultipartFile image=user.getImg();
			Path path;
			path=Paths.get("C:/Users/Asaikiran/gitmain/laptopsfrontend/src/main/webapp/pics/" +user.getUsername() + ".jpg");
			System.out.println("Path=" + path);
			System.out.println("File name=" + user.getImg().getOriginalFilename());
			if(image !=null&& !image.isEmpty()) {
				try {
					image.transferTo(new File(path.toString()));
					System.out.println("Image saved in: " +path.toString());
					
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("Image not saved");
				}
			}
		return "Login";
	}
		else {
			model.addAttribute("errMsg", "Both the passwords are not matching");
			return "Register";
		}
		}
		
	}
}


