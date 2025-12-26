package androidx.leanback.widget.picker;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;
import p000.p63;

/* loaded from: classes.dex */
public class PickerUtility$DateConstant {
    public final String[] days;
    public final Locale locale;
    public final String[] months;

    public PickerUtility$DateConstant(Locale locale) {
        this.locale = locale;
        this.months = DateFormatSymbols.getInstance(locale).getShortMonths();
        Calendar calendar = Calendar.getInstance(locale);
        this.days = p63.m6879x(calendar.getMinimum(5), calendar.getMaximum(5));
    }
}
