package p000;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.extractor.p002ts.TsExtractor;
import com.google.android.exoplayer2.video.spherical.OrientationListener$Listener;

/* loaded from: classes.dex */
public final class o12 implements SensorEventListener {

    /* renamed from: a */
    public final float[] f23566a = new float[16];

    /* renamed from: b */
    public final float[] f23567b = new float[16];

    /* renamed from: c */
    public final float[] f23568c = new float[16];

    /* renamed from: d */
    public final float[] f23569d = new float[3];

    /* renamed from: e */
    public final Display f23570e;

    /* renamed from: f */
    public final OrientationListener$Listener[] f23571f;

    /* renamed from: g */
    public boolean f23572g;

    public o12(Display display, OrientationListener$Listener... orientationListener$ListenerArr) {
        this.f23570e = display;
        this.f23571f = orientationListener$ListenerArr;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i;
        float[] fArr = sensorEvent.values;
        float[] fArr2 = this.f23566a;
        SensorManager.getRotationMatrixFromVector(fArr2, fArr);
        int rotation = this.f23570e.getRotation();
        float[] fArr3 = this.f23567b;
        if (rotation != 0) {
            int i2 = TsExtractor.TS_STREAM_TYPE_AC3;
            if (rotation != 1) {
                i = TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
                if (rotation != 2) {
                    if (rotation == 3) {
                        i2 = 130;
                        i = 1;
                    } else {
                        throw new IllegalStateException();
                    }
                }
            } else {
                i = 129;
                i2 = 2;
            }
            System.arraycopy(fArr2, 0, fArr3, 0, fArr3.length);
            SensorManager.remapCoordinateSystem(fArr3, i2, i, fArr2);
        }
        SensorManager.remapCoordinateSystem(fArr2, 1, 131, fArr3);
        float[] fArr4 = this.f23569d;
        SensorManager.getOrientation(fArr3, fArr4);
        float f = fArr4[2];
        Matrix.rotateM(fArr2, 0, 90.0f, 1.0f, RecyclerView.f7068F0, RecyclerView.f7068F0);
        boolean z = this.f23572g;
        float[] fArr5 = this.f23568c;
        if (!z) {
            uu0.m7770a(fArr5, fArr2);
            this.f23572g = true;
        }
        System.arraycopy(fArr2, 0, fArr3, 0, fArr3.length);
        Matrix.multiplyMM(fArr2, 0, fArr3, 0, fArr5, 0);
        OrientationListener$Listener[] orientationListener$ListenerArr = this.f23571f;
        for (int i3 = 0; i3 < 2; i3++) {
            orientationListener$ListenerArr[i3].onOrientationChange(fArr2, f);
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
