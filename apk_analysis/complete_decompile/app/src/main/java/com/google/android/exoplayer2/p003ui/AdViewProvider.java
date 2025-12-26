package com.google.android.exoplayer2.p003ui;

import android.view.ViewGroup;
import androidx.annotation.Nullable;
import java.util.List;

/* loaded from: classes.dex */
public interface AdViewProvider {
    List<AdOverlayInfo> getAdOverlayInfos();

    @Nullable
    ViewGroup getAdViewGroup();
}
