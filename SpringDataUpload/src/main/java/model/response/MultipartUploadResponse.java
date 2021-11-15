package model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultipartUploadResponse {

    private String fileName;
    private String downloadUrl;
    private String fileType;
    private long size;

    public MultipartUploadResponse(String fileName, String downloadUrl, String fileType, long size) {
        this.fileName = fileName;
        this.downloadUrl = downloadUrl;
        this.fileType = fileType;
        this.size = size;
    }
}
