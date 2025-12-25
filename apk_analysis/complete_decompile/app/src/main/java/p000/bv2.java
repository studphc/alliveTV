package p000;

import android.os.Trace;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class bv2 {
    @DoNotInline
    /* renamed from: a */
    public static void m2168a(String str, int i) {
        Trace.beginAsyncSection(str, i);
    }

    @DoNotInline
    /* renamed from: b */
    public static void m2169b(String str, int i) {
        Trace.endAsyncSection(str, i);
    }

    @DoNotInline
    /* renamed from: c */
    public static boolean m2170c() {
        return Trace.isEnabled();
    }

    @DoNotInline
    /* renamed from: d */
    public static void m2171d(String str, long j) {
        Trace.setCounter(str, j);
    }
}
