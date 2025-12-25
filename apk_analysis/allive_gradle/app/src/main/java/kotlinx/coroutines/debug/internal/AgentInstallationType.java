package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, m5569d2 = {"Lkotlinx/coroutines/debug/internal/AgentInstallationType;", "", "", "a", "Z", "isInstalledStatically$kotlinx_coroutines_core", "()Z", "setInstalledStatically$kotlinx_coroutines_core", "(Z)V", "isInstalledStatically", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class AgentInstallationType {

    @NotNull
    public static final AgentInstallationType INSTANCE = new Object();

    /* renamed from: a, reason: from kotlin metadata */
    public static boolean isInstalledStatically;

    public final boolean isInstalledStatically$kotlinx_coroutines_core() {
        return isInstalledStatically;
    }

    public final void setInstalledStatically$kotlinx_coroutines_core(boolean z) {
        isInstalledStatically = z;
    }
}
