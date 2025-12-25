package androidx.core.view;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* renamed from: androidx.core.view.l */
/* loaded from: classes.dex */
public abstract class AbstractC0216l {

    /* renamed from: a */
    public static final Field f3999a;

    /* renamed from: b */
    public static final Field f4000b;

    /* renamed from: c */
    public static final Field f4001c;

    /* renamed from: d */
    public static final boolean f4002d;

    static {
        try {
            Field declaredField = View.class.getDeclaredField("mAttachInfo");
            f3999a = declaredField;
            declaredField.setAccessible(true);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            Field declaredField2 = cls.getDeclaredField("mStableInsets");
            f4000b = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mContentInsets");
            f4001c = declaredField3;
            declaredField3.setAccessible(true);
            f4002d = true;
        } catch (ReflectiveOperationException e) {
            Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
        }
    }
}
