package com.sjoerd;

import java.util.ArrayList;

public class MeerkeuzeVraag extends Vraag
{

	private ArrayList<Antwoord> antwoorden;

	private int juisteAntwoordIndex;

	public MeerkeuzeVraag(ArrayList<String> antwoorden, int juisteAntwoordIndex)
	{
		this.juisteAntwoordIndex = juisteAntwoordIndex;

		this.antwoorden = new ArrayList<>();
		for (String antwoord : antwoorden)
		{
			Antwoord nieuwAntwoord = new Antwoord();
			nieuwAntwoord.naam = antwoord;
			this.antwoorden.add(nieuwAntwoord);
		}
	}

	public boolean isCorrectBeantwoord()
	{
		if (!isBeantwoord())
		{
			return false;
		}

		int beginLetter = 'a';
		int gekozenLetter = gegevenAntwoord.naam.charAt(0);

		int gekozenAntwoordIndex = gekozenLetter - beginLetter;

		return gekozenAntwoordIndex == juisteAntwoordIndex;
	}

	public void geefAntwoord(String antwoord)
	{
		if (antwoord == null || antwoord.equals("") || antwoord.length() != 1)
		{
			throw new OngeldigAntwoordException();
		}

		char invoerKarakter = Character.toLowerCase(antwoord.charAt(0));

		int keuzeLetterBeginKleineLetter = 'a';
		int keuzeLetterEindKleineLetter = keuzeLetterBeginKleineLetter + antwoorden.size() - 1;

		if (invoerKarakter < keuzeLetterBeginKleineLetter || invoerKarakter > keuzeLetterEindKleineLetter)
		{
			throw new OngeldigAntwoordException();
		}

		gegevenAntwoord = new Antwoord();
		gegevenAntwoord.naam = antwoord;
	}

	public ArrayList<String> haalAntwoordOptiesOp()
	{
		ArrayList<String> antwoordOpties = new ArrayList<>();
		char keuzeLetter = 'A';

		for (Antwoord antwoord : antwoorden)
		{
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(keuzeLetter);
			stringBuilder.append(". ");
			stringBuilder.append(antwoord.naam);
			antwoordOpties.add(stringBuilder.toString());
			keuzeLetter++;
		}

		return antwoordOpties;
	}

}
