package BankOfArt.controller;

import BankOfArt.dto.CreditDto;
import BankOfArt.dto.DepositDto;
import BankOfArt.model.entity.Credit;
import BankOfArt.model.entity.Deposit;
import BankOfArt.service.CreditService;
import BankOfArt.service.DepositService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BankManagerController {
    private final CreditService creditService;
    private final DepositService depositService;

    @GetMapping(value = "/credits")
    public List<CreditDto> credits(){
        return creditService.getAll();
    }

    @GetMapping(value="/deposits")
    public List<DepositDto> deposits(){
        return depositService.getAll();
    }

    @GetMapping(value="/creditCreate")
    public CreditDto createAcredit(){
        return new CreditDto();
    }

    @PostMapping(value="/creditCreate")
    public ResponseEntity<String> createAcredit(@RequestBody CreditDto creditDto) {
        Credit credit = creditService.createAcredit(creditDto);
        if (creditService.saveCredit(credit)) {
            return ResponseEntity.ok("The new type of credit is created");
        }else {
            return ResponseEntity.badRequest().body("Error. Try again");
        }
    }

    @GetMapping(value="/depositCreate")
    public DepositDto createAdeposit(){
        return new DepositDto();
    }

    @PostMapping(value="/depositCreate")
    public ResponseEntity<String> createAdeposit(@RequestBody DepositDto depositDto) {
        Deposit deposit = depositService.createAdeposit(depositDto);
        if (depositService.saveDeposit(deposit)) {
            return ResponseEntity.ok("The new type of deposit is created");
        }else {
            return ResponseEntity.badRequest().body("Error. Try again");
        }
    }

}
