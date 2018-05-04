/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.cart;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.awt.BorderLayout;
import java.util.Map;
import sample.cart.CartObj;

/**
 *
 * @author viquy
 */
public class RemoveItemFromCartAction extends ActionSupport {
    private String[] selectedItem;
    private final String SUCCESS = "success";
    public RemoveItemFromCartAction() {
    }

    public String[] getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String[] selectedItem) {
        this.selectedItem = selectedItem;
    }
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        CartObj cart = (CartObj) session.get("CART");
        if(cart != null){
            for(String item : selectedItem){
                System.out.println("dd" + item);
            }
            session.put("CART", cart);
        }
        return SUCCESS;
    }
    
}
