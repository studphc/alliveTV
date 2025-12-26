package p000;

import android.graphics.drawable.Drawable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class n60 {

    /* renamed from: a */
    public static final boolean f23240a;

    /* renamed from: b */
    public static final Method f23241b;

    /* renamed from: c */
    public static final Field f23242c;

    /* renamed from: d */
    public static final Field f23243d;

    /* renamed from: e */
    public static final Field f23244e;

    /* renamed from: f */
    public static final Field f23245f;

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    static {
        Method method;
        Field field;
        Field field2;
        Field field3;
        Field field4;
        boolean z;
        Class<?> cls;
        try {
            cls = Class.forName("android.graphics.Insets");
            method = Drawable.class.getMethod("getOpticalInsets", null);
        } catch (ClassNotFoundException unused) {
            method = null;
            field = null;
        } catch (NoSuchFieldException unused2) {
            method = null;
            field = null;
        } catch (NoSuchMethodException unused3) {
            method = null;
            field = null;
        }
        try {
            field = cls.getField("left");
            try {
                field2 = cls.getField("top");
                try {
                    field3 = cls.getField("right");
                    try {
                        field4 = cls.getField("bottom");
                        z = true;
                    } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused4) {
                        field4 = null;
                        z = false;
                        if (!z) {
                        }
                    }
                } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused5) {
                    field3 = null;
                }
            } catch (ClassNotFoundException unused6) {
                field2 = null;
                field3 = field2;
                field4 = null;
                z = false;
                if (!z) {
                }
            } catch (NoSuchFieldException unused7) {
                field2 = null;
                field3 = field2;
                field4 = null;
                z = false;
                if (!z) {
                }
            } catch (NoSuchMethodException unused8) {
                field2 = null;
                field3 = field2;
                field4 = null;
                z = false;
                if (!z) {
                }
            }
        } catch (ClassNotFoundException unused9) {
            field = null;
            field2 = field;
            field3 = field2;
            field4 = null;
            z = false;
            if (!z) {
            }
        } catch (NoSuchFieldException unused10) {
            field = null;
            field2 = field;
            field3 = field2;
            field4 = null;
            z = false;
            if (!z) {
            }
        } catch (NoSuchMethodException unused11) {
            field = null;
            field2 = field;
            field3 = field2;
            field4 = null;
            z = false;
            if (!z) {
            }
        }
        if (!z) {
            f23241b = method;
            f23242c = field;
            f23243d = field2;
            f23244e = field3;
            f23245f = field4;
            f23240a = true;
            return;
        }
        f23241b = null;
        f23242c = null;
        f23243d = null;
        f23244e = null;
        f23245f = null;
        f23240a = false;
    }
}
