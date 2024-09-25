package com.bank.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "acco_id")
	private String accoId;

	private BigDecimal balance;

	private String enable;

	private String password;

	private Long version;

	// bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;

	// bi-directional many-to-one association to RegisteredAccount
	@OneToMany(mappedBy = "account")
	private List<RegisteredAccount> registeredAccounts;

	// bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy = "account")
	private List<Transaction> transactions;

}