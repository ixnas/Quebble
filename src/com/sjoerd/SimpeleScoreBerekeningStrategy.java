package com.sjoerd;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SimpeleScoreBerekeningStrategy extends ScoreBerekeningStrategy
{

	public int haalScoreOp(SpelStatistieken spelStatistieken)
	{
		// Voorbeeld van een mogelijke scoreberekening
		/*
		return spelStatistieken.woordLengte *
				(spelStatistieken.aantalCorrecteAntwoorden / spelStatistieken.totaalAantalVragen) -
				spelStatistieken.gespeeldeTijdInSeconden;
		 */

		return spelStatistieken.aantalCorrecteAntwoorden;
	}

}
