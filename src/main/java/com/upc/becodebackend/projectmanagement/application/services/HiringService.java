package com.upc.becodebackend.projectmanagement.application.services;

import com.upc.becodebackend.projectmanagement.domain.model.Hiring;
import com.upc.becodebackend.projectmanagement.domain.repository.HiringRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HiringService {
    private final HiringRepository hiringRepository;

    public HiringService(HiringRepository hiringRepository) {
        this.hiringRepository = hiringRepository;
    }

    public List<Hiring> getAllHirings() {
        return hiringRepository.findAll();
    }

    public Hiring createHiring(Hiring hiring) {
        return hiringRepository.save(hiring);
    }
}
