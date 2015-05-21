package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dao.ImageDAO;
import project.entity.Image;
import project.repository.ActivityRepository;
import project.repository.HistoryRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Punjasin on 5/15/2015.
 */
@Service
@Transactional
public class imageServiceImpl implements ImageService {

    @Autowired
    ImageDAO imgdao;
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    HistoryRepository historyRepository;
    @Override
    public List<Image> getImages() {
        return imgdao.getImages();
    }

    @Override
    public Image getImg(Long id) {
        return imgdao.Get(id);
    }

    @Override
    public Image Update(Image img) {
        return imgdao.Update(img);
    }

    @Override
    public Image add(Image img) {
        return imgdao.add(img);
    }

    @Override
    public Image delete(Long imgid,Long activityid) {
        activityRepository.getOne(activityid).getImages().remove(imgdao.Get(imgid));
        Image temp=imgdao.Get(imgid);

        return imgdao.delete(temp);
    }

    @Override
    public Image deleteHistoryImg(Long id) {
        historyRepository.findOne(1l).getImages().remove(imgdao.Get(id));
        Image temp=imgdao.Get(id);
        return imgdao.delete(temp);
    }
}
