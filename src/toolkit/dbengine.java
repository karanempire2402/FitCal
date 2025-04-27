/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolkit;
import java.sql.*;
import java.util.Vector;
/**
 *
 * @author DELL
 */
public class dbengine {
public Connection dbConnection()throws Exception
        {
            Class.forName("com.mysql.jdbc.Driver");
            String myDB="jdbc:mysql://localhost:3306/tool";
            return DriverManager.getConnection(myDB,"root","");
        }
        public Vector getusers(String q)throws Exception
        {
        Vector<Vector<String>> userVector=new Vector<Vector<String>>();
        Connection conn=dbConnection();
        PreparedStatement pre=conn.prepareStatement(q);
        ResultSet rs=pre.executeQuery();
        while(rs.next())
        {
            Vector<String> user = new Vector<String>();
            user.add(rs.getString(2));
            user.add(rs.getString(3));
            user.add(rs.getString(4));
            userVector.add(user);
        }
        if(conn!=null)
            conn.close();
        return userVector;
        }
}
        
