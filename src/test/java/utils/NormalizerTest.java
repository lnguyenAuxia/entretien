package test.java.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.java.model.Identite;
import main.java.utils.Normalizer;

class NormalizerTest extends Normalizer {

	@Test
	void testNormalizeEmptyString() {
		assertEquals("", normalizeString("     "), "test empty String");
	}
	
	@Test
	void testNormalizeSimpleString() {
		assertEquals("test case", normalizeString(" test  case   "), "test simple String");
	}
	
	@Test
	void testNormalizeIntermediateString() {
		assertEquals("complex case testing", normalizeString(" complex   case       testing     "), "test complex String");
	}
	
	
	@Test
	void testCheckInvalidListEmpty() {
		List<Identite> identitesInput = new ArrayList<>();
		identitesInput.add(new Identite("02", "valide"));
		assertTrue(getIdentitesInvalides(identitesInput).isEmpty(), "Devrait rendre une liste vide");
	}
	
	@Test
	void testCheckInvalidListSingleInvalidElement() {
		List<Identite> identitesInput = new ArrayList<>();
		identitesInput.add(new Identite("01", "adresse invalide"));
		identitesInput.add(new Identite("02", "valide"));
		
		List<Identite> identitesExpectedOutput = new ArrayList<>();
		identitesExpectedOutput.add(new Identite("01", "adresse invalide"));
		
		List<Identite> identitesActualOutput = getIdentitesInvalides(identitesInput);
		assertTrue(identitesExpectedOutput.containsAll(identitesActualOutput)
				&& identitesActualOutput.containsAll(identitesExpectedOutput)
				&& identitesExpectedOutput.size() == identitesActualOutput.size(),
				"Devrait rendre une liste avec un element");
	}
	
	@Test
	void testCheckInvalidListSeveralInvalidElement() {
		List<Identite> identitesInput = new ArrayList<>();
		identitesInput.add(new Identite("01", "adresse invalide"));
		identitesInput.add(new Identite("02", "valide"));
		identitesInput.add(new Identite("03", "adresse invalide rue"));
		identitesInput.add(new Identite("04", "valide8910"));
		identitesInput.add(new Identite("05", "invalideRue"));
		
		List<Identite> identitesExpectedOutput = new ArrayList<>();
		identitesExpectedOutput.add(new Identite("01", "adresse invalide"));
		identitesExpectedOutput.add(new Identite("03", "adresse invalide rue"));
		identitesExpectedOutput.add(new Identite("05", "invalideRue"));
		
		List<Identite> identitesActualOutput = getIdentitesInvalides(identitesInput);
		assertTrue(identitesExpectedOutput.containsAll(identitesActualOutput)
				&& identitesActualOutput.containsAll(identitesExpectedOutput)
				&& identitesExpectedOutput.size() == identitesActualOutput.size(),
				"Devrait rendre une liste avec plusieurs element");
	}
}
