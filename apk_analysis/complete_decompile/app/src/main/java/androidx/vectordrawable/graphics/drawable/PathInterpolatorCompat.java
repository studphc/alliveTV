package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.recyclerview.widget.RecyclerView;
import org.xmlpull.v1.XmlPullParser;
import p000.AbstractC1726qj;
import p000.yy2;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class PathInterpolatorCompat implements Interpolator {
    public static final double EPSILON = 1.0E-5d;
    public static final int MAX_NUM_POINTS = 3000;

    /* renamed from: a */
    public float[] f7555a;

    /* renamed from: b */
    public float[] f7556b;

    public PathInterpolatorCompat(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    /* renamed from: a */
    public final void m1917a(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(MAX_NUM_POINTS, ((int) (length / 0.002f)) + 1);
        if (min > 0) {
            this.f7555a = new float[min];
            this.f7556b = new float[min];
            float[] fArr = new float[2];
            for (int i2 = 0; i2 < min; i2++) {
                pathMeasure.getPosTan((i2 * length) / (min - 1), fArr, null);
                this.f7555a[i2] = fArr[0];
                this.f7556b[i2] = fArr[1];
            }
            if (Math.abs(this.f7555a[0]) <= 1.0E-5d && Math.abs(this.f7556b[0]) <= 1.0E-5d) {
                int i3 = min - 1;
                if (Math.abs(this.f7555a[i3] - 1.0f) <= 1.0E-5d && Math.abs(this.f7556b[i3] - 1.0f) <= 1.0E-5d) {
                    float f = RecyclerView.f7068F0;
                    int i4 = 0;
                    while (i < min) {
                        float[] fArr2 = this.f7555a;
                        int i5 = i4 + 1;
                        float f2 = fArr2[i4];
                        if (f2 >= f) {
                            fArr2[i] = f2;
                            i++;
                            f = f2;
                            i4 = i5;
                        } else {
                            throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f2);
                        }
                    }
                    if (!pathMeasure.nextContour()) {
                        return;
                    } else {
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                }
            }
            StringBuilder sb = new StringBuilder("The Path must start at (0,0) and end at (1,1) start: ");
            sb.append(this.f7555a[0]);
            sb.append(",");
            sb.append(this.f7556b[0]);
            sb.append(" end:");
            int i6 = min - 1;
            sb.append(this.f7555a[i6]);
            sb.append(",");
            sb.append(this.f7556b[i6]);
            throw new IllegalArgumentException(sb.toString());
        }
        throw new IllegalArgumentException("The Path has a invalid length " + length);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= RecyclerView.f7068F0) {
            return RecyclerView.f7068F0;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.f7555a.length - 1;
        int i = 0;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f7555a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.f7555a;
        float f2 = fArr[length];
        float f3 = fArr[i];
        float f4 = f2 - f3;
        if (f4 == RecyclerView.f7068F0) {
            return this.f7556b[i];
        }
        float f5 = (f - f3) / f4;
        float[] fArr2 = this.f7556b;
        float f6 = fArr2[i];
        return AbstractC1726qj.m7051g(fArr2[length], f6, f5, f6);
    }

    public PathInterpolatorCompat(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, yy2.f29188l);
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
            String namedString = TypedArrayUtils.getNamedString(obtainAttributes, xmlPullParser, "pathData", 4);
            Path createPathFromPathData = PathParser.createPathFromPathData(namedString);
            if (createPathFromPathData != null) {
                m1917a(createPathFromPathData);
            } else {
                throw new InflateException(AbstractC1726qj.m7038C("The path is null, which is created from ", namedString));
            }
        } else if (TypedArrayUtils.hasAttribute(xmlPullParser, "controlX1")) {
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "controlY1")) {
                float namedFloat = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "controlX1", 0, RecyclerView.f7068F0);
                float namedFloat2 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "controlY1", 1, RecyclerView.f7068F0);
                boolean hasAttribute = TypedArrayUtils.hasAttribute(xmlPullParser, "controlX2");
                if (hasAttribute != TypedArrayUtils.hasAttribute(xmlPullParser, "controlY2")) {
                    throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
                }
                if (!hasAttribute) {
                    Path path = new Path();
                    path.moveTo(RecyclerView.f7068F0, RecyclerView.f7068F0);
                    path.quadTo(namedFloat, namedFloat2, 1.0f, 1.0f);
                    m1917a(path);
                } else {
                    float namedFloat3 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "controlX2", 2, RecyclerView.f7068F0);
                    float namedFloat4 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "controlY2", 3, RecyclerView.f7068F0);
                    Path path2 = new Path();
                    path2.moveTo(RecyclerView.f7068F0, RecyclerView.f7068F0);
                    path2.cubicTo(namedFloat, namedFloat2, namedFloat3, namedFloat4, 1.0f, 1.0f);
                    m1917a(path2);
                }
            } else {
                throw new InflateException("pathInterpolator requires the controlY1 attribute");
            }
        } else {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
        obtainAttributes.recycle();
    }
}
