package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import androidx.annotation.NonNull;
import p000.AbstractC2033yu;

/* loaded from: classes.dex */
public final class ConfigurationCompat {
    @NonNull
    public static LocaleListCompat getLocales(@NonNull Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return LocaleListCompat.wrap(AbstractC2033yu.m8323a(configuration));
        }
        return LocaleListCompat.create(configuration.locale);
    }

    public static void setLocales(@NonNull Configuration configuration, @NonNull LocaleListCompat localeListCompat) {
        if (Build.VERSION.SDK_INT >= 24) {
            AbstractC2033yu.m8324b(configuration, localeListCompat);
        } else if (!localeListCompat.isEmpty()) {
            configuration.setLocale(localeListCompat.get(0));
        }
    }
}
