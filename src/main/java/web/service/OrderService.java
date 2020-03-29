package web.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

	ProductService productService;

	public OrderService(ProductService productService) {
		this.productService = productService;
	}

	public String getProductName() {
		return productService.getProductName();
	}

}
