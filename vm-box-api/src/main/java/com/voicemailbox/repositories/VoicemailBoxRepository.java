package com.voicemailbox.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voicemailbox.entities.VoicemailBox;

/**
 * VoicemailBoxRepository is a JPA repository
 * 
 * @author Daniel Ramirez
 * @since 0.0.1
 */
@Repository
public interface VoicemailBoxRepository extends JpaRepository<VoicemailBox, String> {

	VoicemailBox findByAccountIdAndVmBoxId(String accountId, String vmBoxId);

	Page<VoicemailBox> findByAccountId(String accountId, Pageable pageable);

}
