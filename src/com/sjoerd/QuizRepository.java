package com.sjoerd;

import java.util.ArrayList;

public class QuizRepository
{

	private static QuizRepository quizRepository;

	public static QuizRepository getInstance()
	{
		if (quizRepository == null)
		{
			quizRepository = new QuizRepository();
		}

		return quizRepository;
	}

	public IQuiz haalQuizOp(ArrayList<IQuiz> uitgezonderdeQuizzes)
	{
		ArrayList<IQuiz> quizzes = new ArrayList<>();

		QuizBuilder quizBuilder = new QuizBuilder();
		IQuiz quiz = quizBuilder
				.stelKostenIn(40)
				.stelVraagNaamIn("Wat is de hoofdstad van Peru?")
				.stelAntwoordenIn(new ArrayList<String>()
				{
					{
						add("Arequipa");
						add("Caracas");
						add("Lima");
						add("Santiago");
					}
				})
				.stelJuisteAntwoordIn(2)
				.stelLetterIn('c')
				.voegIngesteldeVraagToeAanQuiz()
				.stelVraagNaamIn("Hoe het het officieuze landenkampioenschap tennis voor mannen?")
				.stelAntwoordenIn(new ArrayList<String>()
				{
					{
						add("Davis Cup");
						add("Diamond League");
						add("Fed Cup");
						add("Nations League");
					}
				})
				.stelJuisteAntwoordIn(0)
				.stelLetterIn('d')
				.voegIngesteldeVraagToeAanQuiz()
				.stelVraagNaamIn("Wat is de voornaam van de schepper van Miss Marple en Hercule Poirot?")
				.stelAntwoordenIn(new ArrayList<String>()
				{
					{
						add("Ruth");
						add("Emmy");
						add("Joanne");
						add("Agatha");
					}
				})
				.stelJuisteAntwoordIn(3)
				.stelLetterIn('a')
				.voegIngesteldeVraagToeAanQuiz()
				.stelVraagNaamIn("Welke van de volgende Engelse voetbalclub is afkomstig uit Liverpool?")
				.stelAntwoordenIn(new ArrayList<String>()
				{
					{
						add("Arsenal");
						add("Chelsea");
						add("Everton");
						add("Tottenham Hotspur");
					}
				})
				.stelJuisteAntwoordIn(2)
				.stelLetterIn('e')
				.voegIngesteldeVraagToeAanQuiz()
				.stelVraagNaamIn("Wat is de hoofdstad van het Franse departement Vaucluse die we kennen uit een heel bekend liedje over een brug?")
				.stelAntwoordenIn(new ArrayList<String>()
				{
					{
						add("Avignon");
					}
				})
				.stelLetterIn('a')
				.voegIngesteldeVraagToeAanQuiz()
				.stelVraagNaamIn("Welke band stond in 2008 in de hitparade met de song Viva La Vida?")
				.stelAntwoordenIn(new ArrayList<String>()
				{
					{
						add("Coldplay");
					}
				})
				.stelLetterIn('c')
				.voegIngesteldeVraagToeAanQuiz()
				.stelVraagNaamIn("Wat is de bijnaam van de Conservatieve Partij in Engeland?")
				.stelAntwoordenIn(new ArrayList<String>()
				{
					{
						add("Tory");
						add("Tories");
						add("The Tories");
					}
				})
				.stelLetterIn('t')
				.voegIngesteldeVraagToeAanQuiz()
				.stelVraagNaamIn("Welke stad ligt in twee continenten?")
				.stelAntwoordenIn(new ArrayList<String>()
				{
					{
						add("Istanboel");
						add("Istanbul");
					}
				})
				.stelLetterIn('i')
				.voegIngesteldeVraagToeAanQuiz()
				.build();

		quizzes.add(quiz);

		if (uitgezonderdeQuizzes.size() == 0)
		{
			return quiz;
		}

		for (IQuiz uitgezonderdeQuiz : uitgezonderdeQuizzes)
		{
			for (IQuiz interneQuiz : quizzes)
			{
				if (uitgezonderdeQuiz.bevatZelfdeSetVragen(interneQuiz))
				{
					continue;
				}

				return interneQuiz;
			}
		}

		throw new GeenQuizzesBeschikbaarException();
	}

}
