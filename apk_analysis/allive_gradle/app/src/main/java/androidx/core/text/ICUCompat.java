package androidx.core.text;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import p000.p11;
import p000.q11;

/* loaded from: classes.dex */
public final class ICUCompat {

    /* renamed from: a */
    public static final Method f3783a;

    static {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                f3783a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }

    @Nullable
    public static String maximizeAndGetScript(@NonNull Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return q11.m6952c(q11.m6950a(q11.m6951b(locale)));
        }
        try {
            return p11.m6768a((Locale) f3783a.invoke(null, locale));
        } catch (IllegalAccessException e) {
            Log.w("ICUCompat", e);
            return p11.m6768a(locale);
        } catch (InvocationTargetException e2) {
            Log.w("ICUCompat", e2);
            return p11.m6768a(locale);
        }
    }
}
