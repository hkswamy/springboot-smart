package com.telcosmart.model;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Embeddable
@Data
@UserDefinedType
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	
	//private String id;
	private String accountName;
	//private String accountNumber;
	private String accountType;
	private String accountStatus;
}
