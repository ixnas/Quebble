package com.sjoerd;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class QuizSpelenController implements IQuizSpelenController
{

	private IQuiz iQuiz;

	private QuizRepository quizRepository;

	private IHuidigeLogin iHuidigeLogin;

	public QuizSpelenController(IHuidigeLogin huidigeLogin)
	{
		quizRepository = QuizRepository.getInstance();
		iHuidigeLogin = huidigeLogin;
	}


	/**
	 * @see IQuizSpelenController#startNieuweQuiz()
	 */
	public void startNieuweQuiz()
	{
		ISpeler speler = iHuidigeLogin.haalSpelerOp();

		if (speler.heeftOnafgemaakteQuiz())
		{
			throw new SpelerHeeftOnafgemaakteQuizException();
		}

		ArrayList<IQuiz> alGespeeldeQuizzes = speler.haalAlGespeeldeQuizzesOp();
		iQuiz = quizRepository.haalQuizOp(alGespeeldeQuizzes);
		speler.schrijfVanSaldoAf(iQuiz.haalKostenOp());
		speler.stelHuidigeQuizIn(iQuiz);
		iQuiz.startQuiz();
	}


	/**
	 * @see IQuizSpelenController#startWillekeurigeQuiz()
	 */
	public void startWillekeurigeQuiz()
	{
		ISpeler speler = iHuidigeLogin.haalSpelerOp();
		iQuiz = quizRepository.haalQuizOp(new ArrayList<>());
		speler.schrijfVanSaldoAf(iQuiz.haalKostenOp());
		speler.stelHuidigeQuizIn(iQuiz);
		iQuiz.startQuiz();
	}


	/**
	 * @see IQuizSpelenController#hervatOpenstaandeQuiz()
	 */
	public void hervatOpenstaandeQuiz()
	{
		ISpeler speler = iHuidigeLogin.haalSpelerOp();
		iQuiz = speler.haalOnafgemaakteQuizOp();
		iQuiz.startQuiz();
	}


	/**
	 * @see IQuizSpelenController#haalUitlegOp()
	 */
	public String haalUitlegOp()
	{
		return "Quebble bevat een grote verzameling quizzen die elk uit acht vragen bestaan. Elke quiz is een mix van meerkeuzevragen (met steeds vier alternatieven) en kort-antwoord-vragen. Bij meerkeuzevragen vul je de letter in van je gekozen antwoord. Bij de open vragen typ je een kort antwoord. Bij open vragen kunnen meerdere antwoorden goed zijn.";
	}


	/**
	 * @see IQuizSpelenController#haalQuizVraagOp()
	 */
	public String haalQuizVraagOp()
	{
		return iQuiz.haalQuizVraagOp();
	}


	/**
	 * @see IQuizSpelenController#haalMogelijkeAntwoordenOp()
	 */
	public ArrayList<String> haalMogelijkeAntwoordenOp()
	{
		return iQuiz.haalMogelijkeAntwoordenOp();
	}


	/**
	 * @see IQuizSpelenController#geefAntwoord(String)
	 */
	public void geefAntwoord(String antwoord)
	{
		iQuiz.geefAntwoord(antwoord);
	}


	/**
	 * @see IQuizSpelenController#haalBehaaldeLettersOp()
	 */
	public ArrayList<Character> haalBehaaldeLettersOp()
	{
		return iQuiz.haalBehaaldeLettersOp();
	}


	/**
	 * @see IQuizSpelenController#legWoord(String)
	 */
	public void legWoord(String woord)
	{
		iQuiz.legWoord(woord);
	}


	/**
	 * @see IQuizSpelenController#haalScoreOp()
	 */
	public int haalScoreOp()
	{
		return iQuiz.haalScoreOp();
	}


	/**
	 * @see IQuizSpelenController#alleVragenZijnBeantwoord()
	 */
	public boolean alleVragenZijnBeantwoord()
	{
		return iQuiz.alleVragenZijnBeantwoord();
	}

}
