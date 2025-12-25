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

@Metadata(m5568d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ \u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ%\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u0015\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0005J\u001d\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0018J-\u0010\u001b\u001a\u00020\f2\u0018\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00170\u0019H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0002H\u0086\n¢\u0006\u0004\b\u001d\u0010\u0005J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0086\n¢\u0006\u0004\b\u001d\u0010 J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020!H\u0086\n¢\u0006\u0004\b\u001d\u0010\"J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020#H\u0086\n¢\u0006\u0004\b\u001d\u0010$J\u0017\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u0002H\u0001¢\u0006\u0004\b&\u0010\u0005J\r\u0010'\u001a\u00020\f¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0002¢\u0006\u0004\b)\u0010*\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006+"}, m5569d2 = {"Landroidx/collection/MutableIntIntMap;", "Landroidx/collection/IntIntMap;", "", "initialCapacity", "<init>", "(I)V", "key", "Lkotlin/Function0;", "defaultValue", "getOrPut", "(ILkotlin/jvm/functions/Function0;)I", "value", "", "set", "(II)V", "put", "default", "(III)I", TypedValues.TransitionType.S_FROM, "putAll", "(Landroidx/collection/IntIntMap;)V", "plusAssign", "remove", "", "(II)Z", "Lkotlin/Function2;", "predicate", "removeIf", "(Lkotlin/jvm/functions/Function2;)V", "minusAssign", "", "keys", "([I)V", "Landroidx/collection/IntSet;", "(Landroidx/collection/IntSet;)V", "Landroidx/collection/IntList;", "(Landroidx/collection/IntList;)V", FirebaseAnalytics.Param.INDEX, "removeValueAt", "clear", "()V", "trim", "()I", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nIntIntMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntIntMap.kt\nandroidx/collection/MutableIntIntMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 4 IntIntMap.kt\nandroidx/collection/IntIntMap\n+ 5 IntSet.kt\nandroidx/collection/IntSet\n+ 6 IntList.kt\nandroidx/collection/IntList\n+ 7 IntSet.kt\nandroidx/collection/IntSetKt\n*L\n1#1,1047:1\n1037#1,2:1134\n1041#1,5:1142\n1037#1,2:1173\n1041#1,5:1181\n1037#1,2:1198\n1041#1,5:1206\n1037#1,2:1212\n1041#1,5:1220\n1#2:1048\n1672#3,6:1049\n1826#3:1065\n1688#3:1069\n1826#3:1087\n1688#3:1091\n1826#3:1112\n1688#3:1116\n1672#3,6:1136\n1672#3,6:1147\n1615#3:1156\n1619#3:1157\n1795#3,3:1158\n1809#3,3:1161\n1733#3:1164\n1721#3:1165\n1715#3:1166\n1728#3:1167\n1818#3:1168\n1682#3:1169\n1661#3:1170\n1680#3:1171\n1661#3:1172\n1672#3,6:1175\n1795#3,3:1186\n1826#3:1189\n1715#3:1190\n1685#3:1191\n1661#3:1192\n1615#3:1196\n1619#3:1197\n1672#3,6:1200\n1661#3:1211\n1672#3,6:1214\n1672#3,6:1225\n1672#3,6:1231\n385#4,4:1055\n357#4,6:1059\n367#4,3:1066\n370#4,2:1070\n389#4,2:1072\n373#4,6:1074\n391#4:1080\n357#4,6:1081\n367#4,3:1088\n370#4,9:1092\n262#5,4:1101\n232#5,7:1105\n243#5,3:1113\n246#5,2:1117\n266#5,2:1119\n249#5,6:1121\n268#5:1127\n253#6,6:1128\n849#7,3:1153\n849#7,3:1193\n*S KotlinDebug\n*F\n+ 1 IntIntMap.kt\nandroidx/collection/MutableIntIntMap\n*L\n875#1:1134,2\n875#1:1142,5\n933#1:1173,2\n933#1:1181,5\n1007#1:1198,2\n1007#1:1206,5\n1023#1:1212,2\n1023#1:1220,5\n711#1:1049,6\n789#1:1065\n789#1:1069\n828#1:1087\n828#1:1091\n855#1:1112\n855#1:1116\n875#1:1136,6\n885#1:1147,6\n899#1:1156\n900#1:1157\n907#1:1158,3\n908#1:1161,3\n909#1:1164\n910#1:1165\n910#1:1166\n914#1:1167\n917#1:1168\n926#1:1169\n926#1:1170\n932#1:1171\n932#1:1172\n933#1:1175,6\n948#1:1186,3\n949#1:1189\n951#1:1190\n1002#1:1191\n1002#1:1192\n1005#1:1196\n1007#1:1197\n1007#1:1200,6\n1021#1:1211\n1023#1:1214,6\n1038#1:1225,6\n1044#1:1231,6\n789#1:1055,4\n789#1:1059,6\n789#1:1066,3\n789#1:1070,2\n789#1:1072,2\n789#1:1074,6\n789#1:1080\n828#1:1081,6\n828#1:1088,3\n828#1:1092,9\n855#1:1101,4\n855#1:1105,7\n855#1:1113,3\n855#1:1117,2\n855#1:1119,2\n855#1:1121,6\n855#1:1127\n864#1:1128,6\n898#1:1153,3\n1004#1:1193,3\n*E\n"})
/* loaded from: classes.dex */
public final class MutableIntIntMap extends IntIntMap {

    /* renamed from: a */
    public int f1711a;

    public MutableIntIntMap() {
        this(0, 1, null);
    }

    /* renamed from: a */
    public final int m355a(int i) {
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
    public final int m356b(int i) {
        int i2 = ScatterMapKt.MurmurHashC1 * i;
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
            long j = ((jArr[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr[i9] >>> i10);
            long j2 = i5;
            int i11 = i8;
            long j3 = j ^ (j2 * ScatterMapKt.BitmaskLsb);
            for (long j4 = (~j3) & (j3 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j4 != 0; j4 &= j4 - 1) {
                int numberOfTrailingZeros = (i7 + (Long.numberOfTrailingZeros(j4) >> 3)) & i6;
                if (this.keys[numberOfTrailingZeros] == i) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j) << 6) & j & (-9187201950435737472L)) != 0) {
                int m355a = m355a(i4);
                long j5 = 128;
                if (this.f1711a == 0 && ((this.metadata[m355a >> 3] >> ((m355a & 7) << 3)) & 255) != 254) {
                    if (this._capacity > 8) {
                        if (Long.compare(ye0.m8287g(this._size, 32L) ^ Long.MIN_VALUE, ye0.m8287g(this._capacity, 25L) ^ Long.MIN_VALUE) <= 0) {
                            long[] jArr2 = this.metadata;
                            int i12 = this._capacity;
                            int i13 = 0;
                            int i14 = 0;
                            while (i13 < i12) {
                                int i15 = i13 >> 3;
                                int i16 = (i13 & 7) << 3;
                                if (((jArr2[i15] >> i16) & 255) == 254) {
                                    long[] jArr3 = this.metadata;
                                    jArr3[i15] = (jArr3[i15] & (~(255 << i16))) | (j5 << i16);
                                    int i17 = this._capacity;
                                    int i18 = ((i13 - 7) & i17) + (i17 & 7);
                                    int i19 = i18 >> 3;
                                    int i20 = (i18 & 7) << 3;
                                    jArr3[i19] = (jArr3[i19] & (~(255 << i20))) | (128 << i20);
                                    i14++;
                                }
                                i13++;
                                j5 = 128;
                            }
                            this.f1711a += i14;
                            m355a = m355a(i4);
                        }
                    }
                    m358d(ScatterMapKt.nextCapacity(this._capacity));
                    m355a = m355a(i4);
                }
                int i21 = 1;
                this._size++;
                int i22 = this.f1711a;
                long[] jArr4 = this.metadata;
                int i23 = m355a >> 3;
                long j6 = jArr4[i23];
                int i24 = (m355a & 7) << 3;
                if (((j6 >> i24) & 255) != 128) {
                    i21 = 0;
                }
                this.f1711a = i22 - i21;
                jArr4[i23] = ((~(255 << i24)) & j6) | (j2 << i24);
                int i25 = this._capacity;
                int i26 = ((m355a - 7) & i25) + (i25 & 7);
                int i27 = i26 >> 3;
                int i28 = (i26 & 7) << 3;
                jArr4[i27] = (jArr4[i27] & (~(255 << i28))) | (j2 << i28);
                return ~m355a;
            }
            i8 = i11 + 8;
            i7 = (i7 + i8) & i6;
        }
    }

    /* renamed from: c */
    public final void m357c(int i) {
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
        this.f1711a = ScatterMapKt.loadedCapacity(get_capacity()) - this._size;
        this.keys = new int[i2];
        this.values = new int[i2];
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
        this.f1711a = ScatterMapKt.loadedCapacity(get_capacity()) - this._size;
    }

    /* renamed from: d */
    public final void m358d(int i) {
        long[] jArr;
        int[] iArr;
        long[] jArr2 = this.metadata;
        int[] iArr2 = this.keys;
        int[] iArr3 = this.values;
        int i2 = this._capacity;
        m357c(i);
        int[] iArr4 = this.keys;
        int[] iArr5 = this.values;
        int i3 = 0;
        while (i3 < i2) {
            if (((jArr2[i3 >> 3] >> ((i3 & 7) << 3)) & 255) < 128) {
                int i4 = iArr2[i3];
                int i5 = ScatterMapKt.MurmurHashC1 * i4;
                int i6 = i5 ^ (i5 << 16);
                int m355a = m355a(i6 >>> 7);
                long j = i6 & 127;
                long[] jArr3 = this.metadata;
                int i7 = m355a >> 3;
                int i8 = (m355a & 7) << 3;
                jArr = jArr2;
                iArr = iArr2;
                jArr3[i7] = (jArr3[i7] & (~(255 << i8))) | (j << i8);
                int i9 = this._capacity;
                int i10 = ((m355a - 7) & i9) + (i9 & 7);
                int i11 = i10 >> 3;
                int i12 = (i10 & 7) << 3;
                jArr3[i11] = ((~(255 << i12)) & jArr3[i11]) | (j << i12);
                iArr4[m355a] = i4;
                iArr5[m355a] = iArr3[i3];
            } else {
                jArr = jArr2;
                iArr = iArr2;
            }
            i3++;
            jArr2 = jArr;
            iArr2 = iArr;
        }
    }

    public final int getOrPut(int key, @NotNull Function0<Integer> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int findKeyIndex = findKeyIndex(key);
        if (findKeyIndex < 0) {
            int intValue = defaultValue.invoke().intValue();
            put(key, intValue);
            return intValue;
        }
        return this.values[findKeyIndex];
    }

    public final void minusAssign(int key) {
        remove(key);
    }

    public final void plusAssign(@NotNull IntIntMap from) {
        Intrinsics.checkNotNullParameter(from, "from");
        putAll(from);
    }

    public final void put(int key, int value) {
        set(key, value);
    }

    public final void putAll(@NotNull IntIntMap from) {
        Intrinsics.checkNotNullParameter(from, "from");
        int[] iArr = from.keys;
        int[] iArr2 = from.values;
        long[] jArr = from.metadata;
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
                            set(iArr[i4], iArr2[i4]);
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

    public final void remove(int key) {
        int findKeyIndex = findKeyIndex(key);
        if (findKeyIndex >= 0) {
            removeValueAt(findKeyIndex);
        }
    }

    public final void removeIf(@NotNull Function2<? super Integer, ? super Integer, Boolean> predicate) {
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
                            if (predicate.invoke(Integer.valueOf(this.keys[i4]), Integer.valueOf(this.values[i4])).booleanValue()) {
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

    public final void set(int key, int value) {
        int m356b = m356b(key);
        if (m356b < 0) {
            m356b = ~m356b;
        }
        this.keys[m356b] = key;
        this.values[m356b] = value;
    }

    public final int trim() {
        int i = this._capacity;
        int normalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (normalizeCapacity < i) {
            m358d(normalizeCapacity);
            return i - this._capacity;
        }
        return 0;
    }

    public /* synthetic */ MutableIntIntMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    public final void minusAssign(@NotNull int[] keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        for (int i : keys) {
            remove(i);
        }
    }

    public final int put(int key, int value, int r5) {
        int m356b = m356b(key);
        if (m356b < 0) {
            m356b = ~m356b;
        } else {
            r5 = this.values[m356b];
        }
        this.keys[m356b] = key;
        this.values[m356b] = value;
        return r5;
    }

    public MutableIntIntMap(int i) {
        super(null);
        if (i >= 0) {
            m357c(ScatterMapKt.unloadedCapacity(i));
            return;
        }
        throw new IllegalArgumentException("Capacity must be a positive value.");
    }

    public final boolean remove(int key, int value) {
        int findKeyIndex = findKeyIndex(key);
        if (findKeyIndex < 0 || this.values[findKeyIndex] != value) {
            return false;
        }
        removeValueAt(findKeyIndex);
        return true;
    }

    public final void minusAssign(@NotNull IntSet keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        int[] iArr = keys.elements;
        long[] jArr = keys.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        remove(iArr[(i << 3) + i3]);
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

    public final void minusAssign(@NotNull IntList keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        int[] iArr = keys.content;
        int i = keys._size;
        for (int i2 = 0; i2 < i; i2++) {
            remove(iArr[i2]);
        }
    }
}
