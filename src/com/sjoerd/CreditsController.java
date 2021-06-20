package com.sjoerd;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Map;

public class CreditsController implements ICreditsController
{

	private CreditOpwaardeerOptiesRepository creditOpwaardeerOptiesRepository;

	private CreditOpwaardeerOptie[] creditOpwaardeerOptie;

	private IHuidigeLogin iHuidigeLogin;

	private Betaalsysteem betaalsysteem;

	public CreditsController(IHuidigeLogin huidigeLogin)
	{
		iHuidigeLogin = huidigeLogin;
	}


	/**
	 * @see ICreditsController#haalAantallenEnPrijzenInCentenOp()
	 */
	public Map<Integer, Integer> haalAantallenEnPrijzenInCentenOp()
	{
		throw new NotImplementedException();
	}


	/**
	 * @see ICreditsController#koopCredits(int)
	 */
	public void koopCredits(int aantal)
	{
		throw new NotImplementedException();
	}

}
