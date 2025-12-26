package p000;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;

/* loaded from: classes.dex */
public final class do1 implements Handler.Callback {

    /* renamed from: a */
    public final co1 f16457a = new co1(this);

    /* renamed from: b */
    public MediaSource f16458b;

    /* renamed from: c */
    public MediaPeriod f16459c;

    /* renamed from: d */
    public final /* synthetic */ eo1 f16460d;

    public do1(eo1 eo1Var) {
        this.f16460d = eo1Var;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        co1 co1Var = this.f16457a;
        eo1 eo1Var = this.f16460d;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    if (this.f16459c != null) {
                        ((MediaSource) Assertions.checkNotNull(this.f16458b)).releasePeriod(this.f16459c);
                    }
                    ((MediaSource) Assertions.checkNotNull(this.f16458b)).releaseSource(co1Var);
                    eo1Var.f16928c.removeCallbacksAndMessages(null);
                    eo1Var.f16927b.quit();
                    return true;
                }
                ((MediaPeriod) Assertions.checkNotNull(this.f16459c)).continueLoading(0L);
                return true;
            }
            try {
                MediaPeriod mediaPeriod = this.f16459c;
                if (mediaPeriod == null) {
                    ((MediaSource) Assertions.checkNotNull(this.f16458b)).maybeThrowSourceInfoRefreshError();
                } else {
                    mediaPeriod.maybeThrowPrepareError();
                }
                eo1Var.f16928c.sendEmptyMessageDelayed(1, 100);
            } catch (Exception e) {
                eo1Var.f16929d.setException(e);
                eo1Var.f16928c.obtainMessage(3).sendToTarget();
            }
            return true;
        }
        MediaSource createMediaSource = eo1Var.f16926a.createMediaSource((MediaItem) message.obj);
        this.f16458b = createMediaSource;
        createMediaSource.prepareSource(co1Var, null, PlayerId.UNSET);
        eo1Var.f16928c.sendEmptyMessage(1);
        return true;
    }
}
