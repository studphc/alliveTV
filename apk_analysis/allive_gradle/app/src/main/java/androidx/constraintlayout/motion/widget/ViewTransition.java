package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
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
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;
import p000.b43;
import p000.cp1;
import p000.ep1;
import p000.lp1;
import p000.wg2;

/* loaded from: classes.dex */
public class ViewTransition {
    public static final String CONSTRAINT_OVERRIDE = "ConstraintOverride";
    public static final String CUSTOM_ATTRIBUTE = "CustomAttribute";
    public static final String CUSTOM_METHOD = "CustomMethod";
    public static final String KEY_FRAME_SET_TAG = "KeyFrameSet";
    public static final int ONSTATE_ACTION_DOWN = 1;
    public static final int ONSTATE_ACTION_DOWN_UP = 3;
    public static final int ONSTATE_ACTION_UP = 2;
    public static final int ONSTATE_SHARED_VALUE_SET = 4;
    public static final int ONSTATE_SHARED_VALUE_UNSET = 5;
    public static final String VIEW_TRANSITION_TAG = "ViewTransition";

    /* renamed from: a */
    public int f2956a;

    /* renamed from: e */
    public int f2960e;

    /* renamed from: f */
    public final KeyFrames f2961f;

    /* renamed from: g */
    public final ConstraintSet.Constraint f2962g;

    /* renamed from: j */
    public int f2965j;

    /* renamed from: k */
    public String f2966k;

    /* renamed from: o */
    public final Context f2970o;

    /* renamed from: b */
    public int f2957b = -1;

    /* renamed from: c */
    public boolean f2958c = false;

    /* renamed from: d */
    public int f2959d = 0;

    /* renamed from: h */
    public int f2963h = -1;

    /* renamed from: i */
    public int f2964i = -1;

    /* renamed from: l */
    public int f2967l = 0;

    /* renamed from: m */
    public String f2968m = null;

    /* renamed from: n */
    public int f2969n = -1;

    /* renamed from: p */
    public int f2971p = -1;

    /* renamed from: q */
    public int f2972q = -1;

    /* renamed from: r */
    public int f2973r = -1;

    /* renamed from: s */
    public int f2974s = -1;

    /* renamed from: t */
    public int f2975t = -1;

    /* renamed from: u */
    public int f2976u = -1;

    /* renamed from: v */
    public int f2977v = -1;

    public ViewTransition(Context context, XmlResourceParser xmlResourceParser) {
        char c;
        this.f2970o = context;
        try {
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3 && VIEW_TRANSITION_TAG.equals(xmlResourceParser.getName())) {
                        return;
                    }
                } else {
                    String name = xmlResourceParser.getName();
                    switch (name.hashCode()) {
                        case -1962203927:
                            if (name.equals(CONSTRAINT_OVERRIDE)) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1239391468:
                            if (name.equals(KEY_FRAME_SET_TAG)) {
                                c = 1;
                                break;
                            }
                            break;
                        case 61998586:
                            if (name.equals(VIEW_TRANSITION_TAG)) {
                                c = 0;
                                break;
                            }
                            break;
                        case 366511058:
                            if (name.equals(CUSTOM_METHOD)) {
                                c = 4;
                                break;
                            }
                            break;
                        case 1791837707:
                            if (name.equals(CUSTOM_ATTRIBUTE)) {
                                c = 3;
                                break;
                            }
                            break;
                    }
                    c = 65535;
                    if (c != 0) {
                        if (c != 1) {
                            if (c != 2) {
                                if (c != 3 && c != 4) {
                                    Log.e(VIEW_TRANSITION_TAG, Debug.getLoc() + " unknown tag " + name);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(".xml:");
                                    sb.append(xmlResourceParser.getLineNumber());
                                    Log.e(VIEW_TRANSITION_TAG, sb.toString());
                                } else {
                                    ConstraintAttribute.parse(context, xmlResourceParser, this.f2962g.mCustomConstraints);
                                }
                            } else {
                                this.f2962g = ConstraintSet.buildDelta(context, xmlResourceParser);
                            }
                        } else {
                            this.f2961f = new KeyFrames(context, xmlResourceParser);
                        }
                    } else {
                        m602d(context, xmlResourceParser);
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException e) {
            Log.e(VIEW_TRANSITION_TAG, "Error parsing XML resource", e);
        } catch (XmlPullParserException e2) {
            Log.e(VIEW_TRANSITION_TAG, "Error parsing XML resource", e2);
        }
    }

    /* renamed from: a */
    public final void m599a(ViewTransitionController viewTransitionController, MotionLayout motionLayout, int i, ConstraintSet constraintSet, View... viewArr) {
        Interpolator loadInterpolator;
        Interpolator interpolator;
        if (this.f2958c) {
            return;
        }
        int i2 = this.f2960e;
        KeyFrames keyFrames = this.f2961f;
        if (i2 == 2) {
            View view = viewArr[0];
            MotionController motionController = new MotionController(view);
            lp1 lp1Var = motionController.f2801f;
            lp1Var.f22610c = RecyclerView.f7068F0;
            lp1Var.f22611d = RecyclerView.f7068F0;
            motionController.f2795H = true;
            lp1Var.m5968e(view.getX(), view.getY(), view.getWidth(), view.getHeight());
            motionController.f2802g.m5968e(view.getX(), view.getY(), view.getWidth(), view.getHeight());
            cp1 cp1Var = motionController.f2803h;
            cp1Var.getClass();
            view.getX();
            view.getY();
            view.getWidth();
            view.getHeight();
            cp1Var.m4484b(view);
            cp1 cp1Var2 = motionController.f2804i;
            cp1Var2.getClass();
            view.getX();
            view.getY();
            view.getWidth();
            view.getHeight();
            cp1Var2.m4484b(view);
            keyFrames.addAllFrames(motionController);
            motionController.setup(motionLayout.getWidth(), motionLayout.getHeight(), this.f2963h, System.nanoTime());
            int i3 = this.f2963h;
            int i4 = this.f2964i;
            int i5 = this.f2957b;
            Context context = motionLayout.getContext();
            int i6 = this.f2967l;
            if (i6 != -2) {
                if (i6 != -1) {
                    if (i6 != 0) {
                        if (i6 != 1) {
                            if (i6 != 2) {
                                if (i6 != 4) {
                                    if (i6 != 5) {
                                        if (i6 != 6) {
                                            loadInterpolator = null;
                                        } else {
                                            loadInterpolator = new AnticipateInterpolator();
                                        }
                                    } else {
                                        loadInterpolator = new OvershootInterpolator();
                                    }
                                } else {
                                    loadInterpolator = new BounceInterpolator();
                                }
                            } else {
                                loadInterpolator = new DecelerateInterpolator();
                            }
                        } else {
                            loadInterpolator = new AccelerateInterpolator();
                        }
                    } else {
                        loadInterpolator = new AccelerateDecelerateInterpolator();
                    }
                } else {
                    interpolator = new ep1(Easing.getInterpolator(this.f2968m), 2);
                    new b43(viewTransitionController, motionController, i3, i4, i5, interpolator, this.f2971p, this.f2972q);
                    return;
                }
            } else {
                loadInterpolator = AnimationUtils.loadInterpolator(context, this.f2969n);
            }
            interpolator = loadInterpolator;
            new b43(viewTransitionController, motionController, i3, i4, i5, interpolator, this.f2971p, this.f2972q);
            return;
        }
        ConstraintSet.Constraint constraint = this.f2962g;
        if (i2 == 1) {
            for (int i7 : motionLayout.getConstraintSetIds()) {
                if (i7 != i) {
                    ConstraintSet constraintSet2 = motionLayout.getConstraintSet(i7);
                    for (View view2 : viewArr) {
                        ConstraintSet.Constraint constraint2 = constraintSet2.getConstraint(view2.getId());
                        if (constraint != null) {
                            constraint.applyDelta(constraint2);
                            constraint2.mCustomConstraints.putAll(constraint.mCustomConstraints);
                        }
                    }
                }
            }
        }
        ConstraintSet constraintSet3 = new ConstraintSet();
        constraintSet3.clone(constraintSet);
        for (View view3 : viewArr) {
            ConstraintSet.Constraint constraint3 = constraintSet3.getConstraint(view3.getId());
            if (constraint != null) {
                constraint.applyDelta(constraint3);
                constraint3.mCustomConstraints.putAll(constraint.mCustomConstraints);
            }
        }
        motionLayout.updateState(i, constraintSet3);
        int i8 = R.id.view_transition;
        motionLayout.updateState(i8, constraintSet);
        motionLayout.setState(i8, -1, -1);
        MotionScene.Transition transition = new MotionScene.Transition(-1, motionLayout.f2878r, i8, i);
        for (View view4 : viewArr) {
            int i9 = this.f2963h;
            if (i9 != -1) {
                transition.setDuration(i9);
            }
            transition.setPathMotionArc(this.f2959d);
            transition.setInterpolatorInfo(this.f2967l, this.f2968m, this.f2969n);
            int id = view4.getId();
            if (keyFrames != null) {
                ArrayList<Key> keyFramesForView = keyFrames.getKeyFramesForView(-1);
                KeyFrames keyFrames2 = new KeyFrames();
                Iterator<Key> it = keyFramesForView.iterator();
                while (it.hasNext()) {
                    keyFrames2.addKey(it.next().mo8476clone().setViewId(id));
                }
                transition.addKeyFrame(keyFrames2);
            }
        }
        motionLayout.setTransition(transition);
        motionLayout.transitionToEnd(new wg2(6, this, viewArr));
    }

    /* renamed from: b */
    public final boolean m600b(View view) {
        boolean z;
        boolean z2;
        int i = this.f2973r;
        if (i == -1 || view.getTag(i) != null) {
            z = true;
        } else {
            z = false;
        }
        int i2 = this.f2974s;
        if (i2 == -1 || view.getTag(i2) == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public final boolean m601c(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if ((this.f2965j == -1 && this.f2966k == null) || !m600b(view)) {
            return false;
        }
        if (view.getId() == this.f2965j) {
            return true;
        }
        if (this.f2966k == null || !(view.getLayoutParams() instanceof ConstraintLayout.LayoutParams) || (str = ((ConstraintLayout.LayoutParams) view.getLayoutParams()).constraintTag) == null || !str.matches(this.f2966k)) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    public final void m602d(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.ViewTransition);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.ViewTransition_android_id) {
                this.f2956a = obtainStyledAttributes.getResourceId(index, this.f2956a);
            } else if (index == R.styleable.ViewTransition_motionTarget) {
                if (MotionLayout.IS_IN_EDIT_MODE) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.f2965j);
                    this.f2965j = resourceId;
                    if (resourceId == -1) {
                        this.f2966k = obtainStyledAttributes.getString(index);
                    }
                } else if (obtainStyledAttributes.peekValue(index).type == 3) {
                    this.f2966k = obtainStyledAttributes.getString(index);
                } else {
                    this.f2965j = obtainStyledAttributes.getResourceId(index, this.f2965j);
                }
            } else if (index == R.styleable.ViewTransition_onStateTransition) {
                this.f2957b = obtainStyledAttributes.getInt(index, this.f2957b);
            } else if (index == R.styleable.ViewTransition_transitionDisable) {
                this.f2958c = obtainStyledAttributes.getBoolean(index, this.f2958c);
            } else if (index == R.styleable.ViewTransition_pathMotionArc) {
                this.f2959d = obtainStyledAttributes.getInt(index, this.f2959d);
            } else if (index == R.styleable.ViewTransition_duration) {
                this.f2963h = obtainStyledAttributes.getInt(index, this.f2963h);
            } else if (index == R.styleable.ViewTransition_upDuration) {
                this.f2964i = obtainStyledAttributes.getInt(index, this.f2964i);
            } else if (index == R.styleable.ViewTransition_viewTransitionMode) {
                this.f2960e = obtainStyledAttributes.getInt(index, this.f2960e);
            } else if (index == R.styleable.ViewTransition_motionInterpolator) {
                int i2 = obtainStyledAttributes.peekValue(index).type;
                if (i2 == 1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, -1);
                    this.f2969n = resourceId2;
                    if (resourceId2 != -1) {
                        this.f2967l = -2;
                    }
                } else if (i2 == 3) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f2968m = string;
                    if (string != null && string.indexOf("/") > 0) {
                        this.f2969n = obtainStyledAttributes.getResourceId(index, -1);
                        this.f2967l = -2;
                    } else {
                        this.f2967l = -1;
                    }
                } else {
                    this.f2967l = obtainStyledAttributes.getInteger(index, this.f2967l);
                }
            } else if (index == R.styleable.ViewTransition_setsTag) {
                this.f2971p = obtainStyledAttributes.getResourceId(index, this.f2971p);
            } else if (index == R.styleable.ViewTransition_clearsTag) {
                this.f2972q = obtainStyledAttributes.getResourceId(index, this.f2972q);
            } else if (index == R.styleable.ViewTransition_ifTagSet) {
                this.f2973r = obtainStyledAttributes.getResourceId(index, this.f2973r);
            } else if (index == R.styleable.ViewTransition_ifTagNotSet) {
                this.f2974s = obtainStyledAttributes.getResourceId(index, this.f2974s);
            } else if (index == R.styleable.ViewTransition_SharedValueId) {
                this.f2976u = obtainStyledAttributes.getResourceId(index, this.f2976u);
            } else if (index == R.styleable.ViewTransition_SharedValue) {
                this.f2975t = obtainStyledAttributes.getInteger(index, this.f2975t);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public int getSharedValue() {
        return this.f2975t;
    }

    public int getSharedValueCurrent() {
        return this.f2977v;
    }

    public int getSharedValueID() {
        return this.f2976u;
    }

    public int getStateTransition() {
        return this.f2957b;
    }

    public void setSharedValue(int i) {
        this.f2975t = i;
    }

    public void setSharedValueCurrent(int i) {
        this.f2977v = i;
    }

    public void setSharedValueID(int i) {
        this.f2976u = i;
    }

    public void setStateTransition(int i) {
        this.f2957b = i;
    }

    public String toString() {
        return "ViewTransition(" + Debug.getName(this.f2970o, this.f2956a) + ")";
    }
}
