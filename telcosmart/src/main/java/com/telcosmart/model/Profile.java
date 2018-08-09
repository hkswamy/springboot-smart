/**
 * 
 */
package com.telcosmart.model;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.UDTValue;
import com.datastax.driver.core.DataType.Name;

import lombok.Data;


/**
 * @author Kumaraswami Hosuru
 *
 */
@Data
@Table
public class Profile {
	
	@PrimaryKey
	@Id
	private String profileId;
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	private String email;
	@NotBlank
	private String smsRecoveryNumber;
	
	private List<Account> accounts;
	
	@CassandraType(type = Name.UDT, userTypeName = "account")
	UDTValue alternative;
	
}
/*
 * The below are for MYSQL DB
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Data
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long profileId;
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	private String email;
	@NotBlank
	private String smsRecoveryNumber;
	
	@ElementCollection
	private List<Account> accounts;
	
}*/
