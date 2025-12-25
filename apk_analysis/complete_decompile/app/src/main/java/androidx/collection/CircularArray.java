package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(m5568d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\f\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00028\u0000¢\u0006\u0004\b\u000e\u0010\rJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0006J\u0015\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0006J\u0018\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001d\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\rR\u0011\u0010\u001f\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\r¨\u0006 "}, m5569d2 = {"Landroidx/collection/CircularArray;", ExifInterface.LONGITUDE_EAST, "", "", "minCapacity", "<init>", "(I)V", "element", "", "addFirst", "(Ljava/lang/Object;)V", "addLast", "popFirst", "()Ljava/lang/Object;", "popLast", "clear", "()V", "count", "removeFromStart", "removeFromEnd", FirebaseAnalytics.Param.INDEX, "get", "(I)Ljava/lang/Object;", "size", "()I", "", "isEmpty", "()Z", "getFirst", "first", "getLast", "last", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nCircularArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CircularArray.kt\nandroidx/collection/CircularArray\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CollectionPlatformUtils.jvm.kt\nandroidx/collection/CollectionPlatformUtils\n*L\n1#1,270:1\n1#2:271\n26#3:272\n26#3:273\n26#3:274\n26#3:275\n26#3:276\n26#3:277\n26#3:278\n*S KotlinDebug\n*F\n+ 1 CircularArray.kt\nandroidx/collection/CircularArray\n*L\n104#1:272\n122#1:273\n152#1:274\n187#1:275\n221#1:276\n235#1:277\n249#1:278\n*E\n"})
/* loaded from: classes.dex */
public final class CircularArray<E> {

    /* renamed from: a */
    public Object[] f1654a;

    /* renamed from: b */
    public int f1655b;

    /* renamed from: c */
    public int f1656c;

    /* renamed from: d */
    public int f1657d;

    @JvmOverloads
    public CircularArray() {
        this(0, 1, null);
    }

    /* renamed from: a */
    public final void m327a() {
        Object[] objArr = this.f1654a;
        int length = objArr.length;
        int i = this.f1655b;
        int i2 = length - i;
        int i3 = length << 1;
        if (i3 >= 0) {
            Object[] objArr2 = new Object[i3];
            ArraysKt___ArraysJvmKt.copyInto(objArr, objArr2, 0, i, length);
            ArraysKt___ArraysJvmKt.copyInto(this.f1654a, objArr2, i2, 0, this.f1655b);
            this.f1654a = objArr2;
            this.f1655b = 0;
            this.f1656c = length;
            this.f1657d = i3 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public final void addFirst(E element) {
        int i = (this.f1655b - 1) & this.f1657d;
        this.f1655b = i;
        this.f1654a[i] = element;
        if (i == this.f1656c) {
            m327a();
        }
    }

    public final void addLast(E element) {
        Object[] objArr = this.f1654a;
        int i = this.f1656c;
        objArr[i] = element;
        int i2 = this.f1657d & (i + 1);
        this.f1656c = i2;
        if (i2 == this.f1655b) {
            m327a();
        }
    }

    public final void clear() {
        removeFromStart(size());
    }

    public final E get(int index) {
        if (index >= 0 && index < size()) {
            E e = (E) this.f1654a[this.f1657d & (this.f1655b + index)];
            Intrinsics.checkNotNull(e);
            return e;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final E getFirst() {
        int i = this.f1655b;
        if (i != this.f1656c) {
            E e = (E) this.f1654a[i];
            Intrinsics.checkNotNull(e);
            return e;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final E getLast() {
        int i = this.f1655b;
        int i2 = this.f1656c;
        if (i != i2) {
            E e = (E) this.f1654a[(i2 - 1) & this.f1657d];
            Intrinsics.checkNotNull(e);
            return e;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final boolean isEmpty() {
        if (this.f1655b == this.f1656c) {
            return true;
        }
        return false;
    }

    public final E popFirst() {
        int i = this.f1655b;
        if (i != this.f1656c) {
            Object[] objArr = this.f1654a;
            E e = (E) objArr[i];
            objArr[i] = null;
            this.f1655b = (i + 1) & this.f1657d;
            return e;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final E popLast() {
        int i = this.f1655b;
        int i2 = this.f1656c;
        if (i != i2) {
            int i3 = this.f1657d & (i2 - 1);
            Object[] objArr = this.f1654a;
            E e = (E) objArr[i3];
            objArr[i3] = null;
            this.f1656c = i3;
            return e;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final void removeFromEnd(int count) {
        int i;
        if (count <= 0) {
            return;
        }
        if (count <= size()) {
            int i2 = this.f1656c;
            if (count < i2) {
                i = i2 - count;
            } else {
                i = 0;
            }
            for (int i3 = i; i3 < i2; i3++) {
                this.f1654a[i3] = null;
            }
            int i4 = this.f1656c;
            int i5 = i4 - i;
            int i6 = count - i5;
            this.f1656c = i4 - i5;
            if (i6 > 0) {
                int length = this.f1654a.length;
                this.f1656c = length;
                int i7 = length - i6;
                for (int i8 = i7; i8 < length; i8++) {
                    this.f1654a[i8] = null;
                }
                this.f1656c = i7;
                return;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final void removeFromStart(int count) {
        if (count <= 0) {
            return;
        }
        if (count <= size()) {
            int length = this.f1654a.length;
            int i = this.f1655b;
            if (count < length - i) {
                length = i + count;
            }
            while (i < length) {
                this.f1654a[i] = null;
                i++;
            }
            int i2 = this.f1655b;
            int i3 = length - i2;
            int i4 = count - i3;
            this.f1655b = this.f1657d & (i2 + i3);
            if (i4 > 0) {
                for (int i5 = 0; i5 < i4; i5++) {
                    this.f1654a[i5] = null;
                }
                this.f1655b = i4;
                return;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int size() {
        return (this.f1656c - this.f1655b) & this.f1657d;
    }

    @JvmOverloads
    public CircularArray(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i <= 1073741824) {
            i = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
            this.f1657d = i - 1;
            this.f1654a = new Object[i];
            return;
        }
        throw new IllegalArgumentException("capacity must be <= 2^30");
    }

    public /* synthetic */ CircularArray(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 8 : i);
    }
}
