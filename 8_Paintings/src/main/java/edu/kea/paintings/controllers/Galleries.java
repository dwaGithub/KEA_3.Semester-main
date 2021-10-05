package edu.kea.paintings.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.kea.paintings.models.Artist;
import edu.kea.paintings.models.Gallery;
import edu.kea.paintings.repositories.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Galleries {

    @Autowired
    GalleryRepository galleries;

    //Getting all Galleries
    @GetMapping("/galleries")
    Iterable<Gallery> getGalleries() {
        return galleries.findAll();
    }
    //Getting a artist by id
    @GetMapping("/galleries/{id}")
    public Gallery getGalleryById(@PathVariable Long id) {
        return galleries.findById(id).get();
    }
    //Add's an artist using post
    @PostMapping("/galleries")
    public Gallery addGallery(@RequestBody Gallery newGallery) {
        return galleries.save(newGallery);
    }

    @PutMapping("/galleries/{id}")
    public String updateGalleryById(@PathVariable Long id, @RequestBody Gallery galleryToUpdateWith){
        if(galleries.existsById(id)){
            galleryToUpdateWith.setId(id);
            galleries.save(galleryToUpdateWith);
            return "Gallery was created";
        } else {
            return "Gallery not found";
        }
    }

    //Updates an artists by id
    @PatchMapping("/galleries/{id}")
    public String patchGalleryById(@PathVariable Long id, @RequestBody Gallery galleryToUpdateWith){
        return galleries.findById(id).map(foundGallery -> {
            if(galleryToUpdateWith.getOwner() != null) foundGallery.setOwner(galleryToUpdateWith.getOwner());
            if(galleryToUpdateWith.getName() != null) foundGallery.setName(galleryToUpdateWith.getName());
            if(galleryToUpdateWith.getLocation() != null) foundGallery.setLocation(galleryToUpdateWith.getLocation());
            if(galleryToUpdateWith.getSquareFeet() != 0) foundGallery.setSquareFeet(galleryToUpdateWith.getSquareFeet());

            galleries.save(foundGallery);
            return "Gallery updated";
        }).orElse("Gallery now found");
    }

    //Delete an artists by id.
    @DeleteMapping("/galleries/{id}")
    public void deleteGalleryById(@PathVariable Long id){
        galleries.deleteById(id);
    }
}
