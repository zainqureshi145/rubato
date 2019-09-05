package no.rubato.service;

import no.rubato.model.Video;
import no.rubato.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("videoService")
public class VideoService {
    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository){
        this.videoRepository = videoRepository;
    }

    //Get Video by Id
    public Video getByIdVideo(long id){
        return videoRepository.getByIdVideo(id);
    }
    //Save Video
    public Video saveVideo(Video video) {
        return videoRepository.save(video);
    }
    //Delete Video
    public void deleteVideoById(long id){
        videoRepository.deleteById(id);
    }
    //Find By SearchId
    public Video findBySearchId(long id){
        return videoRepository.getByIdVideo(id);
    }
    public List<Video> getAll(){
        return videoRepository.findAll();
    }
}
