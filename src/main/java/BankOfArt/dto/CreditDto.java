package BankOfArt.dto;

import lombok.Data;

@Data
public class CreditDto {
    private Integer id;
    private String title;
    private Float interestRate;
    private Integer term;
}
