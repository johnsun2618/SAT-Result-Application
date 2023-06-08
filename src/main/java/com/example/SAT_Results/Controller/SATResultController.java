package com.example.SAT_Results.Controller;

import com.example.SAT_Results.Entity.SATResult;
import com.example.SAT_Results.Service.Implimentation.SATResultServiceImplmentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sat-results")
public class SATResultController {


    @Autowired
    SATResultServiceImplmentation satResultServiceImplmentation;



//    1. Insert data - First API
    @PostMapping
    public SATResult insertSATResult(@RequestBody SATResult satResult)
    {

        return satResultServiceImplmentation.insertSATResult(satResult);

    }



//    2. View all data - Second API
    @GetMapping
    public List<SATResult> getAllSATResults()
    {

        return satResultServiceImplmentation.getAllSATResults();

    }



//    3. Get rank - Third API
    @GetMapping("/{name}")
    public ResponseEntity<SATResult> getRankByName(@PathVariable String name)
    {

        Optional<SATResult> optionalSATResult = satResultServiceImplmentation.getRankByName(name);
        return optionalSATResult.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }



//    4. Update score - Forth API
    @PutMapping("/{name}")
    public ResponseEntity<SATResult> updateSATScoreByName(@PathVariable String name,
                                                          @RequestParam int satScore)
    {
        Optional<SATResult> optionalSATResult = satResultServiceImplmentation.updateSATScoreByName(name, satScore);
        return optionalSATResult.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }



//    5. Delete one record - Fifth API
    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteSATResultByName(@PathVariable String name)
    {

        boolean deleted = satResultServiceImplmentation.deleteSATResultByName(name);
        if (deleted) {
            return ResponseEntity.ok("Record deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
