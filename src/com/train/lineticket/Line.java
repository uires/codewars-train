package com.train.lineticket;

/*
	The new "Avengers" movie has just been released! There are a lot of people at the cinema box office 
	standing in a huge line. Each of them has a single 100, 50 or 25 dollar bill. An "Avengers" ticket 
	costs 25 dollars.
	Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.
	
	Can Vasya sell a ticket to every person and give change if he initially has no money and sells the 
	tickets strictly in the order people queue?
	
	Return YES, if Vasya can sell a ticket to every person and give change with the bills he has at hand 
	at that moment. Otherwise return NO.
	
	Examples:
	Line.Tickets(new int[] {25, 25, 50}) // => YES 
	Line.Tickets(new int[]{25, 100}) // => NO. Vasya will not have enough money to give change to 100 dollars
	Line.Tickets(new int[] {25, 25, 50, 50, 100}) // => NO. Vasya will not have the right bills to
*/
/**
 * @author uires
 */

public class Line {

	public static int TICKET_VALUE = 25;

	public static String Tickets(int[] peopleInLine) {

		int valorEmCaixa = 0;
		if (peopleInLine[0] > TICKET_VALUE)
			return "NO";

		for (int people : peopleInLine) {

			System.out.println("R$ " + people);
			System.out.println("Valor em caixa R$ " + valorEmCaixa);
			if (people == TICKET_VALUE) {
				
				valorEmCaixa += people;
				System.out.println("Valor em caixa ajustado R$ " + valorEmCaixa);
			} else {

				valorEmCaixa += people;
				System.out.println("Valor em caixa ajustado R$ " + valorEmCaixa);
				int retorno = (people - TICKET_VALUE);
				System.out.println("Troco é R$ " + retorno);
				if (valorEmCaixa < retorno) {
					
					return "NO";
				}
			}
			System.out.println("------------------------");
		}
		System.out.println("Valor em caixa final R$ " + valorEmCaixa);

		return "YES";
	}
}