package p000;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;

/* loaded from: classes.dex */
public final class gl1 implements MediaCodecAdapter.OnFrameRenderedListener, Handler.Callback {

    /* renamed from: a */
    public final Handler f17751a;

    /* renamed from: b */
    public final /* synthetic */ MediaCodecVideoRenderer f17752b;

    public gl1(MediaCodecVideoRenderer mediaCodecVideoRenderer, MediaCodecAdapter mediaCodecAdapter) {
        this.f17752b = mediaCodecVideoRenderer;
        Handler createHandlerForCurrentLooper = Util.createHandlerForCurrentLooper(this);
        this.f17751a = createHandlerForCurrentLooper;
        mediaCodecAdapter.setOnFrameRenderedListener(this, createHandlerForCurrentLooper);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        long j = Util.toLong(message.arg1, message.arg2);
        MediaCodecVideoRenderer mediaCodecVideoRenderer = this.f17752b;
        if (this == mediaCodecVideoRenderer.f12864m1) {
            if (j == Long.MAX_VALUE) {
                mediaCodecVideoRenderer.setPendingOutputEndOfStream();
                return true;
            }
            try {
                mediaCodecVideoRenderer.onProcessedTunneledBuffer(j);
                return true;
            } catch (ExoPlaybackException e) {
                mediaCodecVideoRenderer.setPendingPlaybackException(e);
                return true;
            }
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodecAdapter mediaCodecAdapter, long j, long j2) {
        if (Util.SDK_INT < 30) {
            Handler handler = this.f17751a;
            handler.sendMessageAtFrontOfQueue(Message.obtain(handler, 0, (int) (j >> 32), (int) j));
            return;
        }
        MediaCodecVideoRenderer mediaCodecVideoRenderer = this.f17752b;
        if (this == mediaCodecVideoRenderer.f12864m1) {
            if (j == Long.MAX_VALUE) {
                mediaCodecVideoRenderer.setPendingOutputEndOfStream();
                return;
            }
            try {
                mediaCodecVideoRenderer.onProcessedTunneledBuffer(j);
            } catch (ExoPlaybackException e) {
                mediaCodecVideoRenderer.setPendingPlaybackException(e);
            }
        }
    }
}
