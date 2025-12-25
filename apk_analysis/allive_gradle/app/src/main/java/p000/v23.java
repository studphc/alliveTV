package p000;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* loaded from: classes.dex */
public final class v23 implements View.OnApplyWindowInsetsListener {

    /* renamed from: a */
    public WindowInsetsCompat f27634a = null;

    /* renamed from: b */
    public final /* synthetic */ View f27635b;

    /* renamed from: c */
    public final /* synthetic */ OnApplyWindowInsetsListener f27636c;

    public v23(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f27635b = view;
        this.f27636c = onApplyWindowInsetsListener;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view);
        int i = Build.VERSION.SDK_INT;
        OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f27636c;
        if (i < 30) {
            w23.m7967a(windowInsets, this.f27635b);
            if (windowInsetsCompat.equals(this.f27634a)) {
                return onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsetsCompat).toWindowInsets();
            }
        }
        this.f27634a = windowInsetsCompat;
        WindowInsetsCompat onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsetsCompat);
        if (i >= 30) {
            return onApplyWindowInsets.toWindowInsets();
        }
        ViewCompat.requestApplyInsets(view);
        return onApplyWindowInsets.toWindowInsets();
    }
}
