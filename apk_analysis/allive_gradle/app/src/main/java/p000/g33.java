package p000;

import android.view.ViewConfiguration;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class g33 {
    @DoNotInline
    /* renamed from: a */
    public static int m4913a(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledHoverSlop();
    }

    @DoNotInline
    /* renamed from: b */
    public static boolean m4914b(ViewConfiguration viewConfiguration) {
        return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
    }
}
