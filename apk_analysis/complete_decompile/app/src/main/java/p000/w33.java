package p000;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class w33 extends ViewSpline {

    /* renamed from: c */
    public boolean f28063c;

    @Override // androidx.constraintlayout.motion.utils.ViewSpline
    public final void setProperty(View view, float f) {
        Method method;
        if (view instanceof MotionLayout) {
            ((MotionLayout) view).setProgress(get(f));
            return;
        }
        if (this.f28063c) {
            return;
        }
        try {
            method = view.getClass().getMethod("setProgress", Float.TYPE);
        } catch (NoSuchMethodException unused) {
            this.f28063c = true;
            method = null;
        }
        if (method != null) {
            try {
                method.invoke(view, Float.valueOf(get(f)));
            } catch (IllegalAccessException e) {
                Log.e("ViewSpline", "unable to setProgress", e);
            } catch (InvocationTargetException e2) {
                Log.e("ViewSpline", "unable to setProgress", e2);
            }
        }
    }
}
