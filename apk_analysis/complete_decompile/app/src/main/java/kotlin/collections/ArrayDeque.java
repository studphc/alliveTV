package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1755rb;
import p000.r82;
import p000.ye0;

@SinceKotlin(version = "1.4")
@Metadata(m5568d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 G*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001GB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007B\u0017\b\u0016\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\u0005\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00028\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0010\u0010\u000fJ\r\u0010\u0011\u001a\u00028\u0000¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0012\u0010\u000fJ\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0016J\r\u0010\u0018\u001a\u00028\u0000¢\u0006\u0004\b\u0018\u0010\u000fJ\u000f\u0010\u0019\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0019\u0010\u000fJ\r\u0010\u001a\u001a\u00028\u0000¢\u0006\u0004\b\u001a\u0010\u000fJ\u000f\u0010\u001b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u001b\u0010\u000fJ\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001c\u0010\u001fJ\u001d\u0010 \u001a\u00020\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b \u0010!J%\u0010 \u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b \u0010\"J\u0018\u0010#\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b#\u0010$J \u0010%\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b%\u0010&J\u0018\u0010'\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b'\u0010\u001dJ\u0017\u0010(\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0004\b*\u0010)J\u0017\u0010+\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0004\b+\u0010\u001dJ\u0017\u0010,\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b,\u0010$J\u001d\u0010-\u001a\u00020\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b-\u0010!J\u001d\u0010.\u001a\u00020\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b.\u0010!J\u000f\u0010/\u001a\u00020\u0014H\u0016¢\u0006\u0004\b/\u0010\u0007J)\u00103\u001a\b\u0012\u0004\u0012\u00028\u000101\"\u0004\b\u0001\u001002\f\u00102\u001a\b\u0012\u0004\u0012\u00028\u000101H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010501H\u0016¢\u0006\u0004\b3\u00106J)\u00108\u001a\b\u0012\u0004\u0012\u00028\u000101\"\u0004\b\u0001\u001002\f\u00102\u001a\b\u0012\u0004\u0012\u00028\u000101H\u0000¢\u0006\u0004\b7\u00104J\u0017\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010501H\u0000¢\u0006\u0004\b7\u00106JO\u0010@\u001a\u00020\u00142>\u0010=\u001a:\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010501¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u001409H\u0000¢\u0006\u0004\b>\u0010?R$\u0010F\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00038\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E¨\u0006H"}, m5569d2 = {"Lkotlin/collections/ArrayDeque;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractMutableList;", "", "initialCapacity", "<init>", "(I)V", "()V", "", "elements", "(Ljava/util/Collection;)V", "", "isEmpty", "()Z", "first", "()Ljava/lang/Object;", "firstOrNull", "last", "lastOrNull", "element", "", "addFirst", "(Ljava/lang/Object;)V", "addLast", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "add", "(Ljava/lang/Object;)Z", FirebaseAnalytics.Param.INDEX, "(ILjava/lang/Object;)V", "addAll", "(Ljava/util/Collection;)Z", "(ILjava/util/Collection;)Z", "get", "(I)Ljava/lang/Object;", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "contains", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "remove", "removeAt", "removeAll", "retainAll", "clear", ExifInterface.GPS_DIRECTION_TRUE, "", "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "()[Ljava/lang/Object;", "testToArray$kotlin_stdlib", "testToArray", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "head", "structure", "internalStructure$kotlin_stdlib", "(Lkotlin/jvm/functions/Function2;)V", "internalStructure", "<set-?>", "c", "I", "getSize", "()I", "size", "Companion", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@WasExperimental(markerClass = {ExperimentalStdlibApi.class})
@SourceDebugExtension({"SMAP\nArrayDeque.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArrayDeque.kt\nkotlin/collections/ArrayDeque\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,583:1\n467#1,51:586\n467#1,51:637\n37#2,2:584\n26#3:688\n*S KotlinDebug\n*F\n+ 1 ArrayDeque.kt\nkotlin/collections/ArrayDeque\n*L\n462#1:586,51\n464#1:637,51\n47#1:584,2\n562#1:688\n*E\n"})
/* loaded from: classes2.dex */
public final class ArrayDeque<E> extends AbstractMutableList<E> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d */
    public static final Object[] f20961d = new Object[0];

    /* renamed from: a */
    public int f20962a;

    /* renamed from: b */
    public Object[] f20963b;

    /* renamed from: c, reason: from kotlin metadata */
    public int size;

    @Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\t¨\u0006\u000e"}, m5569d2 = {"Lkotlin/collections/ArrayDeque$Companion;", "", "", "oldCapacity", "minCapacity", "newCapacity$kotlin_stdlib", "(II)I", "newCapacity", "defaultMinCapacity", "I", "", "emptyElementData", "[Ljava/lang/Object;", "maxArraySize", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final int newCapacity$kotlin_stdlib(int oldCapacity, int minCapacity) {
            int i = oldCapacity + (oldCapacity >> 1);
            if (i - minCapacity < 0) {
                i = minCapacity;
            }
            return i - 2147483639 > 0 ? minCapacity > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i;
        }
    }

    public ArrayDeque(int i) {
        Object[] objArr;
        if (i == 0) {
            objArr = f20961d;
        } else if (i > 0) {
            objArr = new Object[i];
        } else {
            throw new IllegalArgumentException(ye0.m8291k(i, "Illegal Capacity: "));
        }
        this.f20963b = objArr;
    }

    /* renamed from: a */
    public final void m5577a(int i, Collection collection) {
        Iterator<E> it = collection.iterator();
        int length = this.f20963b.length;
        while (i < length && it.hasNext()) {
            this.f20963b[i] = it.next();
            i++;
        }
        int i2 = this.f20962a;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.f20963b[i3] = it.next();
        }
        this.size = collection.size() + size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E element) {
        addLast(element);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        m5578c(elements.size() + size());
        m5577a(m5580f(size() + this.f20962a), elements);
        return true;
    }

    public final void addFirst(E element) {
        int i;
        m5578c(size() + 1);
        int i2 = this.f20962a;
        if (i2 == 0) {
            i = ArraysKt___ArraysKt.getLastIndex(this.f20963b);
        } else {
            i = i2 - 1;
        }
        this.f20962a = i;
        this.f20963b[i] = element;
        this.size = size() + 1;
    }

    public final void addLast(E element) {
        m5578c(size() + 1);
        this.f20963b[m5580f(size() + this.f20962a)] = element;
        this.size = size() + 1;
    }

    /* renamed from: c */
    public final void m5578c(int i) {
        if (i >= 0) {
            Object[] objArr = this.f20963b;
            if (i <= objArr.length) {
                return;
            }
            if (objArr == f20961d) {
                this.f20963b = new Object[r82.coerceAtLeast(i, 10)];
                return;
            }
            Object[] objArr2 = new Object[INSTANCE.newCapacity$kotlin_stdlib(objArr.length, i)];
            Object[] objArr3 = this.f20963b;
            ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr2, 0, this.f20962a, objArr3.length);
            Object[] objArr4 = this.f20963b;
            int length = objArr4.length;
            int i2 = this.f20962a;
            ArraysKt___ArraysJvmKt.copyInto(objArr4, objArr2, length - i2, 0, i2);
            this.f20962a = 0;
            this.f20963b = objArr2;
            return;
        }
        throw new IllegalStateException("Deque is too big.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int m5580f = m5580f(size() + this.f20962a);
        int i = this.f20962a;
        if (i < m5580f) {
            ArraysKt___ArraysJvmKt.fill(this.f20963b, (Object) null, i, m5580f);
        } else if (!isEmpty()) {
            Object[] objArr = this.f20963b;
            ArraysKt___ArraysJvmKt.fill(objArr, (Object) null, this.f20962a, objArr.length);
            ArraysKt___ArraysJvmKt.fill(this.f20963b, (Object) null, 0, m5580f);
        }
        this.f20962a = 0;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object element) {
        if (indexOf(element) != -1) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public final int m5579e(int i) {
        if (i == ArraysKt___ArraysKt.getLastIndex(this.f20963b)) {
            return 0;
        }
        return i + 1;
    }

    /* renamed from: f */
    public final int m5580f(int i) {
        Object[] objArr = this.f20963b;
        if (i >= objArr.length) {
            return i - objArr.length;
        }
        return i;
    }

    public final E first() {
        if (!isEmpty()) {
            return (E) this.f20963b[this.f20962a];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Nullable
    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f20963b[this.f20962a];
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        return (E) this.f20963b[m5580f(this.f20962a + index)];
    }

    @Override // kotlin.collections.AbstractMutableList
    /* renamed from: getSize, reason: from getter */
    public int getF21018c() {
        return this.size;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        int i;
        int m5580f = m5580f(size() + this.f20962a);
        int i2 = this.f20962a;
        if (i2 < m5580f) {
            while (i2 < m5580f) {
                if (Intrinsics.areEqual(element, this.f20963b[i2])) {
                    i = this.f20962a;
                } else {
                    i2++;
                }
            }
            return -1;
        }
        if (i2 >= m5580f) {
            int length = this.f20963b.length;
            while (true) {
                if (i2 < length) {
                    if (Intrinsics.areEqual(element, this.f20963b[i2])) {
                        i = this.f20962a;
                        break;
                    }
                    i2++;
                } else {
                    for (int i3 = 0; i3 < m5580f; i3++) {
                        if (Intrinsics.areEqual(element, this.f20963b[i3])) {
                            i2 = i3 + this.f20963b.length;
                            i = this.f20962a;
                        }
                    }
                    return -1;
                }
            }
        } else {
            return -1;
        }
        return i2 - i;
    }

    public final void internalStructure$kotlin_stdlib(@NotNull Function2<? super Integer, ? super Object[], Unit> structure) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(structure, "structure");
        int m5580f = m5580f(size() + this.f20962a);
        if (!isEmpty() && (i2 = this.f20962a) >= m5580f) {
            i = i2 - this.f20963b.length;
        } else {
            i = this.f20962a;
        }
        structure.invoke(Integer.valueOf(i), toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public final E last() {
        if (!isEmpty()) {
            return (E) this.f20963b[m5580f(CollectionsKt__CollectionsKt.getLastIndex(this) + this.f20962a)];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object element) {
        int lastIndex;
        int i;
        int m5580f = m5580f(size() + this.f20962a);
        int i2 = this.f20962a;
        if (i2 < m5580f) {
            lastIndex = m5580f - 1;
            if (i2 <= lastIndex) {
                while (!Intrinsics.areEqual(element, this.f20963b[lastIndex])) {
                    if (lastIndex != i2) {
                        lastIndex--;
                    }
                }
                i = this.f20962a;
                return lastIndex - i;
            }
            return -1;
        }
        if (i2 > m5580f) {
            int i3 = m5580f - 1;
            while (true) {
                if (-1 < i3) {
                    if (Intrinsics.areEqual(element, this.f20963b[i3])) {
                        lastIndex = i3 + this.f20963b.length;
                        i = this.f20962a;
                        break;
                    }
                    i3--;
                } else {
                    lastIndex = ArraysKt___ArraysKt.getLastIndex(this.f20963b);
                    int i4 = this.f20962a;
                    if (i4 <= lastIndex) {
                        while (!Intrinsics.areEqual(element, this.f20963b[lastIndex])) {
                            if (lastIndex != i4) {
                                lastIndex--;
                            }
                        }
                        i = this.f20962a;
                    }
                }
            }
        }
        return -1;
    }

    @Nullable
    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.f20963b[m5580f(CollectionsKt__CollectionsKt.getLastIndex(this) + this.f20962a)];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object element) {
        int indexOf = indexOf(element);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        int m5580f;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.f20963b.length != 0) {
            int m5580f2 = m5580f(size() + this.f20962a);
            int i = this.f20962a;
            if (i < m5580f2) {
                m5580f = i;
                while (i < m5580f2) {
                    Object obj = this.f20963b[i];
                    if (!elements.contains(obj)) {
                        this.f20963b[m5580f] = obj;
                        m5580f++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                ArraysKt___ArraysJvmKt.fill(this.f20963b, (Object) null, m5580f, m5580f2);
            } else {
                int length = this.f20963b.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr = this.f20963b;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (!elements.contains(obj2)) {
                        this.f20963b[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                m5580f = m5580f(i2);
                for (int i3 = 0; i3 < m5580f2; i3++) {
                    Object[] objArr2 = this.f20963b;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (!elements.contains(obj3)) {
                        this.f20963b[m5580f] = obj3;
                        m5580f = m5579e(m5580f);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                int i4 = m5580f - this.f20962a;
                if (i4 < 0) {
                    i4 += this.f20963b.length;
                }
                this.size = i4;
            }
        }
        return z;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int index) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        if (index == CollectionsKt__CollectionsKt.getLastIndex(this)) {
            return removeLast();
        }
        if (index == 0) {
            return removeFirst();
        }
        int m5580f = m5580f(this.f20962a + index);
        E e = (E) this.f20963b[m5580f];
        if (index < (size() >> 1)) {
            int i = this.f20962a;
            if (m5580f >= i) {
                Object[] objArr = this.f20963b;
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i + 1, i, m5580f);
            } else {
                Object[] objArr2 = this.f20963b;
                ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, 1, 0, m5580f);
                Object[] objArr3 = this.f20963b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i2 = this.f20962a;
                ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr3, i2 + 1, i2, objArr3.length - 1);
            }
            Object[] objArr4 = this.f20963b;
            int i3 = this.f20962a;
            objArr4[i3] = null;
            this.f20962a = m5579e(i3);
        } else {
            int m5580f2 = m5580f(CollectionsKt__CollectionsKt.getLastIndex(this) + this.f20962a);
            if (m5580f <= m5580f2) {
                Object[] objArr5 = this.f20963b;
                ArraysKt___ArraysJvmKt.copyInto(objArr5, objArr5, m5580f, m5580f + 1, m5580f2 + 1);
            } else {
                Object[] objArr6 = this.f20963b;
                ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, m5580f, m5580f + 1, objArr6.length);
                Object[] objArr7 = this.f20963b;
                objArr7[objArr7.length - 1] = objArr7[0];
                ArraysKt___ArraysJvmKt.copyInto(objArr7, objArr7, 0, 1, m5580f2 + 1);
            }
            this.f20963b[m5580f2] = null;
        }
        this.size = size() - 1;
        return e;
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            Object[] objArr = this.f20963b;
            int i = this.f20962a;
            E e = (E) objArr[i];
            objArr[i] = null;
            this.f20962a = m5579e(i);
            this.size = size() - 1;
            return e;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Nullable
    public final E removeFirstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public final E removeLast() {
        if (!isEmpty()) {
            int m5580f = m5580f(CollectionsKt__CollectionsKt.getLastIndex(this) + this.f20962a);
            Object[] objArr = this.f20963b;
            E e = (E) objArr[m5580f];
            objArr[m5580f] = null;
            this.size = size() - 1;
            return e;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Nullable
    public final E removeLastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        int m5580f;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.f20963b.length != 0) {
            int m5580f2 = m5580f(size() + this.f20962a);
            int i = this.f20962a;
            if (i < m5580f2) {
                m5580f = i;
                while (i < m5580f2) {
                    Object obj = this.f20963b[i];
                    if (elements.contains(obj)) {
                        this.f20963b[m5580f] = obj;
                        m5580f++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                ArraysKt___ArraysJvmKt.fill(this.f20963b, (Object) null, m5580f, m5580f2);
            } else {
                int length = this.f20963b.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr = this.f20963b;
                    Object obj2 = objArr[i];
                    objArr[i] = null;
                    if (elements.contains(obj2)) {
                        this.f20963b[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                m5580f = m5580f(i2);
                for (int i3 = 0; i3 < m5580f2; i3++) {
                    Object[] objArr2 = this.f20963b;
                    Object obj3 = objArr2[i3];
                    objArr2[i3] = null;
                    if (elements.contains(obj3)) {
                        this.f20963b[m5580f] = obj3;
                        m5580f = m5579e(m5580f);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                int i4 = m5580f - this.f20962a;
                if (i4 < 0) {
                    i4 += this.f20963b.length;
                }
                this.size = i4;
            }
        }
        return z;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        int m5580f = m5580f(this.f20962a + index);
        Object[] objArr = this.f20963b;
        E e = (E) objArr[m5580f];
        objArr[m5580f] = element;
        return e;
    }

    @NotNull
    public final <T> T[] testToArray$kotlin_stdlib(@NotNull T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) toArray(array);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (array.length < size()) {
            array = (T[]) AbstractC1755rb.arrayOfNulls(array, size());
        }
        int m5580f = m5580f(size() + this.f20962a);
        int i = this.f20962a;
        if (i < m5580f) {
            ArraysKt___ArraysJvmKt.copyInto$default(this.f20963b, array, 0, i, m5580f, 2, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr = this.f20963b;
            ArraysKt___ArraysJvmKt.copyInto(objArr, array, 0, this.f20962a, objArr.length);
            Object[] objArr2 = this.f20963b;
            ArraysKt___ArraysJvmKt.copyInto(objArr2, array, objArr2.length - this.f20962a, 0, m5580f);
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, size());
        if (index == size()) {
            addLast(element);
            return;
        }
        if (index == 0) {
            addFirst(element);
            return;
        }
        m5578c(size() + 1);
        int m5580f = m5580f(this.f20962a + index);
        if (index < ((size() + 1) >> 1)) {
            int lastIndex = m5580f == 0 ? ArraysKt___ArraysKt.getLastIndex(this.f20963b) : m5580f - 1;
            int i = this.f20962a;
            int lastIndex2 = i == 0 ? ArraysKt___ArraysKt.getLastIndex(this.f20963b) : i - 1;
            int i2 = this.f20962a;
            if (lastIndex >= i2) {
                Object[] objArr = this.f20963b;
                objArr[lastIndex2] = objArr[i2];
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i2, i2 + 1, lastIndex + 1);
            } else {
                Object[] objArr2 = this.f20963b;
                ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, i2 - 1, i2, objArr2.length);
                Object[] objArr3 = this.f20963b;
                objArr3[objArr3.length - 1] = objArr3[0];
                ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr3, 0, 1, lastIndex + 1);
            }
            this.f20963b[lastIndex] = element;
            this.f20962a = lastIndex2;
        } else {
            int m5580f2 = m5580f(size() + this.f20962a);
            if (m5580f < m5580f2) {
                Object[] objArr4 = this.f20963b;
                ArraysKt___ArraysJvmKt.copyInto(objArr4, objArr4, m5580f + 1, m5580f, m5580f2);
            } else {
                Object[] objArr5 = this.f20963b;
                ArraysKt___ArraysJvmKt.copyInto(objArr5, objArr5, 1, 0, m5580f2);
                Object[] objArr6 = this.f20963b;
                objArr6[0] = objArr6[objArr6.length - 1];
                ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, m5580f + 1, m5580f, objArr6.length - 1);
            }
            this.f20963b[m5580f] = element;
        }
        this.size = size() + 1;
    }

    @NotNull
    public final Object[] testToArray$kotlin_stdlib() {
        return toArray();
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, @NotNull Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        AbstractList.INSTANCE.checkPositionIndex$kotlin_stdlib(index, size());
        if (elements.isEmpty()) {
            return false;
        }
        if (index == size()) {
            return addAll(elements);
        }
        m5578c(elements.size() + size());
        int m5580f = m5580f(size() + this.f20962a);
        int m5580f2 = m5580f(this.f20962a + index);
        int size = elements.size();
        if (index < ((size() + 1) >> 1)) {
            int i = this.f20962a;
            int i2 = i - size;
            if (m5580f2 < i) {
                Object[] objArr = this.f20963b;
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, i2, i, objArr.length);
                if (size >= m5580f2) {
                    Object[] objArr2 = this.f20963b;
                    ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, objArr2.length - size, 0, m5580f2);
                } else {
                    Object[] objArr3 = this.f20963b;
                    ArraysKt___ArraysJvmKt.copyInto(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f20963b;
                    ArraysKt___ArraysJvmKt.copyInto(objArr4, objArr4, 0, size, m5580f2);
                }
            } else if (i2 >= 0) {
                Object[] objArr5 = this.f20963b;
                ArraysKt___ArraysJvmKt.copyInto(objArr5, objArr5, i2, i, m5580f2);
            } else {
                Object[] objArr6 = this.f20963b;
                i2 += objArr6.length;
                int i3 = m5580f2 - i;
                int length = objArr6.length - i2;
                if (length >= i3) {
                    ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, i2, i, m5580f2);
                } else {
                    ArraysKt___ArraysJvmKt.copyInto(objArr6, objArr6, i2, i, i + length);
                    Object[] objArr7 = this.f20963b;
                    ArraysKt___ArraysJvmKt.copyInto(objArr7, objArr7, 0, this.f20962a + length, m5580f2);
                }
            }
            this.f20962a = i2;
            int i4 = m5580f2 - size;
            if (i4 < 0) {
                i4 += this.f20963b.length;
            }
            m5577a(i4, elements);
        } else {
            int i5 = m5580f2 + size;
            if (m5580f2 < m5580f) {
                int i6 = size + m5580f;
                Object[] objArr8 = this.f20963b;
                if (i6 <= objArr8.length) {
                    ArraysKt___ArraysJvmKt.copyInto(objArr8, objArr8, i5, m5580f2, m5580f);
                } else if (i5 >= objArr8.length) {
                    ArraysKt___ArraysJvmKt.copyInto(objArr8, objArr8, i5 - objArr8.length, m5580f2, m5580f);
                } else {
                    int length2 = m5580f - (i6 - objArr8.length);
                    ArraysKt___ArraysJvmKt.copyInto(objArr8, objArr8, 0, length2, m5580f);
                    Object[] objArr9 = this.f20963b;
                    ArraysKt___ArraysJvmKt.copyInto(objArr9, objArr9, i5, m5580f2, length2);
                }
            } else {
                Object[] objArr10 = this.f20963b;
                ArraysKt___ArraysJvmKt.copyInto(objArr10, objArr10, size, 0, m5580f);
                Object[] objArr11 = this.f20963b;
                if (i5 >= objArr11.length) {
                    ArraysKt___ArraysJvmKt.copyInto(objArr11, objArr11, i5 - objArr11.length, m5580f2, objArr11.length);
                } else {
                    ArraysKt___ArraysJvmKt.copyInto(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f20963b;
                    ArraysKt___ArraysJvmKt.copyInto(objArr12, objArr12, i5, m5580f2, objArr12.length - size);
                }
            }
            m5577a(m5580f2, elements);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    public ArrayDeque() {
        this.f20963b = f20961d;
    }

    public ArrayDeque(@NotNull Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] array = elements.toArray(new Object[0]);
        this.f20963b = array;
        this.size = array.length;
        if (array.length == 0) {
            this.f20963b = f20961d;
        }
    }
}
