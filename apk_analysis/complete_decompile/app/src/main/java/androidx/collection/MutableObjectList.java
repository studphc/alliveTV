package androidx.collection;

import androidx.annotation.IntRange;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import p000.r82;
import p000.uq1;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0003FGHB\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\t\u001a\u00020\f2\b\b\u0001\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\rJ%\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012¢\u0006\u0004\b\u0010\u0010\u0013J%\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0010\u0010\u0014J\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0010\u0010\u0015J\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016¢\u0006\u0004\b\u0010\u0010\u0017J\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0010\u0010\u0018J\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019¢\u0006\u0004\b\u0010\u0010\u001aJ\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\u0004\b\u0010\u0010\u001cJ\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\u0004\b\u0010\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002¢\u0006\u0004\b\u001f\u0010 J\u001e\u0010\u001f\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0086\u0002¢\u0006\u0004\b\u001f\u0010!J\u001e\u0010\u001f\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0086\u0002¢\u0006\u0004\b\u001f\u0010\"J\u001e\u0010\u001f\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002¢\u0006\u0004\b\u001f\u0010#J\u001e\u0010\u001f\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0086\u0002¢\u0006\u0004\b\u001f\u0010$J\u001e\u0010\u001f\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0086\u0002¢\u0006\u0004\b\u001f\u0010%J\r\u0010&\u001a\u00020\f¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\f2\b\b\u0002\u0010(\u001a\u00020\u0003¢\u0006\u0004\b)\u0010\u0006J\u0015\u0010+\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u0003¢\u0006\u0004\b+\u0010\u0006J\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\n¢\u0006\u0004\b\u001f\u0010,J\u0018\u0010-\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\n¢\u0006\u0004\b-\u0010,J\u0015\u0010.\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b.\u0010\nJ6\u00103\u001a\u00020\f2!\u00102\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0/H\u0086\bø\u0001\u0000¢\u0006\u0004\b3\u00104J\u001b\u00105\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b5\u0010\u0018J\u001b\u00105\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b5\u0010\u0015J\u001b\u00105\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016¢\u0006\u0004\b5\u0010\u0017J\u001b\u00105\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019¢\u0006\u0004\b5\u0010\u001aJ\u001b\u00105\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\u0004\b5\u0010\u001cJ\u001b\u00105\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\u0004\b5\u0010\u001eJ\u001e\u0010-\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0086\u0002¢\u0006\u0004\b-\u0010\"J\u001e\u0010-\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002¢\u0006\u0004\b-\u0010 J\u001e\u0010-\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0086\u0002¢\u0006\u0004\b-\u0010!J\u001e\u0010-\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0086\u0002¢\u0006\u0004\b-\u0010#J\u001e\u0010-\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0086\u0002¢\u0006\u0004\b-\u0010$J\u001e\u0010-\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0086\u0002¢\u0006\u0004\b-\u0010%J\u0017\u00106\u001a\u00028\u00002\b\b\u0001\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b6\u00107J!\u0010:\u001a\u00020\f2\b\b\u0001\u00108\u001a\u00020\u00032\b\b\u0001\u00109\u001a\u00020\u0003¢\u0006\u0004\b:\u0010;J\u001b\u0010<\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b<\u0010\u0018J\u001b\u0010<\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b<\u0010\u0015J\u001b\u0010<\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012¢\u0006\u0004\b<\u0010=J\u001b\u0010<\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b¢\u0006\u0004\b<\u0010\u001cJ\u001b\u0010<\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\u0004\b<\u0010\u001eJ\"\u0010>\u001a\u00028\u00002\b\b\u0001\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b>\u0010?J\u0015\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016¢\u0006\u0004\b@\u0010AJ\u0013\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000B¢\u0006\u0004\bC\u0010AR\u0012\u0010*\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\bD\u0010E\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006I"}, m5569d2 = {"Landroidx/collection/MutableObjectList;", ExifInterface.LONGITUDE_EAST, "Landroidx/collection/ObjectList;", "", "initialCapacity", "<init>", "(I)V", "element", "", "add", "(Ljava/lang/Object;)Z", FirebaseAnalytics.Param.INDEX, "", "(ILjava/lang/Object;)V", "", "elements", "addAll", "(I[Ljava/lang/Object;)Z", "", "(ILjava/util/Collection;)Z", "(ILandroidx/collection/ObjectList;)Z", "(Landroidx/collection/ObjectList;)Z", "Landroidx/collection/ScatterSet;", "(Landroidx/collection/ScatterSet;)Z", "([Ljava/lang/Object;)Z", "", "(Ljava/util/List;)Z", "", "(Ljava/lang/Iterable;)Z", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;)Z", "plusAssign", "(Landroidx/collection/ObjectList;)V", "(Landroidx/collection/ScatterSet;)V", "([Ljava/lang/Object;)V", "(Ljava/util/List;)V", "(Ljava/lang/Iterable;)V", "(Lkotlin/sequences/Sequence;)V", "clear", "()V", "minCapacity", "trim", "capacity", "ensureCapacity", "(Ljava/lang/Object;)V", "minusAssign", "remove", "Lkotlin/Function1;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "predicate", "removeIf", "(Lkotlin/jvm/functions/Function1;)V", "removeAll", "removeAt", "(I)Ljava/lang/Object;", "start", "end", "removeRange", "(II)V", "retainAll", "(Ljava/util/Collection;)Z", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "asList", "()Ljava/util/List;", "", "asMutableList", "getCapacity", "()I", "tq1", "uq1", "vq1", "collection"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nObjectList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ObjectList.kt\nandroidx/collection/MutableObjectList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ScatterSet.kt\nandroidx/collection/ScatterSet\n+ 4 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 5 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 6 ObjectList.kt\nandroidx/collection/ObjectList\n+ 7 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,1618:1\n948#1,2:1641\n948#1,2:1652\n948#1,2:1656\n652#1:1659\n955#1,2:1662\n955#1,2:1669\n955#1,2:1691\n955#1,2:1701\n955#1,2:1704\n955#1,2:1708\n1864#2,3:1619\n1855#2:1651\n1856#2:1654\n1855#2:1703\n1856#2:1706\n267#3,4:1622\n237#3,7:1626\n248#3,3:1634\n251#3,2:1638\n272#3:1640\n273#3:1643\n254#3,6:1644\n274#3:1650\n267#3,4:1672\n237#3,7:1676\n248#3,3:1684\n251#3,2:1688\n272#3:1690\n273#3:1693\n254#3,6:1694\n274#3:1700\n1826#4:1633\n1688#4:1637\n1826#4:1683\n1688#4:1687\n1295#5:1655\n1296#5:1658\n1295#5:1707\n1296#5:1710\n80#6:1660\n305#6,4:1665\n310#6:1671\n75#6:1711\n75#6:1712\n75#6:1713\n75#6:1714\n75#6:1715\n75#6:1716\n75#6:1717\n75#6:1718\n13579#7:1661\n13580#7:1664\n*S KotlinDebug\n*F\n+ 1 ObjectList.kt\nandroidx/collection/MutableObjectList\n*L\n864#1:1641,2\n898#1:1652,2\n907#1:1656,2\n927#1:1659\n1050#1:1662,2\n1059#1:1669,2\n1068#1:1691,2\n1077#1:1701,2\n1086#1:1704,2\n1095#1:1708,2\n740#1:1619,3\n897#1:1651\n897#1:1654\n1085#1:1703\n1085#1:1706\n863#1:1622,4\n863#1:1626,7\n863#1:1634,3\n863#1:1638,2\n863#1:1640\n863#1:1643\n863#1:1644,6\n863#1:1650\n1067#1:1672,4\n1067#1:1676,7\n1067#1:1684,3\n1067#1:1688,2\n1067#1:1690\n1067#1:1693\n1067#1:1694,6\n1067#1:1700\n863#1:1633\n863#1:1637\n1067#1:1683\n1067#1:1687\n906#1:1655\n906#1:1658\n1094#1:1707\n1094#1:1710\n979#1:1660\n1058#1:1665,4\n1058#1:1671\n1105#1:1711\n1109#1:1712\n1159#1:1713\n1175#1:1714\n1191#1:1715\n1207#1:1716\n1223#1:1717\n1242#1:1718\n1049#1:1661\n1049#1:1664\n*E\n"})
/* loaded from: classes.dex */
public final class MutableObjectList<E> extends ObjectList<E> {

    /* renamed from: a */
    public uq1 f1722a;

    public MutableObjectList() {
        this(0, 1, null);
    }

    public static /* synthetic */ void trim$default(MutableObjectList mutableObjectList, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mutableObjectList._size;
        }
        mutableObjectList.trim(i);
    }

    public final boolean add(E element) {
        ensureCapacity(this._size + 1);
        Object[] objArr = this.content;
        int i = this._size;
        objArr[i] = element;
        this._size = i + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = 0) int index, @NotNull E[] elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (index >= 0 && index <= (i = this._size)) {
            if (elements.length == 0) {
                return false;
            }
            ensureCapacity(i + elements.length);
            Object[] objArr = this.content;
            int i2 = this._size;
            if (index != i2) {
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, elements.length + index, index, i2);
            }
            ArraysKt___ArraysJvmKt.copyInto$default(elements, objArr, index, 0, 0, 12, (Object) null);
            this._size += elements.length;
            return true;
        }
        StringBuilder m8299s = ye0.m8299s(index, "Index ", " must be in 0..");
        m8299s.append(this._size);
        throw new IndexOutOfBoundsException(m8299s.toString());
    }

    @Override // androidx.collection.ObjectList
    @NotNull
    public List<E> asList() {
        return asMutableList();
    }

    @NotNull
    public final List<E> asMutableList() {
        uq1 uq1Var = this.f1722a;
        if (uq1Var == null) {
            uq1 uq1Var2 = new uq1(this);
            this.f1722a = uq1Var2;
            return uq1Var2;
        }
        return uq1Var;
    }

    public final void clear() {
        ArraysKt___ArraysJvmKt.fill(this.content, (Object) null, 0, this._size);
        this._size = 0;
    }

    public final void ensureCapacity(int capacity) {
        Object[] objArr = this.content;
        if (objArr.length < capacity) {
            Object[] copyOf = Arrays.copyOf(objArr, Math.max(capacity, (objArr.length * 3) / 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(E element) {
        remove(element);
    }

    public final void plusAssign(@NotNull ObjectList<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return;
        }
        ensureCapacity(this._size + elements._size);
        ArraysKt___ArraysJvmKt.copyInto(elements.content, this.content, this._size, 0, elements._size);
        this._size += elements._size;
    }

    public final boolean remove(E element) {
        int indexOf = indexOf(element);
        if (indexOf >= 0) {
            removeAt(indexOf);
            return true;
        }
        return false;
    }

    public final boolean removeAll(@NotNull E[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        for (E e : elements) {
            remove(e);
        }
        return i != this._size;
    }

    public final E removeAt(@IntRange(from = 0) int index) {
        int i;
        if (index >= 0 && index < (i = this._size)) {
            Object[] objArr = this.content;
            E e = (E) objArr[index];
            if (index != i - 1) {
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, index, index + 1, i);
            }
            int i2 = this._size - 1;
            this._size = i2;
            objArr[i2] = null;
            return e;
        }
        StringBuilder m8299s = ye0.m8299s(index, "Index ", " must be in 0..");
        m8299s.append(this._size - 1);
        throw new IndexOutOfBoundsException(m8299s.toString());
    }

    public final void removeIf(@NotNull Function1<? super E, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = this._size;
        Object[] objArr = this.content;
        int i2 = 0;
        kotlin.ranges.IntRange until = r82.until(0, i);
        int first = until.getFirst();
        int last = until.getLast();
        if (first <= last) {
            while (true) {
                objArr[first - i2] = objArr[first];
                if (predicate.invoke(objArr[first]).booleanValue()) {
                    i2++;
                }
                if (first == last) {
                    break;
                } else {
                    first++;
                }
            }
        }
        ArraysKt___ArraysJvmKt.fill(objArr, (Object) null, i - i2, i);
        this._size -= i2;
    }

    public final void removeRange(@IntRange(from = 0) int start, @IntRange(from = 0) int end) {
        int i;
        if (start >= 0 && start <= (i = this._size) && end >= 0 && end <= i) {
            if (end >= start) {
                if (end != start) {
                    if (end < i) {
                        Object[] objArr = this.content;
                        ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, start, end, i);
                    }
                    int i2 = this._size;
                    int i3 = i2 - (end - start);
                    ArraysKt___ArraysJvmKt.fill(this.content, (Object) null, i3, i2);
                    this._size = i3;
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Start (" + start + ") is more than end (" + end + ')');
        }
        StringBuilder m8302v = ye0.m8302v("Start (", start, ") and end (", end, ") must be in 0..");
        m8302v.append(this._size);
        throw new IndexOutOfBoundsException(m8302v.toString());
    }

    public final boolean retainAll(@NotNull E[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        Object[] objArr = this.content;
        for (int i2 = i - 1; -1 < i2; i2--) {
            if (ArraysKt___ArraysKt.indexOf(elements, objArr[i2]) < 0) {
                removeAt(i2);
            }
        }
        return i != this._size;
    }

    public final E set(@IntRange(from = 0) int index, E element) {
        if (index >= 0 && index < this._size) {
            Object[] objArr = this.content;
            E e = (E) objArr[index];
            objArr[index] = element;
            return e;
        }
        StringBuilder m8299s = ye0.m8299s(index, "set index ", " must be between 0 .. ");
        m8299s.append(this._size - 1);
        throw new IndexOutOfBoundsException(m8299s.toString());
    }

    public final void trim(int minCapacity) {
        int max = Math.max(minCapacity, this._size);
        Object[] objArr = this.content;
        if (objArr.length > max) {
            Object[] copyOf = Arrays.copyOf(objArr, max);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public /* synthetic */ MutableObjectList(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 16 : i);
    }

    public final void minusAssign(@NotNull List<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int size = elements.size();
        for (int i = 0; i < size; i++) {
            remove(elements.get(i));
        }
    }

    public MutableObjectList(int i) {
        super(i, null);
    }

    public final void add(@IntRange(from = 0) int index, E element) {
        int i;
        if (index >= 0 && index <= (i = this._size)) {
            ensureCapacity(i + 1);
            Object[] objArr = this.content;
            int i2 = this._size;
            if (index != i2) {
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, index + 1, index, i2);
            }
            objArr[index] = element;
            this._size++;
            return;
        }
        StringBuilder m8299s = ye0.m8299s(index, "Index ", " must be in 0..");
        m8299s.append(this._size);
        throw new IndexOutOfBoundsException(m8299s.toString());
    }

    public final void minusAssign(@NotNull E[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        for (E e : elements) {
            remove(e);
        }
    }

    public final boolean removeAll(@NotNull ObjectList<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        minusAssign((ObjectList) elements);
        return i != this._size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(@NotNull ObjectList<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = elements.content;
        int i = elements._size;
        for (int i2 = 0; i2 < i; i2++) {
            remove(objArr[i2]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean retainAll(@NotNull ObjectList<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        Object[] objArr = this.content;
        for (int i2 = i - 1; -1 < i2; i2--) {
            if (!elements.contains(objArr[i2])) {
                removeAt(i2);
            }
        }
        return i != this._size;
    }

    public final boolean removeAll(@NotNull ScatterSet<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        minusAssign((ScatterSet) elements);
        return i != this._size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(@NotNull ScatterSet<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return;
        }
        ensureCapacity(elements.get_size() + this._size);
        Object[] objArr = elements.elements;
        long[] jArr = elements.metadata;
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
                        add(objArr[(i << 3) + i3]);
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(@NotNull ScatterSet<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = elements.elements;
        long[] jArr = elements.metadata;
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

    public final boolean removeAll(@NotNull List<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        minusAssign((List) elements);
        return i != this._size;
    }

    public final boolean retainAll(@NotNull Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        Object[] objArr = this.content;
        for (int i2 = i - 1; -1 < i2; i2--) {
            if (!elements.contains(objArr[i2])) {
                removeAt(i2);
            }
        }
        return i != this._size;
    }

    public final boolean removeAll(@NotNull Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        minusAssign((Iterable) elements);
        return i != this._size;
    }

    public final boolean addAll(@IntRange(from = 0) int index, @NotNull Collection<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (index >= 0 && index <= this._size) {
            int i = 0;
            if (elements.isEmpty()) {
                return false;
            }
            ensureCapacity(elements.size() + this._size);
            Object[] objArr = this.content;
            if (index != this._size) {
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, elements.size() + index, index, this._size);
            }
            for (Object obj : elements) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                objArr[i + index] = obj;
                i = i2;
            }
            this._size = elements.size() + this._size;
            return true;
        }
        StringBuilder m8299s = ye0.m8299s(index, "Index ", " must be in 0..");
        m8299s.append(this._size);
        throw new IndexOutOfBoundsException(m8299s.toString());
    }

    public final void minusAssign(@NotNull Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final void plusAssign(@NotNull E[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.length == 0) {
            return;
        }
        ensureCapacity(this._size + elements.length);
        ArraysKt___ArraysJvmKt.copyInto$default(elements, this.content, this._size, 0, 0, 12, (Object) null);
        this._size += elements.length;
    }

    public final boolean removeAll(@NotNull Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        minusAssign((Sequence) elements);
        return i != this._size;
    }

    public final void minusAssign(@NotNull Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final boolean retainAll(@NotNull Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        Object[] objArr = this.content;
        for (int i2 = i - 1; -1 < i2; i2--) {
            if (!CollectionsKt___CollectionsKt.contains(elements, objArr[i2])) {
                removeAt(i2);
            }
        }
        return i != this._size;
    }

    public final void plusAssign(@NotNull List<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return;
        }
        int i = this._size;
        ensureCapacity(elements.size() + i);
        Object[] objArr = this.content;
        int size = elements.size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2 + i] = elements.get(i2);
        }
        this._size = elements.size() + this._size;
    }

    public final boolean retainAll(@NotNull Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        Object[] objArr = this.content;
        for (int i2 = i - 1; -1 < i2; i2--) {
            if (!SequencesKt___SequencesKt.contains(elements, objArr[i2])) {
                removeAt(i2);
            }
        }
        return i != this._size;
    }

    public final void plusAssign(E element) {
        add(element);
    }

    public final void plusAssign(@NotNull Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public final void plusAssign(@NotNull Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public final boolean addAll(@IntRange(from = 0) int index, @NotNull ObjectList<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (index >= 0 && index <= this._size) {
            if (elements.isEmpty()) {
                return false;
            }
            ensureCapacity(this._size + elements._size);
            Object[] objArr = this.content;
            int i = this._size;
            if (index != i) {
                ArraysKt___ArraysJvmKt.copyInto(objArr, objArr, elements._size + index, index, i);
            }
            ArraysKt___ArraysJvmKt.copyInto(elements.content, objArr, index, 0, elements._size);
            this._size += elements._size;
            return true;
        }
        StringBuilder m8299s = ye0.m8299s(index, "Index ", " must be in 0..");
        m8299s.append(this._size);
        throw new IndexOutOfBoundsException(m8299s.toString());
    }

    public final boolean addAll(@NotNull ObjectList<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        plusAssign((ObjectList) elements);
        return i != this._size;
    }

    public final boolean addAll(@NotNull ScatterSet<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        plusAssign((ScatterSet) elements);
        return i != this._size;
    }

    public final boolean addAll(@NotNull E[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        plusAssign((Object[]) elements);
        return i != this._size;
    }

    public final boolean addAll(@NotNull List<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        plusAssign((List) elements);
        return i != this._size;
    }

    public final boolean addAll(@NotNull Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        plusAssign((Iterable) elements);
        return i != this._size;
    }

    public final boolean addAll(@NotNull Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = this._size;
        plusAssign((Sequence) elements);
        return i != this._size;
    }
}
