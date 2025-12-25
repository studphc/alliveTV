package kotlinx.coroutines.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.selects.OnTimeoutKt;
import kotlinx.coroutines.selects.SelectBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.b51;

@Metadata(m5568d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a-\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u0007\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\n\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u000b\u0010\t\u001aF\u0010\u0012\u001a\u00020\u0002\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u0001\u001a\u00020\u00002\u001c\u0010\u0011\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001aW\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0001\u001a\u00020\u00002'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014¢\u0006\u0002\b\u0016H\u0086@ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001aL\u0010\u0019\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0001\u001a\u00020\u00002'\u0010\u0011\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014¢\u0006\u0002\b\u0016H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, m5569d2 = {"Ljava/time/Duration;", TypedValues.TransitionType.S_DURATION, "", "delay", "(Ljava/time/Duration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "timeout", "debounce", "(Lkotlinx/coroutines/flow/Flow;Ljava/time/Duration;)Lkotlinx/coroutines/flow/Flow;", TypedValues.CycleType.S_WAVE_PERIOD, "sample", "R", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "onTimeout", "(Lkotlinx/coroutines/selects/SelectBuilder;Ljava/time/Duration;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ExtensionFunctionType;", "withTimeout", "(Ljava/time/Duration;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class TimeKt {
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
    
        if (r0 < 807000000) goto L18;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long m5755a(Duration duration) {
        Duration duration2;
        int compareTo;
        ChronoUnit chronoUnit;
        Duration duration3;
        int compareTo2;
        long seconds;
        long millis;
        long seconds2;
        int nano;
        duration2 = Duration.ZERO;
        compareTo = duration.compareTo(duration2);
        if (compareTo > 0) {
            chronoUnit = ChronoUnit.MILLIS;
            duration3 = chronoUnit.getDuration();
            compareTo2 = duration.compareTo(duration3);
            if (compareTo2 > 0) {
                seconds = duration.getSeconds();
                if (seconds >= 9223372036854775L) {
                    seconds2 = duration.getSeconds();
                    if (seconds2 == 9223372036854775L) {
                        nano = duration.getNano();
                    }
                    return Long.MAX_VALUE;
                }
                millis = duration.toMillis();
                return millis;
            }
            return 1L;
        }
        return 0L;
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> debounce(@NotNull Flow<? extends T> flow, @NotNull Duration duration) {
        return FlowKt.debounce(flow, m5755a(duration));
    }

    @Nullable
    public static final Object delay(@NotNull Duration duration, @NotNull Continuation<? super Unit> continuation) {
        Object delay = DelayKt.delay(m5755a(duration), continuation);
        if (delay == b51.getCOROUTINE_SUSPENDED()) {
            return delay;
        }
        return Unit.INSTANCE;
    }

    public static final <R> void onTimeout(@NotNull SelectBuilder<? super R> selectBuilder, @NotNull Duration duration, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        OnTimeoutKt.onTimeout(selectBuilder, m5755a(duration), function1);
    }

    @FlowPreview
    @NotNull
    public static final <T> Flow<T> sample(@NotNull Flow<? extends T> flow, @NotNull Duration duration) {
        return FlowKt.sample(flow, m5755a(duration));
    }

    @Nullable
    public static final <T> Object withTimeout(@NotNull Duration duration, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return TimeoutKt.withTimeout(m5755a(duration), function2, continuation);
    }

    @Nullable
    public static final <T> Object withTimeoutOrNull(@NotNull Duration duration, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return TimeoutKt.withTimeoutOrNull(m5755a(duration), function2, continuation);
    }
}
