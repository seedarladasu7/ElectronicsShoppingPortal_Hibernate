package com.portal.shopping.electronics.service;

import java.util.Optional;

import com.portal.shopping.electronics.model.ProductToCartRequest;
import com.portal.shopping.electronics.model.ProductsResponse;
import com.portal.shopping.electronics.model.PurchaseDetails;
import com.portal.shopping.electronics.model.PurchaseRequest;

public interface ElectronicsShoppingService {
	//ProductService
	public ProductsResponse getElectronicProducts(Optional<String> productName);
	
	//CartService
	public String addElectronicProductsToCart(ProductToCartRequest request);
	
	//PurchaseService
	public String confirmPurchase(PurchaseRequest request);
	
	//UserOrderService
	public PurchaseDetails getUserOrders(Integer userId);
	
}
