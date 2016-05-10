/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questionone;

import entities.Product;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import util.SortByAmountDesc;
import util.SortByDiscountDesc;
import util.SortByNameDesc;
import util.SortByQuantityDesc;

/**
 *
 * @author jnjeru
 */
public class LoadAndSortData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\jnjeru\\Documents\\NetBeansProjects\\QuestionOne\\src\\questionone\\Items.csv");
        BufferedReader reader = null;
        List<Product> pList = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));            
            String line;
            line = reader.readLine();
            while (line != null) {
                Product p = new Product();
                //System.out.println(line);
                StringTokenizer st = new StringTokenizer(line, ",");
                p.setName(st.nextToken());
                p.setQuantity(Integer.valueOf(st.nextToken()));
                p.setAmount(Double.valueOf(st.nextToken()));
                p.setDiscount(Double.valueOf(st.nextToken()));                
                //System.out.println(p.toString());
                pList.add(p);
                //System.out.println("Count : "+pList.size());
                line = reader.readLine();
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to find the file: "+ file);
        }finally{
            reader.close();           
        }
        System.out.println("---Before Any Sorting and with Duplicate Records");
        for(Product p : pList){
            System.out.println(p.toString());
        }
        System.out.println("Total Count with Duplicates :" +pList.size());
        System.out.println("---After Removing Duplicates");
        Set<Product> pSet = new HashSet<>();
        for(int i = 0; i < pList.size(); i++){
            Product p = new Product();
            p = pList.get(i);
            pSet.add(p);            
        }
        System.out.println("Total Count without Duplicates :" +pSet.size());
        for(Product p : pSet){            
            System.out.println(p.toString());
        }
                
        Collections.sort(pList, new SortByQuantityDesc());
        System.out.println("---After Sorting by Quantity Desc");
        for(Product p : pList){            
            System.out.println(p.toString());
        }
        Collections.sort(pList, new SortByAmountDesc());
        System.out.println("---After Sorting by Amount Desc");
        for(Product p : pList){            
            System.out.println(p.toString());
        }
        Collections.sort(pList, new SortByDiscountDesc());
        System.out.println("---After Sorting by Discount Desc");
        for(Product p : pList){            
            System.out.println(p.toString());
        }
        Collections.sort(pList, new SortByNameDesc());
        System.out.println("---After Sorting by Name Desc");
        Iterator it = pList.iterator();
        while(it.hasNext()){
            Product p = (Product) it.next();
            System.out.println(p.toString());
        }

        System.out.println("----working.....end of program...");

    }

}
