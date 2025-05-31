package com.ceos21.vote.common.security;

import com.ceos21.vote.domain.member.dao.MemberRepository;
import com.ceos21.vote.domain.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final MemberRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        Member user = userRepository.findByIdentifier(identifier)
                .orElseThrow(() -> new UsernameNotFoundException("Not Found " + identifier));
        return new UserDetailsImpl(user);
    }
}
