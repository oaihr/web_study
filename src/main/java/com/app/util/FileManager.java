package com.app.util;


import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.file.FileInfo;

public class FileManager {
	
	static final String FILE_DIRECTORY_PATH = "d:/fileStorage/";
	static final String FILE_URL_PATH = "/fileStorage/";
	
	public static FileInfo storeFile(MultipartFile file) throws IllegalStateException, IOException {
		//파일에 대한 정보 + 저장하는 사용할 데이터 -> 저장할 객체 (FileInfo)
		
		FileInfo fileInfo = new FileInfo();
		
		//파일에 대한 정보 처리
		
		fileInfo.setOriginalFileName(file.getOriginalFilename());
		fileInfo.setFilePath(FILE_DIRECTORY_PATH);
		fileInfo.setUrlFilePath(FILE_URL_PATH);
		
		//실제 파일 저장
		//저장할 파일의 이름(Unique)
		//String fileName = createNewFileName(file.getOriginalFilename());
		String extension = extractExtension(file.getOriginalFilename());
		String fileName = createFileName(extension);
		
		fileInfo.setFileName(fileName); // uniqe한 새로만든 파일 이름
		
		file.transferTo( new File( fileInfo.getFilePath() + fileInfo.getFileName()));
									//저장 경로					저장할 파일이름
		return fileInfo;
	}
	
	static String createNewFileName(String fileName) {
		String newFileName = UUID.randomUUID().toString() + fileName.substring((fileName.lastIndexOf(".")+1));
		return newFileName;
	}
	
	static String createFileName(String extension) {
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"."+extension;
		return fileName;
	}
	
	static String extractExtension(String fileName) {
		//cat.jpg		jpg
		//abc.xlsx		xlsx
		//qwe.hwp		hwp	
		//확장자 (jpg, png, jpeg)
		
		return fileName.substring((fileName.lastIndexOf(".")+1));
	}
}
