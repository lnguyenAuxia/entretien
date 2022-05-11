package main.java.utils;

import java.util.List;
import java.util.stream.Collectors;

import main.java.model.Identite;

public class Normalizer {
	// enlève les espaces aux extremites du paramètre et remplace les espaces multiples par de simple espaces
	public String normalizeString(String input) {
		return input.trim().replaceAll(" +", " ");
	}
	
	// remonte les identités dont la taille de l'adresse est strictement supérieure à 10.
	public List<Identite> getIdentitesInvalides(List<Identite> identites) {
		return identites.stream().filter(a -> a.getAdresse().length() > 10).collect(Collectors.toList());
	}
}
