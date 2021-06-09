package com.sjoerd;

import java.util.Map;

public interface ICreditsController {

	public abstract Map<Integer,Integer> haalAantallenEnPrijzenInCentenOp();

	public abstract void koopCredits(int aantal);

}
