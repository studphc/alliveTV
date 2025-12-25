package kotlinx.coroutines.debug;

import android.annotation.SuppressLint;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.AgentInstallationType;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.misc.Signal;
import sun.misc.SignalHandler;

@Metadata(m5568d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\tJ!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, m5569d2 = {"Lkotlinx/coroutines/debug/AgentPremain;", "", "", "args", "Ljava/lang/instrument/Instrumentation;", "instrumentation", "", "premain", "(Ljava/lang/String;Ljava/lang/instrument/Instrumentation;)V", "DebugProbesTransformer", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
@SuppressLint({"all"})
@IgnoreJRERequirement
/* loaded from: classes2.dex */
public final class AgentPremain {

    @NotNull
    public static final AgentPremain INSTANCE = new Object();

    /* renamed from: a */
    public static final boolean f21504a;

    @Metadata(m5568d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001JC\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, m5569d2 = {"Lkotlinx/coroutines/debug/AgentPremain$DebugProbesTransformer;", "Ljava/lang/instrument/ClassFileTransformer;", "Ljava/lang/ClassLoader;", "loader", "", "className", "Ljava/lang/Class;", "classBeingRedefined", "Ljava/security/ProtectionDomain;", "protectionDomain", "", "classfileBuffer", "transform", "(Ljava/lang/ClassLoader;Ljava/lang/String;Ljava/lang/Class;Ljava/security/ProtectionDomain;[B)[B", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
    /* loaded from: classes2.dex */
    public static final class DebugProbesTransformer implements ClassFileTransformer {

        @NotNull
        public static final DebugProbesTransformer INSTANCE = new Object();

        @Nullable
        public byte[] transform(@Nullable ClassLoader loader, @NotNull String className, @Nullable Class<?> classBeingRedefined, @NotNull ProtectionDomain protectionDomain, @Nullable byte[] classfileBuffer) {
            if (loader != null && Intrinsics.areEqual(className, "kotlin/coroutines/jvm/internal/DebugProbesKt")) {
                AgentInstallationType.INSTANCE.setInstalledStatically$kotlinx_coroutines_core(true);
                return ByteStreamsKt.readBytes(loader.getResourceAsStream("DebugProbesKt.bin"));
            }
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlinx.coroutines.debug.AgentPremain] */
    static {
        Object m8512constructorimpl;
        boolean enableCreationStackTraces$kotlinx_coroutines_core;
        Boolean bool;
        Object obj = null;
        try {
            Result.Companion companion = Result.INSTANCE;
            String property = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
            if (property != null) {
                bool = Boolean.valueOf(Boolean.parseBoolean(property));
            } else {
                bool = null;
            }
            m8512constructorimpl = Result.m8512constructorimpl(bool);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m8512constructorimpl = Result.m8512constructorimpl(ResultKt.createFailure(th));
        }
        if (!Result.m8517isFailureimpl(m8512constructorimpl)) {
            obj = m8512constructorimpl;
        }
        Boolean bool2 = (Boolean) obj;
        if (bool2 != null) {
            enableCreationStackTraces$kotlinx_coroutines_core = bool2.booleanValue();
        } else {
            enableCreationStackTraces$kotlinx_coroutines_core = DebugProbesImpl.INSTANCE.getEnableCreationStackTraces$kotlinx_coroutines_core();
        }
        f21504a = enableCreationStackTraces$kotlinx_coroutines_core;
    }

    /* renamed from: a */
    public static void m5705a() {
        try {
            Signal.handle(new Signal("TRAP"), new SignalHandler() { // from class: e7
            });
        } catch (Throwable unused) {
        }
    }

    @JvmStatic
    public static final void premain(@Nullable String args, @NotNull Instrumentation instrumentation) {
        AgentInstallationType.INSTANCE.setInstalledStatically$kotlinx_coroutines_core(true);
        instrumentation.addTransformer(DebugProbesTransformer.INSTANCE);
        DebugProbesImpl debugProbesImpl = DebugProbesImpl.INSTANCE;
        debugProbesImpl.setEnableCreationStackTraces$kotlinx_coroutines_core(f21504a);
        debugProbesImpl.install$kotlinx_coroutines_core();
        INSTANCE.getClass();
        m5705a();
    }
}
