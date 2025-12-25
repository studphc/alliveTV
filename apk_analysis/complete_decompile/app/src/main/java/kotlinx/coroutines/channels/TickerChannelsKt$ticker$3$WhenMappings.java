package kotlinx.coroutines.channels;

import kotlin.Metadata;

@Metadata(m5570k = 3, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final /* synthetic */ class TickerChannelsKt$ticker$3$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        int[] iArr = new int[TickerMode.values().length];
        try {
            iArr[TickerMode.FIXED_PERIOD.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[TickerMode.FIXED_DELAY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        $EnumSwitchMapping$0 = iArr;
    }
}
