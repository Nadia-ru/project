package com.github.controllers;

import com.github.dao.ApplicationDao;
import com.github.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/application")
public class ApplicationController {
    private final ApplicationDao applicationDao;


    @Autowired
    public ApplicationController(ApplicationDao applicationDao) {
        this.applicationDao = applicationDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("application", applicationDao.index());
        return "application/index";
    }
}
