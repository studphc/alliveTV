package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m5568d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, m5569d2 = {"kotlin/sequences/SubSequence$iterator$1", "", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "a", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "iterator", "", "b", "I", "getPosition", "()I", "setPosition", "(I)V", "position", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class SubSequence$iterator$1<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: a, reason: from kotlin metadata */
    public final Iterator iterator;

    /* renamed from: b, reason: from kotlin metadata */
    public int position;

    /* renamed from: c */
    public final /* synthetic */ SubSequence f21310c;

    public SubSequence$iterator$1(SubSequence subSequence) {
        Sequence sequence;
        this.f21310c = subSequence;
        sequence = subSequence.f21305a;
        this.iterator = sequence.iterator();
    }

    /* JADX WARN: Incorrect condition in loop: B:2:0x0008 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5634a() {
        int i;
        while (r0 < i) {
            Iterator it = this.iterator;
            if (it.hasNext()) {
                it.next();
                this.position++;
            } else {
                return;
            }
        }
    }

    @NotNull
    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    public final int getPosition() {
        return this.position;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i;
        m5634a();
        int i2 = this.position;
        i = this.f21310c.f21307c;
        if (i2 < i && this.iterator.hasNext()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        int i;
        m5634a();
        int i2 = this.position;
        i = this.f21310c.f21307c;
        if (i2 < i) {
            this.position++;
            return (T) this.iterator.next();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setPosition(int i) {
        this.position = i;
    }
}
