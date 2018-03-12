package com.uru.app.model;

import java.io.Serializable;

/**
 * Created by Rahul Dev.
 */
public class FileUploadStatus implements Serializable{
    private String message;
    private boolean success;
    private String uploadLocation;
    private String uploadedFileName;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setUploadLocation(String uploadLocation) {
        this.uploadLocation = uploadLocation;
    }

    public String getUploadLocation() {
        return uploadLocation;
    }

    public void setUploadedFileName(String uploadedFileName) {
        this.uploadedFileName = uploadedFileName;
    }

    public String getUploadedFileName() {
        return uploadedFileName;
    }

    @Override
    public String toString() {
    	return "{\"uploadedFileName\":\"" + uploadedFileName +"\"}" ;
//        return "FileUploadStatus{" +
//                "message='" + message + '\'' +
//                ", success=" + success +
//                ", uploadLocation='" + uploadLocation + '\'' +
//                ", uploadedFileName='" + uploadedFileName + '\'' +
//                '}';
    }
}
