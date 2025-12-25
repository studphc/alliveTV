package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.time.Duration;
import kotlinx.coroutines.flow.SharingStarted;
import org.jetbrains.annotations.NotNull;
import p000.nn2;

@Metadata(m5568d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\b"}, m5569d2 = {"WhileSubscribed", "Lkotlinx/coroutines/flow/SharingStarted;", "Lkotlinx/coroutines/flow/SharingStarted$Companion;", "stopTimeout", "Lkotlin/time/Duration;", "replayExpiration", "WhileSubscribed-5qebJ5I", "(Lkotlinx/coroutines/flow/SharingStarted$Companion;JJ)Lkotlinx/coroutines/flow/SharingStarted;", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class SharingStartedKt {
    @NotNull
    /* renamed from: WhileSubscribed-5qebJ5I, reason: not valid java name */
    public static final SharingStarted m8887WhileSubscribed5qebJ5I(@NotNull SharingStarted.Companion companion, long j, long j2) {
        return new nn2(Duration.m8737getInWholeMillisecondsimpl(j), Duration.m8737getInWholeMillisecondsimpl(j2));
    }

    /* renamed from: WhileSubscribed-5qebJ5I$default, reason: not valid java name */
    public static /* synthetic */ SharingStarted m8888WhileSubscribed5qebJ5I$default(SharingStarted.Companion companion, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Duration.INSTANCE.m8795getZEROUwyO8pc();
        }
        if ((i & 2) != 0) {
            j2 = Duration.INSTANCE.m8793getINFINITEUwyO8pc();
        }
        return m8887WhileSubscribed5qebJ5I(companion, j, j2);
    }
}
