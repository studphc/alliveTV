package kotlin.collections.builders;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.h91;

@Metadata(m5568d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00060\u0006j\u0002`\u0007:\u0001GB\t\b\u0016¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\b\u0010\fJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\nH\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016¢\u0006\u0004\b \u0010!J\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001f2\u0006\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b \u0010\"J\u0017\u0010#\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0004\b#\u0010$J\u001f\u0010#\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0004\b#\u0010&J\u001d\u0010)\u001a\u00020\u00102\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0016¢\u0006\u0004\b)\u0010*J%\u0010)\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\n2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0016¢\u0006\u0004\b)\u0010+J\u000f\u0010,\u001a\u00020%H\u0016¢\u0006\u0004\b,\u0010\tJ\u0017\u0010-\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0004\b-\u0010\u0015J\u0017\u0010.\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0004\b.\u0010$J\u001d\u0010/\u001a\u00020\u00102\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0016¢\u0006\u0004\b/\u0010*J\u001d\u00100\u001a\u00020\u00102\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'H\u0016¢\u0006\u0004\b0\u0010*J%\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\nH\u0016¢\u0006\u0004\b3\u00104J)\u00108\u001a\b\u0012\u0004\u0012\u00028\u000106\"\u0004\b\u0001\u001052\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u000106H\u0016¢\u0006\u0004\b8\u00109J\u0017\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:06H\u0016¢\u0006\u0004\b8\u0010;J\u001a\u0010=\u001a\u00020\u00102\b\u0010<\u001a\u0004\u0018\u00010:H\u0096\u0002¢\u0006\u0004\b=\u0010$J\u000f\u0010>\u001a\u00020\nH\u0016¢\u0006\u0004\b>\u0010?J\u000f\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020:H\u0002¢\u0006\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010?¨\u0006H"}, m5569d2 = {"Lkotlin/collections/builders/ListBuilder;", ExifInterface.LONGITUDE_EAST, "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "", "initialCapacity", "(I)V", "", "build", "()Ljava/util/List;", "", "isEmpty", "()Z", FirebaseAnalytics.Param.INDEX, "get", "(I)Ljava/lang/Object;", "element", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "", "iterator", "()Ljava/util/Iterator;", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "add", "(Ljava/lang/Object;)Z", "", "(ILjava/lang/Object;)V", "", "elements", "addAll", "(Ljava/util/Collection;)Z", "(ILjava/util/Collection;)Z", "clear", "removeAt", "remove", "removeAll", "retainAll", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", ExifInterface.GPS_DIRECTION_TRUE, "", FirebaseAnalytics.Param.DESTINATION, "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "()[Ljava/lang/Object;", "other", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "writeReplace", "()Ljava/lang/Object;", "getSize", "size", "h91", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {

    /* renamed from: a */
    public Object[] f21016a;

    /* renamed from: b */
    public final int f21017b;

    /* renamed from: c */
    public int f21018c;

    /* renamed from: d */
    public boolean f21019d;

    /* renamed from: e */
    public final ListBuilder f21020e;

    /* renamed from: f */
    public final ListBuilder f21021f;

    public ListBuilder(Object[] objArr, int i, int i2, boolean z, ListBuilder listBuilder, ListBuilder listBuilder2) {
        this.f21016a = objArr;
        this.f21017b = i;
        this.f21018c = i2;
        this.f21019d = z;
        this.f21020e = listBuilder;
        this.f21021f = listBuilder2;
    }

    private final Object writeReplace() {
        ListBuilder listBuilder;
        if (!this.f21019d && ((listBuilder = this.f21021f) == null || !listBuilder.f21019d)) {
            throw new NotSerializableException("The list cannot be serialized while it is being built.");
        }
        return new SerializedCollection(this, 0);
    }

    /* renamed from: a */
    public final void m5586a(int i, Collection collection, int i2) {
        ListBuilder listBuilder = this.f21020e;
        if (listBuilder != null) {
            listBuilder.m5586a(i, collection, i2);
            this.f21016a = listBuilder.f21016a;
            this.f21018c += i2;
        } else {
            m5589f(i, i2);
            Iterator<E> it = collection.iterator();
            for (int i3 = 0; i3 < i2; i3++) {
                this.f21016a[i + i3] = it.next();
            }
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E element) {
        m5588e();
        m5587c(this.f21017b + this.f21018c, element);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        m5588e();
        int size = elements.size();
        m5586a(this.f21017b + this.f21018c, elements, size);
        return size > 0;
    }

    @NotNull
    public final List<E> build() {
        if (this.f21020e == null) {
            m5588e();
            this.f21019d = true;
            return this;
        }
        throw new IllegalStateException();
    }

    /* renamed from: c */
    public final void m5587c(int i, Object obj) {
        ListBuilder listBuilder = this.f21020e;
        if (listBuilder != null) {
            listBuilder.m5587c(i, obj);
            this.f21016a = listBuilder.f21016a;
            this.f21018c++;
        } else {
            m5589f(i, 1);
            this.f21016a[i] = obj;
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        m5588e();
        m5591h(this.f21017b, this.f21018c);
    }

    /* renamed from: e */
    public final void m5588e() {
        ListBuilder listBuilder;
        if (!this.f21019d && ((listBuilder = this.f21021f) == null || !listBuilder.f21019d)) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(@Nullable Object other) {
        if (other != this) {
            if (other instanceof List) {
                if (ListBuilderKt.access$subarrayContentEquals(this.f21016a, this.f21017b, this.f21018c, (List) other)) {
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public final void m5589f(int i, int i2) {
        int i3 = this.f21018c + i2;
        if (this.f21020e == null) {
            if (i3 >= 0) {
                Object[] objArr = this.f21016a;
                if (i3 > objArr.length) {
                    this.f21016a = ListBuilderKt.copyOfUninitializedElements(this.f21016a, ArrayDeque.INSTANCE.newCapacity$kotlin_stdlib(objArr.length, i3));
                }
                Object[] objArr2 = this.f21016a;
                ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, i + i2, i, this.f21017b + this.f21018c);
                this.f21018c += i2;
                return;
            }
            throw new OutOfMemoryError();
        }
        throw new IllegalStateException();
    }

    /* renamed from: g */
    public final Object m5590g(int i) {
        ListBuilder listBuilder = this.f21020e;
        if (listBuilder != null) {
            this.f21018c--;
            return listBuilder.m5590g(i);
        }
        Object[] objArr = this.f21016a;
        Object obj = objArr[i];
        ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i, i + 1, this.f21018c + this.f21017b);
        ListBuilderKt.resetAt(this.f21016a, (r4 + this.f21018c) - 1);
        this.f21018c--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, this.f21018c);
        return (E) this.f21016a[this.f21017b + index];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.f21018c;
    }

    /* renamed from: h */
    public final void m5591h(int i, int i2) {
        ListBuilder listBuilder = this.f21020e;
        if (listBuilder != null) {
            listBuilder.m5591h(i, i2);
        } else {
            Object[] objArr = this.f21016a;
            ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i, i + i2, this.f21018c);
            Object[] objArr2 = this.f21016a;
            int i3 = this.f21018c;
            ListBuilderKt.resetRange(objArr2, i3 - i2, i3);
        }
        this.f21018c -= i2;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return ListBuilderKt.access$subarrayContentHashCode(this.f21016a, this.f21017b, this.f21018c);
    }

    /* renamed from: i */
    public final int m5592i(int i, int i2, Collection collection, boolean z) {
        ListBuilder listBuilder = this.f21020e;
        if (listBuilder != null) {
            int m5592i = listBuilder.m5592i(i, i2, collection, z);
            this.f21018c -= m5592i;
            return m5592i;
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i + i3;
            if (collection.contains(this.f21016a[i5]) == z) {
                Object[] objArr = this.f21016a;
                i3++;
                objArr[i4 + i] = objArr[i5];
                i4++;
            } else {
                i3++;
            }
        }
        int i6 = i2 - i4;
        Object[] objArr2 = this.f21016a;
        ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, i + i4, i2 + i, this.f21018c);
        Object[] objArr3 = this.f21016a;
        int i7 = this.f21018c;
        ListBuilderKt.resetRange(objArr3, i7 - i6, i7);
        this.f21018c -= i6;
        return i6;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        for (int i = 0; i < this.f21018c; i++) {
            if (Intrinsics.areEqual(this.f21016a[this.f21017b + i], element)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (this.f21018c == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<E> iterator() {
        return new h91(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object element) {
        for (int i = this.f21018c - 1; i >= 0; i--) {
            if (Intrinsics.areEqual(this.f21016a[this.f21017b + i], element)) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator() {
        return new h91(this, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object element) {
        m5588e();
        int indexOf = indexOf(element);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        if (indexOf >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        m5588e();
        if (m5592i(this.f21017b, this.f21018c, elements, false) <= 0) {
            return false;
        }
        return true;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int index) {
        m5588e();
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, this.f21018c);
        return (E) m5590g(this.f21017b + index);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        m5588e();
        if (m5592i(this.f21017b, this.f21018c, elements, true) > 0) {
            return true;
        }
        return false;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        m5588e();
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, this.f21018c);
        Object[] objArr = this.f21016a;
        int i = this.f21017b;
        E e = (E) objArr[i + index];
        objArr[i + index] = element;
        return e;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public List<E> subList(int fromIndex, int toIndex) {
        ListBuilder<E> listBuilder;
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, this.f21018c);
        Object[] objArr = this.f21016a;
        int i = this.f21017b + fromIndex;
        int i2 = toIndex - fromIndex;
        boolean z = this.f21019d;
        ListBuilder<E> listBuilder2 = this.f21021f;
        if (listBuilder2 == null) {
            listBuilder = this;
        } else {
            listBuilder = listBuilder2;
        }
        return new ListBuilder(objArr, i, i2, z, this, listBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public <T> T[] toArray(@NotNull T[] destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        int length = destination.length;
        int i = this.f21018c;
        int i2 = this.f21017b;
        if (length < i) {
            T[] tArr = (T[]) Arrays.copyOfRange(this.f21016a, i2, i + i2, destination.getClass());
            Intrinsics.checkNotNullExpressionValue(tArr, "copyOfRange(array, offse…h, destination.javaClass)");
            return tArr;
        }
        ArraysKt___ArraysJvmKt.copyInto(this.f21016a, destination, 0, i2, i + i2);
        int length2 = destination.length;
        int i3 = this.f21018c;
        if (length2 > i3) {
            destination[i3] = null;
        }
        return destination;
    }

    @Override // java.util.AbstractCollection
    @NotNull
    public String toString() {
        return ListBuilderKt.access$subarrayContentToString(this.f21016a, this.f21017b, this.f21018c);
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator(int index) {
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, this.f21018c);
        return new h91(this, index);
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        m5588e();
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, this.f21018c);
        m5587c(this.f21017b + index, element);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, @NotNull Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        m5588e();
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, this.f21018c);
        int size = elements.size();
        m5586a(this.f21017b + index, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public Object[] toArray() {
        Object[] objArr = this.f21016a;
        int i = this.f21018c;
        int i2 = this.f21017b;
        return ArraysKt___ArraysJvmKt.copyOfRange(objArr, i2, i + i2);
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i) {
        this(ListBuilderKt.arrayOfUninitializedElements(i), 0, 0, false, null, null);
    }
}
