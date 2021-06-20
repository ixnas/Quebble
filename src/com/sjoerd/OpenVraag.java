package com.sjoerd;

import java.util.ArrayList;
import java.util.Locale;

public class OpenVraag extends Vraag
{

	private ArrayList<Antwoord> antwoorden;

	public OpenVraag(ArrayList<String> antwoorden)
	{
		this.antwoorden = new ArrayList<>();
		for (String antwoord : antwoorden)
		{
			Antwoord nieuwAntwoord = new Antwoord();
			nieuwAntwoord.naam = antwoord;
			this.antwoorden.add(nieuwAntwoord);
		}
	}

	public ArrayList<String> haalAntwoordOptiesOp()
	{
		return new ArrayList<>();
	}

	public boolean isCorrectBeantwoord()
	{
		if (!isBeantwoord())
		{
			return false;
		}

		for (Antwoord antwoord : antwoorden)
		{
			String antwoordInKleineLetters = antwoord.naam.toLowerCase();
			String gegevenAntwoordInKleineLetters = gegevenAntwoord.naam.toLowerCase();

			if (antwoordInKleineLetters.equals(gegevenAntwoordInKleineLetters))
			{
				return true;
			}
		}

		return false;
	}

	public void geefAntwoord(String antwoord)
	{
		if (antwoord == null || antwoord.equals(""))
		{
			throw new OngeldigAntwoordException();
		}
		gegevenAntwoord = new Antwoord();
		gegevenAntwoord.naam = antwoord;
	}

}