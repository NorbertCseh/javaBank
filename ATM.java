package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM  {
    Scanner scan = new Scanner(System.in);
    long addMoney= 0;
    long withdrawnMoney =0;
    long newDailyLimit;
    long pin;
    long newPin;





    //Egyenleg lekérdezés
        public long balance(Clients who){
            return who.getBalance();
        }



    //Egyenleg feltöltés
        public long loadBalance(Clients who){
            addMoney=0;
            System.out.println("Kérek add meg mennyi pénzt szeretél feltölteni.");
            do {
                addMoney = notANumber(addMoney);
                if (addMoney<=0)
                    System.out.println("Érvénytelen, kérlek adj meg egy rendes összeget.");
            }while(addMoney<=0);
            who.setBalance(who.getBalance()+addMoney);
            return who.getBalance();
        }




    //Pénz levétel
        public long withdrawn(Clients who){
            withdrawnMoney=0;
            System.out.println("Kérlek add mennyi pénzt szeretnél felvenni.");
            do {
                withdrawnMoney= notANumber(withdrawnMoney);
                if (who.getBalance()<withdrawnMoney) {
                    System.out.println("Nincs elég keret");
                    System.out.println("Kérlek adj meg egy megfelelő összeget!");
                    System.out.println("Egyenleg: "+who.getBalance()+" Ft");
                    withdrawnMoney=0;
                }
                else if (withdrawnMoney==0){
                    System.out.println("Sajnos ezt nem tudom teljesíteni.");
                    System.out.println("Kérlek adj meg egy megfelelő összeget!");
                    System.out.println("Egyenleg: "+who.getBalance()+" Ft");
                }

            }while (withdrawnMoney<=0);
                who.setBalance(who.getBalance()-withdrawnMoney);
                return who.getBalance();
        }

        public long setDailyLimit(Clients who){
            newDailyLimit=0;
            System.out.println("Kérlek add meg az uj napi limitet.");
            do {
                newDailyLimit = notANumber(newDailyLimit);
                if (newDailyLimit<=0)
                    System.out.println("Érvénytelen szám.\nKérlek adj meg egy érvényes számot!");
            }while (newDailyLimit<=0);
            who.setDailyLimit(newDailyLimit);
            return who.getDailyLimit();
        }

    //Beirt szám ellenőrzése.
    public long notANumber(long subject){
        try {
            subject = scan.nextInt();
        } catch (InputMismatchException e) {
            scan.reset();
            scan.next();
        }
        return subject;
    }


    //Uj ügyfél hozzáadása
        public void createClient(Clients who,String fullName, String address, String email, String phone, long balance, long dailyLimit, int pin){
            who.setFullName(fullName);
            who.setAddress(address);
            who.setEmail(email);
            who.setPhone(phone);
            who.setBalance(balance);
            who.setDailyLimit(dailyLimit);
            who.setPin(pin);
        }


        //Pin kod bekerese
        public void login(Clients who){
            System.out.println("Kérlek add meg a pin kodot.(Alap esetben mind két felhasználohoz 1234)");
            do {
                pin = notANumber(pin);
                if (who.getPin()!=pin)
                    System.out.println("Rossz jelszó!\nKérlek probáld ujra.");
            }while(who.getPin()!=pin);
        }


        //Adatok kiirása
        public void getData(Clients who){
            System.out.println("Teljes név: "+who.getFullName());
            System.out.println("Egyenleg: "+who.getBalance()+" Ft");
            System.out.println("Cím: "+who.getAddress());
            System.out.println("E-mail cím: "+who.getEmail());
            System.out.println("Telefon: "+who.getPhone());
            System.out.println("Napi limit: "+who.getDailyLimit()+" Ft");

        }

        //pin kod csere
        public void pinChange(Clients who){
            login(who);
            System.out.println("Kérlek add meg az uj pin kodot.");
            newPin = notANumber(newPin);
            who.setPin((int)newPin);
        }



}
