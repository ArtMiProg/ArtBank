package BankOfArt.service;

import BankOfArt.dto.DepositDto;
import BankOfArt.model.entity.Deposit;

import java.util.List;

public interface DepositService {
    List<DepositDto> getAll();

    Deposit createAdeposit(DepositDto depositDto);

    boolean saveDeposit(Deposit deposit);
}
