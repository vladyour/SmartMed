package com.smartMed2017.controller;

import com.smartMed2017.service.LabworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vladyour on 05.06.17.
 */
@Controller
public class AllLabwork {
    private LabworkService labworkService;

    @Autowired
    @Qualifier(value = "labworkService")
    public void setLabworkService(LabworkService labworkService) {
        this.labworkService = labworkService;
    }

    @RequestMapping(value = "archive", method = RequestMethod.GET)
    public String archive(Model model) {
        model.addAttribute("labworks", labworkService.getAllLabwork());

        return "archive";
    }
}
