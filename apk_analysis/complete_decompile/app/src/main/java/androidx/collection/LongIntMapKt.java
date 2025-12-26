package androidx.collection;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0002\u001a\u001d\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\b\u001a-\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u000b\u001a=\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u000e\u001aM\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0011\u001a]\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0014\u001a\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001d\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0018\u001a-\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0019\u001a=\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u001a\u001aM\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u001b\u001a]\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u001c¨\u0006\u001d"}, m5569d2 = {"Landroidx/collection/LongIntMap;", "emptyLongIntMap", "()Landroidx/collection/LongIntMap;", "longIntMapOf", "", "key1", "", "value1", "(JI)Landroidx/collection/LongIntMap;", "key2", "value2", "(JIJI)Landroidx/collection/LongIntMap;", "key3", "value3", "(JIJIJI)Landroidx/collection/LongIntMap;", "key4", "value4", "(JIJIJIJI)Landroidx/collection/LongIntMap;", "key5", "value5", "(JIJIJIJIJI)Landroidx/collection/LongIntMap;", "Landroidx/collection/MutableLongIntMap;", "mutableLongIntMapOf", "()Landroidx/collection/MutableLongIntMap;", "(JI)Landroidx/collection/MutableLongIntMap;", "(JIJI)Landroidx/collection/MutableLongIntMap;", "(JIJIJI)Landroidx/collection/MutableLongIntMap;", "(JIJIJIJI)Landroidx/collection/MutableLongIntMap;", "(JIJIJIJIJI)Landroidx/collection/MutableLongIntMap;", "collection"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class LongIntMapKt {

    /* renamed from: a */
    public static final MutableLongIntMap f1680a = new MutableLongIntMap(0);

    @NotNull
    public static final LongIntMap emptyLongIntMap() {
        return f1680a;
    }

    @NotNull
    public static final LongIntMap longIntMapOf() {
        return f1680a;
    }

    @NotNull
    public static final MutableLongIntMap mutableLongIntMapOf() {
        return new MutableLongIntMap(0, 1, null);
    }

    @NotNull
    public static final LongIntMap longIntMapOf(long j, int i) {
        MutableLongIntMap mutableLongIntMap = new MutableLongIntMap(0, 1, null);
        mutableLongIntMap.set(j, i);
        return mutableLongIntMap;
    }

    @NotNull
    public static final MutableLongIntMap mutableLongIntMapOf(long j, int i) {
        MutableLongIntMap mutableLongIntMap = new MutableLongIntMap(0, 1, null);
        mutableLongIntMap.set(j, i);
        return mutableLongIntMap;
    }

    @NotNull
    public static final LongIntMap longIntMapOf(long j, int i, long j2, int i2) {
        MutableLongIntMap mutableLongIntMap = new MutableLongIntMap(0, 1, null);
        mutableLongIntMap.set(j, i);
        mutableLongIntMap.set(j2, i2);
        return mutableLongIntMap;
    }

    @NotNull
    public static final MutableLongIntMap mutableLongIntMapOf(long j, int i, long j2, int i2) {
        MutableLongIntMap mutableLongIntMap = new MutableLongIntMap(0, 1, null);
        mutableLongIntMap.set(j, i);
        mutableLongIntMap.set(j2, i2);
        return mutableLongIntMap;
    }

    @NotNull
    public static final LongIntMap longIntMapOf(long j, int i, long j2, int i2, long j3, int i3) {
        MutableLongIntMap mutableLongIntMap = new MutableLongIntMap(0, 1, null);
        mutableLongIntMap.set(j, i);
        mutableLongIntMap.set(j2, i2);
        mutableLongIntMap.set(j3, i3);
        return mutableLongIntMap;
    }

    @NotNull
    public static final MutableLongIntMap mutableLongIntMapOf(long j, int i, long j2, int i2, long j3, int i3) {
        MutableLongIntMap mutableLongIntMap = new MutableLongIntMap(0, 1, null);
        mutableLongIntMap.set(j, i);
        mutableLongIntMap.set(j2, i2);
        mutableLongIntMap.set(j3, i3);
        return mutableLongIntMap;
    }

    @NotNull
    public static final LongIntMap longIntMapOf(long j, int i, long j2, int i2, long j3, int i3, long j4, int i4) {
        MutableLongIntMap mutableLongIntMap = new MutableLongIntMap(0, 1, null);
        mutableLongIntMap.set(j, i);
        mutableLongIntMap.set(j2, i2);
        mutableLongIntMap.set(j3, i3);
        mutableLongIntMap.set(j4, i4);
        return mutableLongIntMap;
    }

    @NotNull
    public static final MutableLongIntMap mutableLongIntMapOf(long j, int i, long j2, int i2, long j3, int i3, long j4, int i4) {
        MutableLongIntMap mutableLongIntMap = new MutableLongIntMap(0, 1, null);
        mutableLongIntMap.set(j, i);
        mutableLongIntMap.set(j2, i2);
        mutableLongIntMap.set(j3, i3);
        mutableLongIntMap.set(j4, i4);
        return mutableLongIntMap;
    }

    @NotNull
    public static final LongIntMap longIntMapOf(long j, int i, long j2, int i2, long j3, int i3, long j4, int i4, long j5, int i5) {
        MutableLongIntMap mutableLongIntMap = new MutableLongIntMap(0, 1, null);
        mutableLongIntMap.set(j, i);
        mutableLongIntMap.set(j2, i2);
        mutableLongIntMap.set(j3, i3);
        mutableLongIntMap.set(j4, i4);
        mutableLongIntMap.set(j5, i5);
        return mutableLongIntMap;
    }

    @NotNull
    public static final MutableLongIntMap mutableLongIntMapOf(long j, int i, long j2, int i2, long j3, int i3, long j4, int i4, long j5, int i5) {
        MutableLongIntMap mutableLongIntMap = new MutableLongIntMap(0, 1, null);
        mutableLongIntMap.set(j, i);
        mutableLongIntMap.set(j2, i2);
        mutableLongIntMap.set(j3, i3);
        mutableLongIntMap.set(j4, i4);
        mutableLongIntMap.set(j5, i5);
        return mutableLongIntMap;
    }
}
