package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a)\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a9\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\f\u001aI\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\u000f\u001aY\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\u0012\u001ai\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\u0015\u001a\u0019\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a)\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0019\u001a9\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u001a\u001aI\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u001b\u001aY\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u001c\u001ai\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u001d¨\u0006\u001e"}, m5569d2 = {"K", "Landroidx/collection/ObjectLongMap;", "emptyObjectLongMap", "()Landroidx/collection/ObjectLongMap;", "objectLongMap", "key1", "", "value1", "objectLongMapOf", "(Ljava/lang/Object;J)Landroidx/collection/ObjectLongMap;", "key2", "value2", "(Ljava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/ObjectLongMap;", "key3", "value3", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/ObjectLongMap;", "key4", "value4", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/ObjectLongMap;", "key5", "value5", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/ObjectLongMap;", "Landroidx/collection/MutableObjectLongMap;", "mutableObjectLongMapOf", "()Landroidx/collection/MutableObjectLongMap;", "(Ljava/lang/Object;J)Landroidx/collection/MutableObjectLongMap;", "(Ljava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/MutableObjectLongMap;", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/MutableObjectLongMap;", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/MutableObjectLongMap;", "(Ljava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;JLjava/lang/Object;J)Landroidx/collection/MutableObjectLongMap;", "collection"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class ObjectLongMapKt {

    /* renamed from: a */
    public static final MutableObjectLongMap f1745a = new MutableObjectLongMap(0);

    @NotNull
    public static final <K> ObjectLongMap<K> emptyObjectLongMap() {
        MutableObjectLongMap mutableObjectLongMap = f1745a;
        Intrinsics.checkNotNull(mutableObjectLongMap, "null cannot be cast to non-null type androidx.collection.ObjectLongMap<K of androidx.collection.ObjectLongMapKt.emptyObjectLongMap>");
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf() {
        return new MutableObjectLongMap<>(0, 1, null);
    }

    @NotNull
    public static final <K> ObjectLongMap<K> objectLongMap() {
        MutableObjectLongMap mutableObjectLongMap = f1745a;
        Intrinsics.checkNotNull(mutableObjectLongMap, "null cannot be cast to non-null type androidx.collection.ObjectLongMap<K of androidx.collection.ObjectLongMapKt.objectLongMap>");
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> ObjectLongMap<K> objectLongMapOf(K k, long j) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, null);
        mutableObjectLongMap.set(k, j);
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k, long j) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, null);
        mutableObjectLongMap.set(k, j);
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> ObjectLongMap<K> objectLongMapOf(K k, long j, K k2, long j2) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k2, j2);
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k, long j, K k2, long j2) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k2, j2);
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> ObjectLongMap<K> objectLongMapOf(K k, long j, K k2, long j2, K k3, long j3) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k2, j2);
        mutableObjectLongMap.set(k3, j3);
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k, long j, K k2, long j2, K k3, long j3) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k2, j2);
        mutableObjectLongMap.set(k3, j3);
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> ObjectLongMap<K> objectLongMapOf(K k, long j, K k2, long j2, K k3, long j3, K k4, long j4) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k2, j2);
        mutableObjectLongMap.set(k3, j3);
        mutableObjectLongMap.set(k4, j4);
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k, long j, K k2, long j2, K k3, long j3, K k4, long j4) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k2, j2);
        mutableObjectLongMap.set(k3, j3);
        mutableObjectLongMap.set(k4, j4);
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> ObjectLongMap<K> objectLongMapOf(K k, long j, K k2, long j2, K k3, long j3, K k4, long j4, K k5, long j5) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k2, j2);
        mutableObjectLongMap.set(k3, j3);
        mutableObjectLongMap.set(k4, j4);
        mutableObjectLongMap.set(k5, j5);
        return mutableObjectLongMap;
    }

    @NotNull
    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k, long j, K k2, long j2, K k3, long j3, K k4, long j4, K k5, long j5) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, null);
        mutableObjectLongMap.set(k, j);
        mutableObjectLongMap.set(k2, j2);
        mutableObjectLongMap.set(k3, j3);
        mutableObjectLongMap.set(k4, j4);
        mutableObjectLongMap.set(k5, j5);
        return mutableObjectLongMap;
    }
}
