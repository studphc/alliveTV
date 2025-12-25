package com.google.android.exoplayer2.video.spherical;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import java.util.concurrent.CopyOnWriteArrayList;
import p000.RunnableC0006a5;
import p000.av2;
import p000.bm2;
import p000.ge2;
import p000.o12;

/* loaded from: classes.dex */
public final class SphericalGLSurfaceView extends GLSurfaceView {

    /* renamed from: l */
    public static final /* synthetic */ int f12897l = 0;

    /* renamed from: a */
    public final CopyOnWriteArrayList f12898a;

    /* renamed from: b */
    public final SensorManager f12899b;

    /* renamed from: c */
    public final Sensor f12900c;

    /* renamed from: d */
    public final o12 f12901d;

    /* renamed from: e */
    public final Handler f12902e;

    /* renamed from: f */
    public final ge2 f12903f;

    /* renamed from: g */
    public SurfaceTexture f12904g;

    /* renamed from: h */
    public Surface f12905h;

    /* renamed from: i */
    public boolean f12906i;

    /* renamed from: j */
    public boolean f12907j;

    /* renamed from: k */
    public boolean f12908k;

    /* loaded from: classes.dex */
    public interface VideoSurfaceListener {
        void onVideoSurfaceCreated(Surface surface);

        void onVideoSurfaceDestroyed(Surface surface);
    }

    public SphericalGLSurfaceView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final void m3065a() {
        boolean z;
        if (this.f12906i && this.f12907j) {
            z = true;
        } else {
            z = false;
        }
        Sensor sensor = this.f12900c;
        if (sensor != null && z != this.f12908k) {
            o12 o12Var = this.f12901d;
            SensorManager sensorManager = this.f12899b;
            if (z) {
                sensorManager.registerListener(o12Var, sensor, 0);
            } else {
                sensorManager.unregisterListener(o12Var);
            }
            this.f12908k = z;
        }
    }

    public void addVideoSurfaceListener(VideoSurfaceListener videoSurfaceListener) {
        this.f12898a.add(videoSurfaceListener);
    }

    public CameraMotionListener getCameraMotionListener() {
        return this.f12903f;
    }

    public VideoFrameMetadataListener getVideoFrameMetadataListener() {
        return this.f12903f;
    }

    @Nullable
    public Surface getVideoSurface() {
        return this.f12905h;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f12902e.post(new RunnableC0006a5(28, this));
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.f12907j = false;
        m3065a();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.f12907j = true;
        m3065a();
    }

    public void removeVideoSurfaceListener(VideoSurfaceListener videoSurfaceListener) {
        this.f12898a.remove(videoSurfaceListener);
    }

    public void setDefaultStereoMode(int i) {
        this.f12903f.f17674k = i;
    }

    public void setUseSensorRotation(boolean z) {
        this.f12906i = z;
        m3065a();
    }

    public SphericalGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12898a = new CopyOnWriteArrayList();
        this.f12902e = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) Assertions.checkNotNull(context.getSystemService("sensor"));
        this.f12899b = sensorManager;
        Sensor defaultSensor = Util.SDK_INT >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.f12900c = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        ge2 ge2Var = new ge2();
        this.f12903f = ge2Var;
        bm2 bm2Var = new bm2(this, ge2Var);
        View.OnTouchListener av2Var = new av2(context, bm2Var);
        this.f12901d = new o12(((WindowManager) Assertions.checkNotNull((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), av2Var, bm2Var);
        this.f12906i = true;
        setEGLContextClientVersion(2);
        setRenderer(bm2Var);
        setOnTouchListener(av2Var);
    }
}
