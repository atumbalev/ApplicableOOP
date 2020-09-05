package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Statistics {
    private String _country;
    private int _data;
    private StringProperty country;
    private IntegerProperty data;

    public Statistics(String country, int data) {
        setCountry(country);
        setData(data);
    }

    public final String getCountry() {
        return country == null ? _country : country.get();
    }

    public final void setCountry(String country) {
        country = country == null ? "N/A" : country;
        if(this.country == null) {
            this._country = country;
        } else {
            this.country.set(country);
        }
    }

    public final StringProperty countryProperty() {
        if(country == null) {
            country = new SimpleStringProperty(this, "country", _country);
        }
        return country;
    }

    public final int getData() {
        return data == null ? _data : data.get();
    }

    public final void setData(int data) {
        data = data < 0 ? 0 : data;
        if(this.data == null) {
            this._data = data;
        } else {
            this.data.set(data);
        }
    }

    public final IntegerProperty dataProperty() {
        if(data == null) {
            data = new SimpleIntegerProperty(this, "data", _data);
        }
        return data;
    }

    @Override
    public String toString() {
        return getCountry();
    }
}
