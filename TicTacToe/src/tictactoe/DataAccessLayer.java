/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import java.sql.* ;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.derby.jdbc.ClientDriver;
/**
 *
 * @author Nada
 */
public class DataAccessLayer {
     static LinkedHashMap<String, Player> Map = new LinkedHashMap<String, Player>();
     static LinkedHashMap<Integer, Score> scoreMap = new LinkedHashMap<Integer, Score>();
     
    public static Connection ConnectDb() throws SQLException{
            DriverManager.registerDriver(new ClientDriver());
             Connection con=  DriverManager.getConnection("jdbc:derby://localhost:1527/TicTacToe","root","root");
            return con;
    }
    public static boolean login(String name,String pass){try {
        //static so we can call it using class name
        Connection con=  ConnectDb();
        PreparedStatement pst=con.prepareStatement("select * from player where USERNAME=? AND PASSWORD=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        pst.setString(1,name);
        pst.setString(2, pass);
        ResultSet rs=pst.executeQuery();
        boolean res=rs.next();
        pst.close();
        con.close();
        return res;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    return false;
    }
    public static void Loaddata(){
         try {
             Connection con = ConnectDb();
            PreparedStatement pst=con.prepareStatement("select * from player ", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
            Map.put(rs.getString(1),new Player(rs.getString(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
         } catch (SQLException ex) {
             Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
         }
            
    };
     public static boolean  Register(String name,String pass,String email){
        try {
            //static so we can call it using class name
            Player result=Map.get(name);
            if(result==null){
                 Connection con=ConnectDb();
            PreparedStatement pst=con.prepareStatement("insert into PLAYER values(?,?,?,?,?)", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        pst.setString(1, name);
                        pst.setString(2, pass);
                        pst.setString(3, email);
                        pst.setInt(4, 0);
                        pst.setInt(5, 0);
                        pst.executeUpdate();
                        pst.close();
                        con.close();
                        Map.put(name,new Player(name,pass,email,0,0));
                        return true;
            }
            else 
                return false;
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
      public static void SaveScore(String p1,String p2,String winner){
         try {
             Connection con = ConnectDb();
             PreparedStatement pst=con.prepareStatement("insert into PLAYER values(?,?,?) ", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             pst.setString(1, p1);
             pst.setString(2, p2);
             pst.setString(3, winner);
             pst.executeUpdate();
             pst.close();
             con.close();
            scoreMap.put(scoreMap.size(),new Score(p1,p2,winner));
            
         } catch (SQLException ex) {
             Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
         }
            
    };
      public static LinkedHashMap ShowScore(String name){
         try {
             Connection con = ConnectDb();
             PreparedStatement pst=con.prepareStatement("select * from SCORE ", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs=pst.executeQuery();
             while(rs.next())
                scoreMap.put(rs.getInt(1),new Score(rs.getString(2),rs.getString(3), rs.getString(4)));
             pst.close();
             con.close();
         } catch (SQLException ex) {
             Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
         }
         return scoreMap;
            
    };
}
