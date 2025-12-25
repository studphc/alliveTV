package p000;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class v21 extends a31 {

    /* renamed from: c */
    public final /* synthetic */ int f27628c;

    /* renamed from: d */
    public final /* synthetic */ ImmutableMap f27629d;

    public /* synthetic */ v21(ImmutableMap immutableMap, int i) {
        this.f27628c = i;
        this.f27629d = immutableMap;
    }

    @Override // com.google.common.collect.ImmutableSet
    /* renamed from: h */
    public ImmutableList mo3978h() {
        switch (this.f27628c) {
            case 1:
                return new b41(this);
            default:
                return super.mo3978h();
        }
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f27628c) {
            case 0:
                return ((w21) this.f27629d).mo5032j();
            default:
                return iterator();
        }
    }

    @Override // p000.a31
    /* renamed from: j */
    public final ImmutableMap mo9j() {
        switch (this.f27628c) {
            case 0:
                return (w21) this.f27629d;
            default:
                return (ImmutableSortedMap) this.f27629d;
        }
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final UnmodifiableIterator iterator() {
        switch (this.f27628c) {
            case 0:
                return ((w21) this.f27629d).mo5032j();
            default:
                return asList().iterator();
        }
    }
}
