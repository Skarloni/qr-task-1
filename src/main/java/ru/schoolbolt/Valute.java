package ru.schoolbolt;

import com.google.gson.annotations.SerializedName;

public final class Valute {
    @SerializedName("ID")
    public String id;
    @SerializedName("NumCode")
    public String numCode;
    @SerializedName("CharCode")
    public String charCode;
    @SerializedName("Nominal")
    public int nominal;
    @SerializedName("Name")
    public String name;
    @SerializedName("Value")
    public Float value;
    @SerializedName("Previous")
    public Float previous;

    public float getDiff() {
        return Math.abs(previous - value);
    }
}
