package p000;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.AbstractC0217m;
import androidx.core.view.WindowInsetsCompat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class w53 extends AbstractC0217m {

    /* renamed from: e */
    public static Field f28073e = null;

    /* renamed from: f */
    public static boolean f28074f = false;

    /* renamed from: g */
    public static Constructor f28075g = null;

    /* renamed from: h */
    public static boolean f28076h = false;

    /* renamed from: c */
    public WindowInsets f28077c;

    /* renamed from: d */
    public Insets f28078d;

    public w53() {
        this.f28077c = m8006l();
    }

    @Nullable
    /* renamed from: l */
    private static WindowInsets m8006l() {
        if (!f28074f) {
            try {
                f28073e = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e);
            }
            f28074f = true;
        }
        Field field = f28073e;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e2) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e2);
            }
        }
        if (!f28076h) {
            try {
                f28075g = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e3) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e3);
            }
            f28076h = true;
        }
        Constructor constructor = f28075g;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e4) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e4);
            }
        }
        return null;
    }

    @Override // androidx.core.view.AbstractC0217m
    @NonNull
    /* renamed from: b */
    public WindowInsetsCompat mo966b() {
        m965a();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.f28077c);
        windowInsetsCompat.f3941a.mo988r(this.f4004b);
        windowInsetsCompat.f3941a.mo32u(this.f28078d);
        return windowInsetsCompat;
    }

    @Override // androidx.core.view.AbstractC0217m
    /* renamed from: g */
    public void mo971g(@Nullable Insets insets) {
        this.f28078d = insets;
    }

    @Override // androidx.core.view.AbstractC0217m
    /* renamed from: i */
    public void mo973i(@NonNull Insets insets) {
        WindowInsets windowInsets = this.f28077c;
        if (windowInsets != null) {
            this.f28077c = windowInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
        }
    }

    public w53(@NonNull WindowInsetsCompat windowInsetsCompat) {
        super(windowInsetsCompat);
        this.f28077c = windowInsetsCompat.toWindowInsets();
    }
}
