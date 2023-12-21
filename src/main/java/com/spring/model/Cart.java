 package com.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="cart")
public class Cart implements Serializable {

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
    private int userId;

    @Column
    private double price;
@Column
private Boolean isActive=true;

    public double getPrice() {
	return price;
}



public void setPrice(double price) {
	this.price = price;
}



	public Boolean getIsActive() {
	return isActive;
}



public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
}



	
 

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



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}
    
}
