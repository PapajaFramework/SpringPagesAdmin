package org.papaja.adminfly.shared.dto;

public class FileDto {

    private UploadFile file;

    public FileDto(UploadFile file) {
        this.file = file;
    }

    public String getName() {
        return file.getName();
    }

    public Long getSize() {
        return file.getFile().getSize();
    }

    public String getOriginalName() {
        return file.getFile().getOriginalFilename();
    }

    public String getContentType() {
        return file.getFile().getContentType();
    }

}
