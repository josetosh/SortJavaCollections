/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import entities.Product;
import java.util.Comparator;

/**
 *
 * @author jnjeru
 */
public class SortByQuantityDesc implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        if (o2.getQuantity()> o1.getQuantity()){
                return 1;
            }else if (o2.getQuantity() < o1.getQuantity()){
                return -1;
            }else{
                return 0;
            }
    }
    
}

