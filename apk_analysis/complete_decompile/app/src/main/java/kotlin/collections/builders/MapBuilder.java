package kotlin.collections.builders;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.r82;

@Metadata(m5568d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u000b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u00060\u0004j\u0002`\u0005:\u0006bcdefgB\t\b\u0016¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u0019\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0015\u0010\u0013J\u001a\u0010\u0016\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0018\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001c\u001a\u00020\u001b2\u0014\u0010\u001a\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001e\u0010\u0017J\u000f\u0010\u001f\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001f\u0010\u0007J\u001a\u0010\"\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0096\u0002¢\u0006\u0004\b\"\u0010\u0013J\u000f\u0010#\u001a\u00020\bH\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010)\u001a\u00020\u001bH\u0000¢\u0006\u0004\b(\u0010\u0007J\u0017\u0010,\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0000¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0000¢\u0006\u0004\b-\u0010+J#\u00103\u001a\u00020\u000e2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010/H\u0000¢\u0006\u0004\b1\u00102J\u001b\u00108\u001a\u00020\u000e2\n\u00105\u001a\u0006\u0012\u0002\b\u000304H\u0000¢\u0006\u0004\b6\u00107J#\u0010:\u001a\u00020\u000e2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010/H\u0000¢\u0006\u0004\b9\u00102J\u0017\u0010=\u001a\u00020\u000e2\u0006\u0010;\u001a\u00028\u0001H\u0000¢\u0006\u0004\b<\u0010\u0013J\u001b\u0010A\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010>H\u0000¢\u0006\u0004\b?\u0010@J\u001b\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010BH\u0000¢\u0006\u0004\bC\u0010DJ\u001b\u0010I\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010FH\u0000¢\u0006\u0004\bG\u0010HJ\u000f\u0010J\u001a\u00020 H\u0002¢\u0006\u0004\bJ\u0010KR$\u0010P\u001a\u00020\b2\u0006\u0010L\u001a\u00020\b8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010$R$\u0010T\u001a\u00020\u000e2\u0006\u0010L\u001a\u00020\u000e8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010\u0010R\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00028\u00000U8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010WR\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00010Y8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[R&\u0010_\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010]0U8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u0010WR\u0014\u0010a\u001a\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b`\u0010$¨\u0006h"}, m5569d2 = {"Lkotlin/collections/builders/MapBuilder;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "", "initialCapacity", "(I)V", "", "build", "()Ljava/util/Map;", "", "isEmpty", "()Z", "key", "containsKey", "(Ljava/lang/Object;)Z", "value", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", TypedValues.TransitionType.S_FROM, "", "putAll", "(Ljava/util/Map;)V", "remove", "clear", "", "other", "equals", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "checkIsMutable$kotlin_stdlib", "checkIsMutable", "addKey$kotlin_stdlib", "(Ljava/lang/Object;)I", "addKey", "removeKey$kotlin_stdlib", "removeKey", "", "entry", "containsEntry$kotlin_stdlib", "(Ljava/util/Map$Entry;)Z", "containsEntry", "", "m", "containsAllEntries$kotlin_stdlib", "(Ljava/util/Collection;)Z", "containsAllEntries", "removeEntry$kotlin_stdlib", "removeEntry", "element", "removeValue$kotlin_stdlib", "removeValue", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator", "writeReplace", "()Ljava/lang/Object;", "<set-?>", "h", "I", "getSize", "size", "l", "Z", "isReadOnly$kotlin_stdlib", "isReadOnly", "", "getKeys", "()Ljava/util/Set;", "keys", "", "getValues", "()Ljava/util/Collection;", "values", "", "getEntries", "entries", "getCapacity$kotlin_stdlib", "capacity", "wd0", "EntriesItr", "EntryRef", "Itr", "KeysItr", "ValuesItr", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, KMutableMap {

    /* renamed from: a */
    public Object[] f21022a;

    /* renamed from: b */
    public Object[] f21023b;

    /* renamed from: c */
    public int[] f21024c;

    /* renamed from: d */
    public int[] f21025d;

    /* renamed from: e */
    public int f21026e;

    /* renamed from: f */
    public int f21027f;

    /* renamed from: g */
    public int f21028g;

    /* renamed from: h, reason: from kotlin metadata */
    public int size;

    /* renamed from: i */
    public MapBuilderKeys f21030i;

    /* renamed from: j */
    public MapBuilderValues f21031j;

    /* renamed from: k */
    public MapBuilderEntries f21032k;

    /* renamed from: l, reason: from kotlin metadata */
    public boolean isReadOnly;

    @Metadata(m5568d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00050\u0004B\u0019\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nH\u0096\u0002J\u0012\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fJ\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012¨\u0006\u0013"}, m5569d2 = {"Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/builders/MapBuilder$Itr;", "", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "Lkotlin/collections/builders/MapBuilder$EntryRef;", "nextAppendString", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nextHashCode", "", "nextHashCode$kotlin_stdlib", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class EntriesItr<K, V> extends Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EntriesItr(@NotNull MapBuilder<K, V> map) {
            super(map);
            Intrinsics.checkNotNullParameter(map, "map");
        }

        public final void nextAppendString(@NotNull StringBuilder sb) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            if (getIndex() < getMap$kotlin_stdlib().f21027f) {
                int index = getIndex();
                setIndex$kotlin_stdlib(index + 1);
                setLastIndex$kotlin_stdlib(index);
                Object obj = getMap$kotlin_stdlib().f21022a[getLastIndex()];
                if (Intrinsics.areEqual(obj, getMap$kotlin_stdlib())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj);
                }
                sb.append('=');
                Object[] objArr = getMap$kotlin_stdlib().f21023b;
                Intrinsics.checkNotNull(objArr);
                Object obj2 = objArr[getLastIndex()];
                if (Intrinsics.areEqual(obj2, getMap$kotlin_stdlib())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj2);
                }
                initNext$kotlin_stdlib();
                return;
            }
            throw new NoSuchElementException();
        }

        public final int nextHashCode$kotlin_stdlib() {
            int i;
            if (getIndex() < getMap$kotlin_stdlib().f21027f) {
                int index = getIndex();
                setIndex$kotlin_stdlib(index + 1);
                setLastIndex$kotlin_stdlib(index);
                Object obj = getMap$kotlin_stdlib().f21022a[getLastIndex()];
                int i2 = 0;
                if (obj != null) {
                    i = obj.hashCode();
                } else {
                    i = 0;
                }
                Object[] objArr = getMap$kotlin_stdlib().f21023b;
                Intrinsics.checkNotNull(objArr);
                Object obj2 = objArr[getLastIndex()];
                if (obj2 != null) {
                    i2 = obj2.hashCode();
                }
                int i3 = i ^ i2;
                initNext$kotlin_stdlib();
                return i3;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        @NotNull
        public EntryRef<K, V> next() {
            if (getIndex() < getMap$kotlin_stdlib().f21027f) {
                int index = getIndex();
                setIndex$kotlin_stdlib(index + 1);
                setLastIndex$kotlin_stdlib(index);
                EntryRef<K, V> entryRef = new EntryRef<>(getMap$kotlin_stdlib(), getLastIndex());
                initNext$kotlin_stdlib();
                return entryRef;
            }
            throw new NoSuchElementException();
        }
    }

    @Metadata(m5568d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0003B#\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00028\u00032\u0006\u0010\n\u001a\u00028\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00028\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018¨\u0006\u001c"}, m5569d2 = {"Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Lkotlin/collections/builders/MapBuilder;", "map", "", FirebaseAnalytics.Param.INDEX, "<init>", "(Lkotlin/collections/builders/MapBuilder;I)V", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getKey", "()Ljava/lang/Object;", "key", "getValue", "value", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {

        /* renamed from: a */
        public final MapBuilder f21034a;

        /* renamed from: b */
        public final int f21035b;

        public EntryRef(@NotNull MapBuilder<K, V> map, int i) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.f21034a = map;
            this.f21035b = i;
        }

        @Override // java.util.Map.Entry
        public boolean equals(@Nullable Object other) {
            if (other instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) other;
                if (Intrinsics.areEqual(entry.getKey(), getKey()) && Intrinsics.areEqual(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) this.f21034a.f21022a[this.f21035b];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = this.f21034a.f21023b;
            Intrinsics.checkNotNull(objArr);
            return (V) objArr[this.f21035b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int i;
            K key = getKey();
            int i2 = 0;
            if (key != null) {
                i = key.hashCode();
            } else {
                i = 0;
            }
            V value = getValue();
            if (value != null) {
                i2 = value.hashCode();
            }
            return i ^ i2;
        }

        @Override // java.util.Map.Entry
        public V setValue(V newValue) {
            MapBuilder mapBuilder = this.f21034a;
            mapBuilder.checkIsMutable$kotlin_stdlib();
            Object[] access$allocateValuesArray = MapBuilder.access$allocateValuesArray(mapBuilder);
            int i = this.f21035b;
            V v = (V) access$allocateValuesArray[i];
            access$allocateValuesArray[i] = newValue;
            return v;
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    @Metadata(m5568d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\nJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\nR&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00148\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00148\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001a¨\u0006 "}, m5569d2 = {"Lkotlin/collections/builders/MapBuilder$Itr;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Lkotlin/collections/builders/MapBuilder;", "map", "<init>", "(Lkotlin/collections/builders/MapBuilder;)V", "", "initNext$kotlin_stdlib", "()V", "initNext", "", "hasNext", "()Z", "remove", "a", "Lkotlin/collections/builders/MapBuilder;", "getMap$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "", "b", "I", "getIndex$kotlin_stdlib", "()I", "setIndex$kotlin_stdlib", "(I)V", FirebaseAnalytics.Param.INDEX, "c", "getLastIndex$kotlin_stdlib", "setLastIndex$kotlin_stdlib", "lastIndex", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    @SourceDebugExtension({"SMAP\nMapBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapBuilder.kt\nkotlin/collections/builders/MapBuilder$Itr\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,694:1\n1#2:695\n*E\n"})
    /* loaded from: classes2.dex */
    public static class Itr<K, V> {

        /* renamed from: a, reason: from kotlin metadata */
        public final MapBuilder map;

        /* renamed from: b, reason: from kotlin metadata */
        public int index;

        /* renamed from: c, reason: from kotlin metadata */
        public int lastIndex;

        public Itr(@NotNull MapBuilder<K, V> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
            this.lastIndex = -1;
            initNext$kotlin_stdlib();
        }

        /* renamed from: getIndex$kotlin_stdlib, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* renamed from: getLastIndex$kotlin_stdlib, reason: from getter */
        public final int getLastIndex() {
            return this.lastIndex;
        }

        @NotNull
        public final MapBuilder<K, V> getMap$kotlin_stdlib() {
            return this.map;
        }

        public final boolean hasNext() {
            if (this.index < this.map.f21027f) {
                return true;
            }
            return false;
        }

        public final void initNext$kotlin_stdlib() {
            while (true) {
                int i = this.index;
                MapBuilder mapBuilder = this.map;
                if (i < mapBuilder.f21027f) {
                    int[] iArr = mapBuilder.f21024c;
                    int i2 = this.index;
                    if (iArr[i2] < 0) {
                        this.index = i2 + 1;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        public final void remove() {
            if (this.lastIndex != -1) {
                MapBuilder mapBuilder = this.map;
                mapBuilder.checkIsMutable$kotlin_stdlib();
                mapBuilder.m5598h(this.lastIndex);
                this.lastIndex = -1;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }

        public final void setIndex$kotlin_stdlib(int i) {
            this.index = i;
        }

        public final void setLastIndex$kotlin_stdlib(int i) {
            this.lastIndex = i;
        }
    }

    @Metadata(m5568d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, m5569d2 = {"Lkotlin/collections/builders/MapBuilder$KeysItr;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class KeysItr<K, V> extends Itr<K, V> implements Iterator<K>, KMutableIterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KeysItr(@NotNull MapBuilder<K, V> map) {
            super(map);
            Intrinsics.checkNotNullParameter(map, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (getIndex() < getMap$kotlin_stdlib().f21027f) {
                int index = getIndex();
                setIndex$kotlin_stdlib(index + 1);
                setLastIndex$kotlin_stdlib(index);
                K k = (K) getMap$kotlin_stdlib().f21022a[getLastIndex()];
                initNext$kotlin_stdlib();
                return k;
            }
            throw new NoSuchElementException();
        }
    }

    @Metadata(m5568d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, m5569d2 = {"Lkotlin/collections/builders/MapBuilder$ValuesItr;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class ValuesItr<K, V> extends Itr<K, V> implements Iterator<V>, KMutableIterator {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ValuesItr(@NotNull MapBuilder<K, V> map) {
            super(map);
            Intrinsics.checkNotNullParameter(map, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (getIndex() < getMap$kotlin_stdlib().f21027f) {
                int index = getIndex();
                setIndex$kotlin_stdlib(index + 1);
                setLastIndex$kotlin_stdlib(index);
                Object[] objArr = getMap$kotlin_stdlib().f21023b;
                Intrinsics.checkNotNull(objArr);
                V v = (V) objArr[getLastIndex()];
                initNext$kotlin_stdlib();
                return v;
            }
            throw new NoSuchElementException();
        }
    }

    public MapBuilder() {
        this(8);
    }

    public static final Object[] access$allocateValuesArray(MapBuilder mapBuilder) {
        Object[] objArr = mapBuilder.f21023b;
        if (objArr == null) {
            Object[] arrayOfUninitializedElements = ListBuilderKt.arrayOfUninitializedElements(mapBuilder.getCapacity$kotlin_stdlib());
            mapBuilder.f21023b = arrayOfUninitializedElements;
            return arrayOfUninitializedElements;
        }
        return objArr;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, tg2] */
    private final Object writeReplace() {
        if (this.isReadOnly) {
            Intrinsics.checkNotNullParameter(this, "map");
            ?? obj = new Object();
            obj.f26809a = this;
            return obj;
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    /* renamed from: a */
    public final void m5593a(int i) {
        Object[] objArr;
        int capacity$kotlin_stdlib = getCapacity$kotlin_stdlib();
        int i2 = this.f21027f;
        int i3 = capacity$kotlin_stdlib - i2;
        int size = i2 - size();
        if (i3 < i && i3 + size >= i && size >= getCapacity$kotlin_stdlib() / 4) {
            m5597g(this.f21025d.length);
            return;
        }
        int i4 = this.f21027f + i;
        if (i4 >= 0) {
            if (i4 > getCapacity$kotlin_stdlib()) {
                int capacity$kotlin_stdlib2 = (getCapacity$kotlin_stdlib() * 3) / 2;
                if (i4 <= capacity$kotlin_stdlib2) {
                    i4 = capacity$kotlin_stdlib2;
                }
                this.f21022a = ListBuilderKt.copyOfUninitializedElements(this.f21022a, i4);
                Object[] objArr2 = this.f21023b;
                if (objArr2 != null) {
                    objArr = ListBuilderKt.copyOfUninitializedElements(objArr2, i4);
                } else {
                    objArr = null;
                }
                this.f21023b = objArr;
                int[] copyOf = Arrays.copyOf(this.f21024c, i4);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                this.f21024c = copyOf;
                int highestOneBit = Integer.highestOneBit(r82.coerceAtLeast(i4, 1) * 3);
                if (highestOneBit > this.f21025d.length) {
                    m5597g(highestOneBit);
                    return;
                }
                return;
            }
            return;
        }
        throw new OutOfMemoryError();
    }

    public final int addKey$kotlin_stdlib(K key) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int m5596f = m5596f(key);
            int coerceAtMost = r82.coerceAtMost(this.f21026e * 2, this.f21025d.length / 2);
            int i = 0;
            while (true) {
                int i2 = this.f21025d[m5596f];
                if (i2 <= 0) {
                    if (this.f21027f >= getCapacity$kotlin_stdlib()) {
                        m5593a(1);
                    } else {
                        int i3 = this.f21027f;
                        int i4 = i3 + 1;
                        this.f21027f = i4;
                        this.f21022a[i3] = key;
                        this.f21024c[i3] = m5596f;
                        this.f21025d[m5596f] = i4;
                        this.size = size() + 1;
                        if (i > this.f21026e) {
                            this.f21026e = i;
                        }
                        return i3;
                    }
                } else {
                    if (Intrinsics.areEqual(this.f21022a[i2 - 1], key)) {
                        return -i2;
                    }
                    i++;
                    if (i > coerceAtMost) {
                        m5597g(this.f21025d.length * 2);
                        break;
                    }
                    int i5 = m5596f - 1;
                    if (m5596f == 0) {
                        m5596f = this.f21025d.length - 1;
                    } else {
                        m5596f = i5;
                    }
                }
            }
        }
    }

    @NotNull
    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.isReadOnly = true;
        return this;
    }

    /* renamed from: c */
    public final int m5594c(Object obj) {
        int m5596f = m5596f(obj);
        int i = this.f21026e;
        while (true) {
            int i2 = this.f21025d[m5596f];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (Intrinsics.areEqual(this.f21022a[i3], obj)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            int i4 = m5596f - 1;
            if (m5596f == 0) {
                m5596f = this.f21025d.length - 1;
            } else {
                m5596f = i4;
            }
        }
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (!this.isReadOnly) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        ?? it = new IntRange(0, this.f21027f - 1).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            int[] iArr = this.f21024c;
            int i = iArr[nextInt];
            if (i >= 0) {
                this.f21025d[i] = 0;
                iArr[nextInt] = -1;
            }
        }
        ListBuilderKt.resetRange(this.f21022a, 0, this.f21027f);
        Object[] objArr = this.f21023b;
        if (objArr != null) {
            ListBuilderKt.resetRange(objArr, 0, this.f21027f);
        }
        this.size = 0;
        this.f21027f = 0;
    }

    public final boolean containsAllEntries$kotlin_stdlib(@NotNull Collection<?> m) {
        Intrinsics.checkNotNullParameter(m, "m");
        for (Object obj : m) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        int m5594c = m5594c(entry.getKey());
        if (m5594c < 0) {
            return false;
        }
        Object[] objArr = this.f21023b;
        Intrinsics.checkNotNull(objArr);
        return Intrinsics.areEqual(objArr[m5594c], entry.getValue());
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        if (m5594c(key) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        if (m5595e(value) >= 0) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public final int m5595e(Object obj) {
        int i = this.f21027f;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.f21024c[i] >= 0) {
                Object[] objArr = this.f21023b;
                Intrinsics.checkNotNull(objArr);
                if (Intrinsics.areEqual(objArr[i], obj)) {
                    return i;
                }
            }
        }
    }

    @NotNull
    public final EntriesItr<K, V> entriesIterator$kotlin_stdlib() {
        return new EntriesItr<>(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(@Nullable Object other) {
        if (other != this) {
            if (other instanceof Map) {
                Map map = (Map) other;
                if (size() != map.size() || !containsAllEntries$kotlin_stdlib(map.entrySet())) {
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public final int m5596f(Object obj) {
        int i;
        if (obj != null) {
            i = obj.hashCode();
        } else {
            i = 0;
        }
        return (i * (-1640531527)) >>> this.f21028g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0062, code lost:
    
        r3[r0] = r7;
        r6.f21024c[r2] = r0;
        r2 = r7;
     */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5597g(int i) {
        int i2;
        int i3 = 0;
        if (this.f21027f > size()) {
            Object[] objArr = this.f21023b;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                i2 = this.f21027f;
                if (i4 >= i2) {
                    break;
                }
                if (this.f21024c[i4] >= 0) {
                    Object[] objArr2 = this.f21022a;
                    objArr2[i5] = objArr2[i4];
                    if (objArr != null) {
                        objArr[i5] = objArr[i4];
                    }
                    i5++;
                }
                i4++;
            }
            ListBuilderKt.resetRange(this.f21022a, i5, i2);
            if (objArr != null) {
                ListBuilderKt.resetRange(objArr, i5, this.f21027f);
            }
            this.f21027f = i5;
        }
        int[] iArr = this.f21025d;
        if (i != iArr.length) {
            this.f21025d = new int[i];
            this.f21028g = Integer.numberOfLeadingZeros(i) + 1;
        } else {
            ArraysKt___ArraysJvmKt.fill(iArr, 0, 0, iArr.length);
        }
        while (i3 < this.f21027f) {
            int i6 = i3 + 1;
            int m5596f = m5596f(this.f21022a[i3]);
            int i7 = this.f21026e;
            while (true) {
                int[] iArr2 = this.f21025d;
                if (iArr2[m5596f] == 0) {
                    break;
                }
                i7--;
                if (i7 >= 0) {
                    int i8 = m5596f - 1;
                    if (m5596f == 0) {
                        m5596f = iArr2.length - 1;
                    } else {
                        m5596f = i8;
                    }
                } else {
                    throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
                }
            }
        }
    }

    @Override // java.util.Map
    @Nullable
    public V get(Object key) {
        int m5594c = m5594c(key);
        if (m5594c < 0) {
            return null;
        }
        Object[] objArr = this.f21023b;
        Intrinsics.checkNotNull(objArr);
        return (V) objArr[m5594c];
    }

    public final int getCapacity$kotlin_stdlib() {
        return this.f21022a.length;
    }

    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        MapBuilderEntries mapBuilderEntries = this.f21032k;
        if (mapBuilderEntries == null) {
            MapBuilderEntries mapBuilderEntries2 = new MapBuilderEntries(this);
            this.f21032k = mapBuilderEntries2;
            return mapBuilderEntries2;
        }
        return mapBuilderEntries;
    }

    @NotNull
    public Set<K> getKeys() {
        MapBuilderKeys mapBuilderKeys = this.f21030i;
        if (mapBuilderKeys == null) {
            MapBuilderKeys mapBuilderKeys2 = new MapBuilderKeys(this);
            this.f21030i = mapBuilderKeys2;
            return mapBuilderKeys2;
        }
        return mapBuilderKeys;
    }

    public int getSize() {
        return this.size;
    }

    @NotNull
    public Collection<V> getValues() {
        MapBuilderValues mapBuilderValues = this.f21031j;
        if (mapBuilderValues == null) {
            MapBuilderValues mapBuilderValues2 = new MapBuilderValues(this);
            this.f21031j = mapBuilderValues2;
            return mapBuilderValues2;
        }
        return mapBuilderValues;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[LOOP:0: B:2:0x001a->B:19:?, LOOP_END, SYNTHETIC] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5598h(int i) {
        ListBuilderKt.resetAt(this.f21022a, i);
        int i2 = this.f21024c[i];
        int coerceAtMost = r82.coerceAtMost(this.f21026e * 2, this.f21025d.length / 2);
        int i3 = 0;
        int i4 = i2;
        while (true) {
            int i5 = i2 - 1;
            if (i2 == 0) {
                i2 = this.f21025d.length - 1;
            } else {
                i2 = i5;
            }
            i3++;
            if (i3 > this.f21026e) {
                this.f21025d[i4] = 0;
                break;
            }
            int[] iArr = this.f21025d;
            int i6 = iArr[i2];
            if (i6 == 0) {
                iArr[i4] = 0;
                break;
            }
            if (i6 < 0) {
                iArr[i4] = -1;
            } else {
                int i7 = i6 - 1;
                int m5596f = m5596f(this.f21022a[i7]) - i2;
                int[] iArr2 = this.f21025d;
                if ((m5596f & (iArr2.length - 1)) >= i3) {
                    iArr2[i4] = i6;
                    this.f21024c[i7] = i4;
                }
                coerceAtMost--;
                if (coerceAtMost >= 0) {
                    this.f21025d[i4] = -1;
                    break;
                }
            }
            i4 = i2;
            i3 = 0;
            coerceAtMost--;
            if (coerceAtMost >= 0) {
            }
        }
        this.f21024c[i] = -1;
        this.size = size() - 1;
    }

    @Override // java.util.Map
    public int hashCode() {
        EntriesItr<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            i += entriesIterator$kotlin_stdlib.nextHashCode$kotlin_stdlib();
        }
        return i;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: isReadOnly$kotlin_stdlib, reason: from getter */
    public final boolean getIsReadOnly() {
        return this.isReadOnly;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @NotNull
    public final KeysItr<K, V> keysIterator$kotlin_stdlib() {
        return new KeysItr<>(this);
    }

    @Override // java.util.Map
    @Nullable
    public V put(K key, V value) {
        checkIsMutable$kotlin_stdlib();
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(key);
        Object[] objArr = this.f21023b;
        if (objArr == null) {
            objArr = ListBuilderKt.arrayOfUninitializedElements(getCapacity$kotlin_stdlib());
            this.f21023b = objArr;
        }
        if (addKey$kotlin_stdlib < 0) {
            int i = (-addKey$kotlin_stdlib) - 1;
            V v = (V) objArr[i];
            objArr[i] = value;
            return v;
        }
        objArr[addKey$kotlin_stdlib] = value;
        return null;
    }

    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends K, ? extends V> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        checkIsMutable$kotlin_stdlib();
        Set<Map.Entry<? extends K, ? extends V>> entrySet = from.entrySet();
        if (!entrySet.isEmpty()) {
            m5593a(entrySet.size());
            for (Map.Entry<? extends K, ? extends V> entry : entrySet) {
                int addKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
                Object[] objArr = this.f21023b;
                if (objArr == null) {
                    objArr = ListBuilderKt.arrayOfUninitializedElements(getCapacity$kotlin_stdlib());
                    this.f21023b = objArr;
                }
                if (addKey$kotlin_stdlib >= 0) {
                    objArr[addKey$kotlin_stdlib] = entry.getValue();
                } else {
                    int i = (-addKey$kotlin_stdlib) - 1;
                    if (!Intrinsics.areEqual(entry.getValue(), objArr[i])) {
                        objArr[i] = entry.getValue();
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Nullable
    public V remove(Object key) {
        int removeKey$kotlin_stdlib = removeKey$kotlin_stdlib(key);
        if (removeKey$kotlin_stdlib < 0) {
            return null;
        }
        Object[] objArr = this.f21023b;
        Intrinsics.checkNotNull(objArr);
        V v = (V) objArr[removeKey$kotlin_stdlib];
        ListBuilderKt.resetAt(objArr, removeKey$kotlin_stdlib);
        return v;
    }

    public final boolean removeEntry$kotlin_stdlib(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int m5594c = m5594c(entry.getKey());
        if (m5594c < 0) {
            return false;
        }
        Object[] objArr = this.f21023b;
        Intrinsics.checkNotNull(objArr);
        if (!Intrinsics.areEqual(objArr[m5594c], entry.getValue())) {
            return false;
        }
        m5598h(m5594c);
        return true;
    }

    public final int removeKey$kotlin_stdlib(K key) {
        checkIsMutable$kotlin_stdlib();
        int m5594c = m5594c(key);
        if (m5594c < 0) {
            return -1;
        }
        m5598h(m5594c);
        return m5594c;
    }

    public final boolean removeValue$kotlin_stdlib(V element) {
        checkIsMutable$kotlin_stdlib();
        int m5595e = m5595e(element);
        if (m5595e < 0) {
            return false;
        }
        m5598h(m5595e);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        EntriesItr<K, V> entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            entriesIterator$kotlin_stdlib.nextAppendString(sb);
            i++;
        }
        sb.append("}");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    @NotNull
    public final ValuesItr<K, V> valuesIterator$kotlin_stdlib() {
        return new ValuesItr<>(this);
    }

    public MapBuilder(int i) {
        Object[] arrayOfUninitializedElements = ListBuilderKt.arrayOfUninitializedElements(i);
        int[] iArr = new int[i];
        int highestOneBit = Integer.highestOneBit(r82.coerceAtLeast(i, 1) * 3);
        this.f21022a = arrayOfUninitializedElements;
        this.f21023b = null;
        this.f21024c = iArr;
        this.f21025d = new int[highestOneBit];
        this.f21026e = 2;
        this.f21027f = 0;
        this.f21028g = Integer.numberOfLeadingZeros(highestOneBit) + 1;
    }
}
