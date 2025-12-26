package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [E] */
@Metadata(m5568d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, m5569d2 = {"kotlin/sequences/FlatteningSequence$iterator$1", "", "next", "()Ljava/lang/Object;", "", "hasNext", "()Z", "a", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "iterator", "b", "getItemIterator", "setItemIterator", "(Ljava/util/Iterator;)V", "itemIterator", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class FlatteningSequence$iterator$1<E> implements Iterator<E>, KMappedMarker {

    /* renamed from: a, reason: from kotlin metadata */
    public final Iterator iterator;

    /* renamed from: b, reason: from kotlin metadata */
    public Iterator itemIterator;

    /* renamed from: c */
    public final /* synthetic */ FlatteningSequence f21275c;

    public FlatteningSequence$iterator$1(FlatteningSequence flatteningSequence) {
        Sequence sequence;
        this.f21275c = flatteningSequence;
        sequence = flatteningSequence.f21270a;
        this.iterator = sequence.iterator();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
    
        return true;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m5632a() {
        Function1 function1;
        Function1 function12;
        Iterator it = this.itemIterator;
        if (it != null && !it.hasNext()) {
            this.itemIterator = null;
        }
        while (true) {
            if (this.itemIterator != null) {
                break;
            }
            Iterator it2 = this.iterator;
            if (!it2.hasNext()) {
                return false;
            }
            Object next = it2.next();
            FlatteningSequence flatteningSequence = this.f21275c;
            function1 = flatteningSequence.f21272c;
            function12 = flatteningSequence.f21271b;
            Iterator it3 = (Iterator) function1.invoke(function12.invoke(next));
            if (it3.hasNext()) {
                this.itemIterator = it3;
                break;
            }
        }
    }

    @Nullable
    public final Iterator<E> getItemIterator() {
        return this.itemIterator;
    }

    @NotNull
    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return m5632a();
    }

    @Override // java.util.Iterator
    public E next() {
        if (m5632a()) {
            Iterator it = this.itemIterator;
            Intrinsics.checkNotNull(it);
            return (E) it.next();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setItemIterator(@Nullable Iterator<? extends E> it) {
        this.itemIterator = it;
    }
}
