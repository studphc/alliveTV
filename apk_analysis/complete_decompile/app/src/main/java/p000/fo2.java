package p000;

/* loaded from: classes2.dex */
public final class fo2 implements CharSequence {

    /* renamed from: a */
    public char[] f17355a;

    /* renamed from: b */
    public String f17356b;

    @Override // java.lang.CharSequence
    public final char charAt(int i) {
        return this.f17355a[i];
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f17355a.length;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return new String(this.f17355a, i, i2 - i);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        if (this.f17356b == null) {
            this.f17356b = new String(this.f17355a);
        }
        return this.f17356b;
    }
}
