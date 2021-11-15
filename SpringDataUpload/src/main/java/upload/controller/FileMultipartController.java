package upload.controller;

import upload.model.request.FileMultipart;
import upload.model.response.MultipartUploadResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import upload.service.FileMultiPartService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileMultipartController {

    @Autowired
    private FileMultiPartService service;

    @PostMapping("/uploadFile")
    public MultipartUploadResponse uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        FileMultipart multipart = service.saveFile(file);
        String fileDownLoadUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
                .path(multipart.getId()).toUriString();
        return new MultipartUploadResponse(multipart.getFileName(), fileDownLoadUrl, file.getContentType(), file.getSize());
    }

    @GetMapping("/downloadFile/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("id") String id) throws FileNotFoundException {
        FileMultipart fileMultipart = service.getFile(id);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileMultipart.getFileType()))
                .body(new ByteArrayResource(fileMultipart.getData()));
    }

    @PostMapping("/uploadMultipleFiles")
    public List<MultipartUploadResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {

        return Arrays.stream(files).map(f -> {
            try {
                return uploadFile(f);
            } catch (IOException e) {
                //
            }
            return null;
        }).collect(Collectors.toList());
    }
}
