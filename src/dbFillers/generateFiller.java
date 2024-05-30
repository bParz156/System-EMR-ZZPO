package dbFillers;

import com.company.Lekarz;
import com.company.Pacjent;

import java.io.*;
import java.util.ArrayList;

public class generateFiller {

    private static String [] names={"Anna", "Zdzislaw", "Maksymilian", "Zofia", "Katarzyna", "Malgorzata", "Ludwik", "Teofil", "Kamil", "Jonasz", "Joachim", "Krzysztof", "Maria", "Heidi",
            "Joanna", "Barbara", "Aleksandra", "Marta", "Weronika"};
    private static String [] surnames={"Nowak", "Kowalczuk", "Mocarz", "Koliber", "Zegarewicz", "Fart", "Slonce", "Turkiewicz", "Dusk", "Malina", "Kalanka"};

    private static String datapath="docs/";
    private static String pacjenci=datapath+"pacjenci.txt";
    private static String lekarze=datapath+"lekarze.txt";

    public static Struktura generateFillers()
    {
        ArrayList<Pacjent> pacjents= generatePatients(70);
        ArrayList<Lekarz> lekarzs=generateDoctors(10);
        Struktura struktura=new Struktura(pacjents, lekarzs);
        return struktura;
    }

    /**
     *
     * Generuje @param n pacjentow i wpisuje ich dane do pacjenci.txt
     */
    private static ArrayList<Pacjent> generatePatients(int n)  {
        ArrayList<Pacjent>  pacjents=new ArrayList<>();
        try {
            FileWriter writer
                    = new FileWriter(pacjenci);
            for(int i=0; i<n; i++)
            {
                int k=getRandomNumber(0,100);
                int m=getRandomNumber(0,100);
                String PESEL=generatePESEL();
                String imie=names[k%names.length];
                String nazwisko=surnames[m%surnames.length];
                Pacjent pacjent=new Pacjent(PESEL, imie, nazwisko);
                pacjents.add(pacjent);
                String data=PESEL+";"+imie+";"+nazwisko+"\n";
                writer.write(data);
            }

            writer.close();
            System.out.println("Successfully written.");
        }
        catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
        return pacjents;
    }

    private static ArrayList<Lekarz> generateDoctors(int n)  {
        ArrayList<Lekarz> lekarzs = new ArrayList<>();
        try {
            FileWriter writer
                    = new FileWriter(lekarze);
            for(int i=0; i<n; i++)
            {
                int k=getRandomNumber(0,100);
                int m=getRandomNumber(0,100);
                String imie=names[k%names.length];
                String nazwisko=surnames[m%surnames.length];
                String data=imie+";"+nazwisko+"\n";
                Lekarz lekarz=new Lekarz(imie, nazwisko);
                lekarzs.add(lekarz);
                writer.write(data);
            }


            writer.close();
            System.out.println("Successfully written.");
        }
        catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
        return lekarzs;
    }

    private static  String generatePESEL()
    {
        int size=11;
        String AlphaNumericString = "0123456789";
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            int index= (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }







}
