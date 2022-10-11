package com.github.controllers;

import com.github.dao.AgreementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agreement")
public class AgreementController {
    private final AgreementDao agreementDao;

    @Autowired
    public AgreementController(AgreementDao agreementDao) {
        this.agreementDao = agreementDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("agreement", agreementDao.index());
        return "agreement/index";
    }
}
