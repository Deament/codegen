
/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */


package cn.xiaohong.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.going.base.PageHelper;
import cn.xiaohong.car.dao.ProductDao;
import cn.xiaohong.car.model.Product;
import cn.xiaohong.car.qvo.ProductQvo;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;

	/** 注册。添加用户 **/
	public void createProduct(Product product) {
		productDao.createProduct(product);
	}

	

	/** 修改用户 **/
	public void updateProduct(Product product) {
		productDao.updateProduct(product);
	}

	/** 查询用户 **/
	public Product getProduct(ProductQvo qvo) {

		return productDao.getProduct(qvo);
	}

	

	/** 获取用户列表 **/
	public List<Product> getProduct_List(PageHelper page, ProductQvo qvo) {
		return productDao.getProduct_List(page, qvo);
	}

	/*** 用户列表数量 ***/
	public Integer getProduct_List_Count(ProductQvo qvo) {
		return productDao.getProduct_List_Count(qvo);
	}
	
	
	public void removeProduct(Integer id[]){
		 productDao.removeProduct(id);
	}
	
	public List<Product> getselect(ProductQvo qvo){
	return 	 productDao.getselect( qvo);
	}
	
	
}
