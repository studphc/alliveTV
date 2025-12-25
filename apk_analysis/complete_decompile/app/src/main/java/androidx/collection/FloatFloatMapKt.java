package androidx.collection;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0002\u001a\u001d\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\u0007\u001a-\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\n\u001a=\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\r\u001aM\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\u0010\u001a]\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0003\u0010\u0013\u001a\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001d\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0017\u001a-\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0018\u001a=\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0019\u001aM\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u001a\u001a]\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u001b¨\u0006\u001c"}, m5569d2 = {"Landroidx/collection/FloatFloatMap;", "emptyFloatFloatMap", "()Landroidx/collection/FloatFloatMap;", "floatFloatMapOf", "", "key1", "value1", "(FF)Landroidx/collection/FloatFloatMap;", "key2", "value2", "(FFFF)Landroidx/collection/FloatFloatMap;", "key3", "value3", "(FFFFFF)Landroidx/collection/FloatFloatMap;", "key4", "value4", "(FFFFFFFF)Landroidx/collection/FloatFloatMap;", "key5", "value5", "(FFFFFFFFFF)Landroidx/collection/FloatFloatMap;", "Landroidx/collection/MutableFloatFloatMap;", "mutableFloatFloatMapOf", "()Landroidx/collection/MutableFloatFloatMap;", "(FF)Landroidx/collection/MutableFloatFloatMap;", "(FFFF)Landroidx/collection/MutableFloatFloatMap;", "(FFFFFF)Landroidx/collection/MutableFloatFloatMap;", "(FFFFFFFF)Landroidx/collection/MutableFloatFloatMap;", "(FFFFFFFFFF)Landroidx/collection/MutableFloatFloatMap;", "collection"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class FloatFloatMapKt {

    /* renamed from: a */
    public static final MutableFloatFloatMap f1662a = new MutableFloatFloatMap(0);

    @NotNull
    public static final FloatFloatMap emptyFloatFloatMap() {
        return f1662a;
    }

    @NotNull
    public static final FloatFloatMap floatFloatMapOf() {
        return f1662a;
    }

    @NotNull
    public static final MutableFloatFloatMap mutableFloatFloatMapOf() {
        return new MutableFloatFloatMap(0, 1, null);
    }

    @NotNull
    public static final FloatFloatMap floatFloatMapOf(float f, float f2) {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0, 1, null);
        mutableFloatFloatMap.set(f, f2);
        return mutableFloatFloatMap;
    }

    @NotNull
    public static final MutableFloatFloatMap mutableFloatFloatMapOf(float f, float f2) {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0, 1, null);
        mutableFloatFloatMap.set(f, f2);
        return mutableFloatFloatMap;
    }

    @NotNull
    public static final FloatFloatMap floatFloatMapOf(float f, float f2, float f3, float f4) {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0, 1, null);
        mutableFloatFloatMap.set(f, f2);
        mutableFloatFloatMap.set(f3, f4);
        return mutableFloatFloatMap;
    }

    @NotNull
    public static final MutableFloatFloatMap mutableFloatFloatMapOf(float f, float f2, float f3, float f4) {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0, 1, null);
        mutableFloatFloatMap.set(f, f2);
        mutableFloatFloatMap.set(f3, f4);
        return mutableFloatFloatMap;
    }

    @NotNull
    public static final FloatFloatMap floatFloatMapOf(float f, float f2, float f3, float f4, float f5, float f6) {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0, 1, null);
        mutableFloatFloatMap.set(f, f2);
        mutableFloatFloatMap.set(f3, f4);
        mutableFloatFloatMap.set(f5, f6);
        return mutableFloatFloatMap;
    }

    @NotNull
    public static final MutableFloatFloatMap mutableFloatFloatMapOf(float f, float f2, float f3, float f4, float f5, float f6) {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0, 1, null);
        mutableFloatFloatMap.set(f, f2);
        mutableFloatFloatMap.set(f3, f4);
        mutableFloatFloatMap.set(f5, f6);
        return mutableFloatFloatMap;
    }

    @NotNull
    public static final FloatFloatMap floatFloatMapOf(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0, 1, null);
        mutableFloatFloatMap.set(f, f2);
        mutableFloatFloatMap.set(f3, f4);
        mutableFloatFloatMap.set(f5, f6);
        mutableFloatFloatMap.set(f7, f8);
        return mutableFloatFloatMap;
    }

    @NotNull
    public static final MutableFloatFloatMap mutableFloatFloatMapOf(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0, 1, null);
        mutableFloatFloatMap.set(f, f2);
        mutableFloatFloatMap.set(f3, f4);
        mutableFloatFloatMap.set(f5, f6);
        mutableFloatFloatMap.set(f7, f8);
        return mutableFloatFloatMap;
    }

    @NotNull
    public static final FloatFloatMap floatFloatMapOf(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0, 1, null);
        mutableFloatFloatMap.set(f, f2);
        mutableFloatFloatMap.set(f3, f4);
        mutableFloatFloatMap.set(f5, f6);
        mutableFloatFloatMap.set(f7, f8);
        mutableFloatFloatMap.set(f9, f10);
        return mutableFloatFloatMap;
    }

    @NotNull
    public static final MutableFloatFloatMap mutableFloatFloatMapOf(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        MutableFloatFloatMap mutableFloatFloatMap = new MutableFloatFloatMap(0, 1, null);
        mutableFloatFloatMap.set(f, f2);
        mutableFloatFloatMap.set(f3, f4);
        mutableFloatFloatMap.set(f5, f6);
        mutableFloatFloatMap.set(f7, f8);
        mutableFloatFloatMap.set(f9, f10);
        return mutableFloatFloatMap;
    }
}
