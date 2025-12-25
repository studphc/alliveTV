package androidx.collection;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0002\u001a\u001d\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\b\u001a-\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u000b\u001a=\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u000e\u001aM\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0011\u001a]\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0014\u001a\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001d\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0018\u001a-\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0019\u001a=\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u001a\u001aM\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u001b\u001a]\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u001c¨\u0006\u001d"}, m5569d2 = {"Landroidx/collection/IntLongMap;", "emptyIntLongMap", "()Landroidx/collection/IntLongMap;", "intLongMapOf", "", "key1", "", "value1", "(IJ)Landroidx/collection/IntLongMap;", "key2", "value2", "(IJIJ)Landroidx/collection/IntLongMap;", "key3", "value3", "(IJIJIJ)Landroidx/collection/IntLongMap;", "key4", "value4", "(IJIJIJIJ)Landroidx/collection/IntLongMap;", "key5", "value5", "(IJIJIJIJIJ)Landroidx/collection/IntLongMap;", "Landroidx/collection/MutableIntLongMap;", "mutableIntLongMapOf", "()Landroidx/collection/MutableIntLongMap;", "(IJ)Landroidx/collection/MutableIntLongMap;", "(IJIJ)Landroidx/collection/MutableIntLongMap;", "(IJIJIJ)Landroidx/collection/MutableIntLongMap;", "(IJIJIJIJ)Landroidx/collection/MutableIntLongMap;", "(IJIJIJIJIJ)Landroidx/collection/MutableIntLongMap;", "collection"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class IntLongMapKt {

    /* renamed from: a */
    public static final MutableIntLongMap f1675a = new MutableIntLongMap(0);

    @NotNull
    public static final IntLongMap emptyIntLongMap() {
        return f1675a;
    }

    @NotNull
    public static final IntLongMap intLongMapOf() {
        return f1675a;
    }

    @NotNull
    public static final MutableIntLongMap mutableIntLongMapOf() {
        return new MutableIntLongMap(0, 1, null);
    }

    @NotNull
    public static final IntLongMap intLongMapOf(int i, long j) {
        MutableIntLongMap mutableIntLongMap = new MutableIntLongMap(0, 1, null);
        mutableIntLongMap.set(i, j);
        return mutableIntLongMap;
    }

    @NotNull
    public static final MutableIntLongMap mutableIntLongMapOf(int i, long j) {
        MutableIntLongMap mutableIntLongMap = new MutableIntLongMap(0, 1, null);
        mutableIntLongMap.set(i, j);
        return mutableIntLongMap;
    }

    @NotNull
    public static final IntLongMap intLongMapOf(int i, long j, int i2, long j2) {
        MutableIntLongMap mutableIntLongMap = new MutableIntLongMap(0, 1, null);
        mutableIntLongMap.set(i, j);
        mutableIntLongMap.set(i2, j2);
        return mutableIntLongMap;
    }

    @NotNull
    public static final MutableIntLongMap mutableIntLongMapOf(int i, long j, int i2, long j2) {
        MutableIntLongMap mutableIntLongMap = new MutableIntLongMap(0, 1, null);
        mutableIntLongMap.set(i, j);
        mutableIntLongMap.set(i2, j2);
        return mutableIntLongMap;
    }

    @NotNull
    public static final IntLongMap intLongMapOf(int i, long j, int i2, long j2, int i3, long j3) {
        MutableIntLongMap mutableIntLongMap = new MutableIntLongMap(0, 1, null);
        mutableIntLongMap.set(i, j);
        mutableIntLongMap.set(i2, j2);
        mutableIntLongMap.set(i3, j3);
        return mutableIntLongMap;
    }

    @NotNull
    public static final MutableIntLongMap mutableIntLongMapOf(int i, long j, int i2, long j2, int i3, long j3) {
        MutableIntLongMap mutableIntLongMap = new MutableIntLongMap(0, 1, null);
        mutableIntLongMap.set(i, j);
        mutableIntLongMap.set(i2, j2);
        mutableIntLongMap.set(i3, j3);
        return mutableIntLongMap;
    }

    @NotNull
    public static final IntLongMap intLongMapOf(int i, long j, int i2, long j2, int i3, long j3, int i4, long j4) {
        MutableIntLongMap mutableIntLongMap = new MutableIntLongMap(0, 1, null);
        mutableIntLongMap.set(i, j);
        mutableIntLongMap.set(i2, j2);
        mutableIntLongMap.set(i3, j3);
        mutableIntLongMap.set(i4, j4);
        return mutableIntLongMap;
    }

    @NotNull
    public static final MutableIntLongMap mutableIntLongMapOf(int i, long j, int i2, long j2, int i3, long j3, int i4, long j4) {
        MutableIntLongMap mutableIntLongMap = new MutableIntLongMap(0, 1, null);
        mutableIntLongMap.set(i, j);
        mutableIntLongMap.set(i2, j2);
        mutableIntLongMap.set(i3, j3);
        mutableIntLongMap.set(i4, j4);
        return mutableIntLongMap;
    }

    @NotNull
    public static final IntLongMap intLongMapOf(int i, long j, int i2, long j2, int i3, long j3, int i4, long j4, int i5, long j5) {
        MutableIntLongMap mutableIntLongMap = new MutableIntLongMap(0, 1, null);
        mutableIntLongMap.set(i, j);
        mutableIntLongMap.set(i2, j2);
        mutableIntLongMap.set(i3, j3);
        mutableIntLongMap.set(i4, j4);
        mutableIntLongMap.set(i5, j5);
        return mutableIntLongMap;
    }

    @NotNull
    public static final MutableIntLongMap mutableIntLongMapOf(int i, long j, int i2, long j2, int i3, long j3, int i4, long j4, int i5, long j5) {
        MutableIntLongMap mutableIntLongMap = new MutableIntLongMap(0, 1, null);
        mutableIntLongMap.set(i, j);
        mutableIntLongMap.set(i2, j2);
        mutableIntLongMap.set(i3, j3);
        mutableIntLongMap.set(i4, j4);
        mutableIntLongMap.set(i5, j5);
        return mutableIntLongMap;
    }
}
