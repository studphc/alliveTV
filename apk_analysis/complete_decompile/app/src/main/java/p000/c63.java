package p000;

import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;

/* loaded from: classes.dex */
public class c63 extends b63 {

    /* renamed from: n */
    public Insets f8275n;

    /* renamed from: o */
    public Insets f8276o;

    /* renamed from: p */
    public Insets f8277p;

    public c63(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
        super(windowInsetsCompat, windowInsets);
        this.f8275n = null;
        this.f8276o = null;
        this.f8277p = null;
    }

    @Override // androidx.core.view.C0220p
    @NonNull
    /* renamed from: i */
    public Insets mo995i() {
        android.graphics.Insets mandatorySystemGestureInsets;
        if (this.f8276o == null) {
            mandatorySystemGestureInsets = this.f4010c.getMandatorySystemGestureInsets();
            this.f8276o = Insets.toCompatInsets(mandatorySystemGestureInsets);
        }
        return this.f8276o;
    }

    @Override // androidx.core.view.C0220p
    @NonNull
    /* renamed from: k */
    public Insets mo996k() {
        android.graphics.Insets systemGestureInsets;
        if (this.f8275n == null) {
            systemGestureInsets = this.f4010c.getSystemGestureInsets();
            this.f8275n = Insets.toCompatInsets(systemGestureInsets);
        }
        return this.f8275n;
    }

    @Override // androidx.core.view.C0220p
    @NonNull
    /* renamed from: m */
    public Insets mo997m() {
        android.graphics.Insets tappableElementInsets;
        if (this.f8277p == null) {
            tappableElementInsets = this.f4010c.getTappableElementInsets();
            this.f8277p = Insets.toCompatInsets(tappableElementInsets);
        }
        return this.f8277p;
    }

    @Override // androidx.core.view.C0218n, androidx.core.view.C0220p
    @NonNull
    /* renamed from: n */
    public WindowInsetsCompat mo985n(int i, int i2, int i3, int i4) {
        WindowInsets inset;
        inset = this.f4010c.inset(i, i2, i3, i4);
        return WindowInsetsCompat.toWindowInsetsCompat(inset);
    }

    public c63(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull c63 c63Var) {
        super(windowInsetsCompat, c63Var);
        this.f8275n = null;
        this.f8276o = null;
        this.f8277p = null;
    }

    @Override // p000.a63, androidx.core.view.C0220p
    /* renamed from: u */
    public void mo32u(@Nullable Insets insets) {
    }
}
