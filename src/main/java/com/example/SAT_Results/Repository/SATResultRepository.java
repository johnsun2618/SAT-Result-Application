package com.example.SAT_Results.Repository;

import com.example.SAT_Results.Entity.SATResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SATResultRepository extends JpaRepository<SATResult, Long> {

    Optional<SATResult> findByName(String name);

}
