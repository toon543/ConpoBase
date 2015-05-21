package project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.entity.Activity;
import project.repository.ActivityRepository;

import java.util.List;

/**
 * Created by Punjasin on 5/13/2015.
 */
@Repository
public class ActivityDAOImpl implements ActivityDAO {
    @Autowired
    ActivityRepository activityRepository;
    @Override
    public List<Activity> getActivitys() {
        return activityRepository.findAll();
    }



    @Override
    public Activity getActivity(Long id) {
        return activityRepository.findOne(id);
    }

    @Override
    public Activity addActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public Activity deleteActivity(Activity activity) {
        activityRepository.delete(activity);
        activity.setId(null);
        return activity;

    }

    @Override
    public Activity updateActivity(Activity activity) {
        return activityRepository.save(activity);
    }



}
