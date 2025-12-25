package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m5568d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, m5569d2 = {"kotlin/sequences/DropSequence$iterator$1", "", "next", "()Ljava/lang/Object;", "", "hasNext", "()Z", "a", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "iterator", "", "b", "I", "getLeft", "()I", "setLeft", "(I)V", "left", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class DropSequence$iterator$1<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: a, reason: from kotlin metadata */
    public final Iterator iterator;

    /* renamed from: b, reason: from kotlin metadata */
    public int left;

    public DropSequence$iterator$1(DropSequence dropSequence) {
        Sequence sequence;
        int i;
        sequence = dropSequence.f21253a;
        this.iterator = sequence.iterator();
        i = dropSequence.f21254b;
        this.left = i;
    }

    @NotNull
    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    public final int getLeft() {
        return this.left;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        Iterator it;
        while (true) {
            int i = this.left;
            it = this.iterator;
            if (i <= 0 || !it.hasNext()) {
                break;
            }
            it.next();
            this.left--;
        }
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        Iterator it;
        while (true) {
            int i = this.left;
            it = this.iterator;
            if (i <= 0 || !it.hasNext()) {
                break;
            }
            it.next();
            this.left--;
        }
        return (T) it.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setLeft(int i) {
        this.left = i;
    }
}
