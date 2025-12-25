package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;
import okhttp3.HttpUrl;
import p000.t21;

@Immutable
@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class ImmutableLongArray implements Serializable {

    /* renamed from: d */
    public static final ImmutableLongArray f15209d = new ImmutableLongArray(new long[0], 0, 0);

    /* renamed from: a */
    public final long[] f15210a;

    /* renamed from: b */
    public final transient int f15211b;

    /* renamed from: c */
    public final int f15212c;

    public ImmutableLongArray(long[] jArr) {
        this(jArr, 0, jArr.length);
    }

    public static Builder builder(int i) {
        Preconditions.checkArgument(i >= 0, "Invalid initialCapacity: %s", i);
        return new Builder(i);
    }

    public static ImmutableLongArray copyOf(long[] jArr) {
        if (jArr.length == 0) {
            return f15209d;
        }
        return new ImmutableLongArray(Arrays.copyOf(jArr, jArr.length));
    }

    /* renamed from: of */
    public static ImmutableLongArray m4264of() {
        return f15209d;
    }

    public List<Long> asList() {
        return new t21(this);
    }

    public boolean contains(long j) {
        if (indexOf(j) >= 0) {
            return true;
        }
        return false;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableLongArray)) {
            return false;
        }
        ImmutableLongArray immutableLongArray = (ImmutableLongArray) obj;
        if (length() != immutableLongArray.length()) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (get(i) != immutableLongArray.get(i)) {
                return false;
            }
        }
        return true;
    }

    public long get(int i) {
        Preconditions.checkElementIndex(i, length());
        return this.f15210a[this.f15211b + i];
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = this.f15211b; i2 < this.f15212c; i2++) {
            i = (i * 31) + Longs.hashCode(this.f15210a[i2]);
        }
        return i;
    }

    public int indexOf(long j) {
        int i = this.f15211b;
        for (int i2 = i; i2 < this.f15212c; i2++) {
            if (this.f15210a[i2] == j) {
                return i2 - i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (this.f15212c == this.f15211b) {
            return true;
        }
        return false;
    }

    public int lastIndexOf(long j) {
        int i;
        int i2 = this.f15212c;
        do {
            i2--;
            i = this.f15211b;
            if (i2 < i) {
                return -1;
            }
        } while (this.f15210a[i2] != j);
        return i2 - i;
    }

    public int length() {
        return this.f15212c - this.f15211b;
    }

    public Object readResolve() {
        if (isEmpty()) {
            return f15209d;
        }
        return this;
    }

    public ImmutableLongArray subArray(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, length());
        if (i == i2) {
            return f15209d;
        }
        int i3 = this.f15211b;
        return new ImmutableLongArray(this.f15210a, i + i3, i3 + i2);
    }

    public long[] toArray() {
        return Arrays.copyOfRange(this.f15210a, this.f15211b, this.f15212c);
    }

    public String toString() {
        if (isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(length() * 5);
        sb.append('[');
        long[] jArr = this.f15210a;
        int i = this.f15211b;
        sb.append(jArr[i]);
        while (true) {
            i++;
            if (i < this.f15212c) {
                sb.append(", ");
                sb.append(jArr[i]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }

    public ImmutableLongArray trimmed() {
        if (this.f15211b <= 0) {
            if (this.f15212c >= this.f15210a.length) {
                return this;
            }
        }
        return new ImmutableLongArray(toArray());
    }

    public Object writeReplace() {
        return trimmed();
    }

    public ImmutableLongArray(long[] jArr, int i, int i2) {
        this.f15210a = jArr;
        this.f15211b = i;
        this.f15212c = i2;
    }

    /* renamed from: of */
    public static ImmutableLongArray m4265of(long j) {
        return new ImmutableLongArray(new long[]{j}, 0, 1);
    }

    @CanIgnoreReturnValue
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a */
        public long[] f15213a;

        /* renamed from: b */
        public int f15214b = 0;

        public Builder(int i) {
            this.f15213a = new long[i];
        }

        /* renamed from: a */
        public final void m4272a(int i) {
            int i2 = this.f15214b + i;
            long[] jArr = this.f15213a;
            if (i2 > jArr.length) {
                int length = jArr.length;
                if (i2 >= 0) {
                    int i3 = length + (length >> 1) + 1;
                    if (i3 < i2) {
                        i3 = Integer.highestOneBit(i2 - 1) << 1;
                    }
                    if (i3 < 0) {
                        i3 = Integer.MAX_VALUE;
                    }
                    this.f15213a = Arrays.copyOf(jArr, i3);
                    return;
                }
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
        }

        public Builder add(long j) {
            m4272a(1);
            long[] jArr = this.f15213a;
            int i = this.f15214b;
            jArr[i] = j;
            this.f15214b = i + 1;
            return this;
        }

        public Builder addAll(long[] jArr) {
            m4272a(jArr.length);
            System.arraycopy(jArr, 0, this.f15213a, this.f15214b, jArr.length);
            this.f15214b += jArr.length;
            return this;
        }

        @CheckReturnValue
        public ImmutableLongArray build() {
            int i = this.f15214b;
            if (i == 0) {
                return ImmutableLongArray.f15209d;
            }
            return new ImmutableLongArray(this.f15213a, 0, i);
        }

        public Builder addAll(Iterable<Long> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection<Long>) iterable);
            }
            Iterator<Long> it = iterable.iterator();
            while (it.hasNext()) {
                add(it.next().longValue());
            }
            return this;
        }

        public Builder addAll(Collection<Long> collection) {
            m4272a(collection.size());
            for (Long l : collection) {
                long[] jArr = this.f15213a;
                int i = this.f15214b;
                this.f15214b = i + 1;
                jArr[i] = l.longValue();
            }
            return this;
        }

        public Builder addAll(ImmutableLongArray immutableLongArray) {
            m4272a(immutableLongArray.length());
            System.arraycopy(immutableLongArray.f15210a, immutableLongArray.f15211b, this.f15213a, this.f15214b, immutableLongArray.length());
            this.f15214b = immutableLongArray.length() + this.f15214b;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder(10);
    }

    public static ImmutableLongArray copyOf(Collection<Long> collection) {
        return collection.isEmpty() ? f15209d : new ImmutableLongArray(Longs.toArray(collection));
    }

    /* renamed from: of */
    public static ImmutableLongArray m4266of(long j, long j2) {
        return new ImmutableLongArray(new long[]{j, j2}, 0, 2);
    }

    public static ImmutableLongArray copyOf(Iterable<Long> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Long>) iterable);
        }
        return builder().addAll(iterable).build();
    }

    /* renamed from: of */
    public static ImmutableLongArray m4267of(long j, long j2, long j3) {
        return new ImmutableLongArray(new long[]{j, j2, j3}, 0, 3);
    }

    /* renamed from: of */
    public static ImmutableLongArray m4268of(long j, long j2, long j3, long j4) {
        return new ImmutableLongArray(new long[]{j, j2, j3, j4}, 0, 4);
    }

    /* renamed from: of */
    public static ImmutableLongArray m4269of(long j, long j2, long j3, long j4, long j5) {
        return new ImmutableLongArray(new long[]{j, j2, j3, j4, j5}, 0, 5);
    }

    /* renamed from: of */
    public static ImmutableLongArray m4270of(long j, long j2, long j3, long j4, long j5, long j6) {
        return new ImmutableLongArray(new long[]{j, j2, j3, j4, j5, j6}, 0, 6);
    }

    /* renamed from: of */
    public static ImmutableLongArray m4271of(long j, long... jArr) {
        Preconditions.checkArgument(jArr.length <= 2147483646, "the total number of elements must fit in an int");
        int length = jArr.length + 1;
        long[] jArr2 = new long[length];
        jArr2[0] = j;
        System.arraycopy(jArr, 0, jArr2, 1, jArr.length);
        return new ImmutableLongArray(jArr2, 0, length);
    }
}
