package com.sjoerd;

public class Quebble
{
	private Login login;

	private IAuthenticatieController iAuthenticatieController;

	private ICreditsController iCreditsController;

	private IQuizSpelenController iQuizSpelenController;

	public Quebble()
	{
		login = new Login();
		iAuthenticatieController = new AuthenticatieController(login);
		iCreditsController = new CreditsController(login);
		iQuizSpelenController = new QuizSpelenController(login);
	}

	public IAuthenticatieController haalAuthenticatieControllerOp()
	{
		return iAuthenticatieController;
	}

	public IQuizSpelenController haalQuizSpelenControllerOp()
	{
		return iQuizSpelenController;
	}

	public ICreditsController haalCreditsControllerOp()
	{
		return iCreditsController;
	}
}
