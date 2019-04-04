package kr.ac.hansung.cse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.cse.dao.ProductDao;
import kr.ac.hansung.cse.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	public List<Product> getProducts(){
		//productDao에서 getProducts()를해서 값을 controller 클래스에 전달
		//List<Product> products = productService.getProduct();
		//여기 리턴값이 결국 products
		return productDao.getProducts();
	}

	public boolean addProduct(Product product) {
		
		return productDao.addProduct(product); 
		
	}

	public boolean deleteProduct(int id) {
		
		return productDao.deleteProduct(id);
	}

	public Product getProductById(int id) {
		
		return productDao.getProductById(id); 
	}

	public boolean updateProduct(Product product) {

		return productDao.updateProduct(product);
	}
}
