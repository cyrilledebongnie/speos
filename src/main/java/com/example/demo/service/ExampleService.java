package com.example.demo.service;

import com.example.demo.model.Partner;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface ExampleService {
    Partner savePartner(Partner partner);
    List<Partner> getAllPartner();
    Partner getPartnerById(Long id) throws NotFoundException;
    Partner updatePartner(Partner partner) throws NotFoundException;
    boolean deletePartner(Long id);
}
