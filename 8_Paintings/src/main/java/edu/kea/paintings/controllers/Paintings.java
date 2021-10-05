package edu.kea.paintings.controllers;


import edu.kea.paintings.models.Painting;
import edu.kea.paintings.repositories.PaintingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Paintings {

    @Autowired
    PaintingRepository paintings;

    //Getting all Paintings
    @GetMapping("/paintings")
    Iterable<Painting> getPaintings() {
        return paintings.findAll();
    }
    //Getting a painting by id
    @GetMapping("/paintings/{id}")
    public Painting getPaintingById(@PathVariable Long id) {
        return paintings.findById(id).get();
    }
    //Add's a painting using post
    @PostMapping("/paintings")
    public Painting addPainting(@RequestBody Painting newPainting) {
        return paintings.save(newPainting);
    }

    @PutMapping("/paintings/{id}")
    public String updatePaintingById(@PathVariable Long id, @RequestBody Painting paintingToUpdateWith){
        if(paintings.existsById(id)){
            paintingToUpdateWith.setId(id);
            paintings.save(paintingToUpdateWith);
            return "Painting was created";
        } else {
            return "Painting not found";
        }
    }

    //Updates a painting by id
    @PatchMapping("/paintings/{id}")
    public String patchPaintingById(@PathVariable Long id, @RequestBody Painting paintingToUpdateWith){
        return paintings.findById(id).map(foundPainting -> {
            if(paintingToUpdateWith.getArtist() != null) foundPainting.setArtist(paintingToUpdateWith.getArtist());
            if(paintingToUpdateWith.getPrice() != 0) foundPainting.setPrice(paintingToUpdateWith.getPrice());
            if(paintingToUpdateWith.getTitle() != null) foundPainting.setTitle(paintingToUpdateWith.getTitle());
            if(paintingToUpdateWith.getGenre() != null) foundPainting.setGenre(paintingToUpdateWith.getGenre());
            if(paintingToUpdateWith.getPrice() != 0) foundPainting.setPrice(paintingToUpdateWith.getPrice());

            paintings.save(foundPainting);
            return "Painting updated";
        }).orElse("Painting not found");
    }

    //Delete an artists by id.
    @DeleteMapping("/paintings/{id}")
    public void deletePaintingById(@PathVariable Long id){
        paintings.deleteById(id);
    }
}
