package p000;

import android.opengl.Matrix;
import com.google.android.exoplayer2.util.TimedValueQueue;

/* loaded from: classes.dex */
public final class uu0 {

    /* renamed from: a */
    public final float[] f27447a = new float[16];

    /* renamed from: b */
    public final float[] f27448b = new float[16];

    /* renamed from: c */
    public final TimedValueQueue f27449c = new TimedValueQueue();

    /* renamed from: d */
    public boolean f27450d;

    /* renamed from: a */
    public static void m7770a(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float f = fArr2[10];
        float f2 = fArr2[8];
        float sqrt = (float) Math.sqrt((f2 * f2) + (f * f));
        float f3 = fArr2[10] / sqrt;
        fArr[0] = f3;
        float f4 = fArr2[8];
        fArr[2] = f4 / sqrt;
        fArr[8] = (-f4) / sqrt;
        fArr[10] = f3;
    }
}
