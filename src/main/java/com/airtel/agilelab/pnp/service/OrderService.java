package com.airtel.agilelab.pnp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airtel.agilelab.pnp.entity.OrderRequestStatus;
import com.airtel.agilelab.pnp.repository.OrderStateRepository;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderStateRepository orderStateRepository;
	
	public void updateOrderByScheduler() {
		List<OrderRequestStatus> results = null;
		int rownumStartCount = 0;
		while(results == null) {
			if(0 >= orderStateRepository.checkOrderRequestCountByStatus("new")) {
				break;
			}
			rownumStartCount = rownumStartCount+1;
			results = orderStateRepository.findSecondInOrderRequest("new",rownumStartCount);
		}
		if(null != results && results.size() >0) {
			OrderRequestStatus orderRequestStatus = results.get(0);
			orderRequestStatus.setStatus("validated");
			//System.out.println(" validating order request "+orderRequestStatus.getId());
			System.out.println(orderRequestStatus.getId());
			orderStateRepository.save(orderRequestStatus);
		}else {
			System.out.println(" no more order request to validate ");
		}
	}
}
