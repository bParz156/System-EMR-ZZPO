package com.company;

import java.util.Objects;

public class Pacjent {
    private String PESEL;
    private String imie;
    private String nazwisko;

    public Pacjent(String PESEL, String imie, String nazwisko)
    {
        this.PESEL=PESEL;
        this.imie=imie;
        this.nazwisko=nazwisko;
    }

    public String getPESEL()
    {
        return PESEL;
    }
    public String getImie()
    {
        return imie;
    }
    public String  getNazwisko()
    {
        return nazwisko;
    }

    @Override
    public String toString() {
        return "Pacjent{" +
                "PESEL='" + PESEL + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pacjent pacjent = (Pacjent) o;
        return Objects.equals(PESEL, pacjent.PESEL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PESEL);
    }
}
