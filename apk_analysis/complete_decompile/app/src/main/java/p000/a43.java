package p000;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class a43 extends ViewTimeCycle {

    /* renamed from: a */
    public boolean f38a;

    @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
    public final boolean setProperty(View view, float f, long j, KeyCache keyCache) {
        Method method;
        if (view instanceof MotionLayout) {
            ((MotionLayout) view).setProgress(get(f, j, view, keyCache));
        } else {
            if (this.f38a) {
                return false;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f38a = true;
                method = null;
            }
            Method method2 = method;
            if (method2 != null) {
                try {
                    method2.invoke(view, Float.valueOf(get(f, j, view, keyCache)));
                } catch (IllegalAccessException e) {
                    Log.e("ViewTimeCycle", "unable to setProgress", e);
                } catch (InvocationTargetException e2) {
                    Log.e("ViewTimeCycle", "unable to setProgress", e2);
                }
            }
        }
        return this.mContinue;
    }
}
