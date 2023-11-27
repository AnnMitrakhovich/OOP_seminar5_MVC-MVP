package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class Table {
    private static int counter;
    private final int number;

    private final Collection<Reservation> reservations = new ArrayList<>();

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public int getNumber() {
        return number;
    }

    public Table() {
        number = ++counter;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Столик %d", number);
    }
}
