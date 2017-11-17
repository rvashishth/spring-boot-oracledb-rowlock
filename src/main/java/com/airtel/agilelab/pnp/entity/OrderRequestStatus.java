package com.airtel.agilelab.pnp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="order_request_status")
public class OrderRequestStatus {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SOME_SEQUENCE2")
	@SequenceGenerator(allocationSize=1,name="SOME_SEQUENCE2",sequenceName="SOME_SEQUENCE2")
	private int id;
	
	@JoinColumn(name="order_request_id")
	@OneToOne(cascade=CascadeType.ALL)
	private OrderRequest orderRequest;
	
	@Column
	private String status;

	@Override
	public String toString() {
		return "OrderRequestStatus [id=" + id + ", orderRequest=" + orderRequest + ", status=" + status + "]";
	}

	public OrderRequestStatus() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OrderRequest getOrderRequest() {
		return orderRequest;
	}

	public void setOrderRequest(OrderRequest orderRequest) {
		this.orderRequest = orderRequest;
	}
	
}
