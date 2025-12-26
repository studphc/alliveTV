package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.ObsoleteCoroutinesApi;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@ObsoleteCoroutinesApi
@Metadata(m5568d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, m5569d2 = {"Lkotlinx/coroutines/channels/TickerMode;", "", "FIXED_PERIOD", "FIXED_DELAY", "kotlinx-coroutines-core"}, m5570k = 1, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class TickerMode {
    public static final TickerMode FIXED_DELAY;
    public static final TickerMode FIXED_PERIOD;

    /* renamed from: a */
    public static final /* synthetic */ TickerMode[] f21489a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Enum, kotlinx.coroutines.channels.TickerMode] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, kotlinx.coroutines.channels.TickerMode] */
    static {
        ?? r2 = new Enum("FIXED_PERIOD", 0);
        FIXED_PERIOD = r2;
        ?? r3 = new Enum("FIXED_DELAY", 1);
        FIXED_DELAY = r3;
        f21489a = new TickerMode[]{r2, r3};
    }

    public static TickerMode valueOf(String str) {
        return (TickerMode) Enum.valueOf(TickerMode.class, str);
    }

    public static TickerMode[] values() {
        return (TickerMode[]) f21489a.clone();
    }
}
