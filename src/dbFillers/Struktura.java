package dbFillers;

import com.company.Lekarz;
import com.company.Pacjent;

import java.util.ArrayList;

public class Struktura {
    public ArrayList<Pacjent> pacjents;
    public ArrayList<Lekarz> lekarzs;

    public Struktura(ArrayList<Pacjent> pacjents, ArrayList<Lekarz> lekarzs)
    {
        this.pacjents=pacjents;
        this.lekarzs=lekarzs;
    }


}
