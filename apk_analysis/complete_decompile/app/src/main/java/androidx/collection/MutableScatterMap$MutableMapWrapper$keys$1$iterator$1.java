package androidx.collection;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import p000.xq1;

@Metadata(m5568d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010)\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, m5569d2 = {"androidx/collection/MutableScatterMap$MutableMapWrapper$keys$1$iterator$1", "", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "", "remove", "()V", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class MutableScatterMap$MutableMapWrapper$keys$1$iterator$1 implements Iterator<Object>, KMutableIterator {

    /* renamed from: a */
    public final Iterator f1730a;

    /* renamed from: b */
    public int f1731b = -1;

    /* renamed from: c */
    public final /* synthetic */ MutableScatterMap f1732c;

    public MutableScatterMap$MutableMapWrapper$keys$1$iterator$1(MutableScatterMap mutableScatterMap) {
        this.f1732c = mutableScatterMap;
        this.f1730a = SequencesKt__SequenceBuilderKt.iterator(new xq1(mutableScatterMap, null));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f1730a.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        int intValue = ((Number) this.f1730a.next()).intValue();
        this.f1731b = intValue;
        return this.f1732c.keys[intValue];
    }

    @Override // java.util.Iterator
    public void remove() {
        int i = this.f1731b;
        if (i >= 0) {
            this.f1732c.removeValueAt(i);
            this.f1731b = -1;
        }
    }
}
