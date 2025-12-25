package p000;

/* loaded from: classes.dex */
public final class ke1 implements n62 {

    /* renamed from: a */
    public final le1 f20835a;

    /* renamed from: b */
    public int f20836b;

    /* renamed from: c */
    public Class f20837c;

    public ke1(le1 le1Var) {
        this.f20835a = le1Var;
    }

    @Override // p000.n62
    /* renamed from: a */
    public final void mo5522a() {
        this.f20835a.m4942b(this);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ke1)) {
            return false;
        }
        ke1 ke1Var = (ke1) obj;
        if (this.f20836b != ke1Var.f20836b || this.f20837c != ke1Var.f20837c) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i;
        int i2 = this.f20836b * 31;
        Class cls = this.f20837c;
        if (cls != null) {
            i = cls.hashCode();
        } else {
            i = 0;
        }
        return i2 + i;
    }

    public final String toString() {
        return "Key{size=" + this.f20836b + "array=" + this.f20837c + '}';
    }
}
