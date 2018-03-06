package com.ex.controller.asy;

import com.ex.pojo.Person;
import com.ex.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class Login_a {

    @Resource
    private PersonService personService;
    @Resource
    private HttpSession httpSession;

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap Login( String userName, String password, ModelMap map) {
        if (personService.isUser(userName, password)) {
            map.addAttribute("code", 200);
            map.addAttribute("message", "success");
            map.addAttribute("result", true);
            Person user = personService.getUser(userName,password);
            httpSession.setAttribute("user",user);
        } else {
            map.addAttribute("code", 401);
            map.addAttribute("message", "账号密码错误");
            map.addAttribute("result", false);
        }
        return map;
    }
}


