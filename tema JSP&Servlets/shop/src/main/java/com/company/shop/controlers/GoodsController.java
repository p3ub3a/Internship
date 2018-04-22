package com.company.shop.controlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.shop.model.ProductDto;
import com.company.shop.model.UserDto;
import com.company.shop.services.ProductService;
import com.company.shop.services.UserService;

@WebServlet(urlPatterns = {"/goods"})
public class GoodsController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String GOODS_VIEW = "goods.jsp";
	
	UserService userService = new UserService();
	
	ProductService productService = new ProductService();
	
	private int itemId;
	private List<ProductDto> availableProducts = productService.getListAvailableProducts();
	static int totalItems=0;
	static List<ProductDto> itemsInBasket = new ArrayList<>();
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Session
		HttpSession session = request.getSession();
		session.setAttribute("basketList", itemsInBasket);
		
		// Populate user data
		UserDto user = userService.getCurrentLoggedInUser();
		request.setAttribute("user", user);
		
		// Populate products data
		request.setAttribute("products", availableProducts);
		
		// Forward to goods page
		RequestDispatcher dispatcher = request.getRequestDispatcher(GOODS_VIEW);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		itemId = Integer.parseInt(request.getParameter("selection"));
		if(itemId != 0){
			for(ProductDto product: availableProducts){
				if(product.getId() ==  itemId && !itemsInBasket.contains(product)){
					itemsInBasket.add(product);
					product.setQuantity(1);
					totalItems++;
					
					System.out.println(product.getLabel() + " has been added into the basket...");
					
				}else if(product.getId() ==  itemId && itemsInBasket.contains(product)){
					product.incrementQuantity();
					totalItems++;
					
					System.out.println("There are " + product.getQuantity() + " " + product.getLabel() + "s currently in the basket");
				}
			}
		}
		
		response.sendRedirect("/shop/basket");
	}
	
}