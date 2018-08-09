package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

// import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {
    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/")
    public String singleFileUpload(@RequestParam("fileid") String fileid,
                                   @RequestParam("description") String description,
                                   @RequestParam("thefile") MultipartFile file,
                                   ModelMap map) {

        if (file.isEmpty()) {
            map.addAttribute("message", "Please select a file to upload");
            return "uploadstatus";
        }

        try {
            byte[] bytes = file.getBytes();
            String content = new String(bytes);
            map.addAttribute("fileid", fileid);
            map.addAttribute("description", description);
            map.addAttribute("file", content);
            map.addAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "uploadstatus";
    }

}
