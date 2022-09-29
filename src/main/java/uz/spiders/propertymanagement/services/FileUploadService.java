package uz.spiders.propertymanagement.services;

import uz.spiders.propertymanagement.dto.requestDTO.FileUploadDTO;
import uz.spiders.propertymanagement.dto.responseDTO.FileUploadResponseDTO;

public interface FileUploadService {
    FileUploadResponseDTO upload(FileUploadDTO fileUploadDTO);
}
