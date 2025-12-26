package p000;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class b21 {

    /* renamed from: a */
    public final float[] f7863a = new float[20];

    /* renamed from: b */
    public final ColorMatrix f7864b = new ColorMatrix();

    /* renamed from: c */
    public final ColorMatrix f7865c = new ColorMatrix();

    /* renamed from: d */
    public float f7866d = 1.0f;

    /* renamed from: e */
    public float f7867e = 1.0f;

    /* renamed from: f */
    public float f7868f = 1.0f;

    /* renamed from: g */
    public float f7869g = 1.0f;

    /* renamed from: a */
    public final void m2005a(ImageView imageView) {
        boolean z;
        float[] fArr;
        float log;
        float f;
        float f2;
        float f3;
        ColorMatrix colorMatrix = this.f7864b;
        colorMatrix.reset();
        float f4 = this.f7867e;
        float f5 = 1.0f;
        float[] fArr2 = this.f7863a;
        boolean z2 = true;
        if (f4 != 1.0f) {
            float f6 = 1.0f - f4;
            float f7 = 0.2999f * f6;
            float f8 = 0.587f * f6;
            float f9 = f6 * 0.114f;
            fArr2[0] = f7 + f4;
            fArr2[1] = f8;
            fArr2[2] = f9;
            fArr2[3] = 0.0f;
            fArr2[4] = 0.0f;
            fArr2[5] = f7;
            fArr2[6] = f8 + f4;
            fArr2[7] = f9;
            fArr2[8] = 0.0f;
            fArr2[9] = 0.0f;
            fArr2[10] = f7;
            fArr2[11] = f8;
            fArr2[12] = f9 + f4;
            fArr2[13] = 0.0f;
            fArr2[14] = 0.0f;
            fArr2[15] = 0.0f;
            fArr2[16] = 0.0f;
            fArr2[17] = 0.0f;
            fArr2[18] = 1.0f;
            fArr2[19] = 0.0f;
            colorMatrix.set(fArr2);
            z = true;
        } else {
            z = false;
        }
        float f10 = this.f7868f;
        ColorMatrix colorMatrix2 = this.f7865c;
        if (f10 != 1.0f) {
            colorMatrix2.setScale(f10, f10, f10, 1.0f);
            colorMatrix.postConcat(colorMatrix2);
            z = true;
        }
        float f11 = this.f7869g;
        if (f11 != 1.0f) {
            if (f11 <= RecyclerView.f7068F0) {
                f11 = 0.01f;
            }
            float f12 = (5000.0f / f11) / 100.0f;
            if (f12 > 66.0f) {
                double d = f12 - 60.0f;
                f = ((float) Math.pow(d, -0.13320475816726685d)) * 329.69873f;
                log = ((float) Math.pow(d, 0.07551485300064087d)) * 288.12216f;
            } else {
                log = (((float) Math.log(f12)) * 99.4708f) - 161.11957f;
                f = 255.0f;
            }
            if (f12 < 66.0f) {
                if (f12 > 19.0f) {
                    f2 = log;
                    f3 = (((float) Math.log(f12 - 10.0f)) * 138.51773f) - 305.0448f;
                } else {
                    f2 = log;
                    f3 = 0.0f;
                }
            } else {
                f2 = log;
                f3 = 255.0f;
            }
            float min = Math.min(255.0f, Math.max(f, RecyclerView.f7068F0));
            float min2 = Math.min(255.0f, Math.max(f2, RecyclerView.f7068F0));
            float min3 = Math.min(255.0f, Math.max(f3, RecyclerView.f7068F0));
            float log2 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float log3 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float min4 = Math.min(255.0f, Math.max(255.0f, RecyclerView.f7068F0));
            float min5 = Math.min(255.0f, Math.max(log2, RecyclerView.f7068F0));
            float min6 = min3 / Math.min(255.0f, Math.max(log3, RecyclerView.f7068F0));
            fArr2[0] = min / min4;
            fArr2[1] = 0.0f;
            fArr2[2] = 0.0f;
            fArr2[3] = 0.0f;
            fArr2[4] = 0.0f;
            fArr2[5] = 0.0f;
            fArr2[6] = min2 / min5;
            fArr2[7] = 0.0f;
            fArr2[8] = 0.0f;
            fArr2[9] = 0.0f;
            fArr2[10] = 0.0f;
            fArr2[11] = 0.0f;
            fArr2[12] = min6;
            fArr2[13] = 0.0f;
            fArr2[14] = 0.0f;
            fArr2[15] = 0.0f;
            fArr2[16] = 0.0f;
            fArr2[17] = 0.0f;
            f5 = 1.0f;
            fArr2[18] = 1.0f;
            fArr2[19] = 0.0f;
            fArr = fArr2;
            colorMatrix2.set(fArr);
            colorMatrix.postConcat(colorMatrix2);
            z = true;
        } else {
            fArr = fArr2;
        }
        float f13 = this.f7866d;
        if (f13 != f5) {
            fArr[0] = f13;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f13;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f13;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
            colorMatrix2.set(fArr);
            colorMatrix.postConcat(colorMatrix2);
        } else {
            z2 = z;
        }
        if (z2) {
            imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        } else {
            imageView.clearColorFilter();
        }
    }
}
