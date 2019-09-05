package no.rubato.repository;

import no.rubato.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
    Video getByIdVideo(long idVideo);
    //Images findByImageName(String name);

}
