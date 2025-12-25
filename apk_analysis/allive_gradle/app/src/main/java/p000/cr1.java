package p000;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.selects.SelectInstanceInternal;
import kotlinx.coroutines.sync.MutexImpl;

/* loaded from: classes2.dex */
public final class cr1 implements SelectInstanceInternal {

    /* renamed from: a */
    public final SelectInstanceInternal f16087a;

    /* renamed from: b */
    public final Object f16088b;

    /* renamed from: c */
    public final /* synthetic */ MutexImpl f16089c;

    public cr1(MutexImpl mutexImpl, SelectInstanceInternal selectInstanceInternal, Object obj) {
        this.f16089c = mutexImpl;
        this.f16087a = selectInstanceInternal;
        this.f16088b = obj;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final void disposeOnCompletion(DisposableHandle disposableHandle) {
        this.f16087a.disposeOnCompletion(disposableHandle);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final CoroutineContext getContext() {
        return this.f16087a.getContext();
    }

    @Override // kotlinx.coroutines.Waiter
    public final void invokeOnCancellation(Segment segment, int i) {
        this.f16087a.invokeOnCancellation(segment, i);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final void selectInRegistrationPhase(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        atomicReferenceFieldUpdater = MutexImpl.f22113i;
        atomicReferenceFieldUpdater.set(this.f16089c, this.f16088b);
        this.f16087a.selectInRegistrationPhase(obj);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public final boolean trySelect(Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        boolean trySelect = this.f16087a.trySelect(obj, obj2);
        if (trySelect) {
            atomicReferenceFieldUpdater = MutexImpl.f22113i;
            atomicReferenceFieldUpdater.set(this.f16089c, this.f16088b);
        }
        return trySelect;
    }
}
