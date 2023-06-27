package BankOfArt.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "deposits")
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String title;
    @Column(name = "interest_rate")
    private Float interestRate;
    @Column
    private Integer term;
}
