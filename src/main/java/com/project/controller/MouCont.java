package com.project.controller;




import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.project.entity.Mou;
import com.project.service.mouSer;

@Controller
public class MouCont {

    @Autowired
    private mouSer mouSer;

    @GetMapping("/mou")
    public String mouPage(Authentication authmou) {
        return "mou";
    }

    @PostMapping("/saveMou")
    public String submitForm(@RequestParam("orgnm") String orgnm,
                             @RequestParam("activitydetails") String activitydetails,
                             @RequestParam("image1") MultipartFile image1,
                             @RequestParam("image2") MultipartFile image2,
                             @RequestParam("dynamicFields") String dynamicFieldsJson) throws IOException {
        mouSer.savelogic(orgnm, activitydetails, image1, image2, dynamicFieldsJson);
        return "redirect:/mou";
    }

    @GetMapping("/viewMou")
    public String showMouData(Model model) {
        List<Mou> formDataList = mouSer.getAllFormData();
        model.addAttribute("formDataList", formDataList);
        return "viewMou";
    }

    @PostMapping("/mou/delete/{id}")
    public String deleteEntry(@PathVariable int id) {
        mouSer.deleteById(id);
        return "redirect:/viewMou";
    }
}
