package com.airtel.agilelab.pnp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="order_request")
public class OrderRequest {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SOME_SEQUENCE")
	@SequenceGenerator(allocationSize=1,name="SOME_SEQUENCE",sequenceName="SOME_SEQUENCE")
	private int id;
	
	@Column(name="order_req_number")
	private int orderReqId;
	
	@Override
	public String toString() {
		return "OrderRequest [id=" + id + ", orderReqId=" + orderReqId + ", name=" + name + "]";
	}

	@OneToOne(mappedBy="orderRequest")
	private OrderRequestStatus orderRequestStatus;
	
	@Column
	private String name;

	public OrderRequest() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderReqId() {
		return orderReqId;
	}

	public void setOrderReqId(int orderReqId) {
		this.orderReqId = orderReqId;
	}

	public OrderRequestStatus getOrderRequestStatus() {
		return orderRequestStatus;
	}

	public void setOrderRequestStatus(OrderRequestStatus orderRequestStatus) {
		this.orderRequestStatus = orderRequestStatus;
	}


}
