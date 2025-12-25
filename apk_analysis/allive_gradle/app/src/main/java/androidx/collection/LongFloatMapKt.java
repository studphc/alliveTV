package androidx.collection;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0002\u001a\u001d\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\b\u001a-\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u000b\u001a=\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u000e\u001aM\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0011\u001a]\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0014\u001a\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001d\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0018\u001a-\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0019\u001a=\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u001a\u001aM\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u001b\u001a]\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u001c¨\u0006\u001d"}, m5569d2 = {"Landroidx/collection/LongFloatMap;", "emptyLongFloatMap", "()Landroidx/collection/LongFloatMap;", "longFloatMapOf", "", "key1", "", "value1", "(JF)Landroidx/collection/LongFloatMap;", "key2", "value2", "(JFJF)Landroidx/collection/LongFloatMap;", "key3", "value3", "(JFJFJF)Landroidx/collection/LongFloatMap;", "key4", "value4", "(JFJFJFJF)Landroidx/collection/LongFloatMap;", "key5", "value5", "(JFJFJFJFJF)Landroidx/collection/LongFloatMap;", "Landroidx/collection/MutableLongFloatMap;", "mutableLongFloatMapOf", "()Landroidx/collection/MutableLongFloatMap;", "(JF)Landroidx/collection/MutableLongFloatMap;", "(JFJF)Landroidx/collection/MutableLongFloatMap;", "(JFJFJF)Landroidx/collection/MutableLongFloatMap;", "(JFJFJFJF)Landroidx/collection/MutableLongFloatMap;", "(JFJFJFJFJF)Landroidx/collection/MutableLongFloatMap;", "collection"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class LongFloatMapKt {

    /* renamed from: a */
    public static final MutableLongFloatMap f1679a = new MutableLongFloatMap(0);

    @NotNull
    public static final LongFloatMap emptyLongFloatMap() {
        return f1679a;
    }

    @NotNull
    public static final LongFloatMap longFloatMapOf() {
        return f1679a;
    }

    @NotNull
    public static final MutableLongFloatMap mutableLongFloatMapOf() {
        return new MutableLongFloatMap(0, 1, null);
    }

    @NotNull
    public static final LongFloatMap longFloatMapOf(long j, float f) {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0, 1, null);
        mutableLongFloatMap.set(j, f);
        return mutableLongFloatMap;
    }

    @NotNull
    public static final MutableLongFloatMap mutableLongFloatMapOf(long j, float f) {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0, 1, null);
        mutableLongFloatMap.set(j, f);
        return mutableLongFloatMap;
    }

    @NotNull
    public static final LongFloatMap longFloatMapOf(long j, float f, long j2, float f2) {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0, 1, null);
        mutableLongFloatMap.set(j, f);
        mutableLongFloatMap.set(j2, f2);
        return mutableLongFloatMap;
    }

    @NotNull
    public static final MutableLongFloatMap mutableLongFloatMapOf(long j, float f, long j2, float f2) {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0, 1, null);
        mutableLongFloatMap.set(j, f);
        mutableLongFloatMap.set(j2, f2);
        return mutableLongFloatMap;
    }

    @NotNull
    public static final LongFloatMap longFloatMapOf(long j, float f, long j2, float f2, long j3, float f3) {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0, 1, null);
        mutableLongFloatMap.set(j, f);
        mutableLongFloatMap.set(j2, f2);
        mutableLongFloatMap.set(j3, f3);
        return mutableLongFloatMap;
    }

    @NotNull
    public static final MutableLongFloatMap mutableLongFloatMapOf(long j, float f, long j2, float f2, long j3, float f3) {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0, 1, null);
        mutableLongFloatMap.set(j, f);
        mutableLongFloatMap.set(j2, f2);
        mutableLongFloatMap.set(j3, f3);
        return mutableLongFloatMap;
    }

    @NotNull
    public static final LongFloatMap longFloatMapOf(long j, float f, long j2, float f2, long j3, float f3, long j4, float f4) {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0, 1, null);
        mutableLongFloatMap.set(j, f);
        mutableLongFloatMap.set(j2, f2);
        mutableLongFloatMap.set(j3, f3);
        mutableLongFloatMap.set(j4, f4);
        return mutableLongFloatMap;
    }

    @NotNull
    public static final MutableLongFloatMap mutableLongFloatMapOf(long j, float f, long j2, float f2, long j3, float f3, long j4, float f4) {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0, 1, null);
        mutableLongFloatMap.set(j, f);
        mutableLongFloatMap.set(j2, f2);
        mutableLongFloatMap.set(j3, f3);
        mutableLongFloatMap.set(j4, f4);
        return mutableLongFloatMap;
    }

    @NotNull
    public static final LongFloatMap longFloatMapOf(long j, float f, long j2, float f2, long j3, float f3, long j4, float f4, long j5, float f5) {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0, 1, null);
        mutableLongFloatMap.set(j, f);
        mutableLongFloatMap.set(j2, f2);
        mutableLongFloatMap.set(j3, f3);
        mutableLongFloatMap.set(j4, f4);
        mutableLongFloatMap.set(j5, f5);
        return mutableLongFloatMap;
    }

    @NotNull
    public static final MutableLongFloatMap mutableLongFloatMapOf(long j, float f, long j2, float f2, long j3, float f3, long j4, float f4, long j5, float f5) {
        MutableLongFloatMap mutableLongFloatMap = new MutableLongFloatMap(0, 1, null);
        mutableLongFloatMap.set(j, f);
        mutableLongFloatMap.set(j2, f2);
        mutableLongFloatMap.set(j3, f3);
        mutableLongFloatMap.set(j4, f4);
        mutableLongFloatMap.set(j5, f5);
        return mutableLongFloatMap;
    }
}
