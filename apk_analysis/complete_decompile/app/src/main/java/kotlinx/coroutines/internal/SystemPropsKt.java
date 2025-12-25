package kotlinx.coroutines.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.bs2;
import p000.qo2;

@Metadata(m5568d1 = {"bs2"}, m5569d2 = {}, m5570k = 4, m5571mv = {1, 8, 0}, m5573xi = 48)
/* loaded from: classes2.dex */
public final class SystemPropsKt {
    public static final int getAVAILABLE_PROCESSORS() {
        return bs2.f8148a;
    }

    @Nullable
    public static final String systemProp(@NotNull String str) {
        int i = bs2.f8148a;
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static /* synthetic */ int systemProp$default(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return systemProp(str, i, i2, i3);
    }

    public static /* synthetic */ long systemProp$default(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return systemProp(str, j, j4, j3);
    }

    public static final boolean systemProp(@NotNull String str, boolean z) {
        String systemProp = systemProp(str);
        return systemProp != null ? Boolean.parseBoolean(systemProp) : z;
    }

    public static final int systemProp(@NotNull String str, int i, int i2, int i3) {
        return (int) systemProp(str, i, i2, i3);
    }

    public static final long systemProp(@NotNull String str, long j, long j2, long j3) {
        String systemProp = systemProp(str);
        if (systemProp == null) {
            return j;
        }
        Long longOrNull = qo2.toLongOrNull(systemProp);
        if (longOrNull == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + systemProp + '\'').toString());
        }
        long longValue = longOrNull.longValue();
        if (j2 <= longValue && longValue <= j3) {
            return longValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + longValue + '\'').toString());
    }

    @NotNull
    public static final String systemProp(@NotNull String str, @NotNull String str2) {
        String systemProp = systemProp(str);
        return systemProp == null ? str2 : systemProp;
    }
}
