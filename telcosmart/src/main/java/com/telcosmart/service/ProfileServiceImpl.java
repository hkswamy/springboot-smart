/**
 * 
 */
package com.telcosmart.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telcosmart.model.Profile;
import com.telcosmart.repository.ProfileRepository;

/**
 * @author Kumaraswami Hosuru
 *
 */
@Service
public class ProfileServiceImpl implements ProfileService {

	private static final Logger log = LoggerFactory.getLogger(ProfileServiceImpl.class);
	public ProfileServiceImpl() {
	}

	@Autowired
	private ProfileRepository profileRepository;

	// Create profile
	public Profile createProfile(Profile profile) {
		log.debug("Profile {} will be created.", profile.toString());
		return profileRepository.save(profile);
	}

	// Get all profiles
	public List<Profile> getAllProfiles() {
		return (List<Profile>) profileRepository.findAll();
	}

	// Get specific profile
	public Optional<Profile> getProfile(String profileId) {
		log.debug("Getting Profile for {}.", profileId);
		return profileRepository.findById(profileId);
	}

	// update profile
	public Profile updateProfile(Profile profile) {
		log.debug("Profile {} will be updated.", profile.toString());
		return profileRepository.save(profile);
	}

	// delete specific profile
	public void deleteProfile(String profileId) {
		log.debug("Deleting Profile for {}.", profileId);
		profileRepository.deleteById(profileId);
	}

	

}
