package com.sjoerd;

import java.util.ArrayList;

public class Speler implements ISpeler
{

	private String gebruikersnaam;

	private String wachtwoordHash;

	private int saldo;

	private ArrayList<IQuiz> alGespeeldeQuizzes;

	private IQuiz huidigeQuiz;

	public Speler()
	{
		gebruikersnaam = "";
		wachtwoordHash = "";
		alGespeeldeQuizzes = new ArrayList<>();
	}

	public void stelAlGespeeldeQuizzesIn(ArrayList<IQuiz> quizzes)
	{
		alGespeeldeQuizzes = quizzes;
	}

	public void stelGebruikersnaamIn(String gebruikersnaam)
	{
		this.gebruikersnaam = gebruikersnaam;
	}

	public void stelWachtwoordIn(String wachtwoord)
	{
		this.wachtwoordHash = wachtwoord;
	}


	/**
	 * @see ISpeler#stelHuidigeQuizIn(IQuiz)
	 */
	public void stelHuidigeQuizIn(IQuiz quiz)
	{
		huidigeQuiz = quiz;
	}


	/**
	 * @see ISpeler#voegGespeeldeQuizToe(IQuiz)
	 */
	public void voegGespeeldeQuizToe(IQuiz quiz)
	{
		alGespeeldeQuizzes.add(quiz);
	}


	/**
	 * @see ISpeler#rondHuidigeQuizAf()
	 */
	public void rondHuidigeQuizAf()
	{
		alGespeeldeQuizzes.add(huidigeQuiz);
		huidigeQuiz = null;
	}


	/**
	 * @see ISpeler#controleerWachtwoord(String)
	 */
	public boolean controleerWachtwoord(String wachtwoord)
	{
		return wachtwoord.equals(wachtwoordHash);
	}


	/**
	 * @see ISpeler#heeftOnafgemaakteQuiz()
	 */
	public boolean heeftOnafgemaakteQuiz()
	{
		return huidigeQuiz != null;
	}


	/**
	 * @see ISpeler#haalAlGespeeldeQuizzesOp()
	 */
	public ArrayList<IQuiz> haalAlGespeeldeQuizzesOp()
	{
		return alGespeeldeQuizzes;
	}


	/**
	 * @see ISpeler#haalOnafgemaakteQuizOp()
	 */
	public IQuiz haalOnafgemaakteQuizOp()
	{
		return huidigeQuiz;
	}


	/**
	 * @see ISpeler#waardeerSaldoOp(int)
	 */
	public void waardeerSaldoOp(int creditbedrag)
	{
		saldo += creditbedrag;
	}

}
