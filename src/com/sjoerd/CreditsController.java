package com.sjoerd;

import java.util.Map;

public class CreditsController implements ICreditsController {

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
	public Map<Integer,Integer> haalAantallenEnPrijzenInCentenOp() {
		return null;
	}


	/**
	 * @see ICreditsController#koopCredits(int)
	 */
	public void koopCredits(int aantal) {

	}

}
