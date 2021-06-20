package com.sjoerd;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public abstract class Vraag implements IVraag
{

	private String naam;

	protected Antwoord gegevenAntwoord;

	private Categorie categorie;

	private Letter letter;

	public static Vraag maakOpenVraag(ArrayList<String> antwoorden)
	{
		return new OpenVraag(antwoorden);
	}

	public static Vraag maakMeerkeuzeVraag(ArrayList<String> antwoorden, int goedAntwoordIndex)
	{
		return new MeerkeuzeVraag(antwoorden, goedAntwoordIndex);
	}

	public abstract ArrayList<String> haalAntwoordOptiesOp();

	public abstract boolean isCorrectBeantwoord();

	public void stelNaamIn(String naam)
	{
		if (naam == null)
		{
			throw new OngeldigeVraagException();
		}

		this.naam = naam;
	}

	public void stelLetterIn(char letter)
	{
		this.letter = new Letter(letter);
	}


	/**
	 * @see IVraag#haalNaamOp()
	 */
	public String haalNaamOp()
	{
		if (naam == null)
		{
			throw new NullPointerException();
		}

		return naam;
	}


	/**
	 * @see IVraag#geefAntwoord(String)
	 */
	public abstract void geefAntwoord(String antwoord);


	/**
	 * @see IVraag#isBeantwoord()
	 */
	public boolean isBeantwoord()
	{
		return gegevenAntwoord != null;
	}


	/**
	 * @see IVraag#isDezelfdeVraag(IVraag)
	 */
	public boolean isDezelfdeVraag(IVraag vraag)
	{
		throw new NotImplementedException();
	}


	/**
	 * @see IVraag#haalLetterOp()
	 */
	public char haalLetterOp()
	{
		return letter.haalKarakterOp();
	}

}
