package p000;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.OnTimeoutKt;
import kotlinx.coroutines.selects.SelectImplementation;

/* loaded from: classes2.dex */
public final class ag0 extends SuspendLambda implements Function3 {

    /* renamed from: e */
    public Ref.ObjectRef f173e;

    /* renamed from: f */
    public Ref.LongRef f174f;

    /* renamed from: g */
    public int f175g;

    /* renamed from: h */
    public /* synthetic */ Object f176h;

    /* renamed from: i */
    public /* synthetic */ Object f177i;

    /* renamed from: j */
    public final /* synthetic */ Function1 f178j;

    /* renamed from: k */
    public final /* synthetic */ Flow f179k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag0(Function1 function1, Flow flow, Continuation continuation) {
        super(3, continuation);
        this.f178j = function1;
        this.f179k = flow;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        ag0 ag0Var = new ag0(this.f178j, this.f179k, (Continuation) obj3);
        ag0Var.f176h = (CoroutineScope) obj;
        ag0Var.f177i = (FlowCollector) obj2;
        return ag0Var.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00dc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00da -> B:6:0x001c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef objectRef;
        FlowCollector flowCollector;
        ReceiveChannel receiveChannel;
        Ref.LongRef longRef;
        Ref.ObjectRef objectRef2;
        ReceiveChannel receiveChannel2;
        FlowCollector flowCollector2;
        SelectImplementation selectImplementation;
        Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
        int i = this.f175g;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    objectRef2 = this.f173e;
                    receiveChannel2 = (ReceiveChannel) this.f177i;
                    flowCollector2 = (FlowCollector) this.f176h;
                    ResultKt.throwOnFailure(obj);
                    flowCollector = flowCollector2;
                    receiveChannel = receiveChannel2;
                    objectRef = objectRef2;
                    if (objectRef.element == NullSurrogateKt.DONE) {
                        longRef = new Ref.LongRef();
                        Object obj2 = objectRef.element;
                        if (obj2 != null) {
                            Symbol symbol = NullSurrogateKt.NULL;
                            if (obj2 == symbol) {
                                obj2 = null;
                            }
                            long longValue = ((Number) this.f178j.invoke(obj2)).longValue();
                            longRef.element = longValue;
                            if (longValue >= 0) {
                                if (longValue == 0) {
                                    Object obj3 = objectRef.element;
                                    if (obj3 == symbol) {
                                        obj3 = null;
                                    }
                                    this.f176h = flowCollector;
                                    this.f177i = receiveChannel;
                                    this.f173e = objectRef;
                                    this.f174f = longRef;
                                    this.f175g = 1;
                                    if (flowCollector.emit(obj3, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    objectRef.element = null;
                                }
                            } else {
                                throw new IllegalArgumentException("Debounce timeout should not be negative");
                            }
                        }
                        Ref.LongRef longRef2 = longRef;
                        objectRef2 = objectRef;
                        receiveChannel2 = receiveChannel;
                        flowCollector2 = flowCollector;
                        selectImplementation = new SelectImplementation(getContext());
                        if (objectRef2.element != 0) {
                            OnTimeoutKt.onTimeout(selectImplementation, longRef2.element, new wf0(null, objectRef2, flowCollector2));
                        }
                        selectImplementation.invoke(receiveChannel2.getOnReceiveCatching(), new xf0(null, objectRef2, flowCollector2));
                        this.f176h = flowCollector2;
                        this.f177i = receiveChannel2;
                        this.f173e = objectRef2;
                        this.f174f = null;
                        this.f175g = 2;
                        if (selectImplementation.doSelect(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowCollector = flowCollector2;
                        receiveChannel = receiveChannel2;
                        objectRef = objectRef2;
                        if (objectRef.element == NullSurrogateKt.DONE) {
                            return Unit.INSTANCE;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                longRef = this.f174f;
                objectRef = this.f173e;
                receiveChannel = (ReceiveChannel) this.f177i;
                flowCollector = (FlowCollector) this.f176h;
                ResultKt.throwOnFailure(obj);
                objectRef.element = null;
                Ref.LongRef longRef22 = longRef;
                objectRef2 = objectRef;
                receiveChannel2 = receiveChannel;
                flowCollector2 = flowCollector;
                selectImplementation = new SelectImplementation(getContext());
                if (objectRef2.element != 0) {
                }
                selectImplementation.invoke(receiveChannel2.getOnReceiveCatching(), new xf0(null, objectRef2, flowCollector2));
                this.f176h = flowCollector2;
                this.f177i = receiveChannel2;
                this.f173e = objectRef2;
                this.f174f = null;
                this.f175g = 2;
                if (selectImplementation.doSelect(this) == coroutine_suspended) {
                }
                flowCollector = flowCollector2;
                receiveChannel = receiveChannel2;
                objectRef = objectRef2;
                if (objectRef.element == NullSurrogateKt.DONE) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f176h;
            FlowCollector flowCollector3 = (FlowCollector) this.f177i;
            ReceiveChannel produce$default = ProduceKt.produce$default(coroutineScope, null, 0, new zf0(this.f179k, null), 3, null);
            objectRef = new Ref.ObjectRef();
            flowCollector = flowCollector3;
            receiveChannel = produce$default;
            if (objectRef.element == NullSurrogateKt.DONE) {
            }
        }
    }
}
