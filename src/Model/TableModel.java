package Model;

import Presenter.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
public class TableModel implements Model {
    private Collection<Table> tables;
    @Override
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }
    @Override
    public int reservationTable(Date reservationDate, int numberTable, String name) {
        for (Table table : loadTables()) {
            if (table.getNumber() == numberTable) {
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }

    @Override
    public void deliteReservation(int oldReservationNo) {
        for (Table table : loadTables()) {
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == oldReservationNo) {
                    table.getReservations().remove(reservation);
                    System.out.println("Бронь отменена");

                }
            }
        }
        throw new RuntimeException("Неверный номер бронирования");
    }

}
