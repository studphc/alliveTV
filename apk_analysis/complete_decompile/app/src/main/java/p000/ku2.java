package p000;

import android.view.View;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class ku2 {
    @Nullable
    @DoNotInline
    /* renamed from: a */
    public static OnBackInvokedDispatcher m5790a(@NonNull View view) {
        return view.findOnBackInvokedDispatcher();
    }

    @NonNull
    @DoNotInline
    /* renamed from: b */
    public static OnBackInvokedCallback m5791b(@NonNull Runnable runnable) {
        Objects.requireNonNull(runnable);
        return new C0010a9(2, runnable);
    }

    @DoNotInline
    /* renamed from: c */
    public static void m5792c(@NonNull Object obj, @NonNull Object obj2) {
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
    }

    @DoNotInline
    /* renamed from: d */
    public static void m5793d(@NonNull Object obj, @NonNull Object obj2) {
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}
