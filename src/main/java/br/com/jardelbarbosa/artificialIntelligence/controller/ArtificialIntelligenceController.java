package br.com.jardelbarbosa.artificialIntelligence.controller;

import br.com.jardelbarbosa.artificialIntelligence.dto.request.QuestionRequest;
import br.com.jardelbarbosa.artificialIntelligence.dto.response.QuestionResponse;
import br.com.jardelbarbosa.artificialIntelligence.service.ArtificalIntelligenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/v1/api/ai")
@RestController
public class ArtificialIntelligenceController {

    private final ArtificalIntelligenceService service;


    @PostMapping
    public QuestionResponse askAi(@RequestBody QuestionRequest request){
        return service.askAi(request);

    }
}


