package com.sjoerd;

import java.util.ArrayList;

public class MeerkeuzeVraag extends Vraag {

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

	public boolean isCorrectBeantwoord() {
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

	public ArrayList<String> haalAntwoordOptiesOp() {
		return null;
	}

}
