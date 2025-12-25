package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(m5568d1 = {"\u0000 \n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0004\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0006\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005\"\u0014\u0010\b\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0005\"\u0014\u0010\t\u001a\u00020\u00038\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0005\"\u001a\u0010\u000f\u001a\u00020\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\" \u0010\u0013\u001a\u00020\n8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\f\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0011\u0010\u000e\"\u001a\u0010\u0019\u001a\u00020\u00148\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u001a\u001a\u00020\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000e¨\u0006\u001c"}, m5569d2 = {"", "resetCoroutineId", "()V", "", "DEBUG_PROPERTY_NAME", "Ljava/lang/String;", "STACKTRACE_RECOVERY_PROPERTY_NAME", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_ON", "DEBUG_PROPERTY_VALUE_OFF", "", "a", "Z", "getDEBUG", "()Z", "DEBUG", "b", "getRECOVER_STACK_TRACES", "getRECOVER_STACK_TRACES$annotations", "RECOVER_STACK_TRACES", "Ljava/util/concurrent/atomic/AtomicLong;", "c", "Ljava/util/concurrent/atomic/AtomicLong;", "getCOROUTINE_ID", "()Ljava/util/concurrent/atomic/AtomicLong;", "COROUTINE_ID", "ASSERTIONS_ENABLED", "getASSERTIONS_ENABLED", "kotlinx-coroutines-core"}, m5570k = 2, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class DebugKt {

    @NotNull
    public static final String DEBUG_PROPERTY_NAME = "kotlinx.coroutines.debug";

    @NotNull
    public static final String DEBUG_PROPERTY_VALUE_AUTO = "auto";

    @NotNull
    public static final String DEBUG_PROPERTY_VALUE_OFF = "off";

    @NotNull
    public static final String DEBUG_PROPERTY_VALUE_ON = "on";

    @NotNull
    public static final String STACKTRACE_RECOVERY_PROPERTY_NAME = "kotlinx.coroutines.stacktrace.recovery";

    /* renamed from: a */
    public static final boolean f21398a;

    /* renamed from: b */
    public static final boolean f21399b;

    /* renamed from: c */
    public static final AtomicLong f21400c;

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        if (r0.equals(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0040, code lost:
    
        if (r0.equals("") != false) goto L23;
     */
    static {
        boolean z;
        String systemProp = SystemPropsKt.systemProp(DEBUG_PROPERTY_NAME);
        boolean z2 = true;
        if (systemProp != null) {
            int hashCode = systemProp.hashCode();
            if (hashCode != 0) {
                if (hashCode != 3551) {
                    if (hashCode == 109935) {
                    }
                }
                throw new IllegalStateException(("System property 'kotlinx.coroutines.debug' has unrecognized value '" + systemProp + '\'').toString());
            }
            f21398a = z;
            if (z || !SystemPropsKt.systemProp(STACKTRACE_RECOVERY_PROPERTY_NAME, true)) {
                z2 = false;
            }
            f21399b = z2;
            f21400c = new AtomicLong(0L);
        }
        z = false;
        f21398a = z;
        if (z) {
        }
        z2 = false;
        f21399b = z2;
        f21400c = new AtomicLong(0L);
    }

    public static final boolean getASSERTIONS_ENABLED() {
        return false;
    }

    @NotNull
    public static final AtomicLong getCOROUTINE_ID() {
        return f21400c;
    }

    public static final boolean getDEBUG() {
        return f21398a;
    }

    public static final boolean getRECOVER_STACK_TRACES() {
        return f21399b;
    }

    @PublishedApi
    public static /* synthetic */ void getRECOVER_STACK_TRACES$annotations() {
    }

    public static final void resetCoroutineId() {
        f21400c.set(0L);
    }
}
