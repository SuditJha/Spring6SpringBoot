package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.College;
import com.service.CollegeService;
import com.exception.UnavailableCollegeException;

@Controller
public class CollegeController {

    @Autowired
    private CollegeService service;

    @GetMapping("/showPage")
    public String showPage(@ModelAttribute("college") College college) {
        return "showPage";
    }

    @PostMapping("/viewCollegeList")
    public String searchCollege(@ModelAttribute("college") College college, ModelMap model) throws UnavailableCollegeException {
        ArrayList<College> result = service.searchCollege(college);
        model.addAttribute("collegeList", result);
        return "viewCollegeList";
    }

    @ExceptionHandler(UnavailableCollegeException.class)
    public ModelAndView exceptionHandler(UnavailableCollegeException e) {
        ModelAndView mv = new ModelAndView("exceptionPage");
        mv.addObject("message", e.getMessage());
        return mv;
    }
}
