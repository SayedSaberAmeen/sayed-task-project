package com.sayed.saber.service;


import com.sayed.saber.config.FileUploadConfig;
import com.sayed.saber.dto.ImageDto;
import com.sayed.saber.entity.ImageEntity;
import com.sayed.saber.repository.ImageRepository;
import com.sayed.saber.util.GeneralUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ImageService {


    private final ImageRepository imageRepository;


    public String saveUser(ImageDto imageDto, MultipartFile multipartFile) throws IOException {

        if (!GeneralUtil.validCategory(imageDto.getCategory()))
            return "un valid category";

        String imageName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));

        if (!GeneralUtil.validExtension(GeneralUtil.getFileExtension(imageName)))
            return "un valid extension";

        imageDto.setImageName(imageName);

        ImageEntity imageEntity = imageRepository.save(new ImageEntity(imageDto));

        if (Objects.nonNull(imageEntity)) {

            String uploadDir = "user-photos/";

            FileUploadConfig.saveFile(uploadDir, imageName, multipartFile);
        }

        return "image added successfully";
    }

    public List<ImageDto> getAllImages() {

        if (GeneralUtil.isAdministrativeUser())
            return imageRepository.findAll().stream().map(ImageDto::new).toList();

      return null;
    }

}
