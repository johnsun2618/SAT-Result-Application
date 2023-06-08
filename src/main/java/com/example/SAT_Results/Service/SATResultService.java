package com.example.SAT_Results.Service;

import com.example.SAT_Results.Entity.SATResult;

import java.util.List;
import java.util.Optional;


public interface SATResultService {



    public SATResult insertSATResult(SATResult satResult);

    public List<SATResult> getAllSATResults();

    public Optional<SATResult> getRankByName(String name);

    public Optional<SATResult> updateSATScoreByName(String name, int satScore);

    public boolean deleteSATResultByName(String name);



}
