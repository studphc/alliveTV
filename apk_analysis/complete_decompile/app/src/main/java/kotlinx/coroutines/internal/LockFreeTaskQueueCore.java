package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC0002a1;

@Metadata(m5568d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 $*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002$%B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015\"\u0004\b\u0001\u0010\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\nR\u0011\u0010\u0019\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\nR\u0011\u0010\u001c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR%\u0010\u001f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u001e0\u001d8\u0002X\u0082\u0004R\u000b\u0010!\u001a\u00020 8\u0002X\u0082\u0004R\u0013\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"8\u0002X\u0082\u0004¨\u0006&"}, m5569d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", ExifInterface.LONGITUDE_EAST, "", "capacity", "", "singleConsumer", "<init>", "(IZ)V", "close", "()Z", "element", "addLast", "(Ljava/lang/Object;)I", "removeFirstOrNull", "()Ljava/lang/Object;", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "isClosed", "isEmpty", "getSize", "()I", "size", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/Core;", "_next", "Lkotlinx/atomicfu/AtomicLong;", "_state", "Lkotlinx/atomicfu/AtomicArray;", "array", "Companion", "Placeholder", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nLockFreeTaskQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore\n+ 2 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,308:1\n299#2,3:309\n299#2,3:312\n299#2,3:315\n299#2,3:318\n299#2,3:321\n299#2,3:325\n299#2,3:328\n1#3:324\n*S KotlinDebug\n*F\n+ 1 LockFreeTaskQueue.kt\nkotlinx/coroutines/internal/LockFreeTaskQueueCore\n*L\n91#1:309,3\n92#1:312,3\n107#1:315,3\n167#1:318,3\n200#1:321,3\n231#1:325,3\n247#1:328,3\n*E\n"})
/* loaded from: classes2.dex */
public final class LockFreeTaskQueueCore<E> {
    public static final int ADD_CLOSED = 2;
    public static final int ADD_FROZEN = 1;
    public static final int ADD_SUCCESS = 0;
    public static final int CAPACITY_BITS = 30;
    public static final long CLOSED_MASK = 2305843009213693952L;
    public static final int CLOSED_SHIFT = 61;
    public static final long FROZEN_MASK = 1152921504606846976L;
    public static final int FROZEN_SHIFT = 60;
    public static final long HEAD_MASK = 1073741823;
    public static final int HEAD_SHIFT = 0;
    public static final int INITIAL_CAPACITY = 8;
    public static final int MAX_CAPACITY_MASK = 1073741823;
    public static final int MIN_ADD_SPIN_CAPACITY = 1024;
    public static final long TAIL_MASK = 1152921503533105152L;
    public static final int TAIL_SHIFT = 30;

    @Volatile
    @Nullable
    private volatile Object _next;

    @Volatile
    private volatile long _state;

    /* renamed from: a */
    public final int f22030a;

    /* renamed from: b */
    public final boolean f22031b;

    /* renamed from: c */
    public final int f22032c;

    /* renamed from: d */
    public final AtomicReferenceArray f22033d;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e */
    public static final AtomicReferenceFieldUpdater f22028e = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next");

    /* renamed from: f */
    public static final AtomicLongFieldUpdater f22029f = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state");

    @JvmField
    @NotNull
    public static final Symbol REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");

    @Metadata(m5568d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001J\u001c\u0010\u0004\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0004¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\tJR\u0010\u0013\u001a\u00028\u0001\"\u0004\b\u0001\u0010\f*\u00020\u000226\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00028\u00010\rH\u0086\b¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\u0006*\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u0018R\u0014\u0010!\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\u001dR\u0014\u0010\"\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\u0018R\u0014\u0010#\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\u0018R\u0014\u0010$\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\u0018R\u0014\u0010%\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\u0018R\u0014\u0010'\u001a\u00020&8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010\u001dR\u0014\u0010*\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010\u0018¨\u0006+"}, m5569d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "", "other", "wo", "(JJ)J", "", "newHead", "updateHead", "(JI)J", "newTail", "updateTail", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "head", "tail", "block", "withState", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "addFailReason", "(J)I", "ADD_CLOSED", "I", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "J", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "Lkotlinx/coroutines/internal/Symbol;", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final int addFailReason(long j) {
            return (j & LockFreeTaskQueueCore.CLOSED_MASK) != 0 ? 2 : 1;
        }

        public final long updateHead(long j, int i) {
            return m5733wo(j, LockFreeTaskQueueCore.HEAD_MASK) | i;
        }

        public final long updateTail(long j, int i) {
            return m5733wo(j, LockFreeTaskQueueCore.TAIL_MASK) | (i << 30);
        }

        public final <T> T withState(long j, @NotNull Function2<? super Integer, ? super Integer, ? extends T> function2) {
            return function2.invoke(Integer.valueOf((int) (LockFreeTaskQueueCore.HEAD_MASK & j)), Integer.valueOf((int) ((j & LockFreeTaskQueueCore.TAIL_MASK) >> 30)));
        }

        /* renamed from: wo */
        public final long m5733wo(long j, long j2) {
            return j & (~j2);
        }
    }

    @Metadata(m5568d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m5569d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", FirebaseAnalytics.Param.INDEX, "", "(I)V", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class Placeholder {

        @JvmField
        public final int index;

        public Placeholder(int i) {
            this.index = i;
        }
    }

    public LockFreeTaskQueueCore(int i, boolean z) {
        this.f22030a = i;
        this.f22031b = z;
        int i2 = i - 1;
        this.f22032c = i2;
        this.f22033d = new AtomicReferenceArray(i);
        if (i2 <= 1073741823) {
            if ((i & i2) == 0) {
                return;
            } else {
                throw new IllegalStateException("Check failed.");
            }
        }
        throw new IllegalStateException("Check failed.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x004e, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int addLast(@NotNull E element) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f22029f;
            long j = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j) != 0) {
                return INSTANCE.addFailReason(j);
            }
            int i = (int) (HEAD_MASK & j);
            int i2 = (int) ((TAIL_MASK & j) >> 30);
            int i3 = this.f22032c;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            boolean z = this.f22031b;
            AtomicReferenceArray atomicReferenceArray = this.f22033d;
            if (!z && atomicReferenceArray.get(i2 & i3) != null) {
                int i4 = this.f22030a;
                if (i4 < 1024 || ((i2 - i) & MAX_CAPACITY_MASK) > (i4 >> 1)) {
                    break;
                }
            } else {
                if (f22029f.compareAndSet(this, j, INSTANCE.updateTail(j, (i2 + 1) & MAX_CAPACITY_MASK))) {
                    atomicReferenceArray.set(i2 & i3, element);
                    LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
                    while ((atomicLongFieldUpdater.get(lockFreeTaskQueueCore) & FROZEN_MASK) != 0) {
                        lockFreeTaskQueueCore = lockFreeTaskQueueCore.next();
                        AtomicReferenceArray atomicReferenceArray2 = lockFreeTaskQueueCore.f22033d;
                        int i5 = lockFreeTaskQueueCore.f22032c & i2;
                        Object obj = atomicReferenceArray2.get(i5);
                        if ((obj instanceof Placeholder) && ((Placeholder) obj).index == i2) {
                            atomicReferenceArray2.set(i5, element);
                        } else {
                            lockFreeTaskQueueCore = null;
                        }
                        if (lockFreeTaskQueueCore == null) {
                            return 0;
                        }
                    }
                    return 0;
                }
            }
        }
    }

    public final boolean close() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j;
        do {
            atomicLongFieldUpdater = f22029f;
            j = atomicLongFieldUpdater.get(this);
            if ((j & CLOSED_MASK) != 0) {
                return true;
            }
            if ((FROZEN_MASK & j) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, CLOSED_MASK | j));
        return true;
    }

    public final int getSize() {
        long j = f22029f.get(this);
        return (((int) ((j & TAIL_MASK) >> 30)) - ((int) (HEAD_MASK & j))) & MAX_CAPACITY_MASK;
    }

    public final boolean isClosed() {
        if ((f22029f.get(this) & CLOSED_MASK) != 0) {
            return true;
        }
        return false;
    }

    public final boolean isEmpty() {
        long j = f22029f.get(this);
        if (((int) (HEAD_MASK & j)) == ((int) ((j & TAIL_MASK) >> 30))) {
            return true;
        }
        return false;
    }

    @NotNull
    public final <R> List<R> map(@NotNull Function1<? super E, ? extends R> transform) {
        ArrayList arrayList = new ArrayList(this.f22030a);
        long j = f22029f.get(this);
        int i = (int) (HEAD_MASK & j);
        int i2 = (int) ((j & TAIL_MASK) >> 30);
        while (true) {
            int i3 = this.f22032c;
            if ((i & i3) != (i2 & i3)) {
                AbstractC0002a1 abstractC0002a1 = (Object) this.f22033d.get(i3 & i);
                if (abstractC0002a1 != null && !(abstractC0002a1 instanceof Placeholder)) {
                    arrayList.add(transform.invoke(abstractC0002a1));
                }
                i++;
            } else {
                return arrayList;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final LockFreeTaskQueueCore<E> next() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j;
        while (true) {
            atomicLongFieldUpdater = f22029f;
            j = atomicLongFieldUpdater.get(this);
            if ((j & FROZEN_MASK) != 0) {
                break;
            }
            long j2 = j | FROZEN_MASK;
            if (atomicLongFieldUpdater.compareAndSet(this, j, j2)) {
                j = j2;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22028e;
            LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            if (lockFreeTaskQueueCore != null) {
                return lockFreeTaskQueueCore;
            }
            LockFreeTaskQueueCore lockFreeTaskQueueCore2 = new LockFreeTaskQueueCore(this.f22030a * 2, this.f22031b);
            int i = (int) (HEAD_MASK & j);
            int i2 = (int) ((TAIL_MASK & j) >> 30);
            while (true) {
                int i3 = this.f22032c;
                int i4 = i & i3;
                if (i4 == (i3 & i2)) {
                    break;
                }
                Object obj = this.f22033d.get(i4);
                if (obj == null) {
                    obj = new Placeholder(i);
                }
                lockFreeTaskQueueCore2.f22033d.set(lockFreeTaskQueueCore2.f22032c & i, obj);
                i++;
            }
            atomicLongFieldUpdater.set(lockFreeTaskQueueCore2, INSTANCE.m5733wo(j, FROZEN_MASK));
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, lockFreeTaskQueueCore2) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    @Nullable
    public final Object removeFirstOrNull() {
        int i;
        while (true) {
            long j = f22029f.get(this);
            if ((j & FROZEN_MASK) != 0) {
                return REMOVE_FROZEN;
            }
            int i2 = (int) (j & HEAD_MASK);
            int i3 = (int) ((TAIL_MASK & j) >> 30);
            int i4 = this.f22032c;
            if ((i3 & i4) == (i2 & i4)) {
                return null;
            }
            AtomicReferenceArray atomicReferenceArray = this.f22033d;
            Object obj = atomicReferenceArray.get(i2 & i4);
            boolean z = this.f22031b;
            if (obj == null) {
                if (z) {
                    return null;
                }
            } else {
                if (obj instanceof Placeholder) {
                    return null;
                }
                int i5 = (i2 + 1) & MAX_CAPACITY_MASK;
                int i6 = i5;
                if (f22029f.compareAndSet(this, j, INSTANCE.updateHead(j, i5))) {
                    atomicReferenceArray.set(i2 & i4, null);
                    return obj;
                }
                if (z) {
                    LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
                    while (true) {
                        AtomicLongFieldUpdater atomicLongFieldUpdater = f22029f;
                        long j2 = atomicLongFieldUpdater.get(lockFreeTaskQueueCore);
                        int i7 = (int) (j2 & HEAD_MASK);
                        if ((j2 & FROZEN_MASK) != 0) {
                            lockFreeTaskQueueCore = lockFreeTaskQueueCore.next();
                            i = i6;
                        } else {
                            i = i6;
                            if (atomicLongFieldUpdater.compareAndSet(lockFreeTaskQueueCore, j2, INSTANCE.updateHead(j2, i))) {
                                lockFreeTaskQueueCore.f22033d.set(lockFreeTaskQueueCore.f22032c & i7, null);
                                lockFreeTaskQueueCore = null;
                            } else {
                                continue;
                                i6 = i;
                            }
                        }
                        if (lockFreeTaskQueueCore == null) {
                            return obj;
                        }
                        i6 = i;
                    }
                }
            }
        }
    }
}
