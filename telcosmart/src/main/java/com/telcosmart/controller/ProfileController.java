/**
 * 
 */
package com.telcosmart.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telcosmart.model.Profile;
import com.telcosmart.service.ProfileService;

/**
 * @author Kumaraswami Hosuru
 *
 */
@RestController
@RequestMapping("/telcosmart")
public class ProfileController {
	private static final Logger log = LoggerFactory.getLogger(ProfileController.class);
	
	public ProfileController() {
	}
	
	@Autowired
	private ProfileService profileService;
	
	//Create profile
	@PostMapping("/create-profile")
	public Profile createProfile(@Valid @RequestBody Profile profile) {
		log.debug("Profile {} will be created.", profile.toString());
		return profileService.createProfile(profile);
	}
	
	//Get all profiles
	@GetMapping("/profiles")
	public List<Profile> getAllProfiles() {
		log.debug("Getting all the profiles");
		return profileService.getAllProfiles();
	}
	
	//Get profile for profileId
	@GetMapping("/profile/{profileId}")
	public Optional<Profile> getProfile(@PathVariable(value="profileId") String profileId) {
		log.debug("Getting Profile for {}.", profileId);
		return profileService.getProfile(profileId);
	}
	
	//Update profile
	@PutMapping("/update-profile")
	public Profile updateProfile(@Valid @RequestBody Profile profile) {
		log.debug("Profile {} will be updated.", profile.toString());
		return profileService.updateProfile(profile);
	}
	
	@DeleteMapping("/delete-profile/{profileId}")
	public void deleteProfile(@PathVariable(value="profileId")String profileId) {
		log.debug("Deleting Profile for {}.", profileId);
		 profileService.deleteProfile(profileId);
	}
	
	@RequestMapping("/greeting")
    public String greeting() {
        return "Hello from EurekaClient!";
    }

}
