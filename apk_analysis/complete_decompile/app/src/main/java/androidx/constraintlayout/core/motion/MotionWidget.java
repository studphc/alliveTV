package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Set;
import p000.ly2;
import p000.py2;

/* loaded from: classes.dex */
public class MotionWidget implements TypedValues {
    public static final int FILL_PARENT = -1;
    public static final int GONE_UNSET = Integer.MIN_VALUE;
    public static final int INVISIBLE = 0;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int MATCH_PARENT = -1;
    public static final int PARENT_ID = 0;
    public static final int ROTATE_LEFT_OF_PORTRATE = 4;
    public static final int ROTATE_NONE = 0;
    public static final int ROTATE_PORTRATE_OF_LEFT = 2;
    public static final int ROTATE_PORTRATE_OF_RIGHT = 1;
    public static final int ROTATE_RIGHT_OF_PORTRATE = 3;
    public static final int UNSET = -1;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 4;
    public static final int WRAP_CONTENT = -2;

    /* renamed from: a */
    public WidgetFrame f2110a;

    /* renamed from: b */
    public final Motion f2111b;

    /* renamed from: c */
    public final PropertySet f2112c;

    /* renamed from: d */
    public float f2113d;

    /* renamed from: e */
    public float f2114e;

    /* loaded from: classes.dex */
    public static class Motion {
        public String mAnimateRelativeTo = null;
        public int mAnimateCircleAngleTo = 0;
        public String mTransitionEasing = null;
        public int mPathMotionArc = -1;
        public int mDrawPath = 0;
        public float mMotionStagger = Float.NaN;
        public int mPolarRelativeTo = -1;
        public float mPathRotate = Float.NaN;
        public float mQuantizeMotionPhase = Float.NaN;
        public int mQuantizeMotionSteps = -1;
        public String mQuantizeInterpolatorString = null;
        public int mQuantizeInterpolatorType = -3;
        public int mQuantizeInterpolatorID = -1;
    }

    /* loaded from: classes.dex */
    public static class PropertySet {
        public int visibility = 4;
        public int mVisibilityMode = 0;
        public float alpha = 1.0f;
        public float mProgress = Float.NaN;
    }

    public MotionWidget() {
        this.f2110a = new WidgetFrame();
        this.f2111b = new Motion();
        this.f2112c = new PropertySet();
    }

    public MotionWidget findViewById(int i) {
        return null;
    }

    public float getAlpha() {
        return this.f2110a.alpha;
    }

    public int getBottom() {
        return this.f2110a.bottom;
    }

    public CustomVariable getCustomAttribute(String str) {
        return this.f2110a.getCustomAttribute(str);
    }

    public Set<String> getCustomAttributeNames() {
        return this.f2110a.getCustomAttributeNames();
    }

    public int getHeight() {
        WidgetFrame widgetFrame = this.f2110a;
        return widgetFrame.bottom - widgetFrame.top;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        int m5999a = ly2.m5999a(str);
        if (m5999a != -1) {
            return m5999a;
        }
        return py2.m6935a(str);
    }

    public int getLeft() {
        return this.f2110a.left;
    }

    public String getName() {
        return this.f2110a.getId();
    }

    public MotionWidget getParent() {
        return null;
    }

    public float getPivotX() {
        return this.f2110a.pivotX;
    }

    public float getPivotY() {
        return this.f2110a.pivotY;
    }

    public int getRight() {
        return this.f2110a.right;
    }

    public float getRotationX() {
        return this.f2110a.rotationX;
    }

    public float getRotationY() {
        return this.f2110a.rotationY;
    }

    public float getRotationZ() {
        return this.f2110a.rotationZ;
    }

    public float getScaleX() {
        return this.f2110a.scaleX;
    }

    public float getScaleY() {
        return this.f2110a.scaleY;
    }

    public int getTop() {
        return this.f2110a.top;
    }

    public float getTranslationX() {
        return this.f2110a.translationX;
    }

    public float getTranslationY() {
        return this.f2110a.translationY;
    }

    public float getTranslationZ() {
        return this.f2110a.translationZ;
    }

    public float getValueAttributes(int i) {
        switch (i) {
            case 303:
                return this.f2110a.alpha;
            case 304:
                return this.f2110a.translationX;
            case 305:
                return this.f2110a.translationY;
            case 306:
                return this.f2110a.translationZ;
            case 307:
            default:
                return Float.NaN;
            case 308:
                return this.f2110a.rotationX;
            case 309:
                return this.f2110a.rotationY;
            case 310:
                return this.f2110a.rotationZ;
            case 311:
                return this.f2110a.scaleX;
            case 312:
                return this.f2110a.scaleY;
            case 313:
                return this.f2110a.pivotX;
            case 314:
                return this.f2110a.pivotY;
            case 315:
                return this.f2113d;
            case TypedValues.AttributesType.TYPE_PATH_ROTATE /* 316 */:
                return this.f2114e;
        }
    }

    public int getVisibility() {
        return this.f2112c.visibility;
    }

    public WidgetFrame getWidgetFrame() {
        return this.f2110a;
    }

    public int getWidth() {
        WidgetFrame widgetFrame = this.f2110a;
        return widgetFrame.right - widgetFrame.left;
    }

    public int getX() {
        return this.f2110a.left;
    }

    public int getY() {
        return this.f2110a.top;
    }

    public void layout(int i, int i2, int i3, int i4) {
        setBounds(i, i2, i3, i4);
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        if (this.f2110a == null) {
            this.f2110a = new WidgetFrame((ConstraintWidget) null);
        }
        WidgetFrame widgetFrame = this.f2110a;
        widgetFrame.top = i2;
        widgetFrame.left = i;
        widgetFrame.right = i3;
        widgetFrame.bottom = i4;
    }

    public void setCustomAttribute(String str, int i, float f) {
        this.f2110a.setCustomAttribute(str, i, f);
    }

    public void setInterpolatedValue(CustomAttribute customAttribute, float[] fArr) {
        this.f2110a.setCustomAttribute(customAttribute.f2047a, TypedValues.Custom.TYPE_FLOAT, fArr[0]);
    }

    public void setPivotX(float f) {
        this.f2110a.pivotX = f;
    }

    public void setPivotY(float f) {
        this.f2110a.pivotY = f;
    }

    public void setRotationX(float f) {
        this.f2110a.rotationX = f;
    }

    public void setRotationY(float f) {
        this.f2110a.rotationY = f;
    }

    public void setRotationZ(float f) {
        this.f2110a.rotationZ = f;
    }

    public void setScaleX(float f) {
        this.f2110a.scaleX = f;
    }

    public void setScaleY(float f) {
        this.f2110a.scaleY = f;
    }

    public void setTranslationX(float f) {
        this.f2110a.translationX = f;
    }

    public void setTranslationY(float f) {
        this.f2110a.translationY = f;
    }

    public void setTranslationZ(float f) {
        this.f2110a.translationZ = f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, boolean z) {
        return false;
    }

    public boolean setValueAttributes(int i, float f) {
        switch (i) {
            case 303:
                this.f2110a.alpha = f;
                return true;
            case 304:
                this.f2110a.translationX = f;
                return true;
            case 305:
                this.f2110a.translationY = f;
                return true;
            case 306:
                this.f2110a.translationZ = f;
                return true;
            case 307:
            default:
                return false;
            case 308:
                this.f2110a.rotationX = f;
                return true;
            case 309:
                this.f2110a.rotationY = f;
                return true;
            case 310:
                this.f2110a.rotationZ = f;
                return true;
            case 311:
                this.f2110a.scaleX = f;
                return true;
            case 312:
                this.f2110a.scaleY = f;
                return true;
            case 313:
                this.f2110a.pivotX = f;
                return true;
            case 314:
                this.f2110a.pivotY = f;
                return true;
            case 315:
                this.f2113d = f;
                return true;
            case TypedValues.AttributesType.TYPE_PATH_ROTATE /* 316 */:
                this.f2114e = f;
                return true;
        }
    }

    public boolean setValueMotion(int i, int i2) {
        Motion motion = this.f2111b;
        switch (i) {
            case TypedValues.MotionType.TYPE_ANIMATE_CIRCLEANGLE_TO /* 606 */:
                motion.mAnimateCircleAngleTo = i2;
                return true;
            case TypedValues.MotionType.TYPE_PATHMOTION_ARC /* 607 */:
                motion.mPathMotionArc = i2;
                return true;
            case TypedValues.MotionType.TYPE_DRAW_PATH /* 608 */:
                motion.mDrawPath = i2;
                return true;
            case TypedValues.MotionType.TYPE_POLAR_RELATIVETO /* 609 */:
                motion.mPolarRelativeTo = i2;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS /* 610 */:
                motion.mQuantizeMotionSteps = i2;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_TYPE /* 611 */:
                motion.mQuantizeInterpolatorType = i2;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID /* 612 */:
                motion.mQuantizeInterpolatorID = i2;
                return true;
            default:
                return false;
        }
    }

    public void setVisibility(int i) {
        this.f2112c.visibility = i;
    }

    public String toString() {
        return this.f2110a.left + ", " + this.f2110a.top + ", " + this.f2110a.right + ", " + this.f2110a.bottom;
    }

    public void updateMotion(TypedValues typedValues) {
        if (this.f2110a.getMotionProperties() != null) {
            this.f2110a.getMotionProperties().applyDelta(typedValues);
        }
    }

    public void setCustomAttribute(String str, int i, int i2) {
        this.f2110a.setCustomAttribute(str, i, i2);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i2) {
        if (setValueAttributes(i, i2)) {
            return true;
        }
        return setValueMotion(i, i2);
    }

    public void setCustomAttribute(String str, int i, boolean z) {
        this.f2110a.setCustomAttribute(str, i, z);
    }

    public void setCustomAttribute(String str, int i, String str2) {
        this.f2110a.setCustomAttribute(str, i, str2);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        if (setValueAttributes(i, f)) {
            return true;
        }
        return setValueMotion(i, f);
    }

    public MotionWidget(WidgetFrame widgetFrame) {
        this.f2110a = new WidgetFrame();
        this.f2111b = new Motion();
        this.f2112c = new PropertySet();
        this.f2110a = widgetFrame;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (i == 605) {
            this.f2111b.mAnimateRelativeTo = str;
            return true;
        }
        return setValueMotion(i, str);
    }

    public boolean setValueMotion(int i, String str) {
        Motion motion = this.f2111b;
        if (i == 603) {
            motion.mTransitionEasing = str;
            return true;
        }
        if (i != 604) {
            return false;
        }
        motion.mQuantizeInterpolatorString = str;
        return true;
    }

    public boolean setValueMotion(int i, float f) {
        Motion motion = this.f2111b;
        switch (i) {
            case 600:
                motion.mMotionStagger = f;
                return true;
            case 601:
                motion.mPathRotate = f;
                return true;
            case TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE /* 602 */:
                motion.mQuantizeMotionPhase = f;
                return true;
            default:
                return false;
        }
    }
}
