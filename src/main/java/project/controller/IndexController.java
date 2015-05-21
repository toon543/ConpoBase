package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by P-OniSawa on 11/5/2558.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping(value="/")
    public String index(){
        return "index";
    }

}