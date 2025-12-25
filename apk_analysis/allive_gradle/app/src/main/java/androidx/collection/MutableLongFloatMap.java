package androidx.collection;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0010J%\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u0017\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0018\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u001bJ-\u0010\u001e\u001a\u00020\u000e2\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001a0\u001cH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b \u0010\u0019J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020!H\u0086\n¢\u0006\u0004\b \u0010#J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020$H\u0086\n¢\u0006\u0004\b \u0010%J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020&H\u0086\n¢\u0006\u0004\b \u0010'J\u0017\u0010)\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u0002H\u0001¢\u0006\u0004\b)\u0010\u0005J\r\u0010*\u001a\u00020\u000e¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\u0002¢\u0006\u0004\b,\u0010-\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006."}, m5569d2 = {"Landroidx/collection/MutableLongFloatMap;", "Landroidx/collection/LongFloatMap;", "", "initialCapacity", "<init>", "(I)V", "", "key", "Lkotlin/Function0;", "", "defaultValue", "getOrPut", "(JLkotlin/jvm/functions/Function0;)F", "value", "", "set", "(JF)V", "put", "default", "(JFF)F", TypedValues.TransitionType.S_FROM, "putAll", "(Landroidx/collection/LongFloatMap;)V", "plusAssign", "remove", "(J)V", "", "(JF)Z", "Lkotlin/Function2;", "predicate", "removeIf", "(Lkotlin/jvm/functions/Function2;)V", "minusAssign", "", "keys", "([J)V", "Landroidx/collection/LongSet;", "(Landroidx/collection/LongSet;)V", "Landroidx/collection/LongList;", "(Landroidx/collection/LongList;)V", FirebaseAnalytics.Param.INDEX, "removeValueAt", "clear", "()V", "trim", "()I", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nLongFloatMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LongFloatMap.kt\nandroidx/collection/MutableLongFloatMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 4 LongFloatMap.kt\nandroidx/collection/LongFloatMap\n+ 5 LongSet.kt\nandroidx/collection/LongSet\n+ 6 LongList.kt\nandroidx/collection/LongList\n+ 7 LongSet.kt\nandroidx/collection/LongSetKt\n*L\n1#1,1047:1\n1037#1,2:1134\n1041#1,5:1142\n1037#1,2:1173\n1041#1,5:1181\n1037#1,2:1198\n1041#1,5:1206\n1037#1,2:1212\n1041#1,5:1220\n1#2:1048\n1672#3,6:1049\n1826#3:1065\n1688#3:1069\n1826#3:1087\n1688#3:1091\n1826#3:1112\n1688#3:1116\n1672#3,6:1136\n1672#3,6:1147\n1615#3:1156\n1619#3:1157\n1795#3,3:1158\n1809#3,3:1161\n1733#3:1164\n1721#3:1165\n1715#3:1166\n1728#3:1167\n1818#3:1168\n1682#3:1169\n1661#3:1170\n1680#3:1171\n1661#3:1172\n1672#3,6:1175\n1795#3,3:1186\n1826#3:1189\n1715#3:1190\n1685#3:1191\n1661#3:1192\n1615#3:1196\n1619#3:1197\n1672#3,6:1200\n1661#3:1211\n1672#3,6:1214\n1672#3,6:1225\n1672#3,6:1231\n385#4,4:1055\n357#4,6:1059\n367#4,3:1066\n370#4,2:1070\n389#4,2:1072\n373#4,6:1074\n391#4:1080\n357#4,6:1081\n367#4,3:1088\n370#4,9:1092\n262#5,4:1101\n232#5,7:1105\n243#5,3:1113\n246#5,2:1117\n266#5,2:1119\n249#5,6:1121\n268#5:1127\n253#6,6:1128\n849#7,3:1153\n849#7,3:1193\n*S KotlinDebug\n*F\n+ 1 LongFloatMap.kt\nandroidx/collection/MutableLongFloatMap\n*L\n875#1:1134,2\n875#1:1142,5\n933#1:1173,2\n933#1:1181,5\n1007#1:1198,2\n1007#1:1206,5\n1023#1:1212,2\n1023#1:1220,5\n711#1:1049,6\n789#1:1065\n789#1:1069\n828#1:1087\n828#1:1091\n855#1:1112\n855#1:1116\n875#1:1136,6\n885#1:1147,6\n899#1:1156\n900#1:1157\n907#1:1158,3\n908#1:1161,3\n909#1:1164\n910#1:1165\n910#1:1166\n914#1:1167\n917#1:1168\n926#1:1169\n926#1:1170\n932#1:1171\n932#1:1172\n933#1:1175,6\n948#1:1186,3\n949#1:1189\n951#1:1190\n1002#1:1191\n1002#1:1192\n1005#1:1196\n1007#1:1197\n1007#1:1200,6\n1021#1:1211\n1023#1:1214,6\n1038#1:1225,6\n1044#1:1231,6\n789#1:1055,4\n789#1:1059,6\n789#1:1066,3\n789#1:1070,2\n789#1:1072,2\n789#1:1074,6\n789#1:1080\n828#1:1081,6\n828#1:1088,3\n828#1:1092,9\n855#1:1101,4\n855#1:1105,7\n855#1:1113,3\n855#1:1117,2\n855#1:1119,2\n855#1:1121,6\n855#1:1127\n864#1:1128,6\n898#1:1153,3\n1004#1:1193,3\n*E\n"})
/* loaded from: classes.dex */
public final class MutableLongFloatMap extends LongFloatMap {

    /* renamed from: a */
    public int f1715a;

    public MutableLongFloatMap() {
        this(0, 1, null);
    }

    /* renamed from: a */
    public final int m372a(int i) {
        int i2 = this._capacity;
        int i3 = i & i2;
        int i4 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i5 = i3 >> 3;
            int i6 = (i3 & 7) << 3;
            long j = ((jArr[i5 + 1] << (64 - i6)) & ((-i6) >> 63)) | (jArr[i5] >>> i6);
            long j2 = j & ((~j) << 7) & (-9187201950435737472L);
            if (j2 != 0) {
                return (i3 + (Long.numberOfTrailingZeros(j2) >> 3)) & i2;
            }
            i4 += 8;
            i3 = (i3 + i4) & i2;
        }
    }

    /* renamed from: b */
    public final int m373b(long j) {
        int i;
        int i2 = ((int) (j ^ (j >>> 32))) * ScatterMapKt.MurmurHashC1;
        int i3 = i2 ^ (i2 << 16);
        int i4 = i3 >>> 7;
        int i5 = i3 & 127;
        int i6 = this._capacity;
        int i7 = i4 & i6;
        int i8 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i9 = i7 >> 3;
            int i10 = (i7 & 7) << 3;
            long j2 = ((jArr[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr[i9] >>> i10);
            long j3 = i5;
            int i11 = i8;
            long j4 = j2 ^ (j3 * ScatterMapKt.BitmaskLsb);
            for (long j5 = (~j4) & (j4 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j5 != 0; j5 &= j5 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j5) >> 3) + i7) & i6;
                if (this.keys[numberOfTrailingZeros] == j) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j2) << 6) & j2 & (-9187201950435737472L)) != 0) {
                int m372a = m372a(i4);
                if (this.f1715a == 0) {
                    long j6 = 254;
                    if (((this.metadata[m372a >> 3] >> ((m372a & 7) << 3)) & 255) != 254) {
                        if (this._capacity > 8) {
                            if (Long.compare(ye0.m8287g(this._size, 32L) ^ Long.MIN_VALUE, ye0.m8287g(this._capacity, 25L) ^ Long.MIN_VALUE) <= 0) {
                                long[] jArr2 = this.metadata;
                                int i12 = this._capacity;
                                int i13 = 0;
                                int i14 = 0;
                                while (i13 < i12) {
                                    int i15 = i13 >> 3;
                                    int i16 = (i13 & 7) << 3;
                                    if (((jArr2[i15] >> i16) & 255) == j6) {
                                        long[] jArr3 = this.metadata;
                                        jArr3[i15] = (jArr3[i15] & (~(255 << i16))) | (128 << i16);
                                        int i17 = this._capacity;
                                        int i18 = ((i13 - 7) & i17) + (i17 & 7);
                                        int i19 = i18 >> 3;
                                        int i20 = (i18 & 7) << 3;
                                        jArr3[i19] = (jArr3[i19] & (~(255 << i20))) | (128 << i20);
                                        i14++;
                                    }
                                    i13++;
                                    j6 = 254;
                                }
                                this.f1715a += i14;
                                m372a = m372a(i4);
                            }
                        }
                        m375d(ScatterMapKt.nextCapacity(this._capacity));
                        m372a = m372a(i4);
                    }
                }
                this._size++;
                int i21 = this.f1715a;
                long[] jArr4 = this.metadata;
                int i22 = m372a >> 3;
                long j7 = jArr4[i22];
                int i23 = (m372a & 7) << 3;
                if (((j7 >> i23) & 255) == 128) {
                    i = 1;
                } else {
                    i = 0;
                }
                this.f1715a = i21 - i;
                jArr4[i22] = ((~(255 << i23)) & j7) | (j3 << i23);
                int i24 = this._capacity;
                int i25 = ((m372a - 7) & i24) + (i24 & 7);
                int i26 = i25 >> 3;
                int i27 = (i25 & 7) << 3;
                jArr4[i26] = (jArr4[i26] & (~(255 << i27))) | (j3 << i27);
                return ~m372a;
            }
            i8 = i11 + 8;
            i7 = (i7 + i8) & i6;
        }
    }

    /* renamed from: c */
    public final void m374c(int i) {
        int i2;
        long[] jArr;
        if (i > 0) {
            i2 = Math.max(7, ScatterMapKt.normalizeCapacity(i));
        } else {
            i2 = 0;
        }
        this._capacity = i2;
        if (i2 == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            jArr = new long[((i2 + 15) & (-8)) >> 3];
            ArraysKt___ArraysJvmKt.fill$default(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
        }
        this.metadata = jArr;
        int i3 = i2 >> 3;
        long j = 255 << ((i2 & 7) << 3);
        jArr[i3] = (jArr[i3] & (~j)) | j;
        this.f1715a = ScatterMapKt.loadedCapacity(get_capacity()) - this._size;
        this.keys = new long[i2];
        this.values = new float[i2];
    }

    public final void clear() {
        this._size = 0;
        long[] jArr = this.metadata;
        if (jArr != ScatterMapKt.EmptyGroup) {
            ArraysKt___ArraysJvmKt.fill$default(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
            long[] jArr2 = this.metadata;
            int i = this._capacity;
            int i2 = i >> 3;
            long j = 255 << ((i & 7) << 3);
            jArr2[i2] = (jArr2[i2] & (~j)) | j;
        }
        this.f1715a = ScatterMapKt.loadedCapacity(get_capacity()) - this._size;
    }

    /* renamed from: d */
    public final void m375d(int i) {
        long[] jArr;
        long[] jArr2;
        long[] jArr3 = this.metadata;
        long[] jArr4 = this.keys;
        float[] fArr = this.values;
        int i2 = this._capacity;
        m374c(i);
        long[] jArr5 = this.keys;
        float[] fArr2 = this.values;
        int i3 = 0;
        while (i3 < i2) {
            if (((jArr3[i3 >> 3] >> ((i3 & 7) << 3)) & 255) < 128) {
                long j = jArr4[i3];
                int i4 = ((int) ((j >>> 32) ^ j)) * ScatterMapKt.MurmurHashC1;
                int i5 = i4 ^ (i4 << 16);
                int m372a = m372a(i5 >>> 7);
                long j2 = i5 & 127;
                long[] jArr6 = this.metadata;
                int i6 = m372a >> 3;
                int i7 = (m372a & 7) << 3;
                jArr = jArr3;
                jArr2 = jArr4;
                jArr6[i6] = (jArr6[i6] & (~(255 << i7))) | (j2 << i7);
                int i8 = this._capacity;
                int i9 = ((m372a - 7) & i8) + (i8 & 7);
                int i10 = i9 >> 3;
                int i11 = (i9 & 7) << 3;
                jArr6[i10] = (jArr6[i10] & (~(255 << i11))) | (j2 << i11);
                jArr5[m372a] = j;
                fArr2[m372a] = fArr[i3];
            } else {
                jArr = jArr3;
                jArr2 = jArr4;
            }
            i3++;
            jArr3 = jArr;
            jArr4 = jArr2;
        }
    }

    public final float getOrPut(long key, @NotNull Function0<Float> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int findKeyIndex = findKeyIndex(key);
        if (findKeyIndex < 0) {
            float floatValue = defaultValue.invoke().floatValue();
            put(key, floatValue);
            return floatValue;
        }
        return this.values[findKeyIndex];
    }

    public final void minusAssign(long key) {
        remove(key);
    }

    public final void plusAssign(@NotNull LongFloatMap from) {
        Intrinsics.checkNotNullParameter(from, "from");
        putAll(from);
    }

    public final void put(long key, float value) {
        set(key, value);
    }

    public final void putAll(@NotNull LongFloatMap from) {
        Intrinsics.checkNotNullParameter(from, "from");
        long[] jArr = from.keys;
        float[] fArr = from.values;
        long[] jArr2 = from.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr2[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            set(jArr[i4], fArr[i4]);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void remove(long key) {
        int findKeyIndex = findKeyIndex(key);
        if (findKeyIndex >= 0) {
            removeValueAt(findKeyIndex);
        }
    }

    public final void removeIf(@NotNull Function2<? super Long, ? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            if (predicate.invoke(Long.valueOf(this.keys[i4]), Float.valueOf(this.values[i4])).booleanValue()) {
                                removeValueAt(i4);
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @PublishedApi
    public final void removeValueAt(int index) {
        this._size--;
        long[] jArr = this.metadata;
        int i = index >> 3;
        int i2 = (index & 7) << 3;
        jArr[i] = (jArr[i] & (~(255 << i2))) | (254 << i2);
        int i3 = this._capacity;
        int i4 = ((index - 7) & i3) + (i3 & 7);
        int i5 = i4 >> 3;
        int i6 = (i4 & 7) << 3;
        jArr[i5] = (jArr[i5] & (~(255 << i6))) | (254 << i6);
    }

    public final void set(long key, float value) {
        int m373b = m373b(key);
        if (m373b < 0) {
            m373b = ~m373b;
        }
        this.keys[m373b] = key;
        this.values[m373b] = value;
    }

    public final int trim() {
        int i = this._capacity;
        int normalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (normalizeCapacity < i) {
            m375d(normalizeCapacity);
            return i - this._capacity;
        }
        return 0;
    }

    public /* synthetic */ MutableLongFloatMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    public final void minusAssign(@NotNull long[] keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        for (long j : keys) {
            remove(j);
        }
    }

    public final float put(long key, float value, float r6) {
        int m373b = m373b(key);
        if (m373b < 0) {
            m373b = ~m373b;
        } else {
            r6 = this.values[m373b];
        }
        this.keys[m373b] = key;
        this.values[m373b] = value;
        return r6;
    }

    public MutableLongFloatMap(int i) {
        super(null);
        if (i >= 0) {
            m374c(ScatterMapKt.unloadedCapacity(i));
            return;
        }
        throw new IllegalArgumentException("Capacity must be a positive value.");
    }

    public final boolean remove(long key, float value) {
        int findKeyIndex = findKeyIndex(key);
        if (findKeyIndex < 0 || this.values[findKeyIndex] != value) {
            return false;
        }
        removeValueAt(findKeyIndex);
        return true;
    }

    public final void minusAssign(@NotNull LongSet keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        long[] jArr = keys.elements;
        long[] jArr2 = keys.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr2[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        remove(jArr[(i << 3) + i3]);
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void minusAssign(@NotNull LongList keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        long[] jArr = keys.content;
        int i = keys._size;
        for (int i2 = 0; i2 < i; i2++) {
            remove(jArr[i2]);
        }
    }
}
