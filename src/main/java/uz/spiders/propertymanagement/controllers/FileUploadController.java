package uz.spiders.propertymanagement.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.spiders.propertymanagement.dto.requestDTO.FileUploadDTO;
import uz.spiders.propertymanagement.dto.responseDTO.FileUploadResponseDTO;
import uz.spiders.propertymanagement.services.FileUploadService;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/files")
public class FileUploadController {
    private final FileUploadService fileUploadService;

    @PostMapping
    public FileUploadResponseDTO upload(@ModelAttribute FileUploadDTO fileUploadDTO) {
        return fileUploadService.upload(fileUploadDTO);
    }
}
