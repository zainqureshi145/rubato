package no.rubato.controller;

import no.rubato.model.Images;
import no.rubato.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/image/")
public class ImageController {

    private  final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService){
        this.imageService = imageService;
    }

    ///Upload Media
    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestBody Images images){
        Images newImages = imageService.saveImage(images);
        return new ResponseEntity<>(newImages, HttpStatus.OK);
    }
    //Delete Image By Id
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteImage(@PathVariable("id") long id, Images images){
        Images currentImage = imageService.findBySearchId(id);
        if(currentImage == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        imageService.deleteImageById(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //List All Images
    @GetMapping("/list-all")//Show all Users from Database
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(imageService.getAll(), HttpStatus.OK);
    }
}
