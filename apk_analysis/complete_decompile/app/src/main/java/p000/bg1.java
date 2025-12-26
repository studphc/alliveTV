package p000;

import com.google.common.base.Preconditions;

/* loaded from: classes2.dex */
public final class bg1 extends ue1 {

    /* renamed from: c */
    public volatile transient ag1 f8003c;

    /* renamed from: d */
    public volatile transient ag1 f8004d;

    @Override // p000.ue1
    /* renamed from: a */
    public final void mo2093a() {
        this.f27240b = null;
        this.f8003c = null;
        this.f8004d = null;
    }

    @Override // p000.ue1
    /* renamed from: c */
    public final Object mo2094c(Object obj) {
        Preconditions.checkNotNull(obj);
        Object mo2095d = mo2095d(obj);
        if (mo2095d != null) {
            return mo2095d;
        }
        Preconditions.checkNotNull(obj);
        Object obj2 = this.f27239a.get(obj);
        if (obj2 != null) {
            ag1 ag1Var = new ag1(obj, obj2);
            this.f8004d = this.f8003c;
            this.f8003c = ag1Var;
        }
        return obj2;
    }

    @Override // p000.ue1
    /* renamed from: d */
    public final Object mo2095d(Object obj) {
        Object mo2095d = super.mo2095d(obj);
        if (mo2095d != null) {
            return mo2095d;
        }
        ag1 ag1Var = this.f8003c;
        if (ag1Var != null && ag1Var.f180a == obj) {
            return ag1Var.f181b;
        }
        ag1 ag1Var2 = this.f8004d;
        if (ag1Var2 != null && ag1Var2.f180a == obj) {
            this.f8004d = this.f8003c;
            this.f8003c = ag1Var2;
            return ag1Var2.f181b;
        }
        return null;
    }
}
