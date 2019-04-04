package kr.ac.hansung.cse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.cse.model.Product;
import kr.ac.hansung.cse.service.ProductService;

@Controller
public class ProductController {
	// 우리 목표는 controller가 service를 호출하는거고
	// service가 dao를 호출하는 그런 루트!

	// bean 생성할때 자동으로 묶어줌
	@Autowired
	private ProductService productService;

	// 사용자가 /products 라는 url로 들어올경우
	@RequestMapping("/products")
	// 아래의 메소드를 실행시킨다.
	public String getProducts(Model model) {

		// getProduct() 메소드를 이용해 리스트에 프로덕트를 저장한다.
		List<Product> products = productService.getProducts();
		// 가져온 product를 model에다 넣는 작업. key,value 값으로..
		model.addAttribute("products", products);
		// view의 logical name
		// 원래는 products.jsp라고 해줘야하는데..안해줘도 뭐 인식한다나..
		return "products";
	}

	// 사용자가 /viewProduct 라는 url로 들어올경우
	@RequestMapping("/viewProduct/{productId}")
	// 아래의 메소드를 실행시킨다.
	// @PathVariable 경로안에 있는 product.id 을 productId로 저장하겠다
	public String viewProduct(@PathVariable int productId, Model model) {
		//특정한 id를 가진 레코드 가져와서 product에 저장함
		Product product = productService.getProductById(productId);
		//model에 product를 넣는다
		model.addAttribute("product", product);
		// id를 바탕으로 빼온 상품데이터를 가지고 상품의 상세 설명 만들어야함
		return "viewProduct";
	}

}
