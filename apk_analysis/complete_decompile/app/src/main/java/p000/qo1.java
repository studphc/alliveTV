package p000;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.leanback.media.PlaybackControlGlue;
import androidx.leanback.media.PlaybackTransportControlGlue;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.ModernAsyncTask$Status;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public final class qo1 extends Handler {

    /* renamed from: a */
    public final /* synthetic */ int f25706a;

    public /* synthetic */ qo1(int i) {
        this.f25706a = i;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        CountDownLatch countDownLatch;
        PlaybackControlGlue playbackControlGlue;
        PlaybackTransportControlGlue playbackTransportControlGlue;
        switch (this.f25706a) {
            case 0:
                po1 po1Var = (po1) message.obj;
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        po1Var.f25241a.getClass();
                        return;
                    }
                    return;
                }
                ro1 ro1Var = po1Var.f25241a;
                Object obj = po1Var.f25242b[0];
                if (ro1Var.f26085d.get()) {
                    RunnableC0552bc runnableC0552bc = (RunnableC0552bc) ro1Var;
                    countDownLatch = runnableC0552bc.f7959i;
                    try {
                        AsyncTaskLoader asyncTaskLoader = runnableC0552bc.f7961k;
                        asyncTaskLoader.onCanceled(obj);
                        if (asyncTaskLoader.f6614l == runnableC0552bc) {
                            asyncTaskLoader.rollbackContentChanged();
                            asyncTaskLoader.f6616n = SystemClock.uptimeMillis();
                            asyncTaskLoader.f6614l = null;
                            asyncTaskLoader.deliverCancellation();
                            asyncTaskLoader.m1546a();
                        }
                        countDownLatch.countDown();
                    } finally {
                        countDownLatch.countDown();
                    }
                } else {
                    RunnableC0552bc runnableC0552bc2 = (RunnableC0552bc) ro1Var;
                    try {
                        AsyncTaskLoader asyncTaskLoader2 = runnableC0552bc2.f7961k;
                        if (asyncTaskLoader2.f6613k != runnableC0552bc2) {
                            asyncTaskLoader2.onCanceled(obj);
                            if (asyncTaskLoader2.f6614l == runnableC0552bc2) {
                                asyncTaskLoader2.rollbackContentChanged();
                                asyncTaskLoader2.f6616n = SystemClock.uptimeMillis();
                                asyncTaskLoader2.f6614l = null;
                                asyncTaskLoader2.deliverCancellation();
                                asyncTaskLoader2.m1546a();
                            }
                        } else if (asyncTaskLoader2.isAbandoned()) {
                            asyncTaskLoader2.onCanceled(obj);
                        } else {
                            asyncTaskLoader2.commitContentChanged();
                            asyncTaskLoader2.f6616n = SystemClock.uptimeMillis();
                            asyncTaskLoader2.f6613k = null;
                            asyncTaskLoader2.deliverResult(obj);
                        }
                    } finally {
                        countDownLatch = runnableC0552bc2.f7959i;
                    }
                }
                ro1Var.f26084c = ModernAsyncTask$Status.FINISHED;
                return;
            case 1:
                if (message.what == 100 && (playbackControlGlue = (PlaybackControlGlue) ((WeakReference) message.obj).get()) != null) {
                    playbackControlGlue.m1364b();
                    return;
                }
                return;
            default:
                if (message.what == 100 && (playbackTransportControlGlue = (PlaybackTransportControlGlue) ((WeakReference) message.obj).get()) != null) {
                    boolean isPlaying = playbackTransportControlGlue.f5426d.isPlaying();
                    playbackTransportControlGlue.f5430h = isPlaying;
                    playbackTransportControlGlue.m1369b(isPlaying);
                    return;
                }
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ qo1(Looper looper) {
        super(looper);
        this.f25706a = 0;
    }
}
