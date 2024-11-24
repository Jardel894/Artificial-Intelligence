package br.com.jardelbarbosa.artificialIntelligence.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@Component
public class ArtificialIntelligenceImpl implements ArtificialIntelligenceClient {


    @Value("${spring.ai.ollama.base-url}")
    private String baseUrl;

    @Value("${spring.ai.ollama.model}")
    private String model;

    private final RestTemplate restTemplate;

    @Override
    public String askAi(String prompt) {
        try {
        String url = String.format("%s/generate", baseUrl);

        Map<String, Object> request = new HashMap<>();
        request.put("model", model);
        request.put("prompt", prompt);
        request.put("stream", false);

        String response = restTemplate.postForObject(url, request, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(response);
            return root.get("response").asText();

        } catch (HttpClientErrorException e) {
            log.error(e);
            throw e;
        } catch (Exception e){
            log.error(e);
            throw new RuntimeException(e);
        }

    }
}
