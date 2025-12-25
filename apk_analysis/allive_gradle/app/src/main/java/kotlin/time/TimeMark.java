package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import p000.C1972x6;

@SinceKotlin(version = "1.3")
@Metadata(m5568d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0015\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001b\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\f\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019¨\u0006\u000f"}, m5569d2 = {"Lkotlin/time/TimeMark;", "", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "hasNotPassedNow", "", "hasPassedNow", "minus", TypedValues.TransitionType.S_DURATION, "minus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "plus", "plus-LRDsOJo", "kotlin-stdlib"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@ExperimentalTime
/* loaded from: classes2.dex */
public interface TimeMark {

    @Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static boolean hasNotPassedNow(@NotNull TimeMark timeMark) {
            return Duration.m8747isNegativeimpl(timeMark.mo8481elapsedNowUwyO8pc());
        }

        public static boolean hasPassedNow(@NotNull TimeMark timeMark) {
            return !Duration.m8747isNegativeimpl(timeMark.mo8481elapsedNowUwyO8pc());
        }

        @NotNull
        /* renamed from: minus-LRDsOJo, reason: not valid java name */
        public static TimeMark m8824minusLRDsOJo(@NotNull TimeMark timeMark, long j) {
            return timeMark.mo8484plusLRDsOJo(Duration.m8766unaryMinusUwyO8pc(j));
        }

        @NotNull
        /* renamed from: plus-LRDsOJo, reason: not valid java name */
        public static TimeMark m8825plusLRDsOJo(@NotNull TimeMark timeMark, long j) {
            return new C1972x6(timeMark, j);
        }
    }

    /* renamed from: elapsedNow-UwyO8pc */
    long mo8481elapsedNowUwyO8pc();

    boolean hasNotPassedNow();

    boolean hasPassedNow();

    @NotNull
    /* renamed from: minus-LRDsOJo */
    TimeMark mo8482minusLRDsOJo(long duration);

    @NotNull
    /* renamed from: plus-LRDsOJo */
    TimeMark mo8484plusLRDsOJo(long duration);
}
