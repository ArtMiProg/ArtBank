package BankOfArt.service.Impl;

import BankOfArt.dto.CreditDto;
import BankOfArt.dto.DepositDto;
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
}
