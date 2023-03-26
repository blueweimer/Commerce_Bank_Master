package com.example.Commerce_Bank_Back_End.config;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final RsaKeyProperties rsaKeys;

    @Autowired
    private DataSource dataSource;

    public SecurityConfiguration(RsaKeyProperties rsaKeys) {
        this.rsaKeys = rsaKeys;
    }

    @Bean
    public AuthenticationManager authManager(UserDetailsService userDetailsService){
        var authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        return new ProviderManager(authProvider);
    }

    //Hard-coding addition to MySQL Database
    //Used for testing purposes
    //TODO: Integrate a password Encryption to replace "noopPasswordEncoder"
    @Bean
    JdbcUserDetailsManager users(PasswordEncoder encoder){
        UserDetails admin = User.builder()
                .username("userThirteen")
                .password("{noop}password")
                .roles("USER")
                .build();
        System.out.println(admin.getPassword());
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
       // jdbcUserDetailsManager.createUser(admin);
        return jdbcUserDetailsManager;
    }

    //Configures server to authenticate user
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .cors(Customizer.withDefaults())//Configure cors security
                .csrf(csrf -> csrf.disable()) //disable cross-site request forgery
                .authorizeHttpRequests( auth -> auth
                        .mvcMatchers("/token").permitAll()//Authenticate using "controller/AuthController"
                        .mvcMatchers("/getId").permitAll()
                        .mvcMatchers("/getId/**").permitAll()
                        .mvcMatchers("/getUIdById/**").permitAll()
                        .mvcMatchers("/getBalanceById/**").permitAll()
                        .mvcMatchers("/getAmountById/**").permitAll()
                        .mvcMatchers("/getTypeById/**").permitAll()
                        .mvcMatchers("/getSavingsGoalById/**").permitAll()
                        .mvcMatchers("/getDateById/**").permitAll()
                        .mvcMatchers("/getTIdByUId/**").permitAll()
                        .mvcMatchers("/getBalanceByUId/**").permitAll()
                        .mvcMatchers("/getAmountByUId/**").permitAll()
                        .mvcMatchers("/getTypeByUId/**").permitAll()
                        .mvcMatchers("/getSavingsGoalByUId/**").permitAll()
                        .mvcMatchers("/getDateByUId/**").permitAll()
                        .mvcMatchers("/setSavingsGoal/**").permitAll()
                        .mvcMatchers("/updateType/**").permitAll()
                        .mvcMatchers("/updateBalance/**").permitAll()
                        .mvcMatchers("/newExpensesIncomes/**").permitAll()
                        .mvcMatchers("/getTargetBalance/**").permitAll()
                        .mvcMatchers("/displayExpensesIncomes/**").permitAll()
                        .mvcMatchers("/findDailyBalance/**").permitAll()
                        .mvcMatchers("/findOverUnder/**").permitAll()
                        .mvcMatchers("/checkGetWorks").permitAll()
                        .anyRequest().authenticated() //authorize all requests from spring
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))//disable session
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt) //Configure with token from front end to backend.
                .exceptionHandling((ex) -> ex
                        .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
                        .accessDeniedHandler(new BearerTokenAccessDeniedHandler())

                )
                .build();
    }

    //Decodes Encrypted Token to access user profile
    @Bean
    JwtDecoder jwtDecoder(){
        return NimbusJwtDecoder.withPublicKey(rsaKeys.publicKey()).build();
    }

    //Encodes profile information into token
    @Bean
    JwtEncoder jwtEncoder(){
        JWK jwk = new RSAKey.Builder(rsaKeys.publicKey()).privateKey(rsaKeys.privateKey()).build();
        JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwks);
    }

    //Connects to Front End
    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:5173"));
        configuration.setAllowedMethods(List.of("GET", "POST"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


    //BCryptPasswordEncoder
    //Doesn't function yet
    @Bean
    PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }








}
