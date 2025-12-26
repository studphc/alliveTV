package p000;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.collections.AbstractIterator;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import p000.rc2;

/* loaded from: classes2.dex */
public final class rc2 extends AbstractList implements RandomAccess {

    /* renamed from: a */
    public final Object[] f25928a;

    /* renamed from: b */
    public final int f25929b;

    /* renamed from: c */
    public int f25930c;

    /* renamed from: d */
    public int f25931d;

    public rc2(int i, Object[] buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.f25928a = buffer;
        if (i >= 0) {
            if (i <= buffer.length) {
                this.f25929b = buffer.length;
                this.f25931d = i;
                return;
            } else {
                StringBuilder m8299s = ye0.m8299s(i, "ring buffer filled size: ", " cannot be larger than the buffer size: ");
                m8299s.append(buffer.length);
                throw new IllegalArgumentException(m8299s.toString().toString());
            }
        }
        throw new IllegalArgumentException(ye0.m8291k(i, "ring buffer filled size should not be negative but it is ").toString());
    }

    /* renamed from: a */
    public final void m7267a(int i) {
        if (i >= 0) {
            if (i <= size()) {
                if (i > 0) {
                    int i2 = this.f25930c;
                    int i3 = this.f25929b;
                    int i4 = (i2 + i) % i3;
                    Object[] objArr = this.f25928a;
                    if (i2 > i4) {
                        ArraysKt___ArraysJvmKt.fill(objArr, (Object) null, i2, i3);
                        ArraysKt___ArraysJvmKt.fill(objArr, (Object) null, 0, i4);
                    } else {
                        ArraysKt___ArraysJvmKt.fill(objArr, (Object) null, i2, i4);
                    }
                    this.f25930c = i4;
                    this.f25931d = size() - i;
                    return;
                }
                return;
            }
            StringBuilder m8299s = ye0.m8299s(i, "n shouldn't be greater than the buffer size: n = ", ", size = ");
            m8299s.append(size());
            throw new IllegalArgumentException(m8299s.toString().toString());
        }
        throw new IllegalArgumentException(ye0.m8291k(i, "n shouldn't be negative but it is ").toString());
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final Object get(int i) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(i, size());
        return this.f25928a[(this.f25930c + i) % this.f25929b];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public final int getF21007c() {
        return this.f25931d;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new AbstractIterator<Object>() { // from class: kotlin.collections.RingBuffer$iterator$1

            /* renamed from: c */
            public int f21008c;

            /* renamed from: d */
            public int f21009d;

            {
                this.f21008c = rc2.this.size();
                this.f21009d = rc2.this.f25930c;
            }

            @Override // kotlin.collections.AbstractIterator
            public void computeNext() {
                if (this.f21008c == 0) {
                    done();
                    return;
                }
                rc2 rc2Var = rc2.this;
                setNext(rc2Var.f25928a[this.f21009d]);
                this.f21009d = (this.f21009d + 1) % rc2Var.f25929b;
                this.f21008c--;
            }
        };
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] array) {
        Object[] objArr;
        Intrinsics.checkNotNullParameter(array, "array");
        if (array.length < size()) {
            array = Arrays.copyOf(array, size());
            Intrinsics.checkNotNullExpressionValue(array, "copyOf(this, newSize)");
        }
        int size = size();
        int i = this.f25930c;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            objArr = this.f25928a;
            if (i3 >= size || i >= this.f25929b) {
                break;
            }
            array[i3] = objArr[i];
            i3++;
            i++;
        }
        while (i3 < size) {
            array[i3] = objArr[i2];
            i3++;
            i2++;
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
