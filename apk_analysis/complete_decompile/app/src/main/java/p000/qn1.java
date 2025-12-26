package p000;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class qn1 implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final String f25698a;

    /* renamed from: b */
    public final int f25699b;

    /* renamed from: c */
    public final String f25700c;

    public qn1(String str, int i, String str2) {
        this.f25698a = str;
        this.f25699b = i;
        this.f25700c = str2;
    }

    private Object readResolve() {
        return new rn1(this.f25698a, this.f25699b, this.f25700c);
    }
}
