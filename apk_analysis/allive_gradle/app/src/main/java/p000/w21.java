package p000;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class w21 extends ImmutableMap {
    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: a */
    public final ImmutableSet mo3934a() {
        return new v21(this, 0);
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: c */
    public ImmutableSet mo3935c() {
        return new c31(this);
    }

    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: e */
    public final ImmutableCollection mo3893e() {
        return new f31(this);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    /* renamed from: j */
    public abstract UnmodifiableIterator mo5032j();

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
    public final /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }
}
