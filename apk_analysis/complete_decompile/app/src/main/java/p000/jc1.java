package p000;

import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class jc1 {
    @DoNotInline
    /* renamed from: a */
    public static LocaleList m5431a(Locale... localeArr) {
        return new LocaleList(localeArr);
    }

    @DoNotInline
    /* renamed from: b */
    public static LocaleList m5432b() {
        return LocaleList.getAdjustedDefault();
    }

    @DoNotInline
    /* renamed from: c */
    public static LocaleList m5433c() {
        return LocaleList.getDefault();
    }
}
