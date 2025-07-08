package com.upc.becodebackend.projectmanagement.api;

import com.upc.becodebackend.projectmanagement.api.resources.CreateHiringResource;
import com.upc.becodebackend.projectmanagement.application.services.HiringService;
import com.upc.becodebackend.projectmanagement.domain.model.Hiring;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hirings")
public class HiringController {
    private final HiringService hiringService;

    public HiringController(HiringService hiringService) {
        this.hiringService = hiringService;
    }

    @GetMapping
    public List<Hiring> getAllHirings() {
        return hiringService.getAllHirings();
    }

    @PostMapping
    public Hiring createHiring(@RequestBody CreateHiringResource resource) {
        Hiring hiring = new Hiring();
        hiring.setProjectId(resource.getProjectId());
        hiring.setUserId(resource.getUserId());
        hiring.setStatus(resource.getStatus());
        return hiringService.createHiring(hiring);
    }
}
