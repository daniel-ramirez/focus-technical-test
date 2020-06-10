package com.voicemailbox.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.voicemailbox.entities.VoicemailMessage;
import com.voicemailbox.repositories.VoicemailMessageRepository;

/**
 * VoicemailMessageService is used for getting VoicemailMessages
 * 
 * @author Daniel Ramirez
 * @since 0.0.1
 */
@Service
public class VoicemailMessageService {

	private final Log logger = LogFactory.getLog(VoicemailMessageService.class);

	@Autowired
	private VoicemailMessageRepository voicemailMessageRepository;

	/**
	 * Get Voicemail Message list paging
	 * 
	 * @param vmBoxId
	 * @param pageable
	 */
	public Page<VoicemailMessage> getMessages(String vmBoxId, Pageable pageable) {
		try {
			return voicemailMessageRepository.findByVmBoxId(vmBoxId, pageable);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	/**
	 * Get Voicemail Message
	 * 
	 * @param vmBoxId
	 * @param vmBoxId
	 */
	public VoicemailMessage getMessage(String vmBoxId, String mediaId) {
		try {
			return voicemailMessageRepository.findByVmBoxIdAndMediaId(vmBoxId, mediaId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

}
