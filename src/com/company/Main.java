package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    String iniciar = "";



		int fila, columna;

		System.out.println("INICIAR JUEGO ?");
		iniciar = sc.next().toLowerCase();


		switch (iniciar){
			case "si":
				Bicho[][] array = new Bicho[2][2];
				int randomNumber = (int) (Math.random()*4+1);  ;
				System.out.println("PRIMER NUMERO ALEATORIO GENERADO " + randomNumber);

				for(int i = 0; i < randomNumber; i++){
					int secondRandomNumber = (int) (Math.random()*2+1);
					System.out.println("SEGUNDO NUMERO ALEATORIO GENERADO " + secondRandomNumber);

					if(secondRandomNumber == 1){
						BichoNormal bichoNormal = new BichoNormal();
						if(array[0][0] == null){
							array[0][0] = bichoNormal;
						}else{
							if(array[0][1] == null){
								array[0][1] = bichoNormal;
							}else{
								if(array[1][0] == null){
									array[1][0] = bichoNormal;
								}else{
									array[1][1] = bichoNormal;
								}
							}
						}
					}else{
						BichoAlien bichoAlien = new BichoAlien();
						if(array[0][0] == null){
							array[0][0] = bichoAlien;
						}else{
							if(array[0][1] == null){
								array[0][1] = bichoAlien;
							}else{
								if(array[1][0] == null){
									array[1][0] = bichoAlien;
								}else{
									array[1][1] = bichoAlien;
								}
							}
						}

					}
				}
				for(int h = 0; h < array.length; h++){
					System.out.println("__________________");
					for(int j = 0; j < array[h].length; j++){
						System.out.print("| ");
						if(array[h][j] != null){
							if(array[h][j].salud == 20){
								System.out.print(" BA-20 ");
							}else{
								System.out.print(" BN-10 ");
							}
						}else{
							System.out.print("       ");
						}
					}
					System.out.print("|");
					System.out.println("");
				}

				while(true){
					System.out.println("En qué posición desea disparar la bala, fila: ");
					fila = sc.nextInt();
					int contador = 0;

					System.out.println("Columna: ");
					columna = sc.nextInt();

					if(array[fila-1][columna-1] != null){
						if(array[fila-1][columna-1].salud > 0){
							array[fila-1][columna-1].setSalud(array[fila-1][columna-1].salud - 5);
							System.out.println("Muy bien, le diste!");
						}else{
							System.out.println("Ya lo mataste!");
						}

					}else{
						System.out.println("Ups, fallaste!");
					}

					for(int h = 0; h < array.length; h++){
						for(int j = 0; j < array[h].length; j++){
							if(array[h][j] != null){
								contador = array[h][j].salud;
							}
						}
					}


					for(int h = 0; h < array.length; h++){
						System.out.println("__________________");
						for(int j = 0; j < array[h].length; j++){
							System.out.print("| ");
							if(array[h][j] != null){
								if(array[h][j].salud == 20){
									System.out.print(" BA-"+array[h][j].salud);
								}else{
									System.out.print(" BN-"+array[h][j].salud);
								}
							}else{
								System.out.print("       ");
							}
						}
						System.out.print("|");
						System.out.println("");
					}

					if(contador == 0){
						System.out.println("──────────────────────────────────────────────────────────────────────────────────────────────────────────────────\n" +
								"─██████████████─██████████████─██████──────────██████─██████████████─██████████████─██████████████─██████████████─\n" +
								"─██░░░░░░░░░░██─██░░░░░░░░░░██─██░░██████████──██░░██─██░░░░░░░░░░██─██░░░░░░░░░░██─██░░░░░░░░░░██─██░░░░░░░░░░██─\n" +
								"─██░░██████████─██░░██████░░██─██░░░░░░░░░░██──██░░██─██░░██████░░██─██░░██████████─██████░░██████─██░░██████████─\n" +
								"─██░░██─────────██░░██──██░░██─██░░██████░░██──██░░██─██░░██──██░░██─██░░██─────────────██░░██─────██░░██─────────\n" +
								"─██░░██─────────██░░██████░░██─██░░██──██░░██──██░░██─██░░██████░░██─██░░██████████─────██░░██─────██░░██████████─\n" +
								"─██░░██──██████─██░░░░░░░░░░██─██░░██──██░░██──██░░██─██░░░░░░░░░░██─██░░░░░░░░░░██─────██░░██─────██░░░░░░░░░░██─\n" +
								"─██░░██──██░░██─██░░██████░░██─██░░██──██░░██──██░░██─██░░██████░░██─██████████░░██─────██░░██─────██░░██████████─\n" +
								"─██░░██──██░░██─██░░██──██░░██─██░░██──██░░██████░░██─██░░██──██░░██─────────██░░██─────██░░██─────██░░██─────────\n" +
								"─██░░██████░░██─██░░██──██░░██─██░░██──██░░░░░░░░░░██─██░░██──██░░██─██████████░░██─────██░░██─────██░░██████████─\n" +
								"─██░░░░░░░░░░██─██░░██──██░░██─██░░██──██████████░░██─██░░██──██░░██─██░░░░░░░░░░██─────██░░██─────██░░░░░░░░░░██─\n" +
								"─██████████████─██████──██████─██████──────────██████─██████──██████─██████████████─────██████─────██████████████─\n" +
								"──────────────────────────────────────────────────────────────────────────────────────────────────────────────────\n");
						break;
					}

				}

				break;

			default:
				System.out.println("Entendido");
		}





    }
}
