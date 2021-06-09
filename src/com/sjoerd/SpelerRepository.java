package com.sjoerd;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SpelerRepository {

	private static SpelerRepository spelerRepository;

	public static SpelerRepository getInstance() {
		if (spelerRepository == null)
		{
			spelerRepository = new SpelerRepository();
		}

		return spelerRepository;
	}

	public ISpeler haalSpelerOp(String gebruikersnaam) {
		if (!gebruikersnaam.equals("Sjoerd"))
		{
			throw new SpelerNietGevondenException();
		}

		Speler speler = new Speler();
		speler.stelGebruikersnaamIn("Sjoerd");
		speler.stelWachtwoordIn("wachtwoord");

		return speler;
	}

	public void voegSpelerToe(String gebruikersnaam, String wachtwoord) {
		throw new NotImplementedException();
	}

}
