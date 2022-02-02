/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labten;

/**
 *
 * @author lapshop
 */
import java.sql.*;
import java.util.Vector;






public class testCon {
    public static ResultSet rs;
    public static Connection con;
    public static Statement stmt;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("working");
    }

    public static int connect() throws ClassNotFoundException{
    try{  
        Class.forName("com.mysql.jdbc.Driver");  
        con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/addressbook","root","123456");
        stmt=con.createStatement();
        rs=stmt.executeQuery("select * from contact");  
        return 0;
        }catch(SQLException e){
            return 1;
        }
    }

    public static void exit() throws SQLException{
        con.close();
        rs.close();
    }

    public static Vector<ContactPerson> get_all() throws SQLException, ClassNotFoundException{
        Vector<ContactPerson> MyContactPersonVector = new Vector<ContactPerson>();
        rs=stmt.executeQuery("select * from contact");
        while(rs.next()){
            ContactPerson the_one = new ContactPerson(rs.getInt(1), rs.getString(2), rs.getString(4),rs.getString(5),rs.getString(8));
            MyContactPersonVector.add(the_one);
        }
        return MyContactPersonVector;
    }

//    public static void update(ContactPerson person_to_be_updated) throws SQLException{
//        String query_String= new String("UPDATE contact SET name = '"+person_to_be_updated.getName()+"', home_phone = '"+person_to_be_updated.getHome_phone()+"' WHERE id="+person_to_be_updated.getId()+";");
//        stmt.executeUpdate(query_String);
//    }
//
//    public static void delete(int _id) throws SQLException{
//        String query_String= new String("DELETE FROM contact WHERE id="+_id+";");
//        stmt.executeUpdate(query_String);
//    }
//
//    public static void Insert(ContactPerson person_to_be_inserted) throws SQLException{
//            String query_String= new String("INSERT INTO contact (name, home_phone) VALUES('"+person_to_be_inserted.getName()+"','" + person_to_be_inserted.getHome_phone()+"';");
//            stmt.executeUpdate(query_String);
//    }
}
