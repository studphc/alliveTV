package p000;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class sh0 implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ Ref.ObjectRef f26429a;

    public sh0(Ref.ObjectRef objectRef) {
        this.f26429a = objectRef;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        this.f26429a.element = obj;
        return Unit.INSTANCE;
    }
}
