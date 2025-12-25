package androidx.collection;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m5568d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000f"}, m5569d2 = {"androidx/collection/LongSparseArrayKt$valueIterator$1", "", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "", "a", "I", "getIndex", "()I", "setIndex", "(I)V", FirebaseAnalytics.Param.INDEX, "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class LongSparseArrayKt$valueIterator$1<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: a, reason: from kotlin metadata */
    public int index;

    /* renamed from: b */
    public final /* synthetic */ LongSparseArray f1692b;

    public LongSparseArrayKt$valueIterator$1(LongSparseArray longSparseArray) {
        this.f1692b = longSparseArray;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.index < this.f1692b.size()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        int i = this.index;
        this.index = i + 1;
        return (T) this.f1692b.valueAt(i);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int i) {
        this.index = i;
    }
}
