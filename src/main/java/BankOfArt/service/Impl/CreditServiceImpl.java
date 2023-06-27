package BankOfArt.service.Impl;

import BankOfArt.dto.CreditDto;
import BankOfArt.model.entity.Credit;
import BankOfArt.model.entity.User;
import BankOfArt.model.repository.CreditRepository;
import BankOfArt.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;

    @Override
    public List<CreditDto> getAll() {
        var credits = creditRepository.findAll();
        var creditDtos = new ArrayList<CreditDto>();

        credits.forEach(credit -> {
            var creditDto = new CreditDto();
            creditDto.setId(credit.getId());
            creditDto.setTitle(credit.getTitle());
            creditDto.setInterestRate(credit.getInterestRate());
            creditDto.setTerm(credit.getTerm());
            creditDtos.add(creditDto);

        });
        return creditDtos;
    }

    @Override
    public Credit createAcredit(CreditDto creditDto){
        var credit = new Credit();
        credit.setId(creditDto.getId());
        credit.setTitle(creditDto.getTitle());
        credit.setInterestRate(creditDto.getInterestRate());
        credit.setTerm(creditDto.getTerm());
        return credit;
    }

    @Override
    public boolean saveCredit(Credit credit) {
        return true;
    }
}
