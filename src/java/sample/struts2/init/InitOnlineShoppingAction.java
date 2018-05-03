/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.struts2.init;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import sameple.product.ProductDAO;

/**
 *
 * @author viquy
 */
public class InitOnlineShoppingAction extends ActionSupport {
    private Map<String, String> itemsList;
    private final String SUCCESS = "success";
    public InitOnlineShoppingAction() {
    }
    
    public String execute() throws Exception {
        ProductDAO dao = new ProductDAO();
        dao.getAllProducts();
        this.itemsList = dao.getItemsList();
        return SUCCESS;
    }
    public Map<String, String> getItemsList(){
        return itemsList;
    }
}
