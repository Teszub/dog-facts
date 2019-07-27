package pl.bykowski.springbootapp;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("animal")
public class AnimalFactGui extends VerticalLayout {

    private AnimalFactClient animalFactClient;
    private DogImageClient dogImageClient;

    @Autowired
    public AnimalFactGui(AnimalFactClient animalFactClient, DogImageClient dogImageClient) {
        TextField textField = new TextField("Lista faktów o zwierzetach");

        this.animalFactClient = animalFactClient; /* to dodoane aby byl autowired*/
        this.dogImageClient = dogImageClient;

        Grid<AnimalFact> grid = new Grid<>(AnimalFact.class);
        /* AnimalFactClient animal1 = new AnimalFactClient(); stare bo jest autowired to niepotrzebne*/
        grid.setItems(animalFactClient.getAnimalFact());
        grid.addColumn(new ComponentRenderer<>(dog -> {
            Image image = new Image(dogImageClient.getDogImage(), "brak");
            return image;
        })).setHeader("Image");

        Label label = new Label();
        grid.setHeight("5000px");

        label.setText(textField.getValue() + grid.toString());
        grid.removeColumnByKey("used");
        grid.removeColumnByKey("id");
        grid.removeColumnByKey("source");
        grid.removeColumnByKey("deleted");
        grid.removeColumnByKey("user");
        grid.removeColumnByKey("updatedAt");
        grid.removeColumnByKey("createdAt");
        grid.removeColumnByKey("type");
        grid.removeColumnByKey("v");
        grid.removeColumnByKey("additionalProperties");



        add(textField, grid);
    }


}
