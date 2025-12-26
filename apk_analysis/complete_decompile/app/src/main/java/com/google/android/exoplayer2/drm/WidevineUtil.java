package com.google.android.exoplayer2.drm;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import java.util.Map;

/* loaded from: classes.dex */
public final class WidevineUtil {
    public static final String PROPERTY_LICENSE_DURATION_REMAINING = "LicenseDurationRemaining";
    public static final String PROPERTY_PLAYBACK_DURATION_REMAINING = "PlaybackDurationRemaining";

    /* JADX WARN: Can't wrap try/catch for region: R(10:5|(2:6|7)|(7:9|10|11|12|(1:14)|16|17)|20|10|11|12|(0)|16|17) */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[Catch: NumberFormatException -> 0x0031, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x0031, blocks: (B:12:0x0025, B:14:0x002d), top: B:11:0x0025 }] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Long, Long> getLicenseDurationRemainingSec(DrmSession drmSession) {
        long j;
        String str;
        String str2;
        Map<String, String> queryKeyStatus = drmSession.queryKeyStatus();
        if (queryKeyStatus == null) {
            return null;
        }
        long j2 = C0643C.TIME_UNSET;
        try {
            str2 = queryKeyStatus.get(PROPERTY_LICENSE_DURATION_REMAINING);
        } catch (NumberFormatException unused) {
        }
        if (str2 != null) {
            j = Long.parseLong(str2);
            Long valueOf = Long.valueOf(j);
            str = queryKeyStatus.get(PROPERTY_PLAYBACK_DURATION_REMAINING);
            if (str != null) {
                j2 = Long.parseLong(str);
            }
            return new Pair<>(valueOf, Long.valueOf(j2));
        }
        j = -9223372036854775807L;
        Long valueOf2 = Long.valueOf(j);
        str = queryKeyStatus.get(PROPERTY_PLAYBACK_DURATION_REMAINING);
        if (str != null) {
        }
        return new Pair<>(valueOf2, Long.valueOf(j2));
    }
}
