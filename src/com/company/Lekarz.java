package com.company;
import java.util.Objects;
import java.util.UUID;

public class Lekarz {
    private UUID id;
    private String imie;
    private String nazwisko;

    public Lekarz(UUID id, String imie, String nazwisko)
    {
        this.id=id;
        this.imie=imie;
        this.nazwisko=nazwisko;
    }

    public Lekarz( String imie, String nazwisko)
    {
        this.imie=imie;
        this.nazwisko=nazwisko;
    }

    public UUID getId()
    {
        return id;
    }

    public String getImie()
    {
        return imie;
    }
    public String getNazwisko()
    {
        return nazwisko;
    }

    @Override
    public String toString() {
        return "Lekarz{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lekarz lekarz = (Lekarz) o;
        return Objects.equals(id, lekarz.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
