package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import p000.e71;

/* loaded from: classes.dex */
public class KeyCycle extends Key {
    public static final int KEY_TYPE = 4;
    public static final int SHAPE_BOUNCE = 6;
    public static final int SHAPE_COS_WAVE = 5;
    public static final int SHAPE_REVERSE_SAW_WAVE = 4;
    public static final int SHAPE_SAW_WAVE = 3;
    public static final int SHAPE_SIN_WAVE = 0;
    public static final int SHAPE_SQUARE_WAVE = 1;
    public static final int SHAPE_TRIANGLE_WAVE = 2;
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_PHASE = "wavePhase";
    public static final String WAVE_SHAPE = "waveShape";

    /* renamed from: e */
    public int f2719e = 0;

    /* renamed from: f */
    public int f2720f = -1;

    /* renamed from: g */
    public String f2721g = null;

    /* renamed from: h */
    public float f2722h = Float.NaN;

    /* renamed from: i */
    public float f2723i = RecyclerView.f7068F0;

    /* renamed from: j */
    public float f2724j = RecyclerView.f7068F0;

    /* renamed from: k */
    public float f2725k = Float.NaN;

    /* renamed from: l */
    public int f2726l = -1;

    /* renamed from: m */
    public float f2727m = Float.NaN;

    /* renamed from: n */
    public float f2728n = Float.NaN;

    /* renamed from: o */
    public float f2729o = Float.NaN;

    /* renamed from: p */
    public float f2730p = Float.NaN;

    /* renamed from: q */
    public float f2731q = Float.NaN;

    /* renamed from: r */
    public float f2732r = Float.NaN;

    /* renamed from: s */
    public float f2733s = Float.NaN;

    /* renamed from: t */
    public float f2734t = Float.NaN;

    /* renamed from: u */
    public float f2735u = Float.NaN;

    /* renamed from: v */
    public float f2736v = Float.NaN;

    /* renamed from: w */
    public float f2737w = Float.NaN;

    public KeyCycle() {
        this.mType = 4;
        this.f2703d = new HashMap();
    }

    public void addCycleValues(HashMap<String, ViewOscillator> hashMap) {
        ViewOscillator viewOscillator;
        ViewOscillator viewOscillator2;
        for (String str : hashMap.keySet()) {
            if (str.startsWith("CUSTOM")) {
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f2703d.get(str.substring(7));
                if (constraintAttribute != null && constraintAttribute.getType() == ConstraintAttribute.AttributeType.FLOAT_TYPE && (viewOscillator = hashMap.get(str)) != null) {
                    viewOscillator.setPoint(this.f2700a, this.f2720f, this.f2721g, this.f2726l, this.f2722h, this.f2723i, this.f2724j, constraintAttribute.getValueToInterpolate(), constraintAttribute);
                }
            } else {
                float value = getValue(str);
                if (!Float.isNaN(value) && (viewOscillator2 = hashMap.get(str)) != null) {
                    viewOscillator2.setPoint(this.f2700a, this.f2720f, this.f2721g, this.f2726l, this.f2722h, this.f2723i, this.f2724j, value);
                }
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0042. Please report as an issue. */
    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> hashMap) {
        Debug.logStack(TypedValues.CycleType.NAME, "add " + hashMap.size() + " values", 2);
        for (String str : hashMap.keySet()) {
            ViewSpline viewSpline = hashMap.get(str);
            if (viewSpline != null) {
                str.getClass();
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
                    case 156108012:
                        if (str.equals("waveOffset")) {
                            c = '\f';
                            break;
                        }
                        break;
                    case 1530034690:
                        if (str.equals("wavePhase")) {
                            c = '\r';
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        viewSpline.setPoint(this.f2700a, this.f2731q);
                        break;
                    case 1:
                        viewSpline.setPoint(this.f2700a, this.f2732r);
                        break;
                    case 2:
                        viewSpline.setPoint(this.f2700a, this.f2735u);
                        break;
                    case 3:
                        viewSpline.setPoint(this.f2700a, this.f2736v);
                        break;
                    case 4:
                        viewSpline.setPoint(this.f2700a, this.f2737w);
                        break;
                    case 5:
                        viewSpline.setPoint(this.f2700a, this.f2725k);
                        break;
                    case 6:
                        viewSpline.setPoint(this.f2700a, this.f2733s);
                        break;
                    case 7:
                        viewSpline.setPoint(this.f2700a, this.f2734t);
                        break;
                    case '\b':
                        viewSpline.setPoint(this.f2700a, this.f2729o);
                        break;
                    case '\t':
                        viewSpline.setPoint(this.f2700a, this.f2728n);
                        break;
                    case '\n':
                        viewSpline.setPoint(this.f2700a, this.f2730p);
                        break;
                    case 11:
                        viewSpline.setPoint(this.f2700a, this.f2727m);
                        break;
                    case '\f':
                        viewSpline.setPoint(this.f2700a, this.f2723i);
                        break;
                    case '\r':
                        viewSpline.setPoint(this.f2700a, this.f2724j);
                        break;
                    default:
                        if (str.startsWith("CUSTOM")) {
                            break;
                        } else {
                            Log.v("WARNING KeyCycle", "  UNKNOWN  ".concat(str));
                            break;
                        }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key key) {
        super.copy(key);
        KeyCycle keyCycle = (KeyCycle) key;
        keyCycle.getClass();
        this.f2719e = keyCycle.f2719e;
        this.f2720f = keyCycle.f2720f;
        this.f2721g = keyCycle.f2721g;
        this.f2722h = keyCycle.f2722h;
        this.f2723i = keyCycle.f2723i;
        this.f2724j = keyCycle.f2724j;
        this.f2725k = keyCycle.f2725k;
        this.f2726l = keyCycle.f2726l;
        this.f2727m = keyCycle.f2727m;
        this.f2728n = keyCycle.f2728n;
        this.f2729o = keyCycle.f2729o;
        this.f2730p = keyCycle.f2730p;
        this.f2731q = keyCycle.f2731q;
        this.f2732r = keyCycle.f2732r;
        this.f2733s = keyCycle.f2733s;
        this.f2734t = keyCycle.f2734t;
        this.f2735u = keyCycle.f2735u;
        this.f2736v = keyCycle.f2736v;
        this.f2737w = keyCycle.f2737w;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f2727m)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f2728n)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f2729o)) {
            hashSet.add(Key.ROTATION);
        }
        if (!Float.isNaN(this.f2731q)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f2732r)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f2733s)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f2734t)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f2730p)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f2735u)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f2736v)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f2737w)) {
            hashSet.add("translationZ");
        }
        if (this.f2703d.size() > 0) {
            Iterator it = this.f2703d.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + ((String) it.next()));
            }
        }
    }

    public float getValue(String str) {
        str.getClass();
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
            case 156108012:
                if (str.equals("waveOffset")) {
                    c = '\f';
                    break;
                }
                break;
            case 1530034690:
                if (str.equals("wavePhase")) {
                    c = '\r';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.f2731q;
            case 1:
                return this.f2732r;
            case 2:
                return this.f2735u;
            case 3:
                return this.f2736v;
            case 4:
                return this.f2737w;
            case 5:
                return this.f2725k;
            case 6:
                return this.f2733s;
            case 7:
                return this.f2734t;
            case '\b':
                return this.f2729o;
            case '\t':
                return this.f2728n;
            case '\n':
                return this.f2730p;
            case 11:
                return this.f2727m;
            case '\f':
                return this.f2723i;
            case '\r':
                return this.f2724j;
            default:
                if (!str.startsWith("CUSTOM")) {
                    Log.v("WARNING! KeyCycle", "  UNKNOWN  ".concat(str));
                    return Float.NaN;
                }
                return Float.NaN;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KeyCycle);
        SparseIntArray sparseIntArray = e71.f16697a;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            SparseIntArray sparseIntArray2 = e71.f16697a;
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
                    obtainStyledAttributes.getString(index);
                    break;
                case 4:
                    this.f2719e = obtainStyledAttributes.getInteger(index, this.f2719e);
                    break;
                case 5:
                    if (obtainStyledAttributes.peekValue(index).type == 3) {
                        this.f2721g = obtainStyledAttributes.getString(index);
                        this.f2720f = 7;
                        break;
                    } else {
                        this.f2720f = obtainStyledAttributes.getInt(index, this.f2720f);
                        break;
                    }
                case 6:
                    this.f2722h = obtainStyledAttributes.getFloat(index, this.f2722h);
                    break;
                case 7:
                    if (obtainStyledAttributes.peekValue(index).type == 5) {
                        this.f2723i = obtainStyledAttributes.getDimension(index, this.f2723i);
                        break;
                    } else {
                        this.f2723i = obtainStyledAttributes.getFloat(index, this.f2723i);
                        break;
                    }
                case 8:
                    this.f2726l = obtainStyledAttributes.getInt(index, this.f2726l);
                    break;
                case 9:
                    this.f2727m = obtainStyledAttributes.getFloat(index, this.f2727m);
                    break;
                case 10:
                    this.f2728n = obtainStyledAttributes.getDimension(index, this.f2728n);
                    break;
                case 11:
                    this.f2729o = obtainStyledAttributes.getFloat(index, this.f2729o);
                    break;
                case 12:
                    this.f2731q = obtainStyledAttributes.getFloat(index, this.f2731q);
                    break;
                case 13:
                    this.f2732r = obtainStyledAttributes.getFloat(index, this.f2732r);
                    break;
                case 14:
                    this.f2730p = obtainStyledAttributes.getFloat(index, this.f2730p);
                    break;
                case 15:
                    this.f2733s = obtainStyledAttributes.getFloat(index, this.f2733s);
                    break;
                case 16:
                    this.f2734t = obtainStyledAttributes.getFloat(index, this.f2734t);
                    break;
                case 17:
                    this.f2735u = obtainStyledAttributes.getDimension(index, this.f2735u);
                    break;
                case 18:
                    this.f2736v = obtainStyledAttributes.getDimension(index, this.f2736v);
                    break;
                case 19:
                    this.f2737w = obtainStyledAttributes.getDimension(index, this.f2737w);
                    break;
                case 20:
                    this.f2725k = obtainStyledAttributes.getFloat(index, this.f2725k);
                    break;
                case 21:
                    this.f2724j = obtainStyledAttributes.getFloat(index, this.f2724j) / 360.0f;
                    break;
                default:
                    Log.e(TypedValues.CycleType.NAME, "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray2.get(index));
                    break;
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
            case 1530034690:
                if (str.equals("wavePhase")) {
                    c = 16;
                    break;
                }
                break;
            case 1532805160:
                if (str.equals("waveShape")) {
                    c = 17;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f2725k = Key.m558a(obj);
                return;
            case 1:
                obj.toString();
                return;
            case 2:
                this.f2731q = Key.m558a(obj);
                return;
            case 3:
                this.f2732r = Key.m558a(obj);
                return;
            case 4:
                this.f2735u = Key.m558a(obj);
                return;
            case 5:
                this.f2736v = Key.m558a(obj);
                return;
            case 6:
                this.f2737w = Key.m558a(obj);
                return;
            case 7:
                this.f2733s = Key.m558a(obj);
                return;
            case '\b':
                this.f2734t = Key.m558a(obj);
                return;
            case '\t':
                this.f2729o = Key.m558a(obj);
                return;
            case '\n':
                this.f2728n = Key.m558a(obj);
                return;
            case 11:
                this.f2730p = Key.m558a(obj);
                return;
            case '\f':
                this.f2727m = Key.m558a(obj);
                return;
            case '\r':
                this.f2723i = Key.m558a(obj);
                return;
            case 14:
                this.f2722h = Key.m558a(obj);
                return;
            case 15:
                this.f2719e = Key.m559b(obj);
                return;
            case 16:
                this.f2724j = Key.m558a(obj);
                return;
            case 17:
                if (obj instanceof Integer) {
                    this.f2720f = Key.m559b(obj);
                    return;
                } else {
                    this.f2720f = 7;
                    this.f2721g = obj.toString();
                    return;
                }
            default:
                return;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: clone */
    public Key mo8476clone() {
        return new KeyCycle().copy(this);
    }
}
