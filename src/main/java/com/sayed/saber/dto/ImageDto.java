package com.sayed.saber.dto;

import com.sayed.saber.entity.ImageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {

    private String description;
    private String category;
    private String imageName;

    public ImageDto(ImageEntity entity) {

        this.description = entity.getDescription();
        this.category = entity.getCategory();
        this.imageName = entity.getImageName();
    }

    public ImageDto(String description, String category) {
        this.description = description;
        this.category = category;
    }
}
