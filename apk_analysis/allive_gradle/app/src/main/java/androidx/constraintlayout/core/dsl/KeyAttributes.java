package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Arrays;

/* loaded from: classes.dex */
public class KeyAttributes extends Keys {
    protected String TYPE;

    /* renamed from: a */
    public String[] f1962a;

    /* renamed from: b */
    public String f1963b;

    /* renamed from: c */
    public Fit f1964c;

    /* renamed from: d */
    public Visibility[] f1965d;

    /* renamed from: e */
    public float[] f1966e;

    /* renamed from: f */
    public float[] f1967f;

    /* renamed from: g */
    public float[] f1968g;

    /* renamed from: h */
    public float[] f1969h;

    /* renamed from: i */
    public float[] f1970i;

    /* renamed from: j */
    public float[] f1971j;

    /* renamed from: k */
    public float[] f1972k;

    /* renamed from: l */
    public float[] f1973l;

    /* renamed from: m */
    public float[] f1974m;

    /* renamed from: n */
    public float[] f1975n;

    /* renamed from: o */
    public float[] f1976o;

    /* renamed from: p */
    public float[] f1977p;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Fit {
        public static final Fit LINEAR;
        public static final Fit SPLINE;

        /* renamed from: a */
        public static final /* synthetic */ Fit[] f1978a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [androidx.constraintlayout.core.dsl.KeyAttributes$Fit, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r3v1, types: [androidx.constraintlayout.core.dsl.KeyAttributes$Fit, java.lang.Enum] */
        static {
            ?? r2 = new Enum("SPLINE", 0);
            SPLINE = r2;
            ?? r3 = new Enum("LINEAR", 1);
            LINEAR = r3;
            f1978a = new Fit[]{r2, r3};
        }

        public static Fit valueOf(String str) {
            return (Fit) Enum.valueOf(Fit.class, str);
        }

        public static Fit[] values() {
            return (Fit[]) f1978a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Visibility {
        public static final Visibility GONE;
        public static final Visibility INVISIBLE;
        public static final Visibility VISIBLE;

        /* renamed from: a */
        public static final /* synthetic */ Visibility[] f1979a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [androidx.constraintlayout.core.dsl.KeyAttributes$Visibility, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r4v1, types: [androidx.constraintlayout.core.dsl.KeyAttributes$Visibility, java.lang.Enum] */
        /* JADX WARN: Type inference failed for: r5v1, types: [androidx.constraintlayout.core.dsl.KeyAttributes$Visibility, java.lang.Enum] */
        static {
            ?? r3 = new Enum("VISIBLE", 0);
            VISIBLE = r3;
            ?? r4 = new Enum("INVISIBLE", 1);
            INVISIBLE = r4;
            ?? r5 = new Enum("GONE", 2);
            GONE = r5;
            f1979a = new Visibility[]{r3, r4, r5};
        }

        public static Visibility valueOf(String str) {
            return (Visibility) Enum.valueOf(Visibility.class, str);
        }

        public static Visibility[] values() {
            return (Visibility[]) f1979a.clone();
        }
    }

    public void attributesToString(StringBuilder sb) {
        append(sb, TypedValues.AttributesType.S_TARGET, this.f1962a);
        sb.append("frame:");
        sb.append(Arrays.toString((int[]) null));
        sb.append(",\n");
        append(sb, "easing", this.f1963b);
        if (this.f1964c != null) {
            sb.append("fit:'");
            sb.append(this.f1964c);
            sb.append("',\n");
        }
        if (this.f1965d != null) {
            sb.append("visibility:'");
            sb.append(Arrays.toString(this.f1965d));
            sb.append("',\n");
        }
        append(sb, "alpha", this.f1966e);
        append(sb, "rotationX", this.f1968g);
        append(sb, "rotationY", this.f1969h);
        append(sb, "rotationZ", this.f1967f);
        append(sb, "pivotX", this.f1970i);
        append(sb, "pivotY", this.f1971j);
        append(sb, "pathRotate", this.f1972k);
        append(sb, "scaleX", this.f1973l);
        append(sb, "scaleY", this.f1974m);
        append(sb, "translationX", this.f1975n);
        append(sb, "translationY", this.f1976o);
        append(sb, "translationZ", this.f1977p);
    }

    public float[] getAlpha() {
        return this.f1966e;
    }

    public Fit getCurveFit() {
        return this.f1964c;
    }

    public float[] getPivotX() {
        return this.f1970i;
    }

    public float[] getPivotY() {
        return this.f1971j;
    }

    public float[] getRotation() {
        return this.f1967f;
    }

    public float[] getRotationX() {
        return this.f1968g;
    }

    public float[] getRotationY() {
        return this.f1969h;
    }

    public float[] getScaleX() {
        return this.f1973l;
    }

    public float[] getScaleY() {
        return this.f1974m;
    }

    public String[] getTarget() {
        return this.f1962a;
    }

    public String getTransitionEasing() {
        return this.f1963b;
    }

    public float[] getTransitionPathRotate() {
        return this.f1972k;
    }

    public float[] getTranslationX() {
        return this.f1975n;
    }

    public float[] getTranslationY() {
        return this.f1976o;
    }

    public float[] getTranslationZ() {
        return this.f1977p;
    }

    public Visibility[] getVisibility() {
        return this.f1965d;
    }

    public void setAlpha(float... fArr) {
        this.f1966e = fArr;
    }

    public void setCurveFit(Fit fit) {
        this.f1964c = fit;
    }

    public void setPivotX(float... fArr) {
        this.f1970i = fArr;
    }

    public void setPivotY(float... fArr) {
        this.f1971j = fArr;
    }

    public void setRotation(float... fArr) {
        this.f1967f = fArr;
    }

    public void setRotationX(float... fArr) {
        this.f1968g = fArr;
    }

    public void setRotationY(float... fArr) {
        this.f1969h = fArr;
    }

    public void setScaleX(float[] fArr) {
        this.f1973l = fArr;
    }

    public void setScaleY(float[] fArr) {
        this.f1974m = fArr;
    }

    public void setTarget(String[] strArr) {
        this.f1962a = strArr;
    }

    public void setTransitionEasing(String str) {
        this.f1963b = str;
    }

    public void setTransitionPathRotate(float... fArr) {
        this.f1972k = fArr;
    }

    public void setTranslationX(float[] fArr) {
        this.f1975n = fArr;
    }

    public void setTranslationY(float[] fArr) {
        this.f1976o = fArr;
    }

    public void setTranslationZ(float[] fArr) {
        this.f1977p = fArr;
    }

    public void setVisibility(Visibility... visibilityArr) {
        this.f1965d = visibilityArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.TYPE);
        sb.append(":{\n");
        attributesToString(sb);
        sb.append("},\n");
        return sb.toString();
    }
}
