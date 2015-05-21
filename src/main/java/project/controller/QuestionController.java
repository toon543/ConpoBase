package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import project.entity.QuestionAnswer;
import project.service.QuestionService;

import java.util.List;

/**
 * Created by Punjasin on 5/15/2015.
 */
@RestController
@RequestMapping("/")

public class QuestionController {
    @Autowired
    QuestionService questionService;
    @RequestMapping(value = "question",method = RequestMethod.GET)
    public List<QuestionAnswer> list(){
        return questionService.getQuestionAnswers();
    }



    @RequestMapping(value = "question",method = RequestMethod.POST)
    public @ResponseBody
    QuestionAnswer add(@RequestBody QuestionAnswer question, BindingResult bindingResult){
        return questionService.addQuestionAnswer(question);
    }

    @RequestMapping(value = "question/{id}",method = RequestMethod.GET)
    public  QuestionAnswer getQuestionAnswer(@PathVariable("id") Long id){
        return questionService.getQuestionAnswer(id);
    }

    @RequestMapping(value = "question/{id}",method = RequestMethod.PUT)
    public  QuestionAnswer edit(@PathVariable("id") Long id,@RequestBody QuestionAnswer question, BindingResult bindingResult){
        question.setNew(false);
        return questionService.updateQuestionAnswer(question);
    }

    @RequestMapping(value = "question/{id}",method = RequestMethod.DELETE)
    public  QuestionAnswer edit(@PathVariable("id") Long id){
        return questionService.deleteQuestionAnswer(id);
    }

}
