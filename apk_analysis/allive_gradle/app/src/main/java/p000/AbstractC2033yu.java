package p000;

import android.content.res.Configuration;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.core.os.LocaleListCompat;

/* renamed from: yu */
/* loaded from: classes.dex */
public abstract class AbstractC2033yu {
    @DoNotInline
    /* renamed from: a */
    public static LocaleList m8323a(Configuration configuration) {
        return configuration.getLocales();
    }

    @DoNotInline
    /* renamed from: b */
    public static void m8324b(@NonNull Configuration configuration, @NonNull LocaleListCompat localeListCompat) {
        configuration.setLocales((LocaleList) localeListCompat.unwrap());
    }
}
