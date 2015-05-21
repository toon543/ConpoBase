package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import project.entity.Activity;
import project.entity.Image;
import project.service.ActivityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Iterator;

/**
 * Created by Punjasin on 5/13/2015.
 */
@Controller
@RequestMapping("/activityImage")
public class ActivityImageController {
    @Autowired
    ActivityService activityService;
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Activity addImage(HttpServletRequest request,
                            HttpServletResponse
                                    response,@RequestParam("activityid")Long activityId){
        MultipartHttpServletRequest mRequest;
        Activity activity = activityService.getActivity(activityId);
        try{
            mRequest = (MultipartHttpServletRequest)request;
            Iterator<String> itr= mRequest.getFileNames();
            while(itr.hasNext()){
                MultipartFile multipartFile = mRequest.getFile(itr.next());
                Image image = new Image();
                image.setFileName(multipartFile.getName());
                image.setContentType(multipartFile.getContentType());
                image.setContent(multipartFile.getBytes());;
                image.setCreated(Calendar.getInstance().getTime());
                activityService.addImage(activity,image);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return activity;
    }
}


