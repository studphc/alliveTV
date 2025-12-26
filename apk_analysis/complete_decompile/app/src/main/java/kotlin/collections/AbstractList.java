package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0577c1;
import p000.C1106d1;
import p000.C1142e1;
import p000.ye0;

@SinceKotlin(version = "1.1")
@Metadata(m5568d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0006\n\u0002\u0010*\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b'\u0018\u0000 \"*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0004\"#$%B\t\b\u0004¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006H¦\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0014J%\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001f¨\u0006&"}, m5569d2 = {"Lkotlin/collections/AbstractList;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/AbstractCollection;", "", "<init>", "()V", "", FirebaseAnalytics.Param.INDEX, "get", "(I)Ljava/lang/Object;", "", "iterator", "()Ljava/util/Iterator;", "element", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "getSize", "size", "Companion", "c1", "d1", "e1", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nAbstractList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractList.kt\nkotlin/collections/AbstractList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,157:1\n350#2,7:158\n378#2,7:165\n*S KotlinDebug\n*F\n+ 1 AbstractList.kt\nkotlin/collections/AbstractList\n*L\n27#1:158,7\n29#1:165,7\n*E\n"})
/* loaded from: classes2.dex */
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E>, KMappedMarker {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(m5568d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\u0007J'\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0012\u0010\u000eJ\u001b\u0010\u0018\u001a\u00020\u00022\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001d\u001a\u00020\u001a2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00142\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0000¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, m5569d2 = {"Lkotlin/collections/AbstractList$Companion;", "", "", FirebaseAnalytics.Param.INDEX, "size", "", "checkElementIndex$kotlin_stdlib", "(II)V", "checkElementIndex", "checkPositionIndex$kotlin_stdlib", "checkPositionIndex", "fromIndex", "toIndex", "checkRangeIndexes$kotlin_stdlib", "(III)V", "checkRangeIndexes", "startIndex", "endIndex", "checkBoundsIndexes$kotlin_stdlib", "checkBoundsIndexes", "", "c", "orderedHashCode$kotlin_stdlib", "(Ljava/util/Collection;)I", "orderedHashCode", "other", "", "orderedEquals$kotlin_stdlib", "(Ljava/util/Collection;Ljava/util/Collection;)Z", "orderedEquals", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final void checkBoundsIndexes$kotlin_stdlib(int startIndex, int endIndex, int size) {
            if (startIndex >= 0 && endIndex <= size) {
                if (startIndex <= endIndex) {
                } else {
                    throw new IllegalArgumentException(ye0.m8293m(startIndex, "startIndex: ", " > endIndex: ", endIndex));
                }
            } else {
                StringBuilder m8302v = ye0.m8302v("startIndex: ", startIndex, ", endIndex: ", endIndex, ", size: ");
                m8302v.append(size);
                throw new IndexOutOfBoundsException(m8302v.toString());
            }
        }

        public final void checkElementIndex$kotlin_stdlib(int index, int size) {
            if (index >= 0 && index < size) {
            } else {
                throw new IndexOutOfBoundsException(ye0.m8293m(index, "index: ", ", size: ", size));
            }
        }

        public final void checkPositionIndex$kotlin_stdlib(int index, int size) {
            if (index >= 0 && index <= size) {
            } else {
                throw new IndexOutOfBoundsException(ye0.m8293m(index, "index: ", ", size: ", size));
            }
        }

        public final void checkRangeIndexes$kotlin_stdlib(int fromIndex, int toIndex, int size) {
            if (fromIndex >= 0 && toIndex <= size) {
                if (fromIndex <= toIndex) {
                } else {
                    throw new IllegalArgumentException(ye0.m8293m(fromIndex, "fromIndex: ", " > toIndex: ", toIndex));
                }
            } else {
                StringBuilder m8302v = ye0.m8302v("fromIndex: ", fromIndex, ", toIndex: ", toIndex, ", size: ");
                m8302v.append(size);
                throw new IndexOutOfBoundsException(m8302v.toString());
            }
        }

        public final boolean orderedEquals$kotlin_stdlib(@NotNull Collection<?> c, @NotNull Collection<?> other) {
            Intrinsics.checkNotNullParameter(c, "c");
            Intrinsics.checkNotNullParameter(other, "other");
            if (c.size() != other.size()) {
                return false;
            }
            Iterator<?> it = other.iterator();
            Iterator<?> it2 = c.iterator();
            while (it2.hasNext()) {
                if (!Intrinsics.areEqual(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int orderedHashCode$kotlin_stdlib(@NotNull Collection<?> c) {
            int i;
            Intrinsics.checkNotNullParameter(c, "c");
            int i2 = 1;
            for (Object obj : c) {
                int i3 = i2 * 31;
                if (obj != null) {
                    i = obj.hashCode();
                } else {
                    i = 0;
                }
                i2 = i3 + i;
            }
            return i2;
        }
    }

    @Override // java.util.List
    public void add(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof List)) {
            return false;
        }
        return INSTANCE.orderedEquals$kotlin_stdlib(this, (Collection) other);
    }

    public abstract E get(int index);

    @Override // kotlin.collections.AbstractCollection
    public abstract int getSize();

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return INSTANCE.orderedHashCode$kotlin_stdlib(this);
    }

    @Override // java.util.List
    public int indexOf(E element) {
        Iterator<E> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!Intrinsics.areEqual(it.next(), element)) {
                i++;
            } else {
                return i;
            }
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<E> iterator() {
        return new C0577c1(this);
    }

    @Override // java.util.List
    public int lastIndexOf(E element) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (Intrinsics.areEqual(listIterator.previous(), element)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<E> listIterator() {
        return new C1106d1(this, 0);
    }

    @Override // java.util.List
    public E remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    @NotNull
    public List<E> subList(int fromIndex, int toIndex) {
        return new C1142e1(this, fromIndex, toIndex);
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<E> listIterator(int index) {
        return new C1106d1(this, index);
    }
}
