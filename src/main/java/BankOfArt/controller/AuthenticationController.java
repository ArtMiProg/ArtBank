package BankOfArt.controller;

import BankOfArt.dto.JwtTokenRequestDto;
import BankOfArt.dto.JwtTokenResponseDto;
import BankOfArt.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;

    @PostMapping(value = "/authenticate")
    public JwtTokenResponseDto authenticate (@RequestBody JwtTokenRequestDto jwtTokenRequestDto){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtTokenRequestDto.getUsername(),
                    jwtTokenRequestDto.getPassword()));
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid credentials");
        }
        var token = jwtTokenUtil.generateToken(jwtTokenRequestDto.getUsername());
        return new JwtTokenResponseDto(token);

    }

}
