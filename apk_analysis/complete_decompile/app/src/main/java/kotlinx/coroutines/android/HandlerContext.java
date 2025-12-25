package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.DurationKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonDisposableHandle;
import kotlinx.coroutines.android.HandlerContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.AbstractC1726qj;
import p000.C1807sq;
import p000.r82;

@Metadata(m5568d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00142\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0096\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010+\u001a\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010'\u001a\u0004\b)\u0010*¨\u0006,"}, m5569d2 = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "Landroid/os/Handler;", "handler", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "<init>", "(Landroid/os/Handler;Ljava/lang/String;)V", "Lkotlin/coroutines/CoroutineContext;", "context", "", "isDispatchNeeded", "(Lkotlin/coroutines/CoroutineContext;)Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "timeMillis", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/DisposableHandle;", "toString", "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "_immediate", "Lkotlinx/coroutines/android/HandlerContext;", "e", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "immediate", "kotlinx-coroutines-android"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nHandlerDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerContext\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Runnable.kt\nkotlinx/coroutines/RunnableKt\n*L\n1#1,217:1\n1#2:218\n17#3:219\n*S KotlinDebug\n*F\n+ 1 HandlerDispatcher.kt\nkotlinx/coroutines/android/HandlerContext\n*L\n147#1:219\n*E\n"})
/* loaded from: classes2.dex */
public final class HandlerContext extends HandlerDispatcher implements Delay {

    @Nullable
    private volatile HandlerContext _immediate;

    /* renamed from: b */
    public final Handler f21435b;

    /* renamed from: c */
    public final String f21436c;

    /* renamed from: d */
    public final boolean f21437d;

    /* renamed from: e, reason: from kotlin metadata */
    public final HandlerContext immediate;

    public HandlerContext(Handler handler, String str, boolean z) {
        super(null);
        this.f21435b = handler;
        this.f21436c = str;
        this.f21437d = z;
        this._immediate = z ? this : null;
        HandlerContext handlerContext = this._immediate;
        if (handlerContext == null) {
            handlerContext = new HandlerContext(handler, str, true);
            this._immediate = handlerContext;
        }
        this.immediate = handlerContext;
    }

    /* renamed from: a */
    public final void m5679a(CoroutineContext coroutineContext, Runnable runnable) {
        JobKt.cancel(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        Dispatchers.getIO().dispatch(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull CoroutineContext context, @NotNull Runnable block) {
        if (!this.f21435b.post(block)) {
            m5679a(context, block);
        }
    }

    public boolean equals(@Nullable Object other) {
        if ((other instanceof HandlerContext) && ((HandlerContext) other).f21435b == this.f21435b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return System.identityHashCode(this.f21435b);
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.Delay
    @NotNull
    public DisposableHandle invokeOnTimeout(long timeMillis, @NotNull final Runnable block, @NotNull CoroutineContext context) {
        if (this.f21435b.postDelayed(block, r82.coerceAtMost(timeMillis, DurationKt.MAX_MILLIS))) {
            return new DisposableHandle() { // from class: yy0
                @Override // kotlinx.coroutines.DisposableHandle
                public final void dispose() {
                    HandlerContext.this.f21435b.removeCallbacks(block);
                }
            };
        }
        m5679a(context, block);
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@NotNull CoroutineContext context) {
        if (this.f21437d && Intrinsics.areEqual(Looper.myLooper(), this.f21435b.getLooper())) {
            return false;
        }
        return true;
    }

    @Override // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long timeMillis, @NotNull final CancellableContinuation<? super Unit> continuation) {
        Runnable runnable = new Runnable() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                CancellableContinuation.this.resumeUndispatched(this, Unit.INSTANCE);
            }
        };
        if (this.f21435b.postDelayed(runnable, r82.coerceAtMost(timeMillis, DurationKt.MAX_MILLIS))) {
            continuation.invokeOnCancellation(new C1807sq(3, this, runnable));
        } else {
            m5679a(continuation.getContext(), runnable);
        }
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        String stringInternalImpl = toStringInternalImpl();
        if (stringInternalImpl == null) {
            String str = this.f21436c;
            if (str == null) {
                str = this.f21435b.toString();
            }
            if (this.f21437d) {
                return AbstractC1726qj.m7057m(str, ".immediate");
            }
            return str;
        }
        return stringInternalImpl;
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.MainCoroutineDispatcher
    @NotNull
    public HandlerContext getImmediate() {
        return this.immediate;
    }

    public /* synthetic */ HandlerContext(Handler handler, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    public HandlerContext(@NotNull Handler handler, @Nullable String str) {
        this(handler, str, false);
    }
}
