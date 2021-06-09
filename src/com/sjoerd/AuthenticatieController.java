package com.sjoerd;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class AuthenticatieController implements IAuthenticatieController
{

	private SpelerRepository spelerRepository;

	private ILoginBeheerder iLoginBeheerder;

	public AuthenticatieController(ILoginBeheerder loginBeheerder)
	{
		spelerRepository = SpelerRepository.getInstance();
		iLoginBeheerder = loginBeheerder;
	}


	/**
	 * @see IAuthenticatieController#registreer(String, String)
	 */
	public void registreer(String gebruikersnaam, String wachtwoord)
	{
		throw new NotImplementedException();
	}


	/**
	 * @see IAuthenticatieController#logIn(String, String)
	 */
	public void logIn(String gebruikersnaam, String wachtwoord)
	{
		ISpeler speler = spelerRepository.haalSpelerOp(gebruikersnaam);
		speler.controleerWachtwoord(wachtwoord);
		iLoginBeheerder.login(speler);
	}


	/**
	 * @see IAuthenticatieController#logUit()
	 */
	public void logUit()
	{
		iLoginBeheerder.logUit();
	}


	/**
	 * @see IAuthenticatieController#isIngelogd()
	 */
	public boolean isIngelogd()
	{
		return iLoginBeheerder.isIngelogd();
	}

}
