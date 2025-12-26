package p000;

import android.app.LocaleManager;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class qc1 {
    @DoNotInline
    /* renamed from: a */
    public static LocaleList m7026a(Object obj) {
        return ((LocaleManager) obj).getApplicationLocales();
    }

    @DoNotInline
    /* renamed from: b */
    public static LocaleList m7027b(Object obj) {
        return ((LocaleManager) obj).getSystemLocales();
    }
}
