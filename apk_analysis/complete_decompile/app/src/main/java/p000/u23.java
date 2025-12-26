package p000;

import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class u23 {
    @DoNotInline
    /* renamed from: a */
    public static WindowInsets m7525a(View view, WindowInsets windowInsets) {
        return view.dispatchApplyWindowInsets(windowInsets);
    }

    @DoNotInline
    /* renamed from: b */
    public static WindowInsets m7526b(View view, WindowInsets windowInsets) {
        return view.onApplyWindowInsets(windowInsets);
    }

    @DoNotInline
    /* renamed from: c */
    public static void m7527c(View view) {
        view.requestApplyInsets();
    }
}
