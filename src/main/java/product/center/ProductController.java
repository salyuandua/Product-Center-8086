package product.center;


import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import product.center.bean.Product;
import product.center.utils.ApiResult;


@RestController
@RequestMapping(value="/product",produces="application/json;charset=UTF-8")
public class ProductController {

	@Autowired
	private ProductService pService;
	
	
	//@RequestMapping("/list")
	@GetMapping("/list")
	public Iterable<Product> productList(
			@RequestParam(name="page",defaultValue="0") Integer page,
			@RequestParam(name="size",defaultValue="20") Integer size){
		
		return pService.productList(page, size);
	}
	
	
	
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable String id) {

		if(StringUtils.isBlank(id)||!StringUtils.isNumeric(id)) {//in validated
			throw new IllegalArgumentException();
			
		}
		return pService.getProduct(Integer.parseInt(id));
	}
	
	/**
	 * add product method
	 * @param product
	 * @return
	 */
	@PostMapping("/submit")
	public ApiResult submit(@Valid Product product,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new IllegalArgumentException(); 
			
		}
		if(!pService.saveOrUpdateProduct(product)) {
			return new ApiResult(false, "Submit failed!");
			
		}
		
		return new ApiResult(true, "submit success!");
		
	}
	
	
	
	
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ApiResult  IllegalArguhandler() {
		return new ApiResult(false, "Arguments are wrong");
	}
	
	
	
	
	
}
