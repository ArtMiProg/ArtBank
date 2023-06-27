package BankOfArt.dto;

import lombok.Data;

@Data
public class UserDto {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String passwordConfirm;
}
