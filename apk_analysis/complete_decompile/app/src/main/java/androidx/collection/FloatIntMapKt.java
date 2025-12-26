package androidx.collection;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0002\u001a\u001d\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\b\u001a-\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u000b\u001a=\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u000e\u001aM\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0011\u001a]\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0003\u0010\u0014\u001a\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001d\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0018\u001a-\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0019\u001a=\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u001a\u001aM\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u001b\u001a]\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u001c¨\u0006\u001d"}, m5569d2 = {"Landroidx/collection/FloatIntMap;", "emptyFloatIntMap", "()Landroidx/collection/FloatIntMap;", "floatIntMapOf", "", "key1", "", "value1", "(FI)Landroidx/collection/FloatIntMap;", "key2", "value2", "(FIFI)Landroidx/collection/FloatIntMap;", "key3", "value3", "(FIFIFI)Landroidx/collection/FloatIntMap;", "key4", "value4", "(FIFIFIFI)Landroidx/collection/FloatIntMap;", "key5", "value5", "(FIFIFIFIFI)Landroidx/collection/FloatIntMap;", "Landroidx/collection/MutableFloatIntMap;", "mutableFloatIntMapOf", "()Landroidx/collection/MutableFloatIntMap;", "(FI)Landroidx/collection/MutableFloatIntMap;", "(FIFI)Landroidx/collection/MutableFloatIntMap;", "(FIFIFI)Landroidx/collection/MutableFloatIntMap;", "(FIFIFIFI)Landroidx/collection/MutableFloatIntMap;", "(FIFIFIFIFI)Landroidx/collection/MutableFloatIntMap;", "collection"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes.dex */
public final class FloatIntMapKt {

    /* renamed from: a */
    public static final MutableFloatIntMap f1663a = new MutableFloatIntMap(0);

    @NotNull
    public static final FloatIntMap emptyFloatIntMap() {
        return f1663a;
    }

    @NotNull
    public static final FloatIntMap floatIntMapOf() {
        return f1663a;
    }

    @NotNull
    public static final MutableFloatIntMap mutableFloatIntMapOf() {
        return new MutableFloatIntMap(0, 1, null);
    }

    @NotNull
    public static final FloatIntMap floatIntMapOf(float f, int i) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, null);
        mutableFloatIntMap.set(f, i);
        return mutableFloatIntMap;
    }

    @NotNull
    public static final MutableFloatIntMap mutableFloatIntMapOf(float f, int i) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, null);
        mutableFloatIntMap.set(f, i);
        return mutableFloatIntMap;
    }

    @NotNull
    public static final FloatIntMap floatIntMapOf(float f, int i, float f2, int i2) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, null);
        mutableFloatIntMap.set(f, i);
        mutableFloatIntMap.set(f2, i2);
        return mutableFloatIntMap;
    }

    @NotNull
    public static final MutableFloatIntMap mutableFloatIntMapOf(float f, int i, float f2, int i2) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, null);
        mutableFloatIntMap.set(f, i);
        mutableFloatIntMap.set(f2, i2);
        return mutableFloatIntMap;
    }

    @NotNull
    public static final FloatIntMap floatIntMapOf(float f, int i, float f2, int i2, float f3, int i3) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, null);
        mutableFloatIntMap.set(f, i);
        mutableFloatIntMap.set(f2, i2);
        mutableFloatIntMap.set(f3, i3);
        return mutableFloatIntMap;
    }

    @NotNull
    public static final MutableFloatIntMap mutableFloatIntMapOf(float f, int i, float f2, int i2, float f3, int i3) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, null);
        mutableFloatIntMap.set(f, i);
        mutableFloatIntMap.set(f2, i2);
        mutableFloatIntMap.set(f3, i3);
        return mutableFloatIntMap;
    }

    @NotNull
    public static final FloatIntMap floatIntMapOf(float f, int i, float f2, int i2, float f3, int i3, float f4, int i4) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, null);
        mutableFloatIntMap.set(f, i);
        mutableFloatIntMap.set(f2, i2);
        mutableFloatIntMap.set(f3, i3);
        mutableFloatIntMap.set(f4, i4);
        return mutableFloatIntMap;
    }

    @NotNull
    public static final MutableFloatIntMap mutableFloatIntMapOf(float f, int i, float f2, int i2, float f3, int i3, float f4, int i4) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, null);
        mutableFloatIntMap.set(f, i);
        mutableFloatIntMap.set(f2, i2);
        mutableFloatIntMap.set(f3, i3);
        mutableFloatIntMap.set(f4, i4);
        return mutableFloatIntMap;
    }

    @NotNull
    public static final FloatIntMap floatIntMapOf(float f, int i, float f2, int i2, float f3, int i3, float f4, int i4, float f5, int i5) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, null);
        mutableFloatIntMap.set(f, i);
        mutableFloatIntMap.set(f2, i2);
        mutableFloatIntMap.set(f3, i3);
        mutableFloatIntMap.set(f4, i4);
        mutableFloatIntMap.set(f5, i5);
        return mutableFloatIntMap;
    }

    @NotNull
    public static final MutableFloatIntMap mutableFloatIntMapOf(float f, int i, float f2, int i2, float f3, int i3, float f4, int i4, float f5, int i5) {
        MutableFloatIntMap mutableFloatIntMap = new MutableFloatIntMap(0, 1, null);
        mutableFloatIntMap.set(f, i);
        mutableFloatIntMap.set(f2, i2);
        mutableFloatIntMap.set(f3, i3);
        mutableFloatIntMap.set(f4, i4);
        mutableFloatIntMap.set(f5, i5);
        return mutableFloatIntMap;
    }
}
