package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1726qj;
import p000.C1189fb;

@Metadata(m5568d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0010#\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0014\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001LB\u0013\b\u0007\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0004\b\u0006\u0010\tB\u0019\b\u0016\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bB\u001b\b\u0016\u0012\u0010\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\f¢\u0006\u0004\b\u0006\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0007J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b!\u0010\u0017J\u001d\u0010\"\u001a\u00020\u000f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000¢\u0006\u0004\b\"\u0010\tJ\u0017\u0010#\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b#\u0010\u0017J\u0015\u0010$\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b$\u0010\u001eJ\u001d\u0010%\u001a\u00020\u00152\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000¢\u0006\u0004\b%\u0010&J\u0015\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\f¢\u0006\u0004\b'\u0010(J'\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\f\"\u0004\b\u0001\u0010)2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\f¢\u0006\u0004\b'\u0010*J\u001a\u0010,\u001a\u00020\u00152\b\u0010+\u001a\u0004\u0018\u00010\u0018H\u0096\u0002¢\u0006\u0004\b,\u0010\u0017J\u000f\u0010-\u001a\u00020\u0004H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b0\u00101J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00028\u000002H\u0096\u0002¢\u0006\u0004\b3\u00104J\u001d\u00106\u001a\u00020\u00152\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¢\u0006\u0004\b6\u00107J\u001d\u0010\"\u001a\u00020\u00152\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¢\u0006\u0004\b\"\u00107J\u001d\u0010%\u001a\u00020\u00152\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¢\u0006\u0004\b%\u00107J\u001d\u00108\u001a\u00020\u00152\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¢\u0006\u0004\b8\u00107R\"\u0010@\u001a\u0002098\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R*\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010(\"\u0004\bD\u0010\u000eR\"\u0010I\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010.\"\u0004\bH\u0010\u0007R\u0014\u0010K\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010.¨\u0006M"}, m5569d2 = {"Landroidx/collection/ArraySet;", ExifInterface.LONGITUDE_EAST, "", "", "", "capacity", "<init>", "(I)V", "set", "(Landroidx/collection/ArraySet;)V", "", "(Ljava/util/Collection;)V", "", "array", "([Ljava/lang/Object;)V", "", "clear", "()V", "minimumCapacity", "ensureCapacity", "element", "", "contains", "(Ljava/lang/Object;)Z", "", "key", "indexOf", "(Ljava/lang/Object;)I", FirebaseAnalytics.Param.INDEX, "valueAt", "(I)Ljava/lang/Object;", "isEmpty", "()Z", "add", "addAll", "remove", "removeAt", "removeAll", "(Landroidx/collection/ArraySet;)Z", "toArray", "()[Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "([Ljava/lang/Object;)[Ljava/lang/Object;", "other", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "iterator", "()Ljava/util/Iterator;", "elements", "containsAll", "(Ljava/util/Collection;)Z", "retainAll", "", "a", "[I", "getHashes$collection", "()[I", "setHashes$collection", "([I)V", "hashes", "b", "[Ljava/lang/Object;", "getArray$collection", "setArray$collection", "c", "I", "get_size$collection", "set_size$collection", "_size", "getSize", "size", "fb", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nArraySet.jvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArraySet.jvm.kt\nandroidx/collection/ArraySet\n+ 2 ArraySet.kt\nandroidx/collection/ArraySetKt\n*L\n1#1,300:1\n304#2,10:301\n317#2,14:311\n334#2:325\n339#2:326\n345#2:327\n350#2:328\n355#2,61:329\n420#2,17:390\n440#2,6:407\n450#2,60:413\n518#2,9:473\n531#2,22:482\n557#2,7:504\n568#2,19:511\n591#2,6:530\n601#2,6:536\n611#2,5:542\n620#2,8:547\n*S KotlinDebug\n*F\n+ 1 ArraySet.jvm.kt\nandroidx/collection/ArraySet\n*L\n98#1:301,10\n108#1:311,14\n118#1:325\n128#1:326\n138#1:327\n145#1:328\n157#1:329,61\n167#1:390,17\n177#1:407,6\n188#1:413,60\n197#1:473,9\n224#1:482,22\n231#1:504,7\n240#1:511,19\n267#1:530,6\n276#1:536,6\n286#1:542,5\n297#1:547,8\n*E\n"})
/* loaded from: classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E>, KMutableCollection, KMutableSet {

    /* renamed from: a, reason: from kotlin metadata */
    public int[] hashes;

    /* renamed from: b, reason: from kotlin metadata */
    public Object[] array;

    /* renamed from: c, reason: from kotlin metadata */
    public int _size;

    @JvmOverloads
    public ArraySet() {
        this(0, 1, null);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E element) {
        int i;
        int indexOf;
        int i2 = get_size$collection();
        boolean z = false;
        if (element == null) {
            indexOf = ArraySetKt.indexOfNull(this);
            i = 0;
        } else {
            int hashCode = element.hashCode();
            i = hashCode;
            indexOf = ArraySetKt.indexOf(this, element, hashCode);
        }
        if (indexOf >= 0) {
            return false;
        }
        int i3 = ~indexOf;
        if (i2 >= getHashes().length) {
            int i4 = 8;
            if (i2 >= 8) {
                i4 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i4 = 4;
            }
            int[] hashes = getHashes();
            Object[] array = getArray();
            ArraySetKt.allocArrays(this, i4);
            if (i2 == get_size$collection()) {
                if (getHashes().length == 0) {
                    z = true;
                }
                if (!z) {
                    ArraysKt___ArraysJvmKt.copyInto$default(hashes, getHashes(), 0, 0, hashes.length, 6, (Object) null);
                    ArraysKt___ArraysJvmKt.copyInto$default(array, getArray(), 0, 0, array.length, 6, (Object) null);
                }
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i3 < i2) {
            int i5 = i3 + 1;
            ArraysKt___ArraysJvmKt.copyInto(getHashes(), getHashes(), i5, i3, i2);
            ArraysKt___ArraysJvmKt.copyInto(getArray(), getArray(), i5, i3, i2);
        }
        if (i2 == get_size$collection() && i3 < getHashes().length) {
            getHashes()[i3] = i;
            getArray()[i3] = element;
            set_size$collection(get_size$collection() + 1);
            return true;
        }
        throw new ConcurrentModificationException();
    }

    public final void addAll(@NotNull ArraySet<? extends E> array) {
        Intrinsics.checkNotNullParameter(array, "array");
        int i = array.get_size$collection();
        ensureCapacity(get_size$collection() + i);
        if (get_size$collection() != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                add(array.valueAt(i2));
            }
            return;
        }
        if (i > 0) {
            ArraysKt___ArraysJvmKt.copyInto$default(array.getHashes(), getHashes(), 0, 0, i, 6, (Object) null);
            ArraysKt___ArraysJvmKt.copyInto$default(array.getArray(), getArray(), 0, 0, i, 6, (Object) null);
            if (get_size$collection() == 0) {
                set_size$collection(i);
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (get_size$collection() != 0) {
            setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            set_size$collection(0);
        }
        if (get_size$collection() == 0) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object element) {
        if (indexOf(element) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void ensureCapacity(int minimumCapacity) {
        int i = get_size$collection();
        if (getHashes().length < minimumCapacity) {
            int[] hashes = getHashes();
            Object[] array = getArray();
            ArraySetKt.allocArrays(this, minimumCapacity);
            if (get_size$collection() > 0) {
                ArraysKt___ArraysJvmKt.copyInto$default(hashes, getHashes(), 0, 0, get_size$collection(), 6, (Object) null);
                ArraysKt___ArraysJvmKt.copyInto$default(array, getArray(), 0, 0, get_size$collection(), 6, (Object) null);
            }
        }
        if (get_size$collection() == i) {
        } else {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof Set) && size() == ((Set) other).size()) {
            try {
                int i = get_size$collection();
                for (int i2 = 0; i2 < i; i2++) {
                    if (((Set) other).contains(valueAt(i2))) {
                    }
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @NotNull
    /* renamed from: getArray$collection, reason: from getter */
    public final Object[] getArray() {
        return this.array;
    }

    @NotNull
    /* renamed from: getHashes$collection, reason: from getter */
    public final int[] getHashes() {
        return this.hashes;
    }

    /* renamed from: getSize, reason: from getter */
    public int get_size() {
        return this._size;
    }

    public final int get_size$collection() {
        return this._size;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] hashes = getHashes();
        int i = get_size$collection();
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += hashes[i3];
        }
        return i2;
    }

    public final int indexOf(@Nullable Object key) {
        if (key == null) {
            return ArraySetKt.indexOfNull(this);
        }
        return ArraySetKt.indexOf(this, key, key.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (get_size$collection() <= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    @NotNull
    public Iterator<E> iterator() {
        return new C1189fb(this);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object element) {
        int indexOf = indexOf(element);
        if (indexOf >= 0) {
            removeAt(indexOf);
            return true;
        }
        return false;
    }

    public final boolean removeAll(@NotNull ArraySet<? extends E> array) {
        Intrinsics.checkNotNullParameter(array, "array");
        int i = array.get_size$collection();
        int i2 = get_size$collection();
        for (int i3 = 0; i3 < i; i3++) {
            remove(array.valueAt(i3));
        }
        return i2 != get_size$collection();
    }

    public final E removeAt(int index) {
        int i = get_size$collection();
        E e = (E) getArray()[index];
        if (i <= 1) {
            clear();
        } else {
            int i2 = i - 1;
            int i3 = 8;
            if (getHashes().length > 8 && get_size$collection() < getHashes().length / 3) {
                if (get_size$collection() > 8) {
                    i3 = get_size$collection() + (get_size$collection() >> 1);
                }
                int[] hashes = getHashes();
                Object[] array = getArray();
                ArraySetKt.allocArrays(this, i3);
                if (index > 0) {
                    ArraysKt___ArraysJvmKt.copyInto$default(hashes, getHashes(), 0, 0, index, 6, (Object) null);
                    ArraysKt___ArraysJvmKt.copyInto$default(array, getArray(), 0, 0, index, 6, (Object) null);
                }
                if (index < i2) {
                    int i4 = index + 1;
                    ArraysKt___ArraysJvmKt.copyInto(hashes, getHashes(), index, i4, i);
                    ArraysKt___ArraysJvmKt.copyInto(array, getArray(), index, i4, i);
                }
            } else {
                if (index < i2) {
                    int i5 = index + 1;
                    ArraysKt___ArraysJvmKt.copyInto(getHashes(), getHashes(), index, i5, i);
                    ArraysKt___ArraysJvmKt.copyInto(getArray(), getArray(), index, i5, i);
                }
                getArray()[i2] = null;
            }
            if (i == get_size$collection()) {
                set_size$collection(i2);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        for (int i = get_size$collection() - 1; -1 < i; i--) {
            if (!CollectionsKt___CollectionsKt.contains(elements, getArray()[i])) {
                removeAt(i);
                z = true;
            }
        }
        return z;
    }

    public final void setArray$collection(@NotNull Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.array = objArr;
    }

    public final void setHashes$collection(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.hashes = iArr;
    }

    public final void set_size$collection(int i) {
        this._size = i;
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return get_size();
    }

    @Override // java.util.Collection, java.util.Set
    @NotNull
    public final Object[] toArray() {
        return ArraysKt___ArraysJvmKt.copyOfRange(this.array, 0, this._size);
    }

    @NotNull
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(get_size$collection() * 14);
        sb.append('{');
        int i = get_size$collection();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            E valueAt = valueAt(i2);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        return AbstractC1726qj.m7060p(sb, '}', "StringBuilder(capacity).…builderAction).toString()");
    }

    public final E valueAt(int index) {
        return (E) getArray()[index];
    }

    @JvmOverloads
    public ArraySet(int i) {
        this.hashes = ContainerHelpersKt.EMPTY_INTS;
        this.array = ContainerHelpersKt.EMPTY_OBJECTS;
        if (i > 0) {
            ArraySetKt.allocArrays(this, i);
        }
    }

    @Override // java.util.Collection, java.util.Set
    @NotNull
    public final <T> T[] toArray(@NotNull T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        int i = this._size;
        if (array.length < i) {
            array = (T[]) ((Object[]) Array.newInstance(array.getClass().getComponentType(), i));
        } else if (array.length > i) {
            array[i] = null;
        }
        ArraysKt___ArraysJvmKt.copyInto(this.array, array, 0, 0, this._size);
        T[] result = array;
        Intrinsics.checkNotNullExpressionValue(result, "result");
        return array;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    public /* synthetic */ ArraySet(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public ArraySet(@Nullable ArraySet<? extends E> arraySet) {
        this(0);
        if (arraySet != null) {
            addAll((ArraySet) arraySet);
        }
    }

    public ArraySet(@Nullable Collection<? extends E> collection) {
        this(0);
        if (collection != null) {
            addAll(collection);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        ensureCapacity(elements.size() + get_size$collection());
        Iterator<? extends E> it = elements.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(@Nullable E[] eArr) {
        this(0);
        if (eArr != null) {
            Iterator it = ArrayIteratorKt.iterator(eArr);
            while (it.hasNext()) {
                add(it.next());
            }
        }
    }
}
