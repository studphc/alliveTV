package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0002\u001a\u0015\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\u0006\u001a\u001d\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\b\u001a%\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\n\u001a\u0019\u0010\u0003\u001a\u00020\u00002\n\u0010\f\u001a\u00020\u000b\"\u00020\u0004¢\u0006\u0004\b\u0003\u0010\r\u001a\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0011\u001a\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0012\u001a%\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0013\u001a\u0019\u0010\u000f\u001a\u00020\u000e2\n\u0010\f\u001a\u00020\u000b\"\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0014\u001a\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0080\b¢\u0006\u0004\b\u0016\u0010\u0017\"\u001a\u0010\u001c\u001a\u00020\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, m5569d2 = {"Landroidx/collection/IntSet;", "emptyIntSet", "()Landroidx/collection/IntSet;", "intSetOf", "", "element1", "(I)Landroidx/collection/IntSet;", "element2", "(II)Landroidx/collection/IntSet;", "element3", "(III)Landroidx/collection/IntSet;", "", "elements", "([I)Landroidx/collection/IntSet;", "Landroidx/collection/MutableIntSet;", "mutableIntSetOf", "()Landroidx/collection/MutableIntSet;", "(I)Landroidx/collection/MutableIntSet;", "(II)Landroidx/collection/MutableIntSet;", "(III)Landroidx/collection/MutableIntSet;", "([I)Landroidx/collection/MutableIntSet;", "k", "hash", "(I)I", "b", "[I", "getEmptyIntArray", "()[I", "EmptyIntArray", "collection"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nIntSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntSet.kt\nandroidx/collection/IntSetKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,853:1\n1#2:854\n*E\n"})
/* loaded from: classes.dex */
public final class IntSetKt {

    /* renamed from: a */
    public static final MutableIntSet f1677a = new MutableIntSet(0);

    /* renamed from: b */
    public static final int[] f1678b = new int[0];

    @NotNull
    public static final IntSet emptyIntSet() {
        return f1677a;
    }

    @NotNull
    public static final int[] getEmptyIntArray() {
        return f1678b;
    }

    public static final int hash(int i) {
        int i2 = i * ScatterMapKt.MurmurHashC1;
        return i2 ^ (i2 << 16);
    }

    @NotNull
    public static final IntSet intSetOf() {
        return f1677a;
    }

    @NotNull
    public static final MutableIntSet mutableIntSetOf() {
        return new MutableIntSet(0, 1, null);
    }

    @NotNull
    public static final IntSet intSetOf(int i) {
        return mutableIntSetOf(i);
    }

    @NotNull
    public static final MutableIntSet mutableIntSetOf(int i) {
        MutableIntSet mutableIntSet = new MutableIntSet(1);
        mutableIntSet.plusAssign(i);
        return mutableIntSet;
    }

    @NotNull
    public static final IntSet intSetOf(int i, int i2) {
        return mutableIntSetOf(i, i2);
    }

    @NotNull
    public static final IntSet intSetOf(int i, int i2, int i3) {
        return mutableIntSetOf(i, i2, i3);
    }

    @NotNull
    public static final MutableIntSet mutableIntSetOf(int i, int i2) {
        MutableIntSet mutableIntSet = new MutableIntSet(2);
        mutableIntSet.plusAssign(i);
        mutableIntSet.plusAssign(i2);
        return mutableIntSet;
    }

    @NotNull
    public static final IntSet intSetOf(@NotNull int... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableIntSet mutableIntSet = new MutableIntSet(elements.length);
        mutableIntSet.plusAssign(elements);
        return mutableIntSet;
    }

    @NotNull
    public static final MutableIntSet mutableIntSetOf(int i, int i2, int i3) {
        MutableIntSet mutableIntSet = new MutableIntSet(3);
        mutableIntSet.plusAssign(i);
        mutableIntSet.plusAssign(i2);
        mutableIntSet.plusAssign(i3);
        return mutableIntSet;
    }

    @NotNull
    public static final MutableIntSet mutableIntSetOf(@NotNull int... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        MutableIntSet mutableIntSet = new MutableIntSet(elements.length);
        mutableIntSet.plusAssign(elements);
        return mutableIntSet;
    }
}
