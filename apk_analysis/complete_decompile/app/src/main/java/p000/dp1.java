package p000;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionPaths;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class dp1 implements Comparable {

    /* renamed from: b */
    public int f16469b;

    /* renamed from: a */
    public float f16468a = 1.0f;

    /* renamed from: c */
    public float f16470c = RecyclerView.f7068F0;

    /* renamed from: d */
    public float f16471d = RecyclerView.f7068F0;

    /* renamed from: e */
    public float f16472e = RecyclerView.f7068F0;

    /* renamed from: f */
    public float f16473f = 1.0f;

    /* renamed from: g */
    public float f16474g = 1.0f;

    /* renamed from: h */
    public float f16475h = Float.NaN;

    /* renamed from: i */
    public float f16476i = Float.NaN;

    /* renamed from: j */
    public float f16477j = RecyclerView.f7068F0;

    /* renamed from: k */
    public float f16478k = RecyclerView.f7068F0;

    /* renamed from: l */
    public float f16479l = RecyclerView.f7068F0;

    /* renamed from: m */
    public final LinkedHashMap f16480m = new LinkedHashMap();

    /* renamed from: c */
    public static boolean m4598c(float f, float f2) {
        if (!Float.isNaN(f) && !Float.isNaN(f2)) {
            if (Math.abs(f - f2) <= 1.0E-6f) {
                return false;
            }
            return true;
        }
        if (Float.isNaN(f) == Float.isNaN(f2)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0028. Please report as an issue. */
    /* renamed from: a */
    public final void m4599a(HashMap hashMap, int i) {
        for (String str : hashMap.keySet()) {
            SplineSet splineSet = (SplineSet) hashMap.get(str);
            str.getClass();
            float f = 1.0f;
            float f2 = Float.NaN;
            float f3 = RecyclerView.f7068F0;
            char c = 65535;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals("rotationX")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1249320805:
                    if (str.equals("rotationY")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1249320804:
                    if (str.equals("rotationZ")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1225497657:
                    if (str.equals("translationX")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1225497656:
                    if (str.equals("translationY")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1225497655:
                    if (str.equals("translationZ")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        c = 6;
                        break;
                    }
                    break;
                case -987906986:
                    if (str.equals("pivotX")) {
                        c = 7;
                        break;
                    }
                    break;
                case -987906985:
                    if (str.equals("pivotY")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals("alpha")) {
                        c = 11;
                        break;
                    }
                    break;
                case 803192288:
                    if (str.equals("pathRotate")) {
                        c = '\f';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (!Float.isNaN(this.f16471d)) {
                        f3 = this.f16471d;
                    }
                    splineSet.setPoint(i, f3);
                    break;
                case 1:
                    if (!Float.isNaN(this.f16472e)) {
                        f3 = this.f16472e;
                    }
                    splineSet.setPoint(i, f3);
                    break;
                case 2:
                    if (!Float.isNaN(this.f16470c)) {
                        f3 = this.f16470c;
                    }
                    splineSet.setPoint(i, f3);
                    break;
                case 3:
                    if (!Float.isNaN(this.f16477j)) {
                        f3 = this.f16477j;
                    }
                    splineSet.setPoint(i, f3);
                    break;
                case 4:
                    if (!Float.isNaN(this.f16478k)) {
                        f3 = this.f16478k;
                    }
                    splineSet.setPoint(i, f3);
                    break;
                case 5:
                    if (!Float.isNaN(this.f16479l)) {
                        f3 = this.f16479l;
                    }
                    splineSet.setPoint(i, f3);
                    break;
                case 6:
                    if (Float.isNaN(Float.NaN)) {
                        f2 = 0.0f;
                    }
                    splineSet.setPoint(i, f2);
                    break;
                case 7:
                    if (!Float.isNaN(this.f16475h)) {
                        f3 = this.f16475h;
                    }
                    splineSet.setPoint(i, f3);
                    break;
                case '\b':
                    if (!Float.isNaN(this.f16476i)) {
                        f3 = this.f16476i;
                    }
                    splineSet.setPoint(i, f3);
                    break;
                case '\t':
                    if (!Float.isNaN(this.f16473f)) {
                        f = this.f16473f;
                    }
                    splineSet.setPoint(i, f);
                    break;
                case '\n':
                    if (!Float.isNaN(this.f16474g)) {
                        f = this.f16474g;
                    }
                    splineSet.setPoint(i, f);
                    break;
                case 11:
                    if (!Float.isNaN(this.f16468a)) {
                        f = this.f16468a;
                    }
                    splineSet.setPoint(i, f);
                    break;
                case '\f':
                    if (Float.isNaN(Float.NaN)) {
                        f2 = 0.0f;
                    }
                    splineSet.setPoint(i, f2);
                    break;
                default:
                    if (str.startsWith("CUSTOM")) {
                        String str2 = str.split(",")[1];
                        LinkedHashMap linkedHashMap = this.f16480m;
                        if (linkedHashMap.containsKey(str2)) {
                            CustomVariable customVariable = (CustomVariable) linkedHashMap.get(str2);
                            if (splineSet instanceof SplineSet.CustomSpline) {
                                ((SplineSet.CustomSpline) splineSet).setPoint(i, customVariable);
                                break;
                            } else {
                                Utils.loge(MotionPaths.TAG, str + " ViewSpline not a CustomSet frame = " + i + ", value" + customVariable.getValueToInterpolate() + splineSet);
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        Utils.loge(MotionPaths.TAG, "UNKNOWN spline ".concat(str));
                        break;
                    }
            }
        }
    }

    /* renamed from: b */
    public final void m4600b(MotionWidget motionWidget) {
        float alpha;
        this.f16469b = motionWidget.getVisibility();
        if (motionWidget.getVisibility() != 4) {
            alpha = RecyclerView.f7068F0;
        } else {
            alpha = motionWidget.getAlpha();
        }
        this.f16468a = alpha;
        this.f16470c = motionWidget.getRotationZ();
        this.f16471d = motionWidget.getRotationX();
        this.f16472e = motionWidget.getRotationY();
        this.f16473f = motionWidget.getScaleX();
        this.f16474g = motionWidget.getScaleY();
        this.f16475h = motionWidget.getPivotX();
        this.f16476i = motionWidget.getPivotY();
        this.f16477j = motionWidget.getTranslationX();
        this.f16478k = motionWidget.getTranslationY();
        this.f16479l = motionWidget.getTranslationZ();
        for (String str : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(str);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.f16480m.put(str, customAttribute);
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        ((dp1) obj).getClass();
        return Float.compare(RecyclerView.f7068F0, RecyclerView.f7068F0);
    }
}
