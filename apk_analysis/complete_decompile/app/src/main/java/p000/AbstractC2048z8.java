package p000;

import android.content.res.Configuration;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.core.os.LocaleListCompat;

/* renamed from: z8 */
/* loaded from: classes.dex */
public abstract class AbstractC2048z8 {
    @DoNotInline
    /* renamed from: a */
    public static void m8399a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
        LocaleList locales;
        LocaleList locales2;
        boolean equals;
        locales = configuration.getLocales();
        locales2 = configuration2.getLocales();
        equals = locales.equals(locales2);
        if (!equals) {
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }
    }

    @DoNotInline
    /* renamed from: b */
    public static LocaleListCompat m8400b(Configuration configuration) {
        LocaleList locales;
        String languageTags;
        locales = configuration.getLocales();
        languageTags = locales.toLanguageTags();
        return LocaleListCompat.forLanguageTags(languageTags);
    }

    @DoNotInline
    /* renamed from: c */
    public static void m8401c(LocaleListCompat localeListCompat) {
        LocaleList forLanguageTags;
        forLanguageTags = LocaleList.forLanguageTags(localeListCompat.toLanguageTags());
        LocaleList.setDefault(forLanguageTags);
    }

    @DoNotInline
    /* renamed from: d */
    public static void m8402d(Configuration configuration, LocaleListCompat localeListCompat) {
        LocaleList forLanguageTags;
        forLanguageTags = LocaleList.forLanguageTags(localeListCompat.toLanguageTags());
        configuration.setLocales(forLanguageTags);
    }
}
