package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableSet;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u00002\n\u0000\n\u0002\u0010#\n\u0002\u0010'\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u0006H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u000e\u001a\u00020\u00032\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\u0011\u001a\u00020\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0013\u001a\u00020\u00032\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u000fJ#\u0010\u0014\u001a\u00020\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0012J)\u0010\u0015\u001a\u00020\u00032\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ)\u0010\u0016\u001a\u00020\u00032\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u000fJ#\u0010\u0017\u001a\u00020\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, m5569d2 = {"androidx/collection/MutableScatterMap$MutableMapWrapper$entries$1", "", "", "", "isEmpty", "()Z", "", "iterator", "()Ljava/util/Iterator;", "", "clear", "()V", "", "elements", "containsAll", "(Ljava/util/Collection;)Z", "element", "contains", "(Ljava/util/Map$Entry;)Z", "addAll", "add", "retainAll", "removeAll", "remove", "", "getSize", "()I", "size", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nScatterMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/MutableScatterMap$MutableMapWrapper$entries$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMap\n+ 4 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n*L\n1#1,1850:1\n1726#2,3:1851\n363#3,6:1854\n373#3,3:1861\n376#3,9:1865\n363#3,6:1874\n373#3,3:1881\n376#3,9:1885\n633#3:1894\n634#3:1898\n636#3,2:1900\n638#3,4:1903\n642#3:1910\n643#3:1914\n644#3:1916\n645#3,4:1919\n651#3:1924\n652#3,8:1926\n1826#4:1860\n1688#4:1864\n1826#4:1880\n1688#4:1884\n1605#4,3:1895\n1619#4:1899\n1615#4:1902\n1795#4,3:1907\n1809#4,3:1911\n1733#4:1915\n1721#4:1917\n1715#4:1918\n1728#4:1923\n1818#4:1925\n*S KotlinDebug\n*F\n+ 1 ScatterMap.kt\nandroidx/collection/MutableScatterMap$MutableMapWrapper$entries$1\n*L\n1358#1:1851,3\n1376#1:1854,6\n1376#1:1861,3\n1376#1:1865,9\n1398#1:1874,6\n1398#1:1881,3\n1398#1:1885,9\n1413#1:1894\n1413#1:1898\n1413#1:1900,2\n1413#1:1903,4\n1413#1:1910\n1413#1:1914\n1413#1:1916\n1413#1:1919,4\n1413#1:1924\n1413#1:1926,8\n1376#1:1860\n1376#1:1864\n1398#1:1880\n1398#1:1884\n1413#1:1895,3\n1413#1:1899\n1413#1:1902\n1413#1:1907,3\n1413#1:1911,3\n1413#1:1915\n1413#1:1917\n1413#1:1918\n1413#1:1923\n1413#1:1925\n*E\n"})
/* loaded from: classes.dex */
public final class MutableScatterMap$MutableMapWrapper$entries$1 implements Set<Map.Entry<Object, Object>>, KMutableSet {

    /* renamed from: a */
    public final /* synthetic */ MutableScatterMap f1725a;

    public MutableScatterMap$MutableMapWrapper$entries$1(MutableScatterMap mutableScatterMap) {
        this.f1725a = mutableScatterMap;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends Map.Entry<Object, Object>> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.f1725a.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (TypeIntrinsics.isMutableMapEntry(obj)) {
            return contains((Map.Entry<Object, Object>) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!Intrinsics.areEqual(this.f1725a.get(entry.getKey()), entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public int getSize() {
        return this.f1725a._size;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.f1725a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<Map.Entry<Object, Object>> iterator() {
        return new MutableScatterMap$MutableMapWrapper$entries$1$iterator$1(this.f1725a);
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean remove(Object obj) {
        if (TypeIntrinsics.isMutableMapEntry(obj)) {
            return remove((Map.Entry<Object, Object>) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        boolean z;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableScatterMap mutableScatterMap = this.f1725a;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            boolean z2 = false;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8;
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((255 & j) < 128) {
                            int i6 = (i2 << 3) + i5;
                            Iterator<? extends Object> it = elements.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                Map.Entry entry = (Map.Entry) it.next();
                                if (Intrinsics.areEqual(entry.getKey(), mutableScatterMap.keys[i6]) && Intrinsics.areEqual(entry.getValue(), mutableScatterMap.values[i6])) {
                                    mutableScatterMap.removeValueAt(i6);
                                    z2 = true;
                                    break;
                                }
                            }
                            i = 8;
                        } else {
                            i = i3;
                        }
                        j >>= i;
                        i5++;
                        i3 = i;
                    }
                    if (i4 != i3) {
                        return z2;
                    }
                }
                if (i2 != length) {
                    i2++;
                } else {
                    z = z2;
                    break;
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        boolean z;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableScatterMap mutableScatterMap = this.f1725a;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            boolean z2 = false;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8;
                    int i4 = 8 - ((~(i2 - length)) >>> 31);
                    int i5 = 0;
                    while (i5 < i4) {
                        if ((255 & j) < 128) {
                            int i6 = (i2 << 3) + i5;
                            Iterator<? extends Object> it = elements.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    Map.Entry entry = (Map.Entry) it.next();
                                    if (Intrinsics.areEqual(entry.getKey(), mutableScatterMap.keys[i6]) && Intrinsics.areEqual(entry.getValue(), mutableScatterMap.values[i6])) {
                                        break;
                                    }
                                } else {
                                    mutableScatterMap.removeValueAt(i6);
                                    z2 = true;
                                    break;
                                }
                            }
                            i = 8;
                        } else {
                            i = i3;
                        }
                        j >>= i;
                        i5++;
                        i3 = i;
                    }
                    if (i4 != i3) {
                        return z2;
                    }
                }
                if (i2 != length) {
                    i2++;
                } else {
                    z = z2;
                    break;
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(@NotNull Map.Entry<Object, Object> element) {
        Intrinsics.checkNotNullParameter(element, "element");
        throw new UnsupportedOperationException();
    }

    public boolean contains(@NotNull Map.Entry<Object, Object> element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return Intrinsics.areEqual(this.f1725a.get(element.getKey()), element.getValue());
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
    
        if (((r9 & ((~r9) << 6)) & (-9187201950435737472L)) == 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007b, code lost:
    
        r15 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean remove(@NotNull Map.Entry<Object, Object> element) {
        int i;
        Intrinsics.checkNotNullParameter(element, "element");
        Object key = element.getKey();
        int hashCode = (key != null ? key.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i2 = hashCode ^ (hashCode << 16);
        int i3 = i2 & 127;
        MutableScatterMap mutableScatterMap = this.f1725a;
        int i4 = mutableScatterMap._capacity;
        int i5 = (i2 >>> 7) & i4;
        int i6 = 0;
        loop0: while (true) {
            long[] jArr = mutableScatterMap.metadata;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j2 = (i3 * ScatterMapKt.BitmaskLsb) ^ j;
            long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L);
            while (true) {
                if (j3 == 0) {
                    break;
                }
                i = ((Long.numberOfTrailingZeros(j3) >> 3) + i5) & i4;
                if (Intrinsics.areEqual(mutableScatterMap.keys[i], key)) {
                    break loop0;
                }
                j3 &= j3 - 1;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
        }
        if (i < 0 || !Intrinsics.areEqual(mutableScatterMap.values[i], element.getValue())) {
            return false;
        }
        mutableScatterMap.removeValueAt(i);
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }
}
