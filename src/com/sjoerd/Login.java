package com.sjoerd;

public class Login implements IHuidigeLogin, ILoginBeheerder
{

	private ISpeler iSpeler;


	/**
	 * @see IHuidigeLogin#haalSpelerOp()
	 */
	public ISpeler haalSpelerOp()
	{
		if (!isIngelogd())
		{
			throw new NietIngelogdException();
		}
		return iSpeler;
	}


	/**
	 * @see ILoginBeheerder#login(ISpeler)
	 */
	public void login(ISpeler speler)
	{
		if (speler == null)
		{
			throw new NullPointerException();
		}

		iSpeler = speler;
	}


	/**
	 * @see ILoginBeheerder#logUit()
	 */
	public void logUit()
	{
		if (!isIngelogd())
		{
			throw new NietIngelogdException();
		}
		iSpeler = null;
	}


	/**
	 * @see ILoginBeheerder#isIngelogd()
	 */
	public boolean isIngelogd()
	{
		return iSpeler != null;
	}

}
