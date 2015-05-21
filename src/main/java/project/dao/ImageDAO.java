package project.dao;

import project.entity.Image;

import java.util.List;

/**
 * Created by Punjasin on 5/15/2015.
 */
public interface ImageDAO {
    List<Image> getImages();
    Image Get(Long id);
    Image Update(Image img);
    Image add(Image img);
    Image delete(Image img);
}
