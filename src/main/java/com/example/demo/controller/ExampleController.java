package com.example.demo.controller;
import com.example.demo.model.ErrorDTO;
import com.example.demo.model.Partner;
import com.example.demo.model.ResponseDTO;
import com.example.demo.service.ExampleService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partners")
@RequiredArgsConstructor
public class ExampleController {

    private final ExampleService exampleService;

    @PostMapping
    public ResponseEntity<ResponseDTO<Partner>> createPartner(@RequestBody Partner partner) {
        try {
            return ResponseEntity.status(200).body(new ResponseDTO<>(this.exampleService.savePartner(partner)));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ResponseDTO(new ErrorDTO(404, e.getMessage())));
        }
    }

    @GetMapping
    public ResponseEntity<ResponseDTO<List<Partner>>> getAllPartners() {
        try {
            return ResponseEntity.status(200).body(new ResponseDTO<>(this.exampleService.getAllPartner()));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ResponseDTO(new ErrorDTO(404, e.getMessage())));
        }
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<Partner>> getPartnerById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(200).body(new ResponseDTO<>(this.exampleService.getPartnerById(id)));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ResponseDTO(new ErrorDTO(404, e.getMessage())));
        }
    }

    @PutMapping()
    public ResponseEntity<ResponseDTO<Partner>> updatePartner(@RequestBody Partner partner) {
        try {
            return ResponseEntity.status(200).body(new ResponseDTO<>(this.exampleService.updatePartner(partner)));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ResponseDTO(new ErrorDTO(404, e.getMessage())));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO<Boolean>> deletePartner(@PathVariable Long id) {
        try {
            return ResponseEntity.status(200).body(new ResponseDTO<>(this.exampleService.deletePartner(id)));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(new ResponseDTO(new ErrorDTO(404, e.getMessage())));
        }
    }
}
