package p000;

import android.app.LocaleManager;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;

/* renamed from: q8 */
/* loaded from: classes.dex */
public abstract class AbstractC1715q8 {
    @DoNotInline
    /* renamed from: a */
    public static LocaleList m7004a(Object obj) {
        return ((LocaleManager) obj).getApplicationLocales();
    }

    @DoNotInline
    /* renamed from: b */
    public static void m7005b(Object obj, LocaleList localeList) {
        ((LocaleManager) obj).setApplicationLocales(localeList);
    }
}
