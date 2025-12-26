package p000;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Pair;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.span.HorizontalTextInVerticalContextSpan;
import com.google.android.exoplayer2.text.span.RubySpan;
import com.google.android.exoplayer2.text.span.SpanUtil;
import com.google.android.exoplayer2.text.span.TextEmphasisSpan;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: classes.dex */
public final class dx2 {

    /* renamed from: a */
    public final String f16589a;

    /* renamed from: b */
    public final String f16590b;

    /* renamed from: c */
    public final boolean f16591c;

    /* renamed from: d */
    public final long f16592d;

    /* renamed from: e */
    public final long f16593e;

    /* renamed from: f */
    public final fx2 f16594f;

    /* renamed from: g */
    public final String[] f16595g;

    /* renamed from: h */
    public final String f16596h;

    /* renamed from: i */
    public final String f16597i;

    /* renamed from: j */
    public final dx2 f16598j;

    /* renamed from: k */
    public final HashMap f16599k;

    /* renamed from: l */
    public final HashMap f16600l;

    /* renamed from: m */
    public ArrayList f16601m;

    public dx2(String str, String str2, long j, long j2, fx2 fx2Var, String[] strArr, String str3, String str4, dx2 dx2Var) {
        boolean z;
        this.f16589a = str;
        this.f16590b = str2;
        this.f16597i = str4;
        this.f16594f = fx2Var;
        this.f16595g = strArr;
        if (str2 != null) {
            z = true;
        } else {
            z = false;
        }
        this.f16591c = z;
        this.f16592d = j;
        this.f16593e = j2;
        this.f16596h = (String) Assertions.checkNotNull(str3);
        this.f16598j = dx2Var;
        this.f16599k = new HashMap();
        this.f16600l = new HashMap();
    }

    /* renamed from: a */
    public static dx2 m4633a(String str) {
        return new dx2(null, str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), C0643C.TIME_UNSET, C0643C.TIME_UNSET, null, null, "", null, null);
    }

    /* renamed from: e */
    public static SpannableStringBuilder m4634e(String str, TreeMap treeMap) {
        if (!treeMap.containsKey(str)) {
            Cue.Builder builder = new Cue.Builder();
            builder.setText(new SpannableStringBuilder());
            treeMap.put(str, builder);
        }
        return (SpannableStringBuilder) Assertions.checkNotNull(((Cue.Builder) treeMap.get(str)).getText());
    }

    /* renamed from: b */
    public final dx2 m4635b(int i) {
        ArrayList arrayList = this.f16601m;
        if (arrayList != null) {
            return (dx2) arrayList.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    /* renamed from: c */
    public final int m4636c() {
        ArrayList arrayList = this.f16601m;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    /* renamed from: d */
    public final void m4637d(TreeSet treeSet, boolean z) {
        boolean z2;
        String str = this.f16589a;
        boolean equals = "p".equals(str);
        boolean equals2 = "div".equals(str);
        if (z || equals || (equals2 && this.f16597i != null)) {
            long j = this.f16592d;
            if (j != C0643C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.f16593e;
            if (j2 != C0643C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.f16601m == null) {
            return;
        }
        for (int i = 0; i < this.f16601m.size(); i++) {
            dx2 dx2Var = (dx2) this.f16601m.get(i);
            if (!z && !equals) {
                z2 = false;
            } else {
                z2 = true;
            }
            dx2Var.m4637d(treeSet, z2);
        }
    }

    /* renamed from: f */
    public final boolean m4638f(long j) {
        long j2 = this.f16592d;
        long j3 = this.f16593e;
        if ((j2 == C0643C.TIME_UNSET && j3 == C0643C.TIME_UNSET) || ((j2 <= j && j3 == C0643C.TIME_UNSET) || ((j2 == C0643C.TIME_UNSET && j < j3) || (j2 <= j && j < j3)))) {
            return true;
        }
        return false;
    }

    /* renamed from: g */
    public final void m4639g(long j, String str, ArrayList arrayList) {
        String str2;
        String str3 = this.f16596h;
        if (!"".equals(str3)) {
            str = str3;
        }
        if (m4638f(j) && "div".equals(this.f16589a) && (str2 = this.f16597i) != null) {
            arrayList.add(new Pair(str, str2));
            return;
        }
        for (int i = 0; i < m4636c(); i++) {
            m4635b(i).m4639g(j, str, arrayList);
        }
    }

    /* renamed from: h */
    public final void m4640h(long j, Map map, HashMap hashMap, String str, TreeMap treeMap) {
        String str2;
        int i;
        char c;
        char c2;
        int i2;
        int i3;
        dx2 dx2Var;
        int i4;
        fx2 m6849I;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if (!m4638f(j)) {
            return;
        }
        String str3 = this.f16596h;
        if ("".equals(str3)) {
            str2 = str;
        } else {
            str2 = str3;
        }
        for (Map.Entry entry : this.f16600l.entrySet()) {
            String str4 = (String) entry.getKey();
            HashMap hashMap2 = this.f16599k;
            if (hashMap2.containsKey(str4)) {
                i = ((Integer) hashMap2.get(str4)).intValue();
            } else {
                i = 0;
            }
            int intValue = ((Integer) entry.getValue()).intValue();
            if (i != intValue) {
                Cue.Builder builder = (Cue.Builder) Assertions.checkNotNull((Cue.Builder) treeMap.get(str4));
                int i10 = ((ex2) Assertions.checkNotNull((ex2) hashMap.get(str2))).f17031j;
                fx2 m6849I2 = p63.m6849I(this.f16594f, this.f16595g, map);
                SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) builder.getText();
                if (spannableStringBuilder == null) {
                    spannableStringBuilder = new SpannableStringBuilder();
                    builder.setText(spannableStringBuilder);
                }
                if (m6849I2 != null) {
                    int i11 = m6849I2.f17433h;
                    int i12 = 1;
                    if (i11 == -1 && m6849I2.f17434i == -1) {
                        i2 = -1;
                    } else {
                        if (i11 == 1) {
                            c = 1;
                        } else {
                            c = 0;
                        }
                        if (m6849I2.f17434i == 1) {
                            c2 = 2;
                        } else {
                            c2 = 0;
                        }
                        i2 = c | c2;
                    }
                    if (i2 != -1) {
                        int i13 = m6849I2.f17433h;
                        if (i13 == -1) {
                            if (m6849I2.f17434i == -1) {
                                i9 = -1;
                                i12 = 1;
                                StyleSpan styleSpan = new StyleSpan(i9);
                                i3 = 33;
                                spannableStringBuilder.setSpan(styleSpan, i, intValue, 33);
                            } else {
                                i12 = 1;
                            }
                        }
                        if (i13 == i12) {
                            i7 = i12;
                        } else {
                            i7 = 0;
                        }
                        if (m6849I2.f17434i == i12) {
                            i8 = 2;
                        } else {
                            i8 = 0;
                        }
                        i9 = i7 | i8;
                        StyleSpan styleSpan2 = new StyleSpan(i9);
                        i3 = 33;
                        spannableStringBuilder.setSpan(styleSpan2, i, intValue, 33);
                    } else {
                        i3 = 33;
                    }
                    if (m6849I2.f17431f == i12) {
                        spannableStringBuilder.setSpan(new StrikethroughSpan(), i, intValue, i3);
                    }
                    if (m6849I2.f17432g == i12) {
                        spannableStringBuilder.setSpan(new UnderlineSpan(), i, intValue, i3);
                    }
                    if (m6849I2.f17428c) {
                        if (m6849I2.f17428c) {
                            SpanUtil.addOrReplaceSpan(spannableStringBuilder, new ForegroundColorSpan(m6849I2.f17427b), i, intValue, 33);
                        } else {
                            throw new IllegalStateException("Font color has not been defined.");
                        }
                    }
                    if (m6849I2.f17430e) {
                        if (m6849I2.f17430e) {
                            SpanUtil.addOrReplaceSpan(spannableStringBuilder, new BackgroundColorSpan(m6849I2.f17429d), i, intValue, 33);
                        } else {
                            throw new IllegalStateException("Background color has not been defined.");
                        }
                    }
                    if (m6849I2.f17426a != null) {
                        SpanUtil.addOrReplaceSpan(spannableStringBuilder, new TypefaceSpan(m6849I2.f17426a), i, intValue, 33);
                    }
                    vs2 vs2Var = m6849I2.f17443r;
                    if (vs2Var != null) {
                        vs2 vs2Var2 = (vs2) Assertions.checkNotNull(vs2Var);
                        int i14 = vs2Var2.f27948a;
                        if (i14 == -1) {
                            if (i10 != 2 && i10 != 1) {
                                i6 = 1;
                            } else {
                                i6 = 3;
                            }
                            i14 = i6;
                            i5 = 1;
                        } else {
                            i5 = vs2Var2.f27949b;
                        }
                        int i15 = vs2Var2.f27950c;
                        if (i15 == -2) {
                            i15 = 1;
                        }
                        SpanUtil.addOrReplaceSpan(spannableStringBuilder, new TextEmphasisSpan(i14, i5, i15), i, intValue, 33);
                    }
                    int i16 = m6849I2.f17438m;
                    if (i16 != 2) {
                        if (i16 == 3 || i16 == 4) {
                            spannableStringBuilder.setSpan(new Object(), i, intValue, 33);
                        }
                    } else {
                        dx2 dx2Var2 = this.f16598j;
                        while (true) {
                            if (dx2Var2 != null) {
                                fx2 m6849I3 = p63.m6849I(dx2Var2.f16594f, dx2Var2.f16595g, map);
                                if (m6849I3 != null && m6849I3.f17438m == 1) {
                                    break;
                                } else {
                                    dx2Var2 = dx2Var2.f16598j;
                                }
                            } else {
                                dx2Var2 = null;
                                break;
                            }
                        }
                        if (dx2Var2 != null) {
                            ArrayDeque arrayDeque = new ArrayDeque();
                            arrayDeque.push(dx2Var2);
                            while (true) {
                                if (!arrayDeque.isEmpty()) {
                                    dx2 dx2Var3 = (dx2) arrayDeque.pop();
                                    fx2 m6849I4 = p63.m6849I(dx2Var3.f16594f, dx2Var3.f16595g, map);
                                    if (m6849I4 != null && m6849I4.f17438m == 3) {
                                        dx2Var = dx2Var3;
                                        break;
                                    }
                                    for (int m4636c = dx2Var3.m4636c() - 1; m4636c >= 0; m4636c--) {
                                        arrayDeque.push(dx2Var3.m4635b(m4636c));
                                    }
                                } else {
                                    dx2Var = null;
                                    break;
                                }
                            }
                            if (dx2Var != null) {
                                if (dx2Var.m4636c() == 1 && dx2Var.m4635b(0).f16590b != null) {
                                    String str5 = (String) Util.castNonNull(dx2Var.m4635b(0).f16590b);
                                    fx2 m6849I5 = p63.m6849I(dx2Var.f16594f, dx2Var.f16595g, map);
                                    if (m6849I5 != null) {
                                        i4 = m6849I5.f17439n;
                                    } else {
                                        i4 = -1;
                                    }
                                    if (i4 == -1 && (m6849I = p63.m6849I(dx2Var2.f16594f, dx2Var2.f16595g, map)) != null) {
                                        i4 = m6849I.f17439n;
                                    }
                                    spannableStringBuilder.setSpan(new RubySpan(str5, i4), i, intValue, 33);
                                } else {
                                    Log.m3025i("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                                }
                            }
                        }
                    }
                    if (m6849I2.f17442q == 1) {
                        SpanUtil.addOrReplaceSpan(spannableStringBuilder, new HorizontalTextInVerticalContextSpan(), i, intValue, 33);
                    }
                    int i17 = m6849I2.f17435j;
                    if (i17 != 1) {
                        if (i17 != 2) {
                            if (i17 == 3) {
                                SpanUtil.addOrReplaceSpan(spannableStringBuilder, new RelativeSizeSpan(m6849I2.f17436k / 100.0f), i, intValue, 33);
                            }
                        } else {
                            SpanUtil.addOrReplaceSpan(spannableStringBuilder, new RelativeSizeSpan(m6849I2.f17436k), i, intValue, 33);
                        }
                    } else {
                        SpanUtil.addOrReplaceSpan(spannableStringBuilder, new AbsoluteSizeSpan((int) m6849I2.f17436k, true), i, intValue, 33);
                    }
                    if ("p".equals(this.f16589a)) {
                        float f = m6849I2.f17444s;
                        if (f != Float.MAX_VALUE) {
                            builder.setShearDegrees((f * (-90.0f)) / 100.0f);
                        }
                        Layout.Alignment alignment = m6849I2.f17440o;
                        if (alignment != null) {
                            builder.setTextAlignment(alignment);
                        }
                        Layout.Alignment alignment2 = m6849I2.f17441p;
                        if (alignment2 != null) {
                            builder.setMultiRowAlignment(alignment2);
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        for (int i18 = 0; i18 < m4636c(); i18++) {
            m4635b(i18).m4640h(j, map, hashMap, str2, treeMap);
        }
    }

    /* renamed from: i */
    public final void m4641i(long j, boolean z, String str, TreeMap treeMap) {
        String str2;
        boolean z2;
        HashMap hashMap = this.f16599k;
        hashMap.clear();
        HashMap hashMap2 = this.f16600l;
        hashMap2.clear();
        String str3 = this.f16589a;
        if ("metadata".equals(str3)) {
            return;
        }
        String str4 = this.f16596h;
        if ("".equals(str4)) {
            str2 = str;
        } else {
            str2 = str4;
        }
        if (this.f16591c && z) {
            m4634e(str2, treeMap).append((CharSequence) Assertions.checkNotNull(this.f16590b));
            return;
        }
        if ("br".equals(str3) && z) {
            m4634e(str2, treeMap).append('\n');
            return;
        }
        if (m4638f(j)) {
            for (Map.Entry entry : treeMap.entrySet()) {
                hashMap.put((String) entry.getKey(), Integer.valueOf(((CharSequence) Assertions.checkNotNull(((Cue.Builder) entry.getValue()).getText())).length()));
            }
            boolean equals = "p".equals(str3);
            for (int i = 0; i < m4636c(); i++) {
                dx2 m4635b = m4635b(i);
                if (!z && !equals) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                m4635b.m4641i(j, z2, str2, treeMap);
            }
            if (equals) {
                SpannableStringBuilder m4634e = m4634e(str2, treeMap);
                int length = m4634e.length() - 1;
                while (length >= 0 && m4634e.charAt(length) == ' ') {
                    length--;
                }
                if (length >= 0 && m4634e.charAt(length) != '\n') {
                    m4634e.append('\n');
                }
            }
            for (Map.Entry entry2 : treeMap.entrySet()) {
                hashMap2.put((String) entry2.getKey(), Integer.valueOf(((CharSequence) Assertions.checkNotNull(((Cue.Builder) entry2.getValue()).getText())).length()));
            }
        }
    }
}
