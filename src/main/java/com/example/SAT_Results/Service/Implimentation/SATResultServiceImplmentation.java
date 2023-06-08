package com.example.SAT_Results.Service.Implimentation;

import com.example.SAT_Results.Entity.SATResult;
import com.example.SAT_Results.Repository.SATResultRepository;
import com.example.SAT_Results.Service.SATResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SATResultServiceImplmentation implements SATResultService {

    @Autowired
    SATResultRepository satResultRepository;

    @Override
    public SATResult insertSATResult(SATResult satResult)
    {

        int satScore = satResult.getSatScore();
        satResult.setPassed(satScore > 30 ? "Pass" : "Fail");
        return satResultRepository.save(satResult);

    }

    @Override
    public List<SATResult> getAllSATResults()
    {
        return satResultRepository.findAll();
    }

    @Override
    public Optional<SATResult> getRankByName(String name)
    {
        return satResultRepository.findByName(name);
    }

    @Override
    public Optional<SATResult> updateSATScoreByName(String name, int satScore)
    {

        Optional<SATResult> optionalSATResult = satResultRepository.findByName(name);
        optionalSATResult.ifPresent(satResult -> {
            satResult.setSatScore(satScore);
            satResult.setPassed(String.valueOf(satScore > 30));
            satResultRepository.save(satResult);
        });
        return optionalSATResult;

    }


    @Override
    public boolean deleteSATResultByName(String name)
    {

        Optional<SATResult> optionalSATResult = satResultRepository.findByName(name);
        if (optionalSATResult.isPresent()) {
            satResultRepository.delete(optionalSATResult.get());
            return true;
        }
        return false;

    }


}
