package p000;

import com.google.common.base.Preconditions;

/* loaded from: classes.dex */
public final class u92 extends i21 {

    /* renamed from: c */
    public final /* synthetic */ w92 f27157c;

    public u92(w92 w92Var) {
        this.f27157c = w92Var;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Preconditions.checkElementIndex(i, size());
        w92 w92Var = this.f27157c;
        return w92Var.f14625e.mo3849a(w92Var.first(), i);
    }
}
