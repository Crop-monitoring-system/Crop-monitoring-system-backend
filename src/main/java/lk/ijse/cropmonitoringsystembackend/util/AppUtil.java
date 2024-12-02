package lk.ijse.cropmonitoringsystembackend.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String createCropId(){
        return "CROP-"+ UUID.randomUUID();
    }


    public static String toBase64CropPic(MultipartFile cropImage){
        String proPicBase64 = null;
        try {
            byte [] proPicBytes = cropImage.getBytes();
            proPicBase64 =  Base64.getEncoder().encodeToString(proPicBytes);
        }catch (Exception e){
            e.printStackTrace();
        }
        return proPicBase64;
    }


    public static String toBase64FieldPic1(MultipartFile fieldImage1){
        String proPicBase64 = null;
        try {
            byte [] proPicBytes = fieldImage1.getBytes();
            proPicBase64 =  Base64.getEncoder().encodeToString(proPicBytes);
        }catch (Exception e){
            e.printStackTrace();
        }
        return proPicBase64;
    }


    public static String toBase64FieldPic2(MultipartFile fieldImage2){
        String proPicBase64 = null;
        try {
            byte [] proPicBytes = fieldImage2.getBytes();
            proPicBase64 =  Base64.getEncoder().encodeToString(proPicBytes);
        }catch (Exception e){
            e.printStackTrace();
        }
        return proPicBase64;
    }






}
