package p000;

import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.WindowInsetsCompat;

/* loaded from: classes.dex */
public abstract class x23 {
    @Nullable
    /* renamed from: a */
    public static WindowInsetsCompat m8088a(@NonNull View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(rootWindowInsets);
        windowInsetsCompat.f3941a.mo990t(windowInsetsCompat);
        windowInsetsCompat.f3941a.mo980d(view.getRootView());
        return windowInsetsCompat;
    }

    @DoNotInline
    /* renamed from: b */
    public static int m8089b(@NonNull View view) {
        return view.getScrollIndicators();
    }

    @DoNotInline
    /* renamed from: c */
    public static void m8090c(@NonNull View view, int i) {
        view.setScrollIndicators(i);
    }

    @DoNotInline
    /* renamed from: d */
    public static void m8091d(@NonNull View view, int i, int i2) {
        view.setScrollIndicators(i, i2);
    }
}
