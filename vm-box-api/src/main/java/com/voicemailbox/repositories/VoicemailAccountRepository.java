package com.voicemailbox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voicemailbox.entities.VoicemailAccount;

/**
 * VoicemailAccountRepository is a JPA repository
 * 
 * @author Daniel Ramirez
 * @since 0.0.1
 */
@Repository
public interface VoicemailAccountRepository extends JpaRepository<VoicemailAccount, String> {

	VoicemailAccount findByAccountId(String accountId);

}
