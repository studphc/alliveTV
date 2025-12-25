package p000;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* loaded from: classes.dex */
public final class i03 implements Spannable {

    /* renamed from: a */
    public boolean f18244a = false;

    /* renamed from: b */
    public Spannable f18245b;

    public i03(Spannable spannable) {
        this.f18245b = spannable;
    }

    /* renamed from: a */
    public final void m5146a() {
        wd0 wd0Var;
        Spannable spannable = this.f18245b;
        if (!this.f18244a) {
            if (Build.VERSION.SDK_INT < 28) {
                wd0Var = new wd0(26);
            } else {
                wd0Var = new wd0(26);
            }
            if (wd0Var.mo5029r(spannable)) {
                this.f18245b = new SpannableString(spannable);
            }
        }
        this.f18244a = true;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.f18245b.charAt(i);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        IntStream chars;
        chars = this.f18245b.chars();
        return chars;
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        IntStream codePoints;
        codePoints = this.f18245b.codePoints();
        return codePoints;
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f18245b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f18245b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f18245b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i, int i2, Class cls) {
        return this.f18245b.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f18245b.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i, int i2, Class cls) {
        return this.f18245b.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        m5146a();
        this.f18245b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i, int i2, int i3) {
        m5146a();
        this.f18245b.setSpan(obj, i, i2, i3);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return this.f18245b.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f18245b.toString();
    }
}
