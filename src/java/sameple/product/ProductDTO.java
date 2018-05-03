/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sameple.product;

import java.io.Serializable;

/**
 *
 * @author viquy
 */
public class ProductDTO implements Serializable{
    private String productId;
    private String productName;
    private double price;

    public ProductDTO() {
    }

    public ProductDTO(String productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof ProductDTO)){
            return false;
        }
        ProductDTO other = (ProductDTO) obj;
        if((this.productId == null && other.productId!=null)
            || (this.productId != null
                    && !this.productId.equals(other.productId))){
            return false;
        }
        return true;
    }
    @Override
    public int hashCode(){
        int hash = 0;
        hash += (productId != null? productId.hashCode() :0);
        return hash;
    }
}
