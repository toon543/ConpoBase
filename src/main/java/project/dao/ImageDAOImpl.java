package project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.entity.Image;
import project.repository.ImageRepository;

import java.util.List;

/**
 * Created by Punjasin on 5/15/2015.
 */
@Repository
public class ImageDAOImpl implements ImageDAO {

    @Autowired
    ImageRepository imageRepository;
    @Override
    public List<Image> getImages() {
        return imageRepository.findAll();
    }

    @Override
    public Image Get(Long id) {

        return imageRepository.findOne(id);
    }

    @Override
    public Image Update( Image img) {
        return imageRepository.save(img);
    }

    @Override
    public Image add(Image img) {
        return imageRepository.save(img);
    }

    @Override
    public Image delete(Image img) {
        imageRepository.delete(img);
        return img;
    }
}
