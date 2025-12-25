package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class ConstraintSet {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int CIRCLE_REFERENCE = 8;
    public static final int END = 7;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int HORIZONTAL_GUIDELINE = 0;
    public static final int INVISIBLE = 4;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int ROTATE_LEFT_OF_PORTRATE = 4;
    public static final int ROTATE_NONE = 0;
    public static final int ROTATE_PORTRATE_OF_LEFT = 2;
    public static final int ROTATE_PORTRATE_OF_RIGHT = 1;
    public static final int ROTATE_RIGHT_OF_PORTRATE = 3;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int VERTICAL = 1;
    public static final int VERTICAL_GUIDELINE = 1;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 0;
    public static final int WRAP_CONTENT = -2;

    /* renamed from: f */
    public static final int[] f3183f = {0, 4, 8};

    /* renamed from: g */
    public static final SparseIntArray f3184g;

    /* renamed from: h */
    public static final SparseIntArray f3185h;

    /* renamed from: a */
    public boolean f3186a;
    public String mIdString;
    public String derivedState = "";

    /* renamed from: b */
    public String[] f3187b = new String[0];
    public int mRotate = 0;

    /* renamed from: c */
    public final HashMap f3188c = new HashMap();

    /* renamed from: d */
    public boolean f3189d = true;

    /* renamed from: e */
    public final HashMap f3190e = new HashMap();

    /* loaded from: classes.dex */
    public static class Constraint {

        /* renamed from: a */
        public int f3191a;

        /* renamed from: b */
        public String f3192b;

        /* renamed from: c */
        public C0133e f3193c;
        public final PropertySet propertySet = new PropertySet();
        public final Motion motion = new Motion();
        public final Layout layout = new Layout();
        public final Transform transform = new Transform();
        public HashMap<String, ConstraintAttribute> mCustomConstraints = new HashMap<>();

        /* renamed from: a */
        public final void m653a(int i, ConstraintLayout.LayoutParams layoutParams) {
            this.f3191a = i;
            Layout layout = this.layout;
            layout.leftToLeft = layoutParams.leftToLeft;
            layout.leftToRight = layoutParams.leftToRight;
            layout.rightToLeft = layoutParams.rightToLeft;
            layout.rightToRight = layoutParams.rightToRight;
            layout.topToTop = layoutParams.topToTop;
            layout.topToBottom = layoutParams.topToBottom;
            layout.bottomToTop = layoutParams.bottomToTop;
            layout.bottomToBottom = layoutParams.bottomToBottom;
            layout.baselineToBaseline = layoutParams.baselineToBaseline;
            layout.baselineToTop = layoutParams.baselineToTop;
            layout.baselineToBottom = layoutParams.baselineToBottom;
            layout.startToEnd = layoutParams.startToEnd;
            layout.startToStart = layoutParams.startToStart;
            layout.endToStart = layoutParams.endToStart;
            layout.endToEnd = layoutParams.endToEnd;
            layout.horizontalBias = layoutParams.horizontalBias;
            layout.verticalBias = layoutParams.verticalBias;
            layout.dimensionRatio = layoutParams.dimensionRatio;
            layout.circleConstraint = layoutParams.circleConstraint;
            layout.circleRadius = layoutParams.circleRadius;
            layout.circleAngle = layoutParams.circleAngle;
            layout.editorAbsoluteX = layoutParams.editorAbsoluteX;
            layout.editorAbsoluteY = layoutParams.editorAbsoluteY;
            layout.orientation = layoutParams.orientation;
            layout.guidePercent = layoutParams.guidePercent;
            layout.guideBegin = layoutParams.guideBegin;
            layout.guideEnd = layoutParams.guideEnd;
            layout.mWidth = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            layout.mHeight = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            layout.leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            layout.rightMargin = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            layout.topMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            layout.bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            layout.baselineMargin = layoutParams.baselineMargin;
            layout.verticalWeight = layoutParams.verticalWeight;
            layout.horizontalWeight = layoutParams.horizontalWeight;
            layout.verticalChainStyle = layoutParams.verticalChainStyle;
            layout.horizontalChainStyle = layoutParams.horizontalChainStyle;
            layout.constrainedWidth = layoutParams.constrainedWidth;
            layout.constrainedHeight = layoutParams.constrainedHeight;
            layout.widthDefault = layoutParams.matchConstraintDefaultWidth;
            layout.heightDefault = layoutParams.matchConstraintDefaultHeight;
            layout.widthMax = layoutParams.matchConstraintMaxWidth;
            layout.heightMax = layoutParams.matchConstraintMaxHeight;
            layout.widthMin = layoutParams.matchConstraintMinWidth;
            layout.heightMin = layoutParams.matchConstraintMinHeight;
            layout.widthPercent = layoutParams.matchConstraintPercentWidth;
            layout.heightPercent = layoutParams.matchConstraintPercentHeight;
            layout.mConstraintTag = layoutParams.constraintTag;
            layout.goneTopMargin = layoutParams.goneTopMargin;
            layout.goneBottomMargin = layoutParams.goneBottomMargin;
            layout.goneLeftMargin = layoutParams.goneLeftMargin;
            layout.goneRightMargin = layoutParams.goneRightMargin;
            layout.goneStartMargin = layoutParams.goneStartMargin;
            layout.goneEndMargin = layoutParams.goneEndMargin;
            layout.goneBaselineMargin = layoutParams.goneBaselineMargin;
            layout.mWrapBehavior = layoutParams.wrapBehaviorInParent;
            layout.endMargin = layoutParams.getMarginEnd();
            this.layout.startMargin = layoutParams.getMarginStart();
        }

        public void applyDelta(Constraint constraint) {
            C0133e c0133e = this.f3193c;
            if (c0133e != null) {
                c0133e.m669e(constraint);
            }
        }

        public void applyTo(ConstraintLayout.LayoutParams layoutParams) {
            Layout layout = this.layout;
            layoutParams.leftToLeft = layout.leftToLeft;
            layoutParams.leftToRight = layout.leftToRight;
            layoutParams.rightToLeft = layout.rightToLeft;
            layoutParams.rightToRight = layout.rightToRight;
            layoutParams.topToTop = layout.topToTop;
            layoutParams.topToBottom = layout.topToBottom;
            layoutParams.bottomToTop = layout.bottomToTop;
            layoutParams.bottomToBottom = layout.bottomToBottom;
            layoutParams.baselineToBaseline = layout.baselineToBaseline;
            layoutParams.baselineToTop = layout.baselineToTop;
            layoutParams.baselineToBottom = layout.baselineToBottom;
            layoutParams.startToEnd = layout.startToEnd;
            layoutParams.startToStart = layout.startToStart;
            layoutParams.endToStart = layout.endToStart;
            layoutParams.endToEnd = layout.endToEnd;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = layout.leftMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = layout.rightMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = layout.topMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = layout.bottomMargin;
            layoutParams.goneStartMargin = layout.goneStartMargin;
            layoutParams.goneEndMargin = layout.goneEndMargin;
            layoutParams.goneTopMargin = layout.goneTopMargin;
            layoutParams.goneBottomMargin = layout.goneBottomMargin;
            layoutParams.horizontalBias = layout.horizontalBias;
            layoutParams.verticalBias = layout.verticalBias;
            layoutParams.circleConstraint = layout.circleConstraint;
            layoutParams.circleRadius = layout.circleRadius;
            layoutParams.circleAngle = layout.circleAngle;
            layoutParams.dimensionRatio = layout.dimensionRatio;
            layoutParams.editorAbsoluteX = layout.editorAbsoluteX;
            layoutParams.editorAbsoluteY = layout.editorAbsoluteY;
            layoutParams.verticalWeight = layout.verticalWeight;
            layoutParams.horizontalWeight = layout.horizontalWeight;
            layoutParams.verticalChainStyle = layout.verticalChainStyle;
            layoutParams.horizontalChainStyle = layout.horizontalChainStyle;
            layoutParams.constrainedWidth = layout.constrainedWidth;
            layoutParams.constrainedHeight = layout.constrainedHeight;
            layoutParams.matchConstraintDefaultWidth = layout.widthDefault;
            layoutParams.matchConstraintDefaultHeight = layout.heightDefault;
            layoutParams.matchConstraintMaxWidth = layout.widthMax;
            layoutParams.matchConstraintMaxHeight = layout.heightMax;
            layoutParams.matchConstraintMinWidth = layout.widthMin;
            layoutParams.matchConstraintMinHeight = layout.heightMin;
            layoutParams.matchConstraintPercentWidth = layout.widthPercent;
            layoutParams.matchConstraintPercentHeight = layout.heightPercent;
            layoutParams.orientation = layout.orientation;
            layoutParams.guidePercent = layout.guidePercent;
            layoutParams.guideBegin = layout.guideBegin;
            layoutParams.guideEnd = layout.guideEnd;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = layout.mWidth;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = layout.mHeight;
            String str = layout.mConstraintTag;
            if (str != null) {
                layoutParams.constraintTag = str;
            }
            layoutParams.wrapBehaviorInParent = layout.mWrapBehavior;
            layoutParams.setMarginStart(layout.startMargin);
            layoutParams.setMarginEnd(this.layout.endMargin);
            layoutParams.validate();
        }

        /* renamed from: b */
        public final void m654b(int i, Constraints.LayoutParams layoutParams) {
            m653a(i, layoutParams);
            this.propertySet.alpha = layoutParams.alpha;
            Transform transform = this.transform;
            transform.rotation = layoutParams.rotation;
            transform.rotationX = layoutParams.rotationX;
            transform.rotationY = layoutParams.rotationY;
            transform.scaleX = layoutParams.scaleX;
            transform.scaleY = layoutParams.scaleY;
            transform.transformPivotX = layoutParams.transformPivotX;
            transform.transformPivotY = layoutParams.transformPivotY;
            transform.translationX = layoutParams.translationX;
            transform.translationY = layoutParams.translationY;
            transform.translationZ = layoutParams.translationZ;
            transform.elevation = layoutParams.elevation;
            transform.applyElevation = layoutParams.applyElevation;
        }

        /* renamed from: c */
        public final ConstraintAttribute m655c(String str, ConstraintAttribute.AttributeType attributeType) {
            if (this.mCustomConstraints.containsKey(str)) {
                ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(str);
                if (constraintAttribute.getType() != attributeType) {
                    throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute.getType().name());
                }
                return constraintAttribute;
            }
            ConstraintAttribute constraintAttribute2 = new ConstraintAttribute(str, attributeType);
            this.mCustomConstraints.put(str, constraintAttribute2);
            return constraintAttribute2;
        }

        public void printDelta(String str) {
            C0133e c0133e = this.f3193c;
            if (c0133e != null) {
                c0133e.getClass();
                Log.v(str, "int");
                for (int i = 0; i < c0133e.f3235c; i++) {
                    Log.v(str, c0133e.f3233a[i] + " = " + c0133e.f3234b[i]);
                }
                Log.v(str, TypedValues.Custom.S_FLOAT);
                for (int i2 = 0; i2 < c0133e.f3238f; i2++) {
                    Log.v(str, c0133e.f3236d[i2] + " = " + c0133e.f3237e[i2]);
                }
                Log.v(str, "strings");
                for (int i3 = 0; i3 < c0133e.f3241i; i3++) {
                    Log.v(str, c0133e.f3239g[i3] + " = " + c0133e.f3240h[i3]);
                }
                Log.v(str, TypedValues.Custom.S_BOOLEAN);
                for (int i4 = 0; i4 < c0133e.f3244l; i4++) {
                    Log.v(str, c0133e.f3242j[i4] + " = " + c0133e.f3243k[i4]);
                }
                return;
            }
            Log.v(str, "DELTA IS NULL");
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Constraint m8478clone() {
            Constraint constraint = new Constraint();
            constraint.layout.copyFrom(this.layout);
            constraint.motion.copyFrom(this.motion);
            constraint.propertySet.copyFrom(this.propertySet);
            constraint.transform.copyFrom(this.transform);
            constraint.f3191a = this.f3191a;
            constraint.f3193c = this.f3193c;
            return constraint;
        }
    }

    /* loaded from: classes.dex */
    public static class Layout {
        public static final int UNSET = -1;
        public static final int UNSET_GONE_MARGIN = Integer.MIN_VALUE;

        /* renamed from: a */
        public static final SparseIntArray f3194a;
        public String mConstraintTag;
        public int mHeight;
        public String mReferenceIdString;
        public int[] mReferenceIds;
        public int mWidth;
        public boolean mIsGuideline = false;
        public boolean mApply = false;
        public boolean mOverride = false;
        public int guideBegin = -1;
        public int guideEnd = -1;
        public float guidePercent = -1.0f;
        public boolean guidelineUseRtl = true;
        public int leftToLeft = -1;
        public int leftToRight = -1;
        public int rightToLeft = -1;
        public int rightToRight = -1;
        public int topToTop = -1;
        public int topToBottom = -1;
        public int bottomToTop = -1;
        public int bottomToBottom = -1;
        public int baselineToBaseline = -1;
        public int baselineToTop = -1;
        public int baselineToBottom = -1;
        public int startToEnd = -1;
        public int startToStart = -1;
        public int endToStart = -1;
        public int endToEnd = -1;
        public float horizontalBias = 0.5f;
        public float verticalBias = 0.5f;
        public String dimensionRatio = null;
        public int circleConstraint = -1;
        public int circleRadius = 0;
        public float circleAngle = RecyclerView.f7068F0;
        public int editorAbsoluteX = -1;
        public int editorAbsoluteY = -1;
        public int orientation = -1;
        public int leftMargin = 0;
        public int rightMargin = 0;
        public int topMargin = 0;
        public int bottomMargin = 0;
        public int endMargin = 0;
        public int startMargin = 0;
        public int baselineMargin = 0;
        public int goneLeftMargin = Integer.MIN_VALUE;
        public int goneTopMargin = Integer.MIN_VALUE;
        public int goneRightMargin = Integer.MIN_VALUE;
        public int goneBottomMargin = Integer.MIN_VALUE;
        public int goneEndMargin = Integer.MIN_VALUE;
        public int goneStartMargin = Integer.MIN_VALUE;
        public int goneBaselineMargin = Integer.MIN_VALUE;
        public float verticalWeight = -1.0f;
        public float horizontalWeight = -1.0f;
        public int horizontalChainStyle = 0;
        public int verticalChainStyle = 0;
        public int widthDefault = 0;
        public int heightDefault = 0;
        public int widthMax = 0;
        public int heightMax = 0;
        public int widthMin = 0;
        public int heightMin = 0;
        public float widthPercent = 1.0f;
        public float heightPercent = 1.0f;
        public int mBarrierDirection = -1;
        public int mBarrierMargin = 0;
        public int mHelperType = -1;
        public boolean constrainedWidth = false;
        public boolean constrainedHeight = false;
        public boolean mBarrierAllowsGoneWidgets = true;
        public int mWrapBehavior = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f3194a = sparseIntArray;
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            sparseIntArray.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            sparseIntArray.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            sparseIntArray.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            sparseIntArray.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            sparseIntArray.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            sparseIntArray.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            sparseIntArray.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            sparseIntArray.append(R.styleable.Layout_layout_editor_absoluteX, 6);
            sparseIntArray.append(R.styleable.Layout_layout_editor_absoluteY, 7);
            sparseIntArray.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
            sparseIntArray.append(R.styleable.Layout_layout_constraintGuide_end, 18);
            sparseIntArray.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
            int i = R.styleable.Layout_guidelineUseRtl;
            sparseIntArray.append(i, 90);
            sparseIntArray.append(R.styleable.Layout_android_orientation, 26);
            sparseIntArray.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            sparseIntArray.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            sparseIntArray.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            sparseIntArray.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            sparseIntArray.append(R.styleable.Layout_layout_goneMarginLeft, 13);
            sparseIntArray.append(R.styleable.Layout_layout_goneMarginTop, 16);
            sparseIntArray.append(R.styleable.Layout_layout_goneMarginRight, 14);
            sparseIntArray.append(R.styleable.Layout_layout_goneMarginBottom, 11);
            sparseIntArray.append(R.styleable.Layout_layout_goneMarginStart, 15);
            sparseIntArray.append(R.styleable.Layout_layout_goneMarginEnd, 12);
            sparseIntArray.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
            sparseIntArray.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            sparseIntArray.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            sparseIntArray.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            sparseIntArray.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            sparseIntArray.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
            sparseIntArray.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_creator, 91);
            sparseIntArray.append(R.styleable.Layout_layout_constraintTop_creator, 91);
            sparseIntArray.append(R.styleable.Layout_layout_constraintRight_creator, 91);
            sparseIntArray.append(R.styleable.Layout_layout_constraintBottom_creator, 91);
            sparseIntArray.append(R.styleable.Layout_layout_constraintBaseline_creator, 91);
            sparseIntArray.append(R.styleable.Layout_android_layout_marginLeft, 23);
            sparseIntArray.append(R.styleable.Layout_android_layout_marginRight, 27);
            sparseIntArray.append(R.styleable.Layout_android_layout_marginStart, 30);
            sparseIntArray.append(R.styleable.Layout_android_layout_marginEnd, 8);
            sparseIntArray.append(R.styleable.Layout_android_layout_marginTop, 33);
            sparseIntArray.append(R.styleable.Layout_android_layout_marginBottom, 2);
            sparseIntArray.append(R.styleable.Layout_android_layout_width, 22);
            sparseIntArray.append(R.styleable.Layout_android_layout_height, 21);
            int i2 = R.styleable.Layout_layout_constraintWidth;
            sparseIntArray.append(i2, 41);
            int i3 = R.styleable.Layout_layout_constraintHeight;
            sparseIntArray.append(i3, 42);
            sparseIntArray.append(R.styleable.Layout_layout_constrainedWidth, 87);
            sparseIntArray.append(R.styleable.Layout_layout_constrainedHeight, 88);
            sparseIntArray.append(R.styleable.Layout_layout_wrapBehaviorInParent, 76);
            sparseIntArray.append(R.styleable.Layout_layout_constraintCircle, 61);
            sparseIntArray.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
            sparseIntArray.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            sparseIntArray.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
            sparseIntArray.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
            sparseIntArray.append(R.styleable.Layout_chainUseRtl, 71);
            sparseIntArray.append(R.styleable.Layout_barrierDirection, 72);
            sparseIntArray.append(R.styleable.Layout_barrierMargin, 73);
            sparseIntArray.append(R.styleable.Layout_constraint_referenced_ids, 74);
            sparseIntArray.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
            int i4 = R.styleable.Layout_layout_constraintWidth_max;
            sparseIntArray.append(i4, 84);
            sparseIntArray.append(R.styleable.Layout_layout_constraintWidth_min, 86);
            sparseIntArray.append(i4, 83);
            sparseIntArray.append(R.styleable.Layout_layout_constraintHeight_min, 85);
            sparseIntArray.append(i2, 87);
            sparseIntArray.append(i3, 88);
            sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 89);
            sparseIntArray.append(i, 90);
        }

        /* renamed from: a */
        public final void m656a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Layout);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                SparseIntArray sparseIntArray = f3194a;
                int i2 = sparseIntArray.get(index);
                switch (i2) {
                    case 1:
                        this.baselineToBaseline = ConstraintSet.m644g(obtainStyledAttributes, index, this.baselineToBaseline);
                        break;
                    case 2:
                        this.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.bottomMargin);
                        break;
                    case 3:
                        this.bottomToBottom = ConstraintSet.m644g(obtainStyledAttributes, index, this.bottomToBottom);
                        break;
                    case 4:
                        this.bottomToTop = ConstraintSet.m644g(obtainStyledAttributes, index, this.bottomToTop);
                        break;
                    case 5:
                        this.dimensionRatio = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                        break;
                    case 7:
                        this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                        break;
                    case 8:
                        this.endMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.endMargin);
                        break;
                    case 9:
                        this.endToEnd = ConstraintSet.m644g(obtainStyledAttributes, index, this.endToEnd);
                        break;
                    case 10:
                        this.endToStart = ConstraintSet.m644g(obtainStyledAttributes, index, this.endToStart);
                        break;
                    case 11:
                        this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                        break;
                    case 12:
                        this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                        break;
                    case 13:
                        this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                        break;
                    case 14:
                        this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                        break;
                    case 15:
                        this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                        break;
                    case 16:
                        this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                        break;
                    case 17:
                        this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                        break;
                    case 18:
                        this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                        break;
                    case 19:
                        this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                        break;
                    case 20:
                        this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                        break;
                    case 21:
                        this.mHeight = obtainStyledAttributes.getLayoutDimension(index, this.mHeight);
                        break;
                    case 22:
                        this.mWidth = obtainStyledAttributes.getLayoutDimension(index, this.mWidth);
                        break;
                    case 23:
                        this.leftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.leftMargin);
                        break;
                    case 24:
                        this.leftToLeft = ConstraintSet.m644g(obtainStyledAttributes, index, this.leftToLeft);
                        break;
                    case 25:
                        this.leftToRight = ConstraintSet.m644g(obtainStyledAttributes, index, this.leftToRight);
                        break;
                    case 26:
                        this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 27:
                        this.rightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.rightMargin);
                        break;
                    case 28:
                        this.rightToLeft = ConstraintSet.m644g(obtainStyledAttributes, index, this.rightToLeft);
                        break;
                    case 29:
                        this.rightToRight = ConstraintSet.m644g(obtainStyledAttributes, index, this.rightToRight);
                        break;
                    case 30:
                        this.startMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.startMargin);
                        break;
                    case 31:
                        this.startToEnd = ConstraintSet.m644g(obtainStyledAttributes, index, this.startToEnd);
                        break;
                    case 32:
                        this.startToStart = ConstraintSet.m644g(obtainStyledAttributes, index, this.startToStart);
                        break;
                    case 33:
                        this.topMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.topMargin);
                        break;
                    case 34:
                        this.topToBottom = ConstraintSet.m644g(obtainStyledAttributes, index, this.topToBottom);
                        break;
                    case 35:
                        this.topToTop = ConstraintSet.m644g(obtainStyledAttributes, index, this.topToTop);
                        break;
                    case 36:
                        this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                        break;
                    case 37:
                        this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                        break;
                    case 38:
                        this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                        break;
                    case 39:
                        this.horizontalChainStyle = obtainStyledAttributes.getInt(index, this.horizontalChainStyle);
                        break;
                    case 40:
                        this.verticalChainStyle = obtainStyledAttributes.getInt(index, this.verticalChainStyle);
                        break;
                    case 41:
                        ConstraintSet.m645h(this, obtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        ConstraintSet.m645h(this, obtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i2) {
                            case 61:
                                this.circleConstraint = ConstraintSet.m644g(obtainStyledAttributes, index, this.circleConstraint);
                                break;
                            case 62:
                                this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                                break;
                            case 63:
                                this.circleAngle = obtainStyledAttributes.getFloat(index, this.circleAngle);
                                break;
                            default:
                                switch (i2) {
                                    case 69:
                                        this.widthPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.heightPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                        break;
                                    case 72:
                                        this.mBarrierDirection = obtainStyledAttributes.getInt(index, this.mBarrierDirection);
                                        break;
                                    case 73:
                                        this.mBarrierMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.mBarrierMargin);
                                        break;
                                    case 74:
                                        this.mReferenceIdString = obtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.mBarrierAllowsGoneWidgets = obtainStyledAttributes.getBoolean(index, this.mBarrierAllowsGoneWidgets);
                                        break;
                                    case 76:
                                        this.mWrapBehavior = obtainStyledAttributes.getInt(index, this.mWrapBehavior);
                                        break;
                                    case 77:
                                        this.baselineToTop = ConstraintSet.m644g(obtainStyledAttributes, index, this.baselineToTop);
                                        break;
                                    case 78:
                                        this.baselineToBottom = ConstraintSet.m644g(obtainStyledAttributes, index, this.baselineToBottom);
                                        break;
                                    case 79:
                                        this.goneBaselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBaselineMargin);
                                        break;
                                    case 80:
                                        this.baselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.baselineMargin);
                                        break;
                                    case 81:
                                        this.widthDefault = obtainStyledAttributes.getInt(index, this.widthDefault);
                                        break;
                                    case 82:
                                        this.heightDefault = obtainStyledAttributes.getInt(index, this.heightDefault);
                                        break;
                                    case 83:
                                        this.heightMax = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMax);
                                        break;
                                    case 84:
                                        this.widthMax = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMax);
                                        break;
                                    case 85:
                                        this.heightMin = obtainStyledAttributes.getDimensionPixelSize(index, this.heightMin);
                                        break;
                                    case 86:
                                        this.widthMin = obtainStyledAttributes.getDimensionPixelSize(index, this.widthMin);
                                        break;
                                    case 87:
                                        this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                                        break;
                                    case 88:
                                        this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                                        break;
                                    case 89:
                                        this.mConstraintTag = obtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.guidelineUseRtl = obtainStyledAttributes.getBoolean(index, this.guidelineUseRtl);
                                        break;
                                    case 91:
                                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                        break;
                                    default:
                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                        break;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void copyFrom(Layout layout) {
            this.mIsGuideline = layout.mIsGuideline;
            this.mWidth = layout.mWidth;
            this.mApply = layout.mApply;
            this.mHeight = layout.mHeight;
            this.guideBegin = layout.guideBegin;
            this.guideEnd = layout.guideEnd;
            this.guidePercent = layout.guidePercent;
            this.guidelineUseRtl = layout.guidelineUseRtl;
            this.leftToLeft = layout.leftToLeft;
            this.leftToRight = layout.leftToRight;
            this.rightToLeft = layout.rightToLeft;
            this.rightToRight = layout.rightToRight;
            this.topToTop = layout.topToTop;
            this.topToBottom = layout.topToBottom;
            this.bottomToTop = layout.bottomToTop;
            this.bottomToBottom = layout.bottomToBottom;
            this.baselineToBaseline = layout.baselineToBaseline;
            this.baselineToTop = layout.baselineToTop;
            this.baselineToBottom = layout.baselineToBottom;
            this.startToEnd = layout.startToEnd;
            this.startToStart = layout.startToStart;
            this.endToStart = layout.endToStart;
            this.endToEnd = layout.endToEnd;
            this.horizontalBias = layout.horizontalBias;
            this.verticalBias = layout.verticalBias;
            this.dimensionRatio = layout.dimensionRatio;
            this.circleConstraint = layout.circleConstraint;
            this.circleRadius = layout.circleRadius;
            this.circleAngle = layout.circleAngle;
            this.editorAbsoluteX = layout.editorAbsoluteX;
            this.editorAbsoluteY = layout.editorAbsoluteY;
            this.orientation = layout.orientation;
            this.leftMargin = layout.leftMargin;
            this.rightMargin = layout.rightMargin;
            this.topMargin = layout.topMargin;
            this.bottomMargin = layout.bottomMargin;
            this.endMargin = layout.endMargin;
            this.startMargin = layout.startMargin;
            this.baselineMargin = layout.baselineMargin;
            this.goneLeftMargin = layout.goneLeftMargin;
            this.goneTopMargin = layout.goneTopMargin;
            this.goneRightMargin = layout.goneRightMargin;
            this.goneBottomMargin = layout.goneBottomMargin;
            this.goneEndMargin = layout.goneEndMargin;
            this.goneStartMargin = layout.goneStartMargin;
            this.goneBaselineMargin = layout.goneBaselineMargin;
            this.verticalWeight = layout.verticalWeight;
            this.horizontalWeight = layout.horizontalWeight;
            this.horizontalChainStyle = layout.horizontalChainStyle;
            this.verticalChainStyle = layout.verticalChainStyle;
            this.widthDefault = layout.widthDefault;
            this.heightDefault = layout.heightDefault;
            this.widthMax = layout.widthMax;
            this.heightMax = layout.heightMax;
            this.widthMin = layout.widthMin;
            this.heightMin = layout.heightMin;
            this.widthPercent = layout.widthPercent;
            this.heightPercent = layout.heightPercent;
            this.mBarrierDirection = layout.mBarrierDirection;
            this.mBarrierMargin = layout.mBarrierMargin;
            this.mHelperType = layout.mHelperType;
            this.mConstraintTag = layout.mConstraintTag;
            int[] iArr = layout.mReferenceIds;
            if (iArr != null && layout.mReferenceIdString == null) {
                this.mReferenceIds = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.mReferenceIds = null;
            }
            this.mReferenceIdString = layout.mReferenceIdString;
            this.constrainedWidth = layout.constrainedWidth;
            this.constrainedHeight = layout.constrainedHeight;
            this.mBarrierAllowsGoneWidgets = layout.mBarrierAllowsGoneWidgets;
            this.mWrapBehavior = layout.mWrapBehavior;
        }

        public void dump(MotionScene motionScene, StringBuilder sb) {
            Field[] declaredFields = getClass().getDeclaredFields();
            sb.append("\n");
            for (Field field : declaredFields) {
                String name = field.getName();
                if (!Modifier.isStatic(field.getModifiers())) {
                    try {
                        Object obj = field.get(this);
                        Class<?> type = field.getType();
                        if (type == Integer.TYPE) {
                            Integer num = (Integer) obj;
                            if (num.intValue() != -1) {
                                Object lookUpConstraintName = motionScene.lookUpConstraintName(num.intValue());
                                sb.append("    ");
                                sb.append(name);
                                sb.append(" = \"");
                                sb.append(lookUpConstraintName == null ? num : lookUpConstraintName);
                                sb.append("\"\n");
                            }
                        } else if (type == Float.TYPE) {
                            Float f = (Float) obj;
                            if (f.floatValue() != -1.0f) {
                                sb.append("    ");
                                sb.append(name);
                                sb.append(" = \"");
                                sb.append(f);
                                sb.append("\"\n");
                            }
                        }
                    } catch (IllegalAccessException e) {
                        Log.e("ConstraintSet", "Error accessing ConstraintSet field", e);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Motion {

        /* renamed from: a */
        public static final SparseIntArray f3195a;
        public boolean mApply = false;
        public int mAnimateRelativeTo = -1;
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

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f3195a = sparseIntArray;
            sparseIntArray.append(R.styleable.Motion_motionPathRotate, 1);
            sparseIntArray.append(R.styleable.Motion_pathMotionArc, 2);
            sparseIntArray.append(R.styleable.Motion_transitionEasing, 3);
            sparseIntArray.append(R.styleable.Motion_drawPath, 4);
            sparseIntArray.append(R.styleable.Motion_animateRelativeTo, 5);
            sparseIntArray.append(R.styleable.Motion_animateCircleAngleTo, 6);
            sparseIntArray.append(R.styleable.Motion_motionStagger, 7);
            sparseIntArray.append(R.styleable.Motion_quantizeMotionSteps, 8);
            sparseIntArray.append(R.styleable.Motion_quantizeMotionPhase, 9);
            sparseIntArray.append(R.styleable.Motion_quantizeMotionInterpolator, 10);
        }

        /* renamed from: a */
        public final void m657a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Motion);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (f3195a.get(index)) {
                    case 1:
                        this.mPathRotate = obtainStyledAttributes.getFloat(index, this.mPathRotate);
                        break;
                    case 2:
                        this.mPathMotionArc = obtainStyledAttributes.getInt(index, this.mPathMotionArc);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            this.mTransitionEasing = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.mTransitionEasing = Easing.NAMED_EASING[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.mDrawPath = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.mAnimateRelativeTo = ConstraintSet.m644g(obtainStyledAttributes, index, this.mAnimateRelativeTo);
                        break;
                    case 6:
                        this.mAnimateCircleAngleTo = obtainStyledAttributes.getInteger(index, this.mAnimateCircleAngleTo);
                        break;
                    case 7:
                        this.mMotionStagger = obtainStyledAttributes.getFloat(index, this.mMotionStagger);
                        break;
                    case 8:
                        this.mQuantizeMotionSteps = obtainStyledAttributes.getInteger(index, this.mQuantizeMotionSteps);
                        break;
                    case 9:
                        this.mQuantizeMotionPhase = obtainStyledAttributes.getFloat(index, this.mQuantizeMotionPhase);
                        break;
                    case 10:
                        int i2 = obtainStyledAttributes.peekValue(index).type;
                        if (i2 == 1) {
                            int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                            this.mQuantizeInterpolatorID = resourceId;
                            if (resourceId != -1) {
                                this.mQuantizeInterpolatorType = -2;
                                break;
                            } else {
                                break;
                            }
                        } else if (i2 == 3) {
                            String string = obtainStyledAttributes.getString(index);
                            this.mQuantizeInterpolatorString = string;
                            if (string.indexOf("/") > 0) {
                                this.mQuantizeInterpolatorID = obtainStyledAttributes.getResourceId(index, -1);
                                this.mQuantizeInterpolatorType = -2;
                                break;
                            } else {
                                this.mQuantizeInterpolatorType = -1;
                                break;
                            }
                        } else {
                            this.mQuantizeInterpolatorType = obtainStyledAttributes.getInteger(index, this.mQuantizeInterpolatorID);
                            break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void copyFrom(Motion motion) {
            this.mApply = motion.mApply;
            this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
            this.mTransitionEasing = motion.mTransitionEasing;
            this.mPathMotionArc = motion.mPathMotionArc;
            this.mDrawPath = motion.mDrawPath;
            this.mPathRotate = motion.mPathRotate;
            this.mMotionStagger = motion.mMotionStagger;
            this.mPolarRelativeTo = motion.mPolarRelativeTo;
        }
    }

    /* loaded from: classes.dex */
    public static class PropertySet {
        public boolean mApply = false;
        public int visibility = 0;
        public int mVisibilityMode = 0;
        public float alpha = 1.0f;
        public float mProgress = Float.NaN;

        /* renamed from: a */
        public final void m658a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PropertySet);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.PropertySet_android_alpha) {
                    this.alpha = obtainStyledAttributes.getFloat(index, this.alpha);
                } else if (index == R.styleable.PropertySet_android_visibility) {
                    int i2 = obtainStyledAttributes.getInt(index, this.visibility);
                    this.visibility = i2;
                    this.visibility = ConstraintSet.f3183f[i2];
                } else if (index == R.styleable.PropertySet_visibilityMode) {
                    this.mVisibilityMode = obtainStyledAttributes.getInt(index, this.mVisibilityMode);
                } else if (index == R.styleable.PropertySet_motionProgress) {
                    this.mProgress = obtainStyledAttributes.getFloat(index, this.mProgress);
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void copyFrom(PropertySet propertySet) {
            this.mApply = propertySet.mApply;
            this.visibility = propertySet.visibility;
            this.alpha = propertySet.alpha;
            this.mProgress = propertySet.mProgress;
            this.mVisibilityMode = propertySet.mVisibilityMode;
        }
    }

    /* loaded from: classes.dex */
    public static class Transform {

        /* renamed from: a */
        public static final SparseIntArray f3196a;
        public boolean mApply = false;
        public float rotation = RecyclerView.f7068F0;
        public float rotationX = RecyclerView.f7068F0;
        public float rotationY = RecyclerView.f7068F0;
        public float scaleX = 1.0f;
        public float scaleY = 1.0f;
        public float transformPivotX = Float.NaN;
        public float transformPivotY = Float.NaN;
        public int transformPivotTarget = -1;
        public float translationX = RecyclerView.f7068F0;
        public float translationY = RecyclerView.f7068F0;
        public float translationZ = RecyclerView.f7068F0;
        public boolean applyElevation = false;
        public float elevation = RecyclerView.f7068F0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f3196a = sparseIntArray;
            sparseIntArray.append(R.styleable.Transform_android_rotation, 1);
            sparseIntArray.append(R.styleable.Transform_android_rotationX, 2);
            sparseIntArray.append(R.styleable.Transform_android_rotationY, 3);
            sparseIntArray.append(R.styleable.Transform_android_scaleX, 4);
            sparseIntArray.append(R.styleable.Transform_android_scaleY, 5);
            sparseIntArray.append(R.styleable.Transform_android_transformPivotX, 6);
            sparseIntArray.append(R.styleable.Transform_android_transformPivotY, 7);
            sparseIntArray.append(R.styleable.Transform_android_translationX, 8);
            sparseIntArray.append(R.styleable.Transform_android_translationY, 9);
            sparseIntArray.append(R.styleable.Transform_android_translationZ, 10);
            sparseIntArray.append(R.styleable.Transform_android_elevation, 11);
            sparseIntArray.append(R.styleable.Transform_transformPivotTarget, 12);
        }

        /* renamed from: a */
        public final void m659a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transform);
            this.mApply = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (f3196a.get(index)) {
                    case 1:
                        this.rotation = obtainStyledAttributes.getFloat(index, this.rotation);
                        break;
                    case 2:
                        this.rotationX = obtainStyledAttributes.getFloat(index, this.rotationX);
                        break;
                    case 3:
                        this.rotationY = obtainStyledAttributes.getFloat(index, this.rotationY);
                        break;
                    case 4:
                        this.scaleX = obtainStyledAttributes.getFloat(index, this.scaleX);
                        break;
                    case 5:
                        this.scaleY = obtainStyledAttributes.getFloat(index, this.scaleY);
                        break;
                    case 6:
                        this.transformPivotX = obtainStyledAttributes.getDimension(index, this.transformPivotX);
                        break;
                    case 7:
                        this.transformPivotY = obtainStyledAttributes.getDimension(index, this.transformPivotY);
                        break;
                    case 8:
                        this.translationX = obtainStyledAttributes.getDimension(index, this.translationX);
                        break;
                    case 9:
                        this.translationY = obtainStyledAttributes.getDimension(index, this.translationY);
                        break;
                    case 10:
                        this.translationZ = obtainStyledAttributes.getDimension(index, this.translationZ);
                        break;
                    case 11:
                        this.applyElevation = true;
                        this.elevation = obtainStyledAttributes.getDimension(index, this.elevation);
                        break;
                    case 12:
                        this.transformPivotTarget = ConstraintSet.m644g(obtainStyledAttributes, index, this.transformPivotTarget);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void copyFrom(Transform transform) {
            this.mApply = transform.mApply;
            this.rotation = transform.rotation;
            this.rotationX = transform.rotationX;
            this.rotationY = transform.rotationY;
            this.scaleX = transform.scaleX;
            this.scaleY = transform.scaleY;
            this.transformPivotX = transform.transformPivotX;
            this.transformPivotY = transform.transformPivotY;
            this.transformPivotTarget = transform.transformPivotTarget;
            this.translationX = transform.translationX;
            this.translationY = transform.translationY;
            this.translationZ = transform.translationZ;
            this.applyElevation = transform.applyElevation;
            this.elevation = transform.elevation;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f3184g = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f3185h = sparseIntArray2;
        sparseIntArray.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        sparseIntArray.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        sparseIntArray.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        sparseIntArray.append(R.styleable.Constraint_guidelineUseRtl, 99);
        sparseIntArray.append(R.styleable.Constraint_android_orientation, 27);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        sparseIntArray.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        sparseIntArray.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        sparseIntArray.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        sparseIntArray.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        sparseIntArray.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        sparseIntArray.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintLeft_creator, 87);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintTop_creator, 87);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintRight_creator, 87);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintBottom_creator, 87);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintBaseline_creator, 87);
        sparseIntArray.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        sparseIntArray.append(R.styleable.Constraint_android_layout_marginRight, 28);
        sparseIntArray.append(R.styleable.Constraint_android_layout_marginStart, 31);
        sparseIntArray.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        sparseIntArray.append(R.styleable.Constraint_android_layout_marginTop, 34);
        sparseIntArray.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        sparseIntArray.append(R.styleable.Constraint_android_layout_width, 23);
        sparseIntArray.append(R.styleable.Constraint_android_layout_height, 21);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintWidth, 95);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHeight, 96);
        sparseIntArray.append(R.styleable.Constraint_android_visibility, 22);
        sparseIntArray.append(R.styleable.Constraint_android_alpha, 43);
        sparseIntArray.append(R.styleable.Constraint_android_elevation, 44);
        sparseIntArray.append(R.styleable.Constraint_android_rotationX, 45);
        sparseIntArray.append(R.styleable.Constraint_android_rotationY, 46);
        sparseIntArray.append(R.styleable.Constraint_android_rotation, 60);
        sparseIntArray.append(R.styleable.Constraint_android_scaleX, 47);
        sparseIntArray.append(R.styleable.Constraint_android_scaleY, 48);
        sparseIntArray.append(R.styleable.Constraint_android_transformPivotX, 49);
        sparseIntArray.append(R.styleable.Constraint_android_transformPivotY, 50);
        sparseIntArray.append(R.styleable.Constraint_android_translationX, 51);
        sparseIntArray.append(R.styleable.Constraint_android_translationY, 52);
        sparseIntArray.append(R.styleable.Constraint_android_translationZ, 53);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintCircle, 61);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        sparseIntArray.append(R.styleable.Constraint_animateRelativeTo, 64);
        sparseIntArray.append(R.styleable.Constraint_transitionEasing, 65);
        sparseIntArray.append(R.styleable.Constraint_drawPath, 66);
        sparseIntArray.append(R.styleable.Constraint_transitionPathRotate, 67);
        sparseIntArray.append(R.styleable.Constraint_motionStagger, 79);
        sparseIntArray.append(R.styleable.Constraint_android_id, 38);
        sparseIntArray.append(R.styleable.Constraint_motionProgress, 68);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        sparseIntArray.append(R.styleable.Constraint_layout_wrapBehaviorInParent, 97);
        sparseIntArray.append(R.styleable.Constraint_chainUseRtl, 71);
        sparseIntArray.append(R.styleable.Constraint_barrierDirection, 72);
        sparseIntArray.append(R.styleable.Constraint_barrierMargin, 73);
        sparseIntArray.append(R.styleable.Constraint_constraint_referenced_ids, 74);
        sparseIntArray.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        sparseIntArray.append(R.styleable.Constraint_pathMotionArc, 76);
        sparseIntArray.append(R.styleable.Constraint_layout_constraintTag, 77);
        sparseIntArray.append(R.styleable.Constraint_visibilityMode, 78);
        sparseIntArray.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        sparseIntArray.append(R.styleable.Constraint_layout_constrainedHeight, 81);
        sparseIntArray.append(R.styleable.Constraint_polarRelativeTo, 82);
        sparseIntArray.append(R.styleable.Constraint_transformPivotTarget, 83);
        sparseIntArray.append(R.styleable.Constraint_quantizeMotionSteps, 84);
        sparseIntArray.append(R.styleable.Constraint_quantizeMotionPhase, 85);
        sparseIntArray.append(R.styleable.Constraint_quantizeMotionInterpolator, 86);
        int i = R.styleable.ConstraintOverride_layout_editor_absoluteY;
        sparseIntArray2.append(i, 6);
        sparseIntArray2.append(i, 7);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_orientation, 27);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_goneMarginTop, 16);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_goneMarginRight, 14);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_goneMarginStart, 15);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_marginLeft, 24);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_marginRight, 28);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_marginStart, 31);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_marginEnd, 8);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_marginTop, 34);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_marginBottom, 2);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_width, 23);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_layout_height, 21);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintWidth, 95);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHeight, 96);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_visibility, 22);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_alpha, 43);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_elevation, 44);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_rotationX, 45);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_rotationY, 46);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_rotation, 60);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_scaleX, 47);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_scaleY, 48);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_transformPivotX, 49);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_transformPivotY, 50);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_translationX, 51);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_translationY, 52);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_translationZ, 53);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        sparseIntArray2.append(R.styleable.ConstraintOverride_animateRelativeTo, 64);
        sparseIntArray2.append(R.styleable.ConstraintOverride_transitionEasing, 65);
        sparseIntArray2.append(R.styleable.ConstraintOverride_drawPath, 66);
        sparseIntArray2.append(R.styleable.ConstraintOverride_transitionPathRotate, 67);
        sparseIntArray2.append(R.styleable.ConstraintOverride_motionStagger, 79);
        sparseIntArray2.append(R.styleable.ConstraintOverride_android_id, 38);
        sparseIntArray2.append(R.styleable.ConstraintOverride_motionTarget, 98);
        sparseIntArray2.append(R.styleable.ConstraintOverride_motionProgress, 68);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        sparseIntArray2.append(R.styleable.ConstraintOverride_chainUseRtl, 71);
        sparseIntArray2.append(R.styleable.ConstraintOverride_barrierDirection, 72);
        sparseIntArray2.append(R.styleable.ConstraintOverride_barrierMargin, 73);
        sparseIntArray2.append(R.styleable.ConstraintOverride_constraint_referenced_ids, 74);
        sparseIntArray2.append(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        sparseIntArray2.append(R.styleable.ConstraintOverride_pathMotionArc, 76);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constraintTag, 77);
        sparseIntArray2.append(R.styleable.ConstraintOverride_visibilityMode, 78);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constrainedWidth, 80);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_constrainedHeight, 81);
        sparseIntArray2.append(R.styleable.ConstraintOverride_polarRelativeTo, 82);
        sparseIntArray2.append(R.styleable.ConstraintOverride_transformPivotTarget, 83);
        sparseIntArray2.append(R.styleable.ConstraintOverride_quantizeMotionSteps, 84);
        sparseIntArray2.append(R.styleable.ConstraintOverride_quantizeMotionPhase, 85);
        sparseIntArray2.append(R.styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        sparseIntArray2.append(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public static Constraint buildDelta(Context context, XmlPullParser xmlPullParser) {
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        Constraint constraint = new Constraint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(asAttributeSet, R.styleable.ConstraintOverride);
        m647j(constraint, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return constraint;
    }

    /* renamed from: c */
    public static int[] m642c(Barrier barrier, String str) {
        int i;
        Object designInformation;
        String[] split = str.split(",");
        Context context = barrier.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            try {
                i = R.id.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i == 0 && barrier.isInEditMode() && (barrier.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) barrier.getParent()).getDesignInformation(0, trim)) != null && (designInformation instanceof Integer)) {
                i = ((Integer) designInformation).intValue();
            }
            iArr[i3] = i;
            i2++;
            i3++;
        }
        if (i3 != split.length) {
            return Arrays.copyOf(iArr, i3);
        }
        return iArr;
    }

    /* renamed from: e */
    public static Constraint m643e(Context context, AttributeSet attributeSet, boolean z) {
        int[] iArr;
        Constraint constraint = new Constraint();
        if (z) {
            iArr = R.styleable.ConstraintOverride;
        } else {
            iArr = R.styleable.Constraint;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (z) {
            m647j(constraint, obtainStyledAttributes);
        } else {
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index != R.styleable.Constraint_android_id && R.styleable.Constraint_android_layout_marginStart != index && R.styleable.Constraint_android_layout_marginEnd != index) {
                    constraint.motion.mApply = true;
                    constraint.layout.mApply = true;
                    constraint.propertySet.mApply = true;
                    constraint.transform.mApply = true;
                }
                SparseIntArray sparseIntArray = f3184g;
                switch (sparseIntArray.get(index)) {
                    case 1:
                        Layout layout = constraint.layout;
                        layout.baselineToBaseline = m644g(obtainStyledAttributes, index, layout.baselineToBaseline);
                        break;
                    case 2:
                        Layout layout2 = constraint.layout;
                        layout2.bottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout2.bottomMargin);
                        break;
                    case 3:
                        Layout layout3 = constraint.layout;
                        layout3.bottomToBottom = m644g(obtainStyledAttributes, index, layout3.bottomToBottom);
                        break;
                    case 4:
                        Layout layout4 = constraint.layout;
                        layout4.bottomToTop = m644g(obtainStyledAttributes, index, layout4.bottomToTop);
                        break;
                    case 5:
                        constraint.layout.dimensionRatio = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        Layout layout5 = constraint.layout;
                        layout5.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, layout5.editorAbsoluteX);
                        break;
                    case 7:
                        Layout layout6 = constraint.layout;
                        layout6.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, layout6.editorAbsoluteY);
                        break;
                    case 8:
                        Layout layout7 = constraint.layout;
                        layout7.endMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout7.endMargin);
                        break;
                    case 9:
                        Layout layout8 = constraint.layout;
                        layout8.endToEnd = m644g(obtainStyledAttributes, index, layout8.endToEnd);
                        break;
                    case 10:
                        Layout layout9 = constraint.layout;
                        layout9.endToStart = m644g(obtainStyledAttributes, index, layout9.endToStart);
                        break;
                    case 11:
                        Layout layout10 = constraint.layout;
                        layout10.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout10.goneBottomMargin);
                        break;
                    case 12:
                        Layout layout11 = constraint.layout;
                        layout11.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout11.goneEndMargin);
                        break;
                    case 13:
                        Layout layout12 = constraint.layout;
                        layout12.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout12.goneLeftMargin);
                        break;
                    case 14:
                        Layout layout13 = constraint.layout;
                        layout13.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout13.goneRightMargin);
                        break;
                    case 15:
                        Layout layout14 = constraint.layout;
                        layout14.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout14.goneStartMargin);
                        break;
                    case 16:
                        Layout layout15 = constraint.layout;
                        layout15.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout15.goneTopMargin);
                        break;
                    case 17:
                        Layout layout16 = constraint.layout;
                        layout16.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, layout16.guideBegin);
                        break;
                    case 18:
                        Layout layout17 = constraint.layout;
                        layout17.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, layout17.guideEnd);
                        break;
                    case 19:
                        Layout layout18 = constraint.layout;
                        layout18.guidePercent = obtainStyledAttributes.getFloat(index, layout18.guidePercent);
                        break;
                    case 20:
                        Layout layout19 = constraint.layout;
                        layout19.horizontalBias = obtainStyledAttributes.getFloat(index, layout19.horizontalBias);
                        break;
                    case 21:
                        Layout layout20 = constraint.layout;
                        layout20.mHeight = obtainStyledAttributes.getLayoutDimension(index, layout20.mHeight);
                        break;
                    case 22:
                        PropertySet propertySet = constraint.propertySet;
                        propertySet.visibility = obtainStyledAttributes.getInt(index, propertySet.visibility);
                        PropertySet propertySet2 = constraint.propertySet;
                        propertySet2.visibility = f3183f[propertySet2.visibility];
                        break;
                    case 23:
                        Layout layout21 = constraint.layout;
                        layout21.mWidth = obtainStyledAttributes.getLayoutDimension(index, layout21.mWidth);
                        break;
                    case 24:
                        Layout layout22 = constraint.layout;
                        layout22.leftMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout22.leftMargin);
                        break;
                    case 25:
                        Layout layout23 = constraint.layout;
                        layout23.leftToLeft = m644g(obtainStyledAttributes, index, layout23.leftToLeft);
                        break;
                    case 26:
                        Layout layout24 = constraint.layout;
                        layout24.leftToRight = m644g(obtainStyledAttributes, index, layout24.leftToRight);
                        break;
                    case 27:
                        Layout layout25 = constraint.layout;
                        layout25.orientation = obtainStyledAttributes.getInt(index, layout25.orientation);
                        break;
                    case 28:
                        Layout layout26 = constraint.layout;
                        layout26.rightMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout26.rightMargin);
                        break;
                    case 29:
                        Layout layout27 = constraint.layout;
                        layout27.rightToLeft = m644g(obtainStyledAttributes, index, layout27.rightToLeft);
                        break;
                    case 30:
                        Layout layout28 = constraint.layout;
                        layout28.rightToRight = m644g(obtainStyledAttributes, index, layout28.rightToRight);
                        break;
                    case 31:
                        Layout layout29 = constraint.layout;
                        layout29.startMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout29.startMargin);
                        break;
                    case 32:
                        Layout layout30 = constraint.layout;
                        layout30.startToEnd = m644g(obtainStyledAttributes, index, layout30.startToEnd);
                        break;
                    case 33:
                        Layout layout31 = constraint.layout;
                        layout31.startToStart = m644g(obtainStyledAttributes, index, layout31.startToStart);
                        break;
                    case 34:
                        Layout layout32 = constraint.layout;
                        layout32.topMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout32.topMargin);
                        break;
                    case 35:
                        Layout layout33 = constraint.layout;
                        layout33.topToBottom = m644g(obtainStyledAttributes, index, layout33.topToBottom);
                        break;
                    case 36:
                        Layout layout34 = constraint.layout;
                        layout34.topToTop = m644g(obtainStyledAttributes, index, layout34.topToTop);
                        break;
                    case 37:
                        Layout layout35 = constraint.layout;
                        layout35.verticalBias = obtainStyledAttributes.getFloat(index, layout35.verticalBias);
                        break;
                    case 38:
                        constraint.f3191a = obtainStyledAttributes.getResourceId(index, constraint.f3191a);
                        break;
                    case 39:
                        Layout layout36 = constraint.layout;
                        layout36.horizontalWeight = obtainStyledAttributes.getFloat(index, layout36.horizontalWeight);
                        break;
                    case 40:
                        Layout layout37 = constraint.layout;
                        layout37.verticalWeight = obtainStyledAttributes.getFloat(index, layout37.verticalWeight);
                        break;
                    case 41:
                        Layout layout38 = constraint.layout;
                        layout38.horizontalChainStyle = obtainStyledAttributes.getInt(index, layout38.horizontalChainStyle);
                        break;
                    case 42:
                        Layout layout39 = constraint.layout;
                        layout39.verticalChainStyle = obtainStyledAttributes.getInt(index, layout39.verticalChainStyle);
                        break;
                    case 43:
                        PropertySet propertySet3 = constraint.propertySet;
                        propertySet3.alpha = obtainStyledAttributes.getFloat(index, propertySet3.alpha);
                        break;
                    case 44:
                        Transform transform = constraint.transform;
                        transform.applyElevation = true;
                        transform.elevation = obtainStyledAttributes.getDimension(index, transform.elevation);
                        break;
                    case 45:
                        Transform transform2 = constraint.transform;
                        transform2.rotationX = obtainStyledAttributes.getFloat(index, transform2.rotationX);
                        break;
                    case 46:
                        Transform transform3 = constraint.transform;
                        transform3.rotationY = obtainStyledAttributes.getFloat(index, transform3.rotationY);
                        break;
                    case 47:
                        Transform transform4 = constraint.transform;
                        transform4.scaleX = obtainStyledAttributes.getFloat(index, transform4.scaleX);
                        break;
                    case 48:
                        Transform transform5 = constraint.transform;
                        transform5.scaleY = obtainStyledAttributes.getFloat(index, transform5.scaleY);
                        break;
                    case 49:
                        Transform transform6 = constraint.transform;
                        transform6.transformPivotX = obtainStyledAttributes.getDimension(index, transform6.transformPivotX);
                        break;
                    case 50:
                        Transform transform7 = constraint.transform;
                        transform7.transformPivotY = obtainStyledAttributes.getDimension(index, transform7.transformPivotY);
                        break;
                    case 51:
                        Transform transform8 = constraint.transform;
                        transform8.translationX = obtainStyledAttributes.getDimension(index, transform8.translationX);
                        break;
                    case 52:
                        Transform transform9 = constraint.transform;
                        transform9.translationY = obtainStyledAttributes.getDimension(index, transform9.translationY);
                        break;
                    case 53:
                        Transform transform10 = constraint.transform;
                        transform10.translationZ = obtainStyledAttributes.getDimension(index, transform10.translationZ);
                        break;
                    case 54:
                        Layout layout40 = constraint.layout;
                        layout40.widthDefault = obtainStyledAttributes.getInt(index, layout40.widthDefault);
                        break;
                    case 55:
                        Layout layout41 = constraint.layout;
                        layout41.heightDefault = obtainStyledAttributes.getInt(index, layout41.heightDefault);
                        break;
                    case 56:
                        Layout layout42 = constraint.layout;
                        layout42.widthMax = obtainStyledAttributes.getDimensionPixelSize(index, layout42.widthMax);
                        break;
                    case 57:
                        Layout layout43 = constraint.layout;
                        layout43.heightMax = obtainStyledAttributes.getDimensionPixelSize(index, layout43.heightMax);
                        break;
                    case 58:
                        Layout layout44 = constraint.layout;
                        layout44.widthMin = obtainStyledAttributes.getDimensionPixelSize(index, layout44.widthMin);
                        break;
                    case 59:
                        Layout layout45 = constraint.layout;
                        layout45.heightMin = obtainStyledAttributes.getDimensionPixelSize(index, layout45.heightMin);
                        break;
                    case 60:
                        Transform transform11 = constraint.transform;
                        transform11.rotation = obtainStyledAttributes.getFloat(index, transform11.rotation);
                        break;
                    case 61:
                        Layout layout46 = constraint.layout;
                        layout46.circleConstraint = m644g(obtainStyledAttributes, index, layout46.circleConstraint);
                        break;
                    case 62:
                        Layout layout47 = constraint.layout;
                        layout47.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, layout47.circleRadius);
                        break;
                    case 63:
                        Layout layout48 = constraint.layout;
                        layout48.circleAngle = obtainStyledAttributes.getFloat(index, layout48.circleAngle);
                        break;
                    case 64:
                        Motion motion = constraint.motion;
                        motion.mAnimateRelativeTo = m644g(obtainStyledAttributes, index, motion.mAnimateRelativeTo);
                        break;
                    case 65:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            constraint.motion.mTransitionEasing = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            constraint.motion.mTransitionEasing = Easing.NAMED_EASING[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 66:
                        constraint.motion.mDrawPath = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 67:
                        Motion motion2 = constraint.motion;
                        motion2.mPathRotate = obtainStyledAttributes.getFloat(index, motion2.mPathRotate);
                        break;
                    case 68:
                        PropertySet propertySet4 = constraint.propertySet;
                        propertySet4.mProgress = obtainStyledAttributes.getFloat(index, propertySet4.mProgress);
                        break;
                    case 69:
                        constraint.layout.widthPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                        break;
                    case 70:
                        constraint.layout.heightPercent = obtainStyledAttributes.getFloat(index, 1.0f);
                        break;
                    case 71:
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        Layout layout49 = constraint.layout;
                        layout49.mBarrierDirection = obtainStyledAttributes.getInt(index, layout49.mBarrierDirection);
                        break;
                    case 73:
                        Layout layout50 = constraint.layout;
                        layout50.mBarrierMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout50.mBarrierMargin);
                        break;
                    case 74:
                        constraint.layout.mReferenceIdString = obtainStyledAttributes.getString(index);
                        break;
                    case 75:
                        Layout layout51 = constraint.layout;
                        layout51.mBarrierAllowsGoneWidgets = obtainStyledAttributes.getBoolean(index, layout51.mBarrierAllowsGoneWidgets);
                        break;
                    case 76:
                        Motion motion3 = constraint.motion;
                        motion3.mPathMotionArc = obtainStyledAttributes.getInt(index, motion3.mPathMotionArc);
                        break;
                    case 77:
                        constraint.layout.mConstraintTag = obtainStyledAttributes.getString(index);
                        break;
                    case 78:
                        PropertySet propertySet5 = constraint.propertySet;
                        propertySet5.mVisibilityMode = obtainStyledAttributes.getInt(index, propertySet5.mVisibilityMode);
                        break;
                    case 79:
                        Motion motion4 = constraint.motion;
                        motion4.mMotionStagger = obtainStyledAttributes.getFloat(index, motion4.mMotionStagger);
                        break;
                    case 80:
                        Layout layout52 = constraint.layout;
                        layout52.constrainedWidth = obtainStyledAttributes.getBoolean(index, layout52.constrainedWidth);
                        break;
                    case 81:
                        Layout layout53 = constraint.layout;
                        layout53.constrainedHeight = obtainStyledAttributes.getBoolean(index, layout53.constrainedHeight);
                        break;
                    case 82:
                        Motion motion5 = constraint.motion;
                        motion5.mAnimateCircleAngleTo = obtainStyledAttributes.getInteger(index, motion5.mAnimateCircleAngleTo);
                        break;
                    case 83:
                        Transform transform12 = constraint.transform;
                        transform12.transformPivotTarget = m644g(obtainStyledAttributes, index, transform12.transformPivotTarget);
                        break;
                    case 84:
                        Motion motion6 = constraint.motion;
                        motion6.mQuantizeMotionSteps = obtainStyledAttributes.getInteger(index, motion6.mQuantizeMotionSteps);
                        break;
                    case 85:
                        Motion motion7 = constraint.motion;
                        motion7.mQuantizeMotionPhase = obtainStyledAttributes.getFloat(index, motion7.mQuantizeMotionPhase);
                        break;
                    case 86:
                        int i2 = obtainStyledAttributes.peekValue(index).type;
                        if (i2 == 1) {
                            constraint.motion.mQuantizeInterpolatorID = obtainStyledAttributes.getResourceId(index, -1);
                            Motion motion8 = constraint.motion;
                            if (motion8.mQuantizeInterpolatorID != -1) {
                                motion8.mQuantizeInterpolatorType = -2;
                                break;
                            } else {
                                break;
                            }
                        } else if (i2 == 3) {
                            constraint.motion.mQuantizeInterpolatorString = obtainStyledAttributes.getString(index);
                            if (constraint.motion.mQuantizeInterpolatorString.indexOf("/") > 0) {
                                constraint.motion.mQuantizeInterpolatorID = obtainStyledAttributes.getResourceId(index, -1);
                                constraint.motion.mQuantizeInterpolatorType = -2;
                                break;
                            } else {
                                constraint.motion.mQuantizeInterpolatorType = -1;
                                break;
                            }
                        } else {
                            Motion motion9 = constraint.motion;
                            motion9.mQuantizeInterpolatorType = obtainStyledAttributes.getInteger(index, motion9.mQuantizeInterpolatorID);
                            break;
                        }
                    case 87:
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                        break;
                    case 88:
                    case 89:
                    case 90:
                    default:
                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                        break;
                    case 91:
                        Layout layout54 = constraint.layout;
                        layout54.baselineToTop = m644g(obtainStyledAttributes, index, layout54.baselineToTop);
                        break;
                    case 92:
                        Layout layout55 = constraint.layout;
                        layout55.baselineToBottom = m644g(obtainStyledAttributes, index, layout55.baselineToBottom);
                        break;
                    case 93:
                        Layout layout56 = constraint.layout;
                        layout56.baselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout56.baselineMargin);
                        break;
                    case 94:
                        Layout layout57 = constraint.layout;
                        layout57.goneBaselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, layout57.goneBaselineMargin);
                        break;
                    case 95:
                        m645h(constraint.layout, obtainStyledAttributes, index, 0);
                        break;
                    case 96:
                        m645h(constraint.layout, obtainStyledAttributes, index, 1);
                        break;
                    case 97:
                        Layout layout58 = constraint.layout;
                        layout58.mWrapBehavior = obtainStyledAttributes.getInt(index, layout58.mWrapBehavior);
                        break;
                }
            }
            Layout layout59 = constraint.layout;
            if (layout59.mReferenceIdString != null) {
                layout59.mReferenceIds = null;
            }
        }
        obtainStyledAttributes.recycle();
        return constraint;
    }

    /* renamed from: g */
    public static int m644g(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        if (resourceId == -1) {
            return typedArray.getInt(i, -1);
        }
        return resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m645h(Object obj, TypedArray typedArray, int i, int i2) {
        int dimensionPixelSize;
        if (obj == null) {
            return;
        }
        int i3 = typedArray.peekValue(i).type;
        boolean z = true;
        int i4 = 0;
        if (i3 != 3) {
            if (i3 != 5) {
                dimensionPixelSize = typedArray.getInt(i, 0);
                if (dimensionPixelSize != -4) {
                    if (dimensionPixelSize == -3 || (dimensionPixelSize != -2 && dimensionPixelSize != -1)) {
                        z = false;
                    }
                } else {
                    i4 = -2;
                }
                if (!(obj instanceof ConstraintLayout.LayoutParams)) {
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) obj;
                    if (i2 == 0) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = i4;
                        layoutParams.constrainedWidth = z;
                        return;
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams).height = i4;
                        layoutParams.constrainedHeight = z;
                        return;
                    }
                }
                if (obj instanceof Layout) {
                    Layout layout = (Layout) obj;
                    if (i2 == 0) {
                        layout.mWidth = i4;
                        layout.constrainedWidth = z;
                        return;
                    } else {
                        layout.mHeight = i4;
                        layout.constrainedHeight = z;
                        return;
                    }
                }
                if (obj instanceof C0133e) {
                    C0133e c0133e = (C0133e) obj;
                    if (i2 == 0) {
                        c0133e.m666b(23, i4);
                        c0133e.m668d(80, z);
                        return;
                    } else {
                        c0133e.m666b(21, i4);
                        c0133e.m668d(81, z);
                        return;
                    }
                }
                return;
            }
            dimensionPixelSize = typedArray.getDimensionPixelSize(i, 0);
            z = false;
            i4 = dimensionPixelSize;
            if (!(obj instanceof ConstraintLayout.LayoutParams)) {
            }
        } else {
            String string = typedArray.getString(i);
            if (string != null) {
                int indexOf = string.indexOf(61);
                int length = string.length();
                if (indexOf > 0 && indexOf < length - 1) {
                    String substring = string.substring(0, indexOf);
                    String substring2 = string.substring(indexOf + 1);
                    if (substring2.length() > 0) {
                        String trim = substring.trim();
                        String trim2 = substring2.trim();
                        if ("ratio".equalsIgnoreCase(trim)) {
                            if (obj instanceof ConstraintLayout.LayoutParams) {
                                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) obj;
                                if (i2 == 0) {
                                    ((ViewGroup.MarginLayoutParams) layoutParams2).width = 0;
                                } else {
                                    ((ViewGroup.MarginLayoutParams) layoutParams2).height = 0;
                                }
                                m646i(layoutParams2, trim2);
                                return;
                            }
                            if (obj instanceof Layout) {
                                ((Layout) obj).dimensionRatio = trim2;
                                return;
                            } else {
                                if (obj instanceof C0133e) {
                                    ((C0133e) obj).m667c(5, trim2);
                                    return;
                                }
                                return;
                            }
                        }
                        try {
                            if ("weight".equalsIgnoreCase(trim)) {
                                float parseFloat = Float.parseFloat(trim2);
                                if (obj instanceof ConstraintLayout.LayoutParams) {
                                    ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) obj;
                                    if (i2 == 0) {
                                        ((ViewGroup.MarginLayoutParams) layoutParams3).width = 0;
                                        layoutParams3.horizontalWeight = parseFloat;
                                    } else {
                                        ((ViewGroup.MarginLayoutParams) layoutParams3).height = 0;
                                        layoutParams3.verticalWeight = parseFloat;
                                    }
                                } else if (obj instanceof Layout) {
                                    Layout layout2 = (Layout) obj;
                                    if (i2 == 0) {
                                        layout2.mWidth = 0;
                                        layout2.horizontalWeight = parseFloat;
                                    } else {
                                        layout2.mHeight = 0;
                                        layout2.verticalWeight = parseFloat;
                                    }
                                } else if (obj instanceof C0133e) {
                                    C0133e c0133e2 = (C0133e) obj;
                                    if (i2 == 0) {
                                        c0133e2.m666b(23, 0);
                                        c0133e2.m665a(39, parseFloat);
                                    } else {
                                        c0133e2.m666b(21, 0);
                                        c0133e2.m665a(40, parseFloat);
                                    }
                                }
                            } else if ("parent".equalsIgnoreCase(trim)) {
                                float max = Math.max(RecyclerView.f7068F0, Math.min(1.0f, Float.parseFloat(trim2)));
                                if (obj instanceof ConstraintLayout.LayoutParams) {
                                    ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) obj;
                                    if (i2 == 0) {
                                        ((ViewGroup.MarginLayoutParams) layoutParams4).width = 0;
                                        layoutParams4.matchConstraintPercentWidth = max;
                                        layoutParams4.matchConstraintDefaultWidth = 2;
                                    } else {
                                        ((ViewGroup.MarginLayoutParams) layoutParams4).height = 0;
                                        layoutParams4.matchConstraintPercentHeight = max;
                                        layoutParams4.matchConstraintDefaultHeight = 2;
                                    }
                                } else if (obj instanceof Layout) {
                                    Layout layout3 = (Layout) obj;
                                    if (i2 == 0) {
                                        layout3.mWidth = 0;
                                        layout3.widthPercent = max;
                                        layout3.widthDefault = 2;
                                    } else {
                                        layout3.mHeight = 0;
                                        layout3.heightPercent = max;
                                        layout3.heightDefault = 2;
                                    }
                                } else if (obj instanceof C0133e) {
                                    C0133e c0133e3 = (C0133e) obj;
                                    if (i2 == 0) {
                                        c0133e3.m666b(23, 0);
                                        c0133e3.m666b(54, 2);
                                    } else {
                                        c0133e3.m666b(21, 0);
                                        c0133e3.m666b(55, 2);
                                    }
                                }
                            }
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
            }
        }
    }

    /* renamed from: i */
    public static void m646i(ConstraintLayout.LayoutParams layoutParams, String str) {
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            char c = 65535;
            int i = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (substring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                    c = 0;
                } else if (substring.equalsIgnoreCase("H")) {
                    c = 1;
                }
                i = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            try {
                if (indexOf2 >= 0 && indexOf2 < length - 1) {
                    String substring2 = str.substring(i, indexOf2);
                    String substring3 = str.substring(indexOf2 + 1);
                    if (substring2.length() > 0 && substring3.length() > 0) {
                        float parseFloat = Float.parseFloat(substring2);
                        float parseFloat2 = Float.parseFloat(substring3);
                        if (parseFloat > RecyclerView.f7068F0 && parseFloat2 > RecyclerView.f7068F0) {
                            if (c == 1) {
                                Math.abs(parseFloat2 / parseFloat);
                            } else {
                                Math.abs(parseFloat / parseFloat2);
                            }
                        }
                    }
                } else {
                    String substring4 = str.substring(i);
                    if (substring4.length() > 0) {
                        Float.parseFloat(substring4);
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        layoutParams.dimensionRatio = str;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.constraintlayout.widget.e, java.lang.Object] */
    /* renamed from: j */
    public static void m647j(Constraint constraint, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        ?? obj = new Object();
        obj.f3233a = new int[10];
        obj.f3234b = new int[10];
        obj.f3235c = 0;
        obj.f3236d = new int[10];
        obj.f3237e = new float[10];
        obj.f3238f = 0;
        obj.f3239g = new int[5];
        obj.f3240h = new String[5];
        obj.f3241i = 0;
        obj.f3242j = new int[4];
        obj.f3243k = new boolean[4];
        obj.f3244l = 0;
        constraint.f3193c = obj;
        constraint.motion.mApply = false;
        constraint.layout.mApply = false;
        constraint.propertySet.mApply = false;
        constraint.transform.mApply = false;
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            int i2 = f3185h.get(index);
            SparseIntArray sparseIntArray = f3184g;
            switch (i2) {
                case 2:
                    obj.m666b(2, typedArray.getDimensionPixelSize(index, constraint.layout.bottomMargin));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                    break;
                case 5:
                    obj.m667c(5, typedArray.getString(index));
                    break;
                case 6:
                    obj.m666b(6, typedArray.getDimensionPixelOffset(index, constraint.layout.editorAbsoluteX));
                    break;
                case 7:
                    obj.m666b(7, typedArray.getDimensionPixelOffset(index, constraint.layout.editorAbsoluteY));
                    break;
                case 8:
                    obj.m666b(8, typedArray.getDimensionPixelSize(index, constraint.layout.endMargin));
                    break;
                case 11:
                    obj.m666b(11, typedArray.getDimensionPixelSize(index, constraint.layout.goneBottomMargin));
                    break;
                case 12:
                    obj.m666b(12, typedArray.getDimensionPixelSize(index, constraint.layout.goneEndMargin));
                    break;
                case 13:
                    obj.m666b(13, typedArray.getDimensionPixelSize(index, constraint.layout.goneLeftMargin));
                    break;
                case 14:
                    obj.m666b(14, typedArray.getDimensionPixelSize(index, constraint.layout.goneRightMargin));
                    break;
                case 15:
                    obj.m666b(15, typedArray.getDimensionPixelSize(index, constraint.layout.goneStartMargin));
                    break;
                case 16:
                    obj.m666b(16, typedArray.getDimensionPixelSize(index, constraint.layout.goneTopMargin));
                    break;
                case 17:
                    obj.m666b(17, typedArray.getDimensionPixelOffset(index, constraint.layout.guideBegin));
                    break;
                case 18:
                    obj.m666b(18, typedArray.getDimensionPixelOffset(index, constraint.layout.guideEnd));
                    break;
                case 19:
                    obj.m665a(19, typedArray.getFloat(index, constraint.layout.guidePercent));
                    break;
                case 20:
                    obj.m665a(20, typedArray.getFloat(index, constraint.layout.horizontalBias));
                    break;
                case 21:
                    obj.m666b(21, typedArray.getLayoutDimension(index, constraint.layout.mHeight));
                    break;
                case 22:
                    obj.m666b(22, f3183f[typedArray.getInt(index, constraint.propertySet.visibility)]);
                    break;
                case 23:
                    obj.m666b(23, typedArray.getLayoutDimension(index, constraint.layout.mWidth));
                    break;
                case 24:
                    obj.m666b(24, typedArray.getDimensionPixelSize(index, constraint.layout.leftMargin));
                    break;
                case 27:
                    obj.m666b(27, typedArray.getInt(index, constraint.layout.orientation));
                    break;
                case 28:
                    obj.m666b(28, typedArray.getDimensionPixelSize(index, constraint.layout.rightMargin));
                    break;
                case 31:
                    obj.m666b(31, typedArray.getDimensionPixelSize(index, constraint.layout.startMargin));
                    break;
                case 34:
                    obj.m666b(34, typedArray.getDimensionPixelSize(index, constraint.layout.topMargin));
                    break;
                case 37:
                    obj.m665a(37, typedArray.getFloat(index, constraint.layout.verticalBias));
                    break;
                case 38:
                    int resourceId = typedArray.getResourceId(index, constraint.f3191a);
                    constraint.f3191a = resourceId;
                    obj.m666b(38, resourceId);
                    break;
                case 39:
                    obj.m665a(39, typedArray.getFloat(index, constraint.layout.horizontalWeight));
                    break;
                case 40:
                    obj.m665a(40, typedArray.getFloat(index, constraint.layout.verticalWeight));
                    break;
                case 41:
                    obj.m666b(41, typedArray.getInt(index, constraint.layout.horizontalChainStyle));
                    break;
                case 42:
                    obj.m666b(42, typedArray.getInt(index, constraint.layout.verticalChainStyle));
                    break;
                case 43:
                    obj.m665a(43, typedArray.getFloat(index, constraint.propertySet.alpha));
                    break;
                case 44:
                    obj.m668d(44, true);
                    obj.m665a(44, typedArray.getDimension(index, constraint.transform.elevation));
                    break;
                case 45:
                    obj.m665a(45, typedArray.getFloat(index, constraint.transform.rotationX));
                    break;
                case 46:
                    obj.m665a(46, typedArray.getFloat(index, constraint.transform.rotationY));
                    break;
                case 47:
                    obj.m665a(47, typedArray.getFloat(index, constraint.transform.scaleX));
                    break;
                case 48:
                    obj.m665a(48, typedArray.getFloat(index, constraint.transform.scaleY));
                    break;
                case 49:
                    obj.m665a(49, typedArray.getDimension(index, constraint.transform.transformPivotX));
                    break;
                case 50:
                    obj.m665a(50, typedArray.getDimension(index, constraint.transform.transformPivotY));
                    break;
                case 51:
                    obj.m665a(51, typedArray.getDimension(index, constraint.transform.translationX));
                    break;
                case 52:
                    obj.m665a(52, typedArray.getDimension(index, constraint.transform.translationY));
                    break;
                case 53:
                    obj.m665a(53, typedArray.getDimension(index, constraint.transform.translationZ));
                    break;
                case 54:
                    obj.m666b(54, typedArray.getInt(index, constraint.layout.widthDefault));
                    break;
                case 55:
                    obj.m666b(55, typedArray.getInt(index, constraint.layout.heightDefault));
                    break;
                case 56:
                    obj.m666b(56, typedArray.getDimensionPixelSize(index, constraint.layout.widthMax));
                    break;
                case 57:
                    obj.m666b(57, typedArray.getDimensionPixelSize(index, constraint.layout.heightMax));
                    break;
                case 58:
                    obj.m666b(58, typedArray.getDimensionPixelSize(index, constraint.layout.widthMin));
                    break;
                case 59:
                    obj.m666b(59, typedArray.getDimensionPixelSize(index, constraint.layout.heightMin));
                    break;
                case 60:
                    obj.m665a(60, typedArray.getFloat(index, constraint.transform.rotation));
                    break;
                case 62:
                    obj.m666b(62, typedArray.getDimensionPixelSize(index, constraint.layout.circleRadius));
                    break;
                case 63:
                    obj.m665a(63, typedArray.getFloat(index, constraint.layout.circleAngle));
                    break;
                case 64:
                    obj.m666b(64, m644g(typedArray, index, constraint.motion.mAnimateRelativeTo));
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        obj.m667c(65, typedArray.getString(index));
                        break;
                    } else {
                        obj.m667c(65, Easing.NAMED_EASING[typedArray.getInteger(index, 0)]);
                        break;
                    }
                case 66:
                    obj.m666b(66, typedArray.getInt(index, 0));
                    break;
                case 67:
                    obj.m665a(67, typedArray.getFloat(index, constraint.motion.mPathRotate));
                    break;
                case 68:
                    obj.m665a(68, typedArray.getFloat(index, constraint.propertySet.mProgress));
                    break;
                case 69:
                    obj.m665a(69, typedArray.getFloat(index, 1.0f));
                    break;
                case 70:
                    obj.m665a(70, typedArray.getFloat(index, 1.0f));
                    break;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    obj.m666b(72, typedArray.getInt(index, constraint.layout.mBarrierDirection));
                    break;
                case 73:
                    obj.m666b(73, typedArray.getDimensionPixelSize(index, constraint.layout.mBarrierMargin));
                    break;
                case 74:
                    obj.m667c(74, typedArray.getString(index));
                    break;
                case 75:
                    obj.m668d(75, typedArray.getBoolean(index, constraint.layout.mBarrierAllowsGoneWidgets));
                    break;
                case 76:
                    obj.m666b(76, typedArray.getInt(index, constraint.motion.mPathMotionArc));
                    break;
                case 77:
                    obj.m667c(77, typedArray.getString(index));
                    break;
                case 78:
                    obj.m666b(78, typedArray.getInt(index, constraint.propertySet.mVisibilityMode));
                    break;
                case 79:
                    obj.m665a(79, typedArray.getFloat(index, constraint.motion.mMotionStagger));
                    break;
                case 80:
                    obj.m668d(80, typedArray.getBoolean(index, constraint.layout.constrainedWidth));
                    break;
                case 81:
                    obj.m668d(81, typedArray.getBoolean(index, constraint.layout.constrainedHeight));
                    break;
                case 82:
                    obj.m666b(82, typedArray.getInteger(index, constraint.motion.mAnimateCircleAngleTo));
                    break;
                case 83:
                    obj.m666b(83, m644g(typedArray, index, constraint.transform.transformPivotTarget));
                    break;
                case 84:
                    obj.m666b(84, typedArray.getInteger(index, constraint.motion.mQuantizeMotionSteps));
                    break;
                case 85:
                    obj.m665a(85, typedArray.getFloat(index, constraint.motion.mQuantizeMotionPhase));
                    break;
                case 86:
                    int i3 = typedArray.peekValue(index).type;
                    if (i3 == 1) {
                        constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                        obj.m666b(89, constraint.motion.mQuantizeInterpolatorID);
                        Motion motion = constraint.motion;
                        if (motion.mQuantizeInterpolatorID != -1) {
                            motion.mQuantizeInterpolatorType = -2;
                            obj.m666b(88, -2);
                            break;
                        } else {
                            break;
                        }
                    } else if (i3 == 3) {
                        constraint.motion.mQuantizeInterpolatorString = typedArray.getString(index);
                        obj.m667c(90, constraint.motion.mQuantizeInterpolatorString);
                        if (constraint.motion.mQuantizeInterpolatorString.indexOf("/") > 0) {
                            constraint.motion.mQuantizeInterpolatorID = typedArray.getResourceId(index, -1);
                            obj.m666b(89, constraint.motion.mQuantizeInterpolatorID);
                            constraint.motion.mQuantizeInterpolatorType = -2;
                            obj.m666b(88, -2);
                            break;
                        } else {
                            constraint.motion.mQuantizeInterpolatorType = -1;
                            obj.m666b(88, -1);
                            break;
                        }
                    } else {
                        Motion motion2 = constraint.motion;
                        motion2.mQuantizeInterpolatorType = typedArray.getInteger(index, motion2.mQuantizeInterpolatorID);
                        obj.m666b(88, constraint.motion.mQuantizeInterpolatorType);
                        break;
                    }
                case 87:
                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                    break;
                case 93:
                    obj.m666b(93, typedArray.getDimensionPixelSize(index, constraint.layout.baselineMargin));
                    break;
                case 94:
                    obj.m666b(94, typedArray.getDimensionPixelSize(index, constraint.layout.goneBaselineMargin));
                    break;
                case 95:
                    m645h(obj, typedArray, index, 0);
                    break;
                case 96:
                    m645h(obj, typedArray, index, 1);
                    break;
                case 97:
                    obj.m666b(97, typedArray.getInt(index, constraint.layout.mWrapBehavior));
                    break;
                case 98:
                    if (MotionLayout.IS_IN_EDIT_MODE) {
                        int resourceId2 = typedArray.getResourceId(index, constraint.f3191a);
                        constraint.f3191a = resourceId2;
                        if (resourceId2 == -1) {
                            constraint.f3192b = typedArray.getString(index);
                            break;
                        } else {
                            break;
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        constraint.f3192b = typedArray.getString(index);
                        break;
                    } else {
                        constraint.f3191a = typedArray.getResourceId(index, constraint.f3191a);
                        break;
                    }
                case 99:
                    obj.m668d(99, typedArray.getBoolean(index, constraint.layout.guidelineUseRtl));
                    break;
            }
        }
    }

    /* renamed from: k */
    public static String m648k(int i) {
        switch (i) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    /* renamed from: a */
    public final void m649a(ConstraintAttribute.AttributeType attributeType, String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            HashMap hashMap = this.f3188c;
            if (hashMap.containsKey(strArr[i])) {
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) hashMap.get(strArr[i]);
                if (constraintAttribute != null && constraintAttribute.getType() != attributeType) {
                    throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute.getType().name());
                }
            } else {
                hashMap.put(strArr[i], new ConstraintAttribute(strArr[i], attributeType));
            }
        }
    }

    public void addColorAttributes(String... strArr) {
        m649a(ConstraintAttribute.AttributeType.COLOR_TYPE, strArr);
    }

    public void addFloatAttributes(String... strArr) {
        m649a(ConstraintAttribute.AttributeType.FLOAT_TYPE, strArr);
    }

    public void addIntAttributes(String... strArr) {
        m649a(ConstraintAttribute.AttributeType.INT_TYPE, strArr);
    }

    public void addStringAttributes(String... strArr) {
        m649a(ConstraintAttribute.AttributeType.STRING_TYPE, strArr);
    }

    public void addToHorizontalChain(int i, int i2, int i3) {
        int i4;
        int i5;
        if (i2 == 0) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        connect(i, 1, i2, i4, 0);
        if (i3 == 0) {
            i5 = 2;
        } else {
            i5 = 1;
        }
        connect(i, 2, i3, i5, 0);
        if (i2 != 0) {
            connect(i2, 2, i, 1, 0);
        }
        if (i3 != 0) {
            connect(i3, 1, i, 2, 0);
        }
    }

    public void addToHorizontalChainRTL(int i, int i2, int i3) {
        int i4;
        int i5;
        if (i2 == 0) {
            i4 = 6;
        } else {
            i4 = 7;
        }
        connect(i, 6, i2, i4, 0);
        if (i3 == 0) {
            i5 = 7;
        } else {
            i5 = 6;
        }
        connect(i, 7, i3, i5, 0);
        if (i2 != 0) {
            connect(i2, 7, i, 6, 0);
        }
        if (i3 != 0) {
            connect(i3, 6, i, 7, 0);
        }
    }

    public void addToVerticalChain(int i, int i2, int i3) {
        int i4;
        int i5;
        if (i2 == 0) {
            i4 = 3;
        } else {
            i4 = 4;
        }
        connect(i, 3, i2, i4, 0);
        if (i3 == 0) {
            i5 = 4;
        } else {
            i5 = 3;
        }
        connect(i, 4, i3, i5, 0);
        if (i2 != 0) {
            connect(i2, 4, i, 3, 0);
        }
        if (i3 != 0) {
            connect(i3, 3, i, 4, 0);
        }
    }

    public void applyCustomAttributes(ConstraintLayout constraintLayout) {
        Constraint constraint;
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            HashMap hashMap = this.f3190e;
            if (!hashMap.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + Debug.getName(childAt));
            } else {
                if (this.f3189d && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (hashMap.containsKey(Integer.valueOf(id)) && (constraint = (Constraint) hashMap.get(Integer.valueOf(id))) != null) {
                    ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
                }
            }
        }
    }

    public void applyDeltaFrom(ConstraintSet constraintSet) {
        for (Constraint constraint : constraintSet.f3190e.values()) {
            if (constraint.f3193c != null) {
                if (constraint.f3192b == null) {
                    constraint.f3193c.m669e(getConstraint(constraint.f3191a));
                } else {
                    Iterator it = this.f3190e.keySet().iterator();
                    while (it.hasNext()) {
                        Constraint constraint2 = getConstraint(((Integer) it.next()).intValue());
                        String str = constraint2.layout.mConstraintTag;
                        if (str != null && constraint.f3192b.matches(str)) {
                            constraint.f3193c.m669e(constraint2);
                            constraint2.mCustomConstraints.putAll((HashMap) constraint.mCustomConstraints.clone());
                        }
                    }
                }
            }
        }
    }

    public void applyTo(ConstraintLayout constraintLayout) {
        m650b(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void applyToHelper(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        Constraint constraint;
        int id = constraintHelper.getId();
        HashMap hashMap = this.f3190e;
        if (hashMap.containsKey(Integer.valueOf(id)) && (constraint = (Constraint) hashMap.get(Integer.valueOf(id))) != null && (constraintWidget instanceof HelperWidget)) {
            constraintHelper.loadParameters(constraint, (HelperWidget) constraintWidget, layoutParams, sparseArray);
        }
    }

    public void applyToLayoutParams(int i, ConstraintLayout.LayoutParams layoutParams) {
        Constraint constraint;
        HashMap hashMap = this.f3190e;
        if (hashMap.containsKey(Integer.valueOf(i)) && (constraint = (Constraint) hashMap.get(Integer.valueOf(i))) != null) {
            constraint.applyTo(layoutParams);
        }
    }

    public void applyToWithoutCustom(ConstraintLayout constraintLayout) {
        m650b(constraintLayout, false);
        constraintLayout.setConstraintSet(null);
    }

    /* renamed from: b */
    public final void m650b(ConstraintLayout constraintLayout, boolean z) {
        int childCount = constraintLayout.getChildCount();
        HashMap hashMap = this.f3190e;
        HashSet hashSet = new HashSet(hashMap.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!hashMap.containsKey(Integer.valueOf(id))) {
                Log.w("ConstraintSet", "id unknown " + Debug.getName(childAt));
            } else {
                if (this.f3189d && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (hashMap.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        Constraint constraint = (Constraint) hashMap.get(Integer.valueOf(id));
                        if (constraint != null) {
                            if (childAt instanceof Barrier) {
                                constraint.layout.mHelperType = 1;
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id);
                                barrier.setType(constraint.layout.mBarrierDirection);
                                barrier.setMargin(constraint.layout.mBarrierMargin);
                                barrier.setAllowsGoneWidget(constraint.layout.mBarrierAllowsGoneWidgets);
                                Layout layout = constraint.layout;
                                int[] iArr = layout.mReferenceIds;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = layout.mReferenceIdString;
                                    if (str != null) {
                                        layout.mReferenceIds = m642c(barrier, str);
                                        barrier.setReferencedIds(constraint.layout.mReferenceIds);
                                    }
                                }
                            }
                            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                            layoutParams.validate();
                            constraint.applyTo(layoutParams);
                            if (z) {
                                ConstraintAttribute.setAttributes(childAt, constraint.mCustomConstraints);
                            }
                            childAt.setLayoutParams(layoutParams);
                            PropertySet propertySet = constraint.propertySet;
                            if (propertySet.mVisibilityMode == 0) {
                                childAt.setVisibility(propertySet.visibility);
                            }
                            childAt.setAlpha(constraint.propertySet.alpha);
                            childAt.setRotation(constraint.transform.rotation);
                            childAt.setRotationX(constraint.transform.rotationX);
                            childAt.setRotationY(constraint.transform.rotationY);
                            childAt.setScaleX(constraint.transform.scaleX);
                            childAt.setScaleY(constraint.transform.scaleY);
                            Transform transform = constraint.transform;
                            if (transform.transformPivotTarget != -1) {
                                if (((View) childAt.getParent()).findViewById(constraint.transform.transformPivotTarget) != null) {
                                    float bottom = (r5.getBottom() + r5.getTop()) / 2.0f;
                                    float right = (r5.getRight() + r5.getLeft()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(right - childAt.getLeft());
                                        childAt.setPivotY(bottom - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(transform.transformPivotX)) {
                                    childAt.setPivotX(constraint.transform.transformPivotX);
                                }
                                if (!Float.isNaN(constraint.transform.transformPivotY)) {
                                    childAt.setPivotY(constraint.transform.transformPivotY);
                                }
                            }
                            childAt.setTranslationX(constraint.transform.translationX);
                            childAt.setTranslationY(constraint.transform.translationY);
                            childAt.setTranslationZ(constraint.transform.translationZ);
                            Transform transform2 = constraint.transform;
                            if (transform2.applyElevation) {
                                childAt.setElevation(transform2.elevation);
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Constraint constraint2 = (Constraint) hashMap.get(num);
            if (constraint2 != null) {
                if (constraint2.layout.mHelperType == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    Layout layout2 = constraint2.layout;
                    int[] iArr2 = layout2.mReferenceIds;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = layout2.mReferenceIdString;
                        if (str2 != null) {
                            layout2.mReferenceIds = m642c(barrier2, str2);
                            barrier2.setReferencedIds(constraint2.layout.mReferenceIds);
                        }
                    }
                    barrier2.setType(constraint2.layout.mBarrierDirection);
                    barrier2.setMargin(constraint2.layout.mBarrierMargin);
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.validateParams();
                    constraint2.applyTo(generateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, generateDefaultLayoutParams);
                }
                if (constraint2.layout.mIsGuideline) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.LayoutParams generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    constraint2.applyTo(generateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, generateDefaultLayoutParams2);
                }
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt2 = constraintLayout.getChildAt(i2);
            if (childAt2 instanceof ConstraintHelper) {
                ((ConstraintHelper) childAt2).applyLayoutFeaturesInConstraintSet(constraintLayout);
            }
        }
    }

    public void center(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        if (i4 >= 0) {
            if (i7 >= 0) {
                if (f > RecyclerView.f7068F0 && f <= 1.0f) {
                    HashMap hashMap = this.f3190e;
                    if (i3 != 1 && i3 != 2) {
                        if (i3 != 6 && i3 != 7) {
                            connect(i, 3, i2, i3, i4);
                            connect(i, 4, i5, i6, i7);
                            Constraint constraint = (Constraint) hashMap.get(Integer.valueOf(i));
                            if (constraint != null) {
                                constraint.layout.verticalBias = f;
                                return;
                            }
                            return;
                        }
                        connect(i, 6, i2, i3, i4);
                        connect(i, 7, i5, i6, i7);
                        Constraint constraint2 = (Constraint) hashMap.get(Integer.valueOf(i));
                        if (constraint2 != null) {
                            constraint2.layout.horizontalBias = f;
                            return;
                        }
                        return;
                    }
                    connect(i, 1, i2, i3, i4);
                    connect(i, 2, i5, i6, i7);
                    Constraint constraint3 = (Constraint) hashMap.get(Integer.valueOf(i));
                    if (constraint3 != null) {
                        constraint3.layout.horizontalBias = f;
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
            }
            throw new IllegalArgumentException("margin must be > 0");
        }
        throw new IllegalArgumentException("margin must be > 0");
    }

    public void centerHorizontally(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        connect(i, 1, i2, i3, i4);
        connect(i, 2, i5, i6, i7);
        Constraint constraint = (Constraint) this.f3190e.get(Integer.valueOf(i));
        if (constraint != null) {
            constraint.layout.horizontalBias = f;
        }
    }

    public void centerHorizontallyRtl(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        connect(i, 6, i2, i3, i4);
        connect(i, 7, i5, i6, i7);
        Constraint constraint = (Constraint) this.f3190e.get(Integer.valueOf(i));
        if (constraint != null) {
            constraint.layout.horizontalBias = f;
        }
    }

    public void centerVertically(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        connect(i, 3, i2, i3, i4);
        connect(i, 4, i5, i6, i7);
        Constraint constraint = (Constraint) this.f3190e.get(Integer.valueOf(i));
        if (constraint != null) {
            constraint.layout.verticalBias = f;
        }
    }

    public void clear(int i) {
        this.f3190e.remove(Integer.valueOf(i));
    }

    public void clone(Context context, int i) {
        clone((ConstraintLayout) LayoutInflater.from(context).inflate(i, (ViewGroup) null));
    }

    public void connect(int i, int i2, int i3, int i4, int i5) {
        HashMap hashMap = this.f3190e;
        if (!hashMap.containsKey(Integer.valueOf(i))) {
            hashMap.put(Integer.valueOf(i), new Constraint());
        }
        Constraint constraint = (Constraint) hashMap.get(Integer.valueOf(i));
        if (constraint == null) {
            return;
        }
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    Layout layout = constraint.layout;
                    layout.leftToLeft = i3;
                    layout.leftToRight = -1;
                } else if (i4 == 2) {
                    Layout layout2 = constraint.layout;
                    layout2.leftToRight = i3;
                    layout2.leftToLeft = -1;
                } else {
                    throw new IllegalArgumentException("Left to " + m648k(i4) + " undefined");
                }
                constraint.layout.leftMargin = i5;
                return;
            case 2:
                if (i4 == 1) {
                    Layout layout3 = constraint.layout;
                    layout3.rightToLeft = i3;
                    layout3.rightToRight = -1;
                } else {
                    if (i4 != 2) {
                        throw new IllegalArgumentException("right to " + m648k(i4) + " undefined");
                    }
                    Layout layout4 = constraint.layout;
                    layout4.rightToRight = i3;
                    layout4.rightToLeft = -1;
                }
                constraint.layout.rightMargin = i5;
                return;
            case 3:
                if (i4 == 3) {
                    Layout layout5 = constraint.layout;
                    layout5.topToTop = i3;
                    layout5.topToBottom = -1;
                    layout5.baselineToBaseline = -1;
                    layout5.baselineToTop = -1;
                    layout5.baselineToBottom = -1;
                } else {
                    if (i4 != 4) {
                        throw new IllegalArgumentException("right to " + m648k(i4) + " undefined");
                    }
                    Layout layout6 = constraint.layout;
                    layout6.topToBottom = i3;
                    layout6.topToTop = -1;
                    layout6.baselineToBaseline = -1;
                    layout6.baselineToTop = -1;
                    layout6.baselineToBottom = -1;
                }
                constraint.layout.topMargin = i5;
                return;
            case 4:
                if (i4 == 4) {
                    Layout layout7 = constraint.layout;
                    layout7.bottomToBottom = i3;
                    layout7.bottomToTop = -1;
                    layout7.baselineToBaseline = -1;
                    layout7.baselineToTop = -1;
                    layout7.baselineToBottom = -1;
                } else {
                    if (i4 != 3) {
                        throw new IllegalArgumentException("right to " + m648k(i4) + " undefined");
                    }
                    Layout layout8 = constraint.layout;
                    layout8.bottomToTop = i3;
                    layout8.bottomToBottom = -1;
                    layout8.baselineToBaseline = -1;
                    layout8.baselineToTop = -1;
                    layout8.baselineToBottom = -1;
                }
                constraint.layout.bottomMargin = i5;
                return;
            case 5:
                if (i4 == 5) {
                    Layout layout9 = constraint.layout;
                    layout9.baselineToBaseline = i3;
                    layout9.bottomToBottom = -1;
                    layout9.bottomToTop = -1;
                    layout9.topToTop = -1;
                    layout9.topToBottom = -1;
                    return;
                }
                if (i4 == 3) {
                    Layout layout10 = constraint.layout;
                    layout10.baselineToTop = i3;
                    layout10.bottomToBottom = -1;
                    layout10.bottomToTop = -1;
                    layout10.topToTop = -1;
                    layout10.topToBottom = -1;
                    return;
                }
                if (i4 != 4) {
                    throw new IllegalArgumentException("right to " + m648k(i4) + " undefined");
                }
                Layout layout11 = constraint.layout;
                layout11.baselineToBottom = i3;
                layout11.bottomToBottom = -1;
                layout11.bottomToTop = -1;
                layout11.topToTop = -1;
                layout11.topToBottom = -1;
                return;
            case 6:
                if (i4 == 6) {
                    Layout layout12 = constraint.layout;
                    layout12.startToStart = i3;
                    layout12.startToEnd = -1;
                } else {
                    if (i4 != 7) {
                        throw new IllegalArgumentException("right to " + m648k(i4) + " undefined");
                    }
                    Layout layout13 = constraint.layout;
                    layout13.startToEnd = i3;
                    layout13.startToStart = -1;
                }
                constraint.layout.startMargin = i5;
                return;
            case 7:
                if (i4 == 7) {
                    Layout layout14 = constraint.layout;
                    layout14.endToEnd = i3;
                    layout14.endToStart = -1;
                } else {
                    if (i4 != 6) {
                        throw new IllegalArgumentException("right to " + m648k(i4) + " undefined");
                    }
                    Layout layout15 = constraint.layout;
                    layout15.endToStart = i3;
                    layout15.endToEnd = -1;
                }
                constraint.layout.endMargin = i5;
                return;
            default:
                throw new IllegalArgumentException(m648k(i2) + " to " + m648k(i4) + " unknown");
        }
    }

    public void constrainCircle(int i, int i2, int i3, float f) {
        Layout layout = m652f(i).layout;
        layout.circleConstraint = i2;
        layout.circleRadius = i3;
        layout.circleAngle = f;
    }

    public void constrainDefaultHeight(int i, int i2) {
        m652f(i).layout.heightDefault = i2;
    }

    public void constrainDefaultWidth(int i, int i2) {
        m652f(i).layout.widthDefault = i2;
    }

    public void constrainHeight(int i, int i2) {
        m652f(i).layout.mHeight = i2;
    }

    public void constrainMaxHeight(int i, int i2) {
        m652f(i).layout.heightMax = i2;
    }

    public void constrainMaxWidth(int i, int i2) {
        m652f(i).layout.widthMax = i2;
    }

    public void constrainMinHeight(int i, int i2) {
        m652f(i).layout.heightMin = i2;
    }

    public void constrainMinWidth(int i, int i2) {
        m652f(i).layout.widthMin = i2;
    }

    public void constrainPercentHeight(int i, float f) {
        m652f(i).layout.heightPercent = f;
    }

    public void constrainPercentWidth(int i, float f) {
        m652f(i).layout.widthPercent = f;
    }

    public void constrainWidth(int i, int i2) {
        m652f(i).layout.mWidth = i2;
    }

    public void constrainedHeight(int i, boolean z) {
        m652f(i).layout.constrainedHeight = z;
    }

    public void constrainedWidth(int i, boolean z) {
        m652f(i).layout.constrainedWidth = z;
    }

    public void create(int i, int i2) {
        Layout layout = m652f(i).layout;
        layout.mIsGuideline = true;
        layout.orientation = i2;
    }

    public void createBarrier(int i, int i2, int i3, int... iArr) {
        Layout layout = m652f(i).layout;
        layout.mHelperType = 1;
        layout.mBarrierDirection = i2;
        layout.mBarrierMargin = i3;
        layout.mIsGuideline = false;
        layout.mReferenceIds = iArr;
    }

    public void createHorizontalChain(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        m651d(i, i2, i3, i4, iArr, fArr, i5, 1, 2);
    }

    public void createHorizontalChainRtl(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        m651d(i, i2, i3, i4, iArr, fArr, i5, 6, 7);
    }

    public void createVerticalChain(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        if (iArr.length >= 2) {
            if (fArr != null && fArr.length != iArr.length) {
                throw new IllegalArgumentException("must have 2 or more widgets in a chain");
            }
            if (fArr != null) {
                m652f(iArr[0]).layout.verticalWeight = fArr[0];
            }
            m652f(iArr[0]).layout.verticalChainStyle = i5;
            connect(iArr[0], 3, i, i2, 0);
            for (int i6 = 1; i6 < iArr.length; i6++) {
                int i7 = i6 - 1;
                connect(iArr[i6], 3, iArr[i7], 4, 0);
                connect(iArr[i7], 4, iArr[i6], 3, 0);
                if (fArr != null) {
                    m652f(iArr[i6]).layout.verticalWeight = fArr[i6];
                }
            }
            connect(iArr[iArr.length - 1], 4, i3, i4, 0);
            return;
        }
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }

    /* renamed from: d */
    public final void m651d(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5, int i6, int i7) {
        if (iArr.length >= 2) {
            if (fArr != null && fArr.length != iArr.length) {
                throw new IllegalArgumentException("must have 2 or more widgets in a chain");
            }
            if (fArr != null) {
                m652f(iArr[0]).layout.horizontalWeight = fArr[0];
            }
            m652f(iArr[0]).layout.horizontalChainStyle = i5;
            connect(iArr[0], i6, i, i2, -1);
            for (int i8 = 1; i8 < iArr.length; i8++) {
                int i9 = i8 - 1;
                connect(iArr[i8], i6, iArr[i9], i7, -1);
                connect(iArr[i9], i7, iArr[i8], i6, -1);
                if (fArr != null) {
                    m652f(iArr[i8]).layout.horizontalWeight = fArr[i8];
                }
            }
            connect(iArr[iArr.length - 1], i7, i3, i4, -1);
            return;
        }
        throw new IllegalArgumentException("must have 2 or more widgets in a chain");
    }

    public void dump(MotionScene motionScene, int... iArr) {
        HashSet hashSet;
        HashMap hashMap = this.f3190e;
        Set keySet = hashMap.keySet();
        if (iArr.length != 0) {
            hashSet = new HashSet();
            for (int i : iArr) {
                hashSet.add(Integer.valueOf(i));
            }
        } else {
            hashSet = new HashSet(keySet);
        }
        System.out.println(hashSet.size() + " constraints");
        StringBuilder sb = new StringBuilder();
        for (Integer num : (Integer[]) hashSet.toArray(new Integer[0])) {
            Constraint constraint = (Constraint) hashMap.get(num);
            if (constraint != null) {
                sb.append("<Constraint id=");
                sb.append(num);
                sb.append(" \n");
                constraint.layout.dump(motionScene, sb);
                sb.append("/>\n");
            }
        }
        System.out.println(sb.toString());
    }

    /* renamed from: f */
    public final Constraint m652f(int i) {
        HashMap hashMap = this.f3190e;
        if (!hashMap.containsKey(Integer.valueOf(i))) {
            hashMap.put(Integer.valueOf(i), new Constraint());
        }
        return (Constraint) hashMap.get(Integer.valueOf(i));
    }

    public boolean getApplyElevation(int i) {
        return m652f(i).transform.applyElevation;
    }

    public Constraint getConstraint(int i) {
        HashMap hashMap = this.f3190e;
        if (hashMap.containsKey(Integer.valueOf(i))) {
            return (Constraint) hashMap.get(Integer.valueOf(i));
        }
        return null;
    }

    public HashMap<String, ConstraintAttribute> getCustomAttributeSet() {
        return this.f3188c;
    }

    public int getHeight(int i) {
        return m652f(i).layout.mHeight;
    }

    public int[] getKnownIds() {
        Integer[] numArr = (Integer[]) this.f3190e.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    public Constraint getParameters(int i) {
        return m652f(i);
    }

    public int[] getReferencedIds(int i) {
        int[] iArr = m652f(i).layout.mReferenceIds;
        if (iArr == null) {
            return new int[0];
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    public String[] getStateLabels() {
        String[] strArr = this.f3187b;
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public int getVisibility(int i) {
        return m652f(i).propertySet.visibility;
    }

    public int getVisibilityMode(int i) {
        return m652f(i).propertySet.mVisibilityMode;
    }

    public int getWidth(int i) {
        return m652f(i).layout.mWidth;
    }

    public boolean isForceId() {
        return this.f3189d;
    }

    public boolean isValidateOnParse() {
        return this.f3186a;
    }

    public void load(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2) {
                    String name = xml.getName();
                    Constraint m643e = m643e(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        m643e.layout.mIsGuideline = true;
                    }
                    this.f3190e.put(Integer.valueOf(m643e.f3191a), m643e);
                }
            }
        } catch (IOException e) {
            Log.e("ConstraintSet", "Error parsing resource: " + i, e);
        } catch (XmlPullParserException e2) {
            Log.e("ConstraintSet", "Error parsing resource: " + i, e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
    
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean matchesLabels(String... strArr) {
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            for (String str2 : this.f3187b) {
                if (str2.equals(str)) {
                    break;
                }
            }
            return false;
        }
        return true;
    }

    public void parseColorAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].split("=");
            if (split2.length != 2) {
                Log.w("ConstraintSet", " Unable to parse " + split[i]);
            } else {
                constraint.m655c(split2[0], ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(Color.parseColor(split2[1]));
            }
        }
    }

    public void parseFloatAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].split("=");
            if (split2.length != 2) {
                Log.w("ConstraintSet", " Unable to parse " + split[i]);
            } else {
                constraint.m655c(split2[0], ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(Float.parseFloat(split2[1]));
            }
        }
    }

    public void parseIntAttributes(Constraint constraint, String str) {
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].split("=");
            if (split2.length != 2) {
                Log.w("ConstraintSet", " Unable to parse " + split[i]);
            } else {
                constraint.m655c(split2[0], ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(Integer.decode(split2[1]).intValue());
            }
        }
    }

    public void parseStringAttributes(Constraint constraint, String str) {
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            char c = charArray[i2];
            if (c == ',' && !z) {
                arrayList.add(new String(charArray, i, i2 - i));
                i = i2 + 1;
            } else if (c == '\"') {
                z = !z;
            }
        }
        arrayList.add(new String(charArray, i, charArray.length - i));
        String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        for (int i3 = 0; i3 < strArr.length; i3++) {
            String[] split = strArr[i3].split("=");
            Log.w("ConstraintSet", " Unable to parse " + strArr[i3]);
            constraint.m655c(split[0], ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(split[1]);
        }
    }

    public void readFallback(ConstraintSet constraintSet) {
        for (Integer num : constraintSet.f3190e.keySet()) {
            num.intValue();
            Constraint constraint = (Constraint) constraintSet.f3190e.get(num);
            HashMap hashMap = this.f3190e;
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, new Constraint());
            }
            Constraint constraint2 = (Constraint) hashMap.get(num);
            if (constraint2 != null) {
                Layout layout = constraint2.layout;
                if (!layout.mApply) {
                    layout.copyFrom(constraint.layout);
                }
                PropertySet propertySet = constraint2.propertySet;
                if (!propertySet.mApply) {
                    propertySet.copyFrom(constraint.propertySet);
                }
                Transform transform = constraint2.transform;
                if (!transform.mApply) {
                    transform.copyFrom(constraint.transform);
                }
                Motion motion = constraint2.motion;
                if (!motion.mApply) {
                    motion.copyFrom(constraint.motion);
                }
                for (String str : constraint.mCustomConstraints.keySet()) {
                    if (!constraint2.mCustomConstraints.containsKey(str)) {
                        constraint2.mCustomConstraints.put(str, constraint.mCustomConstraints.get(str));
                    }
                }
            }
        }
    }

    public void removeAttribute(String str) {
        this.f3188c.remove(str);
    }

    public void removeFromHorizontalChain(int i) {
        Constraint constraint;
        HashMap hashMap = this.f3190e;
        if (!hashMap.containsKey(Integer.valueOf(i)) || (constraint = (Constraint) hashMap.get(Integer.valueOf(i))) == null) {
            return;
        }
        Layout layout = constraint.layout;
        int i2 = layout.leftToRight;
        int i3 = layout.rightToLeft;
        if (i2 == -1 && i3 == -1) {
            int i4 = layout.startToEnd;
            int i5 = layout.endToStart;
            if (i4 != -1 || i5 != -1) {
                if (i4 != -1 && i5 != -1) {
                    connect(i4, 7, i5, 6, 0);
                    connect(i5, 6, i2, 7, 0);
                } else if (i5 != -1) {
                    int i6 = layout.rightToRight;
                    if (i6 != -1) {
                        connect(i2, 7, i6, 7, 0);
                    } else {
                        int i7 = layout.leftToLeft;
                        if (i7 != -1) {
                            connect(i5, 6, i7, 6, 0);
                        }
                    }
                }
            }
            clear(i, 6);
            clear(i, 7);
            return;
        }
        if (i2 != -1 && i3 != -1) {
            connect(i2, 2, i3, 1, 0);
            connect(i3, 1, i2, 2, 0);
        } else {
            int i8 = layout.rightToRight;
            if (i8 != -1) {
                connect(i2, 2, i8, 2, 0);
            } else {
                int i9 = layout.leftToLeft;
                if (i9 != -1) {
                    connect(i3, 1, i9, 1, 0);
                }
            }
        }
        clear(i, 1);
        clear(i, 2);
    }

    public void removeFromVerticalChain(int i) {
        HashMap hashMap = this.f3190e;
        if (hashMap.containsKey(Integer.valueOf(i))) {
            Constraint constraint = (Constraint) hashMap.get(Integer.valueOf(i));
            if (constraint == null) {
                return;
            }
            Layout layout = constraint.layout;
            int i2 = layout.topToBottom;
            int i3 = layout.bottomToTop;
            if (i2 != -1 || i3 != -1) {
                if (i2 != -1 && i3 != -1) {
                    connect(i2, 4, i3, 3, 0);
                    connect(i3, 3, i2, 4, 0);
                } else {
                    int i4 = layout.bottomToBottom;
                    if (i4 != -1) {
                        connect(i2, 4, i4, 4, 0);
                    } else {
                        int i5 = layout.topToTop;
                        if (i5 != -1) {
                            connect(i3, 3, i5, 3, 0);
                        }
                    }
                }
            }
        }
        clear(i, 3);
        clear(i, 4);
    }

    public void setAlpha(int i, float f) {
        m652f(i).propertySet.alpha = f;
    }

    public void setApplyElevation(int i, boolean z) {
        m652f(i).transform.applyElevation = z;
    }

    public void setBarrierType(int i, int i2) {
        m652f(i).layout.mHelperType = i2;
    }

    public void setColorValue(int i, String str, int i2) {
        m652f(i).m655c(str, ConstraintAttribute.AttributeType.COLOR_TYPE).setColorValue(i2);
    }

    public void setDimensionRatio(int i, String str) {
        m652f(i).layout.dimensionRatio = str;
    }

    public void setEditorAbsoluteX(int i, int i2) {
        m652f(i).layout.editorAbsoluteX = i2;
    }

    public void setEditorAbsoluteY(int i, int i2) {
        m652f(i).layout.editorAbsoluteY = i2;
    }

    public void setElevation(int i, float f) {
        m652f(i).transform.elevation = f;
        m652f(i).transform.applyElevation = true;
    }

    public void setFloatValue(int i, String str, float f) {
        m652f(i).m655c(str, ConstraintAttribute.AttributeType.FLOAT_TYPE).setFloatValue(f);
    }

    public void setForceId(boolean z) {
        this.f3189d = z;
    }

    public void setGoneMargin(int i, int i2, int i3) {
        Constraint m652f = m652f(i);
        switch (i2) {
            case 1:
                m652f.layout.goneLeftMargin = i3;
                return;
            case 2:
                m652f.layout.goneRightMargin = i3;
                return;
            case 3:
                m652f.layout.goneTopMargin = i3;
                return;
            case 4:
                m652f.layout.goneBottomMargin = i3;
                return;
            case 5:
                m652f.layout.goneBaselineMargin = i3;
                return;
            case 6:
                m652f.layout.goneStartMargin = i3;
                return;
            case 7:
                m652f.layout.goneEndMargin = i3;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setGuidelineBegin(int i, int i2) {
        m652f(i).layout.guideBegin = i2;
        m652f(i).layout.guideEnd = -1;
        m652f(i).layout.guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int i, int i2) {
        m652f(i).layout.guideEnd = i2;
        m652f(i).layout.guideBegin = -1;
        m652f(i).layout.guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int i, float f) {
        m652f(i).layout.guidePercent = f;
        m652f(i).layout.guideEnd = -1;
        m652f(i).layout.guideBegin = -1;
    }

    public void setHorizontalBias(int i, float f) {
        m652f(i).layout.horizontalBias = f;
    }

    public void setHorizontalChainStyle(int i, int i2) {
        m652f(i).layout.horizontalChainStyle = i2;
    }

    public void setHorizontalWeight(int i, float f) {
        m652f(i).layout.horizontalWeight = f;
    }

    public void setIntValue(int i, String str, int i2) {
        m652f(i).m655c(str, ConstraintAttribute.AttributeType.INT_TYPE).setIntValue(i2);
    }

    public void setLayoutWrapBehavior(int i, int i2) {
        if (i2 >= 0 && i2 <= 3) {
            m652f(i).layout.mWrapBehavior = i2;
        }
    }

    public void setMargin(int i, int i2, int i3) {
        Constraint m652f = m652f(i);
        switch (i2) {
            case 1:
                m652f.layout.leftMargin = i3;
                return;
            case 2:
                m652f.layout.rightMargin = i3;
                return;
            case 3:
                m652f.layout.topMargin = i3;
                return;
            case 4:
                m652f.layout.bottomMargin = i3;
                return;
            case 5:
                m652f.layout.baselineMargin = i3;
                return;
            case 6:
                m652f.layout.startMargin = i3;
                return;
            case 7:
                m652f.layout.endMargin = i3;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setReferencedIds(int i, int... iArr) {
        m652f(i).layout.mReferenceIds = iArr;
    }

    public void setRotation(int i, float f) {
        m652f(i).transform.rotation = f;
    }

    public void setRotationX(int i, float f) {
        m652f(i).transform.rotationX = f;
    }

    public void setRotationY(int i, float f) {
        m652f(i).transform.rotationY = f;
    }

    public void setScaleX(int i, float f) {
        m652f(i).transform.scaleX = f;
    }

    public void setScaleY(int i, float f) {
        m652f(i).transform.scaleY = f;
    }

    public void setStateLabels(String str) {
        this.f3187b = str.split(",");
        int i = 0;
        while (true) {
            String[] strArr = this.f3187b;
            if (i < strArr.length) {
                strArr[i] = strArr[i].trim();
                i++;
            } else {
                return;
            }
        }
    }

    public void setStateLabelsList(String... strArr) {
        this.f3187b = strArr;
        int i = 0;
        while (true) {
            String[] strArr2 = this.f3187b;
            if (i < strArr2.length) {
                strArr2[i] = strArr2[i].trim();
                i++;
            } else {
                return;
            }
        }
    }

    public void setStringValue(int i, String str, String str2) {
        m652f(i).m655c(str, ConstraintAttribute.AttributeType.STRING_TYPE).setStringValue(str2);
    }

    public void setTransformPivot(int i, float f, float f2) {
        Transform transform = m652f(i).transform;
        transform.transformPivotY = f2;
        transform.transformPivotX = f;
    }

    public void setTransformPivotX(int i, float f) {
        m652f(i).transform.transformPivotX = f;
    }

    public void setTransformPivotY(int i, float f) {
        m652f(i).transform.transformPivotY = f;
    }

    public void setTranslation(int i, float f, float f2) {
        Transform transform = m652f(i).transform;
        transform.translationX = f;
        transform.translationY = f2;
    }

    public void setTranslationX(int i, float f) {
        m652f(i).transform.translationX = f;
    }

    public void setTranslationY(int i, float f) {
        m652f(i).transform.translationY = f;
    }

    public void setTranslationZ(int i, float f) {
        m652f(i).transform.translationZ = f;
    }

    public void setValidateOnParse(boolean z) {
        this.f3186a = z;
    }

    public void setVerticalBias(int i, float f) {
        m652f(i).layout.verticalBias = f;
    }

    public void setVerticalChainStyle(int i, int i2) {
        m652f(i).layout.verticalChainStyle = i2;
    }

    public void setVerticalWeight(int i, float f) {
        m652f(i).layout.verticalWeight = f;
    }

    public void setVisibility(int i, int i2) {
        m652f(i).propertySet.visibility = i2;
    }

    public void setVisibilityMode(int i, int i2) {
        m652f(i).propertySet.mVisibilityMode = i2;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.constraintlayout.widget.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.constraintlayout.widget.g, java.lang.Object] */
    public void writeState(Writer writer, ConstraintLayout constraintLayout, int i) {
        String str;
        String str2;
        String str3;
        String str4 = "\n---------------------------------------------\n";
        writer.write("\n---------------------------------------------\n");
        int i2 = i & 1;
        HashMap hashMap = this.f3190e;
        String str5 = "[";
        if (i2 != 1) {
            str = "\n---------------------------------------------\n";
            ?? obj = new Object();
            obj.f3247c = 0;
            obj.f3248d = new HashMap();
            obj.f3245a = writer;
            obj.f3246b = constraintLayout.getContext();
            Writer writer2 = obj.f3245a;
            writer2.write("\n'ConstraintSet':{\n");
            for (Integer num : hashMap.keySet()) {
                Constraint constraint = (Constraint) hashMap.get(num);
                writer2.write(obj.m670a(num.intValue()) + ":{\n");
                Layout layout = constraint.layout;
                obj.m672c("height", layout.mHeight, layout.heightDefault, layout.heightPercent, layout.heightMin, layout.heightMax);
                obj.m672c("width", layout.mWidth, layout.widthDefault, layout.widthPercent, layout.widthMin, layout.widthMax);
                obj.m671b(layout.leftToLeft, "'left'", "'left'", layout.leftMargin);
                obj.m671b(layout.leftToRight, "'left'", "'right'", layout.leftMargin);
                obj.m671b(layout.rightToLeft, "'right'", "'left'", layout.rightMargin);
                obj.m671b(layout.rightToRight, "'right'", "'right'", layout.rightMargin);
                obj.m671b(layout.baselineToBaseline, "'baseline'", "'baseline'", -1);
                obj.m671b(layout.baselineToTop, "'baseline'", "'top'", -1);
                obj.m671b(layout.baselineToBottom, "'baseline'", "'bottom'", -1);
                obj.m671b(layout.topToBottom, "'top'", "'bottom'", layout.topMargin);
                obj.m671b(layout.topToTop, "'top'", "'top'", layout.topMargin);
                obj.m671b(layout.bottomToBottom, "'bottom'", "'bottom'", layout.bottomMargin);
                obj.m671b(layout.bottomToTop, "'bottom'", "'top'", layout.bottomMargin);
                obj.m671b(layout.startToStart, "'start'", "'start'", layout.startMargin);
                obj.m671b(layout.startToEnd, "'start'", "'end'", layout.startMargin);
                obj.m671b(layout.endToStart, "'end'", "'start'", layout.endMargin);
                obj.m671b(layout.endToEnd, "'end'", "'end'", layout.endMargin);
                obj.m676g("'horizontalBias'", layout.horizontalBias);
                obj.m676g("'verticalBias'", layout.verticalBias);
                int i3 = layout.circleConstraint;
                float f = layout.circleAngle;
                int i4 = layout.circleRadius;
                if (i3 != -1) {
                    writer2.write("       circle");
                    writer2.write(":[");
                    writer2.write(obj.m670a(i3));
                    writer2.write(", " + f);
                    writer2.write(i4 + "]");
                }
                int i5 = layout.orientation;
                int i6 = layout.guideBegin;
                int i7 = layout.guideEnd;
                float f2 = layout.guidePercent;
                obj.m673d(i5, "'orientation'");
                obj.m673d(i6, "'guideBegin'");
                obj.m673d(i7, "'guideEnd'");
                obj.m674e("'guidePercent'", f2);
                obj.m675f("'dimensionRatio'", layout.dimensionRatio);
                obj.m673d(layout.mBarrierMargin, "'barrierMargin'");
                obj.m673d(layout.mHelperType, "'type'");
                obj.m675f("'ReferenceId'", layout.mReferenceIdString);
                boolean z = layout.mBarrierAllowsGoneWidgets;
                if (!z) {
                    writer2.write("       'mBarrierAllowsGoneWidgets'");
                    writer2.write(": " + z);
                    writer2.write(",\n");
                }
                obj.m673d(layout.mWrapBehavior, "'WrapBehavior'");
                obj.m674e("'verticalWeight'", layout.verticalWeight);
                obj.m674e("'horizontalWeight'", layout.horizontalWeight);
                obj.m673d(layout.horizontalChainStyle, "'horizontalChainStyle'");
                obj.m673d(layout.verticalChainStyle, "'verticalChainStyle'");
                obj.m673d(layout.mBarrierDirection, "'barrierDirection'");
                int[] iArr = layout.mReferenceIds;
                if (iArr != null) {
                    writer2.write("       'ReferenceIds'");
                    writer2.write(": ");
                    for (int i8 = 0; i8 < iArr.length; i8++) {
                        StringBuilder sb = new StringBuilder();
                        if (i8 != 0) {
                            str2 = ", ";
                        } else {
                            str2 = "[";
                        }
                        sb.append(str2);
                        sb.append(obj.m670a(iArr[i8]));
                        writer2.write(sb.toString());
                    }
                    writer2.write("],\n");
                }
                writer2.write("}\n");
            }
            writer2.write("}\n");
        } else {
            ?? obj2 = new Object();
            obj2.f3251c = 0;
            obj2.f3252d = new HashMap();
            obj2.f3249a = writer;
            obj2.f3250b = constraintLayout.getContext();
            Writer writer3 = obj2.f3249a;
            writer3.write("\n<ConstraintSet>\n");
            Iterator it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                Integer num2 = (Integer) it.next();
                Constraint constraint2 = (Constraint) hashMap.get(num2);
                String m677a = obj2.m677a(num2.intValue());
                writer3.write("  <Constraint");
                writer3.write("\n       android:id=\"" + m677a + "\"");
                Layout layout2 = constraint2.layout;
                obj2.m678b(layout2.mWidth, "android:layout_width");
                obj2.m678b(layout2.mHeight, "android:layout_height");
                obj2.m683g("app:layout_constraintGuide_begin", layout2.guideBegin, -1.0f);
                obj2.m683g("app:layout_constraintGuide_end", layout2.guideEnd, -1.0f);
                obj2.m683g("app:layout_constraintGuide_percent", layout2.guidePercent, -1.0f);
                obj2.m683g("app:layout_constraintHorizontal_bias", layout2.horizontalBias, 0.5f);
                obj2.m683g("app:layout_constraintVertical_bias", layout2.verticalBias, 0.5f);
                obj2.m684h("app:layout_constraintDimensionRatio", layout2.dimensionRatio);
                obj2.m685i(layout2.circleConstraint, "app:layout_constraintCircle");
                obj2.m683g("app:layout_constraintCircleRadius", layout2.circleRadius, RecyclerView.f7068F0);
                obj2.m683g("app:layout_constraintCircleAngle", layout2.circleAngle, RecyclerView.f7068F0);
                obj2.m683g("android:orientation", layout2.orientation, -1.0f);
                obj2.m683g("app:layout_constraintVertical_weight", layout2.verticalWeight, -1.0f);
                obj2.m683g("app:layout_constraintHorizontal_weight", layout2.horizontalWeight, -1.0f);
                obj2.m683g("app:layout_constraintHorizontal_chainStyle", layout2.horizontalChainStyle, RecyclerView.f7068F0);
                obj2.m683g("app:layout_constraintVertical_chainStyle", layout2.verticalChainStyle, RecyclerView.f7068F0);
                String str6 = str5;
                obj2.m683g("app:barrierDirection", layout2.mBarrierDirection, -1.0f);
                Iterator it2 = it;
                obj2.m683g("app:barrierMargin", layout2.mBarrierMargin, RecyclerView.f7068F0);
                obj2.m680d(layout2.leftMargin, 0, "app:layout_marginLeft");
                obj2.m680d(layout2.goneLeftMargin, Integer.MIN_VALUE, "app:layout_goneMarginLeft");
                obj2.m680d(layout2.rightMargin, 0, "app:layout_marginRight");
                obj2.m680d(layout2.goneRightMargin, Integer.MIN_VALUE, "app:layout_goneMarginRight");
                obj2.m680d(layout2.startMargin, 0, "app:layout_marginStart");
                obj2.m680d(layout2.goneStartMargin, Integer.MIN_VALUE, "app:layout_goneMarginStart");
                obj2.m680d(layout2.endMargin, 0, "app:layout_marginEnd");
                obj2.m680d(layout2.goneEndMargin, Integer.MIN_VALUE, "app:layout_goneMarginEnd");
                obj2.m680d(layout2.topMargin, 0, "app:layout_marginTop");
                obj2.m680d(layout2.goneTopMargin, Integer.MIN_VALUE, "app:layout_goneMarginTop");
                obj2.m680d(layout2.bottomMargin, 0, "app:layout_marginBottom");
                obj2.m680d(layout2.goneBottomMargin, Integer.MIN_VALUE, "app:layout_goneMarginBottom");
                obj2.m680d(layout2.goneBaselineMargin, Integer.MIN_VALUE, "app:goneBaselineMargin");
                obj2.m680d(layout2.baselineMargin, 0, "app:baselineMargin");
                obj2.m679c("app:layout_constrainedWidth", layout2.constrainedWidth, false);
                obj2.m679c("app:layout_constrainedHeight", layout2.constrainedHeight, false);
                obj2.m679c("app:barrierAllowsGoneWidgets", layout2.mBarrierAllowsGoneWidgets, true);
                obj2.m683g("app:layout_wrapBehaviorInParent", layout2.mWrapBehavior, RecyclerView.f7068F0);
                obj2.m685i(layout2.baselineToBaseline, "app:baselineToBaseline");
                obj2.m685i(layout2.baselineToBottom, "app:baselineToBottom");
                obj2.m685i(layout2.baselineToTop, "app:baselineToTop");
                obj2.m685i(layout2.bottomToBottom, "app:layout_constraintBottom_toBottomOf");
                obj2.m685i(layout2.bottomToTop, "app:layout_constraintBottom_toTopOf");
                obj2.m685i(layout2.endToEnd, "app:layout_constraintEnd_toEndOf");
                obj2.m685i(layout2.endToStart, "app:layout_constraintEnd_toStartOf");
                obj2.m685i(layout2.leftToLeft, "app:layout_constraintLeft_toLeftOf");
                obj2.m685i(layout2.leftToRight, "app:layout_constraintLeft_toRightOf");
                obj2.m685i(layout2.rightToLeft, "app:layout_constraintRight_toLeftOf");
                obj2.m685i(layout2.rightToRight, "app:layout_constraintRight_toRightOf");
                obj2.m685i(layout2.startToEnd, "app:layout_constraintStart_toEndOf");
                obj2.m685i(layout2.startToStart, "app:layout_constraintStart_toStartOf");
                obj2.m685i(layout2.topToBottom, "app:layout_constraintTop_toBottomOf");
                obj2.m685i(layout2.topToTop, "app:layout_constraintTop_toTopOf");
                String[] strArr = {"spread", "wrap", "percent"};
                String str7 = str4;
                obj2.m681e("app:layout_constraintHeight_default", layout2.heightDefault, strArr, 0);
                obj2.m683g("app:layout_constraintHeight_percent", layout2.heightPercent, 1.0f);
                obj2.m680d(layout2.heightMin, 0, "app:layout_constraintHeight_min");
                obj2.m680d(layout2.heightMax, 0, "app:layout_constraintHeight_max");
                obj2.m679c("android:layout_constrainedHeight", layout2.constrainedHeight, false);
                obj2.m681e("app:layout_constraintWidth_default", layout2.widthDefault, strArr, 0);
                obj2.m683g("app:layout_constraintWidth_percent", layout2.widthPercent, 1.0f);
                obj2.m680d(layout2.widthMin, 0, "app:layout_constraintWidth_min");
                obj2.m680d(layout2.widthMax, 0, "app:layout_constraintWidth_max");
                obj2.m679c("android:layout_constrainedWidth", layout2.constrainedWidth, false);
                obj2.m683g("app:layout_constraintVertical_weight", layout2.verticalWeight, -1.0f);
                obj2.m683g("app:layout_constraintHorizontal_weight", layout2.horizontalWeight, -1.0f);
                obj2.m682f(layout2.horizontalChainStyle, "app:layout_constraintHorizontal_chainStyle");
                obj2.m682f(layout2.verticalChainStyle, "app:layout_constraintVertical_chainStyle");
                obj2.m681e("app:barrierDirection", layout2.mBarrierDirection, new String[]{"left", "right", "top", "bottom", "start", "end"}, -1);
                obj2.m684h("app:layout_constraintTag", layout2.mConstraintTag);
                int[] iArr2 = layout2.mReferenceIds;
                if (iArr2 != null) {
                    writer3.write("\n       'ReferenceIds'");
                    writer3.write(":");
                    for (int i9 = 0; i9 < iArr2.length; i9++) {
                        StringBuilder sb2 = new StringBuilder();
                        if (i9 != 0) {
                            str3 = ", ";
                        } else {
                            str3 = str6;
                        }
                        sb2.append(str3);
                        sb2.append(obj2.m677a(iArr2[i9]));
                        writer3.write(sb2.toString());
                    }
                    writer3.write("],\n");
                }
                writer3.write(" />\n");
                str4 = str7;
                str5 = str6;
                it = it2;
            }
            str = str4;
            writer3.write("</ConstraintSet>\n");
        }
        writer.write(str);
    }

    public void clear(int i, int i2) {
        Constraint constraint;
        HashMap hashMap = this.f3190e;
        if (!hashMap.containsKey(Integer.valueOf(i)) || (constraint = (Constraint) hashMap.get(Integer.valueOf(i))) == null) {
            return;
        }
        switch (i2) {
            case 1:
                Layout layout = constraint.layout;
                layout.leftToRight = -1;
                layout.leftToLeft = -1;
                layout.leftMargin = -1;
                layout.goneLeftMargin = Integer.MIN_VALUE;
                return;
            case 2:
                Layout layout2 = constraint.layout;
                layout2.rightToRight = -1;
                layout2.rightToLeft = -1;
                layout2.rightMargin = -1;
                layout2.goneRightMargin = Integer.MIN_VALUE;
                return;
            case 3:
                Layout layout3 = constraint.layout;
                layout3.topToBottom = -1;
                layout3.topToTop = -1;
                layout3.topMargin = 0;
                layout3.goneTopMargin = Integer.MIN_VALUE;
                return;
            case 4:
                Layout layout4 = constraint.layout;
                layout4.bottomToTop = -1;
                layout4.bottomToBottom = -1;
                layout4.bottomMargin = 0;
                layout4.goneBottomMargin = Integer.MIN_VALUE;
                return;
            case 5:
                Layout layout5 = constraint.layout;
                layout5.baselineToBaseline = -1;
                layout5.baselineToTop = -1;
                layout5.baselineToBottom = -1;
                layout5.baselineMargin = 0;
                layout5.goneBaselineMargin = Integer.MIN_VALUE;
                return;
            case 6:
                Layout layout6 = constraint.layout;
                layout6.startToEnd = -1;
                layout6.startToStart = -1;
                layout6.startMargin = 0;
                layout6.goneStartMargin = Integer.MIN_VALUE;
                return;
            case 7:
                Layout layout7 = constraint.layout;
                layout7.endToStart = -1;
                layout7.endToEnd = -1;
                layout7.endMargin = 0;
                layout7.goneEndMargin = Integer.MIN_VALUE;
                return;
            case 8:
                Layout layout8 = constraint.layout;
                layout8.circleAngle = -1.0f;
                layout8.circleRadius = -1;
                layout8.circleConstraint = -1;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void clone(ConstraintSet constraintSet) {
        HashMap hashMap = this.f3190e;
        hashMap.clear();
        for (Integer num : constraintSet.f3190e.keySet()) {
            Constraint constraint = (Constraint) constraintSet.f3190e.get(num);
            if (constraint != null) {
                hashMap.put(num, constraint.m8478clone());
            }
        }
    }

    public void centerHorizontally(int i, int i2) {
        if (i2 == 0) {
            center(i, 0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            center(i, i2, 2, 0, i2, 1, 0, 0.5f);
        }
    }

    public void centerHorizontallyRtl(int i, int i2) {
        if (i2 == 0) {
            center(i, 0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            center(i, i2, 7, 0, i2, 6, 0, 0.5f);
        }
    }

    public void centerVertically(int i, int i2) {
        if (i2 == 0) {
            center(i, 0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            center(i, i2, 4, 0, i2, 3, 0, 0.5f);
        }
    }

    public void clone(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashMap hashMap = this.f3190e;
        hashMap.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f3189d && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!hashMap.containsKey(Integer.valueOf(id))) {
                hashMap.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = (Constraint) hashMap.get(Integer.valueOf(id));
            if (constraint != null) {
                constraint.mCustomConstraints = ConstraintAttribute.extractAttributes(this.f3188c, childAt);
                constraint.m653a(id, layoutParams);
                constraint.propertySet.visibility = childAt.getVisibility();
                constraint.propertySet.alpha = childAt.getAlpha();
                constraint.transform.rotation = childAt.getRotation();
                constraint.transform.rotationX = childAt.getRotationX();
                constraint.transform.rotationY = childAt.getRotationY();
                constraint.transform.scaleX = childAt.getScaleX();
                constraint.transform.scaleY = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    Transform transform = constraint.transform;
                    transform.transformPivotX = pivotX;
                    transform.transformPivotY = pivotY;
                }
                constraint.transform.translationX = childAt.getTranslationX();
                constraint.transform.translationY = childAt.getTranslationY();
                constraint.transform.translationZ = childAt.getTranslationZ();
                Transform transform2 = constraint.transform;
                if (transform2.applyElevation) {
                    transform2.elevation = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    constraint.layout.mBarrierAllowsGoneWidgets = barrier.getAllowsGoneWidget();
                    constraint.layout.mReferenceIds = barrier.getReferencedIds();
                    constraint.layout.mBarrierDirection = barrier.getType();
                    constraint.layout.mBarrierMargin = barrier.getMargin();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x01d3, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void load(Context context, XmlPullParser xmlPullParser) {
        try {
            int eventType = xmlPullParser.getEventType();
            Constraint constraint = null;
            while (eventType != 1) {
                if (eventType != 0) {
                    char c = 65535;
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        switch (name.hashCode()) {
                            case -2025855158:
                                if (name.equals("Layout")) {
                                    c = 6;
                                    break;
                                }
                                break;
                            case -1984451626:
                                if (name.equals(TypedValues.MotionType.NAME)) {
                                    c = 7;
                                    break;
                                }
                                break;
                            case -1962203927:
                                if (name.equals(ViewTransition.CONSTRAINT_OVERRIDE)) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case -1269513683:
                                if (name.equals("PropertySet")) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case -1238332596:
                                if (name.equals("Transform")) {
                                    c = 5;
                                    break;
                                }
                                break;
                            case -71750448:
                                if (name.equals("Guideline")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 366511058:
                                if (name.equals(ViewTransition.CUSTOM_METHOD)) {
                                    c = '\t';
                                    break;
                                }
                                break;
                            case 1331510167:
                                if (name.equals("Barrier")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 1791837707:
                                if (name.equals(ViewTransition.CUSTOM_ATTRIBUTE)) {
                                    c = '\b';
                                    break;
                                }
                                break;
                            case 1803088381:
                                if (name.equals("Constraint")) {
                                    c = 0;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                constraint = m643e(context, Xml.asAttributeSet(xmlPullParser), false);
                                break;
                            case 1:
                                constraint = m643e(context, Xml.asAttributeSet(xmlPullParser), true);
                                break;
                            case 2:
                                constraint = m643e(context, Xml.asAttributeSet(xmlPullParser), false);
                                Layout layout = constraint.layout;
                                layout.mIsGuideline = true;
                                layout.mApply = true;
                                break;
                            case 3:
                                constraint = m643e(context, Xml.asAttributeSet(xmlPullParser), false);
                                constraint.layout.mHelperType = 1;
                                break;
                            case 4:
                                if (constraint != null) {
                                    constraint.propertySet.m658a(context, Xml.asAttributeSet(xmlPullParser));
                                    break;
                                } else {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                            case 5:
                                if (constraint != null) {
                                    constraint.transform.m659a(context, Xml.asAttributeSet(xmlPullParser));
                                    break;
                                } else {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                            case 6:
                                if (constraint != null) {
                                    constraint.layout.m656a(context, Xml.asAttributeSet(xmlPullParser));
                                    break;
                                } else {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                            case 7:
                                if (constraint != null) {
                                    constraint.motion.m657a(context, Xml.asAttributeSet(xmlPullParser));
                                    break;
                                } else {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                            case '\b':
                            case '\t':
                                if (constraint != null) {
                                    ConstraintAttribute.parse(context, xmlPullParser, constraint.mCustomConstraints);
                                    break;
                                } else {
                                    throw new RuntimeException("XML parser error must be within a Constraint " + xmlPullParser.getLineNumber());
                                }
                        }
                    } else if (eventType == 3) {
                        String lowerCase = xmlPullParser.getName().toLowerCase(Locale.ROOT);
                        switch (lowerCase.hashCode()) {
                            case -2075718416:
                                if (lowerCase.equals("guideline")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case -190376483:
                                if (lowerCase.equals("constraint")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 426575017:
                                if (lowerCase.equals("constraintoverride")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 2146106725:
                                if (lowerCase.equals("constraintset")) {
                                    c = 0;
                                    break;
                                }
                                break;
                        }
                        if (c == 0) {
                            return;
                        }
                        if (c == 1 || c == 2 || c == 3) {
                            this.f3190e.put(Integer.valueOf(constraint.f3191a), constraint);
                            constraint = null;
                        }
                    }
                } else {
                    xmlPullParser.getName();
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e) {
            Log.e("ConstraintSet", "Error parsing XML resource", e);
        } catch (XmlPullParserException e2) {
            Log.e("ConstraintSet", "Error parsing XML resource", e2);
        }
    }

    public void readFallback(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f3189d && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            HashMap hashMap = this.f3190e;
            if (!hashMap.containsKey(Integer.valueOf(id))) {
                hashMap.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = (Constraint) hashMap.get(Integer.valueOf(id));
            if (constraint != null) {
                if (!constraint.layout.mApply) {
                    constraint.m653a(id, layoutParams);
                    if (childAt instanceof ConstraintHelper) {
                        constraint.layout.mReferenceIds = ((ConstraintHelper) childAt).getReferencedIds();
                        if (childAt instanceof Barrier) {
                            Barrier barrier = (Barrier) childAt;
                            constraint.layout.mBarrierAllowsGoneWidgets = barrier.getAllowsGoneWidget();
                            constraint.layout.mBarrierDirection = barrier.getType();
                            constraint.layout.mBarrierMargin = barrier.getMargin();
                        }
                    }
                    constraint.layout.mApply = true;
                }
                PropertySet propertySet = constraint.propertySet;
                if (!propertySet.mApply) {
                    propertySet.visibility = childAt.getVisibility();
                    constraint.propertySet.alpha = childAt.getAlpha();
                    constraint.propertySet.mApply = true;
                }
                Transform transform = constraint.transform;
                if (!transform.mApply) {
                    transform.mApply = true;
                    transform.rotation = childAt.getRotation();
                    constraint.transform.rotationX = childAt.getRotationX();
                    constraint.transform.rotationY = childAt.getRotationY();
                    constraint.transform.scaleX = childAt.getScaleX();
                    constraint.transform.scaleY = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (pivotX != 0.0d || pivotY != 0.0d) {
                        Transform transform2 = constraint.transform;
                        transform2.transformPivotX = pivotX;
                        transform2.transformPivotY = pivotY;
                    }
                    constraint.transform.translationX = childAt.getTranslationX();
                    constraint.transform.translationY = childAt.getTranslationY();
                    constraint.transform.translationZ = childAt.getTranslationZ();
                    Transform transform3 = constraint.transform;
                    if (transform3.applyElevation) {
                        transform3.elevation = childAt.getElevation();
                    }
                }
            }
        }
    }

    public void clone(Constraints constraints) {
        int childCount = constraints.getChildCount();
        HashMap hashMap = this.f3190e;
        hashMap.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraints.getChildAt(i);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.f3189d && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!hashMap.containsKey(Integer.valueOf(id))) {
                hashMap.put(Integer.valueOf(id), new Constraint());
            }
            Constraint constraint = (Constraint) hashMap.get(Integer.valueOf(id));
            if (constraint != null) {
                if (childAt instanceof ConstraintHelper) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) childAt;
                    constraint.m654b(id, layoutParams);
                    if (constraintHelper instanceof Barrier) {
                        Layout layout = constraint.layout;
                        layout.mHelperType = 1;
                        Barrier barrier = (Barrier) constraintHelper;
                        layout.mBarrierDirection = barrier.getType();
                        constraint.layout.mReferenceIds = barrier.getReferencedIds();
                        constraint.layout.mBarrierMargin = barrier.getMargin();
                    }
                }
                constraint.m654b(id, layoutParams);
            }
        }
    }

    public void connect(int i, int i2, int i3, int i4) {
        HashMap hashMap = this.f3190e;
        if (!hashMap.containsKey(Integer.valueOf(i))) {
            hashMap.put(Integer.valueOf(i), new Constraint());
        }
        Constraint constraint = (Constraint) hashMap.get(Integer.valueOf(i));
        if (constraint == null) {
            return;
        }
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    Layout layout = constraint.layout;
                    layout.leftToLeft = i3;
                    layout.leftToRight = -1;
                    return;
                } else if (i4 == 2) {
                    Layout layout2 = constraint.layout;
                    layout2.leftToRight = i3;
                    layout2.leftToLeft = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + m648k(i4) + " undefined");
                }
            case 2:
                if (i4 == 1) {
                    Layout layout3 = constraint.layout;
                    layout3.rightToLeft = i3;
                    layout3.rightToRight = -1;
                    return;
                } else {
                    if (i4 != 2) {
                        throw new IllegalArgumentException("right to " + m648k(i4) + " undefined");
                    }
                    Layout layout4 = constraint.layout;
                    layout4.rightToRight = i3;
                    layout4.rightToLeft = -1;
                    return;
                }
            case 3:
                if (i4 == 3) {
                    Layout layout5 = constraint.layout;
                    layout5.topToTop = i3;
                    layout5.topToBottom = -1;
                    layout5.baselineToBaseline = -1;
                    layout5.baselineToTop = -1;
                    layout5.baselineToBottom = -1;
                    return;
                }
                if (i4 != 4) {
                    throw new IllegalArgumentException("right to " + m648k(i4) + " undefined");
                }
                Layout layout6 = constraint.layout;
                layout6.topToBottom = i3;
                layout6.topToTop = -1;
                layout6.baselineToBaseline = -1;
                layout6.baselineToTop = -1;
                layout6.baselineToBottom = -1;
                return;
            case 4:
                if (i4 == 4) {
                    Layout layout7 = constraint.layout;
                    layout7.bottomToBottom = i3;
                    layout7.bottomToTop = -1;
                    layout7.baselineToBaseline = -1;
                    layout7.baselineToTop = -1;
                    layout7.baselineToBottom = -1;
                    return;
                }
                if (i4 != 3) {
                    throw new IllegalArgumentException("right to " + m648k(i4) + " undefined");
                }
                Layout layout8 = constraint.layout;
                layout8.bottomToTop = i3;
                layout8.bottomToBottom = -1;
                layout8.baselineToBaseline = -1;
                layout8.baselineToTop = -1;
                layout8.baselineToBottom = -1;
                return;
            case 5:
                if (i4 == 5) {
                    Layout layout9 = constraint.layout;
                    layout9.baselineToBaseline = i3;
                    layout9.bottomToBottom = -1;
                    layout9.bottomToTop = -1;
                    layout9.topToTop = -1;
                    layout9.topToBottom = -1;
                    return;
                }
                if (i4 == 3) {
                    Layout layout10 = constraint.layout;
                    layout10.baselineToTop = i3;
                    layout10.bottomToBottom = -1;
                    layout10.bottomToTop = -1;
                    layout10.topToTop = -1;
                    layout10.topToBottom = -1;
                    return;
                }
                if (i4 != 4) {
                    throw new IllegalArgumentException("right to " + m648k(i4) + " undefined");
                }
                Layout layout11 = constraint.layout;
                layout11.baselineToBottom = i3;
                layout11.bottomToBottom = -1;
                layout11.bottomToTop = -1;
                layout11.topToTop = -1;
                layout11.topToBottom = -1;
                return;
            case 6:
                if (i4 == 6) {
                    Layout layout12 = constraint.layout;
                    layout12.startToStart = i3;
                    layout12.startToEnd = -1;
                    return;
                } else {
                    if (i4 != 7) {
                        throw new IllegalArgumentException("right to " + m648k(i4) + " undefined");
                    }
                    Layout layout13 = constraint.layout;
                    layout13.startToEnd = i3;
                    layout13.startToStart = -1;
                    return;
                }
            case 7:
                if (i4 == 7) {
                    Layout layout14 = constraint.layout;
                    layout14.endToEnd = i3;
                    layout14.endToStart = -1;
                    return;
                } else {
                    if (i4 != 6) {
                        throw new IllegalArgumentException("right to " + m648k(i4) + " undefined");
                    }
                    Layout layout15 = constraint.layout;
                    layout15.endToStart = i3;
                    layout15.endToEnd = -1;
                    return;
                }
            default:
                throw new IllegalArgumentException(m648k(i2) + " to " + m648k(i4) + " unknown");
        }
    }
}
