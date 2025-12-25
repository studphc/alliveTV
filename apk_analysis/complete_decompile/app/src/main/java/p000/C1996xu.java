package p000;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMapKt;

/* renamed from: xu */
/* loaded from: classes2.dex */
public final class C1996xu extends AbstractMutableSet {

    /* renamed from: a */
    public final Lambda f28737a;

    /* renamed from: b */
    public final /* synthetic */ ConcurrentWeakMap f28738b;

    /* JADX WARN: Multi-variable type inference failed */
    public C1996xu(ConcurrentWeakMap concurrentWeakMap, Function2 function2) {
        this.f28738b = concurrentWeakMap;
        this.f28737a = (Lambda) function2;
    }

    @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        ConcurrentWeakMapKt.access$noImpl();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.collections.AbstractMutableSet
    public final int getSize() {
        return this.f28738b.size();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.functions.Function2, kotlin.jvm.internal.Lambda] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        atomicReferenceFieldUpdater = ConcurrentWeakMap.f21507c;
        C1922vu c1922vu = (C1922vu) atomicReferenceFieldUpdater.get(this.f28738b);
        c1922vu.getClass();
        return new C1885uu(c1922vu, this.f28737a);
    }
}
