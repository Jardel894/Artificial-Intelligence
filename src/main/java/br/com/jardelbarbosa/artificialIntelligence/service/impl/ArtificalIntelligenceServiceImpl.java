package br.com.jardelbarbosa.artificialIntelligence.service.impl;

import br.com.jardelbarbosa.artificialIntelligence.client.ArtificialIntelligenceClient;
import br.com.jardelbarbosa.artificialIntelligence.dto.request.QuestionRequest;
import br.com.jardelbarbosa.artificialIntelligence.dto.response.QuestionResponse;
import br.com.jardelbarbosa.artificialIntelligence.service.ArtificalIntelligenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArtificalIntelligenceServiceImpl implements ArtificalIntelligenceService {

    private final ArtificialIntelligenceClient artificialInteligence;

    @Override
    public QuestionResponse askAi(QuestionRequest questionRequest) {
        String prompt = String.format("você é um especialista de tecnologia e responde apenas perguntas relacionadas a tecnologia. " +
                "Para qualquer outra pergunta, apenas responda 'Não possuo essa informação.'." +
                "A seguir as questões do usuário: %s", questionRequest.getQuestion() );

        String response = artificialInteligence.askAi(prompt);

        return new QuestionResponse(response);
    }


}
