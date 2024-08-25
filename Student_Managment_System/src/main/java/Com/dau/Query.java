package Com.dau;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Com.bean.student;

public class Query {
  public static int insert(student ob) throws ClassNotFoundException, SQLException {
	 Connection con=Connecter.connect();
	 PreparedStatement ps=con.prepareStatement("insert into student2(name,mobile_number,gender,city,password) values(?,?,?,?,?)");
	 ps.setString(1, ob.getName());
	 ps.setString(2, ob.getMobile());
	 ps.setString(3, ob.getGender());
	 ps.setString(4, ob.getCity());
	 ps.setString(5, ob.getPassword());
	 return ps.executeUpdate();
  }
  public static boolean login(String mobile,String pass) throws ClassNotFoundException, SQLException {
		 Connection con=Connecter.connect();
		 PreparedStatement ps=con.prepareStatement("select * from student2 where mobile_number=? and password=?");
		 ps.setString(1, mobile);
		 ps.setString(2, pass);
		 ResultSet rs=ps.executeQuery();
		 return rs.next(); 
   }
  public static ArrayList<student> fetch() throws ClassNotFoundException, SQLException {
		 Connection con=Connecter.connect();
		 PreparedStatement ps=con.prepareStatement("select * from student2");
		 ResultSet rs=ps.executeQuery();
		 ArrayList<student> ob=new ArrayList();
		 while(rs.next()) {
			 student obdata=new student();
			 obdata.setId(rs.getInt(1));
			 obdata.setName(rs.getString(2));
			 obdata.setMobile(rs.getString(4));
			 obdata.setGender(rs.getString(3));
			 obdata.setCity(rs.getString(5));
			 obdata.setPassword(rs.getString(6));
             ob.add(obdata);
		 }
		 return ob;
    }
  public static student updatefetch(int id) throws ClassNotFoundException, SQLException {
		 Connection con=Connecter.connect();
		 PreparedStatement ps=con.prepareStatement("select * from student2 where id="+id);
		 ResultSet rs=ps.executeQuery();
		 student obdata=new student();
		 rs.next();
			 obdata.setId(rs.getInt(1));
			 obdata.setName(rs.getString(2));
			 obdata.setMobile(rs.getString(4));
			 obdata.setGender(rs.getString(3));
			 obdata.setCity(rs.getString(5));
			 obdata.setPassword(rs.getString(6));
		
		 return obdata;
 }
  public static int update(student ob) throws ClassNotFoundException, SQLException {
		 Connection con=Connecter.connect();
		 PreparedStatement ps=con.prepareStatement("update student2 set name=?,mobile_number=?,gender=?,city=?,password=? where id="+ob.getId());
         ps.setString(1, ob.getName());
         ps.setString(2, ob.getMobile());
         ps.setString(3, ob.getGender());
         ps.setString(4, ob.getCity());
         ps.setString(5, ob.getPassword());
         return ps.executeUpdate();
  }
  public static int delete(int id) throws ClassNotFoundException, SQLException {
		 Connection con=Connecter.connect();
		 PreparedStatement ps=con.prepareStatement("delete from student2 where id="+id);
         return ps.executeUpdate();
  }
}
