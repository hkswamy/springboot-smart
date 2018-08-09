/**
 * 
 */
package com.telcosmart.service;

import java.util.List;
import java.util.Optional;

import com.telcosmart.model.Profile;

/**
 * @author Kumaraswami Hosuru
 *
 */
public interface ProfileService {

	// Create profile
	public Profile createProfile(Profile profile);

	// Get all profiles
	public List<Profile> getAllProfiles();

	// Get specific profile
	public Optional<Profile> getProfile(String profileId);

	// update profile
	public Profile updateProfile(Profile profile);

	// delete specific profile
	public void deleteProfile(String profileId);

}
