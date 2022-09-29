package uz.spiders.propertymanagement.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.spiders.propertymanagement.dto.requestDTO.FileUploadDTO;
import uz.spiders.propertymanagement.dto.responseDTO.FileUploadResponseDTO;
import uz.spiders.propertymanagement.enums.S3BucketName;
import com.amazonaws.services.s3.AmazonS3;
import uz.spiders.propertymanagement.services.FileUploadService;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileUploadServiceImpl implements FileUploadService {
    private final AmazonS3 amazonS3Client;
    private String AWS_URL = String.format("https://%s.s3.amazonaws.com/",
            S3BucketName.PROPERTY_BUCKET.getS3BucketName());
    @Override
    public FileUploadResponseDTO upload(FileUploadDTO fileUploadDTO) {
        String url = uploadFileToAWSAndGetUrl(fileUploadDTO.getFile());
        return new FileUploadResponseDTO(url);
    }

    private String uploadFileToAWSAndGetUrl(MultipartFile multipartFile) {

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(multipartFile.getSize());
        String keyName = new Date().getTime() + "-" + multipartFile.getOriginalFilename().replace(" ", "_");

        try {
            amazonS3Client
                    .putObject(S3BucketName.PROPERTY_BUCKET.getS3BucketName(), keyName,
                            multipartFile.getInputStream(),
                            metadata);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return AWS_URL.concat(keyName);
    }
}
