package project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.entity.Activity;
import project.service.ActivityService;

import java.util.List;

/**
 * Created by Punjasin on 5/13/2015.
 */
@RestController
@RequestMapping("/")
public class ActivityController {
@Autowired
    ActivityService activityService;

    @RequestMapping(value = "activity",method = RequestMethod.GET)
    public  List<Activity> list(){
        return activityService.getActivitys();
    }



    @RequestMapping(value = "activity",method = RequestMethod.POST)
    public @ResponseBody Activity add(@RequestBody Activity activity, BindingResult bindingResult){
        return activityService.addActivity(activity);
    }

    @RequestMapping(value = "activity/{id}",method = RequestMethod.GET)
    public  Activity getActivity(@PathVariable("id") Long id){
        return activityService.getActivity(id);
    }

    @RequestMapping(value = "activity/{id}",method = RequestMethod.PUT)
    public  Activity edit(@PathVariable("id") Long id,@RequestBody Activity activity, BindingResult bindingResult){
        return activityService.updateActivity(activity);
    }

    @RequestMapping(value = "activity/{id}",method = RequestMethod.DELETE)
    public  Activity edit(@PathVariable("id") Long id){
        return activityService.deleteActivity(id);
    }
}
