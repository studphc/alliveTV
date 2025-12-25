package p000;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.GlProgram;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import com.google.android.exoplayer2.video.spherical.Projection$Mesh;
import com.google.android.exoplayer2.video.spherical.Projection$SubMesh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class ge2 implements VideoFrameMetadataListener, CameraMotionListener {

    /* renamed from: i */
    public int f17672i;

    /* renamed from: j */
    public SurfaceTexture f17673j;

    /* renamed from: m */
    public byte[] f17676m;

    /* renamed from: a */
    public final AtomicBoolean f17664a = new AtomicBoolean();

    /* renamed from: b */
    public final AtomicBoolean f17665b = new AtomicBoolean(true);

    /* renamed from: c */
    public final un1 f17666c = new Object();

    /* renamed from: d */
    public final uu0 f17667d = new uu0();

    /* renamed from: e */
    public final TimedValueQueue f17668e = new TimedValueQueue();

    /* renamed from: f */
    public final TimedValueQueue f17669f = new TimedValueQueue();

    /* renamed from: g */
    public final float[] f17670g = new float[16];

    /* renamed from: h */
    public final float[] f17671h = new float[16];

    /* renamed from: k */
    public volatile int f17674k = 0;

    /* renamed from: l */
    public int f17675l = -1;

    /* renamed from: a */
    public final SurfaceTexture m4940a() {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        GlUtil.checkGlError();
        un1 un1Var = this.f17666c;
        un1Var.getClass();
        GlProgram glProgram = new GlProgram("uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n", "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n");
        un1Var.f27393h = glProgram;
        un1Var.f27387b = glProgram.getUniformLocation("uMvpMatrix");
        un1Var.f27388c = ((GlProgram) un1Var.f27393h).getUniformLocation("uTexMatrix");
        un1Var.f27389d = ((GlProgram) un1Var.f27393h).getAttributeArrayLocationAndEnable("aPosition");
        un1Var.f27390e = ((GlProgram) un1Var.f27393h).getAttributeArrayLocationAndEnable("aTexCoords");
        un1Var.f27391f = ((GlProgram) un1Var.f27393h).getUniformLocation("uTexture");
        GlUtil.checkGlError();
        this.f17672i = GlUtil.createExternalTexture();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f17672i);
        this.f17673j = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: fe2
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                ge2.this.f17664a.set(true);
            }
        });
        return this.f17673j;
    }

    @Override // com.google.android.exoplayer2.video.spherical.CameraMotionListener
    public final void onCameraMotion(long j, float[] fArr) {
        this.f17667d.f27449c.add(j, fArr);
    }

    @Override // com.google.android.exoplayer2.video.spherical.CameraMotionListener
    public final void onCameraMotionReset() {
        this.f17668e.clear();
        uu0 uu0Var = this.f17667d;
        uu0Var.f27449c.clear();
        uu0Var.f27450d = false;
        this.f17665b.set(true);
    }

    @Override // com.google.android.exoplayer2.video.VideoFrameMetadataListener
    public final void onVideoFrameAboutToBeRendered(long j, long j2, Format format, MediaFormat mediaFormat) {
        float f;
        int i;
        int i2;
        int i3;
        int i4;
        ArrayList arrayList;
        int readInt;
        int i5 = 1;
        this.f17668e.add(j2, Long.valueOf(j));
        byte[] bArr = format.projectionData;
        int i6 = format.stereoMode;
        byte[] bArr2 = this.f17676m;
        int i7 = this.f17675l;
        this.f17676m = bArr;
        if (i6 == -1) {
            i6 = this.f17674k;
        }
        this.f17675l = i6;
        if (i7 != i6 || !Arrays.equals(bArr2, this.f17676m)) {
            byte[] bArr3 = this.f17676m;
            a82 a82Var = null;
            if (bArr3 != null) {
                int i8 = this.f17675l;
                ParsableByteArray parsableByteArray = new ParsableByteArray(bArr3);
                try {
                    parsableByteArray.skipBytes(4);
                    readInt = parsableByteArray.readInt();
                    parsableByteArray.setPosition(0);
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
                if (readInt == 1886547818) {
                    parsableByteArray.skipBytes(8);
                    int position = parsableByteArray.getPosition();
                    int limit = parsableByteArray.limit();
                    while (position < limit) {
                        int readInt2 = parsableByteArray.readInt() + position;
                        if (readInt2 <= position || readInt2 > limit) {
                            break;
                        }
                        int readInt3 = parsableByteArray.readInt();
                        if (readInt3 != 2037673328 && readInt3 != 1836279920) {
                            parsableByteArray.setPosition(readInt2);
                            position = readInt2;
                        }
                        parsableByteArray.setLimit(readInt2);
                        arrayList = yy2.m8337G(parsableByteArray);
                        break;
                    }
                    arrayList = null;
                } else {
                    arrayList = yy2.m8337G(parsableByteArray);
                }
                if (arrayList != null) {
                    int size = arrayList.size();
                    if (size != 1) {
                        if (size == 2) {
                            a82Var = new a82((Projection$Mesh) arrayList.get(0), (Projection$Mesh) arrayList.get(1), i8);
                        }
                    } else {
                        Projection$Mesh projection$Mesh = (Projection$Mesh) arrayList.get(0);
                        a82Var = new a82(projection$Mesh, projection$Mesh, i8);
                    }
                }
            }
            if (a82Var == null || !un1.m7756a(a82Var)) {
                int i9 = this.f17675l;
                Assertions.checkArgument(true);
                Assertions.checkArgument(true);
                Assertions.checkArgument(true);
                Assertions.checkArgument(true);
                Assertions.checkArgument(true);
                float radians = (float) Math.toRadians(180.0f);
                float radians2 = (float) Math.toRadians(360.0f);
                float f2 = radians / 36;
                float f3 = radians2 / 72;
                float[] fArr = new float[15984];
                float[] fArr2 = new float[10656];
                int i10 = 0;
                int i11 = 0;
                int i12 = 0;
                for (int i13 = 36; i10 < i13; i13 = 36) {
                    float f4 = radians / 2.0f;
                    float f5 = (i10 * f2) - f4;
                    int i14 = i10 + 1;
                    float f6 = (i14 * f2) - f4;
                    int i15 = 0;
                    while (i15 < 73) {
                        float f7 = f6;
                        float f8 = f5;
                        int i16 = i14;
                        int i17 = i11;
                        int i18 = i12;
                        int i19 = 0;
                        int i20 = 2;
                        while (i19 < i20) {
                            if (i19 == 0) {
                                f = f8;
                            } else {
                                f = f7;
                            }
                            float f9 = i15 * f3;
                            float f10 = f3;
                            int i21 = i15;
                            float f11 = radians;
                            double d = 50.0f;
                            int i22 = i9;
                            double d2 = (3.1415927f + f9) - (radians2 / 2.0f);
                            double d3 = f;
                            int i23 = i19;
                            float f12 = f2;
                            fArr[i17] = -((float) (Math.cos(d3) * Math.sin(d2) * d));
                            int i24 = i10;
                            float[] fArr3 = fArr2;
                            fArr[i17 + 1] = (float) (Math.sin(d3) * d);
                            int i25 = i17 + 3;
                            fArr[i17 + 2] = (float) (Math.cos(d3) * Math.cos(d2) * d);
                            fArr3[i18] = f9 / radians2;
                            int i26 = i18 + 2;
                            fArr3[i18 + 1] = ((i24 + i23) * f12) / f11;
                            if (i21 != 0 || i23 != 0) {
                                i = i21;
                                i2 = i23;
                                i3 = 3;
                                if (i != 72 || i2 != 1) {
                                    i4 = 2;
                                    i18 = i26;
                                    i17 = i25;
                                    int i27 = i2 + 1;
                                    i15 = i;
                                    fArr2 = fArr3;
                                    i20 = i4;
                                    f3 = f10;
                                    radians = f11;
                                    i9 = i22;
                                    i10 = i24;
                                    f2 = f12;
                                    i19 = i27;
                                }
                            } else {
                                i2 = i23;
                                i = i21;
                                i3 = 3;
                            }
                            System.arraycopy(fArr, i17, fArr, i25, i3);
                            i17 += 6;
                            i4 = 2;
                            System.arraycopy(fArr3, i18, fArr3, i26, 2);
                            i18 += 4;
                            int i272 = i2 + 1;
                            i15 = i;
                            fArr2 = fArr3;
                            i20 = i4;
                            f3 = f10;
                            radians = f11;
                            i9 = i22;
                            i10 = i24;
                            f2 = f12;
                            i19 = i272;
                        }
                        i15++;
                        i12 = i18;
                        i11 = i17;
                        f5 = f8;
                        i14 = i16;
                        radians = radians;
                        i9 = i9;
                        f2 = f2;
                        f6 = f7;
                    }
                    i10 = i14;
                    i5 = 1;
                }
                int i28 = i9;
                Projection$SubMesh[] projection$SubMeshArr = new Projection$SubMesh[i5];
                projection$SubMeshArr[0] = new Projection$SubMesh(0, fArr, fArr2, i5);
                Projection$Mesh projection$Mesh2 = new Projection$Mesh(projection$SubMeshArr);
                a82Var = new a82(projection$Mesh2, projection$Mesh2, i28);
            }
            this.f17669f.add(j2, a82Var);
        }
    }
}
