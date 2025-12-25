package androidx.activity;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Field;

/* JADX INFO: Access modifiers changed from: package-private */
@RequiresApi(19)
/* loaded from: classes.dex */
public final class ImmLeaksCleaner implements LifecycleEventObserver {

    /* renamed from: b */
    public static int f495b;

    /* renamed from: c */
    public static Field f496c;

    /* renamed from: d */
    public static Field f497d;

    /* renamed from: e */
    public static Field f498e;

    /* renamed from: a */
    public ComponentActivity f499a;

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        if (f495b == 0) {
            try {
                f495b = 2;
                Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                f497d = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                f498e = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                f496c = declaredField3;
                declaredField3.setAccessible(true);
                f495b = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
        if (f495b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f499a.getSystemService("input_method");
            try {
                Object obj = f496c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f497d.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f498e.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused2) {
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (ClassCastException unused3) {
                    } catch (IllegalAccessException unused4) {
                    }
                }
            } catch (IllegalAccessException unused5) {
            }
        }
    }
}
