//package hallodoc.helper;
//
//public class FileUpload {
//	
//	System.out.println(file.getSize());
//	System.out.println(file.getContentType());
//	byte [] data = file.getBytes();
//	//we want to save this var to server
//	 String p =  s.getServletContext().getRealPath("/") + "WEB-INF" + File.separator+ "resources" + File.separator + "image" + File.separator + file.getOriginalFilename();
//	System.out.println(p);
//	FileOutputStream fileOutputStream;
//	try {
//		fileOutputStream = new FileOutputStream(p);
//		fileOutputStream.write(data);
//		fileOutputStream.close();
//		m.addAttribute("filename" , file.getOriginalFilename());
//		m.addAttribute("msg" , "success");
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		System.out.println("error");
//		m.addAttribute("msg" , "errror");
//	}
//
//
//}
//
//
//
//public String fileupload(@RequestParam("profile") CommonsMultipartFile file, HttpSession s, Model m )
//{
//	System.out.println(file.getSize());
//	System.out.println(file.getContentType());
//	byte [] data = file.getBytes();
//	//we want to save this var to server
//	 String p =  s.getServletContext().getRealPath("/") + "WEB-INF" + File.separator+ "resources" + File.separator + "image" + File.separator + file.getOriginalFilename();
//	System.out.println(p);
//	FileOutputStream fileOutputStream;
//	try {
//		fileOutputStream = new FileOutputStream(p);
//		fileOutputStream.write(data);
//		fileOutputStream.close();
//		m.addAttribute("filename" , file.getOriginalFilename());
//		m.addAttribute("msg" , "success");
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		System.out.println("error");
//		m.addAttribute("msg" , "errror");
//	}
//
//}