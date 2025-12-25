package p000;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.Traverser;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class xv2 implements Iterable {

    /* renamed from: a */
    public final /* synthetic */ int f28745a;

    /* renamed from: b */
    public final /* synthetic */ ImmutableSet f28746b;

    /* renamed from: c */
    public final /* synthetic */ Traverser f28747c;

    public /* synthetic */ xv2(Traverser traverser, ImmutableSet immutableSet, int i) {
        this.f28745a = i;
        this.f28747c = traverser;
        this.f28746b = immutableSet;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f28745a) {
            case 0:
                ge3 mo4176a = this.f28747c.mo4176a();
                UnmodifiableIterator it = this.f28746b.iterator();
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.add(it);
                return new aw2(mo4176a, arrayDeque, 2);
            case 1:
                ge3 mo4176a2 = this.f28747c.mo4176a();
                UnmodifiableIterator it2 = this.f28746b.iterator();
                ArrayDeque arrayDeque2 = new ArrayDeque();
                arrayDeque2.add(it2);
                return new aw2(mo4176a2, arrayDeque2, 1);
            default:
                ge3 mo4176a3 = this.f28747c.mo4176a();
                UnmodifiableIterator it3 = this.f28746b.iterator();
                ArrayDeque arrayDeque3 = new ArrayDeque();
                ArrayDeque arrayDeque4 = new ArrayDeque();
                arrayDeque4.add(it3);
                return new gh2(mo4176a3, arrayDeque4, arrayDeque3, 3);
        }
    }
}
