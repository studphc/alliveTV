package com.google.android.exoplayer2;

import android.media.MediaFormat;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;

/* renamed from: com.google.android.exoplayer2.b */
/* loaded from: classes.dex */
public final class C0657b implements VideoFrameMetadataListener, CameraMotionListener, PlayerMessage.Target {

    /* renamed from: a */
    public VideoFrameMetadataListener f9836a;

    /* renamed from: b */
    public CameraMotionListener f9837b;

    /* renamed from: c */
    public VideoFrameMetadataListener f9838c;

    /* renamed from: d */
    public CameraMotionListener f9839d;

    @Override // com.google.android.exoplayer2.PlayerMessage.Target
    public final void handleMessage(int i, Object obj) {
        if (i != 7) {
            if (i != 8) {
                if (i == 10000) {
                    SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj;
                    if (sphericalGLSurfaceView == null) {
                        this.f9838c = null;
                        this.f9839d = null;
                        return;
                    } else {
                        this.f9838c = sphericalGLSurfaceView.getVideoFrameMetadataListener();
                        this.f9839d = sphericalGLSurfaceView.getCameraMotionListener();
                        return;
                    }
                }
                return;
            }
            this.f9837b = (CameraMotionListener) obj;
            return;
        }
        this.f9836a = (VideoFrameMetadataListener) obj;
    }

    @Override // com.google.android.exoplayer2.video.spherical.CameraMotionListener
    public final void onCameraMotion(long j, float[] fArr) {
        CameraMotionListener cameraMotionListener = this.f9839d;
        if (cameraMotionListener != null) {
            cameraMotionListener.onCameraMotion(j, fArr);
        }
        CameraMotionListener cameraMotionListener2 = this.f9837b;
        if (cameraMotionListener2 != null) {
            cameraMotionListener2.onCameraMotion(j, fArr);
        }
    }

    @Override // com.google.android.exoplayer2.video.spherical.CameraMotionListener
    public final void onCameraMotionReset() {
        CameraMotionListener cameraMotionListener = this.f9839d;
        if (cameraMotionListener != null) {
            cameraMotionListener.onCameraMotionReset();
        }
        CameraMotionListener cameraMotionListener2 = this.f9837b;
        if (cameraMotionListener2 != null) {
            cameraMotionListener2.onCameraMotionReset();
        }
    }

    @Override // com.google.android.exoplayer2.video.VideoFrameMetadataListener
    public final void onVideoFrameAboutToBeRendered(long j, long j2, Format format, MediaFormat mediaFormat) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.f9838c;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j, j2, format, mediaFormat);
        }
        VideoFrameMetadataListener videoFrameMetadataListener2 = this.f9836a;
        if (videoFrameMetadataListener2 != null) {
            videoFrameMetadataListener2.onVideoFrameAboutToBeRendered(j, j2, format, mediaFormat);
        }
    }
}
