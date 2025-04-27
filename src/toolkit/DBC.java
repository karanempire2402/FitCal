/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolkit;

/**
 *
 * @author DELL
 */
import java.sql.*;
public class DBC {
    public Connection con=null;
     public ResultSet rs=null;
      public Statement st=null;
       public int rows=0;
       
       public DBC()
       {
           try{
               Class.forName("com.mysql.jdbc.Driver");
               con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tool","root","");
           }
           catch(Exception ex)
           {
               ex.printStackTrace();
           }
       }
       public void executeSelect(String q)
       {
           try{
            st=con.createStatement();
            rs=st.executeQuery(q);
           }
           catch(Exception ex)
           {
               ex.printStackTrace();
           }
       }
        public void executeNonSelect(String q)
       {
           try{
            st=con.createStatement();
            rows=st.executeUpdate(q);
           }
           catch(Exception ex)
           {
               ex.printStackTrace();
           }
       }
    
}
