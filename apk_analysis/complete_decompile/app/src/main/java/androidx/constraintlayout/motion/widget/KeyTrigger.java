package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import p000.l71;

/* loaded from: classes.dex */
public class KeyTrigger extends Key {
    public static final String CROSS = "CROSS";
    public static final int KEY_TYPE = 5;
    public static final String NEGATIVE_CROSS = "negativeCross";
    public static final String POSITIVE_CROSS = "positiveCross";
    public static final String POST_LAYOUT = "postLayout";
    public static final String TRIGGER_COLLISION_ID = "triggerCollisionId";
    public static final String TRIGGER_COLLISION_VIEW = "triggerCollisionView";
    public static final String TRIGGER_ID = "triggerID";
    public static final String TRIGGER_RECEIVER = "triggerReceiver";
    public static final String TRIGGER_SLACK = "triggerSlack";
    public static final String VIEW_TRANSITION_ON_CROSS = "viewTransitionOnCross";
    public static final String VIEW_TRANSITION_ON_NEGATIVE_CROSS = "viewTransitionOnNegativeCross";
    public static final String VIEW_TRANSITION_ON_POSITIVE_CROSS = "viewTransitionOnPositiveCross";

    /* renamed from: e */
    public float f2768e = 0.1f;

    /* renamed from: f */
    public int f2769f;

    /* renamed from: g */
    public int f2770g;

    /* renamed from: h */
    public int f2771h;

    /* renamed from: i */
    public RectF f2772i;

    /* renamed from: j */
    public RectF f2773j;

    /* renamed from: k */
    public HashMap f2774k;

    /* renamed from: l */
    public String f2775l;

    /* renamed from: m */
    public int f2776m;

    /* renamed from: n */
    public String f2777n;

    /* renamed from: o */
    public String f2778o;

    /* renamed from: p */
    public int f2779p;

    /* renamed from: q */
    public int f2780q;

    /* renamed from: r */
    public View f2781r;

    /* renamed from: s */
    public boolean f2782s;

    /* renamed from: t */
    public boolean f2783t;

    /* renamed from: u */
    public boolean f2784u;

    /* renamed from: v */
    public float f2785v;

    /* renamed from: w */
    public float f2786w;

    /* renamed from: x */
    public boolean f2787x;

    public KeyTrigger() {
        int i = Key.UNSET;
        this.f2769f = i;
        this.f2770g = i;
        this.f2771h = i;
        this.f2772i = new RectF();
        this.f2773j = new RectF();
        this.f2774k = new HashMap();
        this.f2775l = null;
        int i2 = Key.UNSET;
        this.f2776m = i2;
        this.f2777n = null;
        this.f2778o = null;
        this.f2779p = i2;
        this.f2780q = i2;
        this.f2781r = null;
        this.f2782s = true;
        this.f2783t = true;
        this.f2784u = true;
        this.f2785v = Float.NaN;
        this.f2787x = false;
        this.mType = 5;
        this.f2703d = new HashMap();
    }

    /* renamed from: d */
    public static void m560d(RectF rectF, View view, boolean z) {
        rectF.top = view.getTop();
        rectF.bottom = view.getBottom();
        rectF.left = view.getLeft();
        rectF.right = view.getRight();
        if (z) {
            view.getMatrix().mapRect(rectF);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> hashMap) {
    }

    /* renamed from: c */
    public final void m561c(View view, String str) {
        Method method;
        boolean z;
        if (str == null) {
            return;
        }
        if (str.startsWith(".")) {
            if (str.length() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                str = str.substring(1).toLowerCase(Locale.ROOT);
            }
            for (String str2 : this.f2703d.keySet()) {
                String lowerCase = str2.toLowerCase(Locale.ROOT);
                if (z || lowerCase.matches(str)) {
                    ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f2703d.get(str2);
                    if (constraintAttribute != null) {
                        constraintAttribute.applyCustom(view);
                    }
                }
            }
            return;
        }
        if (this.f2774k.containsKey(str)) {
            method = (Method) this.f2774k.get(str);
            if (method == null) {
                return;
            }
        } else {
            method = null;
        }
        if (method == null) {
            try {
                method = view.getClass().getMethod(str, null);
                this.f2774k.put(str, method);
            } catch (NoSuchMethodException unused) {
                this.f2774k.put(str, null);
                Log.e(TypedValues.TriggerType.NAME, "Could not find method \"" + str + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view));
                return;
            }
        }
        try {
            method.invoke(view, null);
        } catch (Exception unused2) {
            Log.e(TypedValues.TriggerType.NAME, "Exception in call \"" + this.f2775l + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void conditionallyFire(float f, View view) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        View findViewById;
        boolean z6;
        if (this.f2780q != Key.UNSET) {
            if (this.f2781r == null) {
                this.f2781r = ((ViewGroup) view.getParent()).findViewById(this.f2780q);
            }
            m560d(this.f2772i, this.f2781r, this.f2787x);
            m560d(this.f2773j, view, this.f2787x);
            if (this.f2772i.intersect(this.f2773j)) {
                if (this.f2782s) {
                    this.f2782s = false;
                    z = true;
                } else {
                    z = false;
                }
                if (this.f2784u) {
                    this.f2784u = false;
                    z6 = true;
                } else {
                    z6 = false;
                }
                this.f2783t = true;
                z5 = z6;
                z3 = false;
            } else {
                if (!this.f2782s) {
                    this.f2782s = true;
                    z = true;
                } else {
                    z = false;
                }
                if (this.f2783t) {
                    this.f2783t = false;
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.f2784u = true;
                z5 = false;
            }
        } else {
            if (this.f2782s) {
                float f2 = this.f2785v;
                if ((this.f2786w - f2) * (f - f2) < RecyclerView.f7068F0) {
                    this.f2782s = false;
                    z = true;
                    if (!this.f2783t) {
                        float f3 = this.f2785v;
                        float f4 = f - f3;
                        if ((this.f2786w - f3) * f4 < RecyclerView.f7068F0 && f4 < RecyclerView.f7068F0) {
                            this.f2783t = false;
                            z2 = true;
                            if (this.f2784u) {
                                float f5 = this.f2785v;
                                float f6 = f - f5;
                                if ((this.f2786w - f5) * f6 < RecyclerView.f7068F0 && f6 > RecyclerView.f7068F0) {
                                    this.f2784u = false;
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                boolean z7 = z2;
                                z5 = z4;
                                z3 = z7;
                            } else {
                                if (Math.abs(f - this.f2785v) > this.f2768e) {
                                    this.f2784u = true;
                                }
                                z3 = z2;
                                z5 = false;
                            }
                        }
                    } else if (Math.abs(f - this.f2785v) > this.f2768e) {
                        this.f2783t = true;
                    }
                    z2 = false;
                    if (this.f2784u) {
                    }
                }
            } else if (Math.abs(f - this.f2785v) > this.f2768e) {
                this.f2782s = true;
            }
            z = false;
            if (!this.f2783t) {
            }
            z2 = false;
            if (this.f2784u) {
            }
        }
        this.f2786w = f;
        if (z3 || z || z5) {
            ((MotionLayout) view.getParent()).fireTrigger(this.f2779p, z5, f);
        }
        if (this.f2776m == Key.UNSET) {
            findViewById = view;
        } else {
            findViewById = ((MotionLayout) view.getParent()).findViewById(this.f2776m);
        }
        if (z3) {
            String str = this.f2777n;
            if (str != null) {
                m561c(findViewById, str);
            }
            if (this.f2769f != Key.UNSET) {
                ((MotionLayout) view.getParent()).viewTransition(this.f2769f, findViewById);
            }
        }
        if (z5) {
            String str2 = this.f2778o;
            if (str2 != null) {
                m561c(findViewById, str2);
            }
            if (this.f2770g != Key.UNSET) {
                ((MotionLayout) view.getParent()).viewTransition(this.f2770g, findViewById);
            }
        }
        if (z) {
            String str3 = this.f2775l;
            if (str3 != null) {
                m561c(findViewById, str3);
            }
            if (this.f2771h != Key.UNSET) {
                ((MotionLayout) view.getParent()).viewTransition(this.f2771h, findViewById);
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key key) {
        super.copy(key);
        KeyTrigger keyTrigger = (KeyTrigger) key;
        keyTrigger.getClass();
        this.f2775l = keyTrigger.f2775l;
        this.f2776m = keyTrigger.f2776m;
        this.f2777n = keyTrigger.f2777n;
        this.f2778o = keyTrigger.f2778o;
        this.f2779p = keyTrigger.f2779p;
        this.f2780q = keyTrigger.f2780q;
        this.f2781r = keyTrigger.f2781r;
        this.f2768e = keyTrigger.f2768e;
        this.f2782s = keyTrigger.f2782s;
        this.f2783t = keyTrigger.f2783t;
        this.f2784u = keyTrigger.f2784u;
        this.f2785v = keyTrigger.f2785v;
        this.f2786w = keyTrigger.f2786w;
        this.f2787x = keyTrigger.f2787x;
        this.f2772i = keyTrigger.f2772i;
        this.f2773j = keyTrigger.f2773j;
        this.f2774k = keyTrigger.f2774k;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KeyTrigger);
        SparseIntArray sparseIntArray = l71.f22377a;
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            SparseIntArray sparseIntArray2 = l71.f22377a;
            switch (sparseIntArray2.get(index)) {
                case 1:
                    this.f2777n = obtainStyledAttributes.getString(index);
                    break;
                case 2:
                    this.f2778o = obtainStyledAttributes.getString(index);
                    break;
                case 3:
                default:
                    Log.e(TypedValues.TriggerType.NAME, "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray2.get(index));
                    break;
                case 4:
                    this.f2775l = obtainStyledAttributes.getString(index);
                    break;
                case 5:
                    this.f2768e = obtainStyledAttributes.getFloat(index, this.f2768e);
                    break;
                case 6:
                    this.f2779p = obtainStyledAttributes.getResourceId(index, this.f2779p);
                    break;
                case 7:
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
                case 8:
                    int integer = obtainStyledAttributes.getInteger(index, this.f2700a);
                    this.f2700a = integer;
                    this.f2785v = (integer + 0.5f) / 100.0f;
                    break;
                case 9:
                    this.f2780q = obtainStyledAttributes.getResourceId(index, this.f2780q);
                    break;
                case 10:
                    this.f2787x = obtainStyledAttributes.getBoolean(index, this.f2787x);
                    break;
                case 11:
                    this.f2776m = obtainStyledAttributes.getResourceId(index, this.f2776m);
                    break;
                case 12:
                    this.f2771h = obtainStyledAttributes.getResourceId(index, this.f2771h);
                    break;
                case 13:
                    this.f2769f = obtainStyledAttributes.getResourceId(index, this.f2769f);
                    break;
                case 14:
                    this.f2770g = obtainStyledAttributes.getResourceId(index, this.f2770g);
                    break;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        boolean parseBoolean;
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -1594793529:
                if (str.equals("positiveCross")) {
                    c = 0;
                    break;
                }
                break;
            case -966421266:
                if (str.equals("viewTransitionOnPositiveCross")) {
                    c = 1;
                    break;
                }
                break;
            case -786670827:
                if (str.equals("triggerCollisionId")) {
                    c = 2;
                    break;
                }
                break;
            case -648752941:
                if (str.equals("triggerID")) {
                    c = 3;
                    break;
                }
                break;
            case -638126837:
                if (str.equals("negativeCross")) {
                    c = 4;
                    break;
                }
                break;
            case -76025313:
                if (str.equals("triggerCollisionView")) {
                    c = 5;
                    break;
                }
                break;
            case -9754574:
                if (str.equals("viewTransitionOnNegativeCross")) {
                    c = 6;
                    break;
                }
                break;
            case 64397344:
                if (str.equals("CROSS")) {
                    c = 7;
                    break;
                }
                break;
            case 364489912:
                if (str.equals("triggerSlack")) {
                    c = '\b';
                    break;
                }
                break;
            case 1301930599:
                if (str.equals("viewTransitionOnCross")) {
                    c = '\t';
                    break;
                }
                break;
            case 1401391082:
                if (str.equals("postLayout")) {
                    c = '\n';
                    break;
                }
                break;
            case 1535404999:
                if (str.equals("triggerReceiver")) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f2778o = obj.toString();
                return;
            case 1:
                this.f2770g = Key.m559b(obj);
                return;
            case 2:
                this.f2780q = Key.m559b(obj);
                return;
            case 3:
                this.f2779p = Key.m559b(obj);
                return;
            case 4:
                this.f2777n = obj.toString();
                return;
            case 5:
                this.f2781r = (View) obj;
                return;
            case 6:
                this.f2769f = Key.m559b(obj);
                return;
            case 7:
                this.f2775l = obj.toString();
                return;
            case '\b':
                this.f2768e = Key.m558a(obj);
                return;
            case '\t':
                this.f2771h = Key.m559b(obj);
                return;
            case '\n':
                if (obj instanceof Boolean) {
                    parseBoolean = ((Boolean) obj).booleanValue();
                } else {
                    parseBoolean = Boolean.parseBoolean(obj.toString());
                }
                this.f2787x = parseBoolean;
                return;
            case 11:
                this.f2776m = Key.m559b(obj);
                return;
            default:
                return;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: clone */
    public Key mo8476clone() {
        return new KeyTrigger().copy(this);
    }
}
