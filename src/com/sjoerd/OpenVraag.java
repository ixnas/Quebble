package com.sjoerd;

import java.util.ArrayList;

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
		return null;
	}

	public boolean isCorrectBeantwoord()
	{
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