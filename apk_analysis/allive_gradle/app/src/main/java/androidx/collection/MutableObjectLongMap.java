package androidx.collection;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00028\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0010J%\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0013J\u001b\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\n¢\u0006\u0004\b\u0017\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0018\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u001bJ-\u0010\u001e\u001a\u00020\u000e2\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001a0\u001cH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\n¢\u0006\u0004\b \u0010\u0019J \u0010 \u001a\u00020\u000e2\u000e\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000!H\u0086\n¢\u0006\u0004\b \u0010#J\u001e\u0010 \u001a\u00020\u000e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000$H\u0086\n¢\u0006\u0004\b \u0010%J\u001e\u0010 \u001a\u00020\u000e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0086\n¢\u0006\u0004\b \u0010'J\u001e\u0010 \u001a\u00020\u000e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0086\n¢\u0006\u0004\b \u0010)J\u0017\u0010+\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u0003H\u0001¢\u0006\u0004\b+\u0010\u0006J\r\u0010,\u001a\u00020\u000e¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u0003¢\u0006\u0004\b.\u0010/\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00060"}, m5569d2 = {"Landroidx/collection/MutableObjectLongMap;", "K", "Landroidx/collection/ObjectLongMap;", "", "initialCapacity", "<init>", "(I)V", "key", "Lkotlin/Function0;", "", "defaultValue", "getOrPut", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)J", "value", "", "set", "(Ljava/lang/Object;J)V", "put", "default", "(Ljava/lang/Object;JJ)J", TypedValues.TransitionType.S_FROM, "putAll", "(Landroidx/collection/ObjectLongMap;)V", "plusAssign", "remove", "(Ljava/lang/Object;)V", "", "(Ljava/lang/Object;J)Z", "Lkotlin/Function2;", "predicate", "removeIf", "(Lkotlin/jvm/functions/Function2;)V", "minusAssign", "", "keys", "([Ljava/lang/Object;)V", "", "(Ljava/lang/Iterable;)V", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;)V", "Landroidx/collection/ScatterSet;", "(Landroidx/collection/ScatterSet;)V", FirebaseAnalytics.Param.INDEX, "removeValueAt", "clear", "()V", "trim", "()I", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nObjectLongMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObjectLongMap.kt\nandroidx/collection/MutableObjectLongMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 4 ObjectLongMap.kt\nandroidx/collection/ObjectLongMap\n+ 5 ScatterSet.kt\nandroidx/collection/ScatterSet\n*L\n1#1,1074:1\n1064#1,2:1155\n1068#1,5:1163\n1064#1,2:1194\n1068#1,5:1202\n1064#1,2:1219\n1068#1,5:1227\n1064#1,2:1233\n1068#1,5:1241\n1#2:1075\n1672#3,6:1076\n1826#3:1092\n1688#3:1096\n1826#3:1114\n1688#3:1118\n1826#3:1139\n1688#3:1143\n1672#3,6:1157\n1672#3,6:1168\n1605#3,3:1174\n1615#3:1177\n1619#3:1178\n1795#3,3:1179\n1809#3,3:1182\n1733#3:1185\n1721#3:1186\n1715#3:1187\n1728#3:1188\n1818#3:1189\n1682#3:1190\n1661#3:1191\n1680#3:1192\n1661#3:1193\n1672#3,6:1196\n1795#3,3:1207\n1826#3:1210\n1715#3:1211\n1685#3:1212\n1661#3:1213\n1605#3,3:1214\n1615#3:1217\n1619#3:1218\n1672#3,6:1221\n1661#3:1232\n1672#3,6:1235\n1672#3,6:1246\n1672#3,6:1252\n401#4,4:1082\n373#4,6:1086\n383#4,3:1093\n386#4,2:1097\n406#4,2:1099\n389#4,6:1101\n408#4:1107\n373#4,6:1108\n383#4,3:1115\n386#4,9:1119\n267#5,4:1128\n237#5,7:1132\n248#5,3:1140\n251#5,2:1144\n272#5,2:1146\n254#5,6:1148\n274#5:1154\n*S KotlinDebug\n*F\n+ 1 ObjectLongMap.kt\nandroidx/collection/MutableObjectLongMap\n*L\n900#1:1155,2\n900#1:1163,5\n960#1:1194,2\n960#1:1202,5\n1034#1:1219,2\n1034#1:1227,5\n1050#1:1233,2\n1050#1:1241,5\n728#1:1076,6\n804#1:1092\n804#1:1096\n843#1:1114\n843#1:1118\n889#1:1139\n889#1:1143\n900#1:1157,6\n911#1:1168,6\n925#1:1174,3\n926#1:1177\n927#1:1178\n934#1:1179,3\n935#1:1182,3\n936#1:1185\n937#1:1186\n937#1:1187\n941#1:1188\n944#1:1189\n953#1:1190\n953#1:1191\n959#1:1192\n959#1:1193\n960#1:1196,6\n975#1:1207,3\n976#1:1210\n978#1:1211\n1029#1:1212\n1029#1:1213\n1031#1:1214,3\n1032#1:1217\n1034#1:1218\n1034#1:1221,6\n1048#1:1232\n1050#1:1235,6\n1065#1:1246,6\n1071#1:1252,6\n804#1:1082,4\n804#1:1086,6\n804#1:1093,3\n804#1:1097,2\n804#1:1099,2\n804#1:1101,6\n804#1:1107\n843#1:1108,6\n843#1:1115,3\n843#1:1119,9\n889#1:1128,4\n889#1:1132,7\n889#1:1140,3\n889#1:1144,2\n889#1:1146,2\n889#1:1148,6\n889#1:1154\n*E\n"})
/* loaded from: classes.dex */
public final class MutableObjectLongMap<K> extends ObjectLongMap<K> {

    /* renamed from: a */
    public int f1723a;

    public MutableObjectLongMap() {
        this(0, 1, null);
    }

    /* renamed from: a */
    public final int m401a(int i) {
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
    public final int m402b(Object obj) {
        int i;
        long j;
        int i2;
        long[] jArr;
        int i3;
        long j2;
        if (obj != null) {
            i = obj.hashCode();
        } else {
            i = 0;
        }
        int i4 = i * ScatterMapKt.MurmurHashC1;
        int i5 = i4 ^ (i4 << 16);
        int i6 = i5 >>> 7;
        int i7 = i5 & 127;
        int i8 = this._capacity;
        int i9 = i6 & i8;
        int i10 = 0;
        while (true) {
            long[] jArr2 = this.metadata;
            int i11 = i9 >> 3;
            int i12 = (i9 & 7) << 3;
            long j3 = ((jArr2[i11 + 1] << (64 - i12)) & ((-i12) >> 63)) | (jArr2[i11] >>> i12);
            long j4 = i7;
            int i13 = i7;
            long j5 = j3 ^ (j4 * ScatterMapKt.BitmaskLsb);
            for (long j6 = (~j5) & (j5 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j6 != 0; j6 &= j6 - 1) {
                int numberOfTrailingZeros = (i9 + (Long.numberOfTrailingZeros(j6) >> 3)) & i8;
                if (Intrinsics.areEqual(this.keys[numberOfTrailingZeros], obj)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j3) << 6) & j3 & (-9187201950435737472L)) != 0) {
                int m401a = m401a(i6);
                if (this.f1723a != 0 || ((this.metadata[m401a >> 3] >> ((m401a & 7) << 3)) & 255) == 254) {
                    j = j4;
                } else {
                    if (this._capacity > 8) {
                        if (Long.compare(ye0.m8287g(this._size, 32L) ^ Long.MIN_VALUE, ye0.m8287g(this._capacity, 25L) ^ Long.MIN_VALUE) <= 0) {
                            long[] jArr3 = this.metadata;
                            int i14 = this._capacity;
                            int i15 = 0;
                            int i16 = 0;
                            while (i15 < i14) {
                                int i17 = i15 >> 3;
                                int i18 = (i15 & 7) << 3;
                                if (((jArr3[i17] >> i18) & 255) == 254) {
                                    long[] jArr4 = this.metadata;
                                    jArr = jArr3;
                                    i3 = i14;
                                    jArr4[i17] = ((~(255 << i18)) & jArr4[i17]) | (128 << i18);
                                    int i19 = this._capacity;
                                    int i20 = ((i15 - 7) & i19) + (i19 & 7);
                                    int i21 = i20 >> 3;
                                    int i22 = (i20 & 7) << 3;
                                    j2 = j4;
                                    jArr4[i21] = ((~(255 << i22)) & jArr4[i21]) | (128 << i22);
                                    i16++;
                                } else {
                                    jArr = jArr3;
                                    i3 = i14;
                                    j2 = j4;
                                }
                                i15++;
                                i14 = i3;
                                jArr3 = jArr;
                                j4 = j2;
                            }
                            j = j4;
                            this.f1723a += i16;
                            m401a = m401a(i6);
                        }
                    }
                    j = j4;
                    m404d(ScatterMapKt.nextCapacity(this._capacity));
                    m401a = m401a(i6);
                }
                this._size++;
                int i23 = this.f1723a;
                long[] jArr5 = this.metadata;
                int i24 = m401a >> 3;
                long j7 = jArr5[i24];
                int i25 = (m401a & 7) << 3;
                if (((j7 >> i25) & 255) == 128) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                this.f1723a = i23 - i2;
                jArr5[i24] = (j7 & (~(255 << i25))) | (j << i25);
                int i26 = this._capacity;
                int i27 = ((m401a - 7) & i26) + (i26 & 7);
                int i28 = i27 >> 3;
                int i29 = (i27 & 7) << 3;
                jArr5[i28] = (jArr5[i28] & (~(255 << i29))) | (j << i29);
                return ~m401a;
            }
            i10 += 8;
            i9 = (i9 + i10) & i8;
            i7 = i13;
        }
    }

    /* renamed from: c */
    public final void m403c(int i) {
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
        this.f1723a = ScatterMapKt.loadedCapacity(get_capacity()) - this._size;
        this.keys = new Object[i2];
        this.values = new long[i2];
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
        ArraysKt___ArraysJvmKt.fill(this.keys, (Object) null, 0, this._capacity);
        this.f1723a = ScatterMapKt.loadedCapacity(get_capacity()) - this._size;
    }

    /* renamed from: d */
    public final void m404d(int i) {
        int i2;
        int i3;
        long[] jArr = this.metadata;
        Object[] objArr = this.keys;
        long[] jArr2 = this.values;
        int i4 = this._capacity;
        m403c(i);
        Object[] objArr2 = this.keys;
        long[] jArr3 = this.values;
        int i5 = 0;
        while (i5 < i4) {
            if (((jArr[i5 >> 3] >> ((i5 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i5];
                if (obj != null) {
                    i3 = obj.hashCode();
                } else {
                    i3 = 0;
                }
                int i6 = i3 * ScatterMapKt.MurmurHashC1;
                int i7 = i6 ^ (i6 << 16);
                int m401a = m401a(i7 >>> 7);
                long j = i7 & 127;
                long[] jArr4 = this.metadata;
                int i8 = m401a >> 3;
                int i9 = (m401a & 7) << 3;
                i2 = i5;
                jArr4[i8] = (jArr4[i8] & (~(255 << i9))) | (j << i9);
                int i10 = this._capacity;
                int i11 = ((m401a - 7) & i10) + (i10 & 7);
                int i12 = i11 >> 3;
                int i13 = (i11 & 7) << 3;
                jArr4[i12] = (jArr4[i12] & (~(255 << i13))) | (j << i13);
                objArr2[m401a] = obj;
                jArr3[m401a] = jArr2[i2];
            } else {
                i2 = i5;
            }
            i5 = i2 + 1;
        }
    }

    public final long getOrPut(K key, @NotNull Function0<Long> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int findKeyIndex = findKeyIndex(key);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        long longValue = defaultValue.invoke().longValue();
        set(key, longValue);
        return longValue;
    }

    public final void minusAssign(K key) {
        remove(key);
    }

    public final void plusAssign(@NotNull ObjectLongMap<K> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        putAll(from);
    }

    public final void put(K key, long value) {
        set(key, value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(@NotNull ObjectLongMap<K> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        Object[] objArr = from.keys;
        long[] jArr = from.values;
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
                            set(objArr[i4], jArr[i4]);
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

    public final void remove(K key) {
        int findKeyIndex = findKeyIndex(key);
        if (findKeyIndex >= 0) {
            removeValueAt(findKeyIndex);
        }
    }

    public final void removeIf(@NotNull Function2<? super K, ? super Long, Boolean> predicate) {
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
                            if (predicate.invoke(this.keys[i4], Long.valueOf(this.values[i4])).booleanValue()) {
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
        this.keys[index] = null;
    }

    public final void set(K key, long value) {
        int m402b = m402b(key);
        if (m402b < 0) {
            m402b = ~m402b;
        }
        this.keys[m402b] = key;
        this.values[m402b] = value;
    }

    public final int trim() {
        int i = this._capacity;
        int normalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (normalizeCapacity < i) {
            m404d(normalizeCapacity);
            return i - this._capacity;
        }
        return 0;
    }

    public /* synthetic */ MutableObjectLongMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    public final void minusAssign(@NotNull K[] keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        for (K k : keys) {
            remove(k);
        }
    }

    public final long put(K key, long value, long r7) {
        int m402b = m402b(key);
        if (m402b < 0) {
            m402b = ~m402b;
        } else {
            r7 = this.values[m402b];
        }
        this.keys[m402b] = key;
        this.values[m402b] = value;
        return r7;
    }

    public MutableObjectLongMap(int i) {
        super(null);
        if (i >= 0) {
            m403c(ScatterMapKt.unloadedCapacity(i));
            return;
        }
        throw new IllegalArgumentException("Capacity must be a positive value.");
    }

    public final boolean remove(K key, long value) {
        int findKeyIndex = findKeyIndex(key);
        if (findKeyIndex < 0 || this.values[findKeyIndex] != value) {
            return false;
        }
        removeValueAt(findKeyIndex);
        return true;
    }

    public final void minusAssign(@NotNull Iterable<? extends K> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Iterator<? extends K> it = keys.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final void minusAssign(@NotNull Sequence<? extends K> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Iterator<? extends K> it = keys.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(@NotNull ScatterSet<K> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        Object[] objArr = keys.elements;
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
                        remove(objArr[(i << 3) + i3]);
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
}
