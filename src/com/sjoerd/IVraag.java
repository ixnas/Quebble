package com.sjoerd;

import java.util.ArrayList;

public interface IVraag {

	public abstract ArrayList<String> haalAntwoordOptiesOp();

	public abstract boolean isCorrectBeantwoord();

	public abstract String haalNaamOp();

	public abstract void geefAntwoord(String antwoord);

	public abstract boolean isBeantwoord();

	public abstract boolean isDezelfdeVraag(IVraag vraag);

	public abstract char haalLetterOp();

}
