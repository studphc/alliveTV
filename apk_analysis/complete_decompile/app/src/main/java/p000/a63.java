package p000;

import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.C0218n;
import androidx.core.view.WindowInsetsCompat;

/* loaded from: classes.dex */
public class a63 extends C0218n {

    /* renamed from: m */
    public Insets f61m;

    public a63(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
        super(windowInsetsCompat, windowInsets);
        this.f61m = null;
    }

    @Override // androidx.core.view.C0220p
    @NonNull
    /* renamed from: b */
    public WindowInsetsCompat mo28b() {
        return WindowInsetsCompat.toWindowInsetsCompat(this.f4010c.consumeStableInsets());
    }

    @Override // androidx.core.view.C0220p
    @NonNull
    /* renamed from: c */
    public WindowInsetsCompat mo29c() {
        return WindowInsetsCompat.toWindowInsetsCompat(this.f4010c.consumeSystemWindowInsets());
    }

    @Override // androidx.core.view.C0220p
    @NonNull
    /* renamed from: j */
    public final Insets mo30j() {
        if (this.f61m == null) {
            WindowInsets windowInsets = this.f4010c;
            this.f61m = Insets.m828of(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f61m;
    }

    @Override // androidx.core.view.C0220p
    /* renamed from: o */
    public boolean mo31o() {
        return this.f4010c.isConsumed();
    }

    @Override // androidx.core.view.C0220p
    /* renamed from: u */
    public void mo32u(@Nullable Insets insets) {
        this.f61m = insets;
    }

    public a63(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull a63 a63Var) {
        super(windowInsetsCompat, a63Var);
        this.f61m = null;
        this.f61m = a63Var.f61m;
    }
}
