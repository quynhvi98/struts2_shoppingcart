/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.cart;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import sameple.product.ProductDAO;
import sameple.product.ProductDTO;
import sample.cart.CartObj;

/**
 *
 * @author viquy
 */
public class AddToCartAction extends ActionSupport {
    private String item;
    private final String SUCCESS= "success";
    private final String FAIL = "fail";
    private Map<String, String> itemsList;
    public AddToCartAction() {
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public Map<String, String> getItemsList() {
        return itemsList;
    }
    
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        CartObj cart = (CartObj) session.get("CART");
        if(cart == null){
            cart = new CartObj();
        }
        ProductDAO dao = new ProductDAO();
        ProductDTO dto = dao.getProduct(item);
        cart.addItemToCart(dto);
        session.put("CART", cart);
        dao.getAllProducts();
        this.itemsList = dao.getItemsList();
        return SUCCESS;
    }
    
}
