package com.sgb.biblioteca.config;

import com.sgb.biblioteca.model.Role;
import com.sgb.biblioteca.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> applyAuths(request))
                .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/", true).permitAll())
                .logout(LogoutConfigurer::permitAll);
        return http.build();
    }

    private void applyAuths(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authz) {
        authz
            .requestMatchers(HttpMethod.GET, "/css/**", "/js/**", "/images/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/").authenticated()
            

            // Usuário
            .requestMatchers(HttpMethod.GET, "/login").permitAll()
            .requestMatchers(HttpMethod.GET, "/usuario/new").permitAll()
            .requestMatchers(HttpMethod.POST, "/usuario/new").permitAll()
            .requestMatchers(HttpMethod.GET, "/usuario/{id}/edit").authenticated()
            .requestMatchers(HttpMethod.POST, "/usuario/{id}/edit").authenticated()
            

            // Funcionário
            .requestMatchers(HttpMethod.GET, "/funcionario/new", "/funcionario/{id}/edit").hasRole(Role.STR.ADMIN)
            .requestMatchers(HttpMethod.POST, "/funcionario/new").hasRole(Role.STR.ADMIN)
            .requestMatchers(HttpMethod.GET,  "/funcionario", "/funcionario/{id}", "/livro/new").hasAnyRole(Role.STR.ATENDENTE, Role.STR.ADMIN)
            
            
            // Livro
            .requestMatchers(HttpMethod.GET,  "/livro/new", "/livro/{id}/edit").hasAnyRole(Role.STR.ATENDENTE, Role.STR.ADMIN)
            .requestMatchers(HttpMethod.POST,  "/livro/new").hasAnyRole(Role.STR.ATENDENTE, Role.STR.ADMIN)
            .requestMatchers(HttpMethod.GET,  "/livro", "/livro/{id}").authenticated()
            
            
            // Editora
            .requestMatchers(HttpMethod.GET,  "/editora/new", "/editora/{id}/edit").hasAnyRole(Role.STR.ATENDENTE, Role.STR.ADMIN)
            .requestMatchers(HttpMethod.POST,  "/editora/new").hasAnyRole(Role.STR.ATENDENTE, Role.STR.ADMIN)
            .requestMatchers(HttpMethod.GET,  "/editora", "/editora/{id}").authenticated()
            
            
            // Autor
            .requestMatchers(HttpMethod.GET,  "/autor/new", "/autor/{id}/edit").hasAnyRole(Role.STR.ATENDENTE, Role.STR.ADMIN)
            .requestMatchers(HttpMethod.POST,  "/autor/new").hasAnyRole(Role.STR.ATENDENTE, Role.STR.ADMIN)
            .requestMatchers(HttpMethod.GET,  "/autor", "/autor/{id}").authenticated()
            
            
            // Empréstimo
            .requestMatchers(HttpMethod.GET,  "/emprestimo/new", "/emprestimo/{id}/edit").hasAnyRole(Role.STR.ATENDENTE, Role.STR.ADMIN)
            .requestMatchers(HttpMethod.POST,  "/emprestimo/new").hasAnyRole(Role.STR.ATENDENTE, Role.STR.ADMIN)
            .requestMatchers(HttpMethod.GET,  "/emprestimo", "/emprestimo/{id}").authenticated()
            
            // API's
            .requestMatchers(HttpMethod.GET,  "/api/autores", "/api/livros", "/api/editoras", "/api/users").hasAnyRole(Role.STR.ATENDENTE, Role.STR.ADMIN)

            ;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomUserDetailsService();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception{
        AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
        return auth.build();
    }
}
