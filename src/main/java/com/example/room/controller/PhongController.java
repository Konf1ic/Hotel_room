package com.example.room.controller;

import com.example.room.model.Phong;
import com.example.room.service.PhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/phongs")
public class PhongController {
    @Autowired
    private PhongService phongService;

    @GetMapping()
    public String showAllPhongs(Model model) {
        List<Phong> phongs = phongService.getAllPhongs();
        model.addAttribute("phongs", phongs);
        return "listPhong";
    }

    @GetMapping("/add-phong")
    public String showAddPhongForm(Model model) {
        Phong phong = new Phong();
        model.addAttribute("phong", phong);
        return "createPhong";
    }

    @GetMapping("/edit/{id}")
    public String showEditPhongForm(@PathVariable Long id, Model model) {
        model.addAttribute("phong", phongService.findPhongById(id));
        return "editPhong";
    }

    @GetMapping("/details/{id}")
    public String showPhongDetails(@PathVariable Long id, Model model) {
        model.addAttribute("phong", phongService.findPhongById(id));
        return "detailsPhong";
    }

    @GetMapping("/search")
    public String searchPhong(@RequestParam("name") String name, @RequestParam("price") double price, Model model) {
        List<Phong> phongs = new ArrayList<>();

        if (!name.isEmpty()) {
            phongs.addAll(phongService.searchPhongByName(name));
        }

        if (price > 0) {
            phongs.addAll(phongService.searchPhongByPrice(price));
        }

        model.addAttribute("phongs", phongs);
        return "listPhong";
    }

    @PostMapping("/create")
    public String createPhong(@ModelAttribute Phong phong) {
        phongService.createPhong(phong);
        return "redirect:/phongs";
    }

    @PostMapping("/update")
    public String updatePhong(@ModelAttribute Phong phong) {
        phongService.updatePhong(phong);
        return "redirect:/phongs";
    }

    @GetMapping("/delete/{id}")
    public String deletePhong(@PathVariable Long id) {
        phongService.deletePhongById(id);
        return "redirect:/phongs";
    }
}