package com.github.controllers;

import com.github.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {

    private final ClientDao clientDao;


    @Autowired
    public ClientController(ClientDao clientDao) {
        this.clientDao = clientDao;
    }


    @GetMapping()
    public String index(Model model) {
        model.addAttribute("client", clientDao.index());
        return "client/index";
    }
}
