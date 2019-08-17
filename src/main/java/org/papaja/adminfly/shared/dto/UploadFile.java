package org.papaja.adminfly.shared.dto;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {

    private MultipartFile file;
    private String        name;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("UploadFile{file=%s, size=%d, name='%s'}", file.getOriginalFilename(), file.getSize(), name);
    }

}
