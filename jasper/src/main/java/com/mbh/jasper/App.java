package com.mbh.jasper;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void reportProducts() throws JRException {
		Collection<Map<String, ?>> allProducts = new ArrayList<Map<String,?>>();
		List<Product> products = getProducts();
		
		for (Product product : products) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", product.getId());
			map.put("nom", product.getNom());
			map.put("quantite", product.getQuantite());
			map.put("prix", product.getPrix());
			allProducts.add(map);
		}

		  JasperGen.generate(allProducts, "product_list_report.jrxml", "results");
	        
	       System.out.println("Done!");
				
	}
  
	private static List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		Product p = new Product("2158", "ProductName", 3, 7.5);
		Product p2 = new Product("2257", "ProductName", 3, 4.5);
		Product p3 = new Product("987", "ProductName", 3, 4);
		Product p4 = new Product("2158", "ProductName", 3, 4);
		products.add(p);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		
		return products;
	}


	public static void main(String[] args) {
		try {
			reportProducts();
			JasperGen.generate(getProducts(), "product_list_report.jrxml", "result_objects");
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}