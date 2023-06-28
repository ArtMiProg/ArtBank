package BankOfArt.service.Impl;

import BankOfArt.dto.CreditDto;
import BankOfArt.dto.DepositDto;
import BankOfArt.model.entity.Credit;
import BankOfArt.model.entity.Deposit;
import BankOfArt.model.repository.DepositRepository;
import BankOfArt.service.DepositService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepositServiceImpl implements DepositService {

    private final DepositRepository depositRepository;

    @Override
    public List<DepositDto> getAll() {
        var deposits = depositRepository.findAll();
        var depositDtos = new ArrayList<DepositDto>();

        deposits.forEach(deposit -> {
            var depositDto = new DepositDto();
            depositDto.setId(deposit.getId());
            depositDto.setTitle(deposit.getTitle());
            depositDto.setInterestRate(deposit.getInterestRate());
            depositDto.setTerm(deposit.getTerm());
            depositDtos.add(depositDto);
        });
        return depositDtos;
    }

    @Override
    public Deposit createAdeposit(DepositDto depositDto){
        var deposit = new Deposit();
        deposit.setId(depositDto.getId());
        deposit.setTitle(depositDto.getTitle());
        deposit.setInterestRate(depositDto.getInterestRate());
        deposit.setTerm(depositDto.getTerm());
        return deposit;
    }

    @Override
    public boolean saveDeposit(Deposit deposit) {
        return true;
    }
}
