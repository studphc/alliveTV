package p000;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class qf0 implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ Ref.IntRef f25568a;

    public qf0(Ref.IntRef intRef) {
        this.f25568a = intRef;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        this.f25568a.element++;
        return Unit.INSTANCE;
    }
}
