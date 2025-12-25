package androidx.collection;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import org.jetbrains.annotations.NotNull;
import p000.wq1;

@Metadata(m5568d1 = {"\u0000-\n\u0000\n\u0002\u0010)\n\u0002\u0010'\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR4\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, m5569d2 = {"androidx/collection/MutableScatterMap$MutableMapWrapper$entries$1$iterator$1", "", "", "", "hasNext", "()Z", "next", "()Ljava/util/Map$Entry;", "", "remove", "()V", "", "a", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "setIterator", "(Ljava/util/Iterator;)V", "iterator", "", "b", "I", "getCurrent", "()I", "setCurrent", "(I)V", "current", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class MutableScatterMap$MutableMapWrapper$entries$1$iterator$1 implements Iterator<Map.Entry<Object, Object>>, KMutableIterator {

    /* renamed from: a, reason: from kotlin metadata */
    public Iterator iterator;

    /* renamed from: b, reason: from kotlin metadata */
    public int current = -1;

    /* renamed from: c */
    public final /* synthetic */ MutableScatterMap f1728c;

    public MutableScatterMap$MutableMapWrapper$entries$1$iterator$1(MutableScatterMap mutableScatterMap) {
        this.f1728c = mutableScatterMap;
        this.iterator = SequencesKt__SequenceBuilderKt.iterator(new wq1(mutableScatterMap, this, null));
    }

    public final int getCurrent() {
        return this.current;
    }

    @NotNull
    public final Iterator<Map.Entry<Object, Object>> getIterator() {
        return this.iterator;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        int i = this.current;
        if (i != -1) {
            this.f1728c.removeValueAt(i);
            this.current = -1;
        }
    }

    public final void setCurrent(int i) {
        this.current = i;
    }

    public final void setIterator(@NotNull Iterator<? extends Map.Entry<Object, Object>> it) {
        Intrinsics.checkNotNullParameter(it, "<set-?>");
        this.iterator = it;
    }

    @Override // java.util.Iterator
    @NotNull
    public Map.Entry<Object, Object> next() {
        return (Map.Entry) this.iterator.next();
    }
}
