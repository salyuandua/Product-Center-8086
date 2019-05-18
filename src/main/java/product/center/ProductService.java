package product.center;


import product.center.bean.Product;

public interface ProductService {

	public Iterable<Product> productList(Integer page,Integer size );
		
	public Product getProduct(int id);
	
	public boolean saveOrUpdateProduct(Product product);
	
	//public boolean updateProduct(Product product);
	
	public boolean deleteProduct(Integer id);
	
}
