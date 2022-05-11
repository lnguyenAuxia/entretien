package main.java.model;

import java.util.Objects;

public class Identite {
	private String numeroIdentite;
	private String adresse;
	
	public Identite (String numeroIdentite, String adresse) {
		this.numeroIdentite = numeroIdentite;
		this.adresse = adresse;
	}
	
	public String getNumeroIdentite() {
		return numeroIdentite;
	}
	public void setNumeroIdentite(String numeroIdentite) {
		this.numeroIdentite = numeroIdentite;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	@Override
	public int hashCode() {
		return Objects.hash(adresse, numeroIdentite);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Identite other = (Identite) obj;
		return Objects.equals(adresse, other.adresse) && Objects.equals(numeroIdentite, other.numeroIdentite);
	}
	
	
}
