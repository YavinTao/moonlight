/*
 * Author:  taoyang <yavintao@gmail.com>
 * Created: 2017-04-15
 */
package com.github.yavin.moonlight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

}
