package kotlin.concurrent;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m5568d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m5569d2 = {"", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "daemon", "Ljava/util/Timer;", "timer", "(Ljava/lang/String;Z)Ljava/util/Timer;", "kotlin-stdlib"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
@JvmName(name = "TimersKt")
/* loaded from: classes2.dex */
public final class TimersKt {
    @PublishedApi
    @NotNull
    public static final Timer timer(@Nullable String str, boolean z) {
        if (str == null) {
            return new Timer(z);
        }
        return new Timer(str, z);
    }
}
