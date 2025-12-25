package p000;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class a70 {

    /* renamed from: a */
    public static final Method f68a;

    /* renamed from: b */
    public static final Method f69b;

    /* renamed from: c */
    public static final Method f70c;

    /* renamed from: d */
    public static final boolean f71d;

    static {
        try {
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
            f68a = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
            f69b = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
            f70c = declaredMethod3;
            declaredMethod3.setAccessible(true);
            f71d = true;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
