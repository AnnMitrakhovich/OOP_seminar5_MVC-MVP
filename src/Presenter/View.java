package Presenter;

import java.util.Collection;
import Model.Table;

public interface View {
    void showTables(Collection<Table> tables);

    // все взаимодействия осуществляются через абстракции, а не на прямую, поэтому создаем метод
    // регистрации наблюдателя в интерфейсе
    void registerObserver(ViewObserver observer);

    // метод обрабатывает номер резервации в сообщение для пользователя
    void showReservationTable(int resultReservationNo);
}
