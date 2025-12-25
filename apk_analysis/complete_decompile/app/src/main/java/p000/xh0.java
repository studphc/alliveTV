package p000;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* loaded from: classes2.dex */
public final class xh0 implements FlowCollector {

    /* renamed from: a */
    public final /* synthetic */ Ref.ObjectRef f28558a;

    public xh0(Ref.ObjectRef objectRef) {
        this.f28558a = objectRef;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object obj, Continuation continuation) {
        Ref.ObjectRef objectRef = this.f28558a;
        if (objectRef.element == NullSurrogateKt.NULL) {
            objectRef.element = obj;
            return Unit.INSTANCE;
        }
        throw new IllegalArgumentException("Flow has more than one element");
    }
}
