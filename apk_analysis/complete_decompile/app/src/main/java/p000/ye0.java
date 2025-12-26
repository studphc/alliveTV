package p000;

import android.app.Instrumentation;
import androidx.fragment.app.Fragment;
import com.google.android.exoplayer2.util.Log;
import com.google.android.gms.internal.measurement.zzbl;
import com.google.android.gms.internal.measurement.zzh;
import com.google.android.gms.internal.measurement.zzlk;
import com.google.common.collect.C0915o3;
import com.google.common.primitives.UnsignedLongs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.ULong;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.flow.FlowKt;

/* loaded from: classes.dex */
public abstract /* synthetic */ class ye0 {
    /* renamed from: A */
    public static void m8278A(int i, HashMap hashMap, String str, int i2, String str2) {
        hashMap.put(str, Integer.valueOf(i));
        hashMap.put(str2, Integer.valueOf(i2));
    }

    /* renamed from: B */
    public static void m8279B(String str, String str2, String str3) {
        Log.m3027w(str3, str + str2);
    }

    /* renamed from: C */
    public static /* synthetic */ void m8280C(wd3 wd3Var) {
        if (wd3Var != null) {
            throw new ClassCastException();
        }
    }

    /* renamed from: a */
    public static int m8281a(int i, C0915o3 c0915o3) {
        if (i != 1) {
            return 1;
        }
        return c0915o3.f14918b;
    }

    /* renamed from: b */
    public static long m8282b(int i, long j, long j2) {
        if (i != 1) {
            long j3 = j >>> 32;
            long j4 = j & 4294967295L;
            long m8284d = m8284d(j3 * j3, j2);
            long j5 = j3 * j4 * 2;
            if (j5 < 0) {
                j5 = UnsignedLongs.remainder(j5, j2);
            }
            long m8284d2 = m8284d(m8284d + j5, j2);
            long remainder = UnsignedLongs.remainder(j4 * j4, j2);
            long j6 = m8284d2 + remainder;
            if (m8284d2 >= j2 - remainder) {
                return j6 - j2;
            }
            return j6;
        }
        return (j * j) % j2;
    }

    /* renamed from: c */
    public static long m8283c(int i, C0915o3 c0915o3) {
        if (i != 1) {
            if (c0915o3 == null) {
                return 0L;
            }
            return c0915o3.f14919c;
        }
        if (c0915o3 == null) {
            return 0L;
        }
        return c0915o3.f14920d;
    }

    /* renamed from: d */
    public static long m8284d(long j, long j2) {
        int i = 32;
        do {
            int min = Math.min(i, Long.numberOfLeadingZeros(j));
            j = UnsignedLongs.remainder(j << min, j2);
            i -= min;
        } while (i > 0);
        return j;
    }

    /* renamed from: e */
    public static int m8285e(int i, int i2, int i3) {
        return zzlk.zzz(i) + i2 + i3;
    }

    /* renamed from: f */
    public static int m8286f(int i, int i2, String str) {
        return (str.hashCode() + i) * i2;
    }

    /* renamed from: g */
    public static long m8287g(long j, long j2) {
        return ULong.m8570constructorimpl(ULong.m8570constructorimpl(j) * j2);
    }

    /* renamed from: h */
    public static Object m8288h(zzbl zzblVar, int i, List list, int i2) {
        zzh.zzh(zzblVar.name(), i, list);
        return list.get(i2);
    }

    /* renamed from: i */
    public static Object m8289i(CharSequence charSequence, int i, Function1 function1) {
        return function1.invoke(Character.valueOf(charSequence.charAt(i)));
    }

    /* renamed from: j */
    public static String m8290j(int i, int i2, String str) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    /* renamed from: k */
    public static String m8291k(int i, String str) {
        return str + i;
    }

    /* renamed from: l */
    public static String m8292l(int i, String str, String str2) {
        return str + i + str2;
    }

    /* renamed from: m */
    public static String m8293m(int i, String str, String str2, int i2) {
        return str + i + str2 + i2;
    }

    /* renamed from: n */
    public static String m8294n(long j, String str) {
        return str + j;
    }

    /* renamed from: o */
    public static String m8295o(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    /* renamed from: p */
    public static String m8296p(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    /* renamed from: q */
    public static String m8297q(StringBuilder sb, long j, String str) {
        sb.append(j);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: r */
    public static String m8298r(StringBuilder sb, String str, int i) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: s */
    public static StringBuilder m8299s(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    /* renamed from: t */
    public static StringBuilder m8300t(CharSequence charSequence, String str, CharSequence charSequence2, String str2, CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, str);
        Intrinsics.checkNotNullParameter(charSequence2, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence3);
        return sb;
    }

    /* renamed from: u */
    public static StringBuilder m8301u(CharSequence charSequence, String str, Function1 function1, String str2, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, str);
        Intrinsics.checkNotNullParameter(function1, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        return sb;
    }

    /* renamed from: v */
    public static StringBuilder m8302v(String str, int i, String str2, int i2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        sb.append(str3);
        return sb;
    }

    /* renamed from: w */
    public static StringBuilder m8303w(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    /* renamed from: x */
    public static Iterator m8304x(Sequence sequence, String str, Function1 function1, String str2) {
        Intrinsics.checkNotNullParameter(sequence, str);
        Intrinsics.checkNotNullParameter(function1, str2);
        return sequence.iterator();
    }

    /* renamed from: y */
    public static KotlinNothingValueException m8305y() {
        FlowKt.noImpl();
        return new KotlinNothingValueException();
    }

    /* renamed from: z */
    public static void m8306z(int i) {
        new Instrumentation().sendKeyDownUpSync(i);
    }
}
