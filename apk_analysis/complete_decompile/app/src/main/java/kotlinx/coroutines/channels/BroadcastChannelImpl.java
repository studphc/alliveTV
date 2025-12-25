package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C1585nh;
import p000.C1622oh;
import p000.C1687ph;
import p000.C1724qh;
import p000.b51;
import p000.ye0;

@Metadata(m5568d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u000201B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0016\u001a\u00020\f2\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\u0015H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0010¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010*\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b(\u0010)\u001a\u0004\b&\u0010'R\u0019\u0010-\u001a\u0004\u0018\u00018\u00008F¢\u0006\f\u0012\u0004\b,\u0010)\u001a\u0004\b+\u0010'R\u0014\u0010.\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00062"}, m5569d2 = {"Lkotlinx/coroutines/channels/BroadcastChannelImpl;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/BufferedChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "", "capacity", "<init>", "(I)V", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "element", "", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "", "registerSelectForSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "cancelImpl$kotlinx_coroutines_core", "cancelImpl", "", "toString", "()Ljava/lang/String;", "l", "I", "getCapacity", "()I", "getValue", "()Ljava/lang/Object;", "getValue$annotations", "()V", "value", "getValueOrNull", "getValueOrNull$annotations", "valueOrNull", "isClosedForSend", "()Z", "nh", "oh", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nBroadcastChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl\n+ 2 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,414:1\n15#2:415\n15#2:416\n15#2:420\n15#2:423\n15#2:429\n15#2:430\n15#2:436\n15#2:439\n15#2:440\n15#2:441\n766#3:417\n857#3,2:418\n1855#3,2:421\n1747#3,3:424\n1855#3,2:427\n1855#3,2:431\n766#3:433\n857#3,2:434\n1855#3,2:437\n*S KotlinDebug\n*F\n+ 1 BroadcastChannel.kt\nkotlinx/coroutines/channels/BroadcastChannelImpl\n*L\n166#1:415\n188#1:416\n213#1:420\n237#1:423\n279#1:429\n331#1:430\n343#1:436\n355#1:439\n382#1:440\n394#1:441\n189#1:417\n189#1:418,2\n226#1:421,2\n242#1:424,3\n251#1:427,2\n333#1:431,2\n338#1:433\n338#1:434,2\n346#1:437,2\n*E\n"})
/* loaded from: classes2.dex */
public final class BroadcastChannelImpl<E> extends BufferedChannel<E> implements BroadcastChannel<E> {

    /* renamed from: l, reason: from kotlin metadata */
    public final int capacity;

    /* renamed from: m */
    public final ReentrantLock f21446m;

    /* renamed from: n */
    public List f21447n;

    /* renamed from: o */
    public Object f21448o;

    /* renamed from: p */
    public final HashMap f21449p;

    public BroadcastChannelImpl(int i) {
        super(0, null);
        this.capacity = i;
        if (i < 1 && i != -1) {
            throw new IllegalArgumentException(ye0.m8292l(i, "BroadcastChannel capacity must be positive or Channel.CONFLATED, but ", " was specified").toString());
        }
        this.f21446m = new ReentrantLock();
        this.f21447n = CollectionsKt__CollectionsKt.emptyList();
        this.f21448o = BroadcastChannelKt.access$getNO_ELEMENT$p();
        this.f21449p = new HashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$removeSubscriber(BroadcastChannelImpl broadcastChannelImpl, ReceiveChannel receiveChannel) {
        ReentrantLock reentrantLock = broadcastChannelImpl.f21446m;
        reentrantLock.lock();
        try {
            List list = broadcastChannelImpl.f21447n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((BufferedChannel) obj) != receiveChannel) {
                    arrayList.add(obj);
                }
            }
            broadcastChannelImpl.f21447n = arrayList;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    public static /* synthetic */ void getValueOrNull$annotations() {
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public boolean cancelImpl$kotlinx_coroutines_core(@Nullable Throwable cause) {
        ReentrantLock reentrantLock = this.f21446m;
        reentrantLock.lock();
        try {
            Iterator it = this.f21447n.iterator();
            while (it.hasNext()) {
                ((BufferedChannel) it.next()).cancelImpl$kotlinx_coroutines_core(cause);
            }
            this.f21448o = BroadcastChannelKt.access$getNO_ELEMENT$p();
            boolean cancelImpl$kotlinx_coroutines_core = super.cancelImpl$kotlinx_coroutines_core(cause);
            reentrantLock.unlock();
            return cancelImpl$kotlinx_coroutines_core;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public boolean close(@Nullable Throwable cause) {
        ReentrantLock reentrantLock = this.f21446m;
        reentrantLock.lock();
        try {
            Iterator it = this.f21447n.iterator();
            while (it.hasNext()) {
                ((BufferedChannel) it.next()).close(cause);
            }
            List list = this.f21447n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((BufferedChannel) obj).hasElements$kotlinx_coroutines_core()) {
                    arrayList.add(obj);
                }
            }
            this.f21447n = arrayList;
            boolean close = super.close(cause);
            reentrantLock.unlock();
            return close;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public final E getValue() {
        ReentrantLock reentrantLock = this.f21446m;
        reentrantLock.lock();
        try {
            if (isClosedForSend()) {
                Throwable closeCause = getCloseCause();
                if (closeCause == null) {
                    throw new IllegalStateException("This broadcast channel is closed");
                }
                throw closeCause;
            }
            if (this.f21448o != BroadcastChannelKt.access$getNO_ELEMENT$p()) {
                E e = (E) this.f21448o;
                reentrantLock.unlock();
                return e;
            }
            throw new IllegalStateException("No value");
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Nullable
    public final E getValueOrNull() {
        ReentrantLock reentrantLock = this.f21446m;
        reentrantLock.lock();
        try {
            E e = null;
            if (!isClosedForReceive() && this.f21448o != BroadcastChannelKt.access$getNO_ELEMENT$p()) {
                e = (E) this.f21448o;
            }
            return e;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        ReentrantLock reentrantLock = this.f21446m;
        reentrantLock.lock();
        try {
            return super.isClosedForSend();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    @NotNull
    public ReceiveChannel<E> openSubscription() {
        C1585nh c1585nh;
        ReentrantLock reentrantLock = this.f21446m;
        reentrantLock.lock();
        try {
            if (this.capacity == -1) {
                c1585nh = new C1622oh(this);
            } else {
                c1585nh = new C1585nh(this);
            }
            if (isClosedForSend() && this.f21448o == BroadcastChannelKt.access$getNO_ELEMENT$p()) {
                ((BufferedChannel) c1585nh).close(getCloseCause());
                reentrantLock.unlock();
                return c1585nh;
            }
            if (this.f21448o != BroadcastChannelKt.access$getNO_ELEMENT$p()) {
                ((BufferedChannel) c1585nh).mo8858trySendJP2dKIU(getValue());
            }
            this.f21447n = CollectionsKt___CollectionsKt.plus((Collection<? extends ReceiveChannel<E>>) this.f21447n, c1585nh);
            reentrantLock.unlock();
            return c1585nh;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public void registerSelectForSend(@NotNull SelectInstance<?> select, @Nullable Object element) {
        ReentrantLock reentrantLock = this.f21446m;
        reentrantLock.lock();
        try {
            Object remove = this.f21449p.remove(select);
            if (remove != null) {
                select.selectInRegistrationPhase(remove);
            } else {
                reentrantLock.unlock();
                BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(select.getContext()), null, CoroutineStart.UNDISPATCHED, new C1687ph(this, element, select, null), 1, null);
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0077 -> B:10:0x007a). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object send(E e, @NotNull Continuation<? super Unit> continuation) {
        C1724qh c1724qh;
        int i;
        BroadcastChannelImpl<E> broadcastChannelImpl;
        E e2;
        Iterator it;
        if (continuation instanceof C1724qh) {
            c1724qh = (C1724qh) continuation;
            int i2 = c1724qh.f25588i;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c1724qh.f25588i = i2 - Integer.MIN_VALUE;
                Object obj = c1724qh.f25586g;
                Object coroutine_suspended = b51.getCOROUTINE_SUSPENDED();
                i = c1724qh.f25588i;
                if (i == 0) {
                    if (i == 1) {
                        it = c1724qh.f25585f;
                        Object obj2 = c1724qh.f25584e;
                        broadcastChannelImpl = c1724qh.f25583d;
                        ResultKt.throwOnFailure(obj);
                        E e3 = obj2;
                        if (((Boolean) obj).booleanValue() && broadcastChannelImpl.isClosedForSend()) {
                            throw broadcastChannelImpl.getSendException();
                        }
                        e2 = e3;
                        if (it.hasNext()) {
                            BufferedChannel bufferedChannel = (BufferedChannel) it.next();
                            c1724qh.f25583d = broadcastChannelImpl;
                            c1724qh.f25584e = e2;
                            c1724qh.f25585f = it;
                            c1724qh.f25588i = 1;
                            Object sendBroadcast$kotlinx_coroutines_core = bufferedChannel.sendBroadcast$kotlinx_coroutines_core(e2, c1724qh);
                            if (sendBroadcast$kotlinx_coroutines_core == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            e3 = e2;
                            obj = sendBroadcast$kotlinx_coroutines_core;
                            if (((Boolean) obj).booleanValue()) {
                            }
                            e2 = e3;
                            if (it.hasNext()) {
                                return Unit.INSTANCE;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    ReentrantLock reentrantLock = this.f21446m;
                    reentrantLock.lock();
                    try {
                        if (!isClosedForSend()) {
                            if (this.capacity == -1) {
                                this.f21448o = e;
                            }
                            List list = this.f21447n;
                            reentrantLock.unlock();
                            broadcastChannelImpl = this;
                            e2 = e;
                            it = list.iterator();
                            if (it.hasNext()) {
                            }
                        } else {
                            throw getSendException();
                        }
                    } catch (Throwable th) {
                        reentrantLock.unlock();
                        throw th;
                    }
                }
            }
        }
        c1724qh = new C1724qh(this, continuation);
        Object obj3 = c1724qh.f25586g;
        Object coroutine_suspended2 = b51.getCOROUTINE_SUSPENDED();
        i = c1724qh.f25588i;
        if (i == 0) {
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    @NotNull
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.f21448o != BroadcastChannelKt.access$getNO_ELEMENT$p()) {
            str = "CONFLATED_ELEMENT=" + this.f21448o + "; ";
        } else {
            str = "";
        }
        sb.append(str);
        sb.append("BROADCAST=<");
        sb.append(super.toString());
        sb.append(">; SUBSCRIBERS=");
        sb.append(CollectionsKt___CollectionsKt.joinToString$default(this.f21447n, ";", "<", ">", 0, null, null, 56, null));
        return sb.toString();
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    @NotNull
    /* renamed from: trySend-JP2dKIU, reason: not valid java name */
    public Object mo8858trySendJP2dKIU(E element) {
        ReentrantLock reentrantLock = this.f21446m;
        reentrantLock.lock();
        try {
            if (isClosedForSend()) {
                return super.mo8858trySendJP2dKIU(element);
            }
            List list = this.f21447n;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((BufferedChannel) it.next()).shouldSendSuspend$kotlinx_coroutines_core()) {
                        return ChannelResult.INSTANCE.m8881failurePtdJZtk();
                    }
                }
            }
            if (this.capacity == -1) {
                this.f21448o = element;
            }
            Iterator it2 = this.f21447n.iterator();
            while (it2.hasNext()) {
                ((BufferedChannel) it2.next()).mo8858trySendJP2dKIU(element);
            }
            return ChannelResult.INSTANCE.m8882successJP2dKIU(Unit.INSTANCE);
        } finally {
            reentrantLock.unlock();
        }
    }
}
