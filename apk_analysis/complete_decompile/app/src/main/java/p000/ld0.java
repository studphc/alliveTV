package p000;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;

/* loaded from: classes.dex */
public final class ld0 implements Predicate {

    /* renamed from: a */
    public final Object f22467a;

    /* renamed from: b */
    public final /* synthetic */ md0 f22468b;

    public ld0(md0 md0Var, Object obj) {
        this.f22468b = md0Var;
        this.f22467a = obj;
    }

    @Override // com.google.common.base.Predicate
    public final boolean apply(Object obj) {
        return this.f22468b.f22896g.apply(Maps.immutableEntry(this.f22467a, obj));
    }
}
