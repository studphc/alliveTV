package androidx.collection;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(m5568d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0005J\u0015\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0005J\r\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u000bJ\r\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u0015\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u000bJ\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001a\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000bR\u0011\u0010\u001c\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001d"}, m5569d2 = {"Landroidx/collection/CircularIntArray;", "", "", "minCapacity", "<init>", "(I)V", "element", "", "addFirst", "addLast", "popFirst", "()I", "popLast", "clear", "()V", "count", "removeFromStart", "removeFromEnd", FirebaseAnalytics.Param.INDEX, "get", "(I)I", "size", "", "isEmpty", "()Z", "getFirst", "first", "getLast", "last", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nCircularIntArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CircularIntArray.kt\nandroidx/collection/CircularIntArray\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CollectionPlatformUtils.jvm.kt\nandroidx/collection/CollectionPlatformUtils\n*L\n1#1,213:1\n1#2:214\n26#3:215\n26#3:216\n26#3:217\n26#3:218\n26#3:219\n26#3:220\n26#3:221\n*S KotlinDebug\n*F\n+ 1 CircularIntArray.kt\nandroidx/collection/CircularIntArray\n*L\n100#1:215\n113#1:216\n139#1:217\n156#1:218\n169#1:219\n181#1:220\n193#1:221\n*E\n"})
/* loaded from: classes.dex */
public final class CircularIntArray {

    /* renamed from: a */
    public int[] f1658a;

    /* renamed from: b */
    public int f1659b;

    /* renamed from: c */
    public int f1660c;

    /* renamed from: d */
    public int f1661d;

    @JvmOverloads
    public CircularIntArray() {
        this(0, 1, null);
    }

    /* renamed from: a */
    public final void m328a() {
        int[] iArr = this.f1658a;
        int length = iArr.length;
        int i = this.f1659b;
        int i2 = length - i;
        int i3 = length << 1;
        if (i3 >= 0) {
            int[] iArr2 = new int[i3];
            ArraysKt___ArraysJvmKt.copyInto(iArr, iArr2, 0, i, length);
            ArraysKt___ArraysJvmKt.copyInto(this.f1658a, iArr2, i2, 0, this.f1659b);
            this.f1658a = iArr2;
            this.f1659b = 0;
            this.f1660c = length;
            this.f1661d = i3 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public final void addFirst(int element) {
        int i = (this.f1659b - 1) & this.f1661d;
        this.f1659b = i;
        this.f1658a[i] = element;
        if (i == this.f1660c) {
            m328a();
        }
    }

    public final void addLast(int element) {
        int[] iArr = this.f1658a;
        int i = this.f1660c;
        iArr[i] = element;
        int i2 = this.f1661d & (i + 1);
        this.f1660c = i2;
        if (i2 == this.f1659b) {
            m328a();
        }
    }

    public final void clear() {
        this.f1660c = this.f1659b;
    }

    public final int get(int index) {
        if (index >= 0 && index < size()) {
            return this.f1658a[this.f1661d & (this.f1659b + index)];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int getFirst() {
        int i = this.f1659b;
        if (i != this.f1660c) {
            return this.f1658a[i];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int getLast() {
        int i = this.f1659b;
        int i2 = this.f1660c;
        if (i != i2) {
            return this.f1658a[(i2 - 1) & this.f1661d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final boolean isEmpty() {
        if (this.f1659b == this.f1660c) {
            return true;
        }
        return false;
    }

    public final int popFirst() {
        int i = this.f1659b;
        if (i != this.f1660c) {
            int i2 = this.f1658a[i];
            this.f1659b = (i + 1) & this.f1661d;
            return i2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int popLast() {
        int i = this.f1659b;
        int i2 = this.f1660c;
        if (i != i2) {
            int i3 = this.f1661d & (i2 - 1);
            int i4 = this.f1658a[i3];
            this.f1660c = i3;
            return i4;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final void removeFromEnd(int count) {
        if (count <= 0) {
            return;
        }
        if (count <= size()) {
            this.f1660c = this.f1661d & (this.f1660c - count);
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final void removeFromStart(int count) {
        if (count <= 0) {
            return;
        }
        if (count <= size()) {
            this.f1659b = this.f1661d & (this.f1659b + count);
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int size() {
        return (this.f1660c - this.f1659b) & this.f1661d;
    }

    @JvmOverloads
    public CircularIntArray(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i <= 1073741824) {
            i = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
            this.f1661d = i - 1;
            this.f1658a = new int[i];
            return;
        }
        throw new IllegalArgumentException("capacity must be <= 2^30");
    }

    public /* synthetic */ CircularIntArray(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 8 : i);
    }
}
