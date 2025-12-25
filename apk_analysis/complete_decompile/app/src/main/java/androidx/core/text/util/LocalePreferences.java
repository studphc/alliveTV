package androidx.core.text.util;

import android.os.Build;
import android.text.format.DateFormat;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import p000.sc1;

@RequiresApi(21)
/* loaded from: classes.dex */
public final class LocalePreferences {

    /* renamed from: a */
    public static final String[] f3804a = {"BS", "BZ", "KY", "PR", "PW", "US"};

    /* loaded from: classes.dex */
    public static class CalendarType {
        public static final String CHINESE = "chinese";
        public static final String DANGI = "dangi";
        public static final String DEFAULT = "";
        public static final String GREGORIAN = "gregorian";
        public static final String HEBREW = "hebrew";
        public static final String INDIAN = "indian";
        public static final String ISLAMIC = "islamic";
        public static final String ISLAMIC_CIVIL = "islamic-civil";
        public static final String ISLAMIC_RGSA = "islamic-rgsa";
        public static final String ISLAMIC_TBLA = "islamic-tbla";
        public static final String ISLAMIC_UMALQURA = "islamic-umalqura";
        public static final String PERSIAN = "persian";

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        /* loaded from: classes.dex */
        public @interface CalendarTypes {
        }
    }

    /* loaded from: classes.dex */
    public static class FirstDayOfWeek {
        public static final String DEFAULT = "";
        public static final String FRIDAY = "fri";
        public static final String MONDAY = "mon";
        public static final String SATURDAY = "sat";
        public static final String SUNDAY = "sun";
        public static final String THURSDAY = "thu";
        public static final String TUESDAY = "tue";
        public static final String WEDNESDAY = "wed";

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        /* loaded from: classes.dex */
        public @interface Days {
        }
    }

    /* loaded from: classes.dex */
    public static class HourCycle {
        public static final String DEFAULT = "";
        public static final String H11 = "h11";
        public static final String H12 = "h12";
        public static final String H23 = "h23";
        public static final String H24 = "h24";

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        /* loaded from: classes.dex */
        public @interface HourCycleTypes {
        }
    }

    /* loaded from: classes.dex */
    public static class TemperatureUnit {
        public static final String CELSIUS = "celsius";
        public static final String DEFAULT = "";
        public static final String FAHRENHEIT = "fahrenhe";
        public static final String KELVIN = "kelvin";

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        /* loaded from: classes.dex */
        public @interface TemperatureUnits {
        }
    }

    @NonNull
    public static String getCalendarType() {
        return getCalendarType(true);
    }

    @NonNull
    public static String getFirstDayOfWeek() {
        return getFirstDayOfWeek(true);
    }

    @NonNull
    public static String getHourCycle() {
        return getHourCycle(true);
    }

    @NonNull
    public static String getTemperatureUnit() {
        return getTemperatureUnit(true);
    }

    @NonNull
    public static String getCalendarType(@NonNull Locale locale) {
        return getCalendarType(locale, true);
    }

    @NonNull
    public static String getFirstDayOfWeek(@NonNull Locale locale) {
        return getFirstDayOfWeek(locale, true);
    }

    @NonNull
    public static String getHourCycle(@NonNull Locale locale) {
        return getHourCycle(locale, true);
    }

    @NonNull
    public static String getTemperatureUnit(@NonNull Locale locale) {
        return getTemperatureUnit(locale, true);
    }

    @NonNull
    public static String getCalendarType(boolean z) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = sc1.m7358b();
        } else {
            locale = Locale.getDefault();
        }
        return getCalendarType(locale, z);
    }

    @NonNull
    public static String getFirstDayOfWeek(boolean z) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = sc1.m7358b();
        } else {
            locale = Locale.getDefault();
        }
        return getFirstDayOfWeek(locale, z);
    }

    @NonNull
    public static String getHourCycle(boolean z) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = sc1.m7358b();
        } else {
            locale = Locale.getDefault();
        }
        return getHourCycle(locale, z);
    }

    @NonNull
    public static String getTemperatureUnit(boolean z) {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = sc1.m7358b();
        } else {
            locale = Locale.getDefault();
        }
        return getTemperatureUnit(locale, z);
    }

    @NonNull
    public static String getCalendarType(@NonNull Locale locale, boolean z) {
        String unicodeLocaleType = locale.getUnicodeLocaleType("ca");
        if (unicodeLocaleType == null) {
            unicodeLocaleType = !z ? "" : null;
        }
        if (unicodeLocaleType != null) {
            return unicodeLocaleType;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return sc1.m7357a(locale);
        }
        if (!z) {
            return "";
        }
        return CalendarType.GREGORIAN;
    }

    @NonNull
    public static String getFirstDayOfWeek(@NonNull Locale locale, boolean z) {
        String unicodeLocaleType = locale.getUnicodeLocaleType("fw");
        String str = "";
        if (unicodeLocaleType == null) {
            unicodeLocaleType = !z ? "" : null;
        }
        if (unicodeLocaleType != null) {
            return unicodeLocaleType;
        }
        int firstDayOfWeek = Calendar.getInstance(locale).getFirstDayOfWeek();
        String[] strArr = {FirstDayOfWeek.SUNDAY, FirstDayOfWeek.MONDAY, FirstDayOfWeek.TUESDAY, FirstDayOfWeek.WEDNESDAY, FirstDayOfWeek.THURSDAY, FirstDayOfWeek.FRIDAY, FirstDayOfWeek.SATURDAY};
        if (firstDayOfWeek >= 1 && firstDayOfWeek <= 7) {
            str = strArr[firstDayOfWeek - 1];
        }
        return str;
    }

    @NonNull
    public static String getHourCycle(@NonNull Locale locale, boolean z) {
        String unicodeLocaleType = locale.getUnicodeLocaleType("hc");
        if (unicodeLocaleType == null) {
            unicodeLocaleType = !z ? "" : null;
        }
        if (unicodeLocaleType != null) {
            return unicodeLocaleType;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return AbstractC0198a.m893a(locale);
        }
        return DateFormat.getBestDateTimePattern(locale, "jm").contains("H") ? HourCycle.H23 : HourCycle.H12;
    }

    @NonNull
    public static String getTemperatureUnit(@NonNull Locale locale, boolean z) {
        String unicodeLocaleType = locale.getUnicodeLocaleType("mu");
        if (unicodeLocaleType == null) {
            unicodeLocaleType = !z ? "" : null;
        }
        if (unicodeLocaleType != null) {
            return unicodeLocaleType;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return AbstractC0198a.m894b(locale);
        }
        if (Arrays.binarySearch(f3804a, locale.getCountry()) >= 0) {
            return TemperatureUnit.FAHRENHEIT;
        }
        return TemperatureUnit.CELSIUS;
    }
}
