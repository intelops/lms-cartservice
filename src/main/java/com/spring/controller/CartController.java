package com.spring.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.AddItem;
import com.spring.dto.ApiResponse;
import com.spring.dto.LmsResponse;
import com.spring.iservice.ICartService;
import com.spring.model.Cart;

@RestController
@RequestMapping("/cart")
public class CartController extends BaseController{
	@Autowired
	private ICartService cartService;

	static Logger logger = Logger.getLogger(CartController.class);
	@RequestMapping(value = "/addToCart", method = RequestMethod.POST, headers = "content-type=application/json")	 
	 public ResponseEntity<ApiResponse> addToCart(@RequestBody AddItem addCart) throws SQLException {
			JSONObject json=new JSONObject();
		     //List<Order> orderList;
			Cart cart;
			try {
			//	HttpServletRequest req = (HttpServletRequest) request;
				//String auth = req.getHeader("Token");
				//String validateToken=validateToken(auth,"USER");
				//if(validateToken.equalsIgnoreCase("true")) {
				int userId=1;
		   cart= cartService.addToCart(addCart,userId);
	      //  StripeResponse stripeResponse = new StripeResponse(session.getId());
	        // send the stripe session id in response
	       
			
		}
		//else
		//{
			//return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);
		//}


	catch (Exception e) {
		String stackTrace = ExceptionUtils.getStackTrace(e);
		logger.error(stackTrace);
		return new ResponseEntity<ApiResponse>(new ApiResponse(false, "service failed due to some exceptions", 500), HttpStatus.INTERNAL_SERVER_ERROR);
	}
			return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart", 201), HttpStatus.CREATED);

		}
	@RequestMapping(value = "/getAllItemsInCart", method = RequestMethod.POST, headers = "content-type=application/json")	 
	 public ResponseEntity<LmsResponse> getAllItemsInCart(@RequestBody JSONObject req) throws SQLException {
			LmsResponse result=null;
		     List<Map<String, Object>> cartList;
			try {
			//	HttpServletRequest req = (HttpServletRequest) request;
				//String auth = req.getHeader("Token");
				//String validateToken=validateToken(auth,"USER");
				//if(validateToken.equalsIgnoreCase("true")) {
				int userId=1;
		   cartList= cartService.getAllItemsInCart(userId);
	      //  StripeResponse stripeResponse = new StripeResponse(session.getId());
	        // send the stripe session id in response
	        if(cartList!=null) {
	        	//json.put("list",cartList);
	        	result=new LmsResponse(true,cartList,200);
	        	// return new ResponseEntity<String>(uniqueId, HttpStatus.OK);
	        }
			
		}
		//else
		//{
			//return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);
		//}


	catch (Exception e) {
		String stackTrace = ExceptionUtils.getStackTrace(e);
		logger.error(stackTrace);
		return new ResponseEntity<LmsResponse>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	}
			return new ResponseEntity<LmsResponse>(result, HttpStatus.OK);
	       
		}
	@RequestMapping(value = "/removeItemFromcart", method = RequestMethod.POST, headers = "content-type=application/json")	 
	 public ResponseEntity<ApiResponse> removeItemFromCart(@RequestBody JSONObject req) throws SQLException {
			JSONObject json=new JSONObject();
			Cart cart;
		   //  List<AddToCartDto> cartList;
		try {
			//	HttpServletRequest req = (HttpServletRequest) request;
				//String auth = req.getHeader("Token");
				//String validateToken=validateToken(auth,"USER");
				//if(validateToken.equalsIgnoreCase("true")) {
				int userId=1;
		    cartService.removeItemFromCart(Integer.parseInt(req.get("cartId").toString()));
	      //  StripeResponse stripeResponse = new StripeResponse(session.getId());
	        // send the stripe session id in response
	       
			
		}
		//else
		//{
			//return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);
		//}


	catch (Exception e) {
		String stackTrace = ExceptionUtils.getStackTrace(e);
		logger.error(stackTrace);
		return new ResponseEntity<ApiResponse>(new ApiResponse(false, "service failed due to some exceptions",500), HttpStatus.INTERNAL_SERVER_ERROR);
	}
			 return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed", 200), HttpStatus.OK);

		}
	@RequestMapping(value = "/removeAllItemsFromcart", method = RequestMethod.POST, headers = "content-type=application/json")	 
	 public ResponseEntity<ApiResponse> removeAllItemsFromCart(@RequestBody JSONObject req) throws SQLException {
			JSONObject json=new JSONObject();
			Cart cart;
		   //  List<AddToCartDto> cartList;
		try {
			//	HttpServletRequest req = (HttpServletRequest) request;
				//String auth = req.getHeader("Token");
				//String validateToken=validateToken(auth,"USER");
				//if(validateToken.equalsIgnoreCase("true")) {
				int userId=1;
		    cartService.deleteCartItems(Integer.parseInt(req.get("userId").toString()));
	      //  StripeResponse stripeResponse = new StripeResponse(session.getId());
	        // send the stripe session id in response
	       
			
		}
		//else
		//{
			//return new ResponseEntity<String>("Unauthorized", HttpStatus.UNAUTHORIZED);
		//}


	catch (Exception e) {
		String stackTrace = ExceptionUtils.getStackTrace(e);
		logger.error(stackTrace);
		return new ResponseEntity<ApiResponse>(new ApiResponse(false, "service failed due to some exceptions",500), HttpStatus.INTERNAL_SERVER_ERROR);
	}
			 return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Items has been removed",200), HttpStatus.OK);

		}
}
