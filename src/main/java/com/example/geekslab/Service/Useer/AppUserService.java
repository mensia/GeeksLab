package com.example.geekslab.Service.Useer;

import com.example.geekslab.Entites.AppUser;
import com.example.geekslab.Entites.Role;
import com.example.geekslab.Entites.UserRole;
import com.example.geekslab.Repository.UseerRepo.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.* ;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserService implements UserDetailsService {
    private final AppUserRepository appUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws
            UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username);
        Assert.notNull(appUser,
                new UsernameNotFoundException(username).getMessage());
        return new User(username
                ,appUser.getPassWord()
                ,getAuthorities(appUser.getRole()));
    }
    private List<GrantedAuthority> getAuthorities(UserRole userRole) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userRole.name()));
        return authorities;
    }
}
