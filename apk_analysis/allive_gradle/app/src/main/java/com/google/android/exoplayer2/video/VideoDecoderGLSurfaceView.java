package com.google.android.exoplayer2.video;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.VideoDecoderOutputBuffer;
import p000.f23;

/* loaded from: classes.dex */
public final class VideoDecoderGLSurfaceView extends GLSurfaceView implements VideoDecoderOutputBufferRenderer {

    /* renamed from: b */
    public static final /* synthetic */ int f12870b = 0;

    /* renamed from: a */
    public final f23 f12871a;

    public VideoDecoderGLSurfaceView(Context context) {
        this(context, null);
    }

    @Deprecated
    public VideoDecoderOutputBufferRenderer getVideoDecoderOutputBufferRenderer() {
        return this;
    }

    @Override // com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer
    public void setOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        f23 f23Var = this.f12871a;
        VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = (VideoDecoderOutputBuffer) f23Var.f17106f.getAndSet(videoDecoderOutputBuffer);
        if (videoDecoderOutputBuffer2 != null) {
            videoDecoderOutputBuffer2.release();
        }
        f23Var.f17101a.requestRender();
    }

    public VideoDecoderGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        f23 f23Var = new f23(this);
        this.f12871a = f23Var;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(f23Var);
        setRenderMode(0);
    }
}
