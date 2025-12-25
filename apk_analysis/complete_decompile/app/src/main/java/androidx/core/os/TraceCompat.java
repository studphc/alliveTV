package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.Method;
import p000.bv2;

@Deprecated
/* loaded from: classes.dex */
public final class TraceCompat {

    /* renamed from: a */
    public static final long f3712a;

    /* renamed from: b */
    public static final Method f3713b;

    /* renamed from: c */
    public static final Method f3714c;

    /* renamed from: d */
    public static final Method f3715d;

    /* renamed from: e */
    public static final Method f3716e;

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f3712a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f3713b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f3714c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f3715d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f3716e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception e) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e);
            }
        }
    }

    public static void beginAsyncSection(@NonNull String str, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            bv2.m2168a(str, i);
            return;
        }
        try {
            f3714c.invoke(null, Long.valueOf(f3712a), str, Integer.valueOf(i));
        } catch (Exception unused) {
            Log.v("TraceCompat", "Unable to invoke asyncTraceBegin() via reflection.");
        }
    }

    public static void beginSection(@NonNull String str) {
        Trace.beginSection(str);
    }

    public static void endAsyncSection(@NonNull String str, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            bv2.m2169b(str, i);
            return;
        }
        try {
            f3715d.invoke(null, Long.valueOf(f3712a), str, Integer.valueOf(i));
        } catch (Exception unused) {
            Log.v("TraceCompat", "Unable to invoke endAsyncSection() via reflection.");
        }
    }

    public static void endSection() {
        Trace.endSection();
    }

    public static boolean isEnabled() {
        if (Build.VERSION.SDK_INT >= 29) {
            return bv2.m2170c();
        }
        try {
            return ((Boolean) f3713b.invoke(null, Long.valueOf(f3712a))).booleanValue();
        } catch (Exception unused) {
            Log.v("TraceCompat", "Unable to invoke isTagEnabled() via reflection.");
            return false;
        }
    }

    public static void setCounter(@NonNull String str, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            bv2.m2171d(str, i);
            return;
        }
        try {
            f3716e.invoke(null, Long.valueOf(f3712a), str, Integer.valueOf(i));
        } catch (Exception unused) {
            Log.v("TraceCompat", "Unable to invoke traceCounter() via reflection.");
        }
    }
}
