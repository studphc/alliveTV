package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.selects.SelectClause2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated(level = DeprecationLevel.WARNING, message = "ConflatedBroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
@ObsoleteCoroutinesApi
@Metadata(m5568d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0006J\u001c\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0097\u0001¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\n\u001a\u00020\u000e2\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\rH\u0096\u0001¢\u0006\u0004\b\n\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u000bJ5\u0010\u0015\u001a\u00020\u000e2#\u0010\u0014\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000e0\u0011H\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00028\u0000H\u0097\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001f2\u0006\u0010\u0017\u001a\u00028\u0000H\u0096\u0001ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\t8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b#\u0010$R&\u0010)\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000&0%8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010\u0005\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0013\u0010-\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b,\u0010+\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006."}, m5569d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/BroadcastChannel;", "<init>", "()V", "value", "(Ljava/lang/Object;)V", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "close", "Lkotlin/Function1;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "element", "offer", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "isClosedForSend", "()Z", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "getValue", "()Ljava/lang/Object;", "getValueOrNull", "valueOrNull", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class ConflatedBroadcastChannel<E> implements BroadcastChannel<E> {

    /* renamed from: a */
    public final BroadcastChannelImpl f21487a;

    public ConflatedBroadcastChannel() {
        this.f21487a = new BroadcastChannelImpl(-1);
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public void cancel(@Nullable CancellationException cause) {
        this.f21487a.cancel(cause);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(@Nullable Throwable cause) {
        return this.f21487a.close(cause);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @NotNull
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return this.f21487a.getOnSend();
    }

    public final E getValue() {
        return (E) this.f21487a.getValue();
    }

    @Nullable
    public final E getValueOrNull() {
        return (E) this.f21487a.getValueOrNull();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(@NotNull Function1<? super Throwable, Unit> handler) {
        this.f21487a.invokeOnClose(handler);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this.f21487a.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E element) {
        return this.f21487a.offer(element);
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    @NotNull
    public ReceiveChannel<E> openSubscription() {
        return this.f21487a.openSubscription();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Nullable
    public Object send(E e, @NotNull Continuation<? super Unit> continuation) {
        return this.f21487a.send(e, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @NotNull
    /* renamed from: trySend-JP2dKIU */
    public Object mo8858trySendJP2dKIU(E element) {
        return this.f21487a.mo8858trySendJP2dKIU(element);
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility only")
    public /* synthetic */ boolean cancel(Throwable cause) {
        return this.f21487a.cancel(cause);
    }

    public ConflatedBroadcastChannel(E e) {
        this();
        mo8858trySendJP2dKIU(e);
    }
}
