package p000;

/* loaded from: classes.dex */
public final class ex0 implements Appendable {

    /* renamed from: a */
    public final Appendable f17015a;

    /* renamed from: b */
    public boolean f17016b = true;

    public ex0(Appendable appendable) {
        this.f17015a = appendable;
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c) {
        boolean z = this.f17016b;
        Appendable appendable = this.f17015a;
        if (z) {
            this.f17016b = false;
            appendable.append("  ");
        }
        this.f17016b = c == '\n';
        appendable.append(c);
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        append(charSequence, 0, charSequence.length());
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            charSequence = "";
        }
        boolean z = this.f17016b;
        Appendable appendable = this.f17015a;
        boolean z2 = false;
        if (z) {
            this.f17016b = false;
            appendable.append("  ");
        }
        if (charSequence.length() > 0 && charSequence.charAt(i2 - 1) == '\n') {
            z2 = true;
        }
        this.f17016b = z2;
        appendable.append(charSequence, i, i2);
        return this;
    }
}
