/**
 * 
 */
package com.telcosmart.repository;

import org.springframework.data.repository.CrudRepository;

import com.telcosmart.model.Profile;

/**
 * @author Kumaraswami Hosuru
 *
 */
//public interface ProfileRepository extends JpaRepository<Profile, Long>{
	
public interface ProfileRepository extends CrudRepository<Profile, String>{
	
}
