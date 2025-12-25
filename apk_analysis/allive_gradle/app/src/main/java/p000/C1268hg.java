package p000;

/* renamed from: hg */
/* loaded from: classes.dex */
public final class C1268hg {

    /* renamed from: e */
    public static final byte[] f18047e = new byte[1792];

    /* renamed from: a */
    public final CharSequence f18048a;

    /* renamed from: b */
    public final int f18049b;

    /* renamed from: c */
    public int f18050c;

    /* renamed from: d */
    public char f18051d;

    static {
        for (int i = 0; i < 1792; i++) {
            f18047e[i] = Character.getDirectionality(i);
        }
    }

    public C1268hg(CharSequence charSequence) {
        this.f18048a = charSequence;
        this.f18049b = charSequence.length();
    }

    /* renamed from: a */
    public final byte m5086a() {
        int i = this.f18050c - 1;
        CharSequence charSequence = this.f18048a;
        char charAt = charSequence.charAt(i);
        this.f18051d = charAt;
        if (Character.isLowSurrogate(charAt)) {
            int codePointBefore = Character.codePointBefore(charSequence, this.f18050c);
            this.f18050c -= Character.charCount(codePointBefore);
            return Character.getDirectionality(codePointBefore);
        }
        this.f18050c--;
        char c = this.f18051d;
        if (c < 1792) {
            return f18047e[c];
        }
        return Character.getDirectionality(c);
    }
}
