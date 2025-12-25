package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m5568d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0019\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0003\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, m5569d2 = {"kotlin/sequences/FilteringSequence$iterator$1", "", "next", "()Ljava/lang/Object;", "", "hasNext", "()Z", "a", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "iterator", "", "b", "I", "getNextState", "()I", "setNextState", "(I)V", "nextState", "c", "Ljava/lang/Object;", "getNextItem", "setNextItem", "(Ljava/lang/Object;)V", "nextItem", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class FilteringSequence$iterator$1<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: a, reason: from kotlin metadata */
    public final Iterator iterator;

    /* renamed from: b, reason: from kotlin metadata */
    public int nextState;

    /* renamed from: c, reason: from kotlin metadata */
    public Object nextItem;

    /* renamed from: d */
    public final /* synthetic */ FilteringSequence f21269d;

    public FilteringSequence$iterator$1(FilteringSequence filteringSequence) {
        Sequence sequence;
        this.f21269d = filteringSequence;
        sequence = filteringSequence.f21263a;
        this.iterator = sequence.iterator();
        this.nextState = -1;
    }

    /* renamed from: a */
    public final void m5631a() {
        Object next;
        Function1 function1;
        boolean booleanValue;
        boolean z;
        do {
            Iterator it = this.iterator;
            if (it.hasNext()) {
                next = it.next();
                FilteringSequence filteringSequence = this.f21269d;
                function1 = filteringSequence.f21265c;
                booleanValue = ((Boolean) function1.invoke(next)).booleanValue();
                z = filteringSequence.f21264b;
            } else {
                this.nextState = 0;
                return;
            }
        } while (booleanValue != z);
        this.nextItem = next;
        this.nextState = 1;
    }

    @NotNull
    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    @Nullable
    public final T getNextItem() {
        return (T) this.nextItem;
    }

    public final int getNextState() {
        return this.nextState;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextState == -1) {
            m5631a();
        }
        if (this.nextState == 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.nextState == -1) {
            m5631a();
        }
        if (this.nextState != 0) {
            T t = (T) this.nextItem;
            this.nextItem = null;
            this.nextState = -1;
            return t;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setNextItem(@Nullable T t) {
        this.nextItem = t;
    }

    public final void setNextState(int i) {
        this.nextState = i;
    }
}
