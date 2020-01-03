package com.meru.ProductViewService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.meru.ProductViewService.Service.ProductViewService;
import com.meru.ProductViewService.model.ProductView;
import com.meru.ProductViewService.model.ProductViewList;

@RestController
@RequestMapping("/meru")
public class ViewServiceController {

	@Autowired
	private ProductViewService productviewService;
	
	@RequestMapping(method =RequestMethod.GET,value="/productview/{productid}")
	public ProductView productView (@PathVariable int productid ){
		return productviewService.getProductView(productid);
	}
	
	@RequestMapping(method =RequestMethod.GET,value="/productsview")
	public ProductViewList productView (){
		return productviewService.getProductsView();
	}

}
