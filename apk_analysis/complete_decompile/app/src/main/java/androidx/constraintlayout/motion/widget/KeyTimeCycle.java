package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import p000.AbstractC1726qj;
import p000.k71;

/* loaded from: classes.dex */
public class KeyTimeCycle extends Key {
    public static final int KEY_TYPE = 3;
    public static final int SHAPE_BOUNCE = 6;
    public static final int SHAPE_COS_WAVE = 5;
    public static final int SHAPE_REVERSE_SAW_WAVE = 4;
    public static final int SHAPE_SAW_WAVE = 3;
    public static final int SHAPE_SIN_WAVE = 0;
    public static final int SHAPE_SQUARE_WAVE = 1;
    public static final int SHAPE_TRIANGLE_WAVE = 2;
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_SHAPE = "waveShape";

    /* renamed from: e */
    public int f2752e = -1;

    /* renamed from: f */
    public float f2753f = Float.NaN;

    /* renamed from: g */
    public float f2754g = Float.NaN;

    /* renamed from: h */
    public float f2755h = Float.NaN;

    /* renamed from: i */
    public float f2756i = Float.NaN;

    /* renamed from: j */
    public float f2757j = Float.NaN;

    /* renamed from: k */
    public float f2758k = Float.NaN;

    /* renamed from: l */
    public float f2759l = Float.NaN;

    /* renamed from: m */
    public float f2760m = Float.NaN;

    /* renamed from: n */
    public float f2761n = Float.NaN;

    /* renamed from: o */
    public float f2762o = Float.NaN;

    /* renamed from: p */
    public float f2763p = Float.NaN;

    /* renamed from: q */
    public float f2764q = Float.NaN;

    /* renamed from: r */
    public int f2765r = 0;

    /* renamed from: s */
    public float f2766s = Float.NaN;

    /* renamed from: t */
    public float f2767t = RecyclerView.f7068F0;

    public KeyTimeCycle() {
        this.mType = 3;
        this.f2703d = new HashMap();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x004a. Please report as an issue. */
    public void addTimeValues(HashMap<String, ViewTimeCycle> hashMap) {
        for (String str : hashMap.keySet()) {
            ViewTimeCycle viewTimeCycle = hashMap.get(str);
            if (viewTimeCycle != null) {
                if (str.startsWith("CUSTOM")) {
                    ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f2703d.get(str.substring(7));
                    if (constraintAttribute != null) {
                        ((ViewTimeCycle.CustomSet) viewTimeCycle).setPoint(this.f2700a, constraintAttribute, this.f2766s, this.f2765r, this.f2767t);
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
                        case -40300674:
                            if (str.equals(Key.ROTATION)) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -4379043:
                            if (str.equals("elevation")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case 37232917:
                            if (str.equals("transitionPathRotate")) {
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
                    }
                    switch (c) {
                        case 0:
                            if (Float.isNaN(this.f2756i)) {
                                break;
                            } else {
                                viewTimeCycle.setPoint(this.f2700a, this.f2756i, this.f2766s, this.f2765r, this.f2767t);
                                break;
                            }
                        case 1:
                            if (Float.isNaN(this.f2757j)) {
                                break;
                            } else {
                                viewTimeCycle.setPoint(this.f2700a, this.f2757j, this.f2766s, this.f2765r, this.f2767t);
                                break;
                            }
                        case 2:
                            if (Float.isNaN(this.f2761n)) {
                                break;
                            } else {
                                viewTimeCycle.setPoint(this.f2700a, this.f2761n, this.f2766s, this.f2765r, this.f2767t);
                                break;
                            }
                        case 3:
                            if (Float.isNaN(this.f2762o)) {
                                break;
                            } else {
                                viewTimeCycle.setPoint(this.f2700a, this.f2762o, this.f2766s, this.f2765r, this.f2767t);
                                break;
                            }
                        case 4:
                            if (Float.isNaN(this.f2763p)) {
                                break;
                            } else {
                                viewTimeCycle.setPoint(this.f2700a, this.f2763p, this.f2766s, this.f2765r, this.f2767t);
                                break;
                            }
                        case 5:
                            if (Float.isNaN(this.f2764q)) {
                                break;
                            } else {
                                viewTimeCycle.setPoint(this.f2700a, this.f2764q, this.f2766s, this.f2765r, this.f2767t);
                                break;
                            }
                        case 6:
                            if (Float.isNaN(this.f2759l)) {
                                break;
                            } else {
                                viewTimeCycle.setPoint(this.f2700a, this.f2759l, this.f2766s, this.f2765r, this.f2767t);
                                break;
                            }
                        case 7:
                            if (Float.isNaN(this.f2760m)) {
                                break;
                            } else {
                                viewTimeCycle.setPoint(this.f2700a, this.f2760m, this.f2766s, this.f2765r, this.f2767t);
                                break;
                            }
                        case '\b':
                            if (Float.isNaN(this.f2755h)) {
                                break;
                            } else {
                                viewTimeCycle.setPoint(this.f2700a, this.f2755h, this.f2766s, this.f2765r, this.f2767t);
                                break;
                            }
                        case '\t':
                            if (Float.isNaN(this.f2754g)) {
                                break;
                            } else {
                                viewTimeCycle.setPoint(this.f2700a, this.f2754g, this.f2766s, this.f2765r, this.f2767t);
                                break;
                            }
                        case '\n':
                            if (Float.isNaN(this.f2758k)) {
                                break;
                            } else {
                                viewTimeCycle.setPoint(this.f2700a, this.f2758k, this.f2766s, this.f2765r, this.f2767t);
                                break;
                            }
                        case 11:
                            if (Float.isNaN(this.f2753f)) {
                                break;
                            } else {
                                viewTimeCycle.setPoint(this.f2700a, this.f2753f, this.f2766s, this.f2765r, this.f2767t);
                                break;
                            }
                        default:
                            Log.e("KeyTimeCycles", "UNKNOWN addValues \"" + str + "\"");
                            break;
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> hashMap) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key key) {
        super.copy(key);
        KeyTimeCycle keyTimeCycle = (KeyTimeCycle) key;
        keyTimeCycle.getClass();
        this.f2752e = keyTimeCycle.f2752e;
        this.f2765r = keyTimeCycle.f2765r;
        this.f2766s = keyTimeCycle.f2766s;
        this.f2767t = keyTimeCycle.f2767t;
        this.f2764q = keyTimeCycle.f2764q;
        this.f2753f = keyTimeCycle.f2753f;
        this.f2754g = keyTimeCycle.f2754g;
        this.f2755h = keyTimeCycle.f2755h;
        this.f2758k = keyTimeCycle.f2758k;
        this.f2756i = keyTimeCycle.f2756i;
        this.f2757j = keyTimeCycle.f2757j;
        this.f2759l = keyTimeCycle.f2759l;
        this.f2760m = keyTimeCycle.f2760m;
        this.f2761n = keyTimeCycle.f2761n;
        this.f2762o = keyTimeCycle.f2762o;
        this.f2763p = keyTimeCycle.f2763p;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f2753f)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f2754g)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f2755h)) {
            hashSet.add(Key.ROTATION);
        }
        if (!Float.isNaN(this.f2756i)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f2757j)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f2761n)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f2762o)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f2763p)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f2758k)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f2759l)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f2760m)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f2764q)) {
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KeyTimeCycle);
        SparseIntArray sparseIntArray = k71.f20768a;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            SparseIntArray sparseIntArray2 = k71.f20768a;
            switch (sparseIntArray2.get(index)) {
                case 1:
                    this.f2753f = obtainStyledAttributes.getFloat(index, this.f2753f);
                    break;
                case 2:
                    this.f2754g = obtainStyledAttributes.getDimension(index, this.f2754g);
                    break;
                case 3:
                case 11:
                default:
                    Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray2.get(index));
                    break;
                case 4:
                    this.f2755h = obtainStyledAttributes.getFloat(index, this.f2755h);
                    break;
                case 5:
                    this.f2756i = obtainStyledAttributes.getFloat(index, this.f2756i);
                    break;
                case 6:
                    this.f2757j = obtainStyledAttributes.getFloat(index, this.f2757j);
                    break;
                case 7:
                    this.f2759l = obtainStyledAttributes.getFloat(index, this.f2759l);
                    break;
                case 8:
                    this.f2758k = obtainStyledAttributes.getFloat(index, this.f2758k);
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
                    this.f2752e = obtainStyledAttributes.getInteger(index, this.f2752e);
                    break;
                case 14:
                    this.f2760m = obtainStyledAttributes.getFloat(index, this.f2760m);
                    break;
                case 15:
                    this.f2761n = obtainStyledAttributes.getDimension(index, this.f2761n);
                    break;
                case 16:
                    this.f2762o = obtainStyledAttributes.getDimension(index, this.f2762o);
                    break;
                case 17:
                    this.f2763p = obtainStyledAttributes.getDimension(index, this.f2763p);
                    break;
                case 18:
                    this.f2764q = obtainStyledAttributes.getFloat(index, this.f2764q);
                    break;
                case 19:
                    if (obtainStyledAttributes.peekValue(index).type == 3) {
                        obtainStyledAttributes.getString(index);
                        this.f2765r = 7;
                        break;
                    } else {
                        this.f2765r = obtainStyledAttributes.getInt(index, this.f2765r);
                        break;
                    }
                case 20:
                    this.f2766s = obtainStyledAttributes.getFloat(index, this.f2766s);
                    break;
                case 21:
                    if (obtainStyledAttributes.peekValue(index).type == 5) {
                        this.f2767t = obtainStyledAttributes.getDimension(index, this.f2767t);
                        break;
                    } else {
                        this.f2767t = obtainStyledAttributes.getFloat(index, this.f2767t);
                        break;
                    }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setInterpolation(HashMap<String, Integer> hashMap) {
        if (this.f2752e == -1) {
            return;
        }
        if (!Float.isNaN(this.f2753f)) {
            hashMap.put("alpha", Integer.valueOf(this.f2752e));
        }
        if (!Float.isNaN(this.f2754g)) {
            hashMap.put("elevation", Integer.valueOf(this.f2752e));
        }
        if (!Float.isNaN(this.f2755h)) {
            hashMap.put(Key.ROTATION, Integer.valueOf(this.f2752e));
        }
        if (!Float.isNaN(this.f2756i)) {
            hashMap.put("rotationX", Integer.valueOf(this.f2752e));
        }
        if (!Float.isNaN(this.f2757j)) {
            hashMap.put("rotationY", Integer.valueOf(this.f2752e));
        }
        if (!Float.isNaN(this.f2761n)) {
            hashMap.put("translationX", Integer.valueOf(this.f2752e));
        }
        if (!Float.isNaN(this.f2762o)) {
            hashMap.put("translationY", Integer.valueOf(this.f2752e));
        }
        if (!Float.isNaN(this.f2763p)) {
            hashMap.put("translationZ", Integer.valueOf(this.f2752e));
        }
        if (!Float.isNaN(this.f2758k)) {
            hashMap.put("transitionPathRotate", Integer.valueOf(this.f2752e));
        }
        if (!Float.isNaN(this.f2759l)) {
            hashMap.put("scaleX", Integer.valueOf(this.f2752e));
        }
        if (!Float.isNaN(this.f2759l)) {
            hashMap.put("scaleY", Integer.valueOf(this.f2752e));
        }
        if (!Float.isNaN(this.f2764q)) {
            hashMap.put("progress", Integer.valueOf(this.f2752e));
        }
        if (this.f2703d.size() > 0) {
            Iterator it = this.f2703d.keySet().iterator();
            while (it.hasNext()) {
                hashMap.put(AbstractC1726qj.m7038C("CUSTOM,", (String) it.next()), Integer.valueOf(this.f2752e));
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
            case -40300674:
                if (str.equals(Key.ROTATION)) {
                    c = '\t';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = '\n';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = 11;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = '\f';
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c = '\r';
                    break;
                }
                break;
            case 184161818:
                if (str.equals("wavePeriod")) {
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
            case 1532805160:
                if (str.equals("waveShape")) {
                    c = 16;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f2764q = Key.m558a(obj);
                return;
            case 1:
                obj.toString();
                return;
            case 2:
                this.f2756i = Key.m558a(obj);
                return;
            case 3:
                this.f2757j = Key.m558a(obj);
                return;
            case 4:
                this.f2761n = Key.m558a(obj);
                return;
            case 5:
                this.f2762o = Key.m558a(obj);
                return;
            case 6:
                this.f2763p = Key.m558a(obj);
                return;
            case 7:
                this.f2759l = Key.m558a(obj);
                return;
            case '\b':
                this.f2760m = Key.m558a(obj);
                return;
            case '\t':
                this.f2755h = Key.m558a(obj);
                return;
            case '\n':
                this.f2754g = Key.m558a(obj);
                return;
            case 11:
                this.f2758k = Key.m558a(obj);
                return;
            case '\f':
                this.f2753f = Key.m558a(obj);
                return;
            case '\r':
                this.f2767t = Key.m558a(obj);
                return;
            case 14:
                this.f2766s = Key.m558a(obj);
                return;
            case 15:
                this.f2752e = Key.m559b(obj);
                return;
            case 16:
                if (obj instanceof Integer) {
                    this.f2765r = Key.m559b(obj);
                    return;
                } else {
                    this.f2765r = 7;
                    obj.toString();
                    return;
                }
            default:
                return;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: clone */
    public Key mo8476clone() {
        return new KeyTimeCycle().copy(this);
    }
}
