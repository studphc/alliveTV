package androidx.constraintlayout.motion.utils;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p000.AbstractC1370jx;
import p000.AbstractC1726qj;

/* loaded from: classes.dex */
public class CustomSupport {
    /* renamed from: a */
    public static int m553a(int i) {
        int i2 = (i & (~(i >> 31))) - 255;
        return (i2 & (i2 >> 31)) + 255;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0037. Please report as an issue. */
    public static void setInterpolatedValue(ConstraintAttribute constraintAttribute, View view, float[] fArr) {
        String str;
        boolean z;
        String str2 = "\"";
        Class<?> cls = view.getClass();
        String str3 = "set" + constraintAttribute.getName();
        try {
            try {
                try {
                    try {
                        switch (AbstractC1370jx.f20667a[constraintAttribute.getType().ordinal()]) {
                            case 1:
                                str = "\"";
                                cls.getMethod(str3, Integer.TYPE).invoke(view, Integer.valueOf((int) fArr[0]));
                                return;
                            case 2:
                                str = "\"";
                                cls.getMethod(str3, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                                return;
                            case 3:
                                str = "\"";
                                Method method = cls.getMethod(str3, Drawable.class);
                                int m553a = (m553a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (m553a((int) (fArr[3] * 255.0f)) << 24) | (m553a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | m553a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
                                ColorDrawable colorDrawable = new ColorDrawable();
                                colorDrawable.setColor(m553a);
                                method.invoke(view, colorDrawable);
                                return;
                            case 4:
                                try {
                                } catch (IllegalAccessException e) {
                                    e = e;
                                    str = "\"";
                                } catch (NoSuchMethodException e2) {
                                    e = e2;
                                    str = "\"";
                                }
                                try {
                                    str = "\"";
                                    try {
                                        cls.getMethod(str3, Integer.TYPE).invoke(view, Integer.valueOf((m553a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (m553a((int) (fArr[3] * 255.0f)) << 24) | (m553a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | m553a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f))));
                                        return;
                                    } catch (IllegalAccessException e3) {
                                        e = e3;
                                        str2 = str;
                                        StringBuilder m7065u = AbstractC1726qj.m7065u("Cannot access method ", str3, " on View \"");
                                        m7065u.append(Debug.getName(view));
                                        m7065u.append(str2);
                                        Log.e("CustomSupport", m7065u.toString(), e);
                                        return;
                                    } catch (NoSuchMethodException e4) {
                                        e = e4;
                                        str2 = str;
                                        StringBuilder m7065u2 = AbstractC1726qj.m7065u("No method ", str3, " on View \"");
                                        m7065u2.append(Debug.getName(view));
                                        m7065u2.append(str2);
                                        Log.e("CustomSupport", m7065u2.toString(), e);
                                        return;
                                    } catch (InvocationTargetException e5) {
                                        e = e5;
                                        StringBuilder m7065u3 = AbstractC1726qj.m7065u("Cannot invoke method ", str3, " on View \"");
                                        m7065u3.append(Debug.getName(view));
                                        m7065u3.append(str);
                                        Log.e("CustomSupport", m7065u3.toString(), e);
                                        return;
                                    }
                                } catch (IllegalAccessException e6) {
                                    e = e6;
                                    StringBuilder m7065u4 = AbstractC1726qj.m7065u("Cannot access method ", str3, " on View \"");
                                    m7065u4.append(Debug.getName(view));
                                    m7065u4.append(str2);
                                    Log.e("CustomSupport", m7065u4.toString(), e);
                                    return;
                                } catch (NoSuchMethodException e7) {
                                    e = e7;
                                    StringBuilder m7065u22 = AbstractC1726qj.m7065u("No method ", str3, " on View \"");
                                    m7065u22.append(Debug.getName(view));
                                    m7065u22.append(str2);
                                    Log.e("CustomSupport", m7065u22.toString(), e);
                                    return;
                                } catch (InvocationTargetException e8) {
                                    e = e8;
                                    str = "\"";
                                    StringBuilder m7065u32 = AbstractC1726qj.m7065u("Cannot invoke method ", str3, " on View \"");
                                    m7065u32.append(Debug.getName(view));
                                    m7065u32.append(str);
                                    Log.e("CustomSupport", m7065u32.toString(), e);
                                    return;
                                }
                            case 5:
                                throw new RuntimeException("unable to interpolate strings " + constraintAttribute.getName());
                            case 6:
                                Method method2 = cls.getMethod(str3, Boolean.TYPE);
                                if (fArr[0] > 0.5f) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                method2.invoke(view, Boolean.valueOf(z));
                                return;
                            case 7:
                                cls.getMethod(str3, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                                return;
                            default:
                                return;
                        }
                    } catch (IllegalAccessException e9) {
                        e = e9;
                    } catch (NoSuchMethodException e10) {
                        e = e10;
                    } catch (InvocationTargetException e11) {
                        e = e11;
                    }
                } catch (IllegalAccessException e12) {
                    e = e12;
                } catch (NoSuchMethodException e13) {
                    e = e13;
                }
            } catch (InvocationTargetException e14) {
                e = e14;
            }
        } catch (IllegalAccessException e15) {
            e = e15;
        } catch (NoSuchMethodException e16) {
            e = e16;
        }
    }
}
