package project.dao;

import project.entity.History;

import java.util.List;

/**
 * Created by Punjasin on 5/13/2015.
 */
public interface HistoryDAO {
    List<History> getHistorys();


    History getHistory(Long id);
    History updateHistory(History history);
}
