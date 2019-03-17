package ai.play.devtech.core.web.objects;

import ai.play.devtech.APIObject;
import java.util.Date;

/**
 * A transaction using an alliances bank
 *
 * @author devan
 */
public class BankTransaction {

	Date date;
	APIObject sender;
	APIObject reciever;
	APIObject banker;
	public double money = 0;
	public double coal = 0;
	public double oil = 0;
	public double iron = 0;
	public double bauxite = 0;
	public double steel = 0;
	public double aluminum = 0;
	public double gasoline = 0;
	public double uranium = 0;
	public double lead = 0;
	public double munitions = 0;
	public double food = 0;

}
