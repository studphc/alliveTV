package com.google.android.exoplayer2.video.spherical;

import android.graphics.PointF;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public interface TouchTracker$Listener {
    void onScrollChange(PointF pointF);

    boolean onSingleTapUp(MotionEvent motionEvent);
}
