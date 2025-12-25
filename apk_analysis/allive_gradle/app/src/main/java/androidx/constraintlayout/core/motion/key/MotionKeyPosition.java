package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.HashSet;
import p000.qy2;

/* loaded from: classes.dex */
public class MotionKeyPosition extends MotionKey {
    protected static final float SELECTION_SLOPE = 20.0f;
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;

    /* renamed from: a */
    public float f2147a;

    /* renamed from: b */
    public float f2148b;
    public float mAltPercentX;
    public float mAltPercentY;
    public int mCurveFit;
    public int mDrawPath;
    public int mPathMotionArc;
    public float mPercentHeight;
    public float mPercentWidth;
    public float mPercentX;
    public float mPercentY;
    public int mPositionType;
    public String mTransitionEasing;

    public MotionKeyPosition() {
        int i = MotionKey.UNSET;
        this.mCurveFit = i;
        this.mTransitionEasing = null;
        this.mPathMotionArc = i;
        this.mDrawPath = 0;
        this.mPercentWidth = Float.NaN;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = Float.NaN;
        this.mPercentY = Float.NaN;
        this.mAltPercentX = Float.NaN;
        this.mAltPercentY = Float.NaN;
        this.mPositionType = 0;
        this.f2147a = Float.NaN;
        this.f2148b = Float.NaN;
        this.mType = 2;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKey copy(MotionKey motionKey) {
        super.copy(motionKey);
        MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
        this.mTransitionEasing = motionKeyPosition.mTransitionEasing;
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mPercentWidth = motionKeyPosition.mPercentWidth;
        this.mPercentHeight = Float.NaN;
        this.mPercentX = motionKeyPosition.mPercentX;
        this.mPercentY = motionKeyPosition.mPercentY;
        this.mAltPercentX = motionKeyPosition.mAltPercentX;
        this.mAltPercentY = motionKeyPosition.mAltPercentY;
        this.f2147a = motionKeyPosition.f2147a;
        this.f2148b = motionKeyPosition.f2148b;
        return this;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> hashSet) {
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        return qy2.m7153a(str);
    }

    public boolean intersects(int i, int i2, FloatRect floatRect, FloatRect floatRect2, float f, float f2) {
        float f3;
        float f4;
        float f5;
        float centerX = floatRect.centerX();
        float centerY = floatRect.centerY();
        float centerX2 = floatRect2.centerX();
        float centerY2 = floatRect2.centerY();
        int i3 = this.mPositionType;
        if (i3 != 1) {
            if (i3 != 2) {
                float f6 = centerX2 - centerX;
                float f7 = centerY2 - centerY;
                boolean isNaN = Float.isNaN(this.mPercentX);
                float f8 = RecyclerView.f7068F0;
                if (isNaN) {
                    f3 = 0.0f;
                } else {
                    f3 = this.mPercentX;
                }
                if (Float.isNaN(this.mAltPercentY)) {
                    f4 = 0.0f;
                } else {
                    f4 = this.mAltPercentY;
                }
                if (Float.isNaN(this.mPercentY)) {
                    f5 = 0.0f;
                } else {
                    f5 = this.mPercentY;
                }
                if (!Float.isNaN(this.mAltPercentX)) {
                    f8 = this.mAltPercentX;
                }
                this.f2147a = (int) ((f8 * f7) + (f3 * f6) + centerX);
                this.f2148b = (int) ((f7 * f5) + (f6 * f4) + centerY);
            } else {
                float f9 = this.mPercentX;
                float f10 = 0;
                this.f2147a = (i * f9) + f10;
                this.f2148b = (i2 * f9) + f10;
            }
        } else {
            float f11 = centerX2 - centerX;
            float f12 = centerY2 - centerY;
            float f13 = this.mPercentX;
            float f14 = (f11 * f13) + centerX;
            float f15 = this.mPercentY;
            this.f2147a = ((-f12) * f15) + f14;
            this.f2148b = (f11 * f15) + (f12 * f13) + centerY;
        }
        if (Math.abs(f - this.f2147a) >= SELECTION_SLOPE || Math.abs(f2 - this.f2148b) >= SELECTION_SLOPE) {
            return false;
        }
        return true;
    }

    public void positionAttributes(MotionWidget motionWidget, FloatRect floatRect, FloatRect floatRect2, float f, float f2, String[] strArr, float[] fArr) {
        int i = this.mPositionType;
        if (i != 1) {
            if (i != 2) {
                float centerX = floatRect.centerX();
                float centerY = floatRect.centerY();
                float centerX2 = floatRect2.centerX() - centerX;
                float centerY2 = floatRect2.centerY() - centerY;
                String str = strArr[0];
                if (str != null) {
                    if ("percentX".equals(str)) {
                        fArr[0] = (f - centerX) / centerX2;
                        fArr[1] = (f2 - centerY) / centerY2;
                        return;
                    } else {
                        fArr[1] = (f - centerX) / centerX2;
                        fArr[0] = (f2 - centerY) / centerY2;
                        return;
                    }
                }
                strArr[0] = "percentX";
                fArr[0] = (f - centerX) / centerX2;
                strArr[1] = "percentY";
                fArr[1] = (f2 - centerY) / centerY2;
                return;
            }
            floatRect.centerX();
            floatRect.centerY();
            floatRect2.centerX();
            floatRect2.centerY();
            MotionWidget parent = motionWidget.getParent();
            int width = parent.getWidth();
            int height = parent.getHeight();
            String str2 = strArr[0];
            if (str2 != null) {
                if ("percentX".equals(str2)) {
                    fArr[0] = f / width;
                    fArr[1] = f2 / height;
                    return;
                } else {
                    fArr[1] = f / width;
                    fArr[0] = f2 / height;
                    return;
                }
            }
            strArr[0] = "percentX";
            fArr[0] = f / width;
            strArr[1] = "percentY";
            fArr[1] = f2 / height;
            return;
        }
        float centerX3 = floatRect.centerX();
        float centerY3 = floatRect.centerY();
        float centerX4 = floatRect2.centerX() - centerX3;
        float centerY4 = floatRect2.centerY() - centerY3;
        float hypot = (float) Math.hypot(centerX4, centerY4);
        if (hypot < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f3 = centerX4 / hypot;
        float f4 = centerY4 / hypot;
        float f5 = f2 - centerY3;
        float f6 = f - centerX3;
        float f7 = ((f3 * f5) - (f6 * f4)) / hypot;
        float f8 = ((f4 * f5) + (f3 * f6)) / hypot;
        String str3 = strArr[0];
        if (str3 != null) {
            if ("percentX".equals(str3)) {
                fArr[0] = f8;
                fArr[1] = f7;
                return;
            }
            return;
        }
        strArr[0] = "percentX";
        strArr[1] = "percentY";
        fArr[0] = f8;
        fArr[1] = f7;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i2) {
        if (i == 100) {
            this.mFramePosition = i2;
            return true;
        }
        if (i == 508) {
            this.mCurveFit = i2;
            return true;
        }
        if (i != 510) {
            return super.setValue(i, i2);
        }
        this.mPositionType = i2;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* renamed from: clone */
    public MotionKey mo8474clone() {
        return new MotionKeyPosition().copy(this);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        switch (i) {
            case 503:
                this.mPercentWidth = f;
                return true;
            case 504:
                this.mPercentHeight = f;
                return true;
            case 505:
                this.mPercentWidth = f;
                this.mPercentHeight = f;
                return true;
            case 506:
                this.mPercentX = f;
                return true;
            case 507:
                this.mPercentY = f;
                return true;
            default:
                return super.setValue(i, f);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (i != 501) {
            return super.setValue(i, str);
        }
        this.mTransitionEasing = str.toString();
        return true;
    }
}
