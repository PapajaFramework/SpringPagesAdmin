package org.papaja.adminfly.controller.shared;

import org.papaja.adminfly.dto.shared.FileDto;
import org.papaja.adminfly.dto.shared.UploadFile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @RequestMapping(value = "/process", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public FileDto upload(@ModelAttribute UploadFile file) {
        return new FileDto(file);
    }

}
