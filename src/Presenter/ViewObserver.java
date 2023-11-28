package Presenter;

import java.util.Date;

//обстракция, которая наблюдает за представлением (действиями пользователя);
// в нашем случае наблюдателем является презентер
public interface ViewObserver {
    void onReservationTable(Date orderDate, int orderTable, String name);

}