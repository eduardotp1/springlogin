package mvc.model;

import org.springframework.web.multipart.MultipartFile;

public class Users {
	 private String EMAIL;
	 private String USERNAME;
	 private String password;
	 private String home_address;
	 private String work_address;
	 private MultipartFile IMAGE;
	 
	 
	 public String getEmail() {return EMAIL;}
	 public void setEmail(String EMAIL) {this.EMAIL = EMAIL;}
	 
	 public String getUsername() {return USERNAME;}
	 public void setUsername(String USERNAME) {this.USERNAME = USERNAME;}
	 
	 public String getPassword() {return password;}
	 public void setPassword(String password) {this.password = password;}
	 
	 public String getHome() {return home_address;}
	 public void setHome(String home_address) {this.home_address = home_address;}
	 
	 public String getWork() {return work_address;}
	 public void setWork(String work_address) {this.work_address = work_address;}
	
	 public MultipartFile getImage() {return IMAGE;}
	 public void setImage(MultipartFile IMAGE) {this.IMAGE = IMAGE;}
	 
	 
}
