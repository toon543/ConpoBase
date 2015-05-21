package project.dao;

import project.entity.Activity;

import java.util.List;

/**
 * Created by Punjasin on 5/13/2015.
 */
public interface ActivityDAO {
    List<Activity> getActivitys();

    Activity getActivity(Long id);
    Activity addActivity(Activity activity);
    Activity deleteActivity(Activity activity);
    Activity updateActivity(Activity activity);
}
