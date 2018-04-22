package com.company;



public class Main {

    public static void main(String[] args) {

        Interface main = new Interface();
        Clients Norbi = new Clients();
        Clients Jhon = new Clients();
        Norbi.createClient(Norbi,"Cseh Norbert István","1188, Budapest Csolt utca 5.", "cseh.norbert94@gmail.com","06307990328", 100000, 50000, 1234);
        Jhon.createClient(Jhon,"Jhon Doe","1234, Dummy street 12.", "jhon.doe@gmail.com","123456789", 20000, 20000,1234);


        main.run(Jhon);



    }
}
