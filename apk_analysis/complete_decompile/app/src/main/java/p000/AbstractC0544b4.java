package p000;

import android.os.LocaleList;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.annotation.DoNotInline;

/* renamed from: b4 */
/* loaded from: classes.dex */
public abstract class AbstractC0544b4 {
    @DoNotInline
    /* renamed from: a */
    public static LocaleList m2014a(AccessibilityWindowInfo accessibilityWindowInfo) {
        return accessibilityWindowInfo.getLocales();
    }

    @DoNotInline
    /* renamed from: b */
    public static long m2015b(AccessibilityWindowInfo accessibilityWindowInfo) {
        return accessibilityWindowInfo.getTransitionTimeMillis();
    }
}
