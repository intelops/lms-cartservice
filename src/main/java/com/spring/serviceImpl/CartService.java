package com.spring.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.dto.AddItem;
import com.spring.dto.LmsResponse;
import com.spring.exception.CartItemNotExistException;
import com.spring.iservice.ICartService;
import com.spring.model.Cart;

import com.spring.repository.ICartRepository;
import com.spring.service.BaseServiceImpl;
@Service
public class CartService extends BaseServiceImpl implements ICartService {
	@Autowired
	private ICartRepository repository;;


	@Override
	@Transactional
	public Cart addToCart(AddItem addCart,int userId){
	
		Cart cart=new Cart();
	try {
			
			cart.setProductId(addCart.getProductId());
			cart.setUserId(userId);
			//cart.setQuantity(addCart.getQuantity());
			cart.setPrice(addCart.getPrice());
			cart.setCreatedDate(new Date());
			cart.setIsActive(true);
			genericDao.create(cart);
		}
		catch (Exception e) {
			throw e;
		}
		return cart;
	}

	@Override
	@Transactional
	public List<Map<String, Object>> getAllItemsInCart(int userId) {
		// TODO Auto-generated method stub
		List<Cart> cartList=null;
		//Map<String,Object> cartDtoList=new HashMap<String,Object>();
		List<Map<String, Object>> mapList=new ArrayList<Map<String,Object>>();
		
		try {
			cartList=repository.getAllList(userId);
			for(Cart cart:cartList) {
				Map<String,Object> cartDtoList=new HashMap<String,Object>();
				
				//AddItem cartDto=new AddItem(cart.getId(),cart.getProductId(),cart.getPrice(),cart.getUserId());
				//cartDtoList.add(cartDto);
				//ResponseEntity<LmsResponse> list=getCourseById(cart.getProductId());
				Map<String,Object> list=getCourseById(cart.getProductId()).getBody().getResponse();
			cartDtoList.put("courseName", list.get("courseName"));
			cartDtoList.put("InstitueName", list.get("userName"));
			cartDtoList.put("courseCategory", list.get("courseCategory"));
			cartDtoList.put("rating", list.get("rating"));
			cartDtoList.put("courseLevel", list.get("courseLevel"));
			cartDtoList.put("totalDuration", list.get("totalDuration"));
			cartDtoList.put("totalChapters", list.get("totalChapters"));
			cartDtoList.put("image", list.get("image"));

			//cartDtoList.put("discountPercantage", list.get("courseCategory"));

			cartDtoList.put("courseId",list.get("courseId") );
			cartDtoList.put("price",cart.getPrice());
			cartDtoList.put("userId",cart.getUserId());
			cartDtoList.put("id", cart.getId());	
				mapList.add(cartDtoList);
			}
		}
		catch (Exception e) {
			throw e;
		}
		return mapList;
	}

	@Override
	@Transactional
	public void removeItemFromCart(int cartId) {
		// TODO Auto-generated method stub
		try {
			 if (!repository.existsById(cartId))
		            throw new CartItemNotExistException("Cart id is invalid : " + cartId);
		      //  cartRepository.deleteById(id);
			repository.removeItemFromCart(cartId);
		}
		catch (Exception e) {
			throw e;
		}
	}
	@Override
	@Transactional
	public void deleteCartItems(int userId) {
        repository.deleteAllItemsInCart(userId);
    }
}
