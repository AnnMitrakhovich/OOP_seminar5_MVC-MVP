package Presenter;

import Model.TableModel;
import View.BookingView;

import java.util.Date;

public class BookingPresenter implements ViewObserver{
    private final Model model;
    private final View view;
    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }
    public void updateTablesUI() {
        view.showTables(model.loadTables());
    }
    @Override
    public void onReservationTable(Date orderDate, int orderTable, String name) {
        // презентер уведомлен о событии и реагирует на него
        System.out.println("Презентер реагирует на событие брони столика");
        try {
            int reservationNo = model.reservationTable(orderDate,orderTable,name);
            view.showReservationTable(reservationNo);
        } catch (RuntimeException e){
            view.showReservationTable(-1);
            System.out.println("Попробуйте снова. Бронь не удалась");
        }
    }
    @Override
    public void onChangeReservationTable(int oldReservationNo) {
        System.out.println("Презентер реагирует на событие отмены брони");
        try {
            model.deliteReservation(oldReservationNo);

        } catch (RuntimeException e){
            System.out.println("Попробуйте снова. Ошибка отмены");
        }


    }
}
