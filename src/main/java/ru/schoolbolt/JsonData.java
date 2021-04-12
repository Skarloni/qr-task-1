package ru.schoolbolt;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Map;

public final class JsonData {
    @SerializedName("Date")
    public Date date;
    @SerializedName("PreviousDate")
    public Date previousDate;
    @SerializedName("PreviousURL")
    public String previousURL;
    @SerializedName("Timestamp")
    public Date timestamp;
    @SerializedName("Valute")
    public Map<String, Valute> valutes;
}
