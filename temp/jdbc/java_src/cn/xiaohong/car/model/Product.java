/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2016
 */

package cn.xiaohong.car.model;
import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;




public class Product implements Serializable {
	
	//alias
	public static final String TABLE_ALIAS = "Product";
	public static final String ALIAS_PRODUCT_ID = "productId";
	public static final String ALIAS_NAME = "车辆名称";
	public static final String ALIAS_PRICE = "价格";
	public static final String ALIAS_SUPPILER_ID = "suppilerId";
	public static final String ALIAS_CREATE_DATE = "createDate";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	
	//columns START
	private java.lang.Integer productId;
	private java.lang.String name;
	private java.lang.Integer price;
	private java.lang.Integer suppilerId;
	private java.lang.String createDate;
	private java.lang.String remark;
	//columns END

	public Product(){
	}

	public Product(
		java.lang.Integer productId
	){
		this.productId = productId;
	}

	public void setProductId(java.lang.Integer value) {
		this.productId = value;
	}
	
	public java.lang.Integer getProductId() {
		return this.productId;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	public void setPrice(java.lang.Integer value) {
		this.price = value;
	}
	
	public java.lang.Integer getPrice() {
		return this.price;
	}
	public void setSuppilerId(java.lang.Integer value) {
		this.suppilerId = value;
	}
	
	public java.lang.Integer getSuppilerId() {
		return this.suppilerId;
	}
	public void setCreateDate(java.lang.String value) {
		this.createDate = value;
	}
	
	public java.lang.String getCreateDate() {
		return this.createDate;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("ProductId",getProductId())
			.append("Name",getName())
			.append("Price",getPrice())
			.append("SuppilerId",getSuppilerId())
			.append("CreateDate",getCreateDate())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getProductId())
			.append(getName())
			.append(getPrice())
			.append(getSuppilerId())
			.append(getCreateDate())
			.append(getRemark())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Product == false) return false;
		if(this == obj) return true;
		Product other = (Product)obj;
		return new EqualsBuilder()
			.append(getProductId(),other.getProductId())
			.append(getName(),other.getName())
			.append(getPrice(),other.getPrice())
			.append(getSuppilerId(),other.getSuppilerId())
			.append(getCreateDate(),other.getCreateDate())
			.append(getRemark(),other.getRemark())
			.isEquals();
	}
}

