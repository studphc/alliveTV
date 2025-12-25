package p000;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.graphics.PathParser;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class l13 {

    /* renamed from: p */
    public static final Matrix f22283p = new Matrix();

    /* renamed from: a */
    public final Path f22284a;

    /* renamed from: b */
    public final Path f22285b;

    /* renamed from: c */
    public final Matrix f22286c;

    /* renamed from: d */
    public Paint f22287d;

    /* renamed from: e */
    public Paint f22288e;

    /* renamed from: f */
    public PathMeasure f22289f;

    /* renamed from: g */
    public final i13 f22290g;

    /* renamed from: h */
    public float f22291h;

    /* renamed from: i */
    public float f22292i;

    /* renamed from: j */
    public float f22293j;

    /* renamed from: k */
    public float f22294k;

    /* renamed from: l */
    public int f22295l;

    /* renamed from: m */
    public String f22296m;

    /* renamed from: n */
    public Boolean f22297n;

    /* renamed from: o */
    public final ArrayMap f22298o;

    public l13() {
        this.f22286c = new Matrix();
        this.f22291h = RecyclerView.f7068F0;
        this.f22292i = RecyclerView.f7068F0;
        this.f22293j = RecyclerView.f7068F0;
        this.f22294k = RecyclerView.f7068F0;
        this.f22295l = 255;
        this.f22296m = null;
        this.f22297n = null;
        this.f22298o = new ArrayMap();
        this.f22290g = new i13();
        this.f22284a = new Path();
        this.f22285b = new Path();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00e6, code lost:
    
        if (r0.f17927j != 1.0f) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5816a(i13 i13Var, Matrix matrix, Canvas canvas, int i, int i2) {
        Matrix matrix2;
        int i3;
        float f;
        float f2;
        float f3;
        Path.FillType fillType;
        Path.FillType fillType2;
        int i4 = 1;
        i13Var.f18256a.set(matrix);
        Matrix matrix3 = i13Var.f18265j;
        Matrix matrix4 = i13Var.f18256a;
        matrix4.preConcat(matrix3);
        canvas.save();
        ?? r11 = 0;
        int i5 = 0;
        while (true) {
            ArrayList arrayList = i13Var.f18257b;
            if (i5 < arrayList.size()) {
                j13 j13Var = (j13) arrayList.get(i5);
                if (j13Var instanceof i13) {
                    m5816a((i13) j13Var, matrix4, canvas, i, i2);
                    i3 = i4;
                    matrix2 = matrix4;
                } else if (j13Var instanceof k13) {
                    k13 k13Var = (k13) j13Var;
                    float f4 = i / this.f22293j;
                    float f5 = i2 / this.f22294k;
                    float min = Math.min(f4, f5);
                    Matrix matrix5 = this.f22286c;
                    matrix5.set(matrix4);
                    matrix5.postScale(f4, f5);
                    float[] fArr = {RecyclerView.f7068F0, 1.0f, 1.0f, RecyclerView.f7068F0};
                    matrix4.mapVectors(fArr);
                    float hypot = (float) Math.hypot(fArr[r11], fArr[i4]);
                    matrix2 = matrix4;
                    float hypot2 = (float) Math.hypot(fArr[2], fArr[3]);
                    float f6 = (fArr[r11] * fArr[3]) - (fArr[1] * fArr[2]);
                    float max = Math.max(hypot, hypot2);
                    if (max > RecyclerView.f7068F0) {
                        f = Math.abs(f6) / max;
                    } else {
                        f = 0.0f;
                    }
                    if (f != RecyclerView.f7068F0) {
                        k13Var.getClass();
                        Path path = this.f22284a;
                        path.reset();
                        PathParser.PathDataNode[] pathDataNodeArr = k13Var.f20718a;
                        if (pathDataNodeArr != null) {
                            PathParser.PathDataNode.nodesToPath(pathDataNodeArr, path);
                        }
                        Path path2 = this.f22285b;
                        path2.reset();
                        if (k13Var instanceof g13) {
                            if (k13Var.f20720c == 0) {
                                fillType2 = Path.FillType.WINDING;
                            } else {
                                fillType2 = Path.FillType.EVEN_ODD;
                            }
                            path2.setFillType(fillType2);
                            path2.addPath(path, matrix5);
                            canvas.clipPath(path2);
                        } else {
                            h13 h13Var = (h13) k13Var;
                            float f7 = h13Var.f17926i;
                            if (f7 == RecyclerView.f7068F0) {
                                f2 = 1.0f;
                            } else {
                                f2 = 1.0f;
                            }
                            float f8 = h13Var.f17928k;
                            float f9 = (f7 + f8) % f2;
                            float f10 = (h13Var.f17927j + f8) % f2;
                            if (this.f22289f == null) {
                                this.f22289f = new PathMeasure();
                            }
                            this.f22289f.setPath(path, r11);
                            float length = this.f22289f.getLength();
                            float f11 = f9 * length;
                            float f12 = f10 * length;
                            path.reset();
                            if (f11 > f12) {
                                this.f22289f.getSegment(f11, length, path, true);
                                PathMeasure pathMeasure = this.f22289f;
                                f3 = RecyclerView.f7068F0;
                                pathMeasure.getSegment(RecyclerView.f7068F0, f12, path, true);
                            } else {
                                f3 = RecyclerView.f7068F0;
                                this.f22289f.getSegment(f11, f12, path, true);
                            }
                            path.rLineTo(f3, f3);
                            path2.addPath(path, matrix5);
                            if (h13Var.f17923f.willDraw()) {
                                ComplexColorCompat complexColorCompat = h13Var.f17923f;
                                if (this.f22288e == null) {
                                    Paint paint = new Paint(1);
                                    this.f22288e = paint;
                                    paint.setStyle(Paint.Style.FILL);
                                }
                                Paint paint2 = this.f22288e;
                                if (complexColorCompat.isGradient()) {
                                    Shader shader = complexColorCompat.getShader();
                                    shader.setLocalMatrix(matrix5);
                                    paint2.setShader(shader);
                                    paint2.setAlpha(Math.round(h13Var.f17925h * 255.0f));
                                } else {
                                    paint2.setShader(null);
                                    paint2.setAlpha(255);
                                    int color = complexColorCompat.getColor();
                                    float f13 = h13Var.f17925h;
                                    PorterDuff.Mode mode = VectorDrawableCompat.f7557j;
                                    paint2.setColor((color & ViewCompat.MEASURED_SIZE_MASK) | (((int) (Color.alpha(color) * f13)) << 24));
                                }
                                paint2.setColorFilter(null);
                                if (h13Var.f20720c == 0) {
                                    fillType = Path.FillType.WINDING;
                                } else {
                                    fillType = Path.FillType.EVEN_ODD;
                                }
                                path2.setFillType(fillType);
                                canvas.drawPath(path2, paint2);
                            }
                            if (h13Var.f17921d.willDraw()) {
                                ComplexColorCompat complexColorCompat2 = h13Var.f17921d;
                                if (this.f22287d == null) {
                                    Paint paint3 = new Paint(1);
                                    this.f22287d = paint3;
                                    paint3.setStyle(Paint.Style.STROKE);
                                }
                                Paint paint4 = this.f22287d;
                                Paint.Join join = h13Var.f17930m;
                                if (join != null) {
                                    paint4.setStrokeJoin(join);
                                }
                                Paint.Cap cap = h13Var.f17929l;
                                if (cap != null) {
                                    paint4.setStrokeCap(cap);
                                }
                                paint4.setStrokeMiter(h13Var.f17931n);
                                if (complexColorCompat2.isGradient()) {
                                    Shader shader2 = complexColorCompat2.getShader();
                                    shader2.setLocalMatrix(matrix5);
                                    paint4.setShader(shader2);
                                    paint4.setAlpha(Math.round(h13Var.f17924g * 255.0f));
                                } else {
                                    paint4.setShader(null);
                                    paint4.setAlpha(255);
                                    int color2 = complexColorCompat2.getColor();
                                    float f14 = h13Var.f17924g;
                                    PorterDuff.Mode mode2 = VectorDrawableCompat.f7557j;
                                    paint4.setColor((color2 & ViewCompat.MEASURED_SIZE_MASK) | (((int) (Color.alpha(color2) * f14)) << 24));
                                }
                                paint4.setColorFilter(null);
                                paint4.setStrokeWidth(h13Var.f17922e * min * f);
                                canvas.drawPath(path2, paint4);
                            }
                        }
                    }
                    i3 = 1;
                } else {
                    matrix2 = matrix4;
                    i3 = i4;
                }
                i5 += i3;
                i4 = i3;
                matrix4 = matrix2;
                r11 = 0;
            } else {
                canvas.restore();
                return;
            }
        }
    }

    public float getAlpha() {
        return getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.f22295l;
    }

    public void setAlpha(float f) {
        setRootAlpha((int) (f * 255.0f));
    }

    public void setRootAlpha(int i) {
        this.f22295l = i;
    }

    public l13(l13 l13Var) {
        this.f22286c = new Matrix();
        this.f22291h = RecyclerView.f7068F0;
        this.f22292i = RecyclerView.f7068F0;
        this.f22293j = RecyclerView.f7068F0;
        this.f22294k = RecyclerView.f7068F0;
        this.f22295l = 255;
        this.f22296m = null;
        this.f22297n = null;
        ArrayMap arrayMap = new ArrayMap();
        this.f22298o = arrayMap;
        this.f22290g = new i13(l13Var.f22290g, arrayMap);
        this.f22284a = new Path(l13Var.f22284a);
        this.f22285b = new Path(l13Var.f22285b);
        this.f22291h = l13Var.f22291h;
        this.f22292i = l13Var.f22292i;
        this.f22293j = l13Var.f22293j;
        this.f22294k = l13Var.f22294k;
        this.f22295l = l13Var.f22295l;
        this.f22296m = l13Var.f22296m;
        String str = l13Var.f22296m;
        if (str != null) {
            arrayMap.put(str, this);
        }
        this.f22297n = l13Var.f22297n;
    }
}
