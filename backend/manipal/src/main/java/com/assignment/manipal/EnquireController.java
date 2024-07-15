package com.assignment.manipal;

import com.assignment.manipal.entity.EnquireEntity;
import jakarta.validation.Valid;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EnquireController {
    private final EnquireRepo enquireRepo;

    public EnquireController(EnquireRepo enquireRepo) {
        this.enquireRepo = enquireRepo;
    }

    @PostMapping("/savedata")
    public ResponseEntity<?> saveData(@Valid @RequestBody EnquireEntity enquireEntity){
        try {
            enquireRepo.save(enquireEntity);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
