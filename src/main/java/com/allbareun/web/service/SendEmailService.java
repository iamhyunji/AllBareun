//package com.allbareun.web.service;
//
//import java.security.Principal;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import com.allbareun.web.dao.UserDao;
//import com.allbareun.web.entity.Email;
//
//public class SendEmailService {
//	
//	@Autowired
//	UserDao userDao;
//	
//	@Autowired
//	Principal principal;
//	
//	private JavaMailSender mailsender;
//	private static final String FROM_ADDRESS = "Allbareun9599@gmail.com";
//
//	public Email createMailAndChangePassword(String email, String name, String phone) {
//		String str = getTempPassword();
//		Email emaildto = new Email();
//		emaildto.setAddress(email);
//		emaildto.setTitle(name+"님의 Allbareun 임시 비밀번호 안내 이메일입니다.");
//		emaildto.setMessage("안녕하세요. Allbareun 임시 비밀번호 안내 관련 이메일입니다." +"[" + name + "] 님의 임시 비밀번호는 " + str + "입니다.");/		updatePassword(email, str, name, phone);
//		return emaildto;
//	}
//	
//	public String getTempPassword() {
//		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
//                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
//
//        String str = "";
//
//        int idx = 0;
//        for (int i = 0; i < 10; i++) {
//            idx = (int) (charSet.length * Math.random());
//            str += charSet[idx];
//        }
//        return str;
//	}
	
//	 public void updatePassword(String email, String str, String name, String phone){
//		 String userEmail = userDao.getEmail(name, phone);
//		 BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
//		 String encodePwd = pwdEncoder.encode(str);
//	     
//	        userDao.updateUserPassword(id,pw);
//	    }
//}
