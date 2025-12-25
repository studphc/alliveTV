package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0006\u001a)\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\b\u001a1\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\n\u001a-\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b\"\u00028\u0000¢\u0006\u0004\b\u0004\u0010\r\u001a\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u0000H\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0011\u001a)\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0012\u001a1\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0013\u001a0\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u00002\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b\"\u00028\u0000H\u0086\b¢\u0006\u0004\b\u000f\u0010\u0014¨\u0006\u0015"}, m5569d2 = {ExifInterface.LONGITUDE_EAST, "Landroidx/collection/ObjectList;", "emptyObjectList", "()Landroidx/collection/ObjectList;", "objectListOf", "element1", "(Ljava/lang/Object;)Landroidx/collection/ObjectList;", "element2", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/ObjectList;", "element3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/ObjectList;", "", "elements", "([Ljava/lang/Object;)Landroidx/collection/ObjectList;", "Landroidx/collection/MutableObjectList;", "mutableObjectListOf", "()Landroidx/collection/MutableObjectList;", "(Ljava/lang/Object;)Landroidx/collection/MutableObjectList;", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/MutableObjectList;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/MutableObjectList;", "([Ljava/lang/Object;)Landroidx/collection/MutableObjectList;", "collection"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nObjectList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObjectList.kt\nandroidx/collection/ObjectListKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ObjectList.kt\nandroidx/collection/MutableObjectList\n*L\n1#1,1618:1\n1#2:1619\n948#3,2:1620\n948#3,2:1622\n948#3,2:1624\n948#3,2:1626\n948#3,2:1628\n948#3,2:1630\n*S KotlinDebug\n*F\n+ 1 ObjectList.kt\nandroidx/collection/ObjectListKt\n*L\n1587#1:1620,2\n1596#1:1622,2\n1597#1:1624,2\n1607#1:1626,2\n1608#1:1628,2\n1609#1:1630,2\n*E\n"})
/* loaded from: classes.dex */
public final class ObjectListKt {

    /* renamed from: a */
    public static final Object[] f1743a = new Object[0];

    /* renamed from: b */
    public static final MutableObjectList f1744b = new MutableObjectList(0);

    public static final void access$checkIndex(List list, int i) {
        int size = list.size();
        if (i >= 0 && i < size) {
            return;
        }
        throw new IndexOutOfBoundsException("Index " + i + " is out of bounds. The list has " + size + " elements.");
    }

    public static final void access$checkSubIndex(List list, int i, int i2) {
        int size = list.size();
        if (i <= i2) {
            if (i >= 0) {
                if (i2 <= size) {
                    return;
                }
                throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is more than than the list size (" + size + ')');
            }
            throw new IndexOutOfBoundsException(ye0.m8292l(i, "fromIndex (", ") is less than 0."));
        }
        throw new IllegalArgumentException("Indices are out of order. fromIndex (" + i + ") is greater than toIndex (" + i2 + ").");
    }

    @NotNull
    public static final <E> ObjectList<E> emptyObjectList() {
        MutableObjectList mutableObjectList = f1744b;
        Intrinsics.checkNotNull(mutableObjectList, "null cannot be cast to non-null type androidx.collection.ObjectList<E of androidx.collection.ObjectListKt.emptyObjectList>");
        return mutableObjectList;
    }

    @NotNull
    public static final <E> MutableObjectList<E> mutableObjectListOf() {
        return new MutableObjectList<>(0, 1, null);
    }

    @NotNull
    public static final <E> ObjectList<E> objectListOf() {
        MutableObjectList mutableObjectList = f1744b;
        Intrinsics.checkNotNull(mutableObjectList, "null cannot be cast to non-null type androidx.collection.ObjectList<E of androidx.collection.ObjectListKt.objectListOf>");
        return mutableObjectList;
    }

    @NotNull
    public static final <E> MutableObjectList<E> mutableObjectListOf(E e) {
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(1);
        mutableObjectList.add(e);
        return mutableObjectList;
    }

    @NotNull
    public static final <E> ObjectList<E> objectListOf(E e) {
        return mutableObjectListOf(e);
    }

    @NotNull
    public static final <E> ObjectList<E> objectListOf(E e, E e2) {
        return mutableObjectListOf(e, e2);
    }

    @NotNull
    public static final <E> MutableObjectList<E> mutableObjectListOf(E e, E e2) {
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(2);
        mutableObjectList.add(e);
        mutableObjectList.add(e2);
        return mutableObjectList;
    }

    @NotNull
    public static final <E> ObjectList<E> objectListOf(E e, E e2, E e3) {
        return mutableObjectListOf(e, e2, e3);
    }

    @NotNull
    public static final <E> ObjectList<E> objectListOf(@NotNull E... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableObjectList mutableObjectList = new MutableObjectList(elements.length);
        mutableObjectList.plusAssign((Object[]) elements);
        return mutableObjectList;
    }

    @NotNull
    public static final <E> MutableObjectList<E> mutableObjectListOf(E e, E e2, E e3) {
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(3);
        mutableObjectList.add(e);
        mutableObjectList.add(e2);
        mutableObjectList.add(e3);
        return mutableObjectList;
    }

    @NotNull
    public static final <E> MutableObjectList<E> mutableObjectListOf(@NotNull E... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(elements.length);
        mutableObjectList.plusAssign((Object[]) elements);
        return mutableObjectList;
    }
}
