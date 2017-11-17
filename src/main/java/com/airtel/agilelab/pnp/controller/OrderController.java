package com.airtel.agilelab.pnp.controller;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airtel.agilelab.pnp.entity.OrderRequest;
import com.airtel.agilelab.pnp.entity.OrderRequestStatus;
import com.airtel.agilelab.pnp.repository.OrderStateRepository;

@RestController
public class OrderController {

	@Autowired
	private OrderStateRepository orderStateRepository;
	
	/**
	 * Add a new order in db every 3 second
	 */
	@GetMapping("/createorders")
	public void generateOrderRequest(){
		System.out.println(" == generateOrderRequest == ");
		for(int i=0;i<150;i++) {
			// create new order
			OrderRequest order = new OrderRequest();
			order.setOrderReqId(
					Integer.parseInt(new RandomStringGenerator.Builder().withinRange('1', '9').build().generate(5))
					);
			order.setName(new RandomStringGenerator.Builder().withinRange('a', 'z').build().generate(5));
			// create status row for this order
			OrderRequestStatus orderStatus = new OrderRequestStatus();
			orderStatus.setStatus("new");
			orderStatus.setOrderRequest(order);
			orderStateRepository.save(orderStatus);
		}
	}
	
}
