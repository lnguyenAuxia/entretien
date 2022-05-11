package main.java.utils;

import java.util.List;
import java.util.stream.Collectors;

import main.java.model.Identite;

public class Normalizer {
	// enl�ve les espaces aux extremites du param�tre et remplace les espaces multiples par de simple espaces
	public String normalizeString(String input) {
		return input.trim().replaceAll(" +", " ");
	}
	
	// remonte les identit�s dont la taille de l'adresse est strictement sup�rieure � 10.
	public List<Identite> getIdentitesInvalides(List<Identite> identites) {
		return identites.stream().filter(a -> a.getAdresse().length() > 10).collect(Collectors.toList());
	}
}
