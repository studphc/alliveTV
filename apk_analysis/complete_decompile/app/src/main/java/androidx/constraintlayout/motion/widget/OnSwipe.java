package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
public class OnSwipe {
    public static final int COMPLETE_MODE_CONTINUOUS_VELOCITY = 0;
    public static final int COMPLETE_MODE_SPRING = 1;
    public static final int DRAG_ANTICLOCKWISE = 7;
    public static final int DRAG_CLOCKWISE = 6;
    public static final int DRAG_DOWN = 1;
    public static final int DRAG_END = 5;
    public static final int DRAG_LEFT = 2;
    public static final int DRAG_RIGHT = 3;
    public static final int DRAG_START = 4;
    public static final int DRAG_UP = 0;
    public static final int FLAG_DISABLE_POST_SCROLL = 1;
    public static final int FLAG_DISABLE_SCROLL = 2;
    public static final int ON_UP_AUTOCOMPLETE = 0;
    public static final int ON_UP_AUTOCOMPLETE_TO_END = 2;
    public static final int ON_UP_AUTOCOMPLETE_TO_START = 1;
    public static final int ON_UP_DECELERATE = 4;
    public static final int ON_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int ON_UP_NEVER_TO_END = 7;
    public static final int ON_UP_NEVER_TO_START = 6;
    public static final int ON_UP_STOP = 3;
    public static final int SIDE_BOTTOM = 3;
    public static final int SIDE_END = 6;
    public static final int SIDE_LEFT = 1;
    public static final int SIDE_MIDDLE = 4;
    public static final int SIDE_RIGHT = 2;
    public static final int SIDE_START = 5;
    public static final int SIDE_TOP = 0;
    public static final int SPRING_BOUNDARY_BOUNCEBOTH = 3;
    public static final int SPRING_BOUNDARY_BOUNCEEND = 2;
    public static final int SPRING_BOUNDARY_BOUNCESTART = 1;
    public static final int SPRING_BOUNDARY_OVERSHOOT = 0;

    /* renamed from: a */
    public int f2937a = 0;

    /* renamed from: b */
    public int f2938b = 0;

    /* renamed from: c */
    public int f2939c = -1;

    /* renamed from: d */
    public int f2940d = -1;

    /* renamed from: e */
    public int f2941e = -1;

    /* renamed from: f */
    public int f2942f = 0;

    /* renamed from: g */
    public int f2943g = -1;

    /* renamed from: h */
    public float f2944h = 4.0f;

    /* renamed from: i */
    public float f2945i = 1.2f;

    /* renamed from: j */
    public boolean f2946j = true;

    /* renamed from: k */
    public float f2947k = 1.0f;

    /* renamed from: l */
    public int f2948l = 0;

    /* renamed from: m */
    public float f2949m = 10.0f;

    /* renamed from: n */
    public float f2950n = Float.NaN;

    /* renamed from: o */
    public float f2951o = 1.0f;

    /* renamed from: p */
    public float f2952p = Float.NaN;

    /* renamed from: q */
    public float f2953q = Float.NaN;

    /* renamed from: r */
    public int f2954r = 0;

    /* renamed from: s */
    public int f2955s = 0;

    public int getAutoCompleteMode() {
        return this.f2955s;
    }

    public int getDragDirection() {
        return this.f2937a;
    }

    public float getDragScale() {
        return this.f2947k;
    }

    public float getDragThreshold() {
        return this.f2949m;
    }

    public int getLimitBoundsTo() {
        return this.f2941e;
    }

    public float getMaxAcceleration() {
        return this.f2945i;
    }

    public float getMaxVelocity() {
        return this.f2944h;
    }

    public boolean getMoveWhenScrollAtTop() {
        return this.f2946j;
    }

    public int getNestedScrollFlags() {
        return this.f2948l;
    }

    public int getOnTouchUp() {
        return this.f2942f;
    }

    public int getRotationCenterId() {
        return this.f2943g;
    }

    public int getSpringBoundary() {
        return this.f2954r;
    }

    public float getSpringDamping() {
        return this.f2950n;
    }

    public float getSpringMass() {
        return this.f2951o;
    }

    public float getSpringStiffness() {
        return this.f2952p;
    }

    public float getSpringStopThreshold() {
        return this.f2953q;
    }

    public int getTouchAnchorId() {
        return this.f2939c;
    }

    public int getTouchAnchorSide() {
        return this.f2938b;
    }

    public int getTouchRegionId() {
        return this.f2940d;
    }

    public void setAutoCompleteMode(int i) {
        this.f2955s = i;
    }

    public OnSwipe setDragDirection(int i) {
        this.f2937a = i;
        return this;
    }

    public OnSwipe setDragScale(int i) {
        this.f2947k = i;
        return this;
    }

    public OnSwipe setDragThreshold(int i) {
        this.f2949m = i;
        return this;
    }

    public OnSwipe setLimitBoundsTo(int i) {
        this.f2941e = i;
        return this;
    }

    public OnSwipe setMaxAcceleration(int i) {
        this.f2945i = i;
        return this;
    }

    public OnSwipe setMaxVelocity(int i) {
        this.f2944h = i;
        return this;
    }

    public OnSwipe setMoveWhenScrollAtTop(boolean z) {
        this.f2946j = z;
        return this;
    }

    public OnSwipe setNestedScrollFlags(int i) {
        this.f2948l = i;
        return this;
    }

    public OnSwipe setOnTouchUp(int i) {
        this.f2942f = i;
        return this;
    }

    public OnSwipe setRotateCenter(int i) {
        this.f2943g = i;
        return this;
    }

    public OnSwipe setSpringBoundary(int i) {
        this.f2954r = i;
        return this;
    }

    public OnSwipe setSpringDamping(float f) {
        this.f2950n = f;
        return this;
    }

    public OnSwipe setSpringMass(float f) {
        this.f2951o = f;
        return this;
    }

    public OnSwipe setSpringStiffness(float f) {
        this.f2952p = f;
        return this;
    }

    public OnSwipe setSpringStopThreshold(float f) {
        this.f2953q = f;
        return this;
    }

    public OnSwipe setTouchAnchorId(int i) {
        this.f2939c = i;
        return this;
    }

    public OnSwipe setTouchAnchorSide(int i) {
        this.f2938b = i;
        return this;
    }

    public OnSwipe setTouchRegionId(int i) {
        this.f2940d = i;
        return this;
    }
}
