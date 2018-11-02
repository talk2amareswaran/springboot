package com.example.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class FileUploadRestController {

	ObjectMapper objectMapper = new ObjectMapper();
	
	@RequestMapping(value="/upload", method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> uploadFile(@RequestParam(required=true, value="file") MultipartFile file, @RequestParam(required=true, value="jsondata")String jsondata) throws IOException  {
		
		File convertFile = new File("c://mydownloads//"+file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		
		UserData userData = objectMapper.readValue(jsondata, UserData.class);
		System.out.println(userData.getFirstname());
		System.out.println(userData.getLastname());
		
		return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
		
	}
}
