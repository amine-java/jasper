package com.mbh.jasper;

public class Product {

	public String id = "Default"; 
	public String nom ; 
	public int quantite ; 
	public double prix ;
	
	
	
	public Product(String id, String nom, int quantite, double prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.quantite = quantite;
		this.prix = prix;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	} 

	

}