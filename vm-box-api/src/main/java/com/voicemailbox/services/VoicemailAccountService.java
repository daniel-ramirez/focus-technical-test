package com.voicemailbox.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.voicemailbox.entities.VoicemailAccount;
import com.voicemailbox.repositories.VoicemailAccountRepository;

/**
 * VoicemailAccountService is used for getting VoicemailAccounts
 * 
 * @author Daniel Ramirez
 * @since 0.0.1
 */
@Service
public class VoicemailAccountService {

	private final Log logger = LogFactory.getLog(VoicemailAccountService.class);

	@Autowired
	private VoicemailAccountRepository voicemailAccountRepository;

	/**
	 * Get Voicemail Account list paging
	 * 
	 * @param pageable
	 */
	public Page<VoicemailAccount> getAccounts(Pageable pageable) {
		try {
			return voicemailAccountRepository.findAll(pageable);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	/**
	 * Get Voicemail Account
	 * 
	 * @param accountId
	 */
	public VoicemailAccount getAccount(String accountId) {
		try {
			return voicemailAccountRepository.findByAccountId(accountId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

}
