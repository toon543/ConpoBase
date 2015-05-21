package project.service;

import project.entity.History;
import project.entity.Image;

import java.util.List;

/**
 * Created by Punjasin on 5/13/2015.
 */
public interface HistoryService {
    List<History> getHistorys();

    History getHistory(Long id);

    History updateHistory(History history);


    History addImage(History history, Image image);
}
