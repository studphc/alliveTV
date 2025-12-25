package androidx.tracing;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p000.xy0;

/* loaded from: classes.dex */
public final class Trace {

    /* renamed from: a */
    public static long f7543a;

    /* renamed from: b */
    public static Method f7544b;

    /* renamed from: c */
    public static Method f7545c;

    /* renamed from: d */
    public static Method f7546d;

    /* renamed from: e */
    public static Method f7547e;

    /* renamed from: a */
    public static void m1911a(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    @SuppressLint({"NewApi"})
    public static void beginAsyncSection(@NonNull String str, int i) {
        try {
            if (f7545c == null) {
                xy0.m8195a(str, i);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (f7545c == null) {
                f7545c = android.os.Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            f7545c.invoke(null, Long.valueOf(f7543a), str, Integer.valueOf(i));
        } catch (Exception e) {
            m1911a("asyncTraceBegin", e);
        }
    }

    public static void beginSection(@NonNull String str) {
        android.os.Trace.beginSection(str);
    }

    @SuppressLint({"NewApi"})
    public static void endAsyncSection(@NonNull String str, int i) {
        try {
            if (f7546d == null) {
                xy0.m8197c(str, i);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (f7546d == null) {
                f7546d = android.os.Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            f7546d.invoke(null, Long.valueOf(f7543a), str, Integer.valueOf(i));
        } catch (Exception e) {
            m1911a("asyncTraceEnd", e);
        }
    }

    public static void endSection() {
        android.os.Trace.endSection();
    }

    @SuppressLint({"NewApi"})
    public static boolean isEnabled() {
        boolean isEnabled;
        try {
            if (f7544b == null) {
                isEnabled = android.os.Trace.isEnabled();
                return isEnabled;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (f7544b == null) {
                f7543a = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f7544b = android.os.Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f7544b.invoke(null, Long.valueOf(f7543a))).booleanValue();
        } catch (Exception e) {
            m1911a("isTagEnabled", e);
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public static void setCounter(@NonNull String str, int i) {
        try {
            if (f7547e == null) {
                xy0.m8200f(str, i);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (f7547e == null) {
                f7547e = android.os.Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
            }
            f7547e.invoke(null, Long.valueOf(f7543a), str, Integer.valueOf(i));
        } catch (Exception e) {
            m1911a("traceCounter", e);
        }
    }
}
