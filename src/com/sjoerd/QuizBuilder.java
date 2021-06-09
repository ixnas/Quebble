package com.sjoerd;

import java.util.ArrayList;

public class QuizBuilder
{

	private String vraagNaam;

	private ArrayList<String> antwoorden;

	private int juisteAntwoordIndex;

	private char letter;

	private String gegevenAntwoord;

	private ArrayList<IVraag> vragen;

	private int kosten;

	private int gespeeldeTijdInSeconden;

	private String gelegdWoord;

	public QuizBuilder()
	{
		letter = '.';
		antwoorden = new ArrayList<>();
		juisteAntwoordIndex = -1;
		vragen = new ArrayList<>();
	}

	public QuizBuilder stelVraagNaamIn(String naam)
	{
		vraagNaam = vraagNaam;
		return this;
	}

	public QuizBuilder stelAntwoordenIn(ArrayList<String> antwoorden)
	{
		this.antwoorden = antwoorden;
		return this;
	}

	public QuizBuilder stelJuisteAntwoordIn(int index)
	{
		juisteAntwoordIndex = index;
		return this;
	}

	public QuizBuilder stelLetterIn(char letter)
	{
		this.letter = letter;
		return this;
	}

	public QuizBuilder stelGegevenAntwoordIn(String antwoord)
	{
		gegevenAntwoord = antwoord;
		return this;
	}

	public QuizBuilder voegIngesteldeVraagToeAanQuiz()
	{
		Vraag vraag;

		if (juisteAntwoordIndex == -1)
		{
			vraag = Vraag.maakOpenVraag(antwoorden);
		}
		else
		{
			vraag = Vraag.maakMeerkeuzeVraag(antwoorden, juisteAntwoordIndex);
		}

		vraag.stelNaamIn(vraagNaam);
		vraag.stelLetterIn(letter);

		if (gegevenAntwoord != null)
		{
			vraag.geefAntwoord(gegevenAntwoord);
		}

		vragen.add(vraag);

		vraagNaam = null;
		antwoorden = new ArrayList<>();
		juisteAntwoordIndex = -1;
		gegevenAntwoord = null;
		letter = '.';

		return this;
	}

	public QuizBuilder stelGespeeldeTijdIn(int tijdInSeconden)
	{
		gespeeldeTijdInSeconden = tijdInSeconden;
		return this;
	}

	public QuizBuilder stelKostenIn(int kosten)
	{
		this.kosten = kosten;
		return this;
	}

	public QuizBuilder stelGespeeldWoordIn(String woord)
	{
		this.gelegdWoord = woord;
		return this;
	}

	public IQuiz build()
	{
		Quiz quiz = new Quiz();

		quiz.stelVragenIn(vragen);
		quiz.stelKostenIn(kosten);
		quiz.stelGespeeldeTijdIn(gespeeldeTijdInSeconden);
		quiz.legWoord(gelegdWoord);

		return quiz;
	}

}
