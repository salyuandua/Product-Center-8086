package product.center;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import product.center.bean.Product;


public interface ProductDao extends JpaRepository<Product, Integer>{

//	@Modifying
//	@Query("update Product ")
//	public void updateProduct(Integer id);
	
	
}
