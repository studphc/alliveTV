package androidx.collection;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import org.jetbrains.annotations.NotNull;
import p000.zq1;

@Metadata(m5568d1 = {"\u0000&\n\u0000\n\u0002\u0010)\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\u0006\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, m5569d2 = {"androidx/collection/MutableScatterSet$MutableSetWrapper$iterator$1", "", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "", "remove", "()V", "", "a", "I", "getCurrent", "()I", "setCurrent", "(I)V", "current", "", "b", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "iterator", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class MutableScatterSet$MutableSetWrapper$iterator$1 implements Iterator<Object>, KMutableIterator {

    /* renamed from: a, reason: from kotlin metadata */
    public int current = -1;

    /* renamed from: b, reason: from kotlin metadata */
    public final Iterator iterator;

    /* renamed from: c */
    public final /* synthetic */ MutableScatterSet f1740c;

    public MutableScatterSet$MutableSetWrapper$iterator$1(MutableScatterSet mutableScatterSet) {
        this.f1740c = mutableScatterSet;
        this.iterator = SequencesKt__SequenceBuilderKt.iterator(new zq1(mutableScatterSet, this, null));
    }

    public final int getCurrent() {
        return this.current;
    }

    @NotNull
    public final Iterator<Object> getIterator() {
        return this.iterator;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return this.iterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        int i = this.current;
        if (i != -1) {
            this.f1740c.removeElementAt(i);
            this.current = -1;
        }
    }

    public final void setCurrent(int i) {
        this.current = i;
    }
}
