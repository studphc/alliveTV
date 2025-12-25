package androidx.core.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;

/* renamed from: androidx.core.view.m */
/* loaded from: classes.dex */
public abstract class AbstractC0217m {

    /* renamed from: a */
    public final WindowInsetsCompat f4003a;

    /* renamed from: b */
    public Insets[] f4004b;

    public AbstractC0217m() {
        this(new WindowInsetsCompat((WindowInsetsCompat) null));
    }

    /* renamed from: a */
    public final void m965a() {
        Insets[] insetsArr = this.f4004b;
        if (insetsArr != null) {
            Insets insets = insetsArr[0];
            Insets insets2 = insetsArr[1];
            WindowInsetsCompat windowInsetsCompat = this.f4003a;
            if (insets2 == null) {
                insets2 = windowInsetsCompat.getInsets(2);
            }
            if (insets == null) {
                insets = windowInsetsCompat.getInsets(1);
            }
            mo973i(Insets.max(insets, insets2));
            Insets insets3 = this.f4004b[WindowInsetsCompat.Type.m919a(16)];
            if (insets3 != null) {
                mo972h(insets3);
            }
            Insets insets4 = this.f4004b[WindowInsetsCompat.Type.m919a(32)];
            if (insets4 != null) {
                mo970f(insets4);
            }
            Insets insets5 = this.f4004b[WindowInsetsCompat.Type.m919a(64)];
            if (insets5 != null) {
                mo974j(insets5);
            }
        }
    }

    @NonNull
    /* renamed from: b */
    public abstract WindowInsetsCompat mo966b();

    /* renamed from: c */
    public void mo967c(@Nullable DisplayCutoutCompat displayCutoutCompat) {
    }

    /* renamed from: d */
    public void mo968d(int i, @NonNull Insets insets) {
        if (this.f4004b == null) {
            this.f4004b = new Insets[9];
        }
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if ((i & i2) != 0) {
                this.f4004b[WindowInsetsCompat.Type.m919a(i2)] = insets;
            }
        }
    }

    /* renamed from: e */
    public void mo969e(int i, @NonNull Insets insets) {
        if (i != 8) {
        } else {
            throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
        }
    }

    /* renamed from: f */
    public void mo970f(@NonNull Insets insets) {
    }

    /* renamed from: g */
    public abstract void mo971g(@NonNull Insets insets);

    /* renamed from: h */
    public void mo972h(@NonNull Insets insets) {
    }

    /* renamed from: i */
    public abstract void mo973i(@NonNull Insets insets);

    /* renamed from: j */
    public void mo974j(@NonNull Insets insets) {
    }

    /* renamed from: k */
    public void mo975k(int i, boolean z) {
    }

    public AbstractC0217m(@NonNull WindowInsetsCompat windowInsetsCompat) {
        this.f4003a = windowInsetsCompat;
    }
}
