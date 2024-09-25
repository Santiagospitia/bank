package com.bank.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the registered_account database table.
 * 
 */
@Entity
@Table(name = "registered_account")
@NamedQuery(name = "RegisteredAccount.findAll", query = "SELECT r FROM RegisteredAccount r")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "reac_id")
	private Integer reacId;

	private String enable;

	// bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name = "acco_id")
	private Account account;

	// bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;
}