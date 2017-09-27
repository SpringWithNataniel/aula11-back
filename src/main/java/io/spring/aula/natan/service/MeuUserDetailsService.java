/*
*
* Aula com Nataniel Paiva
*
* Esse projeto poderá ser distribuído da forma que você achar melhor
* O importante é que você aprenda de verdade!
*
 */
package io.spring.aula.natan.service;

import io.spring.aula.natan.entity.Usuario;
import io.spring.aula.natan.repository.UsuarioRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nataniel Paiva <nataniel.paiva@gmail.com>
 */
@Service
public class MeuUserDetailsService implements UserDetailsService {

    private final UsuarioRepository userRepository;

    @Autowired
    public MeuUserDetailsService(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userRepository.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException(String.format("Usuário não existe!", username));
        }
        return new UserRepositoryUserDetails(usuario);
    }

    private final static class UserRepositoryUserDetails extends Usuario implements UserDetails {

        private static final long serialVersionUID = 1L;

        private UserRepositoryUserDetails(Usuario usuario) {
            super(usuario);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return getPerfis();
        }

        @Override
        public String getUsername() {
            return getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        @Override
        public String getPassword() {
            return getSenha();
        }

    }

}
