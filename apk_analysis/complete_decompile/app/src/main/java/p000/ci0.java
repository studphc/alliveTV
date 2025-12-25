package p000;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes2.dex */
public final class ci0 implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ Ref.ObjectRef f8370a;

    /* renamed from: b */
    public final /* synthetic */ CoroutineScope f8371b;

    /* renamed from: c */
    public final /* synthetic */ CompletableDeferred f8372c;

    public ci0(Ref.ObjectRef objectRef, CoroutineScope coroutineScope, CompletableDeferred completableDeferred) {
        this.f8370a = objectRef;
        this.f8371b = coroutineScope;
        this.f8372c = completableDeferred;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, kotlinx.coroutines.flow.MutableStateFlow] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        Unit unit;
        Ref.ObjectRef objectRef = this.f8370a;
        MutableStateFlow mutableStateFlow = (MutableStateFlow) objectRef.element;
        if (mutableStateFlow != null) {
            mutableStateFlow.setValue(obj);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            ?? MutableStateFlow = StateFlowKt.MutableStateFlow(obj);
            this.f8372c.complete(new b92(MutableStateFlow, JobKt.getJob(this.f8371b.getCoroutineContext())));
            objectRef.element = MutableStateFlow;
        }
        return Unit.INSTANCE;
    }
}
