package androidx.leanback.widget.picker;

import java.text.DateFormatSymbols;
import java.util.Locale;
import p000.p63;

/* loaded from: classes.dex */
public class PickerUtility$TimeConstant {
    public final String[] ampm;
    public final String[] hours12;
    public final String[] hours24;
    public final Locale locale;
    public final String[] minutes;

    public PickerUtility$TimeConstant(Locale locale) {
        this.locale = locale;
        DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
        this.hours12 = p63.m6879x(1, 12);
        this.hours24 = p63.m6879x(0, 23);
        this.minutes = p63.m6879x(0, 59);
        this.ampm = dateFormatSymbols.getAmPmStrings();
    }
}
