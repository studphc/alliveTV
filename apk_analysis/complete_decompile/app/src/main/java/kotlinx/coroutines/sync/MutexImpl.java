package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectInstanceInternal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1762ri;
import p000.b51;
import p000.br1;
import p000.cr1;
import p000.dr1;
import p000.er1;

@Metadata(m5568d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002:\u0002$%B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u0019\u0010\u000f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0013\u001a\u00020\u000b2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR(\u0010 \u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00020\u001b8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0013\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070#8\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, m5569d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/Mutex;", "", "locked", "<init>", "(Z)V", "", "owner", "holdsLock", "(Ljava/lang/Object;)Z", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryLock", "unlock", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "onLockRegFunction", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "result", "onLockProcessResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock$annotations", "()V", "onLock", "isLocked", "()Z", "Lkotlinx/atomicfu/AtomicRef;", "br1", "cr1", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,310:1\n332#2,12:311\n1#3:323\n*S KotlinDebug\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexImpl\n*L\n175#1:311,12\n*E\n"})
/* loaded from: classes2.dex */
public class MutexImpl extends SemaphoreImpl implements Mutex {

    /* renamed from: i */
    public static final AtomicReferenceFieldUpdater f22113i = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "owner");

    /* renamed from: h */
    public final C1762ri f22114h;

    @Volatile
    @Nullable
    private volatile Object owner;

    public MutexImpl(boolean z) {
        super(1, z ? 1 : 0);
        Symbol symbol;
        if (!z) {
            symbol = MutexKt.f22115a;
        } else {
            symbol = null;
        }
        this.owner = symbol;
        this.f22114h = new C1762ri(1, this);
    }

    public static /* synthetic */ void getOnLock$annotations() {
    }

    /* renamed from: c */
    public final Object m5750c(Object obj, Continuation continuation) {
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        try {
            acquire((CancellableContinuation<? super Unit>) new br1(this, orCreateCancellableContinuation, obj));
            Object result = orCreateCancellableContinuation.getResult();
            if (result == b51.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            if (result == b51.getCOROUTINE_SUSPENDED()) {
                return result;
            }
            return Unit.INSTANCE;
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.sync.Mutex
    @NotNull
    public SelectClause2<Object, Mutex> getOnLock() {
        dr1 dr1Var = dr1.f16510h;
        Intrinsics.checkNotNull(dr1Var, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(dr1Var, 3);
        er1 er1Var = er1.f16957h;
        Intrinsics.checkNotNull(er1Var, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause2Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(er1Var, 3), this.f22114h);
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean holdsLock(@NotNull Object owner) {
        char c;
        Symbol symbol;
        while (true) {
            if (!isLocked()) {
                c = 0;
                break;
            }
            Object obj = f22113i.get(this);
            symbol = MutexKt.f22115a;
            if (obj != symbol) {
                if (obj == owner) {
                    c = 1;
                } else {
                    c = 2;
                }
            }
        }
        if (c == 1) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean isLocked() {
        if (getAvailablePermits() == 0) {
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    @Nullable
    public Object lock(@Nullable Object obj, @NotNull Continuation<? super Unit> continuation) {
        if (tryLock(obj)) {
            return Unit.INSTANCE;
        }
        Object m5750c = m5750c(obj, continuation);
        if (m5750c != b51.getCOROUTINE_SUSPENDED()) {
            return Unit.INSTANCE;
        }
        return m5750c;
    }

    @Nullable
    public Object onLockProcessResult(@Nullable Object owner, @Nullable Object result) {
        Symbol symbol;
        symbol = MutexKt.f22116b;
        if (!Intrinsics.areEqual(result, symbol)) {
            return this;
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + owner).toString());
    }

    public void onLockRegFunction(@NotNull SelectInstance<?> select, @Nullable Object owner) {
        Symbol symbol;
        if (owner != null && holdsLock(owner)) {
            symbol = MutexKt.f22116b;
            select.selectInRegistrationPhase(symbol);
        } else {
            Intrinsics.checkNotNull(select, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectInstanceInternal<*>");
            onAcquireRegFunction(new cr1(this, (SelectInstanceInternal) select, owner), owner);
        }
    }

    @NotNull
    public String toString() {
        return "Mutex@" + DebugStringsKt.getHexAddress(this) + "[isLocked=" + isLocked() + ",owner=" + f22113i.get(this) + ']';
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean tryLock(@Nullable Object owner) {
        char c;
        char c2;
        Symbol symbol;
        do {
            boolean tryAcquire = tryAcquire();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22113i;
            if (tryAcquire) {
                atomicReferenceFieldUpdater.set(this, owner);
                c = 0;
                break;
            }
            if (owner == null) {
                break;
            }
            while (true) {
                if (!isLocked()) {
                    c2 = 0;
                    break;
                }
                Object obj = atomicReferenceFieldUpdater.get(this);
                symbol = MutexKt.f22115a;
                if (obj != symbol) {
                    if (obj == owner) {
                        c2 = 1;
                    } else {
                        c2 = 2;
                    }
                }
            }
            if (c2 == 1) {
                c = 2;
                break;
            }
        } while (c2 != 2);
        c = 1;
        if (c == 0) {
            return true;
        }
        if (c == 1) {
            return false;
        }
        if (c != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + owner).toString());
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public void unlock(@Nullable Object owner) {
        Symbol symbol;
        Symbol symbol2;
        while (isLocked()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f22113i;
            Object obj = atomicReferenceFieldUpdater.get(this);
            symbol = MutexKt.f22115a;
            if (obj != symbol) {
                if (obj == owner || owner == null) {
                    symbol2 = MutexKt.f22115a;
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, symbol2)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    release();
                    return;
                }
                throw new IllegalStateException(("This mutex is locked by " + obj + ", but " + owner + " is expected").toString());
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }
}
