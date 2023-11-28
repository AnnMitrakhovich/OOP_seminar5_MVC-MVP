package View;

import Model.Table;
import Presenter.View;
import Presenter.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingView implements View {
    // у представления создаем коллекцию наблюдателей, чтобы знать, кого уведомлять об событиях(действиях)
    // пользователя
    private Collection<ViewObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(ViewObserver observer) {
        observers.add(observer);

    }

    @Override
    public void showReservationTable(int resultReservationNo) {
        if (resultReservationNo > 0) {
            System.out.printf("Столик успешно забронирован. Номер %d", resultReservationNo);
        } else {
            System.out.println("Не удалось");
        }
    }

    @Override
    public void showTables(Collection<Table> tables) {
        for (Table table: tables) {
            System.out.println(table);
        }
    }


    // метод заменяет нажатие на кнопку резервирования столика пользователем
    public void reservationTable(Date orderDate, int orderTable, String name) {
// вью должен сообщить всем компонентам на событие - нажатие кнопки пользователем
        // view представление сообщает-рассылает всем уведомления
        System.out.println("Пользователь возбуждает событие");
        for (ViewObserver observer: observers) {
            observer.onReservationTable(orderDate,orderTable,name);
        }
    }
    public void changeReservationTable(int oldReservationNo, Date orderDate, int orderTable, String name) {
// новый метод по отмене предыдущего бронирования и создание нового бронирования
        System.out.println("Пользователь отменяет бронирование");
        for (ViewObserver observer: observers) {
            observer.onChangeReservationTable(oldReservationNo);
            observer.onReservationTable(orderDate,orderTable, name);
        }
    }
}
