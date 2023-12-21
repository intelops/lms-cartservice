package com.spring.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CartItem {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "createdDate")
    private Date createdDate;

  //  @ManyToOne
    //@JoinColumn(name = "product_id", referencedColumnName = "id")
    @Column
    private int productId;
    @Column
    private int cartId;

    @Column
    private double cost;

@Column
private Boolean isActive;
@ManyToOne(cascade= CascadeType.ALL)
@JoinColumn(name = "cartId", nullable = false, insertable = false, updatable = false)
private Cart cart;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public Date getCreatedDate() {
	return createdDate;
}

public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}

public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}

public double getCost() {
	return cost;
}

public void setCost(double cost) {
	this.cost = cost;
}

public Boolean getIsActive() {
	return isActive;
}

public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
}


}
