package eni.tp.app.eni_app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //    @Bean
    public UserDetailsService userDetailsService() {

        String passwordChiff = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("password");


        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password(passwordChiff)
                .roles("USER")
                .build();

        UserDetails userDetails2 = User.withDefaultPasswordEncoder()
                .username("root")
                .password("root")
                .roles("USER")
                .build();

        UserDetails userDetails3 = User.withDefaultPasswordEncoder()
                .username("test")
                .password("test")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(userDetails, userDetails2, userDetails3);
    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery("select email, password, 1 from membre where email=?");
        userDetailsManager.setAuthoritiesByUsernameQuery("select membre.email, roles.role from membre join roles on membre.admin = roles.is_admin where email = ?");

        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        //.requestMatchers("/MEMBRE").hasRole("EMPLOYE") //hasRole pour ne pas avoir besoin de mettre le préfixe "ROLE_"
                        .requestMatchers("/films").permitAll()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/films/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/film-form").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.POST, "/film-form").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/vendor/**").permitAll()
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/images/**").permitAll()//toutes les requêtes commençant par /vendor sont autorisées à tout le monde
                        .requestMatchers("/logout").authenticated()

                        //.anyRequest().authenticated()
                        .anyRequest().denyAll() //rejette toutes les requêtes non configurées ci-dessus
                );

//    http.formLogin(Customizer.withDefaults()); //Configure la page de login de Spring Security par défaut
        http.formLogin(form ->
                form
                        .loginPage("/login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/", true)


        );


        HeaderWriterLogoutHandler clearSiteData = new HeaderWriterLogoutHandler(new ClearSiteDataHeaderWriter(ClearSiteDataHeaderWriter.Directive.ALL));
        //personnalisation du lien de déconnexion
        http.logout((logout) ->
                logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                        .logoutSuccessUrl("/login?logout") //Paramétrage d'un paramètre logout dans l'url
                        .addLogoutHandler(clearSiteData)
        );

        return http.build();
    }
}
