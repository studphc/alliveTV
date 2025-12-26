package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a)\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a9\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\f\u001aI\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\u000f\u001aY\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\u0012\u001ai\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\u0015\u001a\u0019\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a)\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0019\u001a9\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u001a\u001aI\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u001b\u001aY\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u001c\u001ai\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u001d¨\u0006\u001e"}, m5569d2 = {"K", "Landroidx/collection/ObjectFloatMap;", "emptyObjectFloatMap", "()Landroidx/collection/ObjectFloatMap;", "objectFloatMap", "key1", "", "value1", "objectFloatMapOf", "(Ljava/lang/Object;F)Landroidx/collection/ObjectFloatMap;", "key2", "value2", "(Ljava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/ObjectFloatMap;", "key3", "value3", "(Ljava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/ObjectFloatMap;", "key4", "value4", "(Ljava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/ObjectFloatMap;", "key5", "value5", "(Ljava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/ObjectFloatMap;", "Landroidx/collection/MutableObjectFloatMap;", "mutableObjectFloatMapOf", "()Landroidx/collection/MutableObjectFloatMap;", "(Ljava/lang/Object;F)Landroidx/collection/MutableObjectFloatMap;", "(Ljava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/MutableObjectFloatMap;", "(Ljava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/MutableObjectFloatMap;", "(Ljava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/MutableObjectFloatMap;", "(Ljava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;FLjava/lang/Object;F)Landroidx/collection/MutableObjectFloatMap;", "collection"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class ObjectFloatMapKt {

    /* renamed from: a */
    public static final MutableObjectFloatMap f1741a = new MutableObjectFloatMap(0);

    @NotNull
    public static final <K> ObjectFloatMap<K> emptyObjectFloatMap() {
        MutableObjectFloatMap mutableObjectFloatMap = f1741a;
        Intrinsics.checkNotNull(mutableObjectFloatMap, "null cannot be cast to non-null type androidx.collection.ObjectFloatMap<K of androidx.collection.ObjectFloatMapKt.emptyObjectFloatMap>");
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf() {
        return new MutableObjectFloatMap<>(0, 1, null);
    }

    @NotNull
    public static final <K> ObjectFloatMap<K> objectFloatMap() {
        MutableObjectFloatMap mutableObjectFloatMap = f1741a;
        Intrinsics.checkNotNull(mutableObjectFloatMap, "null cannot be cast to non-null type androidx.collection.ObjectFloatMap<K of androidx.collection.ObjectFloatMapKt.objectFloatMap>");
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K k, float f) {
        MutableObjectFloatMap mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, null);
        mutableObjectFloatMap.set(k, f);
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K k, float f) {
        MutableObjectFloatMap<K> mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
        mutableObjectFloatMap.set(k, f);
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K k, float f, K k2, float f2) {
        MutableObjectFloatMap mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, null);
        mutableObjectFloatMap.set(k, f);
        mutableObjectFloatMap.set(k2, f2);
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K k, float f, K k2, float f2) {
        MutableObjectFloatMap<K> mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
        mutableObjectFloatMap.set(k, f);
        mutableObjectFloatMap.set(k2, f2);
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K k, float f, K k2, float f2, K k3, float f3) {
        MutableObjectFloatMap mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, null);
        mutableObjectFloatMap.set(k, f);
        mutableObjectFloatMap.set(k2, f2);
        mutableObjectFloatMap.set(k3, f3);
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K k, float f, K k2, float f2, K k3, float f3) {
        MutableObjectFloatMap<K> mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
        mutableObjectFloatMap.set(k, f);
        mutableObjectFloatMap.set(k2, f2);
        mutableObjectFloatMap.set(k3, f3);
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K k, float f, K k2, float f2, K k3, float f3, K k4, float f4) {
        MutableObjectFloatMap mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, null);
        mutableObjectFloatMap.set(k, f);
        mutableObjectFloatMap.set(k2, f2);
        mutableObjectFloatMap.set(k3, f3);
        mutableObjectFloatMap.set(k4, f4);
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K k, float f, K k2, float f2, K k3, float f3, K k4, float f4) {
        MutableObjectFloatMap<K> mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
        mutableObjectFloatMap.set(k, f);
        mutableObjectFloatMap.set(k2, f2);
        mutableObjectFloatMap.set(k3, f3);
        mutableObjectFloatMap.set(k4, f4);
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K k, float f, K k2, float f2, K k3, float f3, K k4, float f4, K k5, float f5) {
        MutableObjectFloatMap mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, null);
        mutableObjectFloatMap.set(k, f);
        mutableObjectFloatMap.set(k2, f2);
        mutableObjectFloatMap.set(k3, f3);
        mutableObjectFloatMap.set(k4, f4);
        mutableObjectFloatMap.set(k5, f5);
        return mutableObjectFloatMap;
    }

    @NotNull
    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K k, float f, K k2, float f2, K k3, float f3, K k4, float f4, K k5, float f5) {
        MutableObjectFloatMap<K> mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
        mutableObjectFloatMap.set(k, f);
        mutableObjectFloatMap.set(k2, f2);
        mutableObjectFloatMap.set(k3, f3);
        mutableObjectFloatMap.set(k4, f4);
        mutableObjectFloatMap.set(k5, f5);
        return mutableObjectFloatMap;
    }
}
