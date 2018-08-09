/**
 * 
 */
package com.telcosmart.service;

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

import com.telcosmart.model.Account;
import com.telcosmart.model.Profile;
import com.telcosmart.repository.ProfileRepository;

/**
 * @author Kumaraswami Hosuru
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ProfileServiceImplTest {

	@InjectMocks
	ProfileServiceImpl profileService;

	@Mock
	ProfileRepository profileRepository;

	/*@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}*/

	@Test
	public void createProfileTrueTest() {
		Profile profile = new Profile();
		profile.setEmail("email.test@test.com");
		profile.setPassword("12233");
		profile.setSmsRecoveryNumber("smsRecoveryNumber");
		profile.setUsername("username");
		Account account = new Account();
		account.setAccountType("accountType");
		account.setAccountName("accountName");
		account.setAccountStatus("accountStatus");
		//account.setAccountNumber("accountNumber");
		List<Account> accounts = new ArrayList<>();
		accounts.add(account);
		profile.setAccounts(accounts);
		//Long l = (long) 1234;
		profile.setProfileId("l");
		Mockito.when(profileService.createProfile(profile)).thenReturn(profile);
		assertEquals("l", profileService.createProfile(profile).getProfileId());
	}

	@Test
	public void createProfileFalseTest() {
		Profile profile = new Profile();
		//Long l = (long) 1234;
		Account account = new Account("","","");
		List<Account> accounts = new ArrayList<>();
		accounts.add(account);
		profile.setAccounts(accounts);
		//profile.setProfileId(l);
		Long lo = (long) 1;
		Mockito.when(profileService.createProfile(profile)).thenReturn(profile);
		assertNotEquals(lo, profileService.createProfile(profile).getProfileId());
	}
	
	@Test
	public void getAllProfilesNotNullTest() {
		List<Profile> profiles = new ArrayList<>();
		Profile profile = new Profile();
		profiles.add(profile);
		Mockito.when(profileService.getAllProfiles()).thenReturn(profiles);
		assertNotNull(profileService.getAllProfiles());
		
	}
	
	@Test
	public void getAllProfilesNullTest() {
		Mockito.when(profileService.getAllProfiles()).thenReturn(null);
		assertNull(profileService.getAllProfiles());
		
	}
	
	@Test
	public void updateProfileTrueTest() {
		Profile profile = new Profile();
		//Long l = (long) 1234;
		//profile.setProfileId(l);
		profile.setProfileId("1");
		Mockito.when(profileService.updateProfile(profile)).thenReturn(profile);
		assertEquals("1", profileService.updateProfile(profile).getProfileId());
	}

	@Test
	public void updateProfileFalseTest() {
		Profile profile = new Profile();
		//Long l = (long) 1234;
		//profile.setProfileId(l);
		Long lo = (long) 1;
		profile.setProfileId("1");
		Mockito.when(profileService.updateProfile(profile)).thenReturn(profile);
		assertNotEquals(lo, profileService.updateProfile(profile).getProfileId());
	}
	
	@Test
	public void getProfileEqualsTest() {
		
		Profile profile = new Profile();
		//Long l = (long) 1234;
		profile.setProfileId("1234");
		Optional<Profile> optionalProfile = Optional.of(profile);
		Mockito.when(profileService.getProfile("1234")).thenReturn(optionalProfile);
		assertEquals("1234", profileService.getProfile("1234").get().getProfileId());
	}
	
	@Test
	public void getProfileNotEqualsTest() {
		
		Profile profile = new Profile();
		//Long l = (long) 1234;
		//profile.setProfileId(l);
		Optional<Profile> optionalProfile = Optional.of(profile);
		Long lo = (long) 12;
		Mockito.when(profileService.getProfile("l")).thenReturn(optionalProfile);
		assertNotEquals(lo, profileService.getProfile("l").get().getProfileId());
	}
	
	@Test
	public void deleteProfileTest() {
		Profile profile = new Profile();
		profile.setProfileId("1234");
		profileService.deleteProfile("1234");
	}
	
	

}

