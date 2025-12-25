package p000;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.decoder.VideoDecoderOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.GlProgram;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
public final class f23 implements GLSurfaceView.Renderer {

    /* renamed from: k */
    public static final float[] f17096k = {1.164f, 1.164f, 1.164f, RecyclerView.f7068F0, -0.392f, 2.017f, 1.596f, -0.813f, RecyclerView.f7068F0};

    /* renamed from: l */
    public static final float[] f17097l = {1.164f, 1.164f, 1.164f, RecyclerView.f7068F0, -0.213f, 2.112f, 1.793f, -0.533f, RecyclerView.f7068F0};

    /* renamed from: m */
    public static final float[] f17098m = {1.168f, 1.168f, 1.168f, RecyclerView.f7068F0, -0.188f, 2.148f, 1.683f, -0.652f, RecyclerView.f7068F0};

    /* renamed from: n */
    public static final String[] f17099n = {"y_tex", "u_tex", "v_tex"};

    /* renamed from: o */
    public static final FloatBuffer f17100o = GlUtil.createBuffer(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});

    /* renamed from: a */
    public final VideoDecoderGLSurfaceView f17101a;

    /* renamed from: b */
    public final int[] f17102b = new int[3];

    /* renamed from: c */
    public final int[] f17103c = new int[3];

    /* renamed from: d */
    public final int[] f17104d = new int[3];

    /* renamed from: e */
    public final int[] f17105e = new int[3];

    /* renamed from: f */
    public final AtomicReference f17106f = new AtomicReference();

    /* renamed from: g */
    public final FloatBuffer[] f17107g = new FloatBuffer[3];

    /* renamed from: h */
    public GlProgram f17108h;

    /* renamed from: i */
    public int f17109i;

    /* renamed from: j */
    public VideoDecoderOutputBuffer f17110j;

    public f23(VideoDecoderGLSurfaceView videoDecoderGLSurfaceView) {
        this.f17101a = videoDecoderGLSurfaceView;
        for (int i = 0; i < 3; i++) {
            int[] iArr = this.f17104d;
            this.f17105e[i] = -1;
            iArr[i] = -1;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        boolean z;
        VideoDecoderOutputBuffer videoDecoderOutputBuffer = (VideoDecoderOutputBuffer) this.f17106f.getAndSet(null);
        if (videoDecoderOutputBuffer == null && this.f17110j == null) {
            return;
        }
        if (videoDecoderOutputBuffer != null) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = this.f17110j;
            if (videoDecoderOutputBuffer2 != null) {
                videoDecoderOutputBuffer2.release();
            }
            this.f17110j = videoDecoderOutputBuffer;
        }
        VideoDecoderOutputBuffer videoDecoderOutputBuffer3 = (VideoDecoderOutputBuffer) Assertions.checkNotNull(this.f17110j);
        float[] fArr = f17097l;
        int i = videoDecoderOutputBuffer3.colorspace;
        if (i != 1) {
            if (i == 3) {
                fArr = f17098m;
            }
        } else {
            fArr = f17096k;
        }
        GLES20.glUniformMatrix3fv(this.f17109i, 1, false, fArr, 0);
        int[] iArr = (int[]) Assertions.checkNotNull(videoDecoderOutputBuffer3.yuvStrides);
        ByteBuffer[] byteBufferArr = (ByteBuffer[]) Assertions.checkNotNull(videoDecoderOutputBuffer3.yuvPlanes);
        for (int i2 = 0; i2 < 3; i2++) {
            int i3 = videoDecoderOutputBuffer3.height;
            if (i2 != 0) {
                i3 = (i3 + 1) / 2;
            }
            int i4 = i3;
            GLES20.glActiveTexture(33984 + i2);
            GLES20.glBindTexture(3553, this.f17102b[i2]);
            GLES20.glPixelStorei(3317, 1);
            GLES20.glTexImage2D(3553, 0, 6409, iArr[i2], i4, 0, 6409, 5121, byteBufferArr[i2]);
        }
        int i5 = videoDecoderOutputBuffer3.width;
        int i6 = (i5 + 1) / 2;
        int[] iArr2 = {i5, i6, i6};
        for (int i7 = 0; i7 < 3; i7++) {
            int[] iArr3 = this.f17104d;
            int i8 = iArr3[i7];
            int i9 = iArr2[i7];
            int[] iArr4 = this.f17105e;
            if (i8 != i9 || iArr4[i7] != iArr[i7]) {
                if (iArr[i7] != 0) {
                    z = true;
                } else {
                    z = false;
                }
                Assertions.checkState(z);
                float f = iArr2[i7] / iArr[i7];
                FloatBuffer createBuffer = GlUtil.createBuffer(new float[]{RecyclerView.f7068F0, RecyclerView.f7068F0, RecyclerView.f7068F0, 1.0f, f, RecyclerView.f7068F0, f, 1.0f});
                FloatBuffer[] floatBufferArr = this.f17107g;
                floatBufferArr[i7] = createBuffer;
                GLES20.glVertexAttribPointer(this.f17103c[i7], 2, 5126, false, 0, (Buffer) floatBufferArr[i7]);
                iArr3[i7] = iArr2[i7];
                iArr4[i7] = iArr[i7];
            }
        }
        GLES20.glClear(16384);
        GLES20.glDrawArrays(5, 0, 4);
        GlUtil.checkGlError();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GlProgram glProgram = new GlProgram("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
        this.f17108h = glProgram;
        GLES20.glVertexAttribPointer(glProgram.getAttributeArrayLocationAndEnable("in_pos"), 2, 5126, false, 0, (Buffer) f17100o);
        int attributeArrayLocationAndEnable = this.f17108h.getAttributeArrayLocationAndEnable("in_tc_y");
        int[] iArr = this.f17103c;
        iArr[0] = attributeArrayLocationAndEnable;
        iArr[1] = this.f17108h.getAttributeArrayLocationAndEnable("in_tc_u");
        iArr[2] = this.f17108h.getAttributeArrayLocationAndEnable("in_tc_v");
        this.f17109i = this.f17108h.getUniformLocation("mColorConversion");
        GlUtil.checkGlError();
        int[] iArr2 = this.f17102b;
        GLES20.glGenTextures(3, iArr2, 0);
        for (int i = 0; i < 3; i++) {
            GLES20.glUniform1i(this.f17108h.getUniformLocation(f17099n[i]), i);
            GLES20.glActiveTexture(33984 + i);
            GlUtil.bindTexture(3553, iArr2[i]);
        }
        GlUtil.checkGlError();
        GlUtil.checkGlError();
    }
}
