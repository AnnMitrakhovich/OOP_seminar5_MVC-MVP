package Presenter;

import java.util.Collection;
import java.util.Date;

import Model.Table;

import javax.xml.crypto.Data;

public interface Model {
    Collection<Table> loadTables();

    int reservationTable(Date reservationDate, int numberTable, String name);

}
