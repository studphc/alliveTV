package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1726qj;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B#\b\u0016\u0012\u0018\u0010\b\u001a\u0014\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u0001\u0018\u00010\u0000¢\u0006\u0004\b\u0006\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u0007J\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0001H\u0001¢\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0018\u0010\u0012J\u001a\u0010\u0019\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001c\u001a\u00028\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00028\u00012\u0006\u0010\u001e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010 J\u001f\u0010\"\u001a\u00028\u00012\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0010H\u0016¢\u0006\u0004\b$\u0010%J!\u0010&\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0004\b&\u0010\u001dJ'\u0010'\u001a\u00020\n2\u0016\u0010\b\u001a\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u00010\u0000H\u0016¢\u0006\u0004\b'\u0010\tJ!\u0010(\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0004\b(\u0010\u001dJ\u0019\u0010)\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b)\u0010\u001aJ\u001f\u0010)\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00028\u00012\u0006\u0010\u001e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b+\u0010 J!\u0010,\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0001H\u0016¢\u0006\u0004\b,\u0010\u001dJ'\u0010,\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010-\u001a\u00028\u00012\u0006\u0010.\u001a\u00028\u0001H\u0016¢\u0006\u0004\b,\u0010/J\u000f\u00100\u001a\u00020\u0004H\u0016¢\u0006\u0004\b0\u00101J\u001a\u00103\u001a\u00020\u00102\b\u00102\u001a\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b3\u0010\u0012J\u000f\u00104\u001a\u00020\u0004H\u0016¢\u0006\u0004\b4\u00101J\u000f\u00106\u001a\u000205H\u0016¢\u0006\u0004\b6\u00107¨\u00068"}, m5569d2 = {"Landroidx/collection/SimpleArrayMap;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "", "capacity", "<init>", "(I)V", "map", "(Landroidx/collection/SimpleArrayMap;)V", "", "clear", "()V", "minimumCapacity", "ensureCapacity", "key", "", "containsKey", "(Ljava/lang/Object;)Z", "indexOfKey", "(Ljava/lang/Object;)I", "value", "__restricted$indexOfValue", "indexOfValue", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "defaultValue", "getOrDefault", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", FirebaseAnalytics.Param.INDEX, "keyAt", "(I)Ljava/lang/Object;", "valueAt", "setValueAt", "(ILjava/lang/Object;)Ljava/lang/Object;", "isEmpty", "()Z", "put", "putAll", "putIfAbsent", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeAt", "replace", "oldValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "size", "()I", "other", "equals", "hashCode", "", "toString", "()Ljava/lang/String;", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nSimpleArrayMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SimpleArrayMap.kt\nandroidx/collection/SimpleArrayMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,769:1\n297#1,5:770\n297#1,5:775\n1#2:780\n*S KotlinDebug\n*F\n+ 1 SimpleArrayMap.kt\nandroidx/collection/SimpleArrayMap\n*L\n276#1:770,5\n291#1:775,5\n*E\n"})
/* loaded from: classes.dex */
public class SimpleArrayMap<K, V> {

    /* renamed from: a */
    public int[] f1753a;

    /* renamed from: b */
    public Object[] f1754b;

    /* renamed from: c */
    public int f1755c;

    @JvmOverloads
    public SimpleArrayMap() {
        this(0, 1, null);
    }

    @JvmName(name = "__restricted$indexOfValue")
    public final int __restricted$indexOfValue(V value) {
        int i = this.f1755c * 2;
        Object[] objArr = this.f1754b;
        if (value == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (Intrinsics.areEqual(value, objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public final int m414a(int i, Object obj) {
        int i2 = this.f1755c;
        if (i2 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpersKt.binarySearch(this.f1753a, i2, i);
        if (binarySearch < 0) {
            return binarySearch;
        }
        if (Intrinsics.areEqual(obj, this.f1754b[binarySearch << 1])) {
            return binarySearch;
        }
        int i3 = binarySearch + 1;
        while (i3 < i2 && this.f1753a[i3] == i) {
            if (Intrinsics.areEqual(obj, this.f1754b[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = binarySearch - 1; i4 >= 0 && this.f1753a[i4] == i; i4--) {
            if (Intrinsics.areEqual(obj, this.f1754b[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    /* renamed from: c */
    public final int m415c() {
        int i = this.f1755c;
        if (i == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpersKt.binarySearch(this.f1753a, i, 0);
        if (binarySearch < 0) {
            return binarySearch;
        }
        if (this.f1754b[binarySearch << 1] == null) {
            return binarySearch;
        }
        int i2 = binarySearch + 1;
        while (i2 < i && this.f1753a[i2] == 0) {
            if (this.f1754b[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = binarySearch - 1; i3 >= 0 && this.f1753a[i3] == 0; i3--) {
            if (this.f1754b[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    public void clear() {
        if (this.f1755c > 0) {
            this.f1753a = ContainerHelpersKt.EMPTY_INTS;
            this.f1754b = ContainerHelpersKt.EMPTY_OBJECTS;
            this.f1755c = 0;
        }
        if (this.f1755c <= 0) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(K key) {
        if (indexOfKey(key) >= 0) {
            return true;
        }
        return false;
    }

    public boolean containsValue(V value) {
        if (__restricted$indexOfValue(value) >= 0) {
            return true;
        }
        return false;
    }

    public void ensureCapacity(int minimumCapacity) {
        int i = this.f1755c;
        int[] iArr = this.f1753a;
        if (iArr.length < minimumCapacity) {
            int[] copyOf = Arrays.copyOf(iArr, minimumCapacity);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.f1753a = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f1754b, minimumCapacity * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            this.f1754b = copyOf2;
        }
        if (this.f1755c == i) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        try {
            if (other instanceof SimpleArrayMap) {
                if (getF1755c() != ((SimpleArrayMap) other).getF1755c()) {
                    return false;
                }
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) other;
                int i = this.f1755c;
                for (int i2 = 0; i2 < i; i2++) {
                    K keyAt = keyAt(i2);
                    V valueAt = valueAt(i2);
                    Object obj = simpleArrayMap.get(keyAt);
                    if (valueAt == null) {
                        if (obj != null || !simpleArrayMap.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!Intrinsics.areEqual(valueAt, obj)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(other instanceof Map) || getF1755c() != ((Map) other).size()) {
                return false;
            }
            int i3 = this.f1755c;
            for (int i4 = 0; i4 < i3; i4++) {
                K keyAt2 = keyAt(i4);
                V valueAt2 = valueAt(i4);
                Object obj2 = ((Map) other).get(keyAt2);
                if (valueAt2 == null) {
                    if (obj2 != null || !((Map) other).containsKey(keyAt2)) {
                        return false;
                    }
                } else if (!Intrinsics.areEqual(valueAt2, obj2)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    @Nullable
    public V get(K key) {
        int indexOfKey = indexOfKey(key);
        if (indexOfKey >= 0) {
            return (V) this.f1754b[(indexOfKey << 1) + 1];
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V getOrDefault(@Nullable Object key, V defaultValue) {
        int indexOfKey = indexOfKey(key);
        if (indexOfKey >= 0) {
            return (V) this.f1754b[(indexOfKey << 1) + 1];
        }
        return defaultValue;
    }

    public int hashCode() {
        int i;
        int[] iArr = this.f1753a;
        Object[] objArr = this.f1754b;
        int i2 = this.f1755c;
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            int i6 = iArr[i4];
            if (obj != null) {
                i = obj.hashCode();
            } else {
                i = 0;
            }
            i5 += i ^ i6;
            i4++;
            i3 += 2;
        }
        return i5;
    }

    public int indexOfKey(K key) {
        if (key == null) {
            return m415c();
        }
        return m414a(key.hashCode(), key);
    }

    public boolean isEmpty() {
        if (this.f1755c <= 0) {
            return true;
        }
        return false;
    }

    public K keyAt(int index) {
        if (index >= 0 && index < this.f1755c) {
            return (K) this.f1754b[index << 1];
        }
        throw new IllegalArgumentException(ye0.m8291k(index, "Expected index to be within 0..size()-1, but was ").toString());
    }

    @Nullable
    public V put(K key, V value) {
        int i;
        int m415c;
        int i2 = this.f1755c;
        if (key != null) {
            i = key.hashCode();
        } else {
            i = 0;
        }
        if (key != null) {
            m415c = m414a(i, key);
        } else {
            m415c = m415c();
        }
        if (m415c >= 0) {
            int i3 = (m415c << 1) + 1;
            Object[] objArr = this.f1754b;
            V v = (V) objArr[i3];
            objArr[i3] = value;
            return v;
        }
        int i4 = ~m415c;
        int[] iArr = this.f1753a;
        if (i2 >= iArr.length) {
            int i5 = 8;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i5 = 4;
            }
            int[] copyOf = Arrays.copyOf(iArr, i5);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.f1753a = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f1754b, i5 << 1);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            this.f1754b = copyOf2;
            if (i2 != this.f1755c) {
                throw new ConcurrentModificationException();
            }
        }
        if (i4 < i2) {
            int[] iArr2 = this.f1753a;
            int i6 = i4 + 1;
            ArraysKt___ArraysJvmKt.copyInto(iArr2, iArr2, i6, i4, i2);
            Object[] objArr2 = this.f1754b;
            ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, i6 << 1, i4 << 1, this.f1755c << 1);
        }
        int i7 = this.f1755c;
        if (i2 == i7) {
            int[] iArr3 = this.f1753a;
            if (i4 < iArr3.length) {
                iArr3[i4] = i;
                Object[] objArr3 = this.f1754b;
                int i8 = i4 << 1;
                objArr3[i8] = key;
                objArr3[i8 + 1] = value;
                this.f1755c = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(@NotNull SimpleArrayMap<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        int i = map.f1755c;
        ensureCapacity(this.f1755c + i);
        if (this.f1755c == 0) {
            if (i > 0) {
                ArraysKt___ArraysJvmKt.copyInto(map.f1753a, this.f1753a, 0, 0, i);
                ArraysKt___ArraysJvmKt.copyInto(map.f1754b, this.f1754b, 0, 0, i << 1);
                this.f1755c = i;
                return;
            }
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            put(map.keyAt(i2), map.valueAt(i2));
        }
    }

    @Nullable
    public V putIfAbsent(K key, V value) {
        V v = get(key);
        if (v == null) {
            return put(key, value);
        }
        return v;
    }

    @Nullable
    public V remove(K key) {
        int indexOfKey = indexOfKey(key);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public V removeAt(int index) {
        int i;
        if (index >= 0 && index < (i = this.f1755c)) {
            Object[] objArr = this.f1754b;
            int i2 = index << 1;
            V v = (V) objArr[i2 + 1];
            if (i <= 1) {
                clear();
            } else {
                int i3 = i - 1;
                int[] iArr = this.f1753a;
                int i4 = 8;
                if (iArr.length > 8 && i < iArr.length / 3) {
                    if (i > 8) {
                        i4 = i + (i >> 1);
                    }
                    int[] copyOf = Arrays.copyOf(iArr, i4);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                    this.f1753a = copyOf;
                    Object[] copyOf2 = Arrays.copyOf(this.f1754b, i4 << 1);
                    Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
                    this.f1754b = copyOf2;
                    if (i == this.f1755c) {
                        if (index > 0) {
                            ArraysKt___ArraysJvmKt.copyInto(iArr, this.f1753a, 0, 0, index);
                            ArraysKt___ArraysJvmKt.copyInto(objArr, this.f1754b, 0, 0, i2);
                        }
                        if (index < i3) {
                            int i5 = index + 1;
                            ArraysKt___ArraysJvmKt.copyInto(iArr, this.f1753a, index, i5, i);
                            ArraysKt___ArraysJvmKt.copyInto(objArr, this.f1754b, i2, i5 << 1, i << 1);
                        }
                    } else {
                        throw new ConcurrentModificationException();
                    }
                } else {
                    if (index < i3) {
                        int i6 = index + 1;
                        ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, index, i6, i);
                        Object[] objArr2 = this.f1754b;
                        ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, i2, i6 << 1, i << 1);
                    }
                    Object[] objArr3 = this.f1754b;
                    int i7 = i3 << 1;
                    objArr3[i7] = null;
                    objArr3[i7 + 1] = null;
                }
                if (i == this.f1755c) {
                    this.f1755c = i3;
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            return v;
        }
        throw new IllegalArgumentException(ye0.m8291k(index, "Expected index to be within 0..size()-1, but was ").toString());
    }

    @Nullable
    public V replace(K key, V value) {
        int indexOfKey = indexOfKey(key);
        if (indexOfKey >= 0) {
            return setValueAt(indexOfKey, value);
        }
        return null;
    }

    public V setValueAt(int index, V value) {
        if (index >= 0 && index < this.f1755c) {
            int i = (index << 1) + 1;
            Object[] objArr = this.f1754b;
            V v = (V) objArr[i];
            objArr[i] = value;
            return v;
        }
        throw new IllegalArgumentException(ye0.m8291k(index, "Expected index to be within 0..size()-1, but was ").toString());
    }

    /* renamed from: size, reason: from getter */
    public int getF1755c() {
        return this.f1755c;
    }

    @NotNull
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1755c * 28);
        sb.append('{');
        int i = this.f1755c;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            K keyAt = keyAt(i2);
            if (keyAt != sb) {
                sb.append(keyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V valueAt = valueAt(i2);
            if (valueAt != sb) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        return AbstractC1726qj.m7060p(sb, '}', "StringBuilder(capacity).…builderAction).toString()");
    }

    public V valueAt(int index) {
        if (index >= 0 && index < this.f1755c) {
            return (V) this.f1754b[(index << 1) + 1];
        }
        throw new IllegalArgumentException(ye0.m8291k(index, "Expected index to be within 0..size()-1, but was ").toString());
    }

    @JvmOverloads
    public SimpleArrayMap(int i) {
        int[] iArr;
        Object[] objArr;
        if (i == 0) {
            iArr = ContainerHelpersKt.EMPTY_INTS;
        } else {
            iArr = new int[i];
        }
        this.f1753a = iArr;
        if (i == 0) {
            objArr = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            objArr = new Object[i << 1];
        }
        this.f1754b = objArr;
    }

    public boolean remove(K key, V value) {
        int indexOfKey = indexOfKey(key);
        if (indexOfKey < 0 || !Intrinsics.areEqual(value, valueAt(indexOfKey))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public boolean replace(K key, V oldValue, V newValue) {
        int indexOfKey = indexOfKey(key);
        if (indexOfKey < 0 || !Intrinsics.areEqual(oldValue, valueAt(indexOfKey))) {
            return false;
        }
        setValueAt(indexOfKey, newValue);
        return true;
    }

    public /* synthetic */ SimpleArrayMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public SimpleArrayMap(@Nullable SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this(0, 1, null);
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }
}
