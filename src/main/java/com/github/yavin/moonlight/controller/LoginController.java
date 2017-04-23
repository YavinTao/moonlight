/*
 * Author:  taoyang <yavintao@gmail.com>
 * Created: 2017-04-23
 */
package com.github.yavin.moonlight.controller;

import com.github.yavin.moonlight.po.User;
import com.github.yavin.moonlight.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(value = "/login")
    public ModelAndView login(String username, String password, ModelAndView mv, HttpSession session) {
        User user = userService.login(username, password);

        if (user != null) {
            session.setAttribute("user", user);
            mv.setView(new RedirectView("/index"));
        } else {
            mv.addObject("message", "login failed");
            mv.setViewName("/admin/login");
        }

        return mv;
    }

    @RequestMapping(value = "/index")
    public String index(HttpSession session) {
        if (session != null && session.getAttribute("user") != null) {
            return "/admin/index";
        } else {
            return "/admin/login";
        }
    }


}
