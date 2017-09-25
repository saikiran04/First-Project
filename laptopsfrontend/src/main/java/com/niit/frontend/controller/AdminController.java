package com.niit.frontend.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		model.addAttribute("categoryList", categoryDAO.getCategories());
		model.addAttribute("supplierList", supplierDAO.getSuppliers());
		
		return "redirect:/AddProduct";
		
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
	
}
