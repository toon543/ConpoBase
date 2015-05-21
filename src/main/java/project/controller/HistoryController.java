package project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.entity.History;
import project.service.HistoryService;

import java.util.List;

/**
 * Created by Punjasin on 5/13/2015.
 */
@RestController
@RequestMapping("/")
public class HistoryController {
    @Autowired
    HistoryService historyService;

    @RequestMapping(value = "history",method = RequestMethod.GET)
    public List<History> list(){
        return historyService.getHistorys();
    }


    @RequestMapping(value = "history/{id}",method = RequestMethod.GET)
    public  History getHistory(@PathVariable("id") Long id){
        return historyService.getHistory(id);
    }

    @RequestMapping(value = "history/{id}",method = RequestMethod.PUT)
    public  History edit(@PathVariable("id") Long id,@RequestBody History history, BindingResult bindingResult){
        return historyService.updateHistory(history);
    }

}
