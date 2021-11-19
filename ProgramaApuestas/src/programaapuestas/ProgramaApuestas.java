
package programaapuestas;
import java.awt.Font;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*public class ProgramaApuestas {

	public static void main(String[] args) {

		// Configuracion de la interfaz grafica y tabla
		String[] columnNames = { "Juego", "Num iteracion", "$ antes de girar", "Apuesta", "Num aleatorio", "Color",
				"¿Ganó?", "$ despues de girar", "¿Se llegó a USD$1000?" };

		int TotalGanadas1 = 0, TotalGanadas2 = 0;

		System.out.print("¿Cuantos juegos desea simular? ");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		// Configuración tabla jugador 1
		DefaultTableModel dtm1 = new DefaultTableModel(new Object[][] {}, columnNames);
		JFrame f1 = new JFrame("Jugador 1");
		f1.resize(800, 400);
		JTable t1 = new JTable(dtm1);
		t1.setFont(new Font("Arial", Font.PLAIN, 16));
		JScrollPane js1 = new JScrollPane(t1);
		js1.setVisible(true);
		f1.add(js1);
		f1.setVisible(true);

		// Configuración tabla jugador 2
		DefaultTableModel dtm2 = new DefaultTableModel(new Object[][] {}, columnNames);
		JFrame f2 = new JFrame("Jugador 2");
		f2.resize(800, 400);
		JTable t2 = new JTable(dtm2);
		t2.setFont(new Font("Arial", Font.PLAIN, 16));
		JScrollPane js2 = new JScrollPane(t2);
		js2.setVisible(true);
		f2.add(js2);
		f2.setVisible(true);

		for (int i = 0; i < n; i++) { // Ciclo de juegos
			int ganadas1 = 0, ganadas2 = 0;
			dtm1.addRow(new Object[] { i + 1 });
			dtm2.addRow(new Object[] { i + 1 });
			// Inicializacion de variables
			int dineroJ1 = 200, dineroJ2 = 200;
			int apuesta1 = 1, apuesta2 = 1;
			int ronda = 0;
			while ((dineroJ1 > 0 || dineroJ2 > 0) && dineroJ1 < 1000 && dineroJ2 < 1000) { // Mientras ninguno de los 2 haya ganado o perdido
				ronda++;
				String color = "rojo";
				int dineroantes1 = dineroJ1;
				int dineroantes2 = dineroJ2;
				double a;
				do {
					a = Math.random();
					if (a > 10.0 / 22 && a <= 20.0 / 22)
						color = "negro";
					if (a > 20.0 / 22)
						color = "verde";
					if (color.equals("verde")) {
						dtm1.addRow(new Object[] { "", ronda, dineroantes1, apuesta1, a, color, "Nulo", dineroJ1,
								(dineroJ1 >= 1000 ? "Si" : "No") });
						dtm2.addRow(new Object[] { "", ronda, dineroantes2, apuesta2, a, color, "Nulo", dineroJ2,
								(dineroJ2 >= 1000 ? "Si" : "No") });
						ronda++;
					}
				} while (color.equals("verde")); // Mientras el color sea verde
				int apuestaAntes1 = apuesta1;
				int apuestaAntes2 = apuesta2;
				if (color == "rojo") { // Cuando ganan
					if (dineroJ1 > 0 && dineroJ1 < 1000)
						dineroJ1 += apuesta1;
					if (dineroJ2 > 0 && dineroJ2 < 1000) {
						dineroJ2 += apuesta2;
						apuesta2 = 1;
					}
				} else { // Cuando pierden
					if (dineroJ1 > 0 || dineroJ1 < 1000)
						dineroJ1 -= apuesta1;
					if (dineroJ2 > 0 || dineroJ2 < 1000) {
						dineroJ2 -= apuesta2;
						apuesta2 *= 2;
						if (apuesta2 > dineroJ2) // Si la apuesta es mayor al dinero que tiene, la apuesta es todo el dinero
							apuesta2 = dineroJ2;
						if (apuesta2 >= 1000) // Si la apuesta supera el limite, apuesta es 1
							apuesta2 = 1;
					}
				}
				dtm1.addRow(new Object[] { "", ronda, dineroantes1, apuestaAntes1, a, color,
						(color == "rojo") ? "Si" : "No", dineroJ1, (dineroJ1 >= 1000 ? "Si" : "No") });
				dtm2.addRow(new Object[] { "", ronda, dineroantes2, apuestaAntes2, a, color,
						(color == "rojo") ? "Si" : "No", dineroJ2, (dineroJ2 >= 1000 ? "Si" : "No") });
				if (dineroJ1 >= 1000) // Si el jugador 1 ha superado los 1000dlrs
					ganadas1++;
				if (dineroJ2 >= 1000) // Si el jugador 2 ha superado los 1000dlrs
					ganadas2++;
			}

			// Imprimir los resultados
			if (ganadas1 == 0 && ganadas2 == 0)
				System.out.println("Juego " + (i + 1) + ":No es recomendable ninguna estrategia");
			if (ganadas1 > ganadas2)
				System.out.println("Juego " + (i + 1) + ":Es recomendable la estrategia 1");
			if (ganadas2 > ganadas1)
				System.out.println("Juego " + (i + 1) + ":Es recomendable la estrategia 2");
			TotalGanadas1 += ganadas1;
			TotalGanadas2 += ganadas2;
		}
		// Probabilidades de los juegos en total
		System.out.println();
		System.out.println("La probabilidad de ganar con la estrategia 1 es de: " + (TotalGanadas1 * 1.0 / n) + "% "
				+ TotalGanadas1 + "/" + n);
		System.out.println("La probabilidad de ganar con la estrategia 2 es de: " + (TotalGanadas2 * 1.0 / n) + "% "
				+ TotalGanadas2 + "/" + n);
	}

}*/

public class ProgramaApuestas {
static int juegoGanado1,juegoGanado2;
	public static void main(String[] args) {
            Scanner In = new Scanner(System.in);
            int dineroJugador=0,ronda =0,n,dineroADG,dineroDPG=0,dineroDPG1=0,dineroDPG2=0;
            double R,D ;
            String color,colorD;
            String gano=null,metaA;
            System.out.print("Cuantas rondas desea jugar: ");
            int seleccion = In.nextInt();
            for(int j=1;j<=seleccion;j++)
            {
                ronda++;
                System.out.println("\n");
                System.out.println("Ronda: "+ronda);
                for(int i = 1;i<=2;i++)
                {
                    int apuesta,dinero =200;
                    dineroADG=dinero;
                    System.out.println("Jugador "+i);
                    System.out.println("#iteracion\tDinero antes de girar\tApuesta\t\t#aleatorio\t\tColor\t\tGano?\tDinero despues de tirar\t\tSe llego a 1000 USD\tExito++");
                    n=1;
                    if(i==1)
                    {
                        
                        juegoGanado1=0;
                        do
                      {

                        colorD="Rojo";
                        apuesta=1;

                        R = Math.random();
                        if(R>=0&&R<=0.4545)
                        {
                            color = "Rojo";
                            if("Rojo".equals(colorD))
                            {
                                gano="Si";
                                juegoGanado1++;
                                dineroDPG=dineroADG+apuesta;
                            }else if("Rojo".equals(colorD)==false)
                            {
                                gano="No";
                                dineroDPG=dineroADG-apuesta;
                            }

                        }
                        else if(R>=0.4545&&R<=0.9090)
                        {
                            color = "Negro";
                            if("Negro".equals(colorD))
                            {
                                gano="Si";
                                juegoGanado1++;
                                dineroDPG=dineroADG+apuesta;
                            }else if("Negro".equals(colorD)==false)
                            {
                                gano="No";
                                dineroDPG=dineroADG-apuesta;
                            }
                        }
                        else
                        {
                            color = "Verde";
                            if("Verde".equals(colorD))
                            {
                                gano="Nulo";
                            }else if("Verde".equals(colorD)==false)
                            {
                                gano="No";
                                dineroDPG=dineroADG-apuesta;
                            }
                        }

                       if(dineroDPG>=1000)
                       {
                           metaA="Si";
                       }
                       else
                       {
                           metaA="No";
                       }

                        
                        if("Si".equals(gano))
                        {
                            System.out.println(n+"\t\t\t"+dineroADG+"\t\t  "+apuesta+"\t\t"+R+"\t"+color+"\t\t"+gano+"\t\t"+dineroDPG+"\t\t\t\t"+metaA+"\t\t   "+juegoGanado1);
                        }
                        else
                        {
                        System.out.println(n+"\t\t\t"+dineroADG+"\t\t  "+apuesta+"\t\t"+R+"\t"+color+"\t\t"+gano+"\t\t"+dineroDPG+"\t\t\t\t"+metaA+"\t\t"+" ");
                        }
                        dineroADG=dineroDPG;
                        n++;
                        dineroJugador=dineroDPG;
                    }while(dineroDPG>0&&dineroDPG<1000);
                        if(dineroJugador>=1000)
                        {
                            System.out.println("La estrategia 1 es recomendable");
                            System.out.println("");
                        }
                        if(dineroJugador<=0)
                        {
                          System.out.println("La estrategia 1 no es recomendable");
                          System.out.println("");
                        }
                        dineroDPG1=dineroDPG;
                    }
                    
                    if(i==2)
                    {
                        juegoGanado2=0;
                        
                        apuesta=1;
                        do
                       {
                           
                       D = Math.random();
                        if(D>=0&&D<=0.4545)
                        {
                            colorD = "Rojo";

                        }
                        else if(D>=0.4545&&D<=0.9090)
                        {
                            colorD = "Negro";
                        }
                        else
                        {
                            colorD = "Verde";
                        } 

                        R = Math.random();
                        if(R>=0&&R<=0.4545)
                        {
                            color = "Rojo";
                            if("Rojo".equals(colorD))
                            {
                                gano="Si";
                                juegoGanado2++;
                                dineroDPG=dineroADG+apuesta;

                            }else if("Rojo".equals(colorD)==false)
                            {
                                gano="No";
                                dineroDPG=dineroADG-apuesta;
                                
                            }

                        }
                        else if(R>=0.4545&&R<=0.9090)
                        {
                            color = "Negro";
                            if("Negro".equals(colorD))
                            {
                                gano="Si";
                                juegoGanado2++;
                                dineroDPG=dineroADG+apuesta;
                            }else if("Negro".equals(colorD)==false)
                            {
                                gano="No";
                                dineroDPG=dineroADG-apuesta;
                                
                            }
                        }
                        else
                        {
                            color = "Verde";
                            if("Verde".equals(colorD))
                            {
                                gano="Nulo";
                            }else if("Verde".equals(colorD)==false)
                            {
                                gano="No";
                                dineroDPG=dineroADG-apuesta;
                                
                            }
                        }

                       if(dineroDPG>=1000)
                       {
                           metaA="Si";
                       }
                       else
                       {
                           metaA="No";
                       }

                        
                        if("Si".equals(gano))
                        {
                            System.out.println(n+"\t\t\t"+dineroADG+"\t\t  "+apuesta+"\t\t"+R+"\t"+color+"\t\t"+gano+"\t\t"+dineroDPG+"\t\t\t\t"+metaA+"\t\t   "+juegoGanado2);
                        }
                        else if("No".equals(gano))
                        {
                            System.out.println(n+"\t\t\t"+dineroADG+"\t\t  "+apuesta+"\t\t"+R+"\t"+color+"\t\t"+gano+"\t\t"+dineroDPG+"\t\t\t\t"+metaA+"\t\t"+" ");
                            apuesta=apuesta*2;
                        }
                        else 
                        {
                            System.out.println(n+"\t\t\t"+dineroADG+"\t\t  "+apuesta+"\t\t"+R+"\t"+color+"\t\t"+gano+"\t\t"+dineroDPG+"\t\t\t\t"+metaA+"\t\t"+" ");
                            
                        }
                        dineroADG=dineroDPG;
                        if(apuesta>=500)
                        {
                            apuesta=1;
                        }
                        n++;
                        dineroJugador=dineroDPG;
                    }while(dineroDPG>0&&dineroDPG<1000);
                        if(dineroJugador>=1000)
                        {
                            System.out.println("La estrategia 2 es recomendable");
                            System.out.println("");
                        }
                        if(dineroJugador<=0)
                        {
                          System.out.println("La estrategia 2 no es recomendable"); 
                          System.out.println("");
                        }
                        dineroDPG2=dineroDPG;
                    }
                }
                
                if((dineroDPG1>=1000&&dineroDPG2<1000)||(dineroDPG1>dineroDPG2))
                {
                    System.out.println("La estrategia 1 es mejor que la 2");
                }
                if((dineroDPG2>=1000&&dineroDPG1<1000)||(dineroDPG2>dineroDPG1))
                {
                    System.out.println("La estrategia 2 es mejor que la 1");
                }
                if(dineroDPG1>=1000&&dineroDPG2>=1000)
                {
                    System.out.println("Ambas estrategia son viable");
                }
                if(((juegoGanado2-juegoGanado1)==0)||dineroDPG1<1000&&dineroDPG2<1000)
                {
                    System.out.println("Ninguna estrategia es viable");
                }
                
               
            }
        }

}

