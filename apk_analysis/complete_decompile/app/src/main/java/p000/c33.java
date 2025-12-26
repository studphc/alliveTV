package p000;

import android.view.View;
import android.view.WindowInsetsController;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.WindowInsetsControllerCompat;

/* loaded from: classes.dex */
public abstract class c33 {
    @DoNotInline
    /* renamed from: a */
    public static int m2190a(View view) {
        return view.getImportantForContentCapture();
    }

    @DoNotInline
    /* renamed from: b */
    public static CharSequence m2191b(View view) {
        return view.getStateDescription();
    }

    @Nullable
    /* renamed from: c */
    public static WindowInsetsControllerCompat m2192c(@NonNull View view) {
        WindowInsetsController windowInsetsController = view.getWindowInsetsController();
        if (windowInsetsController != null) {
            return WindowInsetsControllerCompat.toWindowInsetsControllerCompat(windowInsetsController);
        }
        return null;
    }

    @DoNotInline
    /* renamed from: d */
    public static boolean m2193d(View view) {
        return view.isImportantForContentCapture();
    }

    @DoNotInline
    /* renamed from: e */
    public static void m2194e(View view, int i) {
        view.setImportantForContentCapture(i);
    }

    @DoNotInline
    /* renamed from: f */
    public static void m2195f(View view, CharSequence charSequence) {
        view.setStateDescription(charSequence);
    }
}
