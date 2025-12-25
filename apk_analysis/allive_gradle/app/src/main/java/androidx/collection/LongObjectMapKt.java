package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a)\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\b\u001a9\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u000b\u001aI\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u000e\u001aY\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0011\u001ai\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0014\u001a\u0019\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a)\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\u0016\u0010\u0018\u001a9\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u0016\u0010\u0019\u001aI\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0004\b\u0016\u0010\u001a\u001aY\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u0016\u0010\u001b\u001ai\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u0016\u0010\u001c¨\u0006\u001d"}, m5569d2 = {ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/collection/LongObjectMap;", "emptyLongObjectMap", "()Landroidx/collection/LongObjectMap;", "longObjectMapOf", "", "key1", "value1", "(JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "key2", "value2", "(JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "key3", "value3", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "key4", "value4", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "key5", "value5", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/LongObjectMap;", "Landroidx/collection/MutableLongObjectMap;", "mutableLongObjectMapOf", "()Landroidx/collection/MutableLongObjectMap;", "(JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "(JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "(JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;)Landroidx/collection/MutableLongObjectMap;", "collection"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class LongObjectMapKt {

    /* renamed from: a */
    public static final MutableLongObjectMap f1685a = new MutableLongObjectMap(0);

    @NotNull
    public static final <V> LongObjectMap<V> emptyLongObjectMap() {
        MutableLongObjectMap mutableLongObjectMap = f1685a;
        Intrinsics.checkNotNull(mutableLongObjectMap, "null cannot be cast to non-null type androidx.collection.LongObjectMap<V of androidx.collection.LongObjectMapKt.emptyLongObjectMap>");
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> LongObjectMap<V> longObjectMapOf() {
        MutableLongObjectMap mutableLongObjectMap = f1685a;
        Intrinsics.checkNotNull(mutableLongObjectMap, "null cannot be cast to non-null type androidx.collection.LongObjectMap<V of androidx.collection.LongObjectMapKt.longObjectMapOf>");
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf() {
        return new MutableLongObjectMap<>(0, 1, null);
    }

    @NotNull
    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v);
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v);
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v, long j2, V v2) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j2, v2);
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v, long j2, V v2) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j2, v2);
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v, long j2, V v2, long j3, V v3) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j2, v2);
        mutableLongObjectMap.set(j3, v3);
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v, long j2, V v2, long j3, V v3) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j2, v2);
        mutableLongObjectMap.set(j3, v3);
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v, long j2, V v2, long j3, V v3, long j4, V v4) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j2, v2);
        mutableLongObjectMap.set(j3, v3);
        mutableLongObjectMap.set(j4, v4);
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v, long j2, V v2, long j3, V v3, long j4, V v4) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j2, v2);
        mutableLongObjectMap.set(j3, v3);
        mutableLongObjectMap.set(j4, v4);
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v, long j2, V v2, long j3, V v3, long j4, V v4, long j5, V v5) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j2, v2);
        mutableLongObjectMap.set(j3, v3);
        mutableLongObjectMap.set(j4, v4);
        mutableLongObjectMap.set(j5, v5);
        return mutableLongObjectMap;
    }

    @NotNull
    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v, long j2, V v2, long j3, V v3, long j4, V v4, long j5, V v5) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j2, v2);
        mutableLongObjectMap.set(j3, v3);
        mutableLongObjectMap.set(j4, v4);
        mutableLongObjectMap.set(j5, v5);
        return mutableLongObjectMap;
    }
}
