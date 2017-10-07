package com.niit.frontend.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	@RequestMapping("/{id}/ViewDetails")
	public String showDetails(@PathVariable Integer id,ModelMap model)
	{
		model.addAttribute("product",productDAO.get(id));
		 
		return "ViewDetails" ;
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
	/*@RequestMapping("/Cart")
	public ModelAndView showCart()
	{
		 ModelAndView mv=new ModelAndView("Cart");
		 
		return mv; 
	}
	@RequestMapping("/AddtoCart")
	public ModelAndView showAddtoCart()
	{
		 ModelAndView mv=new ModelAndView("AddtoCart");
		 
		return mv; 
	}*/
	
	/*@RequestMapping("/AddProduct")
	public ModelAndView showProduct(Model model) {
		
		ModelAndView m=new ModelAndView("AddProduct");
		model.addAttribute("categoryList", categoryDAO.getCategories());
		model.addAttribute("supplierList", supplierDAO.getSuppliers());
		model.addAttribute("productList", productDAO.list());
		
	
		return m;
		
		
	}*/
	
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
	public ModelAndView showLogout(HttpServletRequest request,HttpSession session) {
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
		session.setAttribute("email", user.getEmailid());
		session.setAttribute("loggedInUser", user.getUsername());
		
		session.setAttribute("LoggedIn","true");
		
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities=(Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		
		String role="ROLE_USER";
		for(GrantedAuthority authority : authorities) {
			if(authority.getAuthority().equals(role)) {
				System.out.println(role);
				
				return "LoginDisplay";
			}else {
				session.setAttribute("isAdmin", "true");
			}
		}
		return "AdminHome";
	}
	
	@RequestMapping(value="/addus",method=RequestMethod.POST)
	public String addUSer(@ModelAttribute("user")User user,BindingResult result, HttpServletRequest request,HttpSession session) {
		System.out.println(user.getCpassword());
		System.out.println(user.getPassword());
		
		user.setEnabled("true");
		user.setRole("ROLE_USER");
		
		if(user.getCpassword().equals(user.getPassword())) {
			userDAO.addUser(user);
		}
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
		 
		return "Login";
	}
}

