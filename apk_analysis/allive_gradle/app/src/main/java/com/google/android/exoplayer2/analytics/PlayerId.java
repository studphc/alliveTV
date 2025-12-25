package com.google.android.exoplayer2.analytics;

import android.media.metrics.LogSessionId;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import p000.h62;

/* loaded from: classes.dex */
public final class PlayerId {
    public static final PlayerId UNSET;

    /* renamed from: a */
    public final h62 f9574a;

    static {
        PlayerId playerId;
        if (Util.SDK_INT < 31) {
            playerId = new PlayerId();
        } else {
            playerId = new PlayerId(h62.f17954b);
        }
        UNSET = playerId;
    }

    public PlayerId() {
        this((h62) null);
        Assertions.checkState(Util.SDK_INT < 31);
    }

    @RequiresApi(31)
    public LogSessionId getLogSessionId() {
        return ((h62) Assertions.checkNotNull(this.f9574a)).f17955a;
    }

    @RequiresApi(31)
    public PlayerId(LogSessionId logSessionId) {
        this(new h62(logSessionId));
    }

    public PlayerId(h62 h62Var) {
        this.f9574a = h62Var;
    }
}
