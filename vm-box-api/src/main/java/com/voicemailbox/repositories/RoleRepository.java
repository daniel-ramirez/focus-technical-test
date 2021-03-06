package com.voicemailbox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.voicemailbox.entities.Role;

/**
 * RoleRepository is a rest repository and this is exposed on URL
 * http://serve-host:port/api/roles
 * 
 * @author Daniel Ramirez
 * @since 0.0.1
 */
@RepositoryRestResource(path = "roles", collectionResourceRel = "roles")
public interface RoleRepository extends JpaRepository<Role, Long> {

}
