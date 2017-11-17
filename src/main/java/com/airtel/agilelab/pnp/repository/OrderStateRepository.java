package com.airtel.agilelab.pnp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.airtel.agilelab.pnp.entity.OrderRequestStatus;

public interface OrderStateRepository extends CrudRepository<OrderRequestStatus, Long>{
	
	@Query(value = "SELECT * FROM order_request_status ors WHERE ors.status = ?1 and ROWNUM <= ?2 order by ors.id asc for update skip locked ", nativeQuery = true)
	List<OrderRequestStatus> findSecondInOrderRequest(String status, int rownum);
	
	@Query(value = "Select count(*) from order_request_status ors where ors.status= ?1", nativeQuery=true)
	Integer checkOrderRequestCountByStatus(String status);
}
