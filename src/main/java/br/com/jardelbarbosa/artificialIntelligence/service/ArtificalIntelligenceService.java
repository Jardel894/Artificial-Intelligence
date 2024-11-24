package br.com.jardelbarbosa.artificialIntelligence.service;

import br.com.jardelbarbosa.artificialIntelligence.dto.request.QuestionRequest;
import br.com.jardelbarbosa.artificialIntelligence.dto.response.QuestionResponse;

public interface ArtificalIntelligenceService {

    QuestionResponse askAi(QuestionRequest request);
}
