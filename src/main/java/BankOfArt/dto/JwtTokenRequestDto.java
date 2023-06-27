package BankOfArt.dto;

import lombok.Data;

@Data
public class JwtTokenRequestDto {
    private String username;
    private String password;
}
