package p000;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.EnumMap;

/* loaded from: classes.dex */
public final class m21 extends w21 {

    /* renamed from: f */
    public final transient EnumMap f22778f;

    public m21(EnumMap enumMap) {
        this.f22778f = enumMap;
        Preconditions.checkArgument(!enumMap.isEmpty());
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return this.f22778f.containsKey(obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m21) {
            obj = ((m21) obj).f22778f;
        }
        return this.f22778f.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public final Object get(Object obj) {
        return this.f22778f.get(obj);
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: h */
    public final boolean mo3937h() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: i */
    public final UnmodifiableIterator mo3938i() {
        return Iterators.unmodifiableIterator(this.f22778f.keySet().iterator());
    }

    @Override // p000.w21
    /* renamed from: j */
    public final UnmodifiableIterator mo5032j() {
        return new t51(this.f22778f.entrySet().iterator(), 2);
    }

    @Override // java.util.Map
    public final int size() {
        return this.f22778f.size();
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new l21(this.f22778f);
    }
}
