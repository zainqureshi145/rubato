package no.rubato.service;

import no.rubato.model.Images;
import no.rubato.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("imageService")
public class ImageService {
    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }

    //Get Image by Id
    public Images getByIdImage(long id){
        return imageRepository.getByIdImage(id);
    }
    //Save Images
    public Images saveImage(Images images) {
            return imageRepository.save(images);
    }
    //Delete Images
    public void deleteImageById(long id){
        imageRepository.deleteById(id);
    }
    //Find By SearchId
    public Images findBySearchId(long id){
        return imageRepository.getByIdImage(id);
    }
    //List all
    public List<Images> getAll(){
        return imageRepository.findAll();
    }
}
