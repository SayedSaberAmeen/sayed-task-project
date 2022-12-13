package com.sayed.saber.controller;


import com.sayed.saber.dto.ImageDto;
import com.sayed.saber.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload-picture")
@RequiredArgsConstructor
public class ImageController {

   private final ImageService service ;

    @PostMapping(value = "/save",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveUser(
                                           @RequestParam("image") MultipartFile multipartFile,
                                           @RequestParam("description") String  description,
                                           @RequestParam("category") String category) throws IOException {


     return ResponseEntity.ok().body(service.saveUser(new ImageDto(description,category) ,multipartFile));
    }



}
