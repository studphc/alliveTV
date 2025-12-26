package p000;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes2.dex */
public final class jg0 extends SuspendLambda implements Function3 {

    /* renamed from: e */
    public long f20491e;

    /* renamed from: f */
    public int f20492f;

    /* renamed from: g */
    public /* synthetic */ Object f20493g;

    /* renamed from: h */
    public /* synthetic */ Object f20494h;

    /* renamed from: i */
    public final /* synthetic */ long f20495i;

    /* renamed from: j */
    public final /* synthetic */ Flow f20496j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jg0(long j, Flow flow, Continuation continuation) {
        super(3, continuation);
        this.f20495i = j;
        this.f20496j = flow;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        jg0 jg0Var = new jg0(this.f20495i, this.f20496j, (Continuation) obj3);
        jg0Var.f20493g = (CoroutineScope) obj;
        jg0Var.f20494h = (FlowCollector) obj2;
        return jg0Var.invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:11:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0075 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0073 -> B:5:0x0076). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = p000.b51.getCOROUTINE_SUSPENDED()
            int r1 = r9.f20492f
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L22
            if (r1 != r2) goto L1a
            long r4 = r9.f20491e
            java.lang.Object r1 = r9.f20494h
            kotlinx.coroutines.channels.ReceiveChannel r1 = (kotlinx.coroutines.channels.ReceiveChannel) r1
            java.lang.Object r6 = r9.f20493g
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            kotlin.ResultKt.throwOnFailure(r10)
            goto L76
        L1a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L22:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.f20493g
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            java.lang.Object r1 = r9.f20494h
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.time.Duration$Companion r4 = kotlin.time.Duration.INSTANCE
            long r4 = r4.m8795getZEROUwyO8pc()
            long r6 = r9.f20495i
            int r4 = kotlin.time.Duration.m8718compareToLRDsOJo(r6, r4)
            if (r4 <= 0) goto L81
            r4 = 2
            kotlinx.coroutines.flow.Flow r5 = r9.f20496j
            r8 = 0
            kotlinx.coroutines.flow.Flow r4 = kotlinx.coroutines.flow.FlowKt.buffer$default(r5, r8, r3, r4, r3)
            kotlinx.coroutines.channels.ReceiveChannel r10 = kotlinx.coroutines.flow.FlowKt.produceIn(r4, r10)
            r4 = r6
            r6 = r1
            r1 = r10
        L4a:
            kotlinx.coroutines.selects.SelectImplementation r10 = new kotlinx.coroutines.selects.SelectImplementation
            kotlin.coroutines.CoroutineContext r7 = r9.getContext()
            r10.<init>(r7)
            kotlinx.coroutines.selects.SelectClause1 r7 = r1.getOnReceiveCatching()
            hg0 r8 = new hg0
            r8.<init>(r6, r3)
            r10.invoke(r7, r8)
            ig0 r7 = new ig0
            r7.<init>(r4, r3)
            kotlinx.coroutines.selects.OnTimeoutKt.m8910onTimeout8Mi8wO0(r10, r4, r7)
            r9.f20493g = r6
            r9.f20494h = r1
            r9.f20491e = r4
            r9.f20492f = r2
            java.lang.Object r10 = r10.doSelect(r9)
            if (r10 != r0) goto L76
            return r0
        L76:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L4a
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L81:
            kotlinx.coroutines.TimeoutCancellationException r10 = new kotlinx.coroutines.TimeoutCancellationException
            java.lang.String r0 = "Timed out immediately"
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.jg0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
