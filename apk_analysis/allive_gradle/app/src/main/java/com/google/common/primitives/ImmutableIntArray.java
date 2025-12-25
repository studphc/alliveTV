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
import p000.p21;

@Immutable
@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class ImmutableIntArray implements Serializable {

    /* renamed from: d */
    public static final ImmutableIntArray f15203d = new ImmutableIntArray(0, 0, new int[0]);

    /* renamed from: a */
    public final int[] f15204a;

    /* renamed from: b */
    public final transient int f15205b;

    /* renamed from: c */
    public final int f15206c;

    public ImmutableIntArray(int[] iArr) {
        this(0, iArr.length, iArr);
    }

    public static Builder builder(int i) {
        Preconditions.checkArgument(i >= 0, "Invalid initialCapacity: %s", i);
        return new Builder(i);
    }

    public static ImmutableIntArray copyOf(int[] iArr) {
        return iArr.length == 0 ? f15203d : new ImmutableIntArray(Arrays.copyOf(iArr, iArr.length));
    }

    /* renamed from: of */
    public static ImmutableIntArray m4255of() {
        return f15203d;
    }

    public List<Integer> asList() {
        return new p21(this);
    }

    public boolean contains(int i) {
        if (indexOf(i) >= 0) {
            return true;
        }
        return false;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableIntArray)) {
            return false;
        }
        ImmutableIntArray immutableIntArray = (ImmutableIntArray) obj;
        if (length() != immutableIntArray.length()) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (get(i) != immutableIntArray.get(i)) {
                return false;
            }
        }
        return true;
    }

    public int get(int i) {
        Preconditions.checkElementIndex(i, length());
        return this.f15204a[this.f15205b + i];
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = this.f15205b; i2 < this.f15206c; i2++) {
            i = (i * 31) + Ints.hashCode(this.f15204a[i2]);
        }
        return i;
    }

    public int indexOf(int i) {
        int i2 = this.f15205b;
        for (int i3 = i2; i3 < this.f15206c; i3++) {
            if (this.f15204a[i3] == i) {
                return i3 - i2;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (this.f15206c == this.f15205b) {
            return true;
        }
        return false;
    }

    public int lastIndexOf(int i) {
        int i2;
        int i3 = this.f15206c;
        do {
            i3--;
            i2 = this.f15205b;
            if (i3 < i2) {
                return -1;
            }
        } while (this.f15204a[i3] != i);
        return i3 - i2;
    }

    public int length() {
        return this.f15206c - this.f15205b;
    }

    public Object readResolve() {
        if (isEmpty()) {
            return f15203d;
        }
        return this;
    }

    public ImmutableIntArray subArray(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, length());
        if (i == i2) {
            return f15203d;
        }
        int i3 = this.f15205b;
        return new ImmutableIntArray(i + i3, i3 + i2, this.f15204a);
    }

    public int[] toArray() {
        return Arrays.copyOfRange(this.f15204a, this.f15205b, this.f15206c);
    }

    public String toString() {
        if (isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(length() * 5);
        sb.append('[');
        int[] iArr = this.f15204a;
        int i = this.f15205b;
        sb.append(iArr[i]);
        while (true) {
            i++;
            if (i < this.f15206c) {
                sb.append(", ");
                sb.append(iArr[i]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }

    public ImmutableIntArray trimmed() {
        if (this.f15205b <= 0) {
            if (this.f15206c >= this.f15204a.length) {
                return this;
            }
        }
        return new ImmutableIntArray(toArray());
    }

    public Object writeReplace() {
        return trimmed();
    }

    public ImmutableIntArray(int i, int i2, int[] iArr) {
        this.f15204a = iArr;
        this.f15205b = i;
        this.f15206c = i2;
    }

    public static ImmutableIntArray copyOf(Collection<Integer> collection) {
        return collection.isEmpty() ? f15203d : new ImmutableIntArray(Ints.toArray(collection));
    }

    /* renamed from: of */
    public static ImmutableIntArray m4256of(int i) {
        return new ImmutableIntArray(0, 1, new int[]{i});
    }

    @CanIgnoreReturnValue
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a */
        public int[] f15207a;

        /* renamed from: b */
        public int f15208b = 0;

        public Builder(int i) {
            this.f15207a = new int[i];
        }

        /* renamed from: a */
        public final void m4263a(int i) {
            int i2 = this.f15208b + i;
            int[] iArr = this.f15207a;
            if (i2 > iArr.length) {
                int length = iArr.length;
                if (i2 >= 0) {
                    int i3 = length + (length >> 1) + 1;
                    if (i3 < i2) {
                        i3 = Integer.highestOneBit(i2 - 1) << 1;
                    }
                    if (i3 < 0) {
                        i3 = Integer.MAX_VALUE;
                    }
                    this.f15207a = Arrays.copyOf(iArr, i3);
                    return;
                }
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
        }

        public Builder add(int i) {
            m4263a(1);
            int[] iArr = this.f15207a;
            int i2 = this.f15208b;
            iArr[i2] = i;
            this.f15208b = i2 + 1;
            return this;
        }

        public Builder addAll(int[] iArr) {
            m4263a(iArr.length);
            System.arraycopy(iArr, 0, this.f15207a, this.f15208b, iArr.length);
            this.f15208b += iArr.length;
            return this;
        }

        @CheckReturnValue
        public ImmutableIntArray build() {
            int i = this.f15208b;
            if (i == 0) {
                return ImmutableIntArray.f15203d;
            }
            return new ImmutableIntArray(0, i, this.f15207a);
        }

        public Builder addAll(Iterable<Integer> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection<Integer>) iterable);
            }
            Iterator<Integer> it = iterable.iterator();
            while (it.hasNext()) {
                add(it.next().intValue());
            }
            return this;
        }

        public Builder addAll(Collection<Integer> collection) {
            m4263a(collection.size());
            for (Integer num : collection) {
                int[] iArr = this.f15207a;
                int i = this.f15208b;
                this.f15208b = i + 1;
                iArr[i] = num.intValue();
            }
            return this;
        }

        public Builder addAll(ImmutableIntArray immutableIntArray) {
            m4263a(immutableIntArray.length());
            System.arraycopy(immutableIntArray.f15204a, immutableIntArray.f15205b, this.f15207a, this.f15208b, immutableIntArray.length());
            this.f15208b = immutableIntArray.length() + this.f15208b;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder(10);
    }

    public static ImmutableIntArray copyOf(Iterable<Integer> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Integer>) iterable);
        }
        return builder().addAll(iterable).build();
    }

    /* renamed from: of */
    public static ImmutableIntArray m4257of(int i, int i2) {
        return new ImmutableIntArray(0, 2, new int[]{i, i2});
    }

    /* renamed from: of */
    public static ImmutableIntArray m4258of(int i, int i2, int i3) {
        return new ImmutableIntArray(0, 3, new int[]{i, i2, i3});
    }

    /* renamed from: of */
    public static ImmutableIntArray m4259of(int i, int i2, int i3, int i4) {
        return new ImmutableIntArray(0, 4, new int[]{i, i2, i3, i4});
    }

    /* renamed from: of */
    public static ImmutableIntArray m4260of(int i, int i2, int i3, int i4, int i5) {
        return new ImmutableIntArray(0, 5, new int[]{i, i2, i3, i4, i5});
    }

    /* renamed from: of */
    public static ImmutableIntArray m4261of(int i, int i2, int i3, int i4, int i5, int i6) {
        return new ImmutableIntArray(0, 6, new int[]{i, i2, i3, i4, i5, i6});
    }

    /* renamed from: of */
    public static ImmutableIntArray m4262of(int i, int... iArr) {
        Preconditions.checkArgument(iArr.length <= 2147483646, "the total number of elements must fit in an int");
        int length = iArr.length + 1;
        int[] iArr2 = new int[length];
        iArr2[0] = i;
        System.arraycopy(iArr, 0, iArr2, 1, iArr.length);
        return new ImmutableIntArray(0, length, iArr2);
    }
}
