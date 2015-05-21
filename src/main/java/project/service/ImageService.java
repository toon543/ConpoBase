package project.service;

import project.entity.Image;

import java.util.List;

/**
 * Created by Punjasin on 5/15/2015.
 */
public interface ImageService {
    List<Image> getImages();
    Image getImg(Long id);
    Image Update(Image img);
    Image add(Image img);
    Image delete(Long id,Long pid);
    Image deleteHistoryImg(Long id);
}
