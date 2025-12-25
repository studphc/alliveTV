package p000;

import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.video.spherical.OrientationListener$Listener;
import com.google.android.exoplayer2.video.spherical.Projection$SubMesh;
import com.google.android.exoplayer2.video.spherical.SphericalGLSurfaceView;
import com.google.android.exoplayer2.video.spherical.TouchTracker$Listener;
import java.nio.Buffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
public final class bm2 implements GLSurfaceView.Renderer, TouchTracker$Listener, OrientationListener$Listener {

    /* renamed from: a */
    public final ge2 f8085a;

    /* renamed from: d */
    public final float[] f8088d;

    /* renamed from: e */
    public final float[] f8089e;

    /* renamed from: f */
    public final float[] f8090f;

    /* renamed from: g */
    public float f8091g;

    /* renamed from: h */
    public float f8092h;

    /* renamed from: k */
    public final /* synthetic */ SphericalGLSurfaceView f8095k;

    /* renamed from: b */
    public final float[] f8086b = new float[16];

    /* renamed from: c */
    public final float[] f8087c = new float[16];

    /* renamed from: i */
    public final float[] f8093i = new float[16];

    /* renamed from: j */
    public final float[] f8094j = new float[16];

    public bm2(SphericalGLSurfaceView sphericalGLSurfaceView, ge2 ge2Var) {
        this.f8095k = sphericalGLSurfaceView;
        float[] fArr = new float[16];
        this.f8088d = fArr;
        float[] fArr2 = new float[16];
        this.f8089e = fArr2;
        float[] fArr3 = new float[16];
        this.f8090f = fArr3;
        this.f8085a = ge2Var;
        Matrix.setIdentityM(fArr, 0);
        Matrix.setIdentityM(fArr2, 0);
        Matrix.setIdentityM(fArr3, 0);
        this.f8092h = 3.1415927f;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        float[] fArr;
        synchronized (this) {
            Matrix.multiplyMM(this.f8094j, 0, this.f8088d, 0, this.f8090f, 0);
            Matrix.multiplyMM(this.f8093i, 0, this.f8089e, 0, this.f8094j, 0);
        }
        Matrix.multiplyMM(this.f8087c, 0, this.f8086b, 0, this.f8093i, 0);
        ge2 ge2Var = this.f8085a;
        float[] fArr2 = this.f8087c;
        GLES20.glClear(16384);
        GlUtil.checkGlError();
        boolean compareAndSet = ge2Var.f17664a.compareAndSet(true, false);
        un1 un1Var = ge2Var.f17666c;
        if (compareAndSet) {
            ((SurfaceTexture) Assertions.checkNotNull(ge2Var.f17673j)).updateTexImage();
            GlUtil.checkGlError();
            if (ge2Var.f17665b.compareAndSet(true, false)) {
                Matrix.setIdentityM(ge2Var.f17670g, 0);
            }
            long timestamp = ge2Var.f17673j.getTimestamp();
            Long l = (Long) ge2Var.f17668e.poll(timestamp);
            if (l != null) {
                long longValue = l.longValue();
                uu0 uu0Var = ge2Var.f17667d;
                float[] fArr3 = (float[]) uu0Var.f27449c.pollFloor(longValue);
                if (fArr3 != null) {
                    float f = fArr3[0];
                    float f2 = -fArr3[1];
                    float f3 = -fArr3[2];
                    float length = Matrix.length(f, f2, f3);
                    float[] fArr4 = uu0Var.f27448b;
                    if (length != RecyclerView.f7068F0) {
                        Matrix.setRotateM(fArr4, 0, (float) Math.toDegrees(length), f / length, f2 / length, f3 / length);
                    } else {
                        Matrix.setIdentityM(fArr4, 0);
                    }
                    if (!uu0Var.f27450d) {
                        uu0.m7770a(uu0Var.f27447a, uu0Var.f27448b);
                        uu0Var.f27450d = true;
                    }
                    Matrix.multiplyMM(ge2Var.f17670g, 0, uu0Var.f27447a, 0, uu0Var.f27448b, 0);
                }
            }
            a82 a82Var = (a82) ge2Var.f17669f.pollFloor(timestamp);
            if (a82Var != null) {
                un1Var.getClass();
                if (un1.m7756a(a82Var)) {
                    un1Var.f27386a = a82Var.f81c;
                    un1Var.f27392g = new fa0(a82Var.f79a.getSubMesh(0));
                    if (!a82Var.f82d) {
                        Projection$SubMesh subMesh = a82Var.f80b.getSubMesh(0);
                        subMesh.getVertexCount();
                        GlUtil.createBuffer(subMesh.vertices);
                        GlUtil.createBuffer(subMesh.textureCoords);
                    }
                }
            }
        }
        Matrix.multiplyMM(ge2Var.f17671h, 0, fArr2, 0, ge2Var.f17670g, 0);
        int i = ge2Var.f17672i;
        fa0 fa0Var = (fa0) un1Var.f27392g;
        if (fa0Var != null) {
            int i2 = un1Var.f27386a;
            if (i2 == 1) {
                fArr = un1.f27384l;
            } else if (i2 == 2) {
                fArr = un1.f27385m;
            } else {
                fArr = un1.f27383k;
            }
            GLES20.glUniformMatrix3fv(un1Var.f27388c, 1, false, fArr, 0);
            GLES20.glUniformMatrix4fv(un1Var.f27387b, 1, false, ge2Var.f17671h, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i);
            GLES20.glUniform1i(un1Var.f27391f, 0);
            GlUtil.checkGlError();
            GLES20.glVertexAttribPointer(un1Var.f27389d, 3, 5126, false, 12, (Buffer) fa0Var.f17187a);
            GlUtil.checkGlError();
            GLES20.glVertexAttribPointer(un1Var.f27390e, 2, 5126, false, 8, (Buffer) fa0Var.f17190d);
            GlUtil.checkGlError();
            GLES20.glDrawArrays(fa0Var.f17189c, 0, fa0Var.f17188b);
            GlUtil.checkGlError();
        }
    }

    @Override // com.google.android.exoplayer2.video.spherical.OrientationListener$Listener
    public final synchronized void onOrientationChange(float[] fArr, float f) {
        float[] fArr2 = this.f8088d;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        float f2 = -f;
        this.f8092h = f2;
        Matrix.setRotateM(this.f8089e, 0, -this.f8091g, (float) Math.cos(f2), (float) Math.sin(this.f8092h), RecyclerView.f7068F0);
    }

    @Override // com.google.android.exoplayer2.video.spherical.TouchTracker$Listener
    public final synchronized void onScrollChange(PointF pointF) {
        float f = pointF.y;
        this.f8091g = f;
        Matrix.setRotateM(this.f8089e, 0, -f, (float) Math.cos(this.f8092h), (float) Math.sin(this.f8092h), RecyclerView.f7068F0);
        Matrix.setRotateM(this.f8090f, 0, -pointF.x, RecyclerView.f7068F0, 1.0f, RecyclerView.f7068F0);
    }

    @Override // com.google.android.exoplayer2.video.spherical.TouchTracker$Listener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f8095k.performClick();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f;
        GLES20.glViewport(0, 0, i, i2);
        float f2 = i / i2;
        if (f2 > 1.0f) {
            f = (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / f2)) * 2.0d);
        } else {
            f = 90.0f;
        }
        Matrix.perspectiveM(this.f8086b, 0, f, f2, 0.1f, 100.0f);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        SphericalGLSurfaceView sphericalGLSurfaceView = this.f8095k;
        sphericalGLSurfaceView.f12902e.post(new wg2(1, sphericalGLSurfaceView, this.f8085a.m4940a()));
    }
}
