package p000;

import android.icu.util.ULocale;
import androidx.annotation.DoNotInline;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class q11 {
    @DoNotInline
    /* renamed from: a */
    public static ULocale m6950a(Object obj) {
        return ULocale.addLikelySubtags((ULocale) obj);
    }

    @DoNotInline
    /* renamed from: b */
    public static ULocale m6951b(Locale locale) {
        return ULocale.forLocale(locale);
    }

    @DoNotInline
    /* renamed from: c */
    public static String m6952c(Object obj) {
        return ((ULocale) obj).getScript();
    }
}
