package com.sjoerd;

import java.util.ArrayList;

public class Woord
{

	private ArrayList<Letter> letters;

	public Woord(String woord)
	{
		letters = new ArrayList<>();
		char[] karakters = woord.toCharArray();

		for (char karakter : karakters)
		{
			try
			{
				letters.add(new Letter(karakter));
			}
			catch (OngeldigeLetterException e)
			{
				throw new OngeldigWoordException();
			}
		}
	}

	public String haalStringOp()
	{
		StringBuilder stringBuilder = new StringBuilder();

		for (Letter letter : letters)
		{
			stringBuilder.append(letter.haalKarakterOp());
		}

		return stringBuilder.toString();
	}

	public boolean isGeldigWoordGemaaktVan(ArrayList<Character> letters)
	{
		// Hier moet een call naar een validatielibrary komen
		for (Letter letter : this.letters)
		{
			boolean gevonden = false;
			for (char controleLetter : letters)
			{
				if (letter.haalKarakterOp() == controleLetter)
				{
					gevonden = true;
				}
			}
			if (!gevonden)
			{
				return false;
			}
		}
		return true;
	}

	public int haalLengteOp()
	{
		return letters.size();
	}

}
