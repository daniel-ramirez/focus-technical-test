package com.voicemailbox.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.voicemailbox.entities.Account;
import com.voicemailbox.entities.AccountRole;
import com.voicemailbox.entities.Role;
import com.voicemailbox.repositories.AccountRepository;
import com.voicemailbox.repositories.AccountRoleRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountRoleRepository accountRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		Account currentUser = accountRepository.findByUsername(username);
		List<AccountRole> userRoles = accountRoleRepository.findByAccount(currentUser);
		String[] roles = userRoles.stream().map(AccountRole::getRole).map(Role::getName).collect(Collectors.toList())
				.toArray(new String[0]);

		if (currentUser == null) {
			throw new UsernameNotFoundException(username);
		}

		return new UserDetailsImpl(currentUser, AuthorityUtils.createAuthorityList(roles));
	}

}
