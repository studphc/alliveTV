package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableCollection;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000.\n\u0000\n\u0002\u0010\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ\u001d\u0010\u0013\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u000eJ\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0011J\u001d\u0010\u0015\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u000eJ\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0011R\u0014\u0010\u001a\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, m5569d2 = {"androidx/collection/MutableScatterMap$MutableMapWrapper$values$1", "", "", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "", "clear", "()V", "", "elements", "addAll", "(Ljava/util/Collection;)Z", "element", "add", "(Ljava/lang/Object;)Z", "retainAll", "removeAll", "remove", "containsAll", "contains", "", "getSize", "()I", "size", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nScatterMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/MutableScatterMap$MutableMapWrapper$values$1\n+ 2 ScatterMap.kt\nandroidx/collection/ScatterMap\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1850:1\n363#2,6:1851\n373#2,3:1858\n376#2,9:1862\n363#2,6:1871\n373#2,3:1878\n376#2,9:1882\n363#2,6:1891\n373#2,3:1898\n376#2,9:1902\n1826#3:1857\n1688#3:1861\n1826#3:1877\n1688#3:1881\n1826#3:1897\n1688#3:1901\n1726#4,3:1911\n*S KotlinDebug\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/MutableScatterMap$MutableMapWrapper$values$1\n*L\n1546#1:1851,6\n1546#1:1858,3\n1546#1:1862,9\n1557#1:1871,6\n1557#1:1878,3\n1557#1:1882,9\n1567#1:1891,6\n1567#1:1898,3\n1567#1:1902,9\n1546#1:1857\n1546#1:1861\n1557#1:1877\n1557#1:1881\n1567#1:1897\n1567#1:1901\n1577#1:1911,3\n*E\n"})
/* loaded from: classes.dex */
public final class MutableScatterMap$MutableMapWrapper$values$1 implements Collection<Object>, KMutableCollection {

    /* renamed from: a */
    public final /* synthetic */ MutableScatterMap f1733a;

    public MutableScatterMap$MutableMapWrapper$values$1(MutableScatterMap mutableScatterMap) {
        this.f1733a = mutableScatterMap;
    }

    @Override // java.util.Collection
    public boolean add(Object element) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(@NotNull Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public void clear() {
        this.f1733a.clear();
    }

    @Override // java.util.Collection
    public boolean contains(Object element) {
        return this.f1733a.containsValue(element);
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            if (!this.f1733a.containsValue(it.next())) {
                return false;
            }
        }
        return true;
    }

    public int getSize() {
        return this.f1733a._size;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f1733a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<Object> iterator() {
        return new MutableScatterMap$MutableMapWrapper$values$1$iterator$1(this.f1733a);
    }

    @Override // java.util.Collection
    public boolean remove(Object element) {
        MutableScatterMap mutableScatterMap = this.f1733a;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            if (Intrinsics.areEqual(mutableScatterMap.values[i4], element)) {
                                mutableScatterMap.removeValueAt(i4);
                                return true;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableScatterMap mutableScatterMap = this.f1733a;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        boolean z = false;
        if (length >= 0) {
            int i = 0;
            boolean z2 = false;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            if (CollectionsKt___CollectionsKt.contains(elements, mutableScatterMap.values[i4])) {
                                mutableScatterMap.removeValueAt(i4);
                                z2 = true;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return z2;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    z = z2;
                    break;
                }
            }
        }
        return z;
    }

    @Override // java.util.Collection
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableScatterMap mutableScatterMap = this.f1733a;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        boolean z = false;
        if (length >= 0) {
            int i = 0;
            boolean z2 = false;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            if (!CollectionsKt___CollectionsKt.contains(elements, mutableScatterMap.values[i4])) {
                                mutableScatterMap.removeValueAt(i4);
                                z2 = true;
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return z2;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    z = z2;
                    break;
                }
            }
        }
        return z;
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }
}
