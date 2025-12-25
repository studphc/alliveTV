package p000;

import androidx.annotation.NonNull;
import androidx.core.graphics.Insets;
import androidx.core.view.AbstractC0221q;
import androidx.core.view.WindowInsetsCompat;

/* loaded from: classes.dex */
public final class z53 extends y53 {
    public z53() {
    }

    @Override // androidx.core.view.AbstractC0217m
    /* renamed from: d */
    public void mo968d(int i, @NonNull Insets insets) {
        this.f28846c.setInsets(AbstractC0221q.m998a(i), insets.toPlatformInsets());
    }

    @Override // androidx.core.view.AbstractC0217m
    /* renamed from: e */
    public void mo969e(int i, @NonNull Insets insets) {
        this.f28846c.setInsetsIgnoringVisibility(AbstractC0221q.m998a(i), insets.toPlatformInsets());
    }

    @Override // androidx.core.view.AbstractC0217m
    /* renamed from: k */
    public void mo975k(int i, boolean z) {
        this.f28846c.setVisible(AbstractC0221q.m998a(i), z);
    }

    public z53(@NonNull WindowInsetsCompat windowInsetsCompat) {
        super(windowInsetsCompat);
    }
}
