package com.app.dto.file;

import lombok.Data;

@Data
public class FileInfo {
	
	String fileName; //실제 저장된 파일 이름(Unique PK);
	String originalFileName; // 사용자가 업로드하던 당시의 원래 파일이름 cat.jpg
	String filePath; //파일이 저장된 경로
	String urlFilePath; //나중에 화면에서 이미지 띄울때 접근할 url 경로
	
	
}
