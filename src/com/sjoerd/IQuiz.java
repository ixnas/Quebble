package com.sjoerd;

import java.util.ArrayList;

public interface IQuiz {

	public abstract boolean bevatZelfdeSetVragen(IQuiz quiz);

	public abstract void startQuiz();

	public abstract String haalQuizVraagOp();

	public abstract ArrayList<String> haalMogelijkeAntwoordenOp();

	public abstract void geefAntwoord(String antwoord);

	public abstract ArrayList<Character> haalBehaaldeLettersOp();

	public abstract void stopQuiz();

	public abstract void legWoord(String woord);

	public abstract int haalScoreOp();

	public abstract int haalKostenOp();

	public abstract boolean alleVragenZijnBeantwoord();

}
