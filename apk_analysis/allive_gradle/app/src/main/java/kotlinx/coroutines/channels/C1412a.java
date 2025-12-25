package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause2;

/* renamed from: kotlinx.coroutines.channels.a */
/* loaded from: classes2.dex */
public class C1412a extends AbstractCoroutine implements ProducerScope, BroadcastChannel {

    /* renamed from: d */
    public final BroadcastChannel f21490d;

    public C1412a(CoroutineContext coroutineContext, BroadcastChannel broadcastChannel, boolean z) {
        super(coroutineContext, false, z);
        this.f21490d = broadcastChannel;
        initParentJob((Job) coroutineContext.get(Job.INSTANCE));
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final /* synthetic */ boolean cancel(Throwable th) {
        if (th == null) {
            th = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(th);
        return true;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void cancelInternal(Throwable th) {
        CancellationException cancellationException$default = JobSupport.toCancellationException$default(this, th, null, 1, null);
        this.f21490d.cancel(cancellationException$default);
        cancelCoroutine(cancellationException$default);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean close(Throwable th) {
        boolean close = this.f21490d.close(th);
        start();
        return close;
    }

    @Override // kotlinx.coroutines.channels.ProducerScope
    public final SendChannel getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final SelectClause2 getOnSend() {
        return this.f21490d.getOnSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final void invokeOnClose(Function1 function1) {
        this.f21490d.invokeOnClose(function1);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean isClosedForSend() {
        return this.f21490d.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean offer(Object obj) {
        return this.f21490d.offer(obj);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void onCancelled(Throwable th, boolean z) {
        if (!this.f21490d.close(th) && !z) {
            CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th);
        }
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void onCompleted(Object obj) {
        SendChannel.DefaultImpls.close$default(this.f21490d, null, 1, null);
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel openSubscription() {
        return this.f21490d.openSubscription();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object send(Object obj, Continuation continuation) {
        return this.f21490d.send(obj, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public final Object mo8858trySendJP2dKIU(Object obj) {
        return this.f21490d.mo8858trySendJP2dKIU(obj);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }
}
