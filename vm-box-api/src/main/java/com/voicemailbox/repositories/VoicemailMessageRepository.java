package com.voicemailbox.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.voicemailbox.entities.VoicemailMessage;

/**
 * VoicemailBoxRepository is a JPA repository
 * 
 * @author Daniel Ramirez
 * @since 0.0.1
 */
@Repository
public interface VoicemailMessageRepository extends JpaRepository<VoicemailMessage, String> {

	VoicemailMessage findByVmBoxIdAndMediaId(String vmBoxId, String mediaId);

	Page<VoicemailMessage> findByVmBoxId(String vmBoxId, Pageable pageable);

}
