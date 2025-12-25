package androidx.core.view;

import android.view.Display;
import androidx.annotation.DoNotInline;

/* renamed from: androidx.core.view.b */
/* loaded from: classes.dex */
public abstract class AbstractC0204b {
    @DoNotInline
    /* renamed from: a */
    public static int m937a(Display.Mode mode) {
        return mode.getPhysicalHeight();
    }

    @DoNotInline
    /* renamed from: b */
    public static int m938b(Display.Mode mode) {
        return mode.getPhysicalWidth();
    }
}
