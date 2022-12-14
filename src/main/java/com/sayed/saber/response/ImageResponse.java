package com.sayed.saber.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sayed.saber.dto.ImageDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageResponse {

    private String message;
    private List<ImageDto> allImages;

}
