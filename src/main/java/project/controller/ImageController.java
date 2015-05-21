package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import project.entity.Image;
import project.service.ActivityService;
import project.service.ImageService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Punjasin on 5/15/2015.
 */
@RestController
public class ImageController {
    @Autowired
    ImageService imageService;
    ActivityService activityService;
    @RequestMapping(value = "imgcontrol/{id}/{imgid}",method = RequestMethod.DELETE)
    public Image deleteimage(@PathVariable("id") Long id,@PathVariable("imgid") long imgid){


        return imageService.delete(imgid,id);
    }
    @RequestMapping(value = "historycontrol/{imgid}",method = RequestMethod.DELETE)
    public Image deletehistoryimage(@PathVariable("imgid") Long imgid){


        return imageService.deleteHistoryImg(imgid);
    }
}
