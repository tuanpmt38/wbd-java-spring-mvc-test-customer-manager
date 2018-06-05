package com.codegym.cms.controller;

import com.codegym.cms.model.Province;
import com.codegym.cms.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/provinces")
    public String showListProvince(Model model){

        Iterable<Province> provinces = provinceService.findAll();
        model.addAttribute("provinces", provinces);
        return "/province/list";
    }

    @GetMapping("/create-province")
    public String showFormProvince(Model model){

        model.addAttribute("province", new Province());
        return "/province/create";
    }

    @PostMapping("/create-province")
    public String createProvince(Province province, Model model){

        provinceService.save(province);
        model.addAttribute("message","create successfully");
        return "/province/create";
    }
}
