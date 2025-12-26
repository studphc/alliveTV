package kotlin.collections;

import java.util.Enumeration;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m5568d1 = {"\u0000\u0013\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0002\u001a\u00020\u0003H\u0096\u0002J\u000e\u0010\u0004\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m5569d2 = {"kotlin/collections/CollectionsKt__IteratorsJVMKt$iterator$1", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class CollectionsKt__IteratorsJVMKt$iterator$1<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: a */
    public final /* synthetic */ Enumeration f20996a;

    public CollectionsKt__IteratorsJVMKt$iterator$1(Enumeration enumeration) {
        this.f20996a = enumeration;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f20996a.hasMoreElements();
    }

    @Override // java.util.Iterator
    public T next() {
        return (T) this.f20996a.nextElement();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
