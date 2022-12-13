package com.sayed.saber.entity;

import com.sayed.saber.dto.ImageDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "images")
@Data
@ToString
@NoArgsConstructor
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private String category;

    @Column(name = "image_name")
    private String imageName;

    public ImageEntity(ImageDto dto) {

        this.description = dto.getDescription();
        this.category = dto.getCategory();
        this.imageName = dto.getImageName();
    }
}
