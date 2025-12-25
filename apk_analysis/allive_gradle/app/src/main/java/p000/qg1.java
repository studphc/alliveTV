package p000;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.BiMap;
import java.util.Collection;
import java.util.Set;

/* loaded from: classes.dex */
public final class qg1 extends sg1 implements BiMap {

    /* renamed from: h */
    public final qg1 f25576h;

    public qg1(BiMap biMap, Predicate predicate) {
        super(biMap, predicate);
        this.f25576h = new qg1(biMap.inverse(), new pg1(predicate), this);
    }

    @Override // com.google.common.collect.BiMap
    public final Object forcePut(Object obj, Object obj2) {
        Preconditions.checkArgument(m7372f(obj, obj2));
        return ((BiMap) this.f26415d).forcePut(obj, obj2);
    }

    @Override // com.google.common.collect.BiMap
    public final BiMap inverse() {
        return this.f25576h;
    }

    @Override // p000.ih1, java.util.AbstractMap, java.util.Map
    public final Collection values() {
        return this.f25576h.keySet();
    }

    @Override // p000.ih1, java.util.AbstractMap, java.util.Map
    public final Set values() {
        return this.f25576h.keySet();
    }

    public qg1(BiMap biMap, pg1 pg1Var, qg1 qg1Var) {
        super(biMap, pg1Var);
        this.f25576h = qg1Var;
    }
}
