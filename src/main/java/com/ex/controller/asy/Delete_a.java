package com.ex.controller.asy;

import com.ex.service.ContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class Delete_a {
    @Resource
    private ContentService contentService;
    @Resource
    private HttpSession httpSession;

    @RequestMapping(value = "/api/delete" , method = RequestMethod.POST)
    @ResponseBody
    public ModelMap Delete(int id, ModelMap map) {
        if(contentService.getContent(id) != null && httpSession.getAttribute("user") != null){
            contentService.deleteContent(id);
            map.addAttribute("code", 200);
            map.addAttribute("message", "success");
            map.addAttribute("result", true);
        }else{
            map.addAttribute("code", 402);
            map.addAttribute("message", "操作失败");
            map.addAttribute("result", false);
        }
        return map;
    }

}
