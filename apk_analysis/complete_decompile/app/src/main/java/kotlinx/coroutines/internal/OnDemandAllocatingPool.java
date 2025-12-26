package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import p000.AbstractC1204fq;
import p000.AbstractC1726qj;
import p000.r82;

@Metadata(m5568d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0011R\u000b\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004R\u0013\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00168\u0002X\u0082\u0004¨\u0006\u0018"}, m5569d2 = {"Lkotlinx/coroutines/internal/OnDemandAllocatingPool;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "maxCapacity", "Lkotlin/Function1;", "create", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "", "allocate", "()Z", "", "close", "()Ljava/util/List;", "", "stateRepresentation$kotlinx_coroutines_core", "()Ljava/lang/String;", "stateRepresentation", "toString", "Lkotlinx/atomicfu/AtomicInt;", "controlState", "Lkotlinx/atomicfu/AtomicArray;", "elements", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nOnDemandAllocatingPool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnDemandAllocatingPool.kt\nkotlinx/coroutines/internal/OnDemandAllocatingPool\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 OnDemandAllocatingPool.kt\nkotlinx/coroutines/internal/OnDemandAllocatingPoolKt\n*L\n1#1,107:1\n41#1:108\n41#1:109\n35#1,7:110\n41#1:127\n1549#2:117\n1620#2,2:118\n1622#2:122\n1549#2:123\n1620#2,3:124\n101#3,2:120\n*S KotlinDebug\n*F\n+ 1 OnDemandAllocatingPool.kt\nkotlinx/coroutines/internal/OnDemandAllocatingPool\n*L\n35#1:108\n54#1:109\n76#1:110,7\n92#1:127\n77#1:117\n77#1:118,2\n77#1:122\n91#1:123\n91#1:124,3\n79#1:120,2\n*E\n"})
/* loaded from: classes2.dex */
public final class OnDemandAllocatingPool<T> {

    /* renamed from: d */
    public static final AtomicIntegerFieldUpdater f22034d = AtomicIntegerFieldUpdater.newUpdater(OnDemandAllocatingPool.class, "controlState");

    /* renamed from: a */
    public final int f22035a;

    /* renamed from: b */
    public final Function1 f22036b;

    /* renamed from: c */
    public final AtomicReferenceArray f22037c;

    @Volatile
    private volatile int controlState;

    public OnDemandAllocatingPool(int i, @NotNull Function1<? super Integer, ? extends T> function1) {
        this.f22035a = i;
        this.f22036b = function1;
        this.f22037c = new AtomicReferenceArray(i);
    }

    public final boolean allocate() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        do {
            atomicIntegerFieldUpdater = f22034d;
            i = atomicIntegerFieldUpdater.get(this);
            if ((Integer.MIN_VALUE & i) != 0) {
                return false;
            }
            if (i >= this.f22035a) {
                return true;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, i + 1));
        this.f22037c.set(i, this.f22036b.invoke(Integer.valueOf(i)));
        return true;
    }

    @NotNull
    public final List<T> close() {
        int i;
        Object andSet;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f22034d;
            i = atomicIntegerFieldUpdater.get(this);
            if ((i & Integer.MIN_VALUE) != 0) {
                i = 0;
                break;
            }
            if (atomicIntegerFieldUpdater.compareAndSet(this, i, Integer.MIN_VALUE | i)) {
                break;
            }
        }
        IntRange until = r82.until(0, i);
        ArrayList arrayList = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            do {
                andSet = this.f22037c.getAndSet(nextInt, null);
            } while (andSet == null);
            arrayList.add(andSet);
        }
        return arrayList;
    }

    @NotNull
    public final String stateRepresentation$kotlinx_coroutines_core() {
        String str;
        int i = f22034d.get(this);
        IntRange until = r82.until(0, Integer.MAX_VALUE & i);
        ArrayList arrayList = new ArrayList(AbstractC1204fq.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f22037c.get(((IntIterator) it).nextInt()));
        }
        String obj = arrayList.toString();
        if ((i & Integer.MIN_VALUE) != 0) {
            str = "[closed]";
        } else {
            str = "";
        }
        return AbstractC1726qj.m7057m(obj, str);
    }

    @NotNull
    public String toString() {
        return "OnDemandAllocatingPool(" + stateRepresentation$kotlinx_coroutines_core() + ')';
    }
}
