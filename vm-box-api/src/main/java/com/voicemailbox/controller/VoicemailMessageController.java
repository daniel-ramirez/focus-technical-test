package com.voicemailbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.voicemailbox.entities.VoicemailMessage;
import com.voicemailbox.services.VoicemailMessageService;

/**
 * VoicemailMessageController expose an endpoint to get voicemail message; this
 * is exposed on URL http://serve-host:port/api/accounts/{ACCOUNT_ID}/vmboxes
 * 
 * @author Daniel Ramirez
 * @since 0.0.1
 */
@RestController
@RequestMapping(value = "/v2")
public class VoicemailMessageController {

	@Autowired
	private VoicemailMessageService voicemailMessageService;

	@GetMapping("/accounts/{accountId}/vmboxes/{vmBoxId}/messages")
	@ResponseBody
	public Page<VoicemailMessage> getMessages(@PathVariable(value = "vmBoxId", required = true) String vmBoxId,
			Pageable pageable) {
		return voicemailMessageService.getMessages(vmBoxId, pageable);
	}

	@GetMapping("/accounts/{accountId}/vmboxes/{vmBoxId}/messages/{messageId}")
	@ResponseBody
	public VoicemailMessage getMessage(@PathVariable(value = "vmBoxId", required = true) String vmBoxId,
			@PathVariable(value = "messageId", required = true) String messageId) {
		return voicemailMessageService.getMessage(vmBoxId, messageId);
	}

}
