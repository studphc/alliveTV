package p000;

import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.collect.Interner;
import com.google.common.collect.MapMaker;

/* loaded from: classes.dex */
public final class x41 implements Interner {

    /* renamed from: a */
    public final zf1 f28438a;

    public x41(MapMaker mapMaker) {
        boolean z;
        zf1 zf1Var;
        Equivalence<Object> equals = Equivalence.equals();
        Equivalence equivalence = mapMaker.f14735f;
        if (equivalence == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "key equivalence was already set to %s", equivalence);
        mapMaker.f14735f = (Equivalence) Preconditions.checkNotNull(equals);
        mapMaker.f14730a = true;
        we1 we1Var = zf1.f29349j;
        if1 m4043a = mapMaker.m4043a();
        gf1 gf1Var = if1.f18394a;
        if (m4043a == gf1Var && mapMaker.m4044b() == gf1Var) {
            zf1Var = new zf1(mapMaker, wd0.f28141b);
        } else {
            if1 m4043a2 = mapMaker.m4043a();
            hf1 hf1Var = if1.f18395b;
            if (m4043a2 == hf1Var && mapMaker.m4044b() == gf1Var) {
                zf1Var = new zf1(mapMaker, dx0.f16574c);
            } else {
                if (mapMaker.m4044b() == hf1Var) {
                    throw new IllegalArgumentException("Map cannot have both weak and dummy values");
                }
                throw new AssertionError();
            }
        }
        this.f28438a = zf1Var;
    }

    @Override // com.google.common.collect.Interner
    public final Object intern(Object obj) {
        zf1 zf1Var;
        cf1 m4703d;
        Object key;
        do {
            zf1Var = this.f28438a;
            if (obj == null) {
                zf1Var.getClass();
                m4703d = null;
            } else {
                int m8414c = zf1Var.m8414c(obj);
                m4703d = zf1Var.m8415e(m8414c).m4703d(m8414c, obj);
            }
            if (m4703d != null && (key = m4703d.getKey()) != null) {
                return key;
            }
        } while (((ve1) zf1Var.putIfAbsent(obj, ve1.f27752a)) != null);
        return obj;
    }
}
