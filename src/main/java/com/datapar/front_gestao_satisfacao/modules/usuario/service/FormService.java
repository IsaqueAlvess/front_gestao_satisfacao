package com.datapar.front_gestao_satisfacao.modules.usuario.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.datapar.front_gestao_satisfacao.modules.usuario.entity.Form;

@Service
public class FormService {
    
    public String execute(Form form){
        
        RestTemplate rt = new RestTemplate();
        
        try {
            // Validar os dados do formulário (exemplo básico)
            if ((!form.getEmail().equals("")) || form.getPontuacao() == null) {
                throw new IllegalArgumentException("Email e pontuação são obrigatórios");
            }

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, String> data = new HashMap<>();
            data.put("email", form.getEmail());
            data.put("pontuacao", form.getPontuacao().toString());
            data.put("observacoes", form.getObservacoes());
            data.put("contato", form.getContato());

            HttpEntity<Map<String, String>> request = new HttpEntity<>(data, headers);

            Form response = rt.postForObject("http://localhost:8080/avaliacao/", request, Form.class);

            // Log de sucesso
            System.out.println("Formulário submetido com sucesso! ID da avaliação: {}"+ response.getClass());

            return "Formulário submetido com sucesso!";
        } catch (Exception e) {
            // Log do erro
            e.printStackTrace();
            return "Erro ao submeter formulário";
        }
    }
}

