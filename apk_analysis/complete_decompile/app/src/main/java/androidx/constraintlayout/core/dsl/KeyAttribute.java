package androidx.constraintlayout.core.dsl;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: classes.dex */
public class KeyAttribute extends Keys {

    /* renamed from: a */
    public String f1943a;

    /* renamed from: b */
    public final int f1944b;

    /* renamed from: c */
    public String f1945c;
    protected String TYPE = TypedValues.AttributesType.NAME;

    /* renamed from: d */
    public Fit f1946d = null;

    /* renamed from: e */
    public Visibility f1947e = null;

    /* renamed from: f */
    public float f1948f = Float.NaN;

    /* renamed from: g */
    public float f1949g = Float.NaN;

    /* renamed from: h */
    public float f1950h = Float.NaN;

    /* renamed from: i */
    public float f1951i = Float.NaN;

    /* renamed from: j */
    public float f1952j = Float.NaN;

    /* renamed from: k */
    public float f1953k = Float.NaN;

    /* renamed from: l */
    public float f1954l = Float.NaN;

    /* renamed from: m */
    public float f1955m = Float.NaN;

    /* renamed from: n */
    public float f1956n = Float.NaN;

    /* renamed from: o */
    public float f1957o = Float.NaN;

    /* renamed from: p */
    public float f1958p = Float.NaN;

    /* renamed from: q */
    public float f1959q = Float.NaN;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes.dex */
    public static final class Fit {
        public static final Fit LINEAR;
        public static final Fit SPLINE;

        /* renamed from: a */
        public static final /* synthetic */ Fit[] f1960a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.KeyAttribute$Fit] */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.KeyAttribute$Fit] */
        static {
            ?? r2 = new Enum("SPLINE", 0);
            SPLINE = r2;
            ?? r3 = new Enum("LINEAR", 1);
            LINEAR = r3;
            f1960a = new Fit[]{r2, r3};
        }

        public static Fit valueOf(String str) {
            return (Fit) Enum.valueOf(Fit.class, str);
        }

        public static Fit[] values() {
            return (Fit[]) f1960a.clone();
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
        public static final /* synthetic */ Visibility[] f1961a;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.KeyAttribute$Visibility] */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.KeyAttribute$Visibility] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, androidx.constraintlayout.core.dsl.KeyAttribute$Visibility] */
        static {
            ?? r3 = new Enum("VISIBLE", 0);
            VISIBLE = r3;
            ?? r4 = new Enum("INVISIBLE", 1);
            INVISIBLE = r4;
            ?? r5 = new Enum("GONE", 2);
            GONE = r5;
            f1961a = new Visibility[]{r3, r4, r5};
        }

        public static Visibility valueOf(String str) {
            return (Visibility) Enum.valueOf(Visibility.class, str);
        }

        public static Visibility[] values() {
            return (Visibility[]) f1961a.clone();
        }
    }

    public KeyAttribute(int i, String str) {
        this.f1943a = str;
        this.f1944b = i;
    }

    public void attributesToString(StringBuilder sb) {
        append(sb, TypedValues.AttributesType.S_TARGET, this.f1943a);
        sb.append("frame:");
        sb.append(this.f1944b);
        sb.append(",\n");
        append(sb, "easing", this.f1945c);
        if (this.f1946d != null) {
            sb.append("fit:'");
            sb.append(this.f1946d);
            sb.append("',\n");
        }
        if (this.f1947e != null) {
            sb.append("visibility:'");
            sb.append(this.f1947e);
            sb.append("',\n");
        }
        append(sb, "alpha", this.f1948f);
        append(sb, "rotationX", this.f1950h);
        append(sb, "rotationY", this.f1951i);
        append(sb, "rotationZ", this.f1949g);
        append(sb, "pivotX", this.f1952j);
        append(sb, "pivotY", this.f1953k);
        append(sb, "pathRotate", this.f1954l);
        append(sb, "scaleX", this.f1955m);
        append(sb, "scaleY", this.f1956n);
        append(sb, "translationX", this.f1957o);
        append(sb, "translationY", this.f1958p);
        append(sb, "translationZ", this.f1959q);
    }

    public float getAlpha() {
        return this.f1948f;
    }

    public Fit getCurveFit() {
        return this.f1946d;
    }

    public float getPivotX() {
        return this.f1952j;
    }

    public float getPivotY() {
        return this.f1953k;
    }

    public float getRotation() {
        return this.f1949g;
    }

    public float getRotationX() {
        return this.f1950h;
    }

    public float getRotationY() {
        return this.f1951i;
    }

    public float getScaleX() {
        return this.f1955m;
    }

    public float getScaleY() {
        return this.f1956n;
    }

    public String getTarget() {
        return this.f1943a;
    }

    public String getTransitionEasing() {
        return this.f1945c;
    }

    public float getTransitionPathRotate() {
        return this.f1954l;
    }

    public float getTranslationX() {
        return this.f1957o;
    }

    public float getTranslationY() {
        return this.f1958p;
    }

    public float getTranslationZ() {
        return this.f1959q;
    }

    public Visibility getVisibility() {
        return this.f1947e;
    }

    public void setAlpha(float f) {
        this.f1948f = f;
    }

    public void setCurveFit(Fit fit) {
        this.f1946d = fit;
    }

    public void setPivotX(float f) {
        this.f1952j = f;
    }

    public void setPivotY(float f) {
        this.f1953k = f;
    }

    public void setRotation(float f) {
        this.f1949g = f;
    }

    public void setRotationX(float f) {
        this.f1950h = f;
    }

    public void setRotationY(float f) {
        this.f1951i = f;
    }

    public void setScaleX(float f) {
        this.f1955m = f;
    }

    public void setScaleY(float f) {
        this.f1956n = f;
    }

    public void setTarget(String str) {
        this.f1943a = str;
    }

    public void setTransitionEasing(String str) {
        this.f1945c = str;
    }

    public void setTransitionPathRotate(float f) {
        this.f1954l = f;
    }

    public void setTranslationX(float f) {
        this.f1957o = f;
    }

    public void setTranslationY(float f) {
        this.f1958p = f;
    }

    public void setTranslationZ(float f) {
        this.f1959q = f;
    }

    public void setVisibility(Visibility visibility) {
        this.f1947e = visibility;
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
