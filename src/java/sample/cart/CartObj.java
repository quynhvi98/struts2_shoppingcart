/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import sameple.product.ProductDTO;

/**
 *
 * @author viquy
 */
public class CartObj implements Serializable{
    private String customerId;
    private Map<ProductDTO, Integer> items;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Map<ProductDTO, Integer> getItems() {
        return items;
    }
    public void addItemToCart (ProductDTO item){
        if(this.items == null){
            this.items = new HashMap<>();
        }
        int quantity = 1;
        if(this.items.containsKey(item)){
            quantity = this.items.get(item) + 1;
        }
        this.items.put(item, quantity);
    }
    public void removeItemFromCart (ProductDTO item){
        if(this.items == null){
            return;
        }
        if(this.items.containsKey(item)){
            this.items.remove(item);
            if(this.items.isEmpty()){
                this.items = null;
            }
        }
    }
    public void removeItemFromCart(String id){
        if(this.items == null){
            return;
        }
        ProductDTO dto = new ProductDTO(id, "", 0);
        if(this.items.containsKey(dto)){
            this.items.remove(dto);
            if(this.items.isEmpty()){
                this.items = null;
            }
        }
    }
    
}
