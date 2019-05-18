package product.center;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import product.center.bean.Product;

@Component
public class DefaultProductService implements ProductService{

	@Autowired
	private ProductDao pDao;
	
	@Override
	
	public Iterable<Product> productList(Integer page,Integer size) {

		return pDao.findAll(new PageRequest(page, size));
	}

	@Override
	public Product getProduct(int id) {
		
		
		return pDao.findOne(id);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public boolean saveOrUpdateProduct(Product product) {
		if(pDao.save(product)!=null) {
			return true;
		}
		return false;
	}

//	@Override
//	public boolean updateProduct(Product product) {
//		pDao.save(product);
//		
//		
//		
//		return false;
//	}

	@Override
	public boolean deleteProduct(Integer id) {
		pDao.delete(id);
		if(pDao.exists(id)) {
			return false;
		}
		return true;
	}

}
