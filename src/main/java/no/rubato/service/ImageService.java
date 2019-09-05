package no.rubato.service;

import no.rubato.model.Images;
import no.rubato.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
