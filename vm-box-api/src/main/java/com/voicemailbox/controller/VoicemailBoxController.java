package com.voicemailbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.voicemailbox.entities.VoicemailBox;
import com.voicemailbox.services.VoicemailBoxService;

/**
 * VoicemailBoxController expose an endpoint to get voicemail boxes; this is
 * exposed on URL http://serve-host:port/api/accounts/{ACCOUNT_ID}/vmboxes
 * 
 * @author Daniel Ramirez
 * @since 0.0.1
 */
@RestController
@RequestMapping(value = "/v2")
public class VoicemailBoxController {

	@Autowired
	private VoicemailBoxService voicemailBoxService;

	@GetMapping("/accounts/{accountId}/vmboxes")
	@ResponseBody
	public Page<VoicemailBox> getVmBoxes(@PathVariable(value = "accountId", required = true) String accountId,
			Pageable pageable) {
		return voicemailBoxService.getVmBoxes(accountId, pageable);
	}

	@GetMapping("/accounts/{accountId}/vmboxes/{vmBoxId}")
	@ResponseBody
	public VoicemailBox getVmBox(@PathVariable(value = "accountId", required = true) String accountId,
			@PathVariable(value = "vmBoxId", required = true) String vmBoxId) {
		return voicemailBoxService.getVmBox(accountId, vmBoxId);
	}

}
