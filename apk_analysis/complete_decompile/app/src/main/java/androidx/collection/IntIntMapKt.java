package androidx.collection;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0002\u001a\u001d\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\u0007\u001a-\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\n\u001a=\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\r\u001aM\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\u0010\u001a]\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\u0013\u001a\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001d\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0017\u001a-\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0018\u001a=\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0019\u001aM\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u001a\u001a]\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u001b¨\u0006\u001c"}, m5569d2 = {"Landroidx/collection/IntIntMap;", "emptyIntIntMap", "()Landroidx/collection/IntIntMap;", "intIntMapOf", "", "key1", "value1", "(II)Landroidx/collection/IntIntMap;", "key2", "value2", "(IIII)Landroidx/collection/IntIntMap;", "key3", "value3", "(IIIIII)Landroidx/collection/IntIntMap;", "key4", "value4", "(IIIIIIII)Landroidx/collection/IntIntMap;", "key5", "value5", "(IIIIIIIIII)Landroidx/collection/IntIntMap;", "Landroidx/collection/MutableIntIntMap;", "mutableIntIntMapOf", "()Landroidx/collection/MutableIntIntMap;", "(II)Landroidx/collection/MutableIntIntMap;", "(IIII)Landroidx/collection/MutableIntIntMap;", "(IIIIII)Landroidx/collection/MutableIntIntMap;", "(IIIIIIII)Landroidx/collection/MutableIntIntMap;", "(IIIIIIIIII)Landroidx/collection/MutableIntIntMap;", "collection"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class IntIntMapKt {

    /* renamed from: a */
    public static final MutableIntIntMap f1673a = new MutableIntIntMap(0);

    @NotNull
    public static final IntIntMap emptyIntIntMap() {
        return f1673a;
    }

    @NotNull
    public static final IntIntMap intIntMapOf() {
        return f1673a;
    }

    @NotNull
    public static final MutableIntIntMap mutableIntIntMapOf() {
        return new MutableIntIntMap(0, 1, null);
    }

    @NotNull
    public static final IntIntMap intIntMapOf(int i, int i2) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i2);
        return mutableIntIntMap;
    }

    @NotNull
    public static final MutableIntIntMap mutableIntIntMapOf(int i, int i2) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i2);
        return mutableIntIntMap;
    }

    @NotNull
    public static final IntIntMap intIntMapOf(int i, int i2, int i3, int i4) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i2);
        mutableIntIntMap.set(i3, i4);
        return mutableIntIntMap;
    }

    @NotNull
    public static final MutableIntIntMap mutableIntIntMapOf(int i, int i2, int i3, int i4) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i2);
        mutableIntIntMap.set(i3, i4);
        return mutableIntIntMap;
    }

    @NotNull
    public static final IntIntMap intIntMapOf(int i, int i2, int i3, int i4, int i5, int i6) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i2);
        mutableIntIntMap.set(i3, i4);
        mutableIntIntMap.set(i5, i6);
        return mutableIntIntMap;
    }

    @NotNull
    public static final MutableIntIntMap mutableIntIntMapOf(int i, int i2, int i3, int i4, int i5, int i6) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i2);
        mutableIntIntMap.set(i3, i4);
        mutableIntIntMap.set(i5, i6);
        return mutableIntIntMap;
    }

    @NotNull
    public static final IntIntMap intIntMapOf(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i2);
        mutableIntIntMap.set(i3, i4);
        mutableIntIntMap.set(i5, i6);
        mutableIntIntMap.set(i7, i8);
        return mutableIntIntMap;
    }

    @NotNull
    public static final MutableIntIntMap mutableIntIntMapOf(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i2);
        mutableIntIntMap.set(i3, i4);
        mutableIntIntMap.set(i5, i6);
        mutableIntIntMap.set(i7, i8);
        return mutableIntIntMap;
    }

    @NotNull
    public static final IntIntMap intIntMapOf(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i2);
        mutableIntIntMap.set(i3, i4);
        mutableIntIntMap.set(i5, i6);
        mutableIntIntMap.set(i7, i8);
        mutableIntIntMap.set(i9, i10);
        return mutableIntIntMap;
    }

    @NotNull
    public static final MutableIntIntMap mutableIntIntMapOf(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        MutableIntIntMap mutableIntIntMap = new MutableIntIntMap(0, 1, null);
        mutableIntIntMap.set(i, i2);
        mutableIntIntMap.set(i3, i4);
        mutableIntIntMap.set(i5, i6);
        mutableIntIntMap.set(i7, i8);
        mutableIntIntMap.set(i9, i10);
        return mutableIntIntMap;
    }
}
