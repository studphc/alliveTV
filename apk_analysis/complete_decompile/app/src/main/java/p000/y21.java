package p000;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;

/* loaded from: classes.dex */
public final class y21 extends w21 {

    /* renamed from: f */
    public final /* synthetic */ ImmutableMap f28806f;

    public y21(ImmutableMap immutableMap) {
        this.f28806f = immutableMap;
    }

    @Override // p000.w21, com.google.common.collect.ImmutableMap
    /* renamed from: c */
    public final ImmutableSet mo3935c() {
        return this.f28806f.keySet();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return this.f28806f.containsKey(obj);
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: g */
    public final boolean mo3936g() {
        return this.f28806f.mo3936g();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public final Object get(Object obj) {
        Object obj2 = this.f28806f.get(obj);
        if (obj2 == null) {
            return null;
        }
        return ImmutableSet.m3972of(obj2);
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: h */
    public final boolean mo3937h() {
        return this.f28806f.mo3937h();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public final int hashCode() {
        return this.f28806f.hashCode();
    }

    @Override // p000.w21
    /* renamed from: j */
    public final UnmodifiableIterator mo5032j() {
        return new u21(this.f28806f.entrySet().iterator(), 1);
    }

    @Override // java.util.Map
    public final int size() {
        return this.f28806f.size();
    }
}
