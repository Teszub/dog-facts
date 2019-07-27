package pl.bykowski.springbootapp;


import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class DogImageClient {

    /*@EventListener(ApplicationReadyEvent.class)   to jest po to aby sprawdzic czy dobrze dziala - do tego mozna dodać system.out aby zobaczyc na konsoli*/
    public String getDogImage(){
        RestTemplate restTemplate = new RestTemplate();
        JsonNode jsonNode = restTemplate.getForObject("https://random.dog/woof.json", JsonNode.class);
        return jsonNode.get("url").asText();

    }




}
