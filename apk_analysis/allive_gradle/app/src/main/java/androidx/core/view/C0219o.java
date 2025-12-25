package androidx.core.view;

import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.core.graphics.Insets;
import p000.c63;

/* renamed from: androidx.core.view.o */
/* loaded from: classes.dex */
public final class C0219o extends c63 {

    /* renamed from: q */
    public static final WindowInsetsCompat f4015q;

    static {
        WindowInsets windowInsets;
        windowInsets = WindowInsets.CONSUMED;
        f4015q = WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
    }

    public C0219o(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
        super(windowInsetsCompat, windowInsets);
    }

    @Override // androidx.core.view.C0218n, androidx.core.view.C0220p
    /* renamed from: d */
    public final void mo980d(@NonNull View view) {
    }

    @Override // androidx.core.view.C0218n, androidx.core.view.C0220p
    @NonNull
    /* renamed from: g */
    public Insets mo982g(int i) {
        android.graphics.Insets insets;
        insets = this.f4010c.getInsets(AbstractC0221q.m998a(i));
        return Insets.toCompatInsets(insets);
    }

    @Override // androidx.core.view.C0218n, androidx.core.view.C0220p
    @NonNull
    /* renamed from: h */
    public Insets mo983h(int i) {
        android.graphics.Insets insetsIgnoringVisibility;
        insetsIgnoringVisibility = this.f4010c.getInsetsIgnoringVisibility(AbstractC0221q.m998a(i));
        return Insets.toCompatInsets(insetsIgnoringVisibility);
    }

    @Override // androidx.core.view.C0218n, androidx.core.view.C0220p
    /* renamed from: q */
    public boolean mo987q(int i) {
        boolean isVisible;
        isVisible = this.f4010c.isVisible(AbstractC0221q.m998a(i));
        return isVisible;
    }

    public C0219o(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull C0219o c0219o) {
        super(windowInsetsCompat, c0219o);
    }
}
