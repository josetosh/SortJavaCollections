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
public class SortByNameDesc implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o2.getName().compareToIgnoreCase(o1.getName());
    }
    
}
