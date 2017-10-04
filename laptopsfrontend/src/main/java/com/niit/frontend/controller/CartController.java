package com.niit.frontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.laptopsbackend.dao.ICartDAO;
import com.niit.laptopsbackend.dao.IProductDAO;
import com.niit.laptopsbackend.dao.IUserDAO;
import com.niit.laptopsbackend.model.Cart;
import com.niit.laptopsbackend.model.Product;
import com.niit.laptopsbackend.model.User;

public class CartController {
	@Controller

	public class AdminController {

		@Autowired
		ICartDAO cartDAO;

		@Autowired
		Cart cart;

		@Autowired
		IProductDAO productDAO;

		@Autowired
		Product product;

		@Autowired
		IUserDAO userDAO;

		@Autowired
		User user;
		
		@Autowired
		HttpSession httpSession;

		
		// cart
		@RequestMapping(value = "/viewcart{id}")
		public ModelAndView viewmycart(@PathVariable("id") String id) {
			int s = Integer.parseInt(id);

			ModelAndView mv = new ModelAndView("mycart");
			mv.addObject("cartList", cartDAO.listcartproducts(s));
			// mv.addObject("cartprice", cartDAO.totalprice(id));
			return mv;
		}

		@RequestMapping(value = "/buy{id}&{pid}", method = RequestMethod.POST)
		public ModelAndView buyproductPage(@PathVariable("id") String id, @PathVariable("pid") String pid,
				@RequestParam("quantity") int quantity, HttpSession session) throws Exception {
			
			int i=Integer.parseInt(id);
			int ppid=Integer.parseInt(pid);
			user=userDAO.getbyid(i);
		ModelAndView mv = new ModelAndView("addtocart");
		//int k = Integer.parseInt(quantity);
		int y = 0;
		Cart kcart = new Cart();
		for (Cart temp : cartDAO.listcartproducts(i)) {
			if (temp.getProdid()==ppid) {
				y = 1;
				kcart = temp;
			}
		}
		if (y == 1) {
			kcart.setQuantity(kcart.getQuantity() + quantity);
			kcart.setPrice(kcart.getQuantity() * kcart.getCartproduct().getPrice());
			cartDAO.update(kcart);
		} else {
			cart.setQuantity(quantity);
			cart.setUserid(i);
			cart.setProdid(ppid);
			cart.setCartuser(userDAO.getbyid(i));
			product = productDAO.get(ppid);
			cart.setCartproduct(product);
			cart.setPrice(cart.getQuantity() * product.getPrice());
			cartDAO.save(cart);
		}
		mv.addObject("cartList", cartDAO.listcartproducts(i));
		mv.addObject("cartprice", cartDAO.totalprice(cart.getUserid()));
		return mv;
		}
		
		
		@RequestMapping("/viewcart")
		public ModelAndView viewCart(@RequestParam("userid")String uid,Model model) {
			int id=Integer.parseInt(uid);
			System.out.println("viewing cart");
			model.addAttribute("cartprice", cartDAO.totalprice(cart.getUserid()));
			model.addAttribute("cartList", cartDAO.listcartproducts(id));
			return new ModelAndView("addtocart");
		}
		@RequestMapping(value = "/deletecart{id}")
		public ModelAndView deleteCategory(@PathVariable("id") String id, HttpSession session) throws Exception {
			int i=Integer.parseInt(id);
			cart = cartDAO.getbyid(i);
			cartDAO.delete(cart);
			ModelAndView mv = new ModelAndView("addtocart");
			mv.addObject("cartList", cartDAO.listcartproducts(cart.getUserid()));
			session.setAttribute("cartvalue", cartDAO.totalproducts(cart.getUserid()));
			mv.addObject("cartprice", cartDAO.totalprice(cart.getUserid()));

			mv.addObject("cartmessage1", " has been deleted from your cart");
			return mv;
		}
	
	
	@RequestMapping("/{id}/ViewDetails")
	public String showDetails(@PathVariable Integer id, ModelMap model) {
		model.addAttribute("product",productDAO.get(id));
		return "ViewDetails";
	}

	@RequestMapping("/allproducts")
	public @ResponseBody List<Product> productsall1() {
		System.out.println("inside products all");
		return productDAO.list();
	}

	


	}
}
	
