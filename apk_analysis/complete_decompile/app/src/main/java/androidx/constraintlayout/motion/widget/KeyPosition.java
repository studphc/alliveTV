package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import p000.i71;
import p000.j71;

/* loaded from: classes.dex */
public class KeyPosition extends j71 {
    public static final String DRAWPATH = "drawPath";
    public static final String PERCENT_HEIGHT = "percentHeight";
    public static final String PERCENT_WIDTH = "percentWidth";
    public static final String PERCENT_X = "percentX";
    public static final String PERCENT_Y = "percentY";
    public static final String SIZE_PERCENT = "sizePercent";
    public static final String TRANSITION_EASING = "transitionEasing";
    public static final int TYPE_AXIS = 3;
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;

    /* renamed from: f */
    public String f2740f;

    /* renamed from: g */
    public int f2741g;

    /* renamed from: h */
    public int f2742h;

    /* renamed from: i */
    public float f2743i;

    /* renamed from: j */
    public float f2744j;

    /* renamed from: k */
    public float f2745k;

    /* renamed from: l */
    public float f2746l;

    /* renamed from: m */
    public float f2747m;

    /* renamed from: n */
    public float f2748n;

    /* renamed from: o */
    public int f2749o;

    /* renamed from: p */
    public float f2750p;

    /* renamed from: q */
    public float f2751q;

    public KeyPosition() {
        this.f20396e = Key.UNSET;
        this.f2740f = null;
        this.f2741g = Key.UNSET;
        this.f2742h = 0;
        this.f2743i = Float.NaN;
        this.f2744j = Float.NaN;
        this.f2745k = Float.NaN;
        this.f2746l = Float.NaN;
        this.f2747m = Float.NaN;
        this.f2748n = Float.NaN;
        this.f2749o = 0;
        this.f2750p = Float.NaN;
        this.f2751q = Float.NaN;
        this.mType = 2;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> hashMap) {
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key key) {
        super.copy(key);
        KeyPosition keyPosition = (KeyPosition) key;
        this.f2740f = keyPosition.f2740f;
        this.f2741g = keyPosition.f2741g;
        this.f2742h = keyPosition.f2742h;
        this.f2743i = keyPosition.f2743i;
        this.f2744j = Float.NaN;
        this.f2745k = keyPosition.f2745k;
        this.f2746l = keyPosition.f2746l;
        this.f2747m = keyPosition.f2747m;
        this.f2748n = keyPosition.f2748n;
        this.f2750p = keyPosition.f2750p;
        this.f2751q = keyPosition.f2751q;
        return this;
    }

    @Override // p000.j71
    public boolean intersects(int i, int i2, RectF rectF, RectF rectF2, float f, float f2) {
        float f3;
        float f4;
        float f5;
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX();
        float centerY2 = rectF2.centerY();
        int i3 = this.f2749o;
        if (i3 != 1) {
            if (i3 != 2) {
                float f6 = centerX2 - centerX;
                float f7 = centerY2 - centerY;
                boolean isNaN = Float.isNaN(this.f2745k);
                float f8 = RecyclerView.f7068F0;
                if (isNaN) {
                    f3 = 0.0f;
                } else {
                    f3 = this.f2745k;
                }
                if (Float.isNaN(this.f2748n)) {
                    f4 = 0.0f;
                } else {
                    f4 = this.f2748n;
                }
                if (Float.isNaN(this.f2746l)) {
                    f5 = 0.0f;
                } else {
                    f5 = this.f2746l;
                }
                if (!Float.isNaN(this.f2747m)) {
                    f8 = this.f2747m;
                }
                this.f2750p = (int) ((f8 * f7) + (f3 * f6) + centerX);
                this.f2751q = (int) ((f7 * f5) + (f6 * f4) + centerY);
            } else {
                float f9 = this.f2745k;
                float f10 = 0;
                this.f2750p = (i * f9) + f10;
                this.f2751q = (i2 * f9) + f10;
            }
        } else {
            float f11 = centerX2 - centerX;
            float f12 = centerY2 - centerY;
            float f13 = this.f2745k;
            float f14 = (f11 * f13) + centerX;
            float f15 = this.f2746l;
            this.f2750p = ((-f12) * f15) + f14;
            this.f2751q = (f11 * f15) + (f12 * f13) + centerY;
        }
        if (Math.abs(f - this.f2750p) >= 20.0f || Math.abs(f2 - this.f2751q) >= 20.0f) {
            return false;
        }
        return true;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KeyPosition);
        SparseIntArray sparseIntArray = i71.f18329a;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            SparseIntArray sparseIntArray2 = i71.f18329a;
            switch (sparseIntArray2.get(index)) {
                case 1:
                    if (MotionLayout.IS_IN_EDIT_MODE) {
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.f2701b);
                        this.f2701b = resourceId;
                        if (resourceId == -1) {
                            this.f2702c = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            break;
                        }
                    } else if (obtainStyledAttributes.peekValue(index).type == 3) {
                        this.f2702c = obtainStyledAttributes.getString(index);
                        break;
                    } else {
                        this.f2701b = obtainStyledAttributes.getResourceId(index, this.f2701b);
                        break;
                    }
                case 2:
                    this.f2700a = obtainStyledAttributes.getInt(index, this.f2700a);
                    break;
                case 3:
                    if (obtainStyledAttributes.peekValue(index).type == 3) {
                        this.f2740f = obtainStyledAttributes.getString(index);
                        break;
                    } else {
                        this.f2740f = Easing.NAMED_EASING[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    }
                case 4:
                    this.f20396e = obtainStyledAttributes.getInteger(index, this.f20396e);
                    break;
                case 5:
                    this.f2742h = obtainStyledAttributes.getInt(index, this.f2742h);
                    break;
                case 6:
                    this.f2745k = obtainStyledAttributes.getFloat(index, this.f2745k);
                    break;
                case 7:
                    this.f2746l = obtainStyledAttributes.getFloat(index, this.f2746l);
                    break;
                case 8:
                    float f = obtainStyledAttributes.getFloat(index, this.f2744j);
                    this.f2743i = f;
                    this.f2744j = f;
                    break;
                case 9:
                    this.f2749o = obtainStyledAttributes.getInt(index, this.f2749o);
                    break;
                case 10:
                    this.f2741g = obtainStyledAttributes.getInt(index, this.f2741g);
                    break;
                case 11:
                    this.f2743i = obtainStyledAttributes.getFloat(index, this.f2743i);
                    break;
                case 12:
                    this.f2744j = obtainStyledAttributes.getFloat(index, this.f2744j);
                    break;
                default:
                    Log.e(TypedValues.PositionType.NAME, "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray2.get(index));
                    break;
            }
        }
        if (this.f2700a == -1) {
            Log.e(TypedValues.PositionType.NAME, "no frame position");
        }
    }

    @Override // p000.j71
    public void positionAttributes(View view, RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr) {
        int i = this.f2749o;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    float centerX = rectF.centerX();
                    float centerY = rectF.centerY();
                    float centerX2 = rectF2.centerX() - centerX;
                    float centerY2 = rectF2.centerY() - centerY;
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
                float centerX3 = rectF.centerX();
                float centerY3 = rectF.centerY();
                float centerX4 = rectF2.centerX();
                float centerY4 = rectF2.centerY();
                if (centerX3 > centerX4) {
                    centerX4 = centerX3;
                    centerX3 = centerX4;
                }
                if (centerY3 <= centerY4) {
                    centerY4 = centerY3;
                    centerY3 = centerY4;
                }
                float f3 = centerX4 - centerX3;
                float f4 = centerY3 - centerY4;
                String str2 = strArr[0];
                if (str2 != null) {
                    if ("percentX".equals(str2)) {
                        fArr[0] = (f - centerX3) / f3;
                        fArr[1] = (f2 - centerY4) / f4;
                        return;
                    } else {
                        fArr[1] = (f - centerX3) / f3;
                        fArr[0] = (f2 - centerY4) / f4;
                        return;
                    }
                }
                strArr[0] = "percentX";
                fArr[0] = (f - centerX3) / f3;
                strArr[1] = "percentY";
                fArr[1] = (f2 - centerY4) / f4;
                return;
            }
            rectF.centerX();
            rectF.centerY();
            rectF2.centerX();
            rectF2.centerY();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int width = viewGroup.getWidth();
            int height = viewGroup.getHeight();
            String str3 = strArr[0];
            if (str3 != null) {
                if ("percentX".equals(str3)) {
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
        float centerX5 = rectF.centerX();
        float centerY5 = rectF.centerY();
        float centerX6 = rectF2.centerX() - centerX5;
        float centerY6 = rectF2.centerY() - centerY5;
        float hypot = (float) Math.hypot(centerX6, centerY6);
        if (hypot < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f5 = centerX6 / hypot;
        float f6 = centerY6 / hypot;
        float f7 = f2 - centerY5;
        float f8 = f - centerX5;
        float f9 = ((f5 * f7) - (f8 * f6)) / hypot;
        float f10 = ((f6 * f7) + (f5 * f8)) / hypot;
        String str4 = strArr[0];
        if (str4 != null) {
            if ("percentX".equals(str4)) {
                fArr[0] = f10;
                fArr[1] = f9;
                return;
            }
            return;
        }
        strArr[0] = "percentX";
        strArr[1] = "percentY";
        fArr[0] = f10;
        fArr[1] = f9;
    }

    public void setType(int i) {
        this.f2749o = i;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c = 0;
                    break;
                }
                break;
            case -1127236479:
                if (str.equals("percentWidth")) {
                    c = 1;
                    break;
                }
                break;
            case -1017587252:
                if (str.equals("percentHeight")) {
                    c = 2;
                    break;
                }
                break;
            case -827014263:
                if (str.equals("drawPath")) {
                    c = 3;
                    break;
                }
                break;
            case -200259324:
                if (str.equals("sizePercent")) {
                    c = 4;
                    break;
                }
                break;
            case 428090547:
                if (str.equals("percentX")) {
                    c = 5;
                    break;
                }
                break;
            case 428090548:
                if (str.equals("percentY")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f2740f = obj.toString();
                return;
            case 1:
                this.f2743i = Key.m558a(obj);
                return;
            case 2:
                this.f2744j = Key.m558a(obj);
                return;
            case 3:
                this.f2742h = Key.m559b(obj);
                return;
            case 4:
                float m558a = Key.m558a(obj);
                this.f2743i = m558a;
                this.f2744j = m558a;
                return;
            case 5:
                this.f2745k = Key.m558a(obj);
                return;
            case 6:
                this.f2746l = Key.m558a(obj);
                return;
            default:
                return;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: clone */
    public Key mo8476clone() {
        return new KeyPosition().copy(this);
    }
}
