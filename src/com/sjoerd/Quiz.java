package com.sjoerd;

import javafx.scene.paint.Stop;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Quiz implements IQuiz
{
	private int kosten;

	private ArrayList<IVraag> vragen;

	private Woord woord;

	private SpelStatistieken spelStatistieken;

	private Spelresultaat spelresultaat;

	private Stopwatch stopwatch;

	public Quiz()
	{
		kosten = 0;
		vragen = new ArrayList<>();
		spelStatistieken = new SpelStatistieken();
		spelresultaat = new Spelresultaat(spelStatistieken);
		stopwatch = new Stopwatch();
	}

	public void stelGespeeldeTijdIn(int tijdInSeconden)
	{
		spelStatistieken.gespeeldeTijdInSeconden = tijdInSeconden;
	}

	public void stelVragenIn(ArrayList<IVraag> vragen)
	{
		this.vragen = vragen;
	}

	public void stelKostenIn(int kosten)
	{
		if (kosten < 0)
		{
			throw new OngeldigBedragException();
		}

		this.kosten = kosten;
	}

	public boolean isGeldigeQuiz()
	{
		return vragen.size() == 8;
	}


	/**
	 * @see IQuiz#bevatZelfdeSetVragen(IQuiz)
	 */
	public boolean bevatZelfdeSetVragen(IQuiz quiz)
	{
		Quiz teVergelijkenQuiz = (Quiz) quiz;
		if (vragen.size() != teVergelijkenQuiz.vragen.size())
		{
			return false;
		}

		for (int i = 0; i < vragen.size(); i++)
		{
			if (!vragen.get(i).isDezelfdeVraag(teVergelijkenQuiz.vragen.get(i)))
			{
				return false;
			}
		}

		return true;
	}


	/**
	 * @see IQuiz#startQuiz()
	 */
	public void startQuiz()
	{
		stopwatch.Start();
	}


	/**
	 * @see IQuiz#haalQuizVraagOp()
	 */
	public String haalQuizVraagOp()
	{
		IVraag huidigeVraag = haalHuidigeVraagOp();
		return huidigeVraag.haalNaamOp();
	}


	/**
	 * @see IQuiz#haalMogelijkeAntwoordenOp()
	 */
	public ArrayList<String> haalMogelijkeAntwoordenOp()
	{
		IVraag huidigeVraag = haalHuidigeVraagOp();
		return huidigeVraag.haalAntwoordOptiesOp();
	}


	/**
	 * @see IQuiz#geefAntwoord(String)
	 */
	public void geefAntwoord(String antwoord)
	{
		IVraag huidigeVraag = haalHuidigeVraagOp();
		huidigeVraag.geefAntwoord(antwoord);
	}


	/**
	 * @see IQuiz#haalBehaaldeLettersOp()
	 */
	public ArrayList<Character> haalBehaaldeLettersOp()
	{
		ArrayList<Character> letters = new ArrayList<>();
		for (IVraag vraag : vragen)
		{
			if (!vraag.isCorrectBeantwoord())
			{
				continue;
			}

			char letter = vraag.haalLetterOp();
			letters.add(letter);
		}

		return letters;
	}


	/**
	 * @see IQuiz#stopQuiz()
	 */
	public void stopQuiz()
	{
		if (!alleVragenZijnBeantwoord() || woord == null)
		{
			throw new QuizNogNietAfgemaaktException();
		}

		Letter[] karaktersArray = (Letter[]) vragen
				.stream()
				.map(v -> new Letter(v.haalLetterOp()))
				.toArray();

		ArrayList<Letter> karakters = new ArrayList<>();
		Collections.addAll(karakters, karaktersArray);

		stopwatch.Stop();
		spelStatistieken.woordLengte = woord.haalLengteOp();
		spelStatistieken.gespeeldeTijdInSeconden = stopwatch.haalVerstrekenTijdInSecondenOp();
		spelStatistieken.totaalAantalVragen = vragen.size();
		spelStatistieken.aantalCorrecteAntwoorden = (int) vragen
				.stream()
				.filter(IVraag::isCorrectBeantwoord)
				.count();
	}


	/**
	 * @see IQuiz#legWoord(String)
	 */
	public void legWoord(String woord)
	{
		Woord nieuwWoord = new Woord(woord);

		ArrayList<Character> quizLetters = new ArrayList<>();

		for (IVraag vraag : vragen)
		{
			if (vraag.isCorrectBeantwoord())
			{
				quizLetters.add((Character) vraag.haalLetterOp());
			}
		}

		if (!nieuwWoord.isGeldigWoordGemaaktVan(quizLetters))
		{
			throw new OngeldigWoordException();
		}

		this.woord = nieuwWoord;
	}


	/**
	 * @see IQuiz#haalScoreOp()
	 */
	public int haalScoreOp()
	{
		return spelresultaat.haalScoreOp();
	}


	/**
	 * @see IQuiz#haalKostenOp()
	 */
	public int haalKostenOp()
	{
		return kosten;
	}


	/**
	 * @see IQuiz#alleVragenZijnBeantwoord()
	 */
	public boolean alleVragenZijnBeantwoord()
	{
		try
		{
			haalHuidigeVraagOp();
			return false;
		}
		catch (GeenOpenstaandeVragenMeerException e)
		{
			return true;
		}
	}


	private IVraag haalHuidigeVraagOp()
	{
		for (IVraag vraag : vragen)
		{
			if (!vraag.isBeantwoord())
			{
				return vraag;
			}
		}

		throw new GeenOpenstaandeVragenMeerException();
	}
}
