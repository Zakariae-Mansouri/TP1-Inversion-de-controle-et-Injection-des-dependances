package pres;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

import dao.DaoImpl;
import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;

public class Pres1 {

	public static void main(String[] args) throws Exception {
		/*
		 * Injection des dépendances par instanciation statique
         *		
		 * DaoImpl dao = new DaoImpl(); 
		 * MetierImpl metier = new MetierImpl();
		 * metier.setDao(dao); 
		 * System.out.println(metier.calcul());
		 */

		Scanner scanner = new Scanner(new File("config.txt"));
		
		String daoClassName = scanner.nextLine();
		Class cDao = Class.forName(daoClassName);// pour charger la classe en mémoire
		IDao dao = (IDao) cDao.newInstance();
		
		String metierClassName=scanner.nextLine();
		Class cMetier=Class.forName(metierClassName);
		IMetier metier=(IMetier) cMetier.newInstance();
		
		Method m=cMetier.getMethod("setDao", IDao.class);//pour chercher une methode qui prend un parametre IDao
		m.invoke(metier, dao);//invoquer la methode m(setDao) sur l'objet metier en lui passant le parametre dao 
		System.out.println(metier.calcul());

	}

}
