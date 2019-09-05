package no.rubato.controller;

import no.rubato.model.Video;
import no.rubato.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/video/")
public class VideoController {

    private  final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService){
        this.videoService = videoService;
    }

    ///Upload Video
    @PostMapping("/upload")
    public ResponseEntity<?> uploadVideo(@RequestBody Video video){
        Video newVideo = videoService.saveVideo(video);
        return new ResponseEntity<>(newVideo, HttpStatus.OK);
    }
    //Delete Video By Id
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteVideo(@PathVariable("id") long id, Video video){
        Video currentVideo = videoService.findBySearchId(id);
        if(currentVideo == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        videoService.deleteVideoById(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //List All Images
    @GetMapping("/list-all")//Show all Users from Database
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(videoService.getAll(), HttpStatus.OK);
    }
}
