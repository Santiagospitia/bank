package com.bank.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
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
	
	@NotNull
	@Min(1)
	private Integer dotyId;
}
