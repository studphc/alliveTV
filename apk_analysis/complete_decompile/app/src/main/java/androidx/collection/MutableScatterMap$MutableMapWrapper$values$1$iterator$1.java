package androidx.collection;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import p000.yq1;

@Metadata(m5568d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010)\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, m5569d2 = {"androidx/collection/MutableScatterMap$MutableMapWrapper$values$1$iterator$1", "", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "", "remove", "()V", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class MutableScatterMap$MutableMapWrapper$values$1$iterator$1 implements Iterator<Object>, KMutableIterator {

    /* renamed from: a */
    public final Iterator f1734a;

    /* renamed from: b */
    public int f1735b = -1;

    /* renamed from: c */
    public final /* synthetic */ MutableScatterMap f1736c;

    public MutableScatterMap$MutableMapWrapper$values$1$iterator$1(MutableScatterMap mutableScatterMap) {
        this.f1736c = mutableScatterMap;
        this.f1734a = SequencesKt__SequenceBuilderKt.iterator(new yq1(mutableScatterMap, null));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f1734a.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        int intValue = ((Number) this.f1734a.next()).intValue();
        this.f1735b = intValue;
        return this.f1736c.values[intValue];
    }

    @Override // java.util.Iterator
    public void remove() {
        int i = this.f1735b;
        if (i >= 0) {
            this.f1736c.removeValueAt(i);
            this.f1735b = -1;
        }
    }
}
