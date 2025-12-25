package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.fq2;

@Metadata(m5568d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00060\u0003j\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00028\u0000H$¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000b2\u0006\u0010\n\u001a\u00020\tH$¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0011\u0010\u0012J$\u0010\u0015\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100\u0013H\u0084\b¢\u0006\u0004\b\u0015\u0010\u0016R8\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000b2\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000b8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010!\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006&"}, m5569d2 = {"Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", ExifInterface.LATITUDE_SOUTH, "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "<init>", "()V", "createSlot", "()Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "", "size", "", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "allocateSlot", "slot", "", "freeSlot", "(Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;)V", "Lkotlin/Function1;", "block", "forEachSlotLocked", "(Lkotlin/jvm/functions/Function1;)V", "<set-?>", "a", "[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "getSlots", "()[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "slots", "b", "I", "getNCollectors", "()I", "nCollectors", "Lkotlinx/coroutines/flow/StateFlow;", "getSubscriptionCount", "()Lkotlinx/coroutines/flow/StateFlow;", "subscriptionCount", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nAbstractSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,132:1\n28#2,4:133\n28#2,4:138\n28#2,4:144\n20#3:137\n20#3:142\n20#3:148\n1#4:143\n13579#5,2:149\n*S KotlinDebug\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n*L\n30#1:133,4\n45#1:138,4\n76#1:144,4\n30#1:137\n45#1:142\n76#1:148\n95#1:149,2\n*E\n"})
/* loaded from: classes2.dex */
public abstract class AbstractSharedFlow<S extends AbstractSharedFlowSlot<?>> {

    /* renamed from: a, reason: from kotlin metadata */
    public AbstractSharedFlowSlot[] slots;

    /* renamed from: b, reason: from kotlin metadata */
    public int nCollectors;

    /* renamed from: c */
    public int f21980c;

    /* renamed from: d */
    public fq2 f21981d;

    public static final /* synthetic */ int access$getNCollectors(AbstractSharedFlow abstractSharedFlow) {
        return abstractSharedFlow.nCollectors;
    }

    public static final /* synthetic */ AbstractSharedFlowSlot[] access$getSlots(AbstractSharedFlow abstractSharedFlow) {
        return abstractSharedFlow.slots;
    }

    @NotNull
    public final S allocateSlot() {
        S s;
        fq2 fq2Var;
        synchronized (this) {
            try {
                S[] sArr = (S[]) this.slots;
                if (sArr == null) {
                    sArr = createSlotArray(2);
                    this.slots = sArr;
                } else if (this.nCollectors >= sArr.length) {
                    Object[] copyOf = Arrays.copyOf(sArr, sArr.length * 2);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                    this.slots = (AbstractSharedFlowSlot[]) copyOf;
                    sArr = (S[]) ((AbstractSharedFlowSlot[]) copyOf);
                }
                int i = this.f21980c;
                do {
                    s = sArr[i];
                    if (s == null) {
                        s = createSlot();
                        sArr[i] = s;
                    }
                    i++;
                    if (i >= sArr.length) {
                        i = 0;
                    }
                    Intrinsics.checkNotNull(s, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!s.allocateLocked(this));
                this.f21980c = i;
                this.nCollectors++;
                fq2Var = this.f21981d;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (fq2Var != null) {
            fq2Var.m4827n(1);
        }
        return s;
    }

    @NotNull
    public abstract S createSlot();

    @NotNull
    public abstract S[] createSlotArray(int size);

    public final void forEachSlotLocked(@NotNull Function1<? super S, Unit> block) {
        AbstractSharedFlowSlot[] abstractSharedFlowSlotArr;
        if (this.nCollectors != 0 && (abstractSharedFlowSlotArr = this.slots) != null) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : abstractSharedFlowSlotArr) {
                if (abstractSharedFlowSlot != null) {
                    block.invoke(abstractSharedFlowSlot);
                }
            }
        }
    }

    public final void freeSlot(@NotNull S slot) {
        fq2 fq2Var;
        int i;
        Continuation<Unit>[] freeLocked;
        synchronized (this) {
            try {
                int i2 = this.nCollectors - 1;
                this.nCollectors = i2;
                fq2Var = this.f21981d;
                if (i2 == 0) {
                    this.f21980c = 0;
                }
                Intrinsics.checkNotNull(slot, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                freeLocked = slot.freeLocked(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation<Unit> continuation : freeLocked) {
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m8512constructorimpl(Unit.INSTANCE));
            }
        }
        if (fq2Var != null) {
            fq2Var.m4827n(-1);
        }
    }

    public final int getNCollectors() {
        return this.nCollectors;
    }

    @Nullable
    public final S[] getSlots() {
        return (S[]) this.slots;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [fq2, kotlinx.coroutines.flow.SharedFlowImpl] */
    @NotNull
    public final StateFlow<Integer> getSubscriptionCount() {
        fq2 fq2Var;
        synchronized (this) {
            fq2 fq2Var2 = this.f21981d;
            fq2Var = fq2Var2;
            if (fq2Var2 == null) {
                int i = this.nCollectors;
                ?? sharedFlowImpl = new SharedFlowImpl(1, Integer.MAX_VALUE, BufferOverflow.DROP_OLDEST);
                sharedFlowImpl.tryEmit(Integer.valueOf(i));
                this.f21981d = sharedFlowImpl;
                fq2Var = sharedFlowImpl;
            }
        }
        return fq2Var;
    }
}
