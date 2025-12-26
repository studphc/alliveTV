package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.WindowInsetsCompat;

/* renamed from: androidx.core.view.p */
/* loaded from: classes.dex */
public class C0220p {

    /* renamed from: b */
    public static final WindowInsetsCompat f4016b = new WindowInsetsCompat.Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();

    /* renamed from: a */
    public final WindowInsetsCompat f4017a;

    public C0220p(@NonNull WindowInsetsCompat windowInsetsCompat) {
        this.f4017a = windowInsetsCompat;
    }

    @NonNull
    /* renamed from: a */
    public WindowInsetsCompat mo993a() {
        return this.f4017a;
    }

    @NonNull
    /* renamed from: b */
    public WindowInsetsCompat mo28b() {
        return this.f4017a;
    }

    @NonNull
    /* renamed from: c */
    public WindowInsetsCompat mo29c() {
        return this.f4017a;
    }

    /* renamed from: d */
    public void mo980d(@NonNull View view) {
    }

    /* renamed from: e */
    public void mo981e(@NonNull WindowInsetsCompat windowInsetsCompat) {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0220p)) {
            return false;
        }
        C0220p c0220p = (C0220p) obj;
        if (mo986p() == c0220p.mo986p() && mo31o() == c0220p.mo31o() && ObjectsCompat.equals(mo984l(), c0220p.mo984l()) && ObjectsCompat.equals(mo30j(), c0220p.mo30j()) && ObjectsCompat.equals(mo994f(), c0220p.mo994f())) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f */
    public DisplayCutoutCompat mo994f() {
        return null;
    }

    @NonNull
    /* renamed from: g */
    public Insets mo982g(int i) {
        return Insets.NONE;
    }

    @NonNull
    /* renamed from: h */
    public Insets mo983h(int i) {
        if ((i & 8) == 0) {
            return Insets.NONE;
        }
        throw new IllegalArgumentException("Unable to query the maximum insets for IME");
    }

    public int hashCode() {
        return ObjectsCompat.hash(Boolean.valueOf(mo986p()), Boolean.valueOf(mo31o()), mo984l(), mo30j(), mo994f());
    }

    @NonNull
    /* renamed from: i */
    public Insets mo995i() {
        return mo984l();
    }

    @NonNull
    /* renamed from: j */
    public Insets mo30j() {
        return Insets.NONE;
    }

    @NonNull
    /* renamed from: k */
    public Insets mo996k() {
        return mo984l();
    }

    @NonNull
    /* renamed from: l */
    public Insets mo984l() {
        return Insets.NONE;
    }

    @NonNull
    /* renamed from: m */
    public Insets mo997m() {
        return mo984l();
    }

    @NonNull
    /* renamed from: n */
    public WindowInsetsCompat mo985n(int i, int i2, int i3, int i4) {
        return f4016b;
    }

    /* renamed from: o */
    public boolean mo31o() {
        return false;
    }

    /* renamed from: p */
    public boolean mo986p() {
        return false;
    }

    /* renamed from: q */
    public boolean mo987q(int i) {
        return true;
    }

    /* renamed from: r */
    public void mo988r(Insets[] insetsArr) {
    }

    /* renamed from: s */
    public void mo989s(@NonNull Insets insets) {
    }

    /* renamed from: t */
    public void mo990t(@Nullable WindowInsetsCompat windowInsetsCompat) {
    }

    /* renamed from: u */
    public void mo32u(Insets insets) {
    }
}
