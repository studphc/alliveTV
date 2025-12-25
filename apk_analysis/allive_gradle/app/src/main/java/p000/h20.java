package p000;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;

/* loaded from: classes.dex */
public abstract class h20 extends w21 {

    /* renamed from: f */
    public final int f17932f;

    public h20(int i) {
        this.f17932f = i;
    }

    @Override // p000.w21, com.google.common.collect.ImmutableMap
    /* renamed from: c */
    public final ImmutableSet mo3935c() {
        if (this.f17932f == mo4656l().size()) {
            return mo4656l().keySet();
        }
        return new c31(this);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public final Object get(Object obj) {
        Integer num = (Integer) mo4656l().get(obj);
        if (num == null) {
            return null;
        }
        return mo4655k(num.intValue());
    }

    @Override // p000.w21
    /* renamed from: j */
    public final UnmodifiableIterator mo5032j() {
        return new g20(this);
    }

    /* renamed from: k */
    public abstract Object mo4655k(int i);

    /* renamed from: l */
    public abstract ImmutableMap mo4656l();

    @Override // java.util.Map
    public final int size() {
        return this.f17932f;
    }
}
