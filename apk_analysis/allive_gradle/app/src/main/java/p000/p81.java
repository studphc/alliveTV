package p000;

import java.util.Objects;

/* loaded from: classes.dex */
public final class p81 extends k21 implements s81 {

    /* renamed from: c */
    public final int f25061c;

    /* renamed from: d */
    public p81 f25062d;

    /* renamed from: e */
    public s81 f25063e;

    /* renamed from: f */
    public s81 f25064f;

    /* renamed from: g */
    public p81 f25065g;

    /* renamed from: h */
    public p81 f25066h;

    public p81(Object obj, Object obj2, int i, p81 p81Var) {
        super(obj, obj2);
        this.f25061c = i;
        this.f25062d = p81Var;
    }

    @Override // p000.s81
    /* renamed from: a */
    public final void mo6887a(s81 s81Var) {
        this.f25063e = s81Var;
    }

    @Override // p000.s81
    /* renamed from: b */
    public final s81 mo6888b() {
        s81 s81Var = this.f25064f;
        Objects.requireNonNull(s81Var);
        return s81Var;
    }

    @Override // p000.s81
    /* renamed from: c */
    public final void mo6889c(s81 s81Var) {
        this.f25064f = s81Var;
    }

    /* renamed from: d */
    public final boolean m6890d(int i, Object obj) {
        if (this.f25061c == i && com.google.common.base.Objects.equal(this.f20726b, obj)) {
            return true;
        }
        return false;
    }
}
