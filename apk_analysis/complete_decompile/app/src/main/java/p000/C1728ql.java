package p000;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;

/* renamed from: ql */
/* loaded from: classes.dex */
public final class C1728ql {

    /* renamed from: A */
    public static final int[] f25640A;

    /* renamed from: B */
    public static final boolean[] f25641B;

    /* renamed from: C */
    public static final int[] f25642C;

    /* renamed from: D */
    public static final int[] f25643D;

    /* renamed from: E */
    public static final int[] f25644E;

    /* renamed from: F */
    public static final int[] f25645F;

    /* renamed from: w */
    public static final int f25646w = m7073c(2, 2, 2, 0);

    /* renamed from: x */
    public static final int f25647x;

    /* renamed from: y */
    public static final int[] f25648y;

    /* renamed from: z */
    public static final int[] f25649z;

    /* renamed from: a */
    public final ArrayList f25650a = new ArrayList();

    /* renamed from: b */
    public final SpannableStringBuilder f25651b = new SpannableStringBuilder();

    /* renamed from: c */
    public boolean f25652c;

    /* renamed from: d */
    public boolean f25653d;

    /* renamed from: e */
    public int f25654e;

    /* renamed from: f */
    public boolean f25655f;

    /* renamed from: g */
    public int f25656g;

    /* renamed from: h */
    public int f25657h;

    /* renamed from: i */
    public int f25658i;

    /* renamed from: j */
    public int f25659j;

    /* renamed from: k */
    public boolean f25660k;

    /* renamed from: l */
    public int f25661l;

    /* renamed from: m */
    public int f25662m;

    /* renamed from: n */
    public int f25663n;

    /* renamed from: o */
    public int f25664o;

    /* renamed from: p */
    public int f25665p;

    /* renamed from: q */
    public int f25666q;

    /* renamed from: r */
    public int f25667r;

    /* renamed from: s */
    public int f25668s;

    /* renamed from: t */
    public int f25669t;

    /* renamed from: u */
    public int f25670u;

    /* renamed from: v */
    public int f25671v;

    static {
        int m7073c = m7073c(0, 0, 0, 0);
        f25647x = m7073c;
        int m7073c2 = m7073c(0, 0, 0, 3);
        f25648y = new int[]{0, 0, 0, 0, 0, 2, 0};
        f25649z = new int[]{0, 0, 0, 0, 0, 0, 2};
        f25640A = new int[]{3, 3, 3, 3, 3, 3, 1};
        f25641B = new boolean[]{false, false, false, true, true, true, false};
        f25642C = new int[]{m7073c, m7073c2, m7073c, m7073c, m7073c2, m7073c, m7073c};
        f25643D = new int[]{0, 1, 2, 3, 4, 3, 4};
        f25644E = new int[]{0, 0, 0, 0, 0, 3, 3};
        f25645F = new int[]{m7073c, m7073c, m7073c, m7073c, m7073c, m7073c2, m7073c2};
    }

    public C1728ql() {
        m7076d();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0025  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m7073c(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8 = 0;
        Assertions.checkIndex(i, 0, 4);
        Assertions.checkIndex(i2, 0, 4);
        Assertions.checkIndex(i3, 0, 4);
        Assertions.checkIndex(i4, 0, 4);
        if (i4 != 0 && i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    i5 = 0;
                }
            } else {
                i5 = 127;
            }
            if (i <= 1) {
                i6 = 255;
            } else {
                i6 = 0;
            }
            if (i2 <= 1) {
                i7 = 255;
            } else {
                i7 = 0;
            }
            if (i3 > 1) {
                i8 = 255;
            }
            return Color.argb(i5, i6, i7, i8);
        }
        i5 = 255;
        if (i <= 1) {
        }
        if (i2 <= 1) {
        }
        if (i3 > 1) {
        }
        return Color.argb(i5, i6, i7, i8);
    }

    /* renamed from: a */
    public final void m7074a(char c) {
        SpannableStringBuilder spannableStringBuilder = this.f25651b;
        if (c == '\n') {
            ArrayList arrayList = this.f25650a;
            arrayList.add(m7075b());
            spannableStringBuilder.clear();
            if (this.f25665p != -1) {
                this.f25665p = 0;
            }
            if (this.f25666q != -1) {
                this.f25666q = 0;
            }
            if (this.f25667r != -1) {
                this.f25667r = 0;
            }
            if (this.f25669t != -1) {
                this.f25669t = 0;
            }
            while (true) {
                if ((this.f25660k && arrayList.size() >= this.f25659j) || arrayList.size() >= 15) {
                    arrayList.remove(0);
                } else {
                    return;
                }
            }
        } else {
            spannableStringBuilder.append(c);
        }
    }

    /* renamed from: b */
    public final SpannableString m7075b() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f25651b);
        int length = spannableStringBuilder.length();
        if (length > 0) {
            if (this.f25665p != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(2), this.f25665p, length, 33);
            }
            if (this.f25666q != -1) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.f25666q, length, 33);
            }
            if (this.f25667r != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f25668s), this.f25667r, length, 33);
            }
            if (this.f25669t != -1) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f25670u), this.f25669t, length, 33);
            }
        }
        return new SpannableString(spannableStringBuilder);
    }

    /* renamed from: d */
    public final void m7076d() {
        this.f25650a.clear();
        this.f25651b.clear();
        this.f25665p = -1;
        this.f25666q = -1;
        this.f25667r = -1;
        this.f25669t = -1;
        this.f25671v = 0;
        this.f25652c = false;
        this.f25653d = false;
        this.f25654e = 4;
        this.f25655f = false;
        this.f25656g = 0;
        this.f25657h = 0;
        this.f25658i = 0;
        this.f25659j = 15;
        this.f25660k = true;
        this.f25661l = 0;
        this.f25662m = 0;
        this.f25663n = 0;
        int i = f25647x;
        this.f25664o = i;
        this.f25668s = f25646w;
        this.f25670u = i;
    }

    /* renamed from: e */
    public final void m7077e(boolean z, boolean z2) {
        int i = this.f25665p;
        SpannableStringBuilder spannableStringBuilder = this.f25651b;
        if (i != -1) {
            if (!z) {
                spannableStringBuilder.setSpan(new StyleSpan(2), this.f25665p, spannableStringBuilder.length(), 33);
                this.f25665p = -1;
            }
        } else if (z) {
            this.f25665p = spannableStringBuilder.length();
        }
        if (this.f25666q != -1) {
            if (!z2) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.f25666q, spannableStringBuilder.length(), 33);
                this.f25666q = -1;
                return;
            }
            return;
        }
        if (z2) {
            this.f25666q = spannableStringBuilder.length();
        }
    }

    /* renamed from: f */
    public final void m7078f(int i, int i2) {
        int i3 = this.f25667r;
        SpannableStringBuilder spannableStringBuilder = this.f25651b;
        if (i3 != -1 && this.f25668s != i) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f25668s), this.f25667r, spannableStringBuilder.length(), 33);
        }
        if (i != f25646w) {
            this.f25667r = spannableStringBuilder.length();
            this.f25668s = i;
        }
        if (this.f25669t != -1 && this.f25670u != i2) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(this.f25670u), this.f25669t, spannableStringBuilder.length(), 33);
        }
        if (i2 != f25647x) {
            this.f25669t = spannableStringBuilder.length();
            this.f25670u = i2;
        }
    }
}
