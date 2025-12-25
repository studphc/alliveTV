package p000;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class p33 extends ViewOscillator {

    /* renamed from: g */
    public boolean f25024g;

    @Override // androidx.constraintlayout.motion.utils.ViewOscillator
    public final void setProperty(View view, float f) {
        Method method;
        if (view instanceof MotionLayout) {
            ((MotionLayout) view).setProgress(get(f));
            return;
        }
        if (this.f25024g) {
            return;
        }
        try {
            method = view.getClass().getMethod("setProgress", Float.TYPE);
        } catch (NoSuchMethodException unused) {
            this.f25024g = true;
            method = null;
        }
        if (method != null) {
            try {
                method.invoke(view, Float.valueOf(get(f)));
            } catch (IllegalAccessException e) {
                Log.e("ViewOscillator", "unable to setProgress", e);
            } catch (InvocationTargetException e2) {
                Log.e("ViewOscillator", "unable to setProgress", e2);
            }
        }
    }
}
