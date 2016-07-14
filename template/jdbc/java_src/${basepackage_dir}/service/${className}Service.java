
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 

package ${basepackage}.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.going.base.PageHelper;
import ${basepackage}.dao.${className}Dao;
import ${basepackage}.model.${className};
import ${basepackage}.qvo.${className}Qvo;

@Service
public class ${className}Service {
	@Autowired
	private ${className}Dao ${classNameLower}Dao;

	/** 注册。添加用户 **/
	public void create${className}(${className} ${classNameLower}) {
		${classNameLower}Dao.create${className}(${classNameLower});
	}

	

	/** 修改用户 **/
	public void update${className}(${className} ${classNameLower}) {
		${classNameLower}Dao.update${className}(${classNameLower});
	}

	/** 查询用户 **/
	public ${className} get${className}(${className}Qvo qvo) {

		return ${classNameLower}Dao.get${className}(qvo);
	}

	

	/** 获取用户列表 **/
	public List<${className}> get${className}_List(PageHelper page, ${className}Qvo qvo) {
		return ${classNameLower}Dao.get${className}_List(page, qvo);
	}

	/*** 用户列表数量 ***/
	public Integer get${className}_List_Count(${className}Qvo qvo) {
		return ${classNameLower}Dao.get${className}_List_Count(qvo);
	}
	
	
	public void remove${className}(Integer id[]){
		 ${classNameLower}Dao.remove${className}(id);
	}
	
	public List<${className}> getselect(${className}Qvo qvo){
	return 	 ${classNameLower}Dao.getselect( qvo);
	}
	
	
}
