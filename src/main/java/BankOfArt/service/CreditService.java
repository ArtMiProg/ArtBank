package BankOfArt.service;

import BankOfArt.dto.CreditDto;
import BankOfArt.model.entity.Credit;
import BankOfArt.model.entity.User;

import java.util.List;

public interface CreditService {
    List<CreditDto> getAll();

    Credit createAcredit(CreditDto creditDto);

    boolean saveCredit(Credit credit);
}
