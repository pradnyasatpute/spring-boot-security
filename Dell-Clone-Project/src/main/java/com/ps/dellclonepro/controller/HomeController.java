package com.ps.dellclonepro.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ps.dellclonepro.entity.Product;
import com.ps.dellclonepro.service.ProductService;

@Controller

public class HomeController {
	@Autowired
	private ProductService productService;

//    @GetMapping("/")
//    public String home(Model model) {
//        List<Product> products = productService.getAllProducts();
//        model.addAttribute("products", products);
//        return "index"; // Loads Thymeleaf index.html
//    }
	@RequestMapping("/")
	public String home(Model model) {
		List<Product> products;
		products = productService.displayAllProducts();
		model.addAttribute("products", products);
		long totalProducts = productService.getTotalProducts();
		model.addAttribute("totalProducts", totalProducts);

		long laptopCount = productService.getProductCountByCategory("laptop");
		model.addAttribute("laptopCount", laptopCount);
		
		long tabletCount = productService.getProductCountByCategory("tablet");
		model.addAttribute("tabletCount", tabletCount);
		
		long monitorCount = productService.getProductCountByCategory("monitors");
		model.addAttribute("monitorCount", monitorCount);
		
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String username = authentication.getName(); // Get username

	    model.addAttribute("username", username);

		return "index"; // Loads Thymeleaf index.html
	}

//    @PostMapping("/addProduct")
//    public Product addProduct(@RequestBody Product product) {
//    	return productService.addProduct(product);
//    }
	@RequestMapping("/addproducts")
	public String addProducts(Model model) {
		Product p = new Product();
		model.addAttribute("myproduct", p);
		return "addproducts";
	}

	@PostMapping("/addProduct")
	public String addProduct(@ModelAttribute("myproduct") Product product, @RequestParam("file") MultipartFile file) {

		// Save the product first, so it gets an auto-generated ID
		Product savedProduct = productService.saveProduct(product);

		// Now, pass the saved product ID to addProduct()
		productService.addProduct(savedProduct.getId(), file);

		return "redirect:/";
	}

	@GetMapping("/prolist")
	public String displayAllProducts(Model model) {
		List<Product> products;
		products = productService.displayAllProducts();

		model.addAttribute("products", products);
		return "products";
	}

	@RequestMapping("/updateProductForm/{productId}")
	public String updateProductForm(@PathVariable("productId") int productId, Model model) {
		Product product = productService.getProduct(productId);
		model.addAttribute("product", product);
		return "update-product-form";
	}

	@PostMapping("/updateProduct/{productId}")
	public String updateProduct(@PathVariable("productId") int productId, @ModelAttribute Product product) {
		productService.updateProduct(product, productId);
		return "redirect:/";
	}

	@RequestMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId) {
		productService.deleteProduct(productId);
		return "redirect:/";
	}

//	@PostMapping("/{id}/upload")
//	public ResponseEntity<?> uploadFile(@PathVariable Integer id,@RequestParam("file") MultipartFile file){
//		return ResponseEntity.ok(this.productService.storeFile(id, file));
//	}

	// File Upload (Returns a View)
//	@PostMapping("/{id}/upload")
//	public String uploadFile(@PathVariable Integer id, @RequestParam("file") MultipartFile file, Model model) {
//		String message = productService.storeFile(id, file);
//		model.addAttribute("message", "File uploaded successfully: " + message);
//		return "uploadSuccess"; // This should be a Thymeleaf template (uploadSuccess.html)
//	}
//
	@GetMapping("/download/{fileName}")
	public ResponseEntity<?> download(@PathVariable String fileName) {
		Resource resource = this.productService.loadAsResource(fileName);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\"" + fileName + "\"")
				.body(resource);
	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "you do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

}
