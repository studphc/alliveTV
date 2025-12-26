package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import p000.AbstractC1726qj;
import p000.d71;

/* loaded from: classes.dex */
public class KeyAttributes extends Key {
    public static final int KEY_TYPE = 1;

    /* renamed from: e */
    public int f2704e = -1;

    /* renamed from: f */
    public float f2705f = Float.NaN;

    /* renamed from: g */
    public float f2706g = Float.NaN;

    /* renamed from: h */
    public float f2707h = Float.NaN;

    /* renamed from: i */
    public float f2708i = Float.NaN;

    /* renamed from: j */
    public float f2709j = Float.NaN;

    /* renamed from: k */
    public float f2710k = Float.NaN;

    /* renamed from: l */
    public float f2711l = Float.NaN;

    /* renamed from: m */
    public float f2712m = Float.NaN;

    /* renamed from: n */
    public float f2713n = Float.NaN;

    /* renamed from: o */
    public float f2714o = Float.NaN;

    /* renamed from: p */
    public float f2715p = Float.NaN;

    /* renamed from: q */
    public float f2716q = Float.NaN;

    /* renamed from: r */
    public float f2717r = Float.NaN;

    /* renamed from: s */
    public float f2718s = Float.NaN;

    public KeyAttributes() {
        this.mType = 1;
        this.f2703d = new HashMap();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0041. Please report as an issue. */
    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> hashMap) {
        for (String str : hashMap.keySet()) {
            ViewSpline viewSpline = hashMap.get(str);
            if (viewSpline != null) {
                if (str.startsWith("CUSTOM")) {
                    ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f2703d.get(str.substring(7));
                    if (constraintAttribute != null) {
                        ((ViewSpline.CustomSet) viewSpline).setPoint(this.f2700a, constraintAttribute);
                    }
                } else {
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
                            if (Float.isNaN(this.f2708i)) {
                                break;
                            } else {
                                viewSpline.setPoint(this.f2700a, this.f2708i);
                                break;
                            }
                        case 1:
                            if (Float.isNaN(this.f2709j)) {
                                break;
                            } else {
                                viewSpline.setPoint(this.f2700a, this.f2709j);
                                break;
                            }
                        case 2:
                            if (Float.isNaN(this.f2715p)) {
                                break;
                            } else {
                                viewSpline.setPoint(this.f2700a, this.f2715p);
                                break;
                            }
                        case 3:
                            if (Float.isNaN(this.f2716q)) {
                                break;
                            } else {
                                viewSpline.setPoint(this.f2700a, this.f2716q);
                                break;
                            }
                        case 4:
                            if (Float.isNaN(this.f2717r)) {
                                break;
                            } else {
                                viewSpline.setPoint(this.f2700a, this.f2717r);
                                break;
                            }
                        case 5:
                            if (Float.isNaN(this.f2718s)) {
                                break;
                            } else {
                                viewSpline.setPoint(this.f2700a, this.f2718s);
                                break;
                            }
                        case 6:
                            if (Float.isNaN(this.f2713n)) {
                                break;
                            } else {
                                viewSpline.setPoint(this.f2700a, this.f2713n);
                                break;
                            }
                        case 7:
                            if (Float.isNaN(this.f2714o)) {
                                break;
                            } else {
                                viewSpline.setPoint(this.f2700a, this.f2714o);
                                break;
                            }
                        case '\b':
                            if (Float.isNaN(this.f2708i)) {
                                break;
                            } else {
                                viewSpline.setPoint(this.f2700a, this.f2710k);
                                break;
                            }
                        case '\t':
                            if (Float.isNaN(this.f2709j)) {
                                break;
                            } else {
                                viewSpline.setPoint(this.f2700a, this.f2711l);
                                break;
                            }
                        case '\n':
                            if (Float.isNaN(this.f2707h)) {
                                break;
                            } else {
                                viewSpline.setPoint(this.f2700a, this.f2707h);
                                break;
                            }
                        case 11:
                            if (Float.isNaN(this.f2706g)) {
                                break;
                            } else {
                                viewSpline.setPoint(this.f2700a, this.f2706g);
                                break;
                            }
                        case '\f':
                            if (Float.isNaN(this.f2712m)) {
                                break;
                            } else {
                                viewSpline.setPoint(this.f2700a, this.f2712m);
                                break;
                            }
                        case '\r':
                            if (Float.isNaN(this.f2705f)) {
                                break;
                            } else {
                                viewSpline.setPoint(this.f2700a, this.f2705f);
                                break;
                            }
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key key) {
        super.copy(key);
        KeyAttributes keyAttributes = (KeyAttributes) key;
        this.f2704e = keyAttributes.f2704e;
        this.f2705f = keyAttributes.f2705f;
        this.f2706g = keyAttributes.f2706g;
        this.f2707h = keyAttributes.f2707h;
        this.f2708i = keyAttributes.f2708i;
        this.f2709j = keyAttributes.f2709j;
        this.f2710k = keyAttributes.f2710k;
        this.f2711l = keyAttributes.f2711l;
        this.f2712m = keyAttributes.f2712m;
        this.f2713n = keyAttributes.f2713n;
        this.f2714o = keyAttributes.f2714o;
        this.f2715p = keyAttributes.f2715p;
        this.f2716q = keyAttributes.f2716q;
        this.f2717r = keyAttributes.f2717r;
        this.f2718s = keyAttributes.f2718s;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f2705f)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f2706g)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f2707h)) {
            hashSet.add(Key.ROTATION);
        }
        if (!Float.isNaN(this.f2708i)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f2709j)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f2710k)) {
            hashSet.add(Key.PIVOT_X);
        }
        if (!Float.isNaN(this.f2711l)) {
            hashSet.add(Key.PIVOT_Y);
        }
        if (!Float.isNaN(this.f2715p)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f2716q)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f2717r)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f2712m)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f2713n)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f2714o)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f2718s)) {
            hashSet.add("progress");
        }
        if (this.f2703d.size() > 0) {
            Iterator it = this.f2703d.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + ((String) it.next()));
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KeyAttribute);
        SparseIntArray sparseIntArray = d71.f16279a;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            SparseIntArray sparseIntArray2 = d71.f16279a;
            switch (sparseIntArray2.get(index)) {
                case 1:
                    this.f2705f = obtainStyledAttributes.getFloat(index, this.f2705f);
                    break;
                case 2:
                    this.f2706g = obtainStyledAttributes.getDimension(index, this.f2706g);
                    break;
                case 3:
                case 11:
                default:
                    Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray2.get(index));
                    break;
                case 4:
                    this.f2707h = obtainStyledAttributes.getFloat(index, this.f2707h);
                    break;
                case 5:
                    this.f2708i = obtainStyledAttributes.getFloat(index, this.f2708i);
                    break;
                case 6:
                    this.f2709j = obtainStyledAttributes.getFloat(index, this.f2709j);
                    break;
                case 7:
                    this.f2713n = obtainStyledAttributes.getFloat(index, this.f2713n);
                    break;
                case 8:
                    this.f2712m = obtainStyledAttributes.getFloat(index, this.f2712m);
                    break;
                case 9:
                    obtainStyledAttributes.getString(index);
                    break;
                case 10:
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
                case 12:
                    this.f2700a = obtainStyledAttributes.getInt(index, this.f2700a);
                    break;
                case 13:
                    this.f2704e = obtainStyledAttributes.getInteger(index, this.f2704e);
                    break;
                case 14:
                    this.f2714o = obtainStyledAttributes.getFloat(index, this.f2714o);
                    break;
                case 15:
                    this.f2715p = obtainStyledAttributes.getDimension(index, this.f2715p);
                    break;
                case 16:
                    this.f2716q = obtainStyledAttributes.getDimension(index, this.f2716q);
                    break;
                case 17:
                    this.f2717r = obtainStyledAttributes.getDimension(index, this.f2717r);
                    break;
                case 18:
                    this.f2718s = obtainStyledAttributes.getFloat(index, this.f2718s);
                    break;
                case 19:
                    this.f2710k = obtainStyledAttributes.getDimension(index, this.f2710k);
                    break;
                case 20:
                    this.f2711l = obtainStyledAttributes.getDimension(index, this.f2711l);
                    break;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setInterpolation(HashMap<String, Integer> hashMap) {
        if (this.f2704e == -1) {
            return;
        }
        if (!Float.isNaN(this.f2705f)) {
            hashMap.put("alpha", Integer.valueOf(this.f2704e));
        }
        if (!Float.isNaN(this.f2706g)) {
            hashMap.put("elevation", Integer.valueOf(this.f2704e));
        }
        if (!Float.isNaN(this.f2707h)) {
            hashMap.put(Key.ROTATION, Integer.valueOf(this.f2704e));
        }
        if (!Float.isNaN(this.f2708i)) {
            hashMap.put("rotationX", Integer.valueOf(this.f2704e));
        }
        if (!Float.isNaN(this.f2709j)) {
            hashMap.put("rotationY", Integer.valueOf(this.f2704e));
        }
        if (!Float.isNaN(this.f2710k)) {
            hashMap.put(Key.PIVOT_X, Integer.valueOf(this.f2704e));
        }
        if (!Float.isNaN(this.f2711l)) {
            hashMap.put(Key.PIVOT_Y, Integer.valueOf(this.f2704e));
        }
        if (!Float.isNaN(this.f2715p)) {
            hashMap.put("translationX", Integer.valueOf(this.f2704e));
        }
        if (!Float.isNaN(this.f2716q)) {
            hashMap.put("translationY", Integer.valueOf(this.f2704e));
        }
        if (!Float.isNaN(this.f2717r)) {
            hashMap.put("translationZ", Integer.valueOf(this.f2704e));
        }
        if (!Float.isNaN(this.f2712m)) {
            hashMap.put("transitionPathRotate", Integer.valueOf(this.f2704e));
        }
        if (!Float.isNaN(this.f2713n)) {
            hashMap.put("scaleX", Integer.valueOf(this.f2704e));
        }
        if (!Float.isNaN(this.f2714o)) {
            hashMap.put("scaleY", Integer.valueOf(this.f2704e));
        }
        if (!Float.isNaN(this.f2718s)) {
            hashMap.put("progress", Integer.valueOf(this.f2704e));
        }
        if (this.f2703d.size() > 0) {
            Iterator it = this.f2703d.keySet().iterator();
            while (it.hasNext()) {
                hashMap.put(AbstractC1726qj.m7038C("CUSTOM,", (String) it.next()), Integer.valueOf(this.f2704e));
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -1913008125:
                if (str.equals(Key.MOTIONPROGRESS)) {
                    c = 0;
                    break;
                }
                break;
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c = 1;
                    break;
                }
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 2;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 3;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 4;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 5;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = 6;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 7;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = '\b';
                    break;
                }
                break;
            case -760884510:
                if (str.equals(Key.PIVOT_X)) {
                    c = '\t';
                    break;
                }
                break;
            case -760884509:
                if (str.equals(Key.PIVOT_Y)) {
                    c = '\n';
                    break;
                }
                break;
            case -40300674:
                if (str.equals(Key.ROTATION)) {
                    c = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = '\f';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = '\r';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 14;
                    break;
                }
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    c = 15;
                    break;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c = 16;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f2718s = Key.m558a(obj);
                return;
            case 1:
                obj.toString();
                return;
            case 2:
                this.f2708i = Key.m558a(obj);
                return;
            case 3:
                this.f2709j = Key.m558a(obj);
                return;
            case 4:
                this.f2715p = Key.m558a(obj);
                return;
            case 5:
                this.f2716q = Key.m558a(obj);
                return;
            case 6:
                this.f2717r = Key.m558a(obj);
                return;
            case 7:
                this.f2713n = Key.m558a(obj);
                return;
            case '\b':
                this.f2714o = Key.m558a(obj);
                return;
            case '\t':
                this.f2710k = Key.m558a(obj);
                return;
            case '\n':
                this.f2711l = Key.m558a(obj);
                return;
            case 11:
                this.f2707h = Key.m558a(obj);
                return;
            case '\f':
                this.f2706g = Key.m558a(obj);
                return;
            case '\r':
                this.f2712m = Key.m558a(obj);
                return;
            case 14:
                this.f2705f = Key.m558a(obj);
                return;
            case 15:
                this.f2704e = Key.m559b(obj);
                return;
            case 16:
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                    return;
                } else {
                    Boolean.parseBoolean(obj.toString());
                    return;
                }
            default:
                return;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: clone */
    public Key mo8476clone() {
        return new KeyAttributes().copy(this);
    }
}
