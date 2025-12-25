package p000;

import android.view.Window;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class q53 {
    @DoNotInline
    /* renamed from: a */
    public static <T> T m7000a(Window window, int i) {
        return (T) window.requireViewById(i);
    }
}
