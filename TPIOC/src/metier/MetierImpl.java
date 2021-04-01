package metier;

import dao.IDao;

public class MetierImpl implements IMetier {
	/*
	 * Couplage faible
	 */
	private IDao dao;

	@Override
	public double calcul() {
		double d = dao.getData();
		double res = d * 22;
		return res;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}

}
