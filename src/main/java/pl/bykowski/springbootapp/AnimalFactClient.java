package pl.bykowski.springbootapp;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class AnimalFactClient {

    @EventListener (ApplicationReadyEvent.class)
    public List<AnimalFact> getAnimalFact(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AnimalFact[]> responseEntity = restTemplate.exchange("https://cat-fact.herokuapp.com/facts/random?animal_type=dog&amount=2",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                AnimalFact[].class
        );

     /*   System.out.println("Status code " + responseEntity.getStatusCodeValue());
        Arrays.stream(responseEntity.getBody()).forEach(System.out::println);*/

        return Arrays.asList(responseEntity.getBody());
    }



}
