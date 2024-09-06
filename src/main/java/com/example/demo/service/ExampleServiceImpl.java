package com.example.demo.service;

import com.example.demo.model.Partner;
import com.example.demo.repository.PartnerRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.time.Instant;
import java.util.List;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExampleServiceImpl implements ExampleService {

    private final PartnerRepository partnerRepository;
    private static final String CANNOT_BE_NULL = "cannot be null";
    private static final String CANNOT_BE_EMPTY = "cannot be empty";
    private void checkPartner(Partner partner){
        if(partner.getCompanyName() == null){
            throw new InvalidParameterException("partner not found");
        }
    }

    private void validateCustomerCreation(Partner partner) {
        if (partner.getCompanyName() == null) {
            throw new InvalidParameterException("companyName: %s".formatted(CANNOT_BE_NULL));
        } else if (partner.getCompanyName().isEmpty()) {
            throw new InvalidParameterException("companyName: %s".formatted(CANNOT_BE_EMPTY));
        }

        if (partner.getExpires() == null) {
            throw new InvalidParameterException("expires: %s".formatted(CANNOT_BE_NULL));
        } else if (partner.getExpires().toInstant().isBefore(Instant.now())) {
            throw new InvalidParameterException("expires: %s".formatted("invalid time"));
        }

        if (partner.getRef() == null) {
            throw new InvalidParameterException("ref: %s".formatted(CANNOT_BE_NULL));
        } else if (partner.getRef().isEmpty()) {
            throw new InvalidParameterException("ref: %s".formatted(CANNOT_BE_EMPTY));
        }
    } 
    
    // Create a new partner
    @Override
    public Partner savePartner(Partner partner) {
        validateCustomerCreation(partner);
        this.checkPartner(partner);
        return partnerRepository.save(partner);
    }

    // Get all partners
    @Override
    public List<Partner> getAllPartner() {
        return partnerRepository.findAll();
    }

    // Get a partner by ID
    @Override
    public Partner getPartnerById(Long id) throws NotFoundException {
        return partnerRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    // Update an existing partner
    @Override
    public Partner updatePartner(Partner partner) throws NotFoundException {
        partnerRepository.findById(partner.getId()).orElseThrow(NotFoundException::new);
        return savePartner(partner);
    }

    // Delete a partner by ID
    @Override
    public boolean deletePartner(Long id) {
        Optional<Partner> partner = partnerRepository.findById(id);
        if (partner.isPresent()) {
            partnerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
