/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package cn.xiaohong.car.dao;





import java.util.List;




import cn.going.base.PageHelper;
import cn.xiaohong.car.model.Product;

import cn.xiaohong.car.qvo.ProductQvo;

/*** Dao **/
public interface ProductDao {

	/**新增 返回void*/
	public void save(Product entity);
	/**批量新增**/
	public void batchsave(List<Product> list);
	/**实体中含有Id 的新增**/
	public void savewithbean(Product entity);
	
	
	
	/**批量更新 **/
	public void batchupdate(Product entity);
	/**更新**/
	public void batchupdate(List<Product> list);
	/**删除**/
	public void remove(int id);
	/**批量删除**/
	public void remove(int id[]);
	
	/**获取实体*/
	public void get(int id);
	/**分页查询**/
	public void  query(Page page,ProductQvo qvo);
	/**不 分页查询**/
	public void  query(ProductQvo qvo);
	
	/**下拉框**/
}
