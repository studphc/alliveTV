package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* renamed from: androidx.core.view.n */
/* loaded from: classes.dex */
public class C0218n extends C0220p {

    /* renamed from: h */
    public static boolean f4005h = false;

    /* renamed from: i */
    public static Method f4006i;

    /* renamed from: j */
    public static Class f4007j;

    /* renamed from: k */
    public static Field f4008k;

    /* renamed from: l */
    public static Field f4009l;

    /* renamed from: c */
    public final WindowInsets f4010c;

    /* renamed from: d */
    public Insets[] f4011d;

    /* renamed from: e */
    public Insets f4012e;

    /* renamed from: f */
    public WindowInsetsCompat f4013f;

    /* renamed from: g */
    public Insets f4014g;

    public C0218n(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
        super(windowInsetsCompat);
        this.f4012e = null;
        this.f4010c = windowInsets;
    }

    @SuppressLint({"PrivateApi"})
    /* renamed from: A */
    private static void m976A() {
        try {
            f4006i = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            f4007j = cls;
            f4008k = cls.getDeclaredField("mVisibleInsets");
            f4009l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            f4008k.setAccessible(true);
            f4009l.setAccessible(true);
        } catch (ReflectiveOperationException e) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
        }
        f4005h = true;
    }

    @NonNull
    @SuppressLint({"WrongConstant"})
    /* renamed from: v */
    private Insets m977v(int i, boolean z) {
        Insets insets = Insets.NONE;
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if ((i & i2) != 0) {
                insets = Insets.max(insets, m991w(i2, z));
            }
        }
        return insets;
    }

    /* renamed from: x */
    private Insets m978x() {
        WindowInsetsCompat windowInsetsCompat = this.f4013f;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getStableInsets();
        }
        return Insets.NONE;
    }

    @Nullable
    /* renamed from: y */
    private Insets m979y(@NonNull View view) {
        if (Build.VERSION.SDK_INT < 30) {
            if (!f4005h) {
                m976A();
            }
            Method method = f4006i;
            if (method != null && f4007j != null && f4008k != null) {
                try {
                    Object invoke = method.invoke(view, null);
                    if (invoke == null) {
                        Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) f4008k.get(f4009l.get(invoke));
                    if (rect == null) {
                        return null;
                    }
                    return Insets.m829of(rect);
                } catch (ReflectiveOperationException e) {
                    Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
                }
            }
            return null;
        }
        throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
    }

    @Override // androidx.core.view.C0220p
    /* renamed from: d */
    public void mo980d(@NonNull View view) {
        Insets m979y = m979y(view);
        if (m979y == null) {
            m979y = Insets.NONE;
        }
        mo989s(m979y);
    }

    @Override // androidx.core.view.C0220p
    /* renamed from: e */
    public void mo981e(@NonNull WindowInsetsCompat windowInsetsCompat) {
        windowInsetsCompat.f3941a.mo990t(this.f4013f);
        windowInsetsCompat.f3941a.mo989s(this.f4014g);
    }

    @Override // androidx.core.view.C0220p
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        return Objects.equals(this.f4014g, ((C0218n) obj).f4014g);
    }

    @Override // androidx.core.view.C0220p
    @NonNull
    /* renamed from: g */
    public Insets mo982g(int i) {
        return m977v(i, false);
    }

    @Override // androidx.core.view.C0220p
    @NonNull
    /* renamed from: h */
    public Insets mo983h(int i) {
        return m977v(i, true);
    }

    @Override // androidx.core.view.C0220p
    @NonNull
    /* renamed from: l */
    public final Insets mo984l() {
        if (this.f4012e == null) {
            WindowInsets windowInsets = this.f4010c;
            this.f4012e = Insets.m828of(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.f4012e;
    }

    @Override // androidx.core.view.C0220p
    @NonNull
    /* renamed from: n */
    public WindowInsetsCompat mo985n(int i, int i2, int i3, int i4) {
        WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(WindowInsetsCompat.toWindowInsetsCompat(this.f4010c));
        builder.setSystemWindowInsets(WindowInsetsCompat.m918a(mo984l(), i, i2, i3, i4));
        builder.setStableInsets(WindowInsetsCompat.m918a(mo30j(), i, i2, i3, i4));
        return builder.build();
    }

    @Override // androidx.core.view.C0220p
    /* renamed from: p */
    public boolean mo986p() {
        return this.f4010c.isRound();
    }

    @Override // androidx.core.view.C0220p
    @SuppressLint({"WrongConstant"})
    /* renamed from: q */
    public boolean mo987q(int i) {
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if ((i & i2) != 0 && !m992z(i2)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.core.view.C0220p
    /* renamed from: r */
    public void mo988r(Insets[] insetsArr) {
        this.f4011d = insetsArr;
    }

    @Override // androidx.core.view.C0220p
    /* renamed from: s */
    public void mo989s(@NonNull Insets insets) {
        this.f4014g = insets;
    }

    @Override // androidx.core.view.C0220p
    /* renamed from: t */
    public void mo990t(@Nullable WindowInsetsCompat windowInsetsCompat) {
        this.f4013f = windowInsetsCompat;
    }

    @NonNull
    /* renamed from: w */
    public Insets m991w(int i, boolean z) {
        int i2;
        DisplayCutoutCompat mo994f;
        if (i != 1) {
            Insets insets = null;
            if (i != 2) {
                if (i != 8) {
                    if (i != 16) {
                        if (i != 32) {
                            if (i != 64) {
                                if (i != 128) {
                                    return Insets.NONE;
                                }
                                WindowInsetsCompat windowInsetsCompat = this.f4013f;
                                if (windowInsetsCompat != null) {
                                    mo994f = windowInsetsCompat.getDisplayCutout();
                                } else {
                                    mo994f = mo994f();
                                }
                                if (mo994f != null) {
                                    return Insets.m828of(mo994f.getSafeInsetLeft(), mo994f.getSafeInsetTop(), mo994f.getSafeInsetRight(), mo994f.getSafeInsetBottom());
                                }
                                return Insets.NONE;
                            }
                            return mo997m();
                        }
                        return mo995i();
                    }
                    return mo996k();
                }
                Insets[] insetsArr = this.f4011d;
                if (insetsArr != null) {
                    insets = insetsArr[WindowInsetsCompat.Type.m919a(8)];
                }
                if (insets != null) {
                    return insets;
                }
                Insets mo984l = mo984l();
                Insets m978x = m978x();
                int i3 = mo984l.bottom;
                if (i3 > m978x.bottom) {
                    return Insets.m828of(0, 0, 0, i3);
                }
                Insets insets2 = this.f4014g;
                if (insets2 != null && !insets2.equals(Insets.NONE) && (i2 = this.f4014g.bottom) > m978x.bottom) {
                    return Insets.m828of(0, 0, 0, i2);
                }
                return Insets.NONE;
            }
            if (z) {
                Insets m978x2 = m978x();
                Insets mo30j = mo30j();
                return Insets.m828of(Math.max(m978x2.left, mo30j.left), 0, Math.max(m978x2.right, mo30j.right), Math.max(m978x2.bottom, mo30j.bottom));
            }
            Insets mo984l2 = mo984l();
            WindowInsetsCompat windowInsetsCompat2 = this.f4013f;
            if (windowInsetsCompat2 != null) {
                insets = windowInsetsCompat2.getStableInsets();
            }
            int i4 = mo984l2.bottom;
            if (insets != null) {
                i4 = Math.min(i4, insets.bottom);
            }
            return Insets.m828of(mo984l2.left, 0, mo984l2.right, i4);
        }
        if (z) {
            return Insets.m828of(0, Math.max(m978x().top, mo984l().top), 0, 0);
        }
        return Insets.m828of(0, mo984l().top, 0, 0);
    }

    /* renamed from: z */
    public boolean m992z(int i) {
        if (i != 1 && i != 2) {
            if (i == 4) {
                return false;
            }
            if (i != 8 && i != 128) {
                return true;
            }
        }
        return !m991w(i, false).equals(Insets.NONE);
    }

    public C0218n(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull C0218n c0218n) {
        this(windowInsetsCompat, new WindowInsets(c0218n.f4010c));
    }
}
