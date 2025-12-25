package kotlin;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import p000.C0577c1;

@SinceKotlin(version = "1.3")
@Metadata(m5568d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014B\u0014\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006B\u0014\b\u0001\u0012\u0006\u0010\b\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\tJ\u001e\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0086\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0002H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u001f\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\"\u001a\u00020\u0018H\u0016¢\u0006\u0004\b \u0010!J\u0010\u0010&\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010)\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010.\u001a\u00020\u00182\b\u0010+\u001a\u0004\u0018\u00010*HÖ\u0003¢\u0006\u0004\b,\u0010-R\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\f\n\u0004\b/\u00100\u0012\u0004\b1\u00102R\u0014\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u0010(\u0088\u0001\b\u0092\u0001\u00020\u0007ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u00065"}, m5569d2 = {"Lkotlin/UIntArray;", "", "Lkotlin/UInt;", "", "size", "constructor-impl", "(I)[I", "", "storage", "([I)[I", FirebaseAnalytics.Param.INDEX, "get-pVg5ArA", "([II)I", "get", "value", "", "set-VXSXFK8", "([III)V", "set", "", "iterator-impl", "([I)Ljava/util/Iterator;", "iterator", "element", "", "contains-WZ4Q5Ns", "([II)Z", "contains", "elements", "containsAll-impl", "([ILjava/util/Collection;)Z", "containsAll", "isEmpty-impl", "([I)Z", "isEmpty", "", "toString-impl", "([I)Ljava/lang/String;", "toString", "hashCode-impl", "([I)I", "hashCode", "", "other", "equals-impl", "([ILjava/lang/Object;)Z", "equals", "a", "[I", "getStorage$annotations", "()V", "getSize-impl", "c1", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@ExperimentalUnsignedTypes
@JvmInline
@SourceDebugExtension({"SMAP\nUIntArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UIntArray.kt\nkotlin/UIntArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n*S KotlinDebug\n*F\n+ 1 UIntArray.kt\nkotlin/UIntArray\n*L\n62#1:87,3\n*E\n"})
/* loaded from: classes2.dex */
public final class UIntArray implements Collection<UInt>, KMappedMarker {

    /* renamed from: a, reason: from kotlin metadata */
    public final int[] storage;

    public /* synthetic */ UIntArray(int[] iArr) {
        this.storage = iArr;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UIntArray m8552boximpl(int[] iArr) {
        return new UIntArray(iArr);
    }

    @PublishedApi
    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static int[] m8554constructorimpl(@NotNull int[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }

    /* renamed from: containsAll-impl, reason: not valid java name */
    public static boolean m8556containsAllimpl(int[] iArr, @NotNull Collection<UInt> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        for (Object obj : elements) {
            if (!(obj instanceof UInt) || !ArraysKt___ArraysKt.contains(iArr, ((UInt) obj).getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m8557equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof UIntArray) && Intrinsics.areEqual(iArr, ((UIntArray) obj).getStorage());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m8558equalsimpl0(int[] iArr, int[] iArr2) {
        return Intrinsics.areEqual(iArr, iArr2);
    }

    /* renamed from: get-pVg5ArA, reason: not valid java name */
    public static final int m8559getpVg5ArA(int[] iArr, int i) {
        return UInt.m8546constructorimpl(iArr[i]);
    }

    /* renamed from: getSize-impl, reason: not valid java name */
    public static int m8560getSizeimpl(int[] iArr) {
        return iArr.length;
    }

    @PublishedApi
    public static /* synthetic */ void getStorage$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m8561hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    /* renamed from: isEmpty-impl, reason: not valid java name */
    public static boolean m8562isEmptyimpl(int[] iArr) {
        if (iArr.length == 0) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: iterator-impl, reason: not valid java name */
    public static Iterator<UInt> m8563iteratorimpl(int[] iArr) {
        return new C0577c1(iArr);
    }

    /* renamed from: set-VXSXFK8, reason: not valid java name */
    public static final void m8564setVXSXFK8(int[] iArr, int i, int i2) {
        iArr[i] = i2;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m8565toStringimpl(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UInt uInt) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-WZ4Q5Ns, reason: not valid java name */
    public boolean m8566addWZ4Q5Ns(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UInt> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof UInt)) {
            return false;
        }
        return m8567containsWZ4Q5Ns(((UInt) obj).getCom.google.android.exoplayer2.upstream.DataSchemeDataSource.SCHEME_DATA java.lang.String());
    }

    /* renamed from: contains-WZ4Q5Ns, reason: not valid java name */
    public boolean m8567containsWZ4Q5Ns(int i) {
        return m8555containsWZ4Q5Ns(this.storage, i);
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return m8556containsAllimpl(this.storage, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m8557equalsimpl(this.storage, obj);
    }

    @Override // java.util.Collection
    /* renamed from: getSize, reason: merged with bridge method [inline-methods] */
    public int size() {
        return m8560getSizeimpl(this.storage);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m8561hashCodeimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m8562isEmptyimpl(this.storage);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<UInt> iterator() {
        return m8563iteratorimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public String toString() {
        return m8565toStringimpl(this.storage);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int[] getStorage() {
        return this.storage;
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static int[] m8553constructorimpl(int i) {
        return m8554constructorimpl(new int[i]);
    }

    /* renamed from: contains-WZ4Q5Ns, reason: not valid java name */
    public static boolean m8555containsWZ4Q5Ns(int[] iArr, int i) {
        return ArraysKt___ArraysKt.contains(iArr, i);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }
}
