/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import DB.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author AnhNLCE181837
 */
public class ProvinceDAO {

    public ProvinceDAO() {
    }
    
    public ResultSet getAll(){
        Connection conn = DBConnection.getConnection();
        ResultSet rs = null;
        try{
            Statement st = conn.createStatement();
                rs = st.executeQuery("SELECT name FROM province");
        }catch(Exception e){
            rs=null;
        }
        return rs;
    }
    
    public String getProvinceID(String province){
        Connection conn = DBConnection.getConnection();
        ResultSet rs = null;
        String id = "";
        try{
            String sql = "SELECT id FROM province WHERE name = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, province);
            rs = pst.executeQuery();
            if(rs.next()){
                id = rs.getString("id");
            }
        }catch(Exception e){
            id="";
        }
        return id;
    }
}
