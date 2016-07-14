<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;





import java.util.List;




import cn.going.base.PageHelper;
import ${basepackage}.model.${className};

import ${basepackage}.qvo.${className}Qvo;

/*** Dao **/
public interface ${className}Dao {

	/**新增 返回void*/
	public void save(${className} entity);
	/**批量新增**/
	public void batchsave(List<${className}> list);
	/**实体中含有Id 的新增**/
	public void savewithbean(${className} entity);
	
	
	
	/**批量更新 **/
	public void batchupdate(${className} entity);
	/**更新**/
	public void batchupdate(List<${className}> list);
	/**删除**/
	public void remove(int id);
	/**批量删除**/
	public void remove(int id[]);
	
	/**获取实体*/
	public void get(int id);
	/**分页查询**/
	public void  query(Page page,${className}Qvo qvo);
	/**不 分页查询**/
	public void  query(${className}Qvo qvo);
	
	/**下拉框**/
}
