package lk.ijse.cropmonitoringsystembackend.dto;


import lk.ijse.cropmonitoringsystembackend.customObj.MonitoringLogResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MonitoringLogDto implements Serializable , MonitoringLogResponse {

    private String mCode;
    private String mDate;
    private String observation;
    private String observedImage;

    private String field;
    private String staff;
    private String crop;
}
