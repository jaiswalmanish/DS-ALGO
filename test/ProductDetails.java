package com.az.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class ProductDetails {
	
	public class Product{
		private String aisleId;
		private int price;
		private String productId;

		Product(String aisleId, String productId, int price){
		    this.aisleId = aisleId;
		    this.productId = productId;
		    this.price = price;
		}    
	}

	public List<Integer> getKHighestPrices(List<Product> products, int k){
		  HashMap<String, Integer> aisleMap = new HashMap();
		  for(Product product: products){
		    aisleMap.put(product.aisleId,product.price);
		  }
		  
		  PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
		  for combination in itertools.product(*aisleMap.values()):
		    # The negation is for max-heaps
		    heapq.heappush(heap, (-sum(combination), combination))
		  
		  List<Integer> result = new ArrayList<>();
		  while(k > 0){
		    priceList = heapq.heappop(heap)[1]
		    collection.sort(priceList,reverse=True);	
		    for(int price: priceList){ 		
		        formattedStringPriceList += price+",";
		    }    
		    result.add(formattedStringPriceList);
		    k = k - 1;
		  }
		  return result;
	}			  

}
