package com.ex.controller.asy;

import com.ex.pojo.Person;
import com.ex.service.PersonService;
import com.ex.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Controller
public class Buy_a {

    @Resource
    private TransactionService transactionService;
    @Resource
    private PersonService personService;
    @Resource
    private HttpSession httpSession;


    @RequestMapping(value = "/api/buy" ,method = RequestMethod.POST)
    @ResponseBody
    public ModelMap Buy(int id, ModelMap map) {
        Person person = (Person) httpSession.getAttribute("user");
        transactionService.InsertTransaction(id,personService.getUserId(person.getUserName()));
        System.out.println(id+ " " + personService.getUserId(person.getUserName()));
        map.addAttribute("code", 200);
        map.addAttribute("message", "success");
        map.addAttribute("result", true);
        return map;
    }
}
