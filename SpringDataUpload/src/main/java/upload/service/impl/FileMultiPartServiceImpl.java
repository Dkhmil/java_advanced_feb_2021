package upload.service.impl;

import upload.model.request.FileMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import upload.repository.FileMultipartRepository;
import upload.service.FileMultiPartService;

import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class FileMultiPartServiceImpl implements FileMultiPartService {

    @Autowired
    private FileMultipartRepository repository;

    @Override
    public FileMultipart saveFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        return repository.save(new FileMultipart(fileName, file.getContentType(), file.getBytes()));
    }

    @Override
    public FileMultipart getFile(String fileId) throws FileNotFoundException {
        return repository.findById(fileId).orElseThrow();
    }
}
