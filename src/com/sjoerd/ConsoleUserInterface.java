package com.sjoerd;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUserInterface
{

	private IAuthenticatieController iAuthenticatieController;

	private IQuizSpelenController iQuizSpelenController;

	private ICreditsController iCreditsController;

	private Quebble quebble;

	public ConsoleUserInterface()
	{
		quebble = new Quebble();
		iAuthenticatieController = quebble.haalAuthenticatieControllerOp();
		iQuizSpelenController = quebble.haalQuizSpelenControllerOp();
		iCreditsController = quebble.haalCreditsControllerOp();
	}

	public void startApplicatie()
	{
		iAuthenticatieController.logIn("Sjoerd", "wachtwoord");
		keuzeMenu();
	}

	private void keuzeMenu()
	{
		if (iAuthenticatieController.isIngelogd())
		{
			System.out.println("Je bent ingelogd als " + iAuthenticatieController.haalGebruikersnaamOp() + ".");
		}
		else
		{
			System.out.println("Je bent niet ingelogd.");
		}

		System.out.println("Maak een keuze:");
		System.out.println("1. Quiz spelen");

		String input = "";
		while (!input.equals("1"))
		{
			input = System.console().readLine();
			if (!input.equals("1"))
			{
				System.out.println("Ongeldige keuze.");
			}
		}
		speelQuiz();
	}

	private void speelQuiz()
	{
		System.out.println(iQuizSpelenController.haalUitlegOp());
		iQuizSpelenController.startNieuweQuiz();
		while (!iQuizSpelenController.alleVragenZijnBeantwoord())
		{
			System.out.println(iQuizSpelenController.haalQuizVraagOp());
			ArrayList<String> antwoorden = iQuizSpelenController.haalMogelijkeAntwoordenOp();
			for (String antwoord : antwoorden)
			{
				System.out.println(antwoord);
			}

			String gegevenAntwoord = System.console().readLine();

			try
			{
				iQuizSpelenController.geefAntwoord(gegevenAntwoord);
			}
			catch (OngeldigAntwoordException e)
			{
				System.out.println("Ongeldig antwoord.");
			}
		}

		System.out.println("Je hebt de volgende letters behaald:\n");
		ArrayList<Character> letters = iQuizSpelenController.haalBehaaldeLettersOp();
		for (char letter : letters)
		{
			System.out.print(letter + " ");
		}
		System.out.println();

		while (true)
		{
			try
			{
				String woord = System.console().readLine();
				iQuizSpelenController.legWoord(woord);
				break;
			}
			catch (OngeldigWoordException e)
			{
				System.out.println("Ongeldig woord.");
			}
		}
	}

}
