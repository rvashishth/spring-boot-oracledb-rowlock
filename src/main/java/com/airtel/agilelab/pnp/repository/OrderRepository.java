package com.airtel.agilelab.pnp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.airtel.agilelab.pnp.entity.OrderRequest;

public interface OrderRepository extends CrudRepository<OrderRequest, Long>{

}
