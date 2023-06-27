package BankOfArt.service;

import BankOfArt.dto.DepositDto;

import java.util.List;

public interface DepositService {
    List<DepositDto> getAll();
}
