package p000;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.MotionPaths;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class cp1 implements Comparable {

    /* renamed from: c */
    public int f16048c;

    /* renamed from: a */
    public float f16046a = RecyclerView.f7068F0;

    /* renamed from: b */
    public int f16047b = 0;

    /* renamed from: d */
    public final LinkedHashMap f16049d = new LinkedHashMap();

    /* renamed from: e */
    public float f16050e = 1.0f;

    /* renamed from: f */
    public float f16051f = RecyclerView.f7068F0;

    /* renamed from: g */
    public float f16052g = RecyclerView.f7068F0;

    /* renamed from: h */
    public float f16053h = RecyclerView.f7068F0;

    /* renamed from: i */
    public float f16054i = 1.0f;

    /* renamed from: j */
    public float f16055j = 1.0f;

    /* renamed from: k */
    public float f16056k = Float.NaN;

    /* renamed from: l */
    public float f16057l = Float.NaN;

    /* renamed from: m */
    public float f16058m = RecyclerView.f7068F0;

    /* renamed from: n */
    public float f16059n = RecyclerView.f7068F0;

    /* renamed from: o */
    public float f16060o = RecyclerView.f7068F0;

    /* renamed from: p */
    public float f16061p = Float.NaN;

    /* renamed from: q */
    public float f16062q = Float.NaN;

    /* renamed from: c */
    public static boolean m4482c(float f, float f2) {
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

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0029. Please report as an issue. */
    /* renamed from: a */
    public final void m4483a(HashMap hashMap, int i) {
        for (String str : hashMap.keySet()) {
            ViewSpline viewSpline = (ViewSpline) hashMap.get(str);
            if (viewSpline != null) {
                str.getClass();
                float f = 1.0f;
                float f2 = RecyclerView.f7068F0;
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
                    case -1225497657:
                        if (str.equals("translationX")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1225497656:
                        if (str.equals("translationY")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -1225497655:
                        if (str.equals("translationZ")) {
                            c = 4;
                            break;
                        }
                        break;
                    case -1001078227:
                        if (str.equals("progress")) {
                            c = 5;
                            break;
                        }
                        break;
                    case -908189618:
                        if (str.equals("scaleX")) {
                            c = 6;
                            break;
                        }
                        break;
                    case -908189617:
                        if (str.equals("scaleY")) {
                            c = 7;
                            break;
                        }
                        break;
                    case -760884510:
                        if (str.equals(Key.PIVOT_X)) {
                            c = '\b';
                            break;
                        }
                        break;
                    case -760884509:
                        if (str.equals(Key.PIVOT_Y)) {
                            c = '\t';
                            break;
                        }
                        break;
                    case -40300674:
                        if (str.equals(Key.ROTATION)) {
                            c = '\n';
                            break;
                        }
                        break;
                    case -4379043:
                        if (str.equals("elevation")) {
                            c = 11;
                            break;
                        }
                        break;
                    case 37232917:
                        if (str.equals("transitionPathRotate")) {
                            c = '\f';
                            break;
                        }
                        break;
                    case 92909918:
                        if (str.equals("alpha")) {
                            c = '\r';
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        if (!Float.isNaN(this.f16053h)) {
                            f2 = this.f16053h;
                        }
                        viewSpline.setPoint(i, f2);
                        break;
                    case 1:
                        if (!Float.isNaN(this.f16046a)) {
                            f2 = this.f16046a;
                        }
                        viewSpline.setPoint(i, f2);
                        break;
                    case 2:
                        if (!Float.isNaN(this.f16058m)) {
                            f2 = this.f16058m;
                        }
                        viewSpline.setPoint(i, f2);
                        break;
                    case 3:
                        if (!Float.isNaN(this.f16059n)) {
                            f2 = this.f16059n;
                        }
                        viewSpline.setPoint(i, f2);
                        break;
                    case 4:
                        if (!Float.isNaN(this.f16060o)) {
                            f2 = this.f16060o;
                        }
                        viewSpline.setPoint(i, f2);
                        break;
                    case 5:
                        if (!Float.isNaN(this.f16062q)) {
                            f2 = this.f16062q;
                        }
                        viewSpline.setPoint(i, f2);
                        break;
                    case 6:
                        if (!Float.isNaN(this.f16054i)) {
                            f = this.f16054i;
                        }
                        viewSpline.setPoint(i, f);
                        break;
                    case 7:
                        if (!Float.isNaN(this.f16055j)) {
                            f = this.f16055j;
                        }
                        viewSpline.setPoint(i, f);
                        break;
                    case '\b':
                        if (!Float.isNaN(this.f16056k)) {
                            f2 = this.f16056k;
                        }
                        viewSpline.setPoint(i, f2);
                        break;
                    case '\t':
                        if (!Float.isNaN(this.f16057l)) {
                            f2 = this.f16057l;
                        }
                        viewSpline.setPoint(i, f2);
                        break;
                    case '\n':
                        if (!Float.isNaN(this.f16052g)) {
                            f2 = this.f16052g;
                        }
                        viewSpline.setPoint(i, f2);
                        break;
                    case 11:
                        if (!Float.isNaN(this.f16051f)) {
                            f2 = this.f16051f;
                        }
                        viewSpline.setPoint(i, f2);
                        break;
                    case '\f':
                        if (!Float.isNaN(this.f16061p)) {
                            f2 = this.f16061p;
                        }
                        viewSpline.setPoint(i, f2);
                        break;
                    case '\r':
                        if (!Float.isNaN(this.f16050e)) {
                            f = this.f16050e;
                        }
                        viewSpline.setPoint(i, f);
                        break;
                    default:
                        if (str.startsWith("CUSTOM")) {
                            String str2 = str.split(",")[1];
                            LinkedHashMap linkedHashMap = this.f16049d;
                            if (linkedHashMap.containsKey(str2)) {
                                ConstraintAttribute constraintAttribute = (ConstraintAttribute) linkedHashMap.get(str2);
                                if (viewSpline instanceof ViewSpline.CustomSet) {
                                    ((ViewSpline.CustomSet) viewSpline).setPoint(i, constraintAttribute);
                                    break;
                                } else {
                                    Log.e(MotionPaths.TAG, str + " ViewSpline not a CustomSet frame = " + i + ", value" + constraintAttribute.getValueToInterpolate() + viewSpline);
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            Log.e(MotionPaths.TAG, "UNKNOWN spline ".concat(str));
                            break;
                        }
                }
            }
        }
    }

    /* renamed from: b */
    public final void m4484b(View view) {
        float alpha;
        this.f16048c = view.getVisibility();
        if (view.getVisibility() != 0) {
            alpha = RecyclerView.f7068F0;
        } else {
            alpha = view.getAlpha();
        }
        this.f16050e = alpha;
        this.f16051f = view.getElevation();
        this.f16052g = view.getRotation();
        this.f16053h = view.getRotationX();
        this.f16046a = view.getRotationY();
        this.f16054i = view.getScaleX();
        this.f16055j = view.getScaleY();
        this.f16056k = view.getPivotX();
        this.f16057l = view.getPivotY();
        this.f16058m = view.getTranslationX();
        this.f16059n = view.getTranslationY();
        this.f16060o = view.getTranslationZ();
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        ((cp1) obj).getClass();
        return Float.compare(RecyclerView.f7068F0, RecyclerView.f7068F0);
    }

    /* renamed from: d */
    public final void m4485d(Rect rect, ConstraintSet constraintSet, int i, int i2) {
        float f;
        rect.width();
        rect.height();
        ConstraintSet.Constraint parameters = constraintSet.getParameters(i2);
        ConstraintSet.PropertySet propertySet = parameters.propertySet;
        int i3 = propertySet.mVisibilityMode;
        this.f16047b = i3;
        int i4 = propertySet.visibility;
        this.f16048c = i4;
        if (i4 != 0 && i3 == 0) {
            f = RecyclerView.f7068F0;
        } else {
            f = propertySet.alpha;
        }
        this.f16050e = f;
        ConstraintSet.Transform transform = parameters.transform;
        boolean z = transform.applyElevation;
        this.f16051f = transform.elevation;
        this.f16052g = transform.rotation;
        this.f16053h = transform.rotationX;
        this.f16046a = transform.rotationY;
        this.f16054i = transform.scaleX;
        this.f16055j = transform.scaleY;
        this.f16056k = transform.transformPivotX;
        this.f16057l = transform.transformPivotY;
        this.f16058m = transform.translationX;
        this.f16059n = transform.translationY;
        this.f16060o = transform.translationZ;
        Easing.getInterpolator(parameters.motion.mTransitionEasing);
        this.f16061p = parameters.motion.mPathRotate;
        this.f16062q = parameters.propertySet.mProgress;
        for (String str : parameters.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = parameters.mCustomConstraints.get(str);
            if (constraintAttribute.isContinuous()) {
                this.f16049d.put(str, constraintAttribute);
            }
        }
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                }
            }
            float f2 = this.f16052g + 90.0f;
            this.f16052g = f2;
            if (f2 > 180.0f) {
                this.f16052g = f2 - 360.0f;
                return;
            }
            return;
        }
        this.f16052g -= 90.0f;
    }
}
