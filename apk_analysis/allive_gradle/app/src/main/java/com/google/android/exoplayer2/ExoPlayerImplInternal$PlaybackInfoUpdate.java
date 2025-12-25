package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;
import p000.l52;

/* loaded from: classes.dex */
public final class ExoPlayerImplInternal$PlaybackInfoUpdate {

    /* renamed from: a */
    public boolean f9349a;
    public int discontinuityReason;
    public boolean hasPlayWhenReadyChangeReason;
    public int operationAcks;
    public int playWhenReadyChangeReason;
    public l52 playbackInfo;
    public boolean positionDiscontinuity;

    public ExoPlayerImplInternal$PlaybackInfoUpdate(l52 l52Var) {
        this.playbackInfo = l52Var;
    }

    public void incrementPendingOperationAcks(int i) {
        boolean z;
        boolean z2 = this.f9349a;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        this.f9349a = z2 | z;
        this.operationAcks += i;
    }

    public void setPlayWhenReadyChangeReason(int i) {
        this.f9349a = true;
        this.hasPlayWhenReadyChangeReason = true;
        this.playWhenReadyChangeReason = i;
    }

    public void setPlaybackInfo(l52 l52Var) {
        boolean z;
        boolean z2 = this.f9349a;
        if (this.playbackInfo != l52Var) {
            z = true;
        } else {
            z = false;
        }
        this.f9349a = z2 | z;
        this.playbackInfo = l52Var;
    }

    public void setPositionDiscontinuity(int i) {
        boolean z = true;
        if (this.positionDiscontinuity && this.discontinuityReason != 5) {
            if (i != 5) {
                z = false;
            }
            Assertions.checkArgument(z);
        } else {
            this.f9349a = true;
            this.positionDiscontinuity = true;
            this.discontinuityReason = i;
        }
    }
}
