package upload.service;

import upload.model.request.FileMultipart;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileMultiPartService {

    FileMultipart saveFile(MultipartFile file) throws IOException;

    FileMultipart getFile(String fileId) throws FileNotFoundException;
}
