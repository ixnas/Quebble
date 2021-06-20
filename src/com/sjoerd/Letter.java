package com.sjoerd;

public class Letter
{

	private char karakter;

	public Letter(char letter)
	{
		char kleineLetter = Character.toLowerCase(letter);

		if (kleineLetter < 'a' || kleineLetter > 'z')
		{
			throw new OngeldigeLetterException();
		}

		karakter = kleineLetter;
	}

	public char haalKarakterOp()
	{
		return karakter;
	}

}
