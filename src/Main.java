import Model.Table;
import Model.TableModel;
import Presenter.BookingPresenter;
import View.BookingView;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        TableModel tableModel = new TableModel();
        BookingView bookingView = new BookingView();
        BookingPresenter presenter = new BookingPresenter(tableModel, bookingView);
        presenter.updateTablesUI();
        bookingView.reservationTable(new Date(), 3, "Anna");
        bookingView.reservationTable(new Date(), 1, "Oleg");
        bookingView.changeReservationTable(1001, new Date(), 4, "Gleb");

    }
}