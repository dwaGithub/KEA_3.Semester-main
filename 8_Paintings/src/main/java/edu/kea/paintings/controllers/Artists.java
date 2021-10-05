package edu.kea.paintings.controllers;

import edu.kea.paintings.models.Artist;
import edu.kea.paintings.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Artists {

    @Autowired
    ArtistRepository artists;

    //Getting all Artists
    @GetMapping("/artists")
    Iterable<Artist> getArtists() {
        return artists.findAll();
    }
    //Getting a artist by id
    @GetMapping("/artists/{id}")
    public Artist getArtistById(@PathVariable Long id) {
        return artists.findById(id).get();
    }
    //Add's an artist using post
    @PostMapping("/artists")
    public Artist addArtist(@RequestBody Artist newArtist) {
        return artists.save(newArtist);
    }

    @PutMapping("/artists/{id}")
    public String updateArtistById(@PathVariable Long id, @RequestBody Artist artistToUpdateWith){
        if(artists.existsById(id)){
            artistToUpdateWith.setId(id);
            artists.save(artistToUpdateWith);
            return "Artist was created";
        } else {
            return "Artist not found";
        }
    }

    //Updates an artists by id
    @PatchMapping("/artists/{id}")
    public String patchArtistById(@PathVariable Long id, @RequestBody Artist artistToUpdateWith){
        return artists.findById(id).map(foundArtist -> {
            if(artistToUpdateWith.getName() != null) foundArtist.setName(artistToUpdateWith.getName());
            if(artistToUpdateWith.getAge() !=0) foundArtist.setAge(artistToUpdateWith.getAge());
            if(artistToUpdateWith.getNationality() != null) foundArtist.setNationality(artistToUpdateWith.getNationality());
            if(artistToUpdateWith.getPrimaryStyle() != null) foundArtist.setPrimaryStyle(artistToUpdateWith.getPrimaryStyle());
            if(artistToUpdateWith.getBirthDate() != null) foundArtist.setBirthDate(artistToUpdateWith.getBirthDate());
            if(artistToUpdateWith.getGender() != null) foundArtist.setGender(artistToUpdateWith.getGender());

            artists.save(foundArtist);
            return "Artist updated";
        }).orElse("Artist now found");
    }

    //Delete an artists by id.
    @DeleteMapping("/artists/{id}")
    public void deleteArtistById(@PathVariable Long id){
        artists.deleteById(id);
    }
}