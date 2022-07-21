package com.nashtech.rookies.java05.AssetManagement.Model.DTO;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.nashtech.rookies.java05.AssetManagement.Model.Entity.Role;
import com.nashtech.rookies.java05.AssetManagement.Model.enums.UStatus;

import lombok.Data;

@Data
public class SignupRequest {
	
	private String firstname;

	@Size(min = 2, max = 50)
	private String lastname;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	private boolean gender;

	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	
	private Role role;

	private String status;

}
