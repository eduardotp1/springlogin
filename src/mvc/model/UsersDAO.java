package mvc.model;

import java.io.*;
//import java.nio.file.Files;
import java.sql.*;
//import org.springframework.web.multipart.MultipartFile;

public class UsersDAO {
	private Connection connection = null;
	public UsersDAO() {
		 try {
		 Class.forName("com.mysql.jdbc.Driver");
		 connection = DriverManager.getConnection("jdbc:mysql://localhost/devoir", "root", "201096");
		 
		 } catch (SQLException | ClassNotFoundException e) {e.printStackTrace();}
	}
	
	public void adiciona(Users users) {
		/*MultipartFile filePart = users.getImage();
		//Rotina para salvar o arquivo no servidor 
		if (!filePart.isEmpty()) {
			String fileName = filePart.getOriginalFilename();
			File uploads = new File("/tmp");
			File file = new File(uploads, fileName);
			try (InputStream input = filePart.getInputStream()) {
				Files.copy(input, file.toPath());
			}
		}*/
		
		try {
			String sql = "INSERT INTO users (USERNAME, EMAIL, password) values(?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			System.out.println(users.getUsername());
			stmt.setString(1,users.getUsername());
			stmt.setString(2,users.getEmail());			 
			stmt.setString(3,users.getPassword());
			//stmt.setBinaryStream(4, filePart.getInputStream());
			stmt.execute();
			stmt.close();
		}
		catch (SQLException e) {e.printStackTrace();}
	}
	
	public boolean existeUsuario(Users users) {
		boolean existe = false;
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) FROM users WHERE USERNAME=? AND password=? LIMIT 1");
			stmt.setString(1, users.getUsername());
			stmt.setString(2, users.getPassword());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				if(rs.getInt(1) != 0) {existe=true;}
			}
			rs.close();
			stmt.close();
		}
		catch(SQLException e) {System.out.println(e);}
		return existe;
		}

	public byte[] buscaFoto(String login) {
		byte[] imgData = null;
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE USERNAME=? ");
			stmt.setString(1, login);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Blob image = rs.getBlob("foto");
				imgData = image.getBytes(1, (int) image.length());
			}
			rs.close();
			stmt.close();
		}
		catch(SQLException e) {System.out.println(e);}
		return imgData;
		}
}
