package com.bank.domain;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cust_id")
	@NotNull
	@Min(1)
	private Integer custId;
	
	@NotNull
	@NotEmpty
	@Size(min=4, max=255)
	private String address;

	@NotNull
	@NotEmpty	
	@Size(min=4, max=255)
	@Email
	private String email;

	@NotNull
	private Boolean enable;
	
	@NotNull
	@NotEmpty
	@Size(min=4, max=255)
	private String name;

	@NotNull
	@NotEmpty
	@Size(min=4, max=255)
	private String phone;
	
	private String token;

	// bi-directional many-to-one association to Account
	@OneToMany(mappedBy = "customer")
	private List<Account> accounts;

	// bi-directional many-to-one association to DocumentType
	@ManyToOne
	@JoinColumn(name = "doty_id")
	private DocumentType documentType;

	// bi-directional many-to-one association to RegisteredAccount
	@OneToMany(mappedBy = "customer")
	private List<RegisteredAccount> registeredAccounts;

}