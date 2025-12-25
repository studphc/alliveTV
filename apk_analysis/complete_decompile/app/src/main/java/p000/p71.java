package p000;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectInstance;

/* loaded from: classes2.dex */
public final class p71 extends C1897v5 {

    /* renamed from: e */
    public Continuation f25055e;

    /* renamed from: n */
    public static final void m6885n(p71 p71Var, SelectInstance selectInstance, Object obj) {
        p71Var.onStart();
        super.getOnSend().getRegFunc().invoke(p71Var, selectInstance, obj);
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public final boolean close(Throwable th) {
        boolean close = super.close(th);
        start();
        return close;
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public final SelectClause2 getOnSend() {
        o71 o71Var = o71.f23651h;
        Intrinsics.checkNotNull(o71Var, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new SelectClause2Impl(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(o71Var, 3), super.getOnSend().getProcessResFunc(), null, 8, null);
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public final boolean offer(Object obj) {
        start();
        return super.offer(obj);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void onStart() {
        CancellableKt.startCoroutineCancellable((Continuation<? super Unit>) this.f25055e, this);
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    public final Object send(Object obj, Continuation continuation) {
        start();
        Object send = super.send(obj, continuation);
        if (send == b51.getCOROUTINE_SUSPENDED()) {
            return send;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.channels.ChannelCoroutine, kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public final Object mo8858trySendJP2dKIU(Object obj) {
        start();
        return super.mo8858trySendJP2dKIU(obj);
    }
}
