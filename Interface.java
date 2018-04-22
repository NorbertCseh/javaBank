package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interface extends ATM {
    Scanner scan = new Scanner(System.in);
    int answer=0;
    long subject;


    public void runApp(int task, Clients who){
            switch(task){
                case 0:
                    mainMenu();
                    break;
                case 1:
                    System.out.println("A jelenlegi egyenleg: "+balance(who)+" Ft\n");
                    answer = returnOrExit();
                    break;
                case 2:
                    System.out.println("Uj egyenleg: "+loadBalance(who)+" Ft");
                    answer = returnOrExit();
                    break;
                case 3:
                    System.out.println("Uj egyenleg: "+withdrawn(who));
                    answer = returnOrExit();
                    break;
                case 4:
                    System.out.println("Uj napi limit: "+setDailyLimit(who));
                    answer = returnOrExit();
                    break;
                case 5:
                    getData(who);
                    answer = returnOrExit();
                    break;
                case 6:
                    pinChange(who);
                    System.out.printf("Kész");
                    answer = returnOrExit();
                    break;
                case 7:
                    System.out.println("Viszlát!");
                    System.exit(0);
            }
    }


    //Fő menű
        public int mainMenu(){
            do {
                System.out.printf("\nKérlek válassz a következők közül.\n\n");
                System.out.printf("1. Egyenleg lekérdezés.\t\t2. Egyenleg töltlés.\n");
                System.out.printf("3. Pénz felvétel.\t\t4. Napi limit beállítása.\n");
                System.out.printf("5. Adatok kiirása.\t\t6. Pin csere.\n");
                System.out.printf("7. Kilépés\n");
                try {
                    answer = scan.nextInt();
                }catch (InputMismatchException e) {
                    System.out.println("Ez nem egy szám.");
                    scan.reset();
                    scan.next();
                }
                System.out.println();
                if (answer<=0 || answer>7) {
                    System.out.println("Ilyen menüpont sajnos nincs, kérlek adj meg egy másikat!");
                    answer=0;
                }
            }while (answer==0);


            return answer;
        }





        //Vissza lépés vagy kilépés az egyes menük végén.
        public int returnOrExit(){
        answer=0;
        do {
            System.out.println("\nSzeretne csinálni még valamit?\n");
            System.out.println("1. Vissza lépés a főmenűbe\t2. Kilépés.");
            answer = (int)notANumber(subject);
            if (answer<1 || answer>2)
                System.out.println("Érvénytelen menüpont.\nKérlek adj meg egy érvényeset!\n");
        }while(answer<1 || answer>2);
        switch (answer){
            case 1:
                answer=0;
                break;
            case 2:
                answer=7;
                System.out.println("További kellemes napot!");
                break;
        }
        return answer;
        }

    //Futtatás
    public void run(Clients who){
        who.login(who);
        do {
            int task =mainMenu();
            runApp(task,who );
        }while (answer!=7);
    }





}
