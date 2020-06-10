package com.voicemailbox.util;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.voicemailbox.entities.Account;
import com.voicemailbox.entities.AccountRole;
import com.voicemailbox.entities.Role;
import com.voicemailbox.entities.VoicemailAccount;
import com.voicemailbox.entities.VoicemailBox;
import com.voicemailbox.entities.VoicemailMessage;
import com.voicemailbox.repositories.AccountRepository;
import com.voicemailbox.repositories.AccountRoleRepository;
import com.voicemailbox.repositories.RoleRepository;
import com.voicemailbox.repositories.VoicemailAccountRepository;
import com.voicemailbox.repositories.VoicemailBoxRepository;
import com.voicemailbox.repositories.VoicemailMessageRepository;

@Service
public class InitialData {

	private final Log logger = LogFactory.getLog(InitialData.class);

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	AccountRoleRepository accountRoleRepository;

	@Autowired
	VoicemailAccountRepository voicemailAccountRepository;

	@Autowired
	VoicemailBoxRepository voicemailBoxRepository;

	@Autowired
	VoicemailMessageRepository voicemailMessageRepository;

	public void addLoginData() {
		try {
			Account account1 = new Account();
			account1.setUsername("admin");
			account1.setPassword((new BCryptPasswordEncoder()).encode("123456"));
			account1.setAccountNonExpired(true);
			account1.setAccountNonLocked(true);
			account1.setCredentialsNonExpired(true);
			account1.setEnabled(true);
			account1 = accountRepository.save(account1);

			Role role1 = new Role();
			role1.setName("ROLE_ADMIN");
			role1 = roleRepository.save(role1);

			AccountRole accountRole1 = new AccountRole();
			accountRole1.setAccount(account1);
			accountRole1.setRole(role1);
			accountRoleRepository.save(accountRole1);
		} catch (Exception e) {
			logger.info("Admin - user or role already exists");
		}

		try {
			Account account2 = new Account();
			account2.setUsername("user");
			account2.setPassword((new BCryptPasswordEncoder()).encode("123456"));
			account2.setAccountNonExpired(true);
			account2.setAccountNonLocked(true);
			account2.setCredentialsNonExpired(true);
			account2.setEnabled(true);
			account2 = accountRepository.save(account2);

			Role role2 = new Role();
			role2.setName("ROLE_USER");
			role2 = roleRepository.save(role2);

			AccountRole accountRole2 = new AccountRole();
			accountRole2.setAccount(account2);
			accountRole2.setRole(role2);
			accountRoleRepository.save(accountRole2);
		} catch (Exception e) {
			logger.info("User - user or role already exists");
		}
	}

	public void addVoicemailData() {
		try {
			/******* Main Account *******/
			VoicemailAccount voicemailAccount = new VoicemailAccount();
			voicemailAccount.setAccountId("4642e64040cdb8b89c310a21a07c7f62");
			voicemailAccount.setName("Main Account");
			voicemailAccountRepository.save(voicemailAccount);

			VoicemailBox voicemailBox = new VoicemailBox();
			voicemailBox.setVmBoxId("b37675a2d7b90d60f0ee5d4175502394");
			voicemailBox.setAccountId(voicemailAccount.getAccountId());
			voicemailBox.setName("Main Voicemail Box 1");
			voicemailBoxRepository.save(voicemailBox);

			VoicemailMessage voicemailMessage = new VoicemailMessage();
			voicemailMessage.setMediaId("201605-6aadef09f6fcf5fd8bcdfca312e923ba");
			voicemailMessage.setVmBoxId(voicemailBox.getVmBoxId());
			voicemailMessage.setFromValue("1001@aeac33.sip.2600hz.com");
			voicemailMessage.setToValue("1000@aeac33.sip.2600hz.com");
			voicemailMessage.setCallerIdNumber("1001");
			voicemailMessage.setCallerIdName("userb userb");
			voicemailMessage.setCallId("79959ZDNmM2I5ZTliMzA0NzA4N2FjNjlmODA5OWVkZjUxZWU");
			voicemailMessage.setFolder("new");
			voicemailMessage.setLength(3140);
			voicemailMessage.setTimestampValue(new Date().getTime());
			voicemailMessageRepository.save(voicemailMessage);

			voicemailMessage = new VoicemailMessage();
			voicemailMessage.setMediaId("201605-f0c3c16551a5ff7b5753a381892e2e01");
			voicemailMessage.setVmBoxId(voicemailBox.getVmBoxId());
			voicemailMessage.setFromValue("1002@aeac33.sip.2600hz.com");
			voicemailMessage.setToValue("1000@aeac33.sip.2600hz.com");
			voicemailMessage.setCallerIdNumber("1002");
			voicemailMessage.setCallerIdName("userc userc");
			voicemailMessage.setCallId("79959MmNiMmJiMTIxODhjZjk0ZDhmOGNkMjJkN2MwNGQyNWY");
			voicemailMessage.setFolder("saved");
			voicemailMessage.setLength(5500);
			voicemailMessage.setTimestampValue(new Date().getTime());
			voicemailMessageRepository.save(voicemailMessage);

			voicemailMessage = new VoicemailMessage();
			voicemailMessage.setMediaId("201605-b5753a381892e2f0c3c16551a5ff7e01");
			voicemailMessage.setVmBoxId(voicemailBox.getVmBoxId());
			voicemailMessage.setFromValue("1002@aeac33.sip.2600hz.com");
			voicemailMessage.setToValue("1000@aeac33.sip.2600hz.com");
			voicemailMessage.setCallerIdNumber("1002");
			voicemailMessage.setCallerIdName("userc userc");
			voicemailMessage.setCallId("79959MmNiMmJiMTIxODhjZjk0ZDhmOGNkMjJkN2MwNGQyNWY");
			voicemailMessage.setFolder("deleted");
			voicemailMessage.setLength(4200);
			voicemailMessage.setTimestampValue(new Date().getTime());
			voicemailMessageRepository.save(voicemailMessage);

			voicemailBox = new VoicemailBox();
			voicemailBox.setVmBoxId("c6377d7b95a20d75560f0ee395d41024");
			voicemailBox.setAccountId(voicemailAccount.getAccountId());
			voicemailBox.setName("Main Voicemail Box 2");
			voicemailBoxRepository.save(voicemailBox);

			voicemailMessage = new VoicemailMessage();
			voicemailMessage.setMediaId("201605-cf5fd8bcdfca3126aaf6fe923badef09");
			voicemailMessage.setVmBoxId(voicemailBox.getVmBoxId());
			voicemailMessage.setFromValue("someone@farfaraway.com");
			voicemailMessage.setToValue("1000@aeac33.sip.2600hz.com");
			voicemailMessage.setCallerIdNumber("6001");
			voicemailMessage.setCallerIdName("someone");
			voicemailMessage.setCallId("59799ZDNmM2I5ZTliMzA0NzA4N2FjNjlmODA5OWVkZjUxZWU");
			voicemailMessage.setFolder("new");
			voicemailMessage.setLength(3140);
			voicemailMessage.setTimestampValue(new Date().getTime());
			voicemailMessageRepository.save(voicemailMessage);

			/******* Secondary Account *******/
			voicemailAccount = new VoicemailAccount();
			voicemailAccount.setAccountId("5783e25447cdb8b89c453a21a07c7f86");
			voicemailAccount.setName("Secondary Account");
			voicemailAccountRepository.save(voicemailAccount);

			voicemailBox = new VoicemailBox();
			voicemailBox.setVmBoxId("60f0ee5d4175502394b37675a2d7b90d");
			voicemailBox.setAccountId(voicemailAccount.getAccountId());
			voicemailBox.setName("Secondary Voicemail Box 1");
			voicemailBoxRepository.save(voicemailBox);

			voicemailMessage = new VoicemailMessage();
			voicemailMessage.setMediaId("201606-9f6fcf5fd8bcdfca312e923ba6aadef0");
			voicemailMessage.setVmBoxId(voicemailBox.getVmBoxId());
			voicemailMessage.setFromValue("1004@aeac33.sip.2600hz.com");
			voicemailMessage.setToValue("1000@aeac33.sip.2600hz.com");
			voicemailMessage.setCallerIdNumber("1004");
			voicemailMessage.setCallerIdName("usere usere");
			voicemailMessage.setCallId("95979ZDNmM2I5ZTliMzA0NzA4N2FjNjlmODA5OWVkZjUxZWU");
			voicemailMessage.setFolder("new");
			voicemailMessage.setLength(3940);
			voicemailMessage.setTimestampValue(new Date().getTime());
			voicemailMessageRepository.save(voicemailMessage);

			voicemailMessage = new VoicemailMessage();
			voicemailMessage.setMediaId("201606-551a5ff7b5753a381892e2e01f0c3c16");
			voicemailMessage.setVmBoxId(voicemailBox.getVmBoxId());
			voicemailMessage.setFromValue("1002@aeac33.sip.2600hz.com");
			voicemailMessage.setToValue("1000@aeac33.sip.2600hz.com");
			voicemailMessage.setCallerIdNumber("1002");
			voicemailMessage.setCallerIdName("userc userc");
			voicemailMessage.setCallId("79959MmNiMmJiMTIxODhjZjk0ZDhmOGNkMjJkN2MwNGQyNWY");
			voicemailMessage.setFolder("saved");
			voicemailMessage.setLength(5110);
			voicemailMessage.setTimestampValue(new Date().getTime());
			voicemailMessageRepository.save(voicemailMessage);

			voicemailBox = new VoicemailBox();
			voicemailBox.setVmBoxId("75560f0ee395d41024c6377d7b95a20d");
			voicemailBox.setAccountId(voicemailAccount.getAccountId());
			voicemailBox.setName("Secondary Voicemail Box 2");
			voicemailBoxRepository.save(voicemailBox);

			voicemailMessage = new VoicemailMessage();
			voicemailMessage.setMediaId("201607-9f6fcf5fd8bcdfca312e923ba6aadef0");
			voicemailMessage.setVmBoxId(voicemailBox.getVmBoxId());
			voicemailMessage.setFromValue("1004@aeac33.sip.2600hz.com");
			voicemailMessage.setToValue("1000@aeac33.sip.2600hz.com");
			voicemailMessage.setCallerIdNumber("1004");
			voicemailMessage.setCallerIdName("usere usere");
			voicemailMessage.setCallId("95979ZDNmM2I5ZTliMzA0NzA4N2FjNjlmODA5OWVkZjUxZWU");
			voicemailMessage.setFolder("new");
			voicemailMessage.setLength(4039);
			voicemailMessage.setTimestampValue(new Date().getTime());
			voicemailMessageRepository.save(voicemailMessage);
		} catch (Exception e) {
			logger.info("Init data already exists");
		}
	}

}
