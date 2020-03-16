package com.portal.shopping.electronics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "purchase")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer purchaseId;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cartId")
	@JsonBackReference
	private Cart cart;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "paymentModeId")
	@JsonBackReference
	private PaymentMode paymentMode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deliveryModeId")
	@JsonBackReference
	private DeliveryMode deliveryMode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	@JsonBackReference
	private User user;

	@Column
	private String purchaseOn;

}
