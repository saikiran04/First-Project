package com.niit.frontend.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.laptopsbackend.dao.ICartDAO;
import com.niit.laptopsbackend.dao.ICartItemDAO;
import com.niit.laptopsbackend.dao.ICategoryDAO;
import com.niit.laptopsbackend.dao.IProductDAO;
import com.niit.laptopsbackend.dao.ISupplierDAO;
import com.niit.laptopsbackend.dao.IUserDAO;
import com.niit.laptopsbackend.model.Cart;
import com.niit.laptopsbackend.model.CartItem;
import com.niit.laptopsbackend.model.Category;
import com.niit.laptopsbackend.model.Product;
import com.niit.laptopsbackend.model.Supplier;
import com.niit.laptopsbackend.model.User;

@Controller
public class AdminController {

	@Autowired
	ICategoryDAO categoryDAO;
	
	@Autowired
	Category category;
	
	@Autowired
	Product product;
	
	@Autowired
	IProductDAO productDAO;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	ISupplierDAO supplierDAO;
	
	/*@Autowired
	ICartDAO cartDAO;
	
	@Autowired
	ICartItemDAO cartItemDAO;*/
	
	@Autowired
	Cart cart;
	
	@Autowired
	IUserDAO userDAO;

	@Autowired
	User user;
	
	
	@ModelAttribute
	public Category returnObject1() {
		return new Category();
	}
	
	@ModelAttribute
	public Supplier returnObject2() {
		return new Supplier();
	}
	
	@ModelAttribute("product")
	public Product returnObject3() {
		return new Product();
	}
	
	//-------------------------------------Category Operations --------------------------
	@RequestMapping("/AddCategory")
	public ModelAndView ShowAddCategory(Model model) {
		 ModelAndView mv=new ModelAndView("AddCategory");
		 
		 model.addAttribute("categoryList", categoryDAO.getCategories());
		 System.out.println("added category details in controller");
		 
		 return mv;
	} 
	
	@RequestMapping(value="/addcat", method=RequestMethod.POST)
	public String addCate(@ModelAttribute("category")Category cate) {
		if(cate.getCatid()==0) {
			//new category, add it
			
			categoryDAO.saveCategory(cate);
			System.out.println("adding of new category in controller");
			
		}else {
			//existing category,call update
			 
			categoryDAO.saveCategory(category);
			System.out.println("addsup update method of category in controller");
		}
	
	return "redirect:/AddCategory";
	}
	
	@RequestMapping(value="/deletecategory{id}")
	public String showDeleteCategory(@PathVariable("id") int id, Model model) throws Exception {
		System.out.println(id);
		category=categoryDAO.get(id);
		System.out.println("Category deleted");
		ModelAndView mv=new ModelAndView("AddCategory");
		categoryDAO.delete(category);
		mv.addObject("AddCategory", 0);
		
		System.out.println("delete Id:" + id);
		return "redirect:/AddCategory" ;
		
	}
	@RequestMapping(value="/editcategory{id}")
	public ModelAndView showEditCategory(@PathVariable("id") int id, Model model) throws Exception {
		System.out.println(id);
		category=categoryDAO.get(id);
		System.out.println("Category update");
		ModelAndView mv=new ModelAndView("AddCategory");
		categoryDAO.saveCategory(category);
		
		
		System.out.println("delete Id:" + id);
		return mv ;
		
	}

//----------------------------Product Operations --------------------------
	
	@RequestMapping("/AddProduct")
	public ModelAndView showProduct(Model model) {
		
		ModelAndView m=new ModelAndView("AddProduct");
		
		model.addAttribute("categoryList", categoryDAO.getCategories());
		model.addAttribute("supplierList", supplierDAO.getSuppliers());
		model.addAttribute("productList", productDAO.list());
		
	
		return m;
		
		
	}
	
	@RequestMapping(value="/addprod",method=RequestMethod.POST)
	public String ShowAddProduct(@Valid @ModelAttribute("product")Product prod, Model model, BindingResult result, HttpServletRequest request) throws IOException {
		if(result.hasErrors()) {
			return "AddProduct";
		}
		else {
			
		
		System.out.println(prod.getProdname());
		System.out.println("image uploaded");
		System.out.println("my product controller called");
		
		MultipartFile image=prod.getImg();
		Path path;
		path=Paths.get("C:/Users/Asaikiran/gitmain/laptopsfrontend/src/main/webapp/pics/" +prod.getProdname() + ".jpg");
		System.out.println("Path=" + path);
		System.out.println("File name=" + prod.getImg().getOriginalFilename());
		if(image !=null&& !image.isEmpty()) {
			try {
				image.transferTo(new File(path.toString()));
				System.out.println("Image saved in: " +path.toString());
				
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Image not saved");
			}
		}
		
		if(prod.getProdid()==0) {
			//new product
			productDAO.saveProduct(prod);
		}else {
			productDAO.saveProduct(prod);
			return "AddProduct";
		}
		
		/*HttpSession session=request.getSession(false);
		String email1=(String)session.getAttribute("email");
		String username=(String)session.getAttribute("loggedInUser");*/
		model.addAttribute("productList",productDAO.list());
		model.addAttribute("categoryList", categoryDAO.getCategories());
		model.addAttribute("supplierList", supplierDAO.getSuppliers());
		System.out.println("all supplier got");
		
		return "redirect:/AddProduct";
		}
		
	}
	@RequestMapping(value="/deleteproduct{id}")
	public String showDeleteProduct(@PathVariable("id") int id, Model model) throws Exception {
		System.out.println(id);
		product=productDAO.get(id);
		System.out.println("Product deleted");
		ModelAndView mv=new ModelAndView("AddProduct");
		productDAO.delete(product);
		mv.addObject("AddProduct", 0);
		
		System.out.println("delete Id:" + id);
		return "redirect:/AddProduct" ;
		
	}
	@RequestMapping(value="/editproduct{id}")
	public ModelAndView showEditProduct(@PathVariable("id") String id, Model model) throws Exception {
		int i=Integer.parseInt(id);
		System.out.println(id);
		
		product=productDAO.get(i);
		System.out.println("Product update");
		ModelAndView mv=new ModelAndView("AddProduct");
		productDAO.delete(product);
		
		
		System.out.println("edit Id:" + id);
		
		return mv ;
		
	}
	@RequestMapping("/allproducts")
	public @ResponseBody List<Product> productsall(){
		System.out.println("Inside products all");
		return productDAO.list();
	}
	
	
//---------------------------- Supplier operations -------------------------------
	
	/*@RequestMapping("/AddSupplier")
	public String showSupplier()
	{
		return "AddSupplier";
	}*/
	@RequestMapping("/AddSupplier")
	public ModelAndView showAddSupplier(Model model) {
		ModelAndView mv=new ModelAndView("AddSupplier");
		
		model.addAttribute("supplierList",supplierDAO.getSuppliers());
		System.out.println("added supplier details in controller");
		
		return mv;
	}
	
	@RequestMapping(value="/addsupplier", method=RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier")Supplier sup) {
		if(sup.getSupplierid()==0) {
			//new supplier, add it
			
			supplierDAO.saveOrUpdate(sup);
			System.out.println("adding of new supplier in controller");
			
		}else {
			//existing category,call update
			 
			supplierDAO.saveOrUpdate(supplier);
			System.out.println("addsup update method of supplier in controller");
		}
	
	return "redirect:/AddSupplier";
	}
	@RequestMapping(value="/deletesupplier{id}")
	public String showDeleteSupplier(@PathVariable("id") int id, Model model) throws Exception {
		System.out.println(id);
		supplier=supplierDAO.get(id);
		System.out.println("Supplier deleted");
		ModelAndView mv=new ModelAndView("AddSupplier");
		supplierDAO.delete(supplier);
		mv.addObject("AddSuplier", 0);
		
		System.out.println("delete Id:" + id);
		return "redirect:/AddSupplier" ;
		
	}
	@RequestMapping(value="/editsupplier{id}")
	public ModelAndView showEditSupplier(@PathVariable("id") int id, Model model) throws Exception {
		System.out.println(id);
		supplier=supplierDAO.get(id);
		System.out.println("Supplier edit");
		
		supplierDAO.saveOrUpdate(supplier);
		
		System.out.println("Edit Id:" + id);
		ModelAndView mv=new ModelAndView("AddSupplier");
		return mv ;
		
	}
	
	//-------------------------------------- Cart Operations-------------------------------------------------------------------
	
	/*@RequestMapping("/{id}/AddToCart")
	public String showDetails(@PathVariable Integer id, ModelMap model) {

		model.addAttribute("cart", cartDAO.listcartproducts(id));

		return "AddToCart";

	}

	
	@RequestMapping(value = "/deletecart/{id}")
	public String showDeleteCart(@PathVariable("id") String id, Model model) throws Exception {

		int i = Integer.parseInt(id);

		cart =cartDAO.getbyid(i);

		System.out.println("cart delete");

		//ModelAndView mv = new ModelAndView("viewproducts");

		cartDAO.delete(cart);
		//mv.addObject("viewproducts", 0);

		System.out.println("delete Id:" + id);
		return "addtocart";
		//return mv;

	}
	@RequestMapping(value = "/editcart/{id}")
	public ModelAndView updateCartPage(@PathVariable("id") String id, Model model) throws Exception {
		int i = Integer.parseInt(id);

		model.addAttribute("product", cartDAO.getbyid(i));
		
		model.addAttribute("productList", productDAO.list());
		model.addAttribute("supplierList", supplierDAO.list());
		model.addAttribute("categoryList", categoryDAO.list());
		cartDAO.update(cart);
		System.out.println("edit cart in controller");
		ModelAndView mv = new ModelAndView("addtocart");
		return mv;

	}

@RequestMapping("/Cart")
	public String showCart()
	{
		return "Cart";
	}
	@RequestMapping("/{id}/Cart")
	public String addCart(@PathVariable Integer id, Principal principal,ModelMap model) {
		User user=userDAO.get(principal.getName());
	     user.setCpassword(user.getPassword());
	     Product product=productDAO.get(id);
	     Cart cart=cartDAO.getCartWithUserId(user.getUserid());
	     if(cart!=null)
	     {
	    	 cart.setUser(user);
	    		
	    	CartItem cartItem=cartItemDAO.getExistingCartItemCount(id, cart.getCartid());
	    	if(cartItem!=null)
	    	{
	    		cartItem.setCart(cart);
	    		cartItem.setGrandtotal(cartItem.getGrandtotal()+product.getPrice());
	    		cartItem.setQuantity(cartItem.getQuantity()+1);
	    		cartItemDAO.updateCartItem(cartItem);
	    	}
	    	else{
	    		cartItem=new CartItem();
	    		cartItem.setCart(cart);
	    		cartItem.setGrandtotal(product.getPrice());
	    		cartItem.setProduct(product);
	    		cartItem.setQuantity(1);
	    		cartItemDAO.addCartItem(cartItem);
	    	}
	    	cart.setGrandtotal(cart.getGrandtotal()+product.getPrice());
	    	cart.setQuantity(cart.getQuantity()+1);
	    	List<CartItem> cartItems=cart.getCartitems();
	    	cartItems.add(cartItem);
	    	cart.setCartitems(cartItems);
	    	cartDAO.update(cart);
	    	
	     }else
	     {
	    	 cart=new Cart();
	    	 cart.setGrandtotal(product.getPrice());
	    	 cart.setQuantity(1);
	    	 cart.setUser(user);
	    	 CartItem cartItem=new CartItem();
	    	 cartItem.setCart(cart);
	    	 cartItem.setGrandtotal(product.getPrice());
	    	 cartItem.setProduct(product);
	    	 cartItem.setQuantity(1);
	    	 
	    	 cartDAO.save(cart);
	    	 cartItemDAO.addCartItem(cartItem);
	     }
	     
	     model.addAttribute("mycartList", cartItemDAO.getAll());
				return "Cart";
	}
		     
*/
	}

