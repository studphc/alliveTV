package p000;

import android.graphics.Canvas;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.util.Log;
import com.google.android.gms.measurement.internal.zzio;
import com.google.common.cache.C0839d;
import com.google.common.cache.ConcurrentMapC0840e;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* renamed from: qj */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC1726qj {

    /* renamed from: a */
    public static final /* synthetic */ int[] f25609a = {1, 2, 3, 4, 5, 6, 7, 8};

    /* renamed from: b */
    public static final int[] f25610b = {1, 2, 3, 4, 5, 6, 7, 8};

    /* renamed from: A */
    public static void m7036A(int i, String str, String str2) {
        Log.m3027w(str2, str + i);
    }

    /* renamed from: B */
    public static void m7037B(zzio zzioVar, String str) {
        zzioVar.zzaW().zzk().zza(str);
    }

    /* renamed from: C */
    public static String m7038C(String str, String str2) {
        return str + str2;
    }

    /* renamed from: D */
    public static void m7039D(zzio zzioVar, String str) {
        zzioVar.zzaW().zze().zza(str);
    }

    /* renamed from: E */
    public static /* synthetic */ String m7040E(int i) {
        switch (i) {
            case 1:
                return "UNKNOWN";
            case 2:
                return "HORIZONTAL_DIMENSION";
            case 3:
                return "VERTICAL_DIMENSION";
            case 4:
                return "LEFT";
            case 5:
                return "RIGHT";
            case 6:
                return "TOP";
            case 7:
                return "BOTTOM";
            case 8:
                return "BASELINE";
            default:
                throw null;
        }
    }

    /* renamed from: F */
    public static /* synthetic */ int m7041F(int i) {
        if (i != 0) {
            return i - 1;
        }
        throw null;
    }

    /* renamed from: G */
    public static /* synthetic */ String m7042G(int i) {
        switch (i) {
            case 1:
                return "INITIALIZE";
            case 2:
                return "RESOURCE_CACHE";
            case 3:
                return "DATA_CACHE";
            case 4:
                return "SOURCE";
            case 5:
                return "ENCODE";
            case 6:
                return "FINISHED";
            default:
                return "null";
        }
    }

    /* renamed from: H */
    public static /* synthetic */ String m7043H(int i) {
        switch (i) {
            case 1:
                return "UNKNOWN";
            case 2:
                return "HORIZONTAL_DIMENSION";
            case 3:
                return "VERTICAL_DIMENSION";
            case 4:
                return "LEFT";
            case 5:
                return "RIGHT";
            case 6:
                return "TOP";
            case 7:
                return "BOTTOM";
            case 8:
                return "BASELINE";
            default:
                return "null";
        }
    }

    /* renamed from: I */
    public static /* synthetic */ int[] m7044I(int i) {
        int[] iArr = new int[i];
        System.arraycopy(f25609a, 0, iArr, 0, i);
        return iArr;
    }

    /* renamed from: a */
    public static void m7045a(j92 j92Var, j92 j92Var2) {
        j92Var2.mo54i(j92Var.mo57l());
        j92 mo50d = j92Var.mo50d();
        Logger logger = ConcurrentMapC0840e.f14584w;
        mo50d.mo60o(j92Var2);
        j92Var2.mo55j(mo50d);
        j92 mo59n = j92Var.mo59n();
        j92Var2.mo60o(mo59n);
        mo59n.mo55j(j92Var2);
        pb1 pb1Var = pb1.f25104a;
        j92Var.mo60o(pb1Var);
        j92Var.mo55j(pb1Var);
    }

    /* renamed from: b */
    public static j92 m7046b(int i, C0839d c0839d, j92 j92Var, j92 j92Var2) {
        return m7049e(i, c0839d, j92Var.getKey(), j92Var.mo2222c(), j92Var2);
    }

    /* renamed from: c */
    public static void m7047c(j92 j92Var, j92 j92Var2) {
        j92Var2.mo58m(j92Var.mo51f());
        j92 mo61p = j92Var.mo61p();
        Logger logger = ConcurrentMapC0840e.f14584w;
        mo61p.mo53h(j92Var2);
        j92Var2.mo52g(mo61p);
        j92 mo56k = j92Var.mo56k();
        j92Var2.mo53h(mo56k);
        mo56k.mo52g(j92Var2);
        pb1 pb1Var = pb1.f25104a;
        j92Var.mo53h(pb1Var);
        j92Var.mo52g(pb1Var);
    }

    /* renamed from: d */
    public static j92 m7048d(int i, C0839d c0839d, j92 j92Var, j92 j92Var2) {
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 6) {
                        if (i != 7) {
                            if (i != 8) {
                                return m7046b(i, c0839d, j92Var, j92Var2);
                            }
                            j92 m7046b = m7046b(8, c0839d, j92Var, j92Var2);
                            m7045a(j92Var, m7046b);
                            m7047c(j92Var, m7046b);
                            return m7046b;
                        }
                        j92 m7046b2 = m7046b(7, c0839d, j92Var, j92Var2);
                        m7047c(j92Var, m7046b2);
                        return m7046b2;
                    }
                    j92 m7046b3 = m7046b(6, c0839d, j92Var, j92Var2);
                    m7045a(j92Var, m7046b3);
                    return m7046b3;
                }
                j92 m7046b4 = m7046b(4, c0839d, j92Var, j92Var2);
                m7045a(j92Var, m7046b4);
                m7047c(j92Var, m7046b4);
                return m7046b4;
            }
            j92 m7046b5 = m7046b(3, c0839d, j92Var, j92Var2);
            m7047c(j92Var, m7046b5);
            return m7046b5;
        }
        j92 m7046b6 = m7046b(2, c0839d, j92Var, j92Var2);
        m7045a(j92Var, m7046b6);
        return m7046b6;
    }

    /* JADX WARN: Type inference failed for: r8v4, types: [j92, xb1, wb1] */
    /* JADX WARN: Type inference failed for: r8v8, types: [cc1, bc1, j92] */
    /* renamed from: e */
    public static j92 m7049e(int i, C0839d c0839d, Object obj, int i2, j92 j92Var) {
        switch (i) {
            case 1:
                return new xb1(obj, i2, j92Var);
            case 2:
                vb1 vb1Var = new vb1(obj, i2, j92Var, 0);
                vb1Var.f27729f = Long.MAX_VALUE;
                Logger logger = ConcurrentMapC0840e.f14584w;
                pb1 pb1Var = pb1.f25104a;
                vb1Var.f27730g = pb1Var;
                vb1Var.f27731h = pb1Var;
                return vb1Var;
            case 3:
                vb1 vb1Var2 = new vb1(obj, i2, j92Var, 1);
                vb1Var2.f27729f = Long.MAX_VALUE;
                Logger logger2 = ConcurrentMapC0840e.f14584w;
                pb1 pb1Var2 = pb1.f25104a;
                vb1Var2.f27730g = pb1Var2;
                vb1Var2.f27731h = pb1Var2;
                return vb1Var2;
            case 4:
                ?? xb1Var = new xb1(obj, i2, j92Var);
                xb1Var.f28126e = Long.MAX_VALUE;
                Logger logger3 = ConcurrentMapC0840e.f14584w;
                pb1 pb1Var3 = pb1.f25104a;
                xb1Var.f28127f = pb1Var3;
                xb1Var.f28128g = pb1Var3;
                xb1Var.f28129h = Long.MAX_VALUE;
                xb1Var.f28130i = pb1Var3;
                xb1Var.f28131j = pb1Var3;
                return xb1Var;
            case 5:
                return new cc1(i2, j92Var, obj, c0839d.f14577h);
            case 6:
                ac1 ac1Var = new ac1(c0839d.f14577h, obj, i2, j92Var, 0);
                ac1Var.f120e = Long.MAX_VALUE;
                Logger logger4 = ConcurrentMapC0840e.f14584w;
                pb1 pb1Var4 = pb1.f25104a;
                ac1Var.f121f = pb1Var4;
                ac1Var.f122g = pb1Var4;
                return ac1Var;
            case 7:
                ac1 ac1Var2 = new ac1(c0839d.f14577h, obj, i2, j92Var, 1);
                ac1Var2.f120e = Long.MAX_VALUE;
                Logger logger5 = ConcurrentMapC0840e.f14584w;
                pb1 pb1Var5 = pb1.f25104a;
                ac1Var2.f121f = pb1Var5;
                ac1Var2.f122g = pb1Var5;
                return ac1Var2;
            default:
                ?? cc1Var = new cc1(i2, j92Var, obj, c0839d.f14577h);
                cc1Var.f7963d = Long.MAX_VALUE;
                Logger logger6 = ConcurrentMapC0840e.f14584w;
                pb1 pb1Var6 = pb1.f25104a;
                cc1Var.f7964e = pb1Var6;
                cc1Var.f7965f = pb1Var6;
                cc1Var.f7966g = Long.MAX_VALUE;
                cc1Var.f7967h = pb1Var6;
                cc1Var.f7968i = pb1Var6;
                return cc1Var;
        }
    }

    /* renamed from: f */
    public static /* synthetic */ long m7050f(int i) {
        if (i == 1) {
            return 0L;
        }
        if (i == 2) {
            return 1L;
        }
        if (i == 3) {
            return 2L;
        }
        if (i == 4) {
            return 3L;
        }
        if (i == 5) {
            return 4L;
        }
        throw null;
    }

    /* renamed from: g */
    public static float m7051g(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    /* renamed from: h */
    public static int m7052h(int i, String str) {
        return String.valueOf(str).length() + i;
    }

    /* renamed from: i */
    public static Object m7053i(ArrayList arrayList, int i) {
        return arrayList.get(arrayList.size() - i);
    }

    /* renamed from: j */
    public static String m7054j(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: k */
    public static String m7055k(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb.toString();
    }

    /* renamed from: l */
    public static String m7056l(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.m1725x());
        return sb.toString();
    }

    /* renamed from: m */
    public static String m7057m(String str, String str2) {
        return str + str2;
    }

    /* renamed from: n */
    public static String m7058n(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    /* renamed from: o */
    public static String m7059o(String str, String str2, String str3, int i) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    /* renamed from: p */
    public static String m7060p(StringBuilder sb, char c, String str) {
        sb.append(c);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, str);
        return sb2;
    }

    /* renamed from: q */
    public static String m7061q(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: r */
    public static StringBuilder m7062r(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb;
    }

    /* renamed from: s */
    public static StringBuilder m7063s(CharSequence charSequence, String str, Function2 function2, String str2, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, str);
        Intrinsics.checkNotNullParameter(function2, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        return sb;
    }

    /* renamed from: t */
    public static StringBuilder m7064t(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    /* renamed from: u */
    public static StringBuilder m7065u(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    /* renamed from: v */
    public static ArrayList m7066v(LinkedHashMap linkedHashMap, Object obj) {
        ArrayList arrayList = new ArrayList();
        linkedHashMap.put(obj, arrayList);
        return arrayList;
    }

    /* renamed from: w */
    public static ArrayList m7067w(Map map, Object obj) {
        ArrayList arrayList = new ArrayList();
        map.put(obj, arrayList);
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.IntIterator] */
    /* renamed from: x */
    public static IntIterator m7068x(int i, int i2) {
        return new IntRange(i, i2).iterator();
    }

    /* renamed from: y */
    public static void m7069y(int i, int i2, Function1 function1) {
        function1.invoke(Integer.valueOf(i + i2));
    }

    /* renamed from: z */
    public static void m7070z(int i, Canvas canvas, int i2, int i3) {
        InlineMarker.finallyStart(i);
        canvas.restoreToCount(i2);
        InlineMarker.finallyEnd(i3);
    }
}
