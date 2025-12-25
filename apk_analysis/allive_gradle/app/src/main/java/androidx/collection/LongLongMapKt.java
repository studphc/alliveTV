package androidx.collection;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0002\u001a\u001d\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\u0007\u001a-\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\n\u001a=\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\r\u001aM\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\u0010\u001a]\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\u0013\u001a\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001d\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0017\u001a-\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0018\u001a=\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0019\u001aM\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u001a\u001a]\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u001b¨\u0006\u001c"}, m5569d2 = {"Landroidx/collection/LongLongMap;", "emptyLongLongMap", "()Landroidx/collection/LongLongMap;", "longLongMapOf", "", "key1", "value1", "(JJ)Landroidx/collection/LongLongMap;", "key2", "value2", "(JJJJ)Landroidx/collection/LongLongMap;", "key3", "value3", "(JJJJJJ)Landroidx/collection/LongLongMap;", "key4", "value4", "(JJJJJJJJ)Landroidx/collection/LongLongMap;", "key5", "value5", "(JJJJJJJJJJ)Landroidx/collection/LongLongMap;", "Landroidx/collection/MutableLongLongMap;", "mutableLongLongMapOf", "()Landroidx/collection/MutableLongLongMap;", "(JJ)Landroidx/collection/MutableLongLongMap;", "(JJJJ)Landroidx/collection/MutableLongLongMap;", "(JJJJJJ)Landroidx/collection/MutableLongLongMap;", "(JJJJJJJJ)Landroidx/collection/MutableLongLongMap;", "(JJJJJJJJJJ)Landroidx/collection/MutableLongLongMap;", "collection"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class LongLongMapKt {

    /* renamed from: a */
    public static final MutableLongLongMap f1682a = new MutableLongLongMap(0);

    @NotNull
    public static final LongLongMap emptyLongLongMap() {
        return f1682a;
    }

    @NotNull
    public static final LongLongMap longLongMapOf() {
        return f1682a;
    }

    @NotNull
    public static final MutableLongLongMap mutableLongLongMapOf() {
        return new MutableLongLongMap(0, 1, null);
    }

    @NotNull
    public static final LongLongMap longLongMapOf(long j, long j2) {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0, 1, null);
        mutableLongLongMap.set(j, j2);
        return mutableLongLongMap;
    }

    @NotNull
    public static final MutableLongLongMap mutableLongLongMapOf(long j, long j2) {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0, 1, null);
        mutableLongLongMap.set(j, j2);
        return mutableLongLongMap;
    }

    @NotNull
    public static final LongLongMap longLongMapOf(long j, long j2, long j3, long j4) {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0, 1, null);
        mutableLongLongMap.set(j, j2);
        mutableLongLongMap.set(j3, j4);
        return mutableLongLongMap;
    }

    @NotNull
    public static final MutableLongLongMap mutableLongLongMapOf(long j, long j2, long j3, long j4) {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0, 1, null);
        mutableLongLongMap.set(j, j2);
        mutableLongLongMap.set(j3, j4);
        return mutableLongLongMap;
    }

    @NotNull
    public static final LongLongMap longLongMapOf(long j, long j2, long j3, long j4, long j5, long j6) {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0, 1, null);
        mutableLongLongMap.set(j, j2);
        mutableLongLongMap.set(j3, j4);
        mutableLongLongMap.set(j5, j6);
        return mutableLongLongMap;
    }

    @NotNull
    public static final MutableLongLongMap mutableLongLongMapOf(long j, long j2, long j3, long j4, long j5, long j6) {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0, 1, null);
        mutableLongLongMap.set(j, j2);
        mutableLongLongMap.set(j3, j4);
        mutableLongLongMap.set(j5, j6);
        return mutableLongLongMap;
    }

    @NotNull
    public static final LongLongMap longLongMapOf(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0, 1, null);
        mutableLongLongMap.set(j, j2);
        mutableLongLongMap.set(j3, j4);
        mutableLongLongMap.set(j5, j6);
        mutableLongLongMap.set(j7, j8);
        return mutableLongLongMap;
    }

    @NotNull
    public static final MutableLongLongMap mutableLongLongMapOf(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0, 1, null);
        mutableLongLongMap.set(j, j2);
        mutableLongLongMap.set(j3, j4);
        mutableLongLongMap.set(j5, j6);
        mutableLongLongMap.set(j7, j8);
        return mutableLongLongMap;
    }

    @NotNull
    public static final LongLongMap longLongMapOf(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0, 1, null);
        mutableLongLongMap.set(j, j2);
        mutableLongLongMap.set(j3, j4);
        mutableLongLongMap.set(j5, j6);
        mutableLongLongMap.set(j7, j8);
        mutableLongLongMap.set(j9, j10);
        return mutableLongLongMap;
    }

    @NotNull
    public static final MutableLongLongMap mutableLongLongMapOf(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
        MutableLongLongMap mutableLongLongMap = new MutableLongLongMap(0, 1, null);
        mutableLongLongMap.set(j, j2);
        mutableLongLongMap.set(j3, j4);
        mutableLongLongMap.set(j5, j6);
        mutableLongLongMap.set(j7, j8);
        mutableLongLongMap.set(j9, j10);
        return mutableLongLongMap;
    }
}
