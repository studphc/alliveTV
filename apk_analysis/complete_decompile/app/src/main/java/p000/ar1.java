package p000;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.sync.MutexImpl;

/* loaded from: classes2.dex */
public final class ar1 extends Lambda implements Function1 {

    /* renamed from: b */
    public final /* synthetic */ int f7724b;

    /* renamed from: c */
    public final /* synthetic */ MutexImpl f7725c;

    /* renamed from: d */
    public final /* synthetic */ br1 f7726d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ar1(MutexImpl mutexImpl, br1 br1Var, int i) {
        super(1);
        this.f7724b = i;
        this.f7725c = mutexImpl;
        this.f7726d = br1Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        switch (this.f7724b) {
            case 0:
                this.f7725c.unlock(this.f7726d.f8143b);
                return Unit.INSTANCE;
            default:
                atomicReferenceFieldUpdater = MutexImpl.f22113i;
                br1 br1Var = this.f7726d;
                Object obj2 = br1Var.f8143b;
                MutexImpl mutexImpl = this.f7725c;
                atomicReferenceFieldUpdater.set(mutexImpl, obj2);
                mutexImpl.unlock(br1Var.f8143b);
                return Unit.INSTANCE;
        }
    }
}
