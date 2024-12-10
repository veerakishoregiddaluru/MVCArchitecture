import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.jasper.tagplugins.jstl.core.Catch;

public class Model {
	Connection con=null;
	PreparedStatement ps=null;
	PreparedStatement ps2=null;
	ResultSet rs=null;
	String path="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/kodnest";
	String sql="insert into  koduser values(?,?,?,?,?)";
	String user="root";
	String pass="Kishore214@";
	String sql2="select * from koduser where id=? && password=?";
			
public Model() {
	
	try {
		
		Class.forName(path);
		con=DriverManager.getConnection(url,user,pass);
		ps=con.prepareStatement(sql);
		ps2=con.prepareStatement(sql2);
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
	
	public boolean performRegistration(String id,String password,String name,String age,String gmail) {
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, age);
			ps.setString(5, gmail);
			int rs=ps.executeUpdate();
			if(rs==1) {
				return true;
			}
			
	}catch (Exception e) {
e.printStackTrace();
		}
		return false;
	}
	public boolean loginForm(String id,String password) {
		try {
		ps2=con.prepareStatement(sql2);
		
		
		
		ps2.setString(1, id);
		ps2.setString(2, password);
		rs=ps2.executeQuery();
		if(rs.next()) {
			return true;
		}
		
		
		}catch (Exception e) {
e.printStackTrace();
		}
		
		
		return false;
	}

}

