package p000;

import com.google.common.base.Equivalence;
import com.google.common.collect.ForwardingConcurrentMap;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public abstract class xe1 extends ForwardingConcurrentMap implements Serializable {
    private static final long serialVersionUID = 3;

    /* renamed from: a */
    public final if1 f28523a;

    /* renamed from: b */
    public final if1 f28524b;

    /* renamed from: c */
    public final Equivalence f28525c;

    /* renamed from: d */
    public final int f28526d;

    /* renamed from: e */
    public transient ConcurrentMap f28527e;

    public xe1(if1 if1Var, if1 if1Var2, Equivalence equivalence, int i, zf1 zf1Var) {
        this.f28523a = if1Var;
        this.f28524b = if1Var2;
        this.f28525c = equivalence;
        this.f28526d = i;
        this.f28527e = zf1Var;
    }

    @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public final Object delegate() {
        return this.f28527e;
    }

    @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public final Map delegate() {
        return this.f28527e;
    }

    @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public final ConcurrentMap delegate() {
        return this.f28527e;
    }
}
