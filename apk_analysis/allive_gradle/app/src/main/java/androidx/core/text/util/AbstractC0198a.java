package androidx.core.text.util;

import android.icu.number.NumberFormatter;
import android.icu.number.UnlocalizedNumberFormatter;
import android.icu.text.DateTimePatternGenerator;
import android.icu.util.MeasureUnit;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.core.text.util.LocalePreferences;
import java.util.Locale;
import p000.rc1;

/* renamed from: androidx.core.text.util.a */
/* loaded from: classes.dex */
public abstract class AbstractC0198a {
    @DoNotInline
    /* renamed from: a */
    public static String m893a(@NonNull Locale locale) {
        int i = rc1.f25927a[DateTimePatternGenerator.getInstance(locale).getDefaultHourCycle().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return "";
                    }
                    return LocalePreferences.HourCycle.H24;
                }
                return LocalePreferences.HourCycle.H23;
            }
            return LocalePreferences.HourCycle.H12;
        }
        return LocalePreferences.HourCycle.H11;
    }

    @DoNotInline
    /* renamed from: b */
    public static String m894b(@NonNull Locale locale) {
        String identifier = ((UnlocalizedNumberFormatter) ((UnlocalizedNumberFormatter) NumberFormatter.with().usage("weather")).unit(MeasureUnit.CELSIUS)).locale(locale).format(1L).getOutputUnit().getIdentifier();
        if (identifier.startsWith(LocalePreferences.TemperatureUnit.FAHRENHEIT)) {
            return LocalePreferences.TemperatureUnit.FAHRENHEIT;
        }
        return identifier;
    }
}
