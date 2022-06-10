package com.dsic.FicheInfo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Fiche {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String lieuNaissance;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateNaissance;
	private String cin;
	private String prenomPere;
	private String prenomMere;
	private String ville;
	private String etatCivil;
	private String niveauEtude;
	private String diplomes;
	private String travail;
	private String lieuTravail;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateEntreeOffice;
	private String address;
	private String tele;
	private String observations;
	private int nombreEnfants;
	public String photo;
	public Fiche(int id, String nom, String prenom, String lieuNaissance, Date dateNaissance, String cin,
			String prenomPere, String prenomMere, String ville, String etatCivil, String niveauEtude, String diplomes,
			String travail, String lieuTravail, Date dateEntreeOffice, String address, String tele, String observations,
			int nombreEnfants) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.lieuNaissance = lieuNaissance;
		this.dateNaissance = dateNaissance;
		this.cin = cin;
		this.prenomPere = prenomPere;
		this.prenomMere = prenomMere;
		this.ville = ville;
		this.etatCivil = etatCivil;
		this.niveauEtude = niveauEtude;
		this.diplomes = diplomes;
		this.travail = travail;
		this.lieuTravail = lieuTravail;
		this.dateEntreeOffice = dateEntreeOffice;
		this.address = address;
		this.tele = tele;
		this.observations = observations;
		this.nombreEnfants = nombreEnfants;
	}
	public Fiche() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getPrenomPere() {
		return prenomPere;
	}
	public void setPrenomPere(String prenomPere) {
		this.prenomPere = prenomPere;
	}
	public String getPrenomMere() {
		return prenomMere;
	}
	public void setPrenomMere(String prenomMere) {
		this.prenomMere = prenomMere;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getEtatCivil() {
		return etatCivil;
	}
	public void setEtatCivil(String etatCivil) {
		this.etatCivil = etatCivil;
	}
	public String getNiveauEtude() {
		return niveauEtude;
	}
	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}
	public String getDiplomes() {
		return diplomes;
	}
	public void setDiplomes(String diplomes) {
		this.diplomes = diplomes;
	}
	public String getTravail() {
		return travail;
	}
	public void setTravail(String travail) {
		this.travail = travail;
	}
	public String getLieuTravail() {
		return lieuTravail;
	}
	public void setLieuTravail(String lieuTravail) {
		this.lieuTravail = lieuTravail;
	}
	public Date getDateEntreeOffice() {
		return dateEntreeOffice;
	}
	public void setDateEntreeOffice(Date dateEntreeOffice) {
		this.dateEntreeOffice = dateEntreeOffice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	public int getNombreEnfants() {
		return nombreEnfants;
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public void setNombreEnfants(int nombreEnfants) {
		this.nombreEnfants = nombreEnfants;
	}
	
}
