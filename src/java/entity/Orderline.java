/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import data.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jamie
 */
public class Orderline {
    private Cupcake c;
    private int amount;
    private int price;

    public Cupcake getC() {
        return c;
    }

    public void setC(Cupcake c) {
        this.c = c;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
        
    public Orderline(Cupcake c, int amount) throws SQLException{
        this.c=c;
        this.amount=amount;
        PreparedStatement pstmt = DB.getConnection().prepareStatement("select tPrice,bPrice from tops,bottoms where bFlavour=? and tFlavour=?");
        pstmt.setString(1, c.getBottom());
        pstmt.setString(2, c.getTopping());
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        this.price=(rs.getInt(1) + rs.getInt(2)) * amount;
               
    }
    
}


