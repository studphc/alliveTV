package p000;

import android.content.Context;
import androidx.annotation.DoNotInline;

/* renamed from: zv */
/* loaded from: classes.dex */
public abstract class AbstractC2071zv {
    @DoNotInline
    /* renamed from: a */
    public static int m8440a(Context context, int i) {
        return context.getColor(i);
    }

    @DoNotInline
    /* renamed from: b */
    public static <T> T m8441b(Context context, Class<T> cls) {
        return (T) context.getSystemService(cls);
    }

    @DoNotInline
    /* renamed from: c */
    public static String m8442c(Context context, Class<?> cls) {
        return context.getSystemServiceName(cls);
    }
}
