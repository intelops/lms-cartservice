package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.dto.AddItem;
import com.spring.model.Cart;


@Repository
public interface ICartRepository  extends PagingAndSortingRepository<Cart,Integer>{
	@Query("select a from Cart a where  a.userId=:userId and a.isActive=1") 
	List<Cart> getAllList(@Param("userId")int userId);
	@Modifying
@Query("UPDATE Cart SET isActive=0  WHERE id=:cartId") 
	void removeItemFromCart(@Param("cartId")int cartId);
	@Modifying
	@Query("UPDATE Cart SET isActive=0  WHERE userId=:userId") 
	void deleteAllItemsInCart(@Param("userId")int userId);

}
