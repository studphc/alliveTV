package p000;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;

/* renamed from: ol */
/* loaded from: classes.dex */
public final class C1641ol {

    /* renamed from: a */
    public final ArrayList f24799a;

    /* renamed from: b */
    public final ArrayList f24800b;

    /* renamed from: c */
    public final StringBuilder f24801c;

    /* renamed from: d */
    public int f24802d;

    /* renamed from: e */
    public int f24803e;

    /* renamed from: f */
    public int f24804f;

    /* renamed from: g */
    public int f24805g;

    /* renamed from: h */
    public int f24806h;

    public C1641ol(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        this.f24799a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f24800b = arrayList2;
        StringBuilder sb = new StringBuilder();
        this.f24801c = sb;
        this.f24805g = i;
        arrayList.clear();
        arrayList2.clear();
        sb.setLength(0);
        this.f24802d = 15;
        this.f24803e = 0;
        this.f24804f = 0;
        this.f24806h = i2;
    }

    /* renamed from: a */
    public final void m6682a(char c) {
        StringBuilder sb = this.f24801c;
        if (sb.length() < 32) {
            sb.append(c);
        }
    }

    /* renamed from: b */
    public final void m6683b() {
        StringBuilder sb = this.f24801c;
        int length = sb.length();
        if (length > 0) {
            sb.delete(length - 1, length);
            ArrayList arrayList = this.f24799a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                C1589nl c1589nl = (C1589nl) arrayList.get(size);
                int i = c1589nl.f23394c;
                if (i == length) {
                    c1589nl.f23394c = i - 1;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    public final Cue m6684c(int i) {
        float f;
        int i2 = this.f24803e + this.f24804f;
        int i3 = 32 - i2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f24800b;
            if (i4 >= arrayList.size()) {
                break;
            }
            spannableStringBuilder.append(Util.truncateAscii((CharSequence) arrayList.get(i4), i3));
            spannableStringBuilder.append('\n');
            i4++;
        }
        spannableStringBuilder.append(Util.truncateAscii(m6685d(), i3));
        if (spannableStringBuilder.length() == 0) {
            return null;
        }
        int length = i3 - spannableStringBuilder.length();
        int i5 = i2 - length;
        if (i == Integer.MIN_VALUE) {
            if (this.f24805g == 2 && (Math.abs(i5) < 3 || length < 0)) {
                i = 1;
            } else if (this.f24805g == 2 && i5 > 0) {
                i = 2;
            } else {
                i = 0;
            }
        }
        if (i != 1) {
            if (i == 2) {
                i2 = 32 - length;
            }
            f = ((i2 / 32.0f) * 0.8f) + 0.1f;
        } else {
            f = 0.5f;
        }
        int i6 = this.f24802d;
        if (i6 > 7) {
            i6 -= 17;
        } else if (this.f24805g == 1) {
            i6 -= this.f24806h - 1;
        }
        return new Cue.Builder().setText(spannableStringBuilder).setTextAlignment(Layout.Alignment.ALIGN_NORMAL).setLine(i6, 1).setPosition(f).setPositionAnchor(i).build();
    }

    /* renamed from: d */
    public final SpannableString m6685d() {
        int i;
        boolean z;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f24801c);
        int length = spannableStringBuilder.length();
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = 0;
        int i7 = 0;
        boolean z2 = false;
        while (true) {
            ArrayList arrayList = this.f24799a;
            if (i6 >= arrayList.size()) {
                break;
            }
            C1589nl c1589nl = (C1589nl) arrayList.get(i6);
            boolean z3 = c1589nl.f23393b;
            int i8 = c1589nl.f23392a;
            if (i8 != 8) {
                if (i8 == 7) {
                    z = true;
                } else {
                    z = false;
                }
                if (i8 != 7) {
                    i5 = Cea608Decoder.f11769A[i8];
                }
                z2 = z;
            }
            int i9 = c1589nl.f23394c;
            i6++;
            if (i6 < arrayList.size()) {
                i = ((C1589nl) arrayList.get(i6)).f23394c;
            } else {
                i = length;
            }
            if (i9 != i) {
                if (i2 != -1 && !z3) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i9, 33);
                    i2 = -1;
                } else if (i2 == -1 && z3) {
                    i2 = i9;
                }
                if (i3 != -1 && !z2) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), i3, i9, 33);
                    i3 = -1;
                } else if (i3 == -1 && z2) {
                    i3 = i9;
                }
                if (i5 != i4) {
                    if (i4 != -1) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(i4), i7, i9, 33);
                    }
                    i4 = i5;
                    i7 = i9;
                }
            }
        }
        if (i2 != -1 && i2 != length) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i2, length, 33);
        }
        if (i3 != -1 && i3 != length) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i3, length, 33);
        }
        if (i7 != length && i4 != -1) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i4), i7, length, 33);
        }
        return new SpannableString(spannableStringBuilder);
    }

    /* renamed from: e */
    public final boolean m6686e() {
        if (this.f24799a.isEmpty() && this.f24800b.isEmpty() && this.f24801c.length() == 0) {
            return true;
        }
        return false;
    }
}
