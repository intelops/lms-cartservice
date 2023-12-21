package com.spring.iservice;

import java.util.List;
import java.util.Map;

import com.spring.dto.AddItem;
import com.spring.model.Cart;

public interface ICartService {
	List<Map<String, Object>> getAllItemsInCart(int userId);
	Cart addToCart( AddItem addCart,int userId);
	void removeItemFromCart(int parseInt);
	//void removeItemsFromCart(int parseInt);
	void deleteCartItems(int parseInt);

}
