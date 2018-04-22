package com.company.shop.controlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

@WebServlet(urlPatterns = {"/basket"})
public class BasketController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String BASKET_VIEW = "basket.jsp";
	
	private String message;
	
	UserService userService = new UserService();
	
	ProductService productService = new ProductService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get products in basket from session
		HttpSession session = request.getSession();
		List<ProductDto> productsInBasket = (List<ProductDto>)session.getAttribute("basketList");
		request.setAttribute("productsInBasket", productsInBasket);
		
		if(productsInBasket == null || productsInBasket.isEmpty()){
			message = "Woops, the basket seems to be empty, try adding some products.";
			request.setAttribute("showList", false);
		}else{
			message = "Products in basket:";
			request.setAttribute("showList", true);
			request.setAttribute("totalItems", GoodsController.totalItems);
		}
		request.setAttribute("message", message);
		
		// Forward to basket page
		RequestDispatcher dispatcher = request.getRequestDispatcher(BASKET_VIEW);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		// Get products in basket from session
		
		int quantity;
		quantity = Integer.parseInt(request.getParameter("quantity"));
		long productId;
		productId=Integer.parseInt(request.getParameter("id"));
		
		deleteProduct(productId,quantity);
		
		//Update basket view
		this.doGet(request,response);
	}

	private void deleteProduct(long productId, int quantity) {

		for(ProductDto product: GoodsController.itemsInBasket){
			if(product.getId() == productId){
				if(quantity>1){
					quantity--;
					GoodsController.totalItems--;
					product.setQuantity(quantity);
					
					if(quantity == 1){
						System.out.println("There is one " + product.getLabel() + " inside the basket");
					}else{
						System.out.println("One " + product.getLabel() + " has been removed, there are " + product.getQuantity() + " " + product.getLabel() + "s currently in the basket");
					}
				}else{
					GoodsController.itemsInBasket.remove(product);
					quantity--;
					GoodsController.totalItems--;
					product.setQuantity(quantity);
					
					System.out.println(product.getLabel() + " has been removed from the basket...");
				}
				break;
			}
		}
	}
}