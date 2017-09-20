package com.niit.frontend.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.laptopsbackend.dao.ICategoryDAO;
import com.niit.laptopsbackend.dao.IProductDAO;
import com.niit.laptopsbackend.dao.ISupplierDAO;
import com.niit.laptopsbackend.model.Category;
import com.niit.laptopsbackend.model.Product;
import com.niit.laptopsbackend.model.Supplier;

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
		System.out.println(prod.getProdname());
		System.out.println("image uploaded");
		System.out.println("my product controller called");
		MultipartFile image=prod.getImg();
		Path path;
		path=Paths.get("C:/Users/Asaikiran/git/laptopsfrontend/src/main/webapp/pics/" +prod.getProdname() + ".jpg");
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
		
		HttpSession session=request.getSession(false);
		String email1=(String)session.getAttribute("email");
		String username=(String)session.getAttribute("loggedInUser");
		model.addAttribute("productList",productDAO.list());
		model.addAttribute("categoryDAO", categoryDAO.getCategories());
		model.addAttribute("supplierList", supplierDAO.getSuppliers());
		
		return "AddProduct";
		
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
}
