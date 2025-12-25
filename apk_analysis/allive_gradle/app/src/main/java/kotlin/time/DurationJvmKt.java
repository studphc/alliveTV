package kotlin.time;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u001c\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\u0006\"\u001a\u0010\t\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m5569d2 = {"", "value", "", "decimals", "", "formatToExactDecimals", "(DI)Ljava/lang/String;", "formatUpToDecimals", "", "durationAssertionsEnabled", "Z", "getDurationAssertionsEnabled", "()Z", "kotlin-stdlib"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@SourceDebugExtension({"SMAP\nDurationJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DurationJvm.kt\nkotlin/time/DurationJvmKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,33:1\n1#2:34\n*E\n"})
/* loaded from: classes2.dex */
public final class DurationJvmKt {

    /* renamed from: a */
    public static final ThreadLocal[] f21374a;

    static {
        ThreadLocal[] threadLocalArr = new ThreadLocal[4];
        for (int i = 0; i < 4; i++) {
            threadLocalArr[i] = new ThreadLocal();
        }
        f21374a = threadLocalArr;
    }

    /* renamed from: a */
    public static final DecimalFormat m5646a(int i) {
        DecimalFormat decimalFormat = new DecimalFormat("0");
        if (i > 0) {
            decimalFormat.setMinimumFractionDigits(i);
        }
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat;
    }

    @NotNull
    public static final String formatToExactDecimals(double d, int i) {
        DecimalFormat m5646a;
        ThreadLocal[] threadLocalArr = f21374a;
        if (i < threadLocalArr.length) {
            ThreadLocal threadLocal = threadLocalArr[i];
            Object obj = threadLocal.get();
            if (obj == null) {
                obj = m5646a(i);
                threadLocal.set(obj);
            } else {
                Intrinsics.checkNotNullExpressionValue(obj, "get() ?: default().also(this::set)");
            }
            m5646a = (DecimalFormat) obj;
        } else {
            m5646a = m5646a(i);
        }
        String format = m5646a.format(d);
        Intrinsics.checkNotNullExpressionValue(format, "format.format(value)");
        return format;
    }

    @NotNull
    public static final String formatUpToDecimals(double d, int i) {
        DecimalFormat m5646a = m5646a(0);
        m5646a.setMaximumFractionDigits(i);
        String format = m5646a.format(d);
        Intrinsics.checkNotNullExpressionValue(format, "createFormatForDecimals(… }\n        .format(value)");
        return format;
    }

    public static final boolean getDurationAssertionsEnabled() {
        return false;
    }
}
