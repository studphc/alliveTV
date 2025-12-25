package androidx.collection;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
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
import org.jetbrains.annotations.Nullable;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\n\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\f\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\n¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0016\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0016\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\f\u001a\u00028\u0000¢\u0006\u0004\b\u0016\u0010\u0019J-\u0010\u001c\u001a\u00020\r2\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00180\u001aH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0003H\u0086\n¢\u0006\u0004\b\u001e\u0010\u0006J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001fH\u0086\n¢\u0006\u0004\b\u001e\u0010!J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010 \u001a\u00020\"H\u0086\n¢\u0006\u0004\b\u001e\u0010#J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010 \u001a\u00020$H\u0086\n¢\u0006\u0004\b\u001e\u0010%J\u0019\u0010'\u001a\u0004\u0018\u00018\u00002\u0006\u0010&\u001a\u00020\u0003H\u0001¢\u0006\u0004\b'\u0010\u0017J\r\u0010(\u001a\u00020\r¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\u0003¢\u0006\u0004\b*\u0010+\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006,"}, m5569d2 = {"Landroidx/collection/MutableIntObjectMap;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/collection/IntObjectMap;", "", "initialCapacity", "<init>", "(I)V", "key", "Lkotlin/Function0;", "defaultValue", "getOrPut", "(ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "value", "", "set", "(ILjava/lang/Object;)V", "put", "(ILjava/lang/Object;)Ljava/lang/Object;", TypedValues.TransitionType.S_FROM, "putAll", "(Landroidx/collection/IntObjectMap;)V", "plusAssign", "remove", "(I)Ljava/lang/Object;", "", "(ILjava/lang/Object;)Z", "Lkotlin/Function2;", "predicate", "removeIf", "(Lkotlin/jvm/functions/Function2;)V", "minusAssign", "", "keys", "([I)V", "Landroidx/collection/IntSet;", "(Landroidx/collection/IntSet;)V", "Landroidx/collection/IntList;", "(Landroidx/collection/IntList;)V", FirebaseAnalytics.Param.INDEX, "removeValueAt", "clear", "()V", "trim", "()I", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nIntObjectMap.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntObjectMap.kt\nandroidx/collection/MutableIntObjectMap\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 4 IntObjectMap.kt\nandroidx/collection/IntObjectMap\n+ 5 IntSet.kt\nandroidx/collection/IntSetKt\n+ 6 IntSet.kt\nandroidx/collection/IntSet\n+ 7 IntList.kt\nandroidx/collection/IntList\n*L\n1#1,1034:1\n820#1,2:1187\n820#1,2:1201\n1024#1,2:1204\n1028#1,5:1212\n1024#1,2:1243\n1028#1,5:1251\n1024#1,2:1268\n1028#1,5:1276\n1024#1,2:1282\n1028#1,5:1290\n1#2:1035\n1672#3,6:1036\n1826#3:1052\n1688#3:1056\n1619#3:1073\n1615#3:1076\n1795#3,3:1081\n1809#3,3:1085\n1733#3:1089\n1721#3:1091\n1715#3:1092\n1728#3:1097\n1818#3:1099\n1619#3:1113\n1615#3:1116\n1795#3,3:1121\n1809#3,3:1125\n1733#3:1129\n1721#3:1131\n1715#3:1132\n1728#3:1137\n1818#3:1139\n1826#3:1154\n1688#3:1158\n1826#3:1179\n1688#3:1183\n1672#3,6:1206\n1672#3,6:1217\n1615#3:1226\n1619#3:1227\n1795#3,3:1228\n1809#3,3:1231\n1733#3:1234\n1721#3:1235\n1715#3:1236\n1728#3:1237\n1818#3:1238\n1682#3:1239\n1661#3:1240\n1680#3:1241\n1661#3:1242\n1672#3,6:1245\n1795#3,3:1256\n1826#3:1259\n1715#3:1260\n1685#3:1261\n1661#3:1262\n1615#3:1266\n1619#3:1267\n1672#3,6:1270\n1661#3:1281\n1672#3,6:1284\n1672#3,6:1295\n1672#3,6:1301\n382#4,4:1042\n354#4,6:1046\n364#4,3:1053\n367#4,2:1057\n387#4,2:1059\n370#4,6:1061\n389#4:1067\n619#4:1068\n620#4:1072\n622#4,2:1074\n624#4,4:1077\n628#4:1084\n629#4:1088\n630#4:1090\n631#4,4:1093\n637#4:1098\n638#4,8:1100\n619#4:1108\n620#4:1112\n622#4,2:1114\n624#4,4:1117\n628#4:1124\n629#4:1128\n630#4:1130\n631#4,4:1133\n637#4:1138\n638#4,8:1140\n354#4,6:1148\n364#4,3:1155\n367#4,9:1159\n849#5,3:1069\n849#5,3:1109\n849#5,3:1223\n849#5,3:1263\n262#6,4:1168\n232#6,7:1172\n243#6,3:1180\n246#6,2:1184\n266#6:1186\n267#6:1189\n249#6,6:1190\n268#6:1196\n253#7,4:1197\n258#7:1203\n*S KotlinDebug\n*F\n+ 1 IntObjectMap.kt\nandroidx/collection/MutableIntObjectMap\n*L\n837#1:1187,2\n846#1:1201,2\n856#1:1204,2\n856#1:1212,5\n920#1:1243,2\n920#1:1251,5\n994#1:1268,2\n994#1:1276,5\n1010#1:1282,2\n1010#1:1290,5\n713#1:1036,6\n766#1:1052\n766#1:1056\n782#1:1073\n782#1:1076\n782#1:1081,3\n782#1:1085,3\n782#1:1089\n782#1:1091\n782#1:1092\n782#1:1097\n782#1:1099\n794#1:1113\n794#1:1116\n794#1:1121,3\n794#1:1125,3\n794#1:1129\n794#1:1131\n794#1:1132\n794#1:1137\n794#1:1139\n808#1:1154\n808#1:1158\n836#1:1179\n836#1:1183\n856#1:1206,6\n871#1:1217,6\n886#1:1226\n887#1:1227\n894#1:1228,3\n895#1:1231,3\n896#1:1234\n897#1:1235\n897#1:1236\n901#1:1237\n904#1:1238\n913#1:1239\n913#1:1240\n919#1:1241\n919#1:1242\n920#1:1245,6\n935#1:1256,3\n936#1:1259\n938#1:1260\n989#1:1261\n989#1:1262\n992#1:1266\n994#1:1267\n994#1:1270,6\n1008#1:1281\n1010#1:1284,6\n1025#1:1295,6\n1031#1:1301,6\n766#1:1042,4\n766#1:1046,6\n766#1:1053,3\n766#1:1057,2\n766#1:1059,2\n766#1:1061,6\n766#1:1067\n782#1:1068\n782#1:1072\n782#1:1074,2\n782#1:1077,4\n782#1:1084\n782#1:1088\n782#1:1090\n782#1:1093,4\n782#1:1098\n782#1:1100,8\n794#1:1108\n794#1:1112\n794#1:1114,2\n794#1:1117,4\n794#1:1124\n794#1:1128\n794#1:1130\n794#1:1133,4\n794#1:1138\n794#1:1140,8\n808#1:1148,6\n808#1:1155,3\n808#1:1159,9\n782#1:1069,3\n794#1:1109,3\n885#1:1223,3\n991#1:1263,3\n836#1:1168,4\n836#1:1172,7\n836#1:1180,3\n836#1:1184,2\n836#1:1186\n836#1:1189\n836#1:1190,6\n836#1:1196\n845#1:1197,4\n845#1:1203\n*E\n"})
/* loaded from: classes.dex */
public final class MutableIntObjectMap<V> extends IntObjectMap<V> {

    /* renamed from: a */
    public int f1713a;

    public MutableIntObjectMap() {
        this(0, 1, null);
    }

    /* renamed from: a */
    public final int m363a(int i) {
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
                int m364b = m364b(i4);
                long j5 = 128;
                if (this.f1713a == 0 && ((this.metadata[m364b >> 3] >> ((m364b & 7) << 3)) & 255) != 254) {
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
                            this.f1713a += i14;
                            m364b = m364b(i4);
                        }
                    }
                    m366d(ScatterMapKt.nextCapacity(this._capacity));
                    m364b = m364b(i4);
                }
                int i21 = 1;
                this._size++;
                int i22 = this.f1713a;
                long[] jArr4 = this.metadata;
                int i23 = m364b >> 3;
                long j6 = jArr4[i23];
                int i24 = (m364b & 7) << 3;
                if (((j6 >> i24) & 255) != 128) {
                    i21 = 0;
                }
                this.f1713a = i22 - i21;
                jArr4[i23] = ((~(255 << i24)) & j6) | (j2 << i24);
                int i25 = this._capacity;
                int i26 = ((m364b - 7) & i25) + (i25 & 7);
                int i27 = i26 >> 3;
                int i28 = (i26 & 7) << 3;
                jArr4[i27] = (jArr4[i27] & (~(255 << i28))) | (j2 << i28);
                return m364b;
            }
            i8 = i11 + 8;
            i7 = (i7 + i8) & i6;
        }
    }

    /* renamed from: b */
    public final int m364b(int i) {
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

    /* renamed from: c */
    public final void m365c(int i) {
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
        this.f1713a = ScatterMapKt.loadedCapacity(get_capacity()) - this._size;
        this.keys = new int[i2];
        this.values = new Object[i2];
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
        ArraysKt___ArraysJvmKt.fill(this.values, (Object) null, 0, this._capacity);
        this.f1713a = ScatterMapKt.loadedCapacity(get_capacity()) - this._size;
    }

    /* renamed from: d */
    public final void m366d(int i) {
        long[] jArr;
        int[] iArr;
        long[] jArr2 = this.metadata;
        int[] iArr2 = this.keys;
        Object[] objArr = this.values;
        int i2 = this._capacity;
        m365c(i);
        int[] iArr3 = this.keys;
        Object[] objArr2 = this.values;
        int i3 = 0;
        while (i3 < i2) {
            if (((jArr2[i3 >> 3] >> ((i3 & 7) << 3)) & 255) < 128) {
                int i4 = iArr2[i3];
                int i5 = ScatterMapKt.MurmurHashC1 * i4;
                int i6 = i5 ^ (i5 << 16);
                int m364b = m364b(i6 >>> 7);
                long j = i6 & 127;
                long[] jArr3 = this.metadata;
                int i7 = m364b >> 3;
                int i8 = (m364b & 7) << 3;
                jArr = jArr2;
                iArr = iArr2;
                jArr3[i7] = (jArr3[i7] & (~(255 << i8))) | (j << i8);
                int i9 = this._capacity;
                int i10 = ((m364b - 7) & i9) + (i9 & 7);
                int i11 = i10 >> 3;
                int i12 = (i10 & 7) << 3;
                jArr3[i11] = ((~(255 << i12)) & jArr3[i11]) | (j << i12);
                iArr3[m364b] = i4;
                objArr2[m364b] = objArr[i3];
            } else {
                jArr = jArr2;
                iArr = iArr2;
            }
            i3++;
            jArr2 = jArr;
            iArr2 = iArr;
        }
    }

    public final V getOrPut(int key, @NotNull Function0<? extends V> defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        V v = get(key);
        if (v == null) {
            V invoke = defaultValue.invoke();
            set(key, invoke);
            return invoke;
        }
        return v;
    }

    public final void minusAssign(int key) {
        remove(key);
    }

    public final void plusAssign(@NotNull IntObjectMap<V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        putAll(from);
    }

    @Nullable
    public final V put(int key, V value) {
        int m363a = m363a(key);
        Object[] objArr = this.values;
        V v = (V) objArr[m363a];
        this.keys[m363a] = key;
        objArr[m363a] = value;
        return v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putAll(@NotNull IntObjectMap<V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        int[] iArr = from.keys;
        Object[] objArr = from.values;
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
                            set(iArr[i4], objArr[i4]);
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

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005d, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
    
        r10 = -1;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final V remove(int key) {
        int i;
        int i2 = ScatterMapKt.MurmurHashC1 * key;
        int i3 = i2 ^ (i2 << 16);
        int i4 = i3 & 127;
        int i5 = this._capacity;
        int i6 = (i3 >>> 7) & i5;
        int i7 = 0;
        loop0: while (true) {
            long[] jArr = this.metadata;
            int i8 = i6 >> 3;
            int i9 = (i6 & 7) << 3;
            long j = ((jArr[i8 + 1] << (64 - i9)) & ((-i9) >> 63)) | (jArr[i8] >>> i9);
            long j2 = (i4 * ScatterMapKt.BitmaskLsb) ^ j;
            long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L);
            while (true) {
                if (j3 == 0) {
                    break;
                }
                i = ((Long.numberOfTrailingZeros(j3) >> 3) + i6) & i5;
                if (this.keys[i] == key) {
                    break loop0;
                }
                j3 &= j3 - 1;
            }
            i7 += 8;
            i6 = (i6 + i7) & i5;
        }
        if (i >= 0) {
            return removeValueAt(i);
        }
        return null;
    }

    public final void removeIf(@NotNull Function2<? super Integer, ? super V, Boolean> predicate) {
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
                            if (predicate.invoke(Integer.valueOf(this.keys[i4]), this.values[i4]).booleanValue()) {
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
    @Nullable
    public final V removeValueAt(int index) {
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
        Object[] objArr = this.values;
        V v = (V) objArr[index];
        objArr[index] = null;
        return v;
    }

    public final void set(int key, V value) {
        int m363a = m363a(key);
        this.keys[m363a] = key;
        this.values[m363a] = value;
    }

    public final int trim() {
        int i = this._capacity;
        int normalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (normalizeCapacity < i) {
            m366d(normalizeCapacity);
            return i - this._capacity;
        }
        return 0;
    }

    public /* synthetic */ MutableIntObjectMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    public final void minusAssign(@NotNull int[] keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        for (int i : keys) {
            remove(i);
        }
    }

    public MutableIntObjectMap(int i) {
        super(null);
        if (i >= 0) {
            m365c(ScatterMapKt.unloadedCapacity(i));
            return;
        }
        throw new IllegalArgumentException("Capacity must be a positive value.");
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

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0062, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0064, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean remove(int key, V value) {
        int i;
        int i2 = ScatterMapKt.MurmurHashC1 * key;
        int i3 = i2 ^ (i2 << 16);
        int i4 = i3 & 127;
        int i5 = this._capacity;
        int i6 = (i3 >>> 7) & i5;
        int i7 = 0;
        loop0: while (true) {
            long[] jArr = this.metadata;
            int i8 = i6 >> 3;
            int i9 = (i6 & 7) << 3;
            long j = ((jArr[i8 + 1] << (64 - i9)) & ((-i9) >> 63)) | (jArr[i8] >>> i9);
            long j2 = (i4 * ScatterMapKt.BitmaskLsb) ^ j;
            long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L);
            while (true) {
                if (j3 == 0) {
                    break;
                }
                i = ((Long.numberOfTrailingZeros(j3) >> 3) + i6) & i5;
                if (this.keys[i] == key) {
                    break loop0;
                }
                j3 &= j3 - 1;
            }
            i7 += 8;
            i6 = (i6 + i7) & i5;
        }
        if (i < 0 || !Intrinsics.areEqual(this.values[i], value)) {
            return false;
        }
        removeValueAt(i);
        return true;
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
