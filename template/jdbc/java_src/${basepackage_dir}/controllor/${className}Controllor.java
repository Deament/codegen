<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.controllor;





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
import ${basepackage}.model.${className};
import ${basepackage}.qvo.${className}Qvo;
import ${basepackage}.service.${className}Service;
import cn.going.view.JsView;

@Controller
@RequestMapping("/${classNameLower}.do")
public class ${className}Controllor {
	@Autowired
	${className}Service ${classNameLower}Service;

	

	/** 新增 **/
	@ResponseBody
	@RequestMapping(params={"action=add${classNameLower}"}, method = RequestMethod.POST)
	
	public Json add${classNameLower}(HttpServletRequest request) throws Exception {
		Json j = new Json();

		try {
			${className} ${classNameLower} = getServlet${className}(request);
			
			${classNameLower}Service.create${className}(${classNameLower});
			j.setSuccess(true);
			j.setMsg("新增成功！");
			j.setObj(${classNameLower});
		} catch (Exception e) {
			e.printStackTrace();
			j.setMsg(e.getMessage());
		}
		return j;

	}
	
	
	
	

	// 获取信息
	private ${className} getServlet${className}(HttpServletRequest request) {
		${className} bean = new ${className}();
		
		<#list table.columns as column>
		
		 
		<#if column.javaType=="java.lang.String">
		bean.set${column.columnName}(ServletUtil.getStringParamDefaultBlank(request,
				"${column.columnName?uncap_first}"));
		
		</#if>
				<#if column.javaType=="java.lang.Integer">
				bean.set${column.columnName}(ServletUtil.getIntParamDefault0(request,
						"${column.columnName?uncap_first}"))	;			
				</#if>	
						</#list>		
		return bean;
	}
	// 获取信息-查询
		private ${className}Qvo getServlet${className}Qvo(HttpServletRequest request) {
			${className}Qvo bean = new ${className}Qvo();
			
			<#list table.columns as column>
			
			 
			<#if column.javaType=="java.lang.String">
			bean.set${column.columnName}(ServletUtil.getStringParamDefaultBlank(request,
					"${column.columnName?uncap_first}"));
			
			</#if>
					<#if column.javaType=="java.lang.Integer">
					bean.set${column.columnName}(ServletUtil.getIntParamDefault0(request,
							"${column.columnName?uncap_first}"))	;			
					</#if>	
							</#list>		
			return bean;
		}
	

	

	/** 更新 **/
	@ResponseBody
	@RequestMapping(params={"action=update${classNameLower}"})
	public Json update${classNameLower}(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		${className} ${classNameLower} = getServlet${className}(request);
		Json j = new Json();
		j.setSuccess(true);
		try {
			${classNameLower}Service.update${className}(${classNameLower});
		}catch(Exception e){
			j.setMsg("操作失败！");
			j.setObj(${classNameLower});
			return j;
		}
		j.setMsg("操作成功！");
		return j;
	}


	/** 列表初始化 **/
	@RequestMapping(params={"action=${classNameLower}listindex"})
	public String ${classNameLower}listindex(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "/car/${className}_list";
	}

	/** 获取列表 **/
	@ResponseBody
	@RequestMapping(params={"action=get${className}_List"})
	public DataGrid get${className}_List(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PageHelper page = new PageHelper();
		page.setPage(ServletUtil.getIntParamDefault0(request, "page"));
		${className}Qvo qvo = getServlet${className}Qvo(request);
		
		List<${className}> ${classNameLower}List = ${classNameLower}Service.get${className}_List(page, qvo);
		Integer count = ${classNameLower}Service.get${className}_List_Count(qvo);
		DataGrid dg = new DataGrid();
		dg.setRows(${classNameLower}List);
		dg.setTotal(Long.parseLong(count + ""));

		return dg;
	}


	/** 删除权限 **/
	@ResponseBody
	@RequestMapping(params={"action=remove${className}"})
	public Json remove${className}(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Json j = new Json();
		Integer auth_id[];
		<#list
		table.columns as column> <#if column_index==0>
		String[] ${className?lower_case}_ids = ServletUtil.getStringParamDefaultBlank(request,
				"${column.columnName?uncap_first}").split(",");
</#if></#list>
		auth_id = new Integer[ ${className?lower_case}_ids.length];

		for (int i = 0; i < ${className?lower_case}_ids.length; i++) {
			auth_id[i] = Integer.parseInt(${className?lower_case}_ids[i]);
		}

		try {
			j.setSuccess(true);
			j.setMsg("删除成功！");
			${classNameLower}Service.remove${className}(auth_id);
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

			${className}Qvo qvo = getServlet${className}Qvo(request);
			
			List<${className}> list = ${classNameLower}Service.getselect( qvo);
			String json = JSONUtils.toJSONString(list);

			return json;
		}

}

