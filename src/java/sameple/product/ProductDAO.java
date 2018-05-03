/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sameple.product;

import com.opensymphony.xwork2.Preparable;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.naming.NamingException;
import sample.utils.DBUtils;

/**
 *
 * @author viquy
 */
public class ProductDAO implements Serializable{
    private Map<String, String> itemsList;

    public Map<String, String> getItemsList() {
        return itemsList;
    }
    public void getAllProducts() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtils.makeConnection();
            if(con!=null){
                String sql="select * from Product";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while(rs.next()){
                    String id = rs.getString("productId");
                    String name = rs.getString("productName");
                    if(this.itemsList == null){
                        this.itemsList = new HashMap<>();
                    }
                    this.itemsList.put(id, name);
                }
            }
        }finally{
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
    }
    public ProductDTO getProduct (String id) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtils.makeConnection();
            if(con != null){
                String sql="select * from product where productId = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs= stm.executeQuery();
                if(rs.next()){
                    String name = rs.getString("productName");
                    double price = rs.getDouble("price");
                    ProductDTO dto= new ProductDTO(id, name, price);
                    return dto;
                }
            }
        }finally{
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
        return null;
    }
}
