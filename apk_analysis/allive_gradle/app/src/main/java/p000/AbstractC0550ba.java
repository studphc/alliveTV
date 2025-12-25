package p000;

import android.os.LocaleList;
import android.widget.TextView;
import androidx.annotation.DoNotInline;

/* renamed from: ba */
/* loaded from: classes.dex */
public abstract class AbstractC0550ba {
    @DoNotInline
    /* renamed from: a */
    public static LocaleList m2067a(String str) {
        return LocaleList.forLanguageTags(str);
    }

    @DoNotInline
    /* renamed from: b */
    public static void m2068b(TextView textView, LocaleList localeList) {
        textView.setTextLocales(localeList);
    }
}
