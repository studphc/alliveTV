package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0006\u001a)\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\b\u001a1\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\n\u001a-\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b\"\u00028\u0000¢\u0006\u0004\b\u0004\u0010\r\u001a\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0011\u001a)\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0012\u001a1\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0013\u001a-\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u00002\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b\"\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0014¨\u0006\u0015"}, m5569d2 = {ExifInterface.LONGITUDE_EAST, "Landroidx/collection/ScatterSet;", "emptyScatterSet", "()Landroidx/collection/ScatterSet;", "scatterSetOf", "element1", "(Ljava/lang/Object;)Landroidx/collection/ScatterSet;", "element2", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/ScatterSet;", "element3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/ScatterSet;", "", "elements", "([Ljava/lang/Object;)Landroidx/collection/ScatterSet;", "Landroidx/collection/MutableScatterSet;", "mutableScatterSetOf", "()Landroidx/collection/MutableScatterSet;", "(Ljava/lang/Object;)Landroidx/collection/MutableScatterSet;", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/MutableScatterSet;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/MutableScatterSet;", "([Ljava/lang/Object;)Landroidx/collection/MutableScatterSet;", "collection"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nScatterSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterSet.kt\nandroidx/collection/ScatterSetKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1100:1\n1#2:1101\n*E\n"})
/* loaded from: classes.dex */
public final class ScatterSetKt {

    /* renamed from: a */
    public static final MutableScatterSet f1752a = new MutableScatterSet(0);

    @NotNull
    public static final <E> ScatterSet<E> emptyScatterSet() {
        MutableScatterSet mutableScatterSet = f1752a;
        Intrinsics.checkNotNull(mutableScatterSet, "null cannot be cast to non-null type androidx.collection.ScatterSet<E of androidx.collection.ScatterSetKt.emptyScatterSet>");
        return mutableScatterSet;
    }

    @NotNull
    public static final <E> MutableScatterSet<E> mutableScatterSetOf() {
        return new MutableScatterSet<>(0, 1, null);
    }

    @NotNull
    public static final <E> ScatterSet<E> scatterSetOf() {
        MutableScatterSet mutableScatterSet = f1752a;
        Intrinsics.checkNotNull(mutableScatterSet, "null cannot be cast to non-null type androidx.collection.ScatterSet<E of androidx.collection.ScatterSetKt.scatterSetOf>");
        return mutableScatterSet;
    }

    @NotNull
    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E e) {
        MutableScatterSet<E> mutableScatterSet = new MutableScatterSet<>(1);
        mutableScatterSet.plusAssign((MutableScatterSet<E>) e);
        return mutableScatterSet;
    }

    @NotNull
    public static final <E> ScatterSet<E> scatterSetOf(E e) {
        return mutableScatterSetOf(e);
    }

    @NotNull
    public static final <E> ScatterSet<E> scatterSetOf(E e, E e2) {
        return mutableScatterSetOf(e, e2);
    }

    @NotNull
    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E e, E e2) {
        MutableScatterSet<E> mutableScatterSet = new MutableScatterSet<>(2);
        mutableScatterSet.plusAssign((MutableScatterSet<E>) e);
        mutableScatterSet.plusAssign((MutableScatterSet<E>) e2);
        return mutableScatterSet;
    }

    @NotNull
    public static final <E> ScatterSet<E> scatterSetOf(E e, E e2, E e3) {
        return mutableScatterSetOf(e, e2, e3);
    }

    @NotNull
    public static final <E> ScatterSet<E> scatterSetOf(@NotNull E... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableScatterSet mutableScatterSet = new MutableScatterSet(elements.length);
        mutableScatterSet.plusAssign((Object[]) elements);
        return mutableScatterSet;
    }

    @NotNull
    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E e, E e2, E e3) {
        MutableScatterSet<E> mutableScatterSet = new MutableScatterSet<>(3);
        mutableScatterSet.plusAssign((MutableScatterSet<E>) e);
        mutableScatterSet.plusAssign((MutableScatterSet<E>) e2);
        mutableScatterSet.plusAssign((MutableScatterSet<E>) e3);
        return mutableScatterSet;
    }

    @NotNull
    public static final <E> MutableScatterSet<E> mutableScatterSetOf(@NotNull E... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableScatterSet<E> mutableScatterSet = new MutableScatterSet<>(elements.length);
        mutableScatterSet.plusAssign((Object[]) elements);
        return mutableScatterSet;
    }
}
