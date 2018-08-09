/**
 * 
 */
package com.telcosmart.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.telcosmart.model.Profile;
import com.telcosmart.service.ProfileServiceImpl;

/**
 * @author Kumaraswami Hosuru
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ProfileControllerTest {
	
	@InjectMocks
	ProfileController proflieController;
	
	@Mock
	ProfileServiceImpl profileService;
	
	@Test
	public void createProfileTrueTest() {
		Profile profile = new Profile();
		//Long l = (long) 1234;
		profile.setProfileId("l");
		Mockito.when(proflieController.createProfile(profile)).thenReturn(profile);
		assertEquals("l", proflieController.createProfile(profile).getProfileId());
	}
	
	
	@Test
	public void createProfileFalseTest() {
		Profile profile = new Profile();
		//Long l = (long) 1234;
		//profile.setProfileId(l);
		Long lo = (long) 1;
		Mockito.when(proflieController.createProfile(profile)).thenReturn(profile);
		assertNotEquals(lo, proflieController.createProfile(profile).getProfileId());
	}
	
	@Test
	public void getAllProfilesNotNullTest() {
		List<Profile> profiles = new ArrayList<>();
		Profile profile = new Profile();
		profiles.add(profile);
		Mockito.when(proflieController.getAllProfiles()).thenReturn(profiles);
		assertNotNull(proflieController.getAllProfiles());
		
	}
	
	@Test
	public void getAllProfilesNullTest() {
		Mockito.when(proflieController.getAllProfiles()).thenReturn(null);
		assertNull(proflieController.getAllProfiles());
		
	}
	
	@Test
	public void updateProfileTrueTest() {
		Profile profile = new Profile();
		//Long l = (long) 1234;
		//profile.setProfileId(l);
		profile.setProfileId("1");
		Mockito.when(proflieController.updateProfile(profile)).thenReturn(profile);
		assertEquals("1", proflieController.updateProfile(profile).getProfileId());
	}

	@Test
	public void updateProfileFalseTest() {
		Profile profile = new Profile();
		//Long l = (long) 1234;
		//profile.setProfileId(l);
		Long lo = (long) 1;
		profile.setProfileId("1");
		Mockito.when(proflieController.updateProfile(profile)).thenReturn(profile);
		assertNotEquals(lo, proflieController.updateProfile(profile).getProfileId());
	}
	
	@Test
	public void getProfileEqualsTest() {
		
		Profile profile = new Profile();
		//Long l = (long) 1234;
		profile.setProfileId("1234");
		Optional<Profile> optionalProfile = Optional.of(profile);
		Mockito.when(proflieController.getProfile("1234")).thenReturn(optionalProfile);
		assertEquals("1234", proflieController.getProfile("1234").get().getProfileId());
	}
	
	@Test
	public void getProfileNotEqualsTest() {
		
		Profile profile = new Profile();
		//Long l = (long) 1234;
		//profile.setProfileId(l);
		Optional<Profile> optionalProfile = Optional.of(profile);
		Long lo = (long) 12;
		Mockito.when(proflieController.getProfile("l")).thenReturn(optionalProfile);
		assertNotEquals(lo, proflieController.getProfile("l").get().getProfileId());
	}
	
	@Test
	public void deleteProfileTest() {
		Profile profile = new Profile();
		profile.setProfileId("1234");
		proflieController.deleteProfile("1234");
	}

}
