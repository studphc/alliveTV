package p000;

import android.content.LocusId;
import android.os.Handler;
import android.os.Trace;

/* loaded from: classes.dex */
public abstract class xy0 {
    /* renamed from: a */
    public static void m8195a(String str, int i) {
        Trace.beginAsyncSection(str, i);
    }

    /* renamed from: b */
    public static LocusId m8196b(String str) {
        return new LocusId(str);
    }

    /* renamed from: c */
    public static void m8197c(String str, int i) {
        Trace.endAsyncSection(str, i);
    }

    /* renamed from: d */
    public static String m8198d(LocusId locusId) {
        return locusId.getId();
    }

    /* renamed from: e */
    public static boolean m8199e(Handler handler, Runnable runnable) {
        return handler.hasCallbacks(runnable);
    }

    /* renamed from: f */
    public static void m8200f(String str, int i) {
        Trace.setCounter(str, i);
    }
}
