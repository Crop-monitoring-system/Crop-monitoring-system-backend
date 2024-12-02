package lk.ijse.cropmonitoringsystembackend.dto;


import lk.ijse.cropmonitoringsystembackend.customObj.CropResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CropDto implements Serializable, CropResponse {

 private String code;
 private String category;
 private String commonName;  // updated to camelCase
 private String cropImage;  // updated to camelCase
 private String scientificName;  // updated to camelCase
 private String season;
 private String status;  // updated to camelCase
 private String field;


}
