package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [V] */
@Metadata(m5568d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n¨\u0006\u000f"}, m5569d2 = {"kotlin/sequences/MergingSequence$iterator$1", "", "next", "()Ljava/lang/Object;", "", "hasNext", "()Z", "a", "Ljava/util/Iterator;", "getIterator1", "()Ljava/util/Iterator;", "iterator1", "b", "getIterator2", "iterator2", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class MergingSequence$iterator$1<V> implements Iterator<V>, KMappedMarker {

    /* renamed from: a, reason: from kotlin metadata */
    public final Iterator iterator1;

    /* renamed from: b, reason: from kotlin metadata */
    public final Iterator iterator2;

    /* renamed from: c */
    public final /* synthetic */ MergingSequence f21287c;

    public MergingSequence$iterator$1(MergingSequence mergingSequence) {
        Sequence sequence;
        Sequence sequence2;
        this.f21287c = mergingSequence;
        sequence = mergingSequence.f21282a;
        this.iterator1 = sequence.iterator();
        sequence2 = mergingSequence.f21283b;
        this.iterator2 = sequence2.iterator();
    }

    @NotNull
    public final Iterator<T1> getIterator1() {
        return this.iterator1;
    }

    @NotNull
    public final Iterator<T2> getIterator2() {
        return this.iterator2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.iterator1.hasNext() && this.iterator2.hasNext()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public V next() {
        Function2 function2;
        function2 = this.f21287c.f21284c;
        return (V) function2.invoke(this.iterator1.next(), this.iterator2.next());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
