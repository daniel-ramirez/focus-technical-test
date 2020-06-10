package com.voicemailbox.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.voicemailbox.entities.VoicemailBox;
import com.voicemailbox.repositories.VoicemailBoxRepository;

/**
 * VoicemailBoxService is used for getting VoicemailBoxes
 * 
 * @author Daniel Ramirez
 * @since 0.0.1
 */
@Service
public class VoicemailBoxService {

	private final Log logger = LogFactory.getLog(VoicemailBoxService.class);

	@Autowired
	private VoicemailBoxRepository voicemailBoxRepository;

	/**
	 * Get all Voicemail Boxes list paging
	 * 
	 * @param pageable
	 */
	public Page<VoicemailBox> getAllVmBoxes(Pageable pageable) {
		try {
			return voicemailBoxRepository.findAll(pageable);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	/**
	 * Get Voicemail Boxes list paging
	 * 
	 * @param accountId
	 * @param pageable
	 */
	public Page<VoicemailBox> getVmBoxes(String accountId, Pageable pageable) {
		try {
			return voicemailBoxRepository.findByAccountId(accountId, pageable);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	/**
	 * Get Voicemail Box
	 * 
	 * @param accountId
	 * @param vmBoxId
	 */
	public VoicemailBox getVmBox(String accountId, String vmBoxId) {
		try {
			return voicemailBoxRepository.findByAccountIdAndVmBoxId(accountId, vmBoxId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

}
