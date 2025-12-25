package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.Facade;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;
import p000.C1135dv;

/* loaded from: classes.dex */
public class ConstraintReference implements Reference {

    /* renamed from: C */
    public float f2295C;

    /* renamed from: D */
    public float f2296D;

    /* renamed from: F */
    public Dimension f2298F;

    /* renamed from: G */
    public Dimension f2299G;

    /* renamed from: H */
    public Object f2300H;

    /* renamed from: I */
    public ConstraintWidget f2301I;

    /* renamed from: J */
    public final HashMap f2302J;

    /* renamed from: K */
    public HashMap f2303K;

    /* renamed from: L */
    public TypedBundle f2304L;

    /* renamed from: a */
    public Object f2305a;

    /* renamed from: b */
    public final State f2306b;

    /* renamed from: c */
    public String f2307c = null;

    /* renamed from: d */
    public Facade f2308d = null;

    /* renamed from: e */
    public int f2309e = 0;

    /* renamed from: f */
    public int f2310f = 0;

    /* renamed from: g */
    public float f2311g = -1.0f;

    /* renamed from: h */
    public float f2312h = -1.0f;
    protected float mHorizontalBias = 0.5f;
    protected float mVerticalBias = 0.5f;
    protected int mMarginLeft = 0;
    protected int mMarginRight = 0;
    protected int mMarginStart = 0;
    protected int mMarginEnd = 0;
    protected int mMarginTop = 0;
    protected int mMarginBottom = 0;
    protected int mMarginLeftGone = 0;
    protected int mMarginRightGone = 0;
    protected int mMarginStartGone = 0;
    protected int mMarginEndGone = 0;
    protected int mMarginTopGone = 0;
    protected int mMarginBottomGone = 0;

    /* renamed from: i */
    public int f2313i = 0;

    /* renamed from: j */
    public int f2314j = 0;

    /* renamed from: k */
    public float f2315k = Float.NaN;

    /* renamed from: l */
    public float f2316l = Float.NaN;

    /* renamed from: m */
    public float f2317m = Float.NaN;

    /* renamed from: n */
    public float f2318n = Float.NaN;

    /* renamed from: o */
    public float f2319o = Float.NaN;

    /* renamed from: p */
    public float f2320p = Float.NaN;

    /* renamed from: q */
    public float f2321q = Float.NaN;

    /* renamed from: r */
    public float f2322r = Float.NaN;

    /* renamed from: s */
    public float f2323s = Float.NaN;

    /* renamed from: t */
    public float f2324t = Float.NaN;

    /* renamed from: u */
    public float f2325u = Float.NaN;

    /* renamed from: v */
    public int f2326v = 0;
    protected Object mLeftToLeft = null;
    protected Object mLeftToRight = null;
    protected Object mRightToLeft = null;
    protected Object mRightToRight = null;
    protected Object mStartToStart = null;
    protected Object mStartToEnd = null;
    protected Object mEndToStart = null;
    protected Object mEndToEnd = null;
    protected Object mTopToTop = null;
    protected Object mTopToBottom = null;

    /* renamed from: w */
    public ConstraintReference f2327w = null;
    protected Object mBottomToTop = null;
    protected Object mBottomToBottom = null;

    /* renamed from: x */
    public ConstraintReference f2328x = null;

    /* renamed from: y */
    public Object f2329y = null;

    /* renamed from: z */
    public Object f2330z = null;

    /* renamed from: A */
    public Object f2293A = null;

    /* renamed from: B */
    public Object f2294B = null;

    /* renamed from: E */
    public State.Constraint f2297E = null;

    /* loaded from: classes.dex */
    public interface ConstraintReferenceFactory {
        ConstraintReference create(State state);
    }

    public ConstraintReference(State state) {
        Object obj = Dimension.WRAP_DIMENSION;
        this.f2298F = Dimension.createFixed(obj);
        this.f2299G = Dimension.createFixed(obj);
        this.f2302J = new HashMap();
        this.f2303K = new HashMap();
        this.f2304L = null;
        this.f2306b = state;
    }

    /* renamed from: a */
    public final void m450a(ConstraintWidget constraintWidget, Object obj, State.Constraint constraint) {
        ConstraintWidget constraintWidget2;
        if (obj instanceof Reference) {
            constraintWidget2 = ((Reference) obj).getConstraintWidget();
        } else {
            constraintWidget2 = null;
        }
        ConstraintWidget constraintWidget3 = constraintWidget2;
        if (constraintWidget3 == null) {
            return;
        }
        int[] iArr = AbstractC0121a.f2390a;
        int i = iArr[constraint.ordinal()];
        switch (iArr[constraint.ordinal()]) {
            case 1:
                ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                constraintWidget.getAnchor(type).connect(constraintWidget3.getAnchor(type), this.mMarginLeft, this.mMarginLeftGone, false);
                return;
            case 2:
                constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT), this.mMarginLeft, this.mMarginLeftGone, false);
                return;
            case 3:
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget3.getAnchor(ConstraintAnchor.Type.LEFT), this.mMarginRight, this.mMarginRightGone, false);
                return;
            case 4:
                ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                constraintWidget.getAnchor(type2).connect(constraintWidget3.getAnchor(type2), this.mMarginRight, this.mMarginRightGone, false);
                return;
            case 5:
                ConstraintAnchor.Type type3 = ConstraintAnchor.Type.LEFT;
                constraintWidget.getAnchor(type3).connect(constraintWidget3.getAnchor(type3), this.mMarginStart, this.mMarginStartGone, false);
                return;
            case 6:
                constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT), this.mMarginStart, this.mMarginStartGone, false);
                return;
            case 7:
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget3.getAnchor(ConstraintAnchor.Type.LEFT), this.mMarginEnd, this.mMarginEndGone, false);
                return;
            case 8:
                ConstraintAnchor.Type type4 = ConstraintAnchor.Type.RIGHT;
                constraintWidget.getAnchor(type4).connect(constraintWidget3.getAnchor(type4), this.mMarginEnd, this.mMarginEndGone, false);
                return;
            case 9:
                ConstraintAnchor.Type type5 = ConstraintAnchor.Type.TOP;
                constraintWidget.getAnchor(type5).connect(constraintWidget3.getAnchor(type5), this.mMarginTop, this.mMarginTopGone, false);
                return;
            case 10:
                constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget3.getAnchor(ConstraintAnchor.Type.BOTTOM), this.mMarginTop, this.mMarginTopGone, false);
                return;
            case 11:
                constraintWidget.immediateConnect(ConstraintAnchor.Type.TOP, constraintWidget3, ConstraintAnchor.Type.BASELINE, this.mMarginTop, this.mMarginTopGone);
                return;
            case 12:
                constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget3.getAnchor(ConstraintAnchor.Type.TOP), this.mMarginBottom, this.mMarginBottomGone, false);
                return;
            case 13:
                ConstraintAnchor.Type type6 = ConstraintAnchor.Type.BOTTOM;
                constraintWidget.getAnchor(type6).connect(constraintWidget3.getAnchor(type6), this.mMarginBottom, this.mMarginBottomGone, false);
                return;
            case 14:
                constraintWidget.immediateConnect(ConstraintAnchor.Type.BOTTOM, constraintWidget3, ConstraintAnchor.Type.BASELINE, this.mMarginBottom, this.mMarginBottomGone);
                return;
            case 15:
                constraintWidget.immediateConnect(ConstraintAnchor.Type.BASELINE, constraintWidget3, ConstraintAnchor.Type.BOTTOM, this.f2313i, this.f2314j);
                return;
            case 16:
                constraintWidget.immediateConnect(ConstraintAnchor.Type.BASELINE, constraintWidget3, ConstraintAnchor.Type.TOP, this.f2313i, this.f2314j);
                return;
            case 17:
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.BASELINE;
                constraintWidget.immediateConnect(type7, constraintWidget3, type7, this.f2313i, this.f2314j);
                return;
            case 18:
                constraintWidget.connectCircularConstraint(constraintWidget3, this.f2295C, (int) this.f2296D);
                return;
            default:
                return;
        }
    }

    public void addCustomColor(String str, int i) {
        this.f2302J.put(str, Integer.valueOf(i));
    }

    public void addCustomFloat(String str, float f) {
        if (this.f2303K == null) {
            this.f2303K = new HashMap();
        }
        this.f2303K.put(str, Float.valueOf(f));
    }

    public ConstraintReference alpha(float f) {
        this.f2323s = f;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void apply() {
        if (this.f2301I == null) {
            return;
        }
        Facade facade = this.f2308d;
        if (facade != null) {
            facade.apply();
        }
        Dimension dimension = this.f2298F;
        ConstraintWidget constraintWidget = this.f2301I;
        State state = this.f2306b;
        dimension.apply(state, constraintWidget, 0);
        this.f2299G.apply(state, this.f2301I, 1);
        this.mLeftToLeft = m451b(this.mLeftToLeft);
        this.mLeftToRight = m451b(this.mLeftToRight);
        this.mRightToLeft = m451b(this.mRightToLeft);
        this.mRightToRight = m451b(this.mRightToRight);
        this.mStartToStart = m451b(this.mStartToStart);
        this.mStartToEnd = m451b(this.mStartToEnd);
        this.mEndToStart = m451b(this.mEndToStart);
        this.mEndToEnd = m451b(this.mEndToEnd);
        this.mTopToTop = m451b(this.mTopToTop);
        this.mTopToBottom = m451b(this.mTopToBottom);
        this.mBottomToTop = m451b(this.mBottomToTop);
        this.mBottomToBottom = m451b(this.mBottomToBottom);
        this.f2329y = m451b(this.f2329y);
        this.f2330z = m451b(this.f2330z);
        this.f2293A = m451b(this.f2293A);
        applyWidgetConstraints();
        int i = this.f2309e;
        if (i != 0) {
            this.f2301I.setHorizontalChainStyle(i);
        }
        int i2 = this.f2310f;
        if (i2 != 0) {
            this.f2301I.setVerticalChainStyle(i2);
        }
        float f = this.f2311g;
        if (f != -1.0f) {
            this.f2301I.setHorizontalWeight(f);
        }
        float f2 = this.f2312h;
        if (f2 != -1.0f) {
            this.f2301I.setVerticalWeight(f2);
        }
        this.f2301I.setHorizontalBiasPercent(this.mHorizontalBias);
        this.f2301I.setVerticalBiasPercent(this.mVerticalBias);
        ConstraintWidget constraintWidget2 = this.f2301I;
        WidgetFrame widgetFrame = constraintWidget2.frame;
        widgetFrame.pivotX = this.f2315k;
        widgetFrame.pivotY = this.f2316l;
        widgetFrame.rotationX = this.f2317m;
        widgetFrame.rotationY = this.f2318n;
        widgetFrame.rotationZ = this.f2319o;
        widgetFrame.translationX = this.f2320p;
        widgetFrame.translationY = this.f2321q;
        widgetFrame.translationZ = this.f2322r;
        widgetFrame.scaleX = this.f2324t;
        widgetFrame.scaleY = this.f2325u;
        widgetFrame.alpha = this.f2323s;
        int i3 = this.f2326v;
        widgetFrame.visibility = i3;
        constraintWidget2.setVisibility(i3);
        this.f2301I.frame.f2389b = this.f2304L;
        HashMap hashMap = this.f2302J;
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                this.f2301I.frame.setCustomAttribute(str, TypedValues.Custom.TYPE_COLOR, ((Integer) hashMap.get(str)).intValue());
            }
        }
        HashMap hashMap2 = this.f2303K;
        if (hashMap2 != null) {
            for (String str2 : hashMap2.keySet()) {
                this.f2301I.frame.setCustomAttribute(str2, TypedValues.Custom.TYPE_FLOAT, ((Float) this.f2303K.get(str2)).floatValue());
            }
        }
    }

    public void applyWidgetConstraints() {
        m450a(this.f2301I, this.mLeftToLeft, State.Constraint.LEFT_TO_LEFT);
        m450a(this.f2301I, this.mLeftToRight, State.Constraint.LEFT_TO_RIGHT);
        m450a(this.f2301I, this.mRightToLeft, State.Constraint.RIGHT_TO_LEFT);
        m450a(this.f2301I, this.mRightToRight, State.Constraint.RIGHT_TO_RIGHT);
        m450a(this.f2301I, this.mStartToStart, State.Constraint.START_TO_START);
        m450a(this.f2301I, this.mStartToEnd, State.Constraint.START_TO_END);
        m450a(this.f2301I, this.mEndToStart, State.Constraint.END_TO_START);
        m450a(this.f2301I, this.mEndToEnd, State.Constraint.END_TO_END);
        m450a(this.f2301I, this.mTopToTop, State.Constraint.TOP_TO_TOP);
        m450a(this.f2301I, this.mTopToBottom, State.Constraint.TOP_TO_BOTTOM);
        m450a(this.f2301I, this.f2327w, State.Constraint.TOP_TO_BASELINE);
        m450a(this.f2301I, this.mBottomToTop, State.Constraint.BOTTOM_TO_TOP);
        m450a(this.f2301I, this.mBottomToBottom, State.Constraint.BOTTOM_TO_BOTTOM);
        m450a(this.f2301I, this.f2328x, State.Constraint.BOTTOM_TO_BASELINE);
        m450a(this.f2301I, this.f2329y, State.Constraint.BASELINE_TO_BASELINE);
        m450a(this.f2301I, this.f2330z, State.Constraint.BASELINE_TO_TOP);
        m450a(this.f2301I, this.f2293A, State.Constraint.BASELINE_TO_BOTTOM);
        m450a(this.f2301I, this.f2294B, State.Constraint.CIRCULAR_CONSTRAINT);
    }

    /* renamed from: b */
    public final Object m451b(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof ConstraintReference)) {
            return this.f2306b.mReferences.get(obj);
        }
        return obj;
    }

    public ConstraintReference baseline() {
        this.f2297E = State.Constraint.BASELINE_TO_BASELINE;
        return this;
    }

    public ConstraintReference baselineToBaseline(Object obj) {
        this.f2297E = State.Constraint.BASELINE_TO_BASELINE;
        this.f2329y = obj;
        return this;
    }

    public ConstraintReference baselineToBottom(Object obj) {
        this.f2297E = State.Constraint.BASELINE_TO_BOTTOM;
        this.f2293A = obj;
        return this;
    }

    public ConstraintReference baselineToTop(Object obj) {
        this.f2297E = State.Constraint.BASELINE_TO_TOP;
        this.f2330z = obj;
        return this;
    }

    public ConstraintReference bias(float f) {
        State.Constraint constraint = this.f2297E;
        if (constraint == null) {
            return this;
        }
        int i = AbstractC0121a.f2390a[constraint.ordinal()];
        if (i != 19) {
            if (i != 20) {
                switch (i) {
                }
                return this;
            }
            this.mVerticalBias = f;
            return this;
        }
        this.mHorizontalBias = f;
        return this;
    }

    public ConstraintReference bottom() {
        if (this.mBottomToTop != null) {
            this.f2297E = State.Constraint.BOTTOM_TO_TOP;
        } else {
            this.f2297E = State.Constraint.BOTTOM_TO_BOTTOM;
        }
        return this;
    }

    public ConstraintReference bottomToBottom(Object obj) {
        this.f2297E = State.Constraint.BOTTOM_TO_BOTTOM;
        this.mBottomToBottom = obj;
        return this;
    }

    public ConstraintReference bottomToTop(Object obj) {
        this.f2297E = State.Constraint.BOTTOM_TO_TOP;
        this.mBottomToTop = obj;
        return this;
    }

    public ConstraintReference centerHorizontally(Object obj) {
        Object m451b = m451b(obj);
        this.mStartToStart = m451b;
        this.mEndToEnd = m451b;
        this.f2297E = State.Constraint.CENTER_HORIZONTALLY;
        this.mHorizontalBias = 0.5f;
        return this;
    }

    public ConstraintReference centerVertically(Object obj) {
        Object m451b = m451b(obj);
        this.mTopToTop = m451b;
        this.mBottomToBottom = m451b;
        this.f2297E = State.Constraint.CENTER_VERTICALLY;
        this.mVerticalBias = 0.5f;
        return this;
    }

    public ConstraintReference circularConstraint(Object obj, float f, float f2) {
        this.f2294B = m451b(obj);
        this.f2295C = f;
        this.f2296D = f2;
        this.f2297E = State.Constraint.CIRCULAR_CONSTRAINT;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public ConstraintReference clear() {
        State.Constraint constraint = this.f2297E;
        if (constraint != null) {
            switch (AbstractC0121a.f2390a[constraint.ordinal()]) {
                case 1:
                case 2:
                    this.mLeftToLeft = null;
                    this.mLeftToRight = null;
                    this.mMarginLeft = 0;
                    this.mMarginLeftGone = 0;
                    break;
                case 3:
                case 4:
                    this.mRightToLeft = null;
                    this.mRightToRight = null;
                    this.mMarginRight = 0;
                    this.mMarginRightGone = 0;
                    break;
                case 5:
                case 6:
                    this.mStartToStart = null;
                    this.mStartToEnd = null;
                    this.mMarginStart = 0;
                    this.mMarginStartGone = 0;
                    break;
                case 7:
                case 8:
                    this.mEndToStart = null;
                    this.mEndToEnd = null;
                    this.mMarginEnd = 0;
                    this.mMarginEndGone = 0;
                    break;
                case 9:
                case 10:
                case 11:
                    this.mTopToTop = null;
                    this.mTopToBottom = null;
                    this.f2327w = null;
                    this.mMarginTop = 0;
                    this.mMarginTopGone = 0;
                    break;
                case 12:
                case 13:
                case 14:
                    this.mBottomToTop = null;
                    this.mBottomToBottom = null;
                    this.f2328x = null;
                    this.mMarginBottom = 0;
                    this.mMarginBottomGone = 0;
                    break;
                case 17:
                    this.f2329y = null;
                    break;
                case 18:
                    this.f2294B = null;
                    break;
            }
        } else {
            clearAll();
        }
        return this;
    }

    public ConstraintReference clearAll() {
        this.mLeftToLeft = null;
        this.mLeftToRight = null;
        this.mMarginLeft = 0;
        this.mRightToLeft = null;
        this.mRightToRight = null;
        this.mMarginRight = 0;
        this.mStartToStart = null;
        this.mStartToEnd = null;
        this.mMarginStart = 0;
        this.mEndToStart = null;
        this.mEndToEnd = null;
        this.mMarginEnd = 0;
        this.mTopToTop = null;
        this.mTopToBottom = null;
        this.mMarginTop = 0;
        this.mBottomToTop = null;
        this.mBottomToBottom = null;
        this.mMarginBottom = 0;
        this.f2329y = null;
        this.f2294B = null;
        this.mHorizontalBias = 0.5f;
        this.mVerticalBias = 0.5f;
        this.mMarginLeftGone = 0;
        this.mMarginRightGone = 0;
        this.mMarginStartGone = 0;
        this.mMarginEndGone = 0;
        this.mMarginTopGone = 0;
        this.mMarginBottomGone = 0;
        return this;
    }

    public ConstraintReference clearHorizontal() {
        start().clear();
        end().clear();
        left().clear();
        right().clear();
        return this;
    }

    public ConstraintReference clearVertical() {
        top().clear();
        baseline().clear();
        bottom().clear();
        return this;
    }

    public ConstraintWidget createConstraintWidget() {
        return new ConstraintWidget(getWidth().f2341d, getHeight().f2341d);
    }

    public ConstraintReference end() {
        if (this.mEndToStart != null) {
            this.f2297E = State.Constraint.END_TO_START;
        } else {
            this.f2297E = State.Constraint.END_TO_END;
        }
        return this;
    }

    public ConstraintReference endToEnd(Object obj) {
        this.f2297E = State.Constraint.END_TO_END;
        this.mEndToEnd = obj;
        return this;
    }

    public ConstraintReference endToStart(Object obj) {
        this.f2297E = State.Constraint.END_TO_START;
        this.mEndToStart = obj;
        return this;
    }

    public float getAlpha() {
        return this.f2323s;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public ConstraintWidget getConstraintWidget() {
        if (this.f2301I == null) {
            ConstraintWidget createConstraintWidget = createConstraintWidget();
            this.f2301I = createConstraintWidget;
            createConstraintWidget.setCompanionWidget(this.f2300H);
        }
        return this.f2301I;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public Facade getFacade() {
        return this.f2308d;
    }

    public Dimension getHeight() {
        return this.f2299G;
    }

    public int getHorizontalChainStyle() {
        return this.f2309e;
    }

    public float getHorizontalChainWeight() {
        return this.f2311g;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public Object getKey() {
        return this.f2305a;
    }

    public float getPivotX() {
        return this.f2315k;
    }

    public float getPivotY() {
        return this.f2316l;
    }

    public float getRotationX() {
        return this.f2317m;
    }

    public float getRotationY() {
        return this.f2318n;
    }

    public float getRotationZ() {
        return this.f2319o;
    }

    public float getScaleX() {
        return this.f2324t;
    }

    public float getScaleY() {
        return this.f2325u;
    }

    public String getTag() {
        return this.f2307c;
    }

    public float getTranslationX() {
        return this.f2320p;
    }

    public float getTranslationY() {
        return this.f2321q;
    }

    public float getTranslationZ() {
        return this.f2322r;
    }

    public int getVerticalChainStyle(int i) {
        return this.f2310f;
    }

    public float getVerticalChainWeight() {
        return this.f2312h;
    }

    public Object getView() {
        return this.f2300H;
    }

    public Dimension getWidth() {
        return this.f2298F;
    }

    public ConstraintReference height(Dimension dimension) {
        return setHeight(dimension);
    }

    public ConstraintReference horizontalBias(float f) {
        this.mHorizontalBias = f;
        return this;
    }

    public ConstraintReference left() {
        if (this.mLeftToLeft != null) {
            this.f2297E = State.Constraint.LEFT_TO_LEFT;
        } else {
            this.f2297E = State.Constraint.LEFT_TO_RIGHT;
        }
        return this;
    }

    public ConstraintReference leftToLeft(Object obj) {
        this.f2297E = State.Constraint.LEFT_TO_LEFT;
        this.mLeftToLeft = obj;
        return this;
    }

    public ConstraintReference leftToRight(Object obj) {
        this.f2297E = State.Constraint.LEFT_TO_RIGHT;
        this.mLeftToRight = obj;
        return this;
    }

    public ConstraintReference margin(Object obj) {
        return margin(this.f2306b.convertDimension(obj));
    }

    public ConstraintReference marginGone(Object obj) {
        return marginGone(this.f2306b.convertDimension(obj));
    }

    public ConstraintReference pivotX(float f) {
        this.f2315k = f;
        return this;
    }

    public ConstraintReference pivotY(float f) {
        this.f2316l = f;
        return this;
    }

    public ConstraintReference right() {
        if (this.mRightToLeft != null) {
            this.f2297E = State.Constraint.RIGHT_TO_LEFT;
        } else {
            this.f2297E = State.Constraint.RIGHT_TO_RIGHT;
        }
        return this;
    }

    public ConstraintReference rightToLeft(Object obj) {
        this.f2297E = State.Constraint.RIGHT_TO_LEFT;
        this.mRightToLeft = obj;
        return this;
    }

    public ConstraintReference rightToRight(Object obj) {
        this.f2297E = State.Constraint.RIGHT_TO_RIGHT;
        this.mRightToRight = obj;
        return this;
    }

    public ConstraintReference rotationX(float f) {
        this.f2317m = f;
        return this;
    }

    public ConstraintReference rotationY(float f) {
        this.f2318n = f;
        return this;
    }

    public ConstraintReference rotationZ(float f) {
        this.f2319o = f;
        return this;
    }

    public ConstraintReference scaleX(float f) {
        this.f2324t = f;
        return this;
    }

    public ConstraintReference scaleY(float f) {
        this.f2325u = f;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void setConstraintWidget(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return;
        }
        this.f2301I = constraintWidget;
        constraintWidget.setCompanionWidget(this.f2300H);
    }

    public void setFacade(Facade facade) {
        this.f2308d = facade;
        if (facade != null) {
            setConstraintWidget(facade.getConstraintWidget());
        }
    }

    public ConstraintReference setHeight(Dimension dimension) {
        this.f2299G = dimension;
        return this;
    }

    public void setHorizontalChainStyle(int i) {
        this.f2309e = i;
    }

    public void setHorizontalChainWeight(float f) {
        this.f2311g = f;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void setKey(Object obj) {
        this.f2305a = obj;
    }

    public void setTag(String str) {
        this.f2307c = str;
    }

    public void setVerticalChainStyle(int i) {
        this.f2310f = i;
    }

    public void setVerticalChainWeight(float f) {
        this.f2312h = f;
    }

    public void setView(Object obj) {
        this.f2300H = obj;
        ConstraintWidget constraintWidget = this.f2301I;
        if (constraintWidget != null) {
            constraintWidget.setCompanionWidget(obj);
        }
    }

    public ConstraintReference setWidth(Dimension dimension) {
        this.f2298F = dimension;
        return this;
    }

    public ConstraintReference start() {
        if (this.mStartToStart != null) {
            this.f2297E = State.Constraint.START_TO_START;
        } else {
            this.f2297E = State.Constraint.START_TO_END;
        }
        return this;
    }

    public ConstraintReference startToEnd(Object obj) {
        this.f2297E = State.Constraint.START_TO_END;
        this.mStartToEnd = obj;
        return this;
    }

    public ConstraintReference startToStart(Object obj) {
        this.f2297E = State.Constraint.START_TO_START;
        this.mStartToStart = obj;
        return this;
    }

    public ConstraintReference top() {
        if (this.mTopToTop != null) {
            this.f2297E = State.Constraint.TOP_TO_TOP;
        } else {
            this.f2297E = State.Constraint.TOP_TO_BOTTOM;
        }
        return this;
    }

    public ConstraintReference topToBottom(Object obj) {
        this.f2297E = State.Constraint.TOP_TO_BOTTOM;
        this.mTopToBottom = obj;
        return this;
    }

    public ConstraintReference topToTop(Object obj) {
        this.f2297E = State.Constraint.TOP_TO_TOP;
        this.mTopToTop = obj;
        return this;
    }

    public ConstraintReference translationX(float f) {
        this.f2320p = f;
        return this;
    }

    public ConstraintReference translationY(float f) {
        this.f2321q = f;
        return this;
    }

    public ConstraintReference translationZ(float f) {
        this.f2322r = f;
        return this;
    }

    public void validate() {
        ArrayList arrayList = new ArrayList();
        if (this.mLeftToLeft != null && this.mLeftToRight != null) {
            arrayList.add("LeftToLeft and LeftToRight both defined");
        }
        if (this.mRightToLeft != null && this.mRightToRight != null) {
            arrayList.add("RightToLeft and RightToRight both defined");
        }
        if (this.mStartToStart != null && this.mStartToEnd != null) {
            arrayList.add("StartToStart and StartToEnd both defined");
        }
        if (this.mEndToStart != null && this.mEndToEnd != null) {
            arrayList.add("EndToStart and EndToEnd both defined");
        }
        if ((this.mLeftToLeft != null || this.mLeftToRight != null || this.mRightToLeft != null || this.mRightToRight != null) && (this.mStartToStart != null || this.mStartToEnd != null || this.mEndToStart != null || this.mEndToEnd != null)) {
            arrayList.add("Both left/right and start/end constraints defined");
        }
        if (arrayList.size() <= 0) {
        } else {
            throw new C1135dv(arrayList);
        }
    }

    public ConstraintReference verticalBias(float f) {
        this.mVerticalBias = f;
        return this;
    }

    public ConstraintReference visibility(int i) {
        this.f2326v = i;
        return this;
    }

    public ConstraintReference width(Dimension dimension) {
        return setWidth(dimension);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public ConstraintReference margin(int i) {
        State.Constraint constraint = this.f2297E;
        if (constraint != null) {
            switch (AbstractC0121a.f2390a[constraint.ordinal()]) {
                case 1:
                case 2:
                    this.mMarginLeft = i;
                    break;
                case 3:
                case 4:
                    this.mMarginRight = i;
                    break;
                case 5:
                case 6:
                    this.mMarginStart = i;
                    break;
                case 7:
                case 8:
                    this.mMarginEnd = i;
                    break;
                case 9:
                case 10:
                case 11:
                    this.mMarginTop = i;
                    break;
                case 12:
                case 13:
                case 14:
                    this.mMarginBottom = i;
                    break;
                case 15:
                case 16:
                case 17:
                    this.f2313i = i;
                    break;
                case 18:
                    this.f2296D = i;
                    break;
            }
        } else {
            this.mMarginLeft = i;
            this.mMarginRight = i;
            this.mMarginStart = i;
            this.mMarginEnd = i;
            this.mMarginTop = i;
            this.mMarginBottom = i;
        }
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public ConstraintReference marginGone(int i) {
        State.Constraint constraint = this.f2297E;
        if (constraint != null) {
            switch (AbstractC0121a.f2390a[constraint.ordinal()]) {
                case 1:
                case 2:
                    this.mMarginLeftGone = i;
                    break;
                case 3:
                case 4:
                    this.mMarginRightGone = i;
                    break;
                case 5:
                case 6:
                    this.mMarginStartGone = i;
                    break;
                case 7:
                case 8:
                    this.mMarginEndGone = i;
                    break;
                case 9:
                case 10:
                case 11:
                    this.mMarginTopGone = i;
                    break;
                case 12:
                case 13:
                case 14:
                    this.mMarginBottomGone = i;
                    break;
                case 15:
                case 16:
                case 17:
                    this.f2314j = i;
                    break;
            }
        } else {
            this.mMarginLeftGone = i;
            this.mMarginRightGone = i;
            this.mMarginStartGone = i;
            this.mMarginEndGone = i;
            this.mMarginTopGone = i;
            this.mMarginBottomGone = i;
        }
        return this;
    }
}
