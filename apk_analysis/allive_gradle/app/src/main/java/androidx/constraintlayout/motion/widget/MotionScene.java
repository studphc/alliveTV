package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.internal.http.HttpStatusCodesKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p000.AbstractC1726qj;
import p000.ep1;
import p000.kp1;
import p000.ye0;

/* loaded from: classes.dex */
public class MotionScene {
    public static final int LAYOUT_CALL_MEASURE = 2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    public static final int UNSET = -1;

    /* renamed from: a */
    public final MotionLayout f2896a;

    /* renamed from: b */
    public final StateSet f2897b;

    /* renamed from: c */
    public Transition f2898c;

    /* renamed from: d */
    public boolean f2899d;

    /* renamed from: e */
    public final ArrayList f2900e;

    /* renamed from: f */
    public final Transition f2901f;

    /* renamed from: g */
    public final ArrayList f2902g;

    /* renamed from: h */
    public final SparseArray f2903h;

    /* renamed from: i */
    public final HashMap f2904i;

    /* renamed from: j */
    public final SparseIntArray f2905j;

    /* renamed from: k */
    public int f2906k;

    /* renamed from: l */
    public int f2907l;

    /* renamed from: m */
    public MotionEvent f2908m;

    /* renamed from: n */
    public boolean f2909n;

    /* renamed from: o */
    public boolean f2910o;

    /* renamed from: p */
    public MotionLayout.MotionTracker f2911p;

    /* renamed from: q */
    public boolean f2912q;

    /* renamed from: r */
    public final ViewTransitionController f2913r;

    /* renamed from: s */
    public float f2914s;

    /* renamed from: t */
    public float f2915t;

    public MotionScene(MotionLayout motionLayout) {
        this.f2897b = null;
        this.f2898c = null;
        this.f2899d = false;
        this.f2900e = new ArrayList();
        this.f2901f = null;
        this.f2902g = new ArrayList();
        this.f2903h = new SparseArray();
        this.f2904i = new HashMap();
        this.f2905j = new SparseIntArray();
        this.f2906k = HttpStatusCodesKt.HTTP_BAD_REQUEST;
        this.f2907l = 0;
        this.f2909n = false;
        this.f2910o = false;
        this.f2896a = motionLayout;
        this.f2913r = new ViewTransitionController(motionLayout);
    }

    /* renamed from: c */
    public static int m584c(Context context, String str) {
        int i;
        if (str.contains("/")) {
            i = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
        } else {
            i = -1;
        }
        if (i == -1) {
            if (str.length() > 1) {
                return Integer.parseInt(str.substring(1));
            }
            Log.e(TypedValues.MotionScene.NAME, "error in parsing id");
            return i;
        }
        return i;
    }

    public static String stripID(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        if (indexOf < 0) {
            return str;
        }
        return str.substring(indexOf + 1);
    }

    /* renamed from: a */
    public final boolean m585a(MotionLayout motionLayout, int i) {
        Transition transition;
        int i2;
        int i3;
        if (this.f2911p != null || this.f2899d) {
            return false;
        }
        Iterator it = this.f2900e.iterator();
        while (it.hasNext()) {
            Transition transition2 = (Transition) it.next();
            if (transition2.f2929n != 0 && ((transition = this.f2898c) != transition2 || !transition.isTransitionFlag(2))) {
                int i4 = transition2.f2919d;
                kp1 kp1Var = kp1.f22138d;
                kp1 kp1Var2 = kp1.f22137c;
                kp1 kp1Var3 = kp1.f22136b;
                if (i == i4 && ((i3 = transition2.f2929n) == 4 || i3 == 2)) {
                    motionLayout.setState(kp1Var);
                    motionLayout.setTransition(transition2);
                    if (transition2.f2929n == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(kp1Var3);
                        motionLayout.setState(kp1Var2);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.m577j(true);
                        motionLayout.setState(kp1Var3);
                        motionLayout.setState(kp1Var2);
                        motionLayout.setState(kp1Var);
                        motionLayout.m582o();
                    }
                    return true;
                }
                if (i == transition2.f2918c && ((i2 = transition2.f2929n) == 3 || i2 == 1)) {
                    motionLayout.setState(kp1Var);
                    motionLayout.setTransition(transition2);
                    if (transition2.f2929n == 3) {
                        motionLayout.transitionToStart();
                        motionLayout.setState(kp1Var3);
                        motionLayout.setState(kp1Var2);
                    } else {
                        motionLayout.setProgress(RecyclerView.f7068F0);
                        motionLayout.m577j(true);
                        motionLayout.setState(kp1Var3);
                        motionLayout.setState(kp1Var2);
                        motionLayout.setState(kp1Var);
                        motionLayout.m582o();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void addOnClickListeners(MotionLayout motionLayout, int i) {
        ArrayList arrayList = this.f2900e;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Transition transition = (Transition) it.next();
            if (transition.f2928m.size() > 0) {
                Iterator it2 = transition.f2928m.iterator();
                while (it2.hasNext()) {
                    ((Transition.TransitionOnClick) it2.next()).removeOnClickListeners(motionLayout);
                }
            }
        }
        ArrayList arrayList2 = this.f2902g;
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            Transition transition2 = (Transition) it3.next();
            if (transition2.f2928m.size() > 0) {
                Iterator it4 = transition2.f2928m.iterator();
                while (it4.hasNext()) {
                    ((Transition.TransitionOnClick) it4.next()).removeOnClickListeners(motionLayout);
                }
            }
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            Transition transition3 = (Transition) it5.next();
            if (transition3.f2928m.size() > 0) {
                Iterator it6 = transition3.f2928m.iterator();
                while (it6.hasNext()) {
                    ((Transition.TransitionOnClick) it6.next()).addOnClickListeners(motionLayout, i, transition3);
                }
            }
        }
        Iterator it7 = arrayList2.iterator();
        while (it7.hasNext()) {
            Transition transition4 = (Transition) it7.next();
            if (transition4.f2928m.size() > 0) {
                Iterator it8 = transition4.f2928m.iterator();
                while (it8.hasNext()) {
                    ((Transition.TransitionOnClick) it8.next()).addOnClickListeners(motionLayout, i, transition4);
                }
            }
        }
    }

    public void addTransition(Transition transition) {
        int m587d = m587d(transition);
        ArrayList arrayList = this.f2900e;
        if (m587d == -1) {
            arrayList.add(transition);
        } else {
            arrayList.set(m587d, transition);
        }
    }

    public boolean applyViewTransition(int i, MotionController motionController) {
        Iterator it = this.f2913r.f2979b.iterator();
        while (it.hasNext()) {
            ViewTransition viewTransition = (ViewTransition) it.next();
            if (viewTransition.f2956a == i) {
                viewTransition.f2961f.addAllFrames(motionController);
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final ConstraintSet m586b(int i) {
        int stateGetConstraintID;
        StateSet stateSet = this.f2897b;
        if (stateSet != null && (stateGetConstraintID = stateSet.stateGetConstraintID(i, -1, -1)) != -1) {
            i = stateGetConstraintID;
        }
        SparseArray sparseArray = this.f2903h;
        if (sparseArray.get(i) == null) {
            Log.e(TypedValues.MotionScene.NAME, "Warning could not find ConstraintSet id/" + Debug.getName(this.f2896a.getContext(), i) + " In MotionScene");
            return (ConstraintSet) sparseArray.get(sparseArray.keyAt(0));
        }
        return (ConstraintSet) sparseArray.get(i);
    }

    public Transition bestTransitionFor(int i, float f, float f2, MotionEvent motionEvent) {
        C0128c c0128c;
        float f3;
        if (i != -1) {
            List<Transition> transitionsWithState = getTransitionsWithState(i);
            RectF rectF = new RectF();
            float f4 = RecyclerView.f7068F0;
            Transition transition = null;
            for (Transition transition2 : transitionsWithState) {
                if (!transition2.f2930o && (c0128c = transition2.f2927l) != null) {
                    c0128c.m612c(this.f2912q);
                    C0128c c0128c2 = transition2.f2927l;
                    MotionLayout motionLayout = this.f2896a;
                    RectF m611b = c0128c2.m611b(motionLayout, rectF);
                    if (m611b == null || motionEvent == null || m611b.contains(motionEvent.getX(), motionEvent.getY())) {
                        RectF m610a = transition2.f2927l.m610a(motionLayout, rectF);
                        if (m610a == null || motionEvent == null || m610a.contains(motionEvent.getX(), motionEvent.getY())) {
                            C0128c c0128c3 = transition2.f2927l;
                            float f5 = (c0128c3.f3010l * f2) + (c0128c3.f3009k * f);
                            if (c0128c3.f3008j && motionEvent != null) {
                                float x = motionEvent.getX();
                                transition2.f2927l.getClass();
                                float y = motionEvent.getY();
                                transition2.f2927l.getClass();
                                f5 = ((float) (Math.atan2(f2 + r9, f + r7) - Math.atan2(x - 0.5f, y - 0.5f))) * 10.0f;
                            }
                            if (transition2.f2918c == i) {
                                f3 = -1.0f;
                            } else {
                                f3 = 1.1f;
                            }
                            float f6 = f5 * f3;
                            if (f6 > f4) {
                                transition = transition2;
                                f4 = f6;
                            }
                        }
                    }
                }
            }
            return transition;
        }
        return this.f2898c;
    }

    /* renamed from: d */
    public final int m587d(Transition transition) {
        int i = transition.f2916a;
        if (i != -1) {
            int i2 = 0;
            while (true) {
                ArrayList arrayList = this.f2900e;
                if (i2 >= arrayList.size()) {
                    return -1;
                }
                if (((Transition) arrayList.get(i2)).f2916a == i) {
                    return i2;
                }
                i2++;
            }
        } else {
            throw new IllegalArgumentException("The transition must have an id");
        }
    }

    public void disableAutoTransition(boolean z) {
        this.f2899d = z;
    }

    /* renamed from: e */
    public final Key m588e(int i, int i2, int i3) {
        Transition transition = this.f2898c;
        if (transition == null) {
            return null;
        }
        Iterator it = transition.f2926k.iterator();
        while (it.hasNext()) {
            KeyFrames keyFrames = (KeyFrames) it.next();
            for (Integer num : keyFrames.getKeys()) {
                if (i2 == num.intValue()) {
                    Iterator<Key> it2 = keyFrames.getKeyFramesForView(num.intValue()).iterator();
                    while (it2.hasNext()) {
                        Key next = it2.next();
                        if (next.f2700a == i3 && next.mType == i) {
                            return next;
                        }
                    }
                }
            }
        }
        return null;
    }

    public void enableViewTransition(int i, boolean z) {
        Iterator it = this.f2913r.f2979b.iterator();
        while (it.hasNext()) {
            ViewTransition viewTransition = (ViewTransition) it.next();
            if (viewTransition.f2956a == i) {
                viewTransition.f2958c = !z;
                return;
            }
        }
    }

    /* renamed from: f */
    public final float m589f() {
        C0128c c0128c;
        Transition transition = this.f2898c;
        if (transition != null && (c0128c = transition.f2927l) != null) {
            return c0128c.f3018t;
        }
        return RecyclerView.f7068F0;
    }

    /* renamed from: g */
    public final int m590g() {
        Transition transition = this.f2898c;
        if (transition == null) {
            return -1;
        }
        return transition.f2919d;
    }

    public int gatPathMotionArc() {
        Transition transition = this.f2898c;
        if (transition != null) {
            return transition.f2931p;
        }
        return -1;
    }

    public ConstraintSet getConstraintSet(Context context, String str) {
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.f2903h;
            if (i < sparseArray.size()) {
                int keyAt = sparseArray.keyAt(i);
                if (str.equals(context.getResources().getResourceName(keyAt))) {
                    return (ConstraintSet) sparseArray.get(keyAt);
                }
                i++;
            } else {
                return null;
            }
        }
    }

    public int[] getConstraintSetIds() {
        SparseArray sparseArray = this.f2903h;
        int size = sparseArray.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = sparseArray.keyAt(i);
        }
        return iArr;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.f2900e;
    }

    public int getDuration() {
        Transition transition = this.f2898c;
        if (transition != null) {
            return transition.f2923h;
        }
        return this.f2906k;
    }

    public Interpolator getInterpolator() {
        Transition transition = this.f2898c;
        int i = transition.f2920e;
        if (i != -2) {
            if (i != -1) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 4) {
                                if (i != 5) {
                                    if (i != 6) {
                                        return null;
                                    }
                                    return new AnticipateInterpolator();
                                }
                                return new OvershootInterpolator();
                            }
                            return new BounceInterpolator();
                        }
                        return new DecelerateInterpolator();
                    }
                    return new AccelerateInterpolator();
                }
                return new AccelerateDecelerateInterpolator();
            }
            return new ep1(Easing.getInterpolator(transition.f2921f), 1);
        }
        return AnimationUtils.loadInterpolator(this.f2896a.getContext(), this.f2898c.f2922g);
    }

    public void getKeyFrames(MotionController motionController) {
        Transition transition = this.f2898c;
        if (transition == null) {
            Transition transition2 = this.f2901f;
            if (transition2 != null) {
                Iterator it = transition2.f2926k.iterator();
                while (it.hasNext()) {
                    ((KeyFrames) it.next()).addFrames(motionController);
                }
                return;
            }
            return;
        }
        Iterator it2 = transition.f2926k.iterator();
        while (it2.hasNext()) {
            ((KeyFrames) it2.next()).addFrames(motionController);
        }
    }

    public int[] getMatchingStateLabels(String... strArr) {
        SparseArray sparseArray = this.f2903h;
        int size = sparseArray.size();
        int[] iArr = new int[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintSet constraintSet = (ConstraintSet) sparseArray.valueAt(i2);
            int keyAt = sparseArray.keyAt(i2);
            if (constraintSet.matchesLabels(strArr)) {
                constraintSet.getStateLabels();
                iArr[i] = keyAt;
                i++;
            }
        }
        return Arrays.copyOf(iArr, i);
    }

    public float getPathPercent(View view, int i) {
        return RecyclerView.f7068F0;
    }

    public float getStaggered() {
        Transition transition = this.f2898c;
        if (transition != null) {
            return transition.f2924i;
        }
        return RecyclerView.f7068F0;
    }

    public Transition getTransitionById(int i) {
        Iterator it = this.f2900e.iterator();
        while (it.hasNext()) {
            Transition transition = (Transition) it.next();
            if (transition.f2916a == i) {
                return transition;
            }
        }
        return null;
    }

    public List<Transition> getTransitionsWithState(int i) {
        int stateGetConstraintID;
        StateSet stateSet = this.f2897b;
        if (stateSet != null && (stateGetConstraintID = stateSet.stateGetConstraintID(i, -1, -1)) != -1) {
            i = stateGetConstraintID;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f2900e.iterator();
        while (it.hasNext()) {
            Transition transition = (Transition) it.next();
            if (transition.f2919d == i || transition.f2918c == i) {
                arrayList.add(transition);
            }
        }
        return arrayList;
    }

    /* renamed from: h */
    public final int m591h(Context context, XmlResourceParser xmlResourceParser) {
        char c;
        char c2;
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.setForceId(false);
        int attributeCount = xmlResourceParser.getAttributeCount();
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributeName = xmlResourceParser.getAttributeName(i3);
            String attributeValue = xmlResourceParser.getAttributeValue(i3);
            attributeName.getClass();
            switch (attributeName.hashCode()) {
                case -1496482599:
                    if (attributeName.equals("deriveConstraintsFrom")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1153153640:
                    if (attributeName.equals("constraintRotate")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3355:
                    if (attributeName.equals("id")) {
                        c = 2;
                        break;
                    }
                    break;
                case 973381616:
                    if (attributeName.equals("stateLabels")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            c = 65535;
            switch (c) {
                case 0:
                    i2 = m584c(context, attributeValue);
                    break;
                case 1:
                    try {
                        constraintSet.mRotate = Integer.parseInt(attributeValue);
                        break;
                    } catch (NumberFormatException unused) {
                        attributeValue.getClass();
                        switch (attributeValue.hashCode()) {
                            case -768416914:
                                if (attributeValue.equals("x_left")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (attributeValue.equals("left")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 3387192:
                                if (attributeValue.equals(SchedulerSupport.NONE)) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (attributeValue.equals("right")) {
                                    c2 = 3;
                                    break;
                                }
                                break;
                            case 1954540437:
                                if (attributeValue.equals("x_right")) {
                                    c2 = 4;
                                    break;
                                }
                                break;
                        }
                        c2 = 65535;
                        switch (c2) {
                            case 0:
                                constraintSet.mRotate = 4;
                                break;
                            case 1:
                                constraintSet.mRotate = 2;
                                break;
                            case 2:
                                constraintSet.mRotate = 0;
                                break;
                            case 3:
                                constraintSet.mRotate = 1;
                                break;
                            case 4:
                                constraintSet.mRotate = 3;
                                break;
                        }
                    }
                    break;
                case 2:
                    i = m584c(context, attributeValue);
                    this.f2904i.put(stripID(attributeValue), Integer.valueOf(i));
                    constraintSet.mIdString = Debug.getName(context, i);
                    break;
                case 3:
                    constraintSet.setStateLabels(attributeValue);
                    break;
            }
        }
        if (i != -1) {
            if (this.f2896a.f2847L != 0) {
                constraintSet.setValidateOnParse(true);
            }
            constraintSet.load(context, xmlResourceParser);
            if (i2 != -1) {
                this.f2905j.put(i, i2);
            }
            this.f2903h.put(i, constraintSet);
        }
        return i;
    }

    /* renamed from: i */
    public final int m592i(int i, Context context) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && "ConstraintSet".equals(name)) {
                    i = m591h(context, xml);
                    return i;
                }
            }
            return -1;
        } catch (IOException e) {
            Log.e(TypedValues.MotionScene.NAME, "Error parsing resource: " + i, e);
            return -1;
        } catch (XmlPullParserException e2) {
            Log.e(TypedValues.MotionScene.NAME, "Error parsing resource: " + i, e2);
            return -1;
        }
    }

    public boolean isViewTransitionEnabled(int i) {
        Iterator it = this.f2913r.f2979b.iterator();
        while (it.hasNext()) {
            if (((ViewTransition) it.next()).f2956a == i) {
                return !r1.f2958c;
            }
        }
        return false;
    }

    /* renamed from: j */
    public final void m593j(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.include);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.include_constraintSet) {
                m592i(obtainStyledAttributes.getResourceId(index, -1), context);
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: k */
    public final void m594k(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.MotionScene_defaultDuration) {
                int i2 = obtainStyledAttributes.getInt(index, this.f2906k);
                this.f2906k = i2;
                if (i2 < 8) {
                    this.f2906k = 8;
                }
            } else if (index == R.styleable.MotionScene_layoutDuringTransition) {
                this.f2907l = obtainStyledAttributes.getInteger(index, 0);
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: l */
    public final void m595l(MotionLayout motionLayout, int i) {
        SparseArray sparseArray = this.f2903h;
        ConstraintSet constraintSet = (ConstraintSet) sparseArray.get(i);
        constraintSet.derivedState = constraintSet.mIdString;
        int i2 = this.f2905j.get(i);
        if (i2 > 0) {
            m595l(motionLayout, i2);
            ConstraintSet constraintSet2 = (ConstraintSet) sparseArray.get(i2);
            if (constraintSet2 == null) {
                Log.e(TypedValues.MotionScene.NAME, "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.getName(this.f2896a.getContext(), i2));
                return;
            } else {
                constraintSet.derivedState += "/" + constraintSet2.derivedState;
                constraintSet.readFallback(constraintSet2);
            }
        } else {
            constraintSet.derivedState = AbstractC1726qj.m7061q(new StringBuilder(), constraintSet.derivedState, "  layout");
            constraintSet.readFallback(motionLayout);
        }
        constraintSet.applyDeltaFrom(constraintSet);
    }

    public int lookUpConstraintId(String str) {
        Integer num = (Integer) this.f2904i.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String lookUpConstraintName(int i) {
        for (Map.Entry entry : this.f2904i.entrySet()) {
            Integer num = (Integer) entry.getValue();
            if (num != null && num.intValue() == i) {
                return (String) entry.getKey();
            }
        }
        return null;
    }

    /* renamed from: m */
    public final void m596m(MotionLayout motionLayout) {
        int i = 0;
        loop0: while (true) {
            SparseArray sparseArray = this.f2903h;
            if (i < sparseArray.size()) {
                int keyAt = sparseArray.keyAt(i);
                SparseIntArray sparseIntArray = this.f2905j;
                int i2 = sparseIntArray.get(keyAt);
                int size = sparseIntArray.size();
                while (i2 > 0) {
                    if (i2 == keyAt) {
                        break loop0;
                    }
                    int i3 = size - 1;
                    if (size < 0) {
                        break loop0;
                    }
                    i2 = sparseIntArray.get(i2);
                    size = i3;
                }
                m595l(motionLayout, keyAt);
                i++;
            } else {
                return;
            }
        }
        Log.e(TypedValues.MotionScene.NAME, "Cannot be derived from yourself");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (r2 != (-1)) goto L13;
     */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m597n(int i, int i2) {
        int i3;
        int i4;
        StateSet stateSet = this.f2897b;
        if (stateSet != null) {
            i3 = stateSet.stateGetConstraintID(i, -1, -1);
            if (i3 == -1) {
                i3 = i;
            }
            i4 = this.f2897b.stateGetConstraintID(i2, -1, -1);
        } else {
            i3 = i;
        }
        i4 = i2;
        Transition transition = this.f2898c;
        if (transition != null && transition.f2918c == i2 && transition.f2919d == i) {
            return;
        }
        ArrayList arrayList = this.f2900e;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Transition transition2 = (Transition) it.next();
            int i5 = transition2.f2918c;
            if ((i5 == i4 && transition2.f2919d == i3) || (i5 == i2 && transition2.f2919d == i)) {
                this.f2898c = transition2;
                C0128c c0128c = transition2.f2927l;
                if (c0128c != null) {
                    c0128c.m612c(this.f2912q);
                    return;
                }
                return;
            }
        }
        Transition transition3 = this.f2901f;
        Iterator it2 = this.f2902g.iterator();
        while (it2.hasNext()) {
            Transition transition4 = (Transition) it2.next();
            if (transition4.f2918c == i2) {
                transition3 = transition4;
            }
        }
        Transition transition5 = new Transition(this, transition3);
        transition5.f2919d = i3;
        transition5.f2918c = i4;
        if (i3 != -1) {
            arrayList.add(transition5);
        }
        this.f2898c = transition5;
    }

    /* renamed from: o */
    public final boolean m598o() {
        Iterator it = this.f2900e.iterator();
        while (it.hasNext()) {
            if (((Transition) it.next()).f2927l != null) {
                return true;
            }
        }
        Transition transition = this.f2898c;
        if (transition != null && transition.f2927l != null) {
            return true;
        }
        return false;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public void removeTransition(Transition transition) {
        int m587d = m587d(transition);
        if (m587d != -1) {
            this.f2900e.remove(m587d);
        }
    }

    public void setConstraintSet(int i, ConstraintSet constraintSet) {
        this.f2903h.put(i, constraintSet);
    }

    public void setDuration(int i) {
        Transition transition = this.f2898c;
        if (transition != null) {
            transition.setDuration(i);
        } else {
            this.f2906k = i;
        }
    }

    public void setKeyframe(View view, int i, String str, Object obj) {
        Transition transition = this.f2898c;
        if (transition == null) {
            return;
        }
        Iterator it = transition.f2926k.iterator();
        while (it.hasNext()) {
            Iterator<Key> it2 = ((KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
            while (it2.hasNext()) {
                if (it2.next().f2700a == i && obj != null) {
                }
            }
        }
    }

    public void setRtl(boolean z) {
        C0128c c0128c;
        this.f2912q = z;
        Transition transition = this.f2898c;
        if (transition != null && (c0128c = transition.f2927l) != null) {
            c0128c.m612c(z);
        }
    }

    public void setTransition(Transition transition) {
        C0128c c0128c;
        this.f2898c = transition;
        if (transition != null && (c0128c = transition.f2927l) != null) {
            c0128c.m612c(this.f2912q);
        }
    }

    public boolean validateLayout(MotionLayout motionLayout) {
        if (motionLayout == this.f2896a && motionLayout.f2878r == this) {
            return true;
        }
        return false;
    }

    public void viewTransition(int i, View... viewArr) {
        String str;
        ViewTransitionController viewTransitionController = this.f2913r;
        viewTransitionController.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it = viewTransitionController.f2979b.iterator();
        ViewTransition viewTransition = null;
        while (true) {
            boolean hasNext = it.hasNext();
            str = viewTransitionController.f2981d;
            if (!hasNext) {
                break;
            }
            ViewTransition viewTransition2 = (ViewTransition) it.next();
            if (viewTransition2.f2956a == i) {
                for (View view : viewArr) {
                    if (viewTransition2.m600b(view)) {
                        arrayList.add(view);
                    }
                }
                if (!arrayList.isEmpty()) {
                    View[] viewArr2 = (View[]) arrayList.toArray(new View[0]);
                    MotionLayout motionLayout = viewTransitionController.f2978a;
                    int currentState = motionLayout.getCurrentState();
                    if (viewTransition2.f2960e != 2) {
                        if (currentState == -1) {
                            Log.w(str, "No support for ViewTransition within transition yet. Currently: " + motionLayout.toString());
                        } else {
                            ConstraintSet constraintSet = motionLayout.getConstraintSet(currentState);
                            if (constraintSet != null) {
                                viewTransition2.m599a(viewTransitionController, viewTransitionController.f2978a, currentState, constraintSet, viewArr2);
                            }
                        }
                    } else {
                        viewTransition2.m599a(viewTransitionController, viewTransitionController.f2978a, currentState, null, viewArr2);
                    }
                    arrayList.clear();
                }
                viewTransition = viewTransition2;
            }
        }
        if (viewTransition == null) {
            Log.e(str, " Could not find ViewTransition");
        }
    }

    /* loaded from: classes.dex */
    public static class Transition {
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        public static final int INTERPOLATE_ANTICIPATE = 6;
        public static final int INTERPOLATE_BOUNCE = 4;
        public static final int INTERPOLATE_EASE_IN = 1;
        public static final int INTERPOLATE_EASE_IN_OUT = 0;
        public static final int INTERPOLATE_EASE_OUT = 2;
        public static final int INTERPOLATE_LINEAR = 3;
        public static final int INTERPOLATE_OVERSHOOT = 5;
        public static final int INTERPOLATE_REFERENCE_ID = -2;
        public static final int INTERPOLATE_SPLINE_STRING = -1;

        /* renamed from: a */
        public final int f2916a;

        /* renamed from: b */
        public final boolean f2917b;

        /* renamed from: c */
        public int f2918c;

        /* renamed from: d */
        public int f2919d;

        /* renamed from: e */
        public int f2920e;

        /* renamed from: f */
        public String f2921f;

        /* renamed from: g */
        public int f2922g;

        /* renamed from: h */
        public int f2923h;

        /* renamed from: i */
        public float f2924i;

        /* renamed from: j */
        public final MotionScene f2925j;

        /* renamed from: k */
        public final ArrayList f2926k;

        /* renamed from: l */
        public C0128c f2927l;

        /* renamed from: m */
        public final ArrayList f2928m;

        /* renamed from: n */
        public int f2929n;

        /* renamed from: o */
        public boolean f2930o;

        /* renamed from: p */
        public int f2931p;

        /* renamed from: q */
        public int f2932q;

        /* renamed from: r */
        public int f2933r;

        public Transition(MotionScene motionScene, Transition transition) {
            this.f2916a = -1;
            this.f2917b = false;
            this.f2918c = -1;
            this.f2919d = -1;
            this.f2920e = 0;
            this.f2921f = null;
            this.f2922g = -1;
            this.f2923h = HttpStatusCodesKt.HTTP_BAD_REQUEST;
            this.f2924i = RecyclerView.f7068F0;
            this.f2926k = new ArrayList();
            this.f2927l = null;
            this.f2928m = new ArrayList();
            this.f2929n = 0;
            this.f2930o = false;
            this.f2931p = -1;
            this.f2932q = 0;
            this.f2933r = 0;
            this.f2925j = motionScene;
            this.f2923h = motionScene.f2906k;
            if (transition != null) {
                this.f2931p = transition.f2931p;
                this.f2920e = transition.f2920e;
                this.f2921f = transition.f2921f;
                this.f2922g = transition.f2922g;
                this.f2923h = transition.f2923h;
                this.f2926k = transition.f2926k;
                this.f2924i = transition.f2924i;
                this.f2932q = transition.f2932q;
            }
        }

        public void addKeyFrame(KeyFrames keyFrames) {
            this.f2926k.add(keyFrames);
        }

        public void addOnClick(int i, int i2) {
            ArrayList arrayList = this.f2928m;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                TransitionOnClick transitionOnClick = (TransitionOnClick) it.next();
                if (transitionOnClick.f2935b == i) {
                    transitionOnClick.f2936c = i2;
                    return;
                }
            }
            arrayList.add(new TransitionOnClick(this, i, i2));
        }

        public String debugString(Context context) {
            String resourceEntryName;
            if (this.f2919d == -1) {
                resourceEntryName = "null";
            } else {
                resourceEntryName = context.getResources().getResourceEntryName(this.f2919d);
            }
            if (this.f2918c == -1) {
                return AbstractC1726qj.m7057m(resourceEntryName, " -> null");
            }
            StringBuilder m8303w = ye0.m8303w(resourceEntryName, " -> ");
            m8303w.append(context.getResources().getResourceEntryName(this.f2918c));
            return m8303w.toString();
        }

        public int getAutoTransition() {
            return this.f2929n;
        }

        public int getDuration() {
            return this.f2923h;
        }

        public int getEndConstraintSetId() {
            return this.f2918c;
        }

        public int getId() {
            return this.f2916a;
        }

        public List<KeyFrames> getKeyFrameList() {
            return this.f2926k;
        }

        public int getLayoutDuringTransition() {
            return this.f2932q;
        }

        public List<TransitionOnClick> getOnClickList() {
            return this.f2928m;
        }

        public int getPathMotionArc() {
            return this.f2931p;
        }

        public float getStagger() {
            return this.f2924i;
        }

        public int getStartConstraintSetId() {
            return this.f2919d;
        }

        public C0128c getTouchResponse() {
            return this.f2927l;
        }

        public boolean isEnabled() {
            return !this.f2930o;
        }

        public boolean isTransitionFlag(int i) {
            if ((i & this.f2933r) != 0) {
                return true;
            }
            return false;
        }

        public void removeOnClick(int i) {
            TransitionOnClick transitionOnClick;
            ArrayList arrayList = this.f2928m;
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    transitionOnClick = (TransitionOnClick) it.next();
                    if (transitionOnClick.f2935b == i) {
                        break;
                    }
                } else {
                    transitionOnClick = null;
                    break;
                }
            }
            if (transitionOnClick != null) {
                arrayList.remove(transitionOnClick);
            }
        }

        public void setAutoTransition(int i) {
            this.f2929n = i;
        }

        public void setDuration(int i) {
            this.f2923h = Math.max(i, 8);
        }

        public void setEnabled(boolean z) {
            this.f2930o = !z;
        }

        public void setInterpolatorInfo(int i, String str, int i2) {
            this.f2920e = i;
            this.f2921f = str;
            this.f2922g = i2;
        }

        public void setLayoutDuringTransition(int i) {
            this.f2932q = i;
        }

        public void setOnSwipe(OnSwipe onSwipe) {
            C0128c c0128c;
            if (onSwipe == null) {
                c0128c = null;
            } else {
                c0128c = new C0128c(this.f2925j.f2896a, onSwipe);
            }
            this.f2927l = c0128c;
        }

        public void setOnTouchUp(int i) {
            C0128c touchResponse = getTouchResponse();
            if (touchResponse != null) {
                touchResponse.f3001c = i;
            }
        }

        public void setPathMotionArc(int i) {
            this.f2931p = i;
        }

        public void setStagger(float f) {
            this.f2924i = f;
        }

        public void setTransitionFlag(int i) {
            this.f2933r = i;
        }

        public void addOnClick(Context context, XmlPullParser xmlPullParser) {
            this.f2928m.add(new TransitionOnClick(context, this, xmlPullParser));
        }

        /* loaded from: classes.dex */
        public static class TransitionOnClick implements View.OnClickListener {
            public static final int ANIM_TOGGLE = 17;
            public static final int ANIM_TO_END = 1;
            public static final int ANIM_TO_START = 16;
            public static final int JUMP_TO_END = 256;
            public static final int JUMP_TO_START = 4096;

            /* renamed from: a */
            public final Transition f2934a;

            /* renamed from: b */
            public final int f2935b;

            /* renamed from: c */
            public int f2936c;

            public TransitionOnClick(Context context, Transition transition, XmlPullParser xmlPullParser) {
                this.f2935b = -1;
                this.f2936c = 17;
                this.f2934a = transition;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i = 0; i < indexCount; i++) {
                    int index = obtainStyledAttributes.getIndex(i);
                    if (index == R.styleable.OnClick_targetId) {
                        this.f2935b = obtainStyledAttributes.getResourceId(index, this.f2935b);
                    } else if (index == R.styleable.OnClick_clickAction) {
                        this.f2936c = obtainStyledAttributes.getInt(index, this.f2936c);
                    }
                }
                obtainStyledAttributes.recycle();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r7v4, types: [android.view.View] */
            public void addOnClickListeners(MotionLayout motionLayout, int i, Transition transition) {
                boolean z;
                boolean z2;
                boolean z3;
                boolean z4;
                int i2 = this.f2935b;
                MotionLayout motionLayout2 = motionLayout;
                if (i2 != -1) {
                    motionLayout2 = motionLayout.findViewById(i2);
                }
                if (motionLayout2 == null) {
                    Log.e(TypedValues.MotionScene.NAME, "OnClick could not find id " + i2);
                    return;
                }
                int i3 = transition.f2919d;
                int i4 = transition.f2918c;
                if (i3 == -1) {
                    motionLayout2.setOnClickListener(this);
                    return;
                }
                int i5 = this.f2936c;
                boolean z5 = false;
                if ((i5 & 1) != 0 && i == i3) {
                    z = true;
                } else {
                    z = false;
                }
                if ((i5 & 256) != 0 && i == i3) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z6 = z | z2;
                if ((i5 & 1) != 0 && i == i3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean z7 = z3 | z6;
                if ((i5 & 16) != 0 && i == i4) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z8 = z7 | z4;
                if ((i5 & 4096) != 0 && i == i4) {
                    z5 = true;
                }
                if (z8 | z5) {
                    motionLayout2.setOnClickListener(this);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onClick(View view) {
                boolean z;
                boolean z2;
                Transition transition = this.f2934a;
                MotionLayout motionLayout = transition.f2925j.f2896a;
                if (!motionLayout.isInteractionEnabled()) {
                    return;
                }
                if (transition.f2919d == -1) {
                    int currentState = motionLayout.getCurrentState();
                    if (currentState == -1) {
                        motionLayout.transitionToState(transition.f2918c);
                        return;
                    }
                    Transition transition2 = new Transition(transition.f2925j, transition);
                    transition2.f2919d = currentState;
                    transition2.f2918c = transition.f2918c;
                    motionLayout.setTransition(transition2);
                    motionLayout.transitionToEnd();
                    return;
                }
                Transition transition3 = transition.f2925j.f2898c;
                int i = this.f2936c;
                boolean z3 = false;
                if ((i & 1) == 0 && (i & 256) == 0) {
                    z = false;
                } else {
                    z = true;
                }
                if ((i & 16) == 0 && (i & 4096) == 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z && z2) {
                    if (transition3 != transition) {
                        motionLayout.setTransition(transition);
                    }
                    if (motionLayout.getCurrentState() != motionLayout.getEndState() && motionLayout.getProgress() <= 0.5f) {
                        z2 = false;
                    }
                    if (transition != transition3) {
                        int i2 = transition.f2918c;
                        int i3 = transition.f2919d;
                        if (i3 == -1) {
                            if (motionLayout.f2888w == i2) {
                                return;
                            }
                        } else {
                            int i4 = motionLayout.f2888w;
                            if (i4 != i3 && i4 != i2) {
                                return;
                            }
                        }
                    }
                    if (!z3 && (this.f2936c & 1) != 0) {
                        motionLayout.setTransition(transition);
                        motionLayout.transitionToEnd();
                        return;
                    }
                    if (!z2 && (this.f2936c & 16) != 0) {
                        motionLayout.setTransition(transition);
                        motionLayout.transitionToStart();
                        return;
                    } else if (!z3 && (this.f2936c & 256) != 0) {
                        motionLayout.setTransition(transition);
                        motionLayout.setProgress(1.0f);
                        return;
                    } else if (!z2 && (this.f2936c & 4096) != 0) {
                        motionLayout.setTransition(transition);
                        motionLayout.setProgress(RecyclerView.f7068F0);
                        return;
                    }
                }
                z3 = z;
                if (transition != transition3) {
                }
                if (!z3) {
                }
                if (!z2) {
                }
                if (!z3) {
                }
                if (!z2) {
                }
            }

            public void removeOnClickListeners(MotionLayout motionLayout) {
                int i = this.f2935b;
                if (i == -1) {
                    return;
                }
                View findViewById = motionLayout.findViewById(i);
                if (findViewById == null) {
                    Log.e(TypedValues.MotionScene.NAME, " (*)  could not find id " + i);
                    return;
                }
                findViewById.setOnClickListener(null);
            }

            public TransitionOnClick(Transition transition, int i, int i2) {
                this.f2934a = transition;
                this.f2935b = i;
                this.f2936c = i2;
            }
        }

        public Transition(int i, MotionScene motionScene, int i2, int i3) {
            this.f2916a = -1;
            this.f2917b = false;
            this.f2918c = -1;
            this.f2919d = -1;
            this.f2920e = 0;
            this.f2921f = null;
            this.f2922g = -1;
            this.f2923h = HttpStatusCodesKt.HTTP_BAD_REQUEST;
            this.f2924i = RecyclerView.f7068F0;
            this.f2926k = new ArrayList();
            this.f2927l = null;
            this.f2928m = new ArrayList();
            this.f2929n = 0;
            this.f2930o = false;
            this.f2931p = -1;
            this.f2932q = 0;
            this.f2933r = 0;
            this.f2916a = i;
            this.f2925j = motionScene;
            this.f2919d = i2;
            this.f2918c = i3;
            this.f2923h = motionScene.f2906k;
            this.f2932q = motionScene.f2907l;
        }

        public Transition(MotionScene motionScene, Context context, XmlResourceParser xmlResourceParser) {
            this.f2916a = -1;
            this.f2917b = false;
            this.f2918c = -1;
            this.f2919d = -1;
            this.f2920e = 0;
            this.f2921f = null;
            this.f2922g = -1;
            this.f2923h = HttpStatusCodesKt.HTTP_BAD_REQUEST;
            this.f2924i = RecyclerView.f7068F0;
            this.f2926k = new ArrayList();
            this.f2927l = null;
            this.f2928m = new ArrayList();
            this.f2929n = 0;
            this.f2930o = false;
            this.f2931p = -1;
            this.f2932q = 0;
            this.f2933r = 0;
            this.f2923h = motionScene.f2906k;
            this.f2932q = motionScene.f2907l;
            this.f2925j = motionScene;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.Transition);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                int i2 = R.styleable.Transition_constraintSetEnd;
                SparseArray sparseArray = motionScene.f2903h;
                if (index == i2) {
                    this.f2918c = obtainStyledAttributes.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f2918c);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.load(context, this.f2918c);
                        sparseArray.append(this.f2918c, constraintSet);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.f2918c = motionScene.m592i(this.f2918c, context);
                    }
                } else if (index == R.styleable.Transition_constraintSetStart) {
                    this.f2919d = obtainStyledAttributes.getResourceId(index, this.f2919d);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.f2919d);
                    if ("layout".equals(resourceTypeName2)) {
                        ConstraintSet constraintSet2 = new ConstraintSet();
                        constraintSet2.load(context, this.f2919d);
                        sparseArray.append(this.f2919d, constraintSet2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.f2919d = motionScene.m592i(this.f2919d, context);
                    }
                } else if (index == R.styleable.Transition_motionInterpolator) {
                    int i3 = obtainStyledAttributes.peekValue(index).type;
                    if (i3 == 1) {
                        int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                        this.f2922g = resourceId;
                        if (resourceId != -1) {
                            this.f2920e = -2;
                        }
                    } else if (i3 == 3) {
                        String string = obtainStyledAttributes.getString(index);
                        this.f2921f = string;
                        if (string != null) {
                            if (string.indexOf("/") > 0) {
                                this.f2922g = obtainStyledAttributes.getResourceId(index, -1);
                                this.f2920e = -2;
                            } else {
                                this.f2920e = -1;
                            }
                        }
                    } else {
                        this.f2920e = obtainStyledAttributes.getInteger(index, this.f2920e);
                    }
                } else if (index == R.styleable.Transition_duration) {
                    int i4 = obtainStyledAttributes.getInt(index, this.f2923h);
                    this.f2923h = i4;
                    if (i4 < 8) {
                        this.f2923h = 8;
                    }
                } else if (index == R.styleable.Transition_staggered) {
                    this.f2924i = obtainStyledAttributes.getFloat(index, this.f2924i);
                } else if (index == R.styleable.Transition_autoTransition) {
                    this.f2929n = obtainStyledAttributes.getInteger(index, this.f2929n);
                } else if (index == R.styleable.Transition_android_id) {
                    this.f2916a = obtainStyledAttributes.getResourceId(index, this.f2916a);
                } else if (index == R.styleable.Transition_transitionDisable) {
                    this.f2930o = obtainStyledAttributes.getBoolean(index, this.f2930o);
                } else if (index == R.styleable.Transition_pathMotionArc) {
                    this.f2931p = obtainStyledAttributes.getInteger(index, -1);
                } else if (index == R.styleable.Transition_layoutDuringTransition) {
                    this.f2932q = obtainStyledAttributes.getInteger(index, 0);
                } else if (index == R.styleable.Transition_transitionFlags) {
                    this.f2933r = obtainStyledAttributes.getInteger(index, 0);
                }
            }
            if (this.f2919d == -1) {
                this.f2917b = true;
            }
            obtainStyledAttributes.recycle();
        }
    }

    public MotionScene(Context context, MotionLayout motionLayout, int i) {
        int eventType;
        Transition transition = null;
        this.f2897b = null;
        this.f2898c = null;
        this.f2899d = false;
        ArrayList arrayList = new ArrayList();
        this.f2900e = arrayList;
        this.f2901f = null;
        this.f2902g = new ArrayList();
        this.f2903h = new SparseArray();
        this.f2904i = new HashMap();
        this.f2905j = new SparseIntArray();
        this.f2906k = HttpStatusCodesKt.HTTP_BAD_REQUEST;
        this.f2907l = 0;
        this.f2909n = false;
        this.f2910o = false;
        this.f2896a = motionLayout;
        this.f2913r = new ViewTransitionController(motionLayout);
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            eventType = xml.getEventType();
        } catch (IOException e) {
            Log.e(TypedValues.MotionScene.NAME, "Error parsing resource: " + i, e);
        } catch (XmlPullParserException e2) {
            Log.e(TypedValues.MotionScene.NAME, "Error parsing resource: " + i, e2);
        }
        while (true) {
            char c = 1;
            if (eventType != 1) {
                if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c = 5;
                                break;
                            }
                            break;
                        case -1239391468:
                            if (name.equals(ViewTransition.KEY_FRAME_SET_TAG)) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -687739768:
                            if (name.equals("Include")) {
                                c = 7;
                                break;
                            }
                            break;
                        case 61998586:
                            if (name.equals(ViewTransition.VIEW_TRANSITION_TAG)) {
                                c = '\t';
                                break;
                            }
                            break;
                        case 269306229:
                            if (name.equals("Transition")) {
                                break;
                            }
                            break;
                        case 312750793:
                            if (name.equals("OnClick")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 327855227:
                            if (name.equals("OnSwipe")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 793277014:
                            if (name.equals(TypedValues.MotionScene.NAME)) {
                                c = 0;
                                break;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 1942574248:
                            if (name.equals("include")) {
                                c = 6;
                                break;
                            }
                            break;
                    }
                    c = 65535;
                    MotionLayout motionLayout2 = this.f2896a;
                    switch (c) {
                        case 0:
                            m594k(context, xml);
                            break;
                        case 1:
                            transition = new Transition(this, context, xml);
                            arrayList.add(transition);
                            if (this.f2898c == null && !transition.f2917b) {
                                this.f2898c = transition;
                                C0128c c0128c = transition.f2927l;
                                if (c0128c != null) {
                                    c0128c.m612c(this.f2912q);
                                }
                            }
                            if (!transition.f2917b) {
                                break;
                            } else {
                                if (transition.f2918c == -1) {
                                    this.f2901f = transition;
                                } else {
                                    this.f2902g.add(transition);
                                }
                                arrayList.remove(transition);
                                break;
                            }
                            break;
                        case 2:
                            if (transition == null) {
                                Log.v(TypedValues.MotionScene.NAME, " OnSwipe (" + context.getResources().getResourceEntryName(i) + ".xml:" + xml.getLineNumber() + ")");
                            }
                            if (transition == null) {
                                break;
                            } else {
                                transition.f2927l = new C0128c(context, motionLayout2, xml);
                                break;
                            }
                        case 3:
                            if (transition != null && !motionLayout2.isInEditMode()) {
                                transition.addOnClick(context, xml);
                                break;
                            }
                            break;
                        case 4:
                            this.f2897b = new StateSet(context, xml);
                            break;
                        case 5:
                            m591h(context, xml);
                            break;
                        case 6:
                        case 7:
                            m593j(context, xml);
                            break;
                        case '\b':
                            KeyFrames keyFrames = new KeyFrames(context, xml);
                            if (transition == null) {
                                break;
                            } else {
                                transition.f2926k.add(keyFrames);
                                break;
                            }
                        case '\t':
                            this.f2913r.add(new ViewTransition(context, xml));
                            break;
                    }
                }
                eventType = xml.next();
            } else {
                SparseArray sparseArray = this.f2903h;
                int i2 = R.id.motion_base;
                sparseArray.put(i2, new ConstraintSet());
                this.f2904i.put("motion_base", Integer.valueOf(i2));
                return;
            }
        }
    }
}
