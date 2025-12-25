package p000;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;

/* loaded from: classes2.dex */
public final class bg0 extends SuspendLambda implements Function2 {

    /* renamed from: e */
    public int f7999e;

    /* renamed from: f */
    public /* synthetic */ Object f8000f;

    /* renamed from: g */
    public final /* synthetic */ long f8001g;

    /* renamed from: h */
    public final /* synthetic */ long f8002h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg0(long j, long j2, Continuation continuation) {
        super(2, continuation);
        this.f8001g = j;
        this.f8002h = j2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        bg0 bg0Var = new bg0(this.f8001g, this.f8002h, continuation);
        bg0Var.f8000f = obj;
        return bg0Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((bg0) create((ProducerScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005c A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x005a -> B:12:0x003f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = p000.b51.getCOROUTINE_SUSPENDED()
            int r1 = r6.f7999e
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2a
            if (r1 == r4) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            goto L22
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            java.lang.Object r1 = r6.f8000f
            kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L50
        L22:
            java.lang.Object r1 = r6.f8000f
            kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L3f
        L2a:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.f8000f
            r1 = r7
            kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
            r6.f8000f = r1
            r6.f7999e = r4
            long r4 = r6.f8001g
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r6)
            if (r7 != r0) goto L3f
            return r0
        L3f:
            kotlinx.coroutines.channels.SendChannel r7 = r1.getChannel()
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            r6.f8000f = r1
            r6.f7999e = r3
            java.lang.Object r7 = r7.send(r4, r6)
            if (r7 != r0) goto L50
            return r0
        L50:
            r6.f8000f = r1
            r6.f7999e = r2
            long r4 = r6.f8002h
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r6)
            if (r7 != r0) goto L3f
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.bg0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
