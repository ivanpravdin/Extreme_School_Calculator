import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.Scanner;
import java.util.Date;

	//
	//Extreme School Calculator
	//

public class Main {
	
	public static double math(String equation) { // Function calculating simple math equations
		String[] splited = equation.split("\\s+"); // Splitting equation by space to get elements of it
		double result = Double.parseDouble(splited[0]);
		for (int i = 1; i<splited.length; i+=2) {
			if(splited[i].equals("+")) {  
				result += Double.parseDouble(splited[i+1]);
			}
			if(splited[i].equals("-")) {
				result -= Double.parseDouble(splited[i+1]);
			}
			if(splited[i].equals("*")) {
				result *= Double.parseDouble(splited[i+1]);
			}
			if(splited[i].equals("/")) {
				result /= Double.parseDouble(splited[i+1]);
			}
		}
		return result;
	}
	
	public static void Study_Hours(int y) { // Function for getting information about study hours
		LocalDate now = LocalDate.now(); // Getting today's date
		if (now.compareTo(LocalDate.of(2020, 10, 19))>=0) {
			if (y==1) {
				System.out.println("Study Hours is required. Hall Cross OK.");
			} else {
				System.out.println("No Study Hours required.");
			}
		}
		else if (now.compareTo(LocalDate.of(2020, 10, 5))>=0) {
			if (y==4) {
				System.out.println("No Study Hours required");
			} else {
				System.out.println("Study Hours is required. Hall Cross OK.");
			}
		}
		else if (now.compareTo(LocalDate.of(2020, 9, 21))>=0) {
			if (y==4) {
				System.out.println("No Study Hours required.");
			} else {
				System.out.println("Study Hours is required. In own hall.");
			}
		} else {
			if (y==4) {
				System.out.println("No Study Hours required.");
			} else {
				System.out.println("Study Hours is required. In room.");
			}
		}
	}
	
	public static void Sleeping_calc(int wake_or_go, String wake_time) { // Function for Sleeping Calculator
		Date date = new Date();
		if (wake_or_go == 2) {
			String[] splited = wake_time.split(":");
			long minutes = Long.parseLong(splited[0])*60+Long.parseLong(splited[1]);
			long option_1 = minutes-90*5+15+24*60;
			long option_2 = minutes-90*6+15+24*60;
			System.out.println("We recommend you to go to bed at: "+(option_2/60%24)+":"+option_2%60+" or "+(option_1/60%24)+":"+option_1%60);
			
		} else {
			long minutes = date.toInstant().atZone(ZoneId.systemDefault()).getHour()*60+
					date.toInstant().atZone(ZoneId.systemDefault()).getMinute();
			long option_1 = minutes+90*5+15;
			long option_2 = minutes+90*6+15;
			System.out.println("We recommend you to wake up at: "+(option_1/60%24)+":"+option_1%60+" or "+(option_2/60%24)+":"+option_2%60);
		}
	}
	
	public static void hex_dec_bin(String base, String res, String num){ // Function for converting Hex to Bin to Dec
		if (base.equals("hex")) {
			if (res.equals("dec")) {
				int decimal=Integer.parseInt(num,16);
				System.out.println("Number in decimal: "+decimal);
			} else {
				int decimal=Integer.parseInt(num,16);
				System.out.println("Number in binary: "+Integer.toBinaryString(decimal));
			}
		} else if (base.equals("dec")) {
			if (res.equals("bin")) {
				System.out.println("Number in binary: "+Integer.toBinaryString(Integer.parseInt(num)));
			} else {
				System.out.println("Number in hexadecimal: "+Integer.toHexString(Integer.parseInt(num)));
			}
		} else {
			if (res.equals("dec")) {
				System.out.println("Number in decimal: "+Integer.parseInt(num,2));
			} else {
				int dec = Integer.parseInt(num,2);
				System.out.println("Number in hexadecimal: "+Integer.toHexString(dec));
			}
		}
	}
	
	public static long factorial(long n) { // Function for calculation of the factorial
		long result = 1;
		for(int i = 2; i<=n; i++) result *= i;
		return result;
	}
	
	public static void pascal_triangle(long row) { // Function for printing Pascal's triangle
		for (long i = 0; i<=row; i++) {
			for(int a = 0; a <= row-i; a++){
	            System.out.print(" ");
	         }
			for (long j = 0; j<=i; j++) {
				System.out.print(factorial(i)/(factorial(j)*factorial(i-j))+"  ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws OutOfMemoryError { 
		
		Scanner sc = new Scanner(System.in);
		System.out.println("**WELCOME TO THE EXTREME SCHOOL CALCULATOR**");
		System.out.println("============================================");
		System.out.println();
		while (true) {
			System.out.println("Please choose the function you want to use:");
			System.out.println("1 - Math Calculator");
			System.out.println("2 - Study Hours");
			System.out.println("3 - Sleeping calculator");
			System.out.println("4 - Pascal's triangle");
			System.out.println("5 - Hex to Bin to Dec Converter");
			System.out.println();
			int n = sc.nextInt();
			System.out.println();
			if (n == 1) {
				System.out.println("Please write down math equation in the following format: 5 * 7 + 8");
				sc.nextLine();
				String equation = sc.nextLine();
				System.out.println();
				System.out.println("The result is: "+math(equation));
			} else if (n == 2) {
				System.out.println("Please write down your year:");
				int y = sc.nextInt();
				System.out.println();
				Study_Hours(y);
			} else if (n == 3) {
				System.out.println("Do you want to calculate when to wake up or when to get to bed? [1/2]");
				int c = sc.nextInt();
				System.out.println();
				if(c == 2) {
					System.out.println("Please write down when you want to get wake up in the following format: 8:45");
					sc.nextLine();
					String wake_time = sc.nextLine();
					System.out.println();
					Sleeping_calc(c, wake_time);
				} else {
					System.out.println();
					Sleeping_calc(c, " ");
				}
			} else if (n == 4) {
				System.out.println("Please write down the number of the last row:");
				long row = sc.nextLong();
				 pascal_triangle(row);
			} else if (n == 5) {
				System.out.println("Please write down the base of the number you want to convert in the following format: hex/dec/bin");
				String base = sc.next();
				System.out.println();
				System.out.println("Please write down the base you want to convert your number to in the following format: hex/dec/bin");
				String res = sc.next();
				System.out.println();
				System.out.println("Please write down the number you want to convert:");
				String num = sc.next();
				System.out.println();
				hex_dec_bin(base, res, num);
				System.out.println();
			} else {
				System.out.println("No such option.");
				System.out.println();
			}
			System.out.println();
			System.out.println("Do you want to continue? [y/n]");
			String answer = sc.next();
			if (answer.equals("n")) {
				System.out.println();
				System.out.println("Thank you for using ESC! We hope to see you again!");
				break;
			}
			System.out.println();
		}
	}
}

