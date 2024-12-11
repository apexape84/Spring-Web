package com.ohgiraffers.fileupload;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileController {
    @Autowired
    private ResourceLoader resourceLoader;

    @PostMapping("single-file")
    public String singleFile(@RequestParam MultipartFile singleFile, String description,
                             Model model) throws IOException {
        System.out.println("singleFile = " + singleFile);
        System.out.println("description = " + description);

        Resource resource = resourceLoader.getResource("classpath:static/img/single");

        String filePath = null;

        if(!resource.exists()) {
            String root = "src/main/resources/static/img/single";
            File file = new File(root);
            file.mkdirs();

            filePath = file.getAbsolutePath();
        } else {
            filePath = resourceLoader.getResource("classpath:static/img/single").getFile().getAbsolutePath();
        }

        String originFileName = singleFile.getOriginalFilename();
        System.out.println("originFileName = " + originFileName);
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        System.out.println("ext = " + ext);

        String savedName = UUID.randomUUID().toString().replace("-","") + ext;

        singleFile.transferTo(new File(filePath + "/" + savedName));

        model.addAttribute("message", "File uploaded successfully!");
        model.addAttribute("fileName", originFileName);
        return "result";
    }

    @PostMapping("multi-file")
    public String multiFile(@RequestParam List<MultipartFile> multiFile, String description,Model model) throws IOException {

        Resource resource = resourceLoader.getResource("classpath:static/img/multi");

        String filePath = null;

        if(!resource.exists()) {
            String root = "src/main/resources/static/img/multi";
            File file = new File(root);
            file.mkdirs();

            filePath = file.getAbsolutePath();
        } else {
            filePath = resourceLoader.getResource("classpath:static/img/multi").getFile().getAbsolutePath();
        }
        List<FileDTO> files = new ArrayList<>();
        List<String> savedFiles = new ArrayList<>();

        for(MultipartFile file : multiFile) {
            String originFileName = file.getOriginalFilename();
            String ext = originFileName.substring(originFileName.lastIndexOf("."));
            String savedName = UUID.randomUUID().toString().replace("-","") + ext;

            files.add(new FileDTO(originFileName, savedName, filePath, description));
            file.transferTo(new File(filePath + "/" + savedName));
            savedFiles.add("static/img/multi/" + savedName);
        }

        model.addAttribute("message", "File uploaded successfully!");
        model.addAttribute("imgs", savedFiles);

        return "result";
    }
}
