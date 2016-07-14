/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package cn.xiaohong.car.controllor;





import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;





import util.javaweb.ServletUtil;
import util.json.JSONUtils;
import util.str.QvoConditionUtil;
import cn.going.base.DataGrid;
import cn.going.base.Json;
import cn.going.base.PageHelper;
import cn.going.controllor.rbac.rbac.entity.Role;
import cn.going.controllor.rbac.rbac.qvo.RoleQvo;
import cn.xiaohong.car.model.Product;
import cn.xiaohong.car.qvo.ProductQvo;
import cn.xiaohong.car.service.ProductService;
import cn.going.view.JsView;

@Controller
@RequestMapping("/product.do")
public class ProductControllor {
	@Autowired
	ProductService productService;

	

	/** 新增 **/
	@ResponseBody
	@RequestMapping(params={"action=addproduct"}, method = RequestMethod.POST)
	
	public Json addproduct(HttpServletRequest request) throws Exception {
		Json j = new Json();

		try {
			Product product = getServletProduct(request);
			
			productService.createProduct(product);
			j.setSuccess(true);
			j.setMsg("新增成功！");
			j.setObj(product);
		} catch (Exception e) {
			e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;

	}
	
	
	
	

	// 获取信息
	private Product getServletProduct(HttpServletRequest request) {
		Product bean = new Product();
		
		
		 
				bean.setProductId(ServletUtil.getIntParamDefault0(request,
						"productId"))	;			
		
		 
		bean.setName(ServletUtil.getStringParamDefaultBlank(request,
				"name"));
		
		
		 
				bean.setPrice(ServletUtil.getIntParamDefault0(request,
						"price"))	;			
		
		 
				bean.setSuppilerId(ServletUtil.getIntParamDefault0(request,
						"suppilerId"))	;			
		
		 
		bean.setCreateDate(ServletUtil.getStringParamDefaultBlank(request,
				"createDate"));
		
		
		 
		bean.setRemark(ServletUtil.getStringParamDefaultBlank(request,
				"remark"));
		
		return bean;
	}
	// 获取信息-查询
		private ProductQvo getServletProductQvo(HttpServletRequest request) {
			ProductQvo bean = new ProductQvo();
			
			
			 
					bean.setProductId(ServletUtil.getIntParamDefault0(request,
							"productId"))	;			
			
			 
			bean.setName(ServletUtil.getStringParamDefaultBlank(request,
					"name"));
			
			
			 
					bean.setPrice(ServletUtil.getIntParamDefault0(request,
							"price"))	;			
			
			 
					bean.setSuppilerId(ServletUtil.getIntParamDefault0(request,
							"suppilerId"))	;			
			
			 
			bean.setCreateDate(ServletUtil.getStringParamDefaultBlank(request,
					"createDate"));
			
			
			 
			bean.setRemark(ServletUtil.getStringParamDefaultBlank(request,
					"remark"));
			
			return bean;
		}
	

	

	/** 更新 **/
	@ResponseBody
	@RequestMapping(params={"action=updateproduct"})
	public Json updateproduct(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Product product = getServletProduct(request);
		Json j = new Json();
		j.setSuccess(true);
		try {
			productService.updateProduct(product);
		}catch(Exception e){
			j.setMsg("操作失败！");
			j.setObj(product);
			return j;
		}
		j.setMsg("操作成功！");
		return j;
	}


	/** 列表初始化 **/
	@RequestMapping(params={"action=productlistindex"})
	public String productlistindex(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "/car/Product_list";
	}

	/** 获取列表 **/
	@ResponseBody
	@RequestMapping(params={"action=getProduct_List"})
	public DataGrid getProduct_List(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PageHelper page = new PageHelper();
		page.setPage(ServletUtil.getIntParamDefault0(request, "page"));
		ProductQvo qvo = getServletProductQvo(request);
		
		List<Product> productList = productService.getProduct_List(page, qvo);
		Integer count = productService.getProduct_List_Count(qvo);
		DataGrid dg = new DataGrid();
		dg.setRows(productList);
		dg.setTotal(Long.parseLong(count + ""));

		return dg;
	}


	/** 删除权限 **/
	@ResponseBody
	@RequestMapping(params={"action=removeProduct"})
	public Json removeProduct(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Json j = new Json();
		Integer auth_id[];
 
		String[] product_ids = ServletUtil.getStringParamDefaultBlank(request,
				"productId").split(",");
     		auth_id = new Integer[ product_ids.length];

		for (int i = 0; i < product_ids.length; i++) {
			auth_id[i] = Integer.parseInt(product_ids[i]);
		}

		try {
			j.setSuccess(true);
			j.setMsg("删除成功！");
			productService.removeProduct(auth_id);
		} catch (Exception e) {
			e.printStackTrace();
			j.setMsg("删除失败");
		}
		return j;
	}
	
		/** 选择框 **/
		@ResponseBody
		@RequestMapping(params={"action=getselect"})
		public String getRoleList_select(HttpServletRequest request,
				HttpServletResponse response) throws Exception {

			ProductQvo qvo = getServletProductQvo(request);
			
			List<Product> list = productService.getselect( qvo);
			String json = JSONUtils.toJSONString(list);

			return json;
		}

}

