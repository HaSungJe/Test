package com.myweb.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData) throws Exception{
		UUID uuid = UUID.randomUUID();
		String saveName = uuid.toString() + "_" + originalName;
		
		// 년, 월, 일 별로 폴더 세분화
		// C:/upload/2018/10/31/saveName		
		String path = calcPath(uploadPath);
		
		// path = "G://upload/2018/10/31
		// saveName = "~~~~~~_원래이름"
		File target = new File(path, saveName);		// 파일생성(위치, 파일명)
		FileCopyUtils.copy(fileData, target);		// 파일값넣기(내용, 대상파일)
		
		String filePath = path + File.separator + saveName;
		
		// 확장자 얻기
		String formatName = getFormatName(saveName);
		
		// 이미지인지 아닌지 확인
		boolean isImage = isImage(formatName);
		if(isImage == true) {
			// 이미지일 경우 : 1. 썸네일을 생성, 2. 썸네일의 위치 돌려줌.
			// filePath = 썸네일의 좌표+이름
			filePath = makeThumbnail(path, saveName);			
		}
		
		//
		String filePath2 = filePath.substring(uploadPath.length());
		System.out.println("filePath2: "+filePath2);
		
		//
		String filePath3 = filePath2.replace(File.separatorChar, '/');
		System.out.println("filePath3: "+filePath3);
		
		return filePath3;	// 파일이 저장된 경로와 이름.
							// "G://upload/2018/10/31/saveName"
		
		
	}
	
	public static String calcPath(String uploadPath) {
		// G:/upload	
		Calendar cal = Calendar.getInstance();
		
		// G:/upload/2018		
		String yearPath = File.separator + cal.get(Calendar.YEAR);
	//	System.out.println("yearPath: "+yearPath);
		
		// G:/upload/2018/10
		// new DecimalFormet("00").formet(내용) - 자리를 숫자 2자리로 맞춤.
		// File.separator - "/"를 붙여줌.
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
	//	System.out.println("monthPath: "+monthPath);
		
		// datePath = "2018/10/31
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		System.out.println("datePath: "+datePath);
		
		// 파일이 존재하는지 확인. 없으면 만들어줘야함
		
		// dirPath = "G://uplpad/2018/10/31"
		File dirPath = new File(uploadPath + datePath);		// 1. D:/upload/2018
		// 이 파일이 존재하지 않는다면					// 2. D:/upload/2018/10
		if(!dirPath.exists()) {							// 3. D:/upload/2018/10/31
			// mkdirs() - 상위 폴더가 존재하지 않으면, 상위 폴더도 생성.
			// mkdir() - 상위 폴더가 존재하지 않으면, 폴더 생성 불가.
			dirPath.mkdirs();
		}
		
		//return : "G://upload/2018/10/31"
		return uploadPath + datePath;
	}
	
	// 이미지 작게 복사하기.
	private static String makeThumbnail(String path, String fileName) throws Exception{
		// imgscalr 라이브러리
		// 메모리상에서 원본이미지 불러다가 -> 작은 이미지로 
		// 메모리에 생성된 작은 이미지를 파일에 쓰기
				
		// 버퍼로 이미지를 읽어온다(경로, 파일명)
		BufferedImage sourceImg = ImageIO.read(new File(path, fileName));		// 원본
		
		// 높이 값이 100에 가로 크기를 자동으로 조절.
		// 새로운 버퍼 이미지를 만들어서 읽어온 버퍼이미지의 값을 수정한 새로운 파일 만듦
		BufferedImage destImg = 		
				Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
		
		// 썸네일 파일명 -> "G://upload/2018/10/31/uuid_s_saveName"
		String thumNailName = path + File.separator + "s_" + fileName;
		System.out.println("thumNailName: "+thumNailName );
		
		
		// 새로운 파일 생성
		File newFile = new File(thumNailName);
		
		// 확장자 얻기
		String formatName = getFormatName(thumNailName);
		
		// 이미지파일인 경우 썸네일을 만든다.

		// 이미지를 리사이즈된 썸네일을 그린다.(참조파일, 확장자, 타겟)
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);			
			
		return thumNailName;
	}
	
	
	// 확장자 얻기
	public static String getFormatName(String fileName) {
		String formatName = fileName.substring(fileName.lastIndexOf(".") +1);
		System.out.println("fileType: " + formatName);
				
		return formatName;
	}
	
	// 이미지파일인지 아닌지 확인하기
	private static boolean isImage(String formatName) {
		formatName = formatName.toUpperCase();
		String[] imgFormat = {"JPG", "GIF", "PNG"};
		for(String format: imgFormat) {
			if(format.equals(formatName)) {
				System.out.println("파일종류구분: " + formatName);
				System.out.println("매치: "+format);
				return true;
			}
		}	
		return false;
	}
	
}








