package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    public static final int DESIGN_INFO_ID = 0;
    public static final String VERSION = "ConstraintLayout-2.2.0-alpha04";

    /* renamed from: q */
    public static SharedValues f3138q;

    /* renamed from: a */
    public final SparseArray f3139a;

    /* renamed from: b */
    public final ArrayList f3140b;

    /* renamed from: c */
    public int f3141c;

    /* renamed from: d */
    public int f3142d;

    /* renamed from: e */
    public int f3143e;

    /* renamed from: f */
    public int f3144f;

    /* renamed from: g */
    public int f3145g;

    /* renamed from: h */
    public ConstraintSet f3146h;

    /* renamed from: i */
    public int f3147i;

    /* renamed from: j */
    public HashMap f3148j;

    /* renamed from: k */
    public int f3149k;

    /* renamed from: l */
    public int f3150l;

    /* renamed from: m */
    public final SparseArray f3151m;
    protected ConstraintLayoutStates mConstraintLayoutSpec;
    protected boolean mDirtyHierarchy;
    protected ConstraintWidgetContainer mLayoutWidget;

    /* renamed from: n */
    public Metrics f3152n;

    /* renamed from: o */
    public final C0130b f3153o;

    /* renamed from: p */
    public ArrayList f3154p;

    /* loaded from: classes.dex */
    public interface ValueModifier {
        boolean update(int i, int i2, int i3, View view, LayoutParams layoutParams);
    }

    public ConstraintLayout(@NonNull Context context) {
        super(context);
        this.f3139a = new SparseArray();
        this.f3140b = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.f3141c = 0;
        this.f3142d = 0;
        this.f3143e = Integer.MAX_VALUE;
        this.f3144f = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.f3145g = 257;
        this.f3146h = null;
        this.mConstraintLayoutSpec = null;
        this.f3147i = -1;
        this.f3148j = new HashMap();
        this.f3149k = -1;
        this.f3150l = -1;
        this.f3151m = new SparseArray();
        this.f3153o = new C0130b(this, this);
        m631a(null, 0, 0);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int max2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        if (max2 > 0) {
            return max2;
        }
        return max;
    }

    public static SharedValues getSharedValues() {
        if (f3138q == null) {
            f3138q = new SharedValues();
        }
        return f3138q;
    }

    /* renamed from: a */
    public final void m631a(AttributeSet attributeSet, int i, int i2) {
        this.mLayoutWidget.setCompanionWidget(this);
        this.mLayoutWidget.setMeasurer(this.f3153o);
        this.f3139a.put(getId(), this);
        this.f3146h = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout, i, i2);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.f3141c = obtainStyledAttributes.getDimensionPixelOffset(index, this.f3141c);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.f3142d = obtainStyledAttributes.getDimensionPixelOffset(index, this.f3142d);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.f3143e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f3143e);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.f3144f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f3144f);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f3145g = obtainStyledAttributes.getInt(index, this.f3145g);
                } else if (index == R.styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f3146h = constraintSet;
                        constraintSet.load(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f3146h = null;
                    }
                    this.f3147i = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.setOptimizationLevel(this.f3145g);
    }

    public void addValueModifier(ValueModifier valueModifier) {
        if (this.f3154p == null) {
            this.f3154p = new ArrayList();
        }
        this.f3154p.add(valueModifier);
    }

    public void applyConstraintsFromLayoutParams(boolean z, View view, ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        int i;
        layoutParams.validate();
        layoutParams.helped = false;
        constraintWidget.setVisibility(view.getVisibility());
        if (layoutParams.f3160f) {
            constraintWidget.setInPlaceholder(true);
            constraintWidget.setVisibility(8);
        }
        constraintWidget.setCompanionWidget(view);
        if (view instanceof ConstraintHelper) {
            ((ConstraintHelper) view).resolveRtl(constraintWidget, this.mLayoutWidget.isRtl());
        }
        if (layoutParams.f3158d) {
            androidx.constraintlayout.core.widgets.Guideline guideline = (androidx.constraintlayout.core.widgets.Guideline) constraintWidget;
            int i2 = layoutParams.f3168n;
            int i3 = layoutParams.f3169o;
            float f = layoutParams.f3170p;
            if (f != -1.0f) {
                guideline.setGuidePercent(f);
                return;
            } else if (i2 != -1) {
                guideline.setGuideBegin(i2);
                return;
            } else {
                if (i3 != -1) {
                    guideline.setGuideEnd(i3);
                    return;
                }
                return;
            }
        }
        int i4 = layoutParams.f3161g;
        int i5 = layoutParams.f3162h;
        int i6 = layoutParams.f3163i;
        int i7 = layoutParams.f3164j;
        int i8 = layoutParams.f3165k;
        int i9 = layoutParams.f3166l;
        float f2 = layoutParams.f3167m;
        int i10 = layoutParams.circleConstraint;
        if (i10 != -1) {
            ConstraintWidget constraintWidget6 = sparseArray.get(i10);
            if (constraintWidget6 != null) {
                constraintWidget.connectCircularConstraint(constraintWidget6, layoutParams.circleAngle, layoutParams.circleRadius);
            }
        } else {
            if (i4 != -1) {
                ConstraintWidget constraintWidget7 = sparseArray.get(i4);
                if (constraintWidget7 != null) {
                    ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                    constraintWidget.immediateConnect(type, constraintWidget7, type, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i8);
                }
            } else if (i5 != -1 && (constraintWidget2 = sparseArray.get(i5)) != null) {
                constraintWidget.immediateConnect(ConstraintAnchor.Type.LEFT, constraintWidget2, ConstraintAnchor.Type.RIGHT, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i8);
            }
            if (i6 != -1) {
                ConstraintWidget constraintWidget8 = sparseArray.get(i6);
                if (constraintWidget8 != null) {
                    constraintWidget.immediateConnect(ConstraintAnchor.Type.RIGHT, constraintWidget8, ConstraintAnchor.Type.LEFT, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i9);
                }
            } else if (i7 != -1 && (constraintWidget3 = sparseArray.get(i7)) != null) {
                ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                constraintWidget.immediateConnect(type2, constraintWidget3, type2, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, i9);
            }
            int i11 = layoutParams.topToTop;
            if (i11 != -1) {
                ConstraintWidget constraintWidget9 = sparseArray.get(i11);
                if (constraintWidget9 != null) {
                    ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
                    constraintWidget.immediateConnect(type3, constraintWidget9, type3, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.goneTopMargin);
                }
            } else {
                int i12 = layoutParams.topToBottom;
                if (i12 != -1 && (constraintWidget4 = sparseArray.get(i12)) != null) {
                    constraintWidget.immediateConnect(ConstraintAnchor.Type.TOP, constraintWidget4, ConstraintAnchor.Type.BOTTOM, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, layoutParams.goneTopMargin);
                }
            }
            int i13 = layoutParams.bottomToTop;
            if (i13 != -1) {
                ConstraintWidget constraintWidget10 = sparseArray.get(i13);
                if (constraintWidget10 != null) {
                    constraintWidget.immediateConnect(ConstraintAnchor.Type.BOTTOM, constraintWidget10, ConstraintAnchor.Type.TOP, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.goneBottomMargin);
                }
            } else {
                int i14 = layoutParams.bottomToBottom;
                if (i14 != -1 && (constraintWidget5 = sparseArray.get(i14)) != null) {
                    ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
                    constraintWidget.immediateConnect(type4, constraintWidget5, type4, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutParams.goneBottomMargin);
                }
            }
            int i15 = layoutParams.baselineToBaseline;
            if (i15 != -1) {
                m632b(constraintWidget, layoutParams, sparseArray, i15, ConstraintAnchor.Type.BASELINE);
            } else {
                int i16 = layoutParams.baselineToTop;
                if (i16 != -1) {
                    m632b(constraintWidget, layoutParams, sparseArray, i16, ConstraintAnchor.Type.TOP);
                } else {
                    int i17 = layoutParams.baselineToBottom;
                    if (i17 != -1) {
                        m632b(constraintWidget, layoutParams, sparseArray, i17, ConstraintAnchor.Type.BOTTOM);
                    }
                }
            }
            if (f2 >= RecyclerView.f7068F0) {
                constraintWidget.setHorizontalBiasPercent(f2);
            }
            float f3 = layoutParams.verticalBias;
            if (f3 >= RecyclerView.f7068F0) {
                constraintWidget.setVerticalBiasPercent(f3);
            }
        }
        if (z && ((i = layoutParams.editorAbsoluteX) != -1 || layoutParams.editorAbsoluteY != -1)) {
            constraintWidget.setOrigin(i, layoutParams.editorAbsoluteY);
        }
        if (!layoutParams.f3155a) {
            if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
                if (layoutParams.constrainedWidth) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                } else {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                }
                constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            } else {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                constraintWidget.setWidth(0);
            }
        } else {
            constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidget.setWidth(((ViewGroup.MarginLayoutParams) layoutParams).width);
            if (((ViewGroup.MarginLayoutParams) layoutParams).width == -2) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            }
        }
        if (!layoutParams.f3156b) {
            if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                if (layoutParams.constrainedHeight) {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                } else {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                }
                constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).mMargin = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            } else {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                constraintWidget.setHeight(0);
            }
        } else {
            constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidget.setHeight(((ViewGroup.MarginLayoutParams) layoutParams).height);
            if (((ViewGroup.MarginLayoutParams) layoutParams).height == -2) {
                constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            }
        }
        constraintWidget.setDimensionRatio(layoutParams.dimensionRatio);
        constraintWidget.setHorizontalWeight(layoutParams.horizontalWeight);
        constraintWidget.setVerticalWeight(layoutParams.verticalWeight);
        constraintWidget.setHorizontalChainStyle(layoutParams.horizontalChainStyle);
        constraintWidget.setVerticalChainStyle(layoutParams.verticalChainStyle);
        constraintWidget.setWrapBehaviorInParent(layoutParams.wrapBehaviorInParent);
        constraintWidget.setHorizontalMatchStyle(layoutParams.matchConstraintDefaultWidth, layoutParams.matchConstraintMinWidth, layoutParams.matchConstraintMaxWidth, layoutParams.matchConstraintPercentWidth);
        constraintWidget.setVerticalMatchStyle(layoutParams.matchConstraintDefaultHeight, layoutParams.matchConstraintMinHeight, layoutParams.matchConstraintMaxHeight, layoutParams.matchConstraintPercentHeight);
    }

    /* renamed from: b */
    public final void m632b(ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray sparseArray, int i, ConstraintAnchor.Type type) {
        View view = (View) this.f3139a.get(i);
        ConstraintWidget constraintWidget2 = (ConstraintWidget) sparseArray.get(i);
        if (constraintWidget2 != null && view != null && (view.getLayoutParams() instanceof LayoutParams)) {
            layoutParams.f3157c = true;
            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.BASELINE;
            if (type == type2) {
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                layoutParams2.f3157c = true;
                layoutParams2.f3171q.setHasBaseline(true);
            }
            constraintWidget.getAnchor(type2).connect(constraintWidget2.getAnchor(type), layoutParams.baselineMargin, layoutParams.goneBaselineMargin, true);
            constraintWidget.setHasBaseline(true);
            constraintWidget.getAnchor(ConstraintAnchor.Type.TOP).reset();
            constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).reset();
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.f3140b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                ((ConstraintHelper) arrayList.get(i)).updatePreDraw(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i3 = (int) ((parseInt / 1080.0f) * width);
                        int i4 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(SupportMenu.CATEGORY_MASK);
                        float f = i3;
                        float f2 = i4;
                        float f3 = i3 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float parseInt4 = i4 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f3, f2, f3, parseInt4, paint);
                        canvas.drawLine(f3, parseInt4, f, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f3, f2, paint);
                    }
                }
            }
        }
    }

    public boolean dynamicUpdateConstraints(int i, int i2) {
        boolean z = false;
        if (this.f3154p == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Iterator it = this.f3154p.iterator();
        while (it.hasNext()) {
            ValueModifier valueModifier = (ValueModifier) it.next();
            Iterator<ConstraintWidget> it2 = this.mLayoutWidget.getChildren().iterator();
            while (it2.hasNext()) {
                View view = (View) it2.next().getCompanionWidget();
                z |= valueModifier.update(size, size2, view.getId(), view, (LayoutParams) view.getLayoutParams());
            }
        }
        return z;
    }

    public void fillMetrics(Metrics metrics) {
        this.f3152n = metrics;
        this.mLayoutWidget.fillMetrics(metrics);
    }

    @Override // android.view.View
    public void forceLayout() {
        this.mDirtyHierarchy = true;
        this.f3149k = -1;
        this.f3150l = -1;
        super.forceLayout();
    }

    public Object getDesignInformation(int i, Object obj) {
        if (i == 0 && (obj instanceof String)) {
            String str = (String) obj;
            HashMap hashMap = this.f3148j;
            if (hashMap != null && hashMap.containsKey(str)) {
                return this.f3148j.get(str);
            }
            return null;
        }
        return null;
    }

    public int getMaxHeight() {
        return this.f3144f;
    }

    public int getMaxWidth() {
        return this.f3143e;
    }

    public int getMinHeight() {
        return this.f3142d;
    }

    public int getMinWidth() {
        return this.f3141c;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        if (this.mLayoutWidget.stringId == null) {
            int id2 = getId();
            if (id2 != -1) {
                this.mLayoutWidget.stringId = getContext().getResources().getResourceEntryName(id2);
            } else {
                this.mLayoutWidget.stringId = "parent";
            }
        }
        if (this.mLayoutWidget.getDebugName() == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
            constraintWidgetContainer.setDebugName(constraintWidgetContainer.stringId);
            Log.v("ConstraintLayout", " setDebugName " + this.mLayoutWidget.getDebugName());
        }
        Iterator<ConstraintWidget> it = this.mLayoutWidget.getChildren().iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            View view = (View) next.getCompanionWidget();
            if (view != null) {
                if (next.stringId == null && (id = view.getId()) != -1) {
                    next.stringId = getContext().getResources().getResourceEntryName(id);
                }
                if (next.getDebugName() == null) {
                    next.setDebugName(next.stringId);
                    Log.v("ConstraintLayout", " setDebugName " + next.getDebugName());
                }
            }
        }
        this.mLayoutWidget.getSceneString(sb);
        return sb.toString();
    }

    public View getViewById(int i) {
        return (View) this.f3139a.get(i);
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view != null) {
            if (view.getLayoutParams() instanceof LayoutParams) {
                return ((LayoutParams) view.getLayoutParams()).f3171q;
            }
            view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
            if (view.getLayoutParams() instanceof LayoutParams) {
                return ((LayoutParams) view.getLayoutParams()).f3171q;
            }
            return null;
        }
        return null;
    }

    public boolean isRtl() {
        if ((getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection()) {
            return true;
        }
        return false;
    }

    public void loadLayoutDescription(int i) {
        if (i != 0) {
            try {
                this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i);
                return;
            } catch (Resources.NotFoundException unused) {
                this.mConstraintLayoutSpec = null;
                return;
            }
        }
        this.mConstraintLayoutSpec = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        Metrics metrics = this.f3152n;
        if (metrics != null) {
            metrics.mNumberOfLayouts++;
        }
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.f3171q;
            if ((childAt.getVisibility() != 8 || layoutParams.f3158d || layoutParams.f3159e || isInEditMode) && !layoutParams.f3160f) {
                int x = constraintWidget.getX();
                int y = constraintWidget.getY();
                int width = constraintWidget.getWidth() + x;
                int height = constraintWidget.getHeight() + y;
                childAt.layout(x, y, width, height);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(x, y, width, height);
                }
            }
        }
        ArrayList arrayList = this.f3140b;
        int size = arrayList.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                ((ConstraintHelper) arrayList.get(i6)).updatePostLayout(this);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        long j;
        boolean z;
        ConstraintWidget constraintWidget;
        if (this.f3152n != null) {
            j = System.nanoTime();
            this.f3152n.mChildCount = getChildCount();
            this.f3152n.mMeasureCalls++;
        } else {
            j = 0;
        }
        boolean dynamicUpdateConstraints = this.mDirtyHierarchy | dynamicUpdateConstraints(i, i2);
        this.mDirtyHierarchy = dynamicUpdateConstraints;
        if (!dynamicUpdateConstraints) {
            int childCount = getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                if (getChildAt(i3).isLayoutRequested()) {
                    this.mDirtyHierarchy = true;
                    break;
                }
                i3++;
            }
        }
        this.mLayoutWidget.setRtl(isRtl());
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            int childCount2 = getChildCount();
            int i4 = 0;
            while (true) {
                if (i4 < childCount2) {
                    if (getChildAt(i4).isLayoutRequested()) {
                        z = true;
                        break;
                    }
                    i4++;
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                boolean isInEditMode = isInEditMode();
                int childCount3 = getChildCount();
                for (int i5 = 0; i5 < childCount3; i5++) {
                    ConstraintWidget viewWidget = getViewWidget(getChildAt(i5));
                    if (viewWidget != null) {
                        viewWidget.reset();
                    }
                }
                if (isInEditMode) {
                    for (int i6 = 0; i6 < childCount3; i6++) {
                        View childAt = getChildAt(i6);
                        try {
                            String resourceName = getResources().getResourceName(childAt.getId());
                            setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                            int indexOf = resourceName.indexOf(47);
                            if (indexOf != -1) {
                                resourceName = resourceName.substring(indexOf + 1);
                            }
                            int id = childAt.getId();
                            if (id == 0) {
                                constraintWidget = this.mLayoutWidget;
                            } else {
                                View view = (View) this.f3139a.get(id);
                                if (view == null && (view = findViewById(id)) != null && view != this && view.getParent() == this) {
                                    onViewAdded(view);
                                }
                                if (view == this) {
                                    constraintWidget = this.mLayoutWidget;
                                } else if (view == null) {
                                    constraintWidget = null;
                                } else {
                                    constraintWidget = ((LayoutParams) view.getLayoutParams()).f3171q;
                                }
                            }
                            constraintWidget.setDebugName(resourceName);
                        } catch (Resources.NotFoundException unused) {
                        }
                    }
                }
                if (this.f3147i != -1) {
                    for (int i7 = 0; i7 < childCount3; i7++) {
                        View childAt2 = getChildAt(i7);
                        if (childAt2.getId() == this.f3147i && (childAt2 instanceof Constraints)) {
                            this.f3146h = ((Constraints) childAt2).getConstraintSet();
                        }
                    }
                }
                ConstraintSet constraintSet = this.f3146h;
                if (constraintSet != null) {
                    constraintSet.m650b(this, true);
                }
                this.mLayoutWidget.removeAllChildren();
                ArrayList arrayList = this.f3140b;
                int size = arrayList.size();
                if (size > 0) {
                    for (int i8 = 0; i8 < size; i8++) {
                        ((ConstraintHelper) arrayList.get(i8)).updatePreLayout(this);
                    }
                }
                for (int i9 = 0; i9 < childCount3; i9++) {
                    View childAt3 = getChildAt(i9);
                    if (childAt3 instanceof Placeholder) {
                        ((Placeholder) childAt3).updatePreLayout(this);
                    }
                }
                SparseArray<ConstraintWidget> sparseArray = this.f3151m;
                sparseArray.clear();
                sparseArray.put(0, this.mLayoutWidget);
                sparseArray.put(getId(), this.mLayoutWidget);
                for (int i10 = 0; i10 < childCount3; i10++) {
                    View childAt4 = getChildAt(i10);
                    sparseArray.put(childAt4.getId(), getViewWidget(childAt4));
                }
                for (int i11 = 0; i11 < childCount3; i11++) {
                    View childAt5 = getChildAt(i11);
                    ConstraintWidget viewWidget2 = getViewWidget(childAt5);
                    if (viewWidget2 != null) {
                        LayoutParams layoutParams = (LayoutParams) childAt5.getLayoutParams();
                        this.mLayoutWidget.add(viewWidget2);
                        applyConstraintsFromLayoutParams(isInEditMode, childAt5, viewWidget2, layoutParams, sparseArray);
                    }
                }
            }
            if (z) {
                this.mLayoutWidget.updateHierarchy();
            }
        }
        this.mLayoutWidget.fillMetrics(this.f3152n);
        resolveSystem(this.mLayoutWidget, this.f3145g, i, i2);
        resolveMeasuredDimension(i, i2, this.mLayoutWidget.getWidth(), this.mLayoutWidget.getHeight(), this.mLayoutWidget.isWidthMeasuredTooSmall(), this.mLayoutWidget.isHeightMeasuredTooSmall());
        Metrics metrics = this.f3152n;
        if (metrics != null) {
            metrics.mMeasureDuration = (System.nanoTime() - j) + metrics.mMeasureDuration;
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof androidx.constraintlayout.core.widgets.Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            androidx.constraintlayout.core.widgets.Guideline guideline = new androidx.constraintlayout.core.widgets.Guideline();
            layoutParams.f3171q = guideline;
            layoutParams.f3158d = true;
            guideline.setOrientation(layoutParams.orientation);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.validateParams();
            ((LayoutParams) view.getLayoutParams()).f3159e = true;
            ArrayList arrayList = this.f3140b;
            if (!arrayList.contains(constraintHelper)) {
                arrayList.add(constraintHelper);
            }
        }
        this.f3139a.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f3139a.remove(view.getId());
        this.mLayoutWidget.remove(getViewWidget(view));
        this.f3140b.remove(view);
        this.mDirtyHierarchy = true;
    }

    public void parseLayoutDescription(int i) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.mDirtyHierarchy = true;
        this.f3149k = -1;
        this.f3150l = -1;
        super.requestLayout();
    }

    public void resolveMeasuredDimension(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        C0130b c0130b = this.f3153o;
        int i5 = c0130b.f3219e;
        int resolveSizeAndState = View.resolveSizeAndState(i3 + c0130b.f3218d, i, 0);
        int resolveSizeAndState2 = View.resolveSizeAndState(i4 + i5, i2, 0);
        int i6 = resolveSizeAndState & ViewCompat.MEASURED_SIZE_MASK;
        int i7 = resolveSizeAndState2 & ViewCompat.MEASURED_SIZE_MASK;
        int min = Math.min(this.f3143e, i6);
        int min2 = Math.min(this.f3144f, i7);
        if (z) {
            min |= 16777216;
        }
        if (z2) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.f3149k = min;
        this.f3150l = min2;
    }

    public void resolveSystem(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2, int i3) {
        int i4;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i5 = max + max2;
        int paddingWidth = getPaddingWidth();
        C0130b c0130b = this.f3153o;
        c0130b.f3216b = max;
        c0130b.f3217c = max2;
        c0130b.f3218d = paddingWidth;
        c0130b.f3219e = i5;
        c0130b.f3220f = i2;
        c0130b.f3221g = i3;
        int max3 = Math.max(0, getPaddingStart());
        int max4 = Math.max(0, getPaddingEnd());
        if (max3 <= 0 && max4 <= 0) {
            max3 = Math.max(0, getPaddingLeft());
        } else if (isRtl()) {
            i4 = max4;
            int i6 = size - paddingWidth;
            int i7 = size2 - i5;
            setSelfDimensionBehaviour(constraintWidgetContainer, mode, i6, mode2, i7);
            constraintWidgetContainer.measure(i, mode, i6, mode2, i7, this.f3149k, this.f3150l, i4, max);
        }
        i4 = max3;
        int i62 = size - paddingWidth;
        int i72 = size2 - i5;
        setSelfDimensionBehaviour(constraintWidgetContainer, mode, i62, mode2, i72);
        constraintWidgetContainer.measure(i, mode, i62, mode2, i72, this.f3149k, this.f3150l, i4, max);
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.f3146h = constraintSet;
    }

    public void setDesignInformation(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f3148j == null) {
                this.f3148j = new HashMap();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.f3148j.put(str, num);
        }
    }

    @Override // android.view.View
    public void setId(int i) {
        int id = getId();
        SparseArray sparseArray = this.f3139a;
        sparseArray.remove(id);
        super.setId(i);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.f3144f) {
            return;
        }
        this.f3144f = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.f3143e) {
            return;
        }
        this.f3143e = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.f3142d) {
            return;
        }
        this.f3142d = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.f3141c) {
            return;
        }
        this.f3141c = i;
        requestLayout();
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.setOnConstraintsChanged(constraintsChangedListener);
        }
    }

    public void setOptimizationLevel(int i) {
        this.f3145g = i;
        this.mLayoutWidget.setOptimizationLevel(i);
    }

    public void setSelfDimensionBehaviour(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2, int i3, int i4) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        C0130b c0130b = this.f3153o;
        int i5 = c0130b.f3219e;
        int i6 = c0130b.f3218d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        int childCount = getChildCount();
        if (i != Integer.MIN_VALUE) {
            if (i != 0) {
                if (i != 1073741824) {
                    dimensionBehaviour = dimensionBehaviour2;
                    i2 = 0;
                } else {
                    i2 = Math.min(this.f3143e - i6, i2);
                    dimensionBehaviour = dimensionBehaviour2;
                }
            } else {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i2 = Math.max(0, this.f3141c);
                }
                i2 = 0;
            }
        } else {
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i2 = Math.max(0, this.f3141c);
            }
        }
        if (i3 != Integer.MIN_VALUE) {
            if (i3 != 0) {
                if (i3 == 1073741824) {
                    i4 = Math.min(this.f3144f - i5, i4);
                }
                i4 = 0;
            } else {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i4 = Math.max(0, this.f3142d);
                }
                i4 = 0;
            }
        } else {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i4 = Math.max(0, this.f3142d);
            }
        }
        if (i2 != constraintWidgetContainer.getWidth() || i4 != constraintWidgetContainer.getHeight()) {
            constraintWidgetContainer.invalidateMeasures();
        }
        constraintWidgetContainer.setX(0);
        constraintWidgetContainer.setY(0);
        constraintWidgetContainer.setMaxWidth(this.f3143e - i6);
        constraintWidgetContainer.setMaxHeight(this.f3144f - i5);
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setHorizontalDimensionBehaviour(dimensionBehaviour);
        constraintWidgetContainer.setWidth(i2);
        constraintWidgetContainer.setVerticalDimensionBehaviour(dimensionBehaviour2);
        constraintWidgetContainer.setHeight(i4);
        constraintWidgetContainer.setMinWidth(this.f3141c - i6);
        constraintWidgetContainer.setMinHeight(this.f3142d - i5);
    }

    public void setState(int i, int i2, int i3) {
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.updateConstraints(i, i2, i3);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3139a = new SparseArray();
        this.f3140b = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.f3141c = 0;
        this.f3142d = 0;
        this.f3143e = Integer.MAX_VALUE;
        this.f3144f = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.f3145g = 257;
        this.f3146h = null;
        this.mConstraintLayoutSpec = null;
        this.f3147i = -1;
        this.f3148j = new HashMap();
        this.f3149k = -1;
        this.f3150l = -1;
        this.f3151m = new SparseArray();
        this.f3153o = new C0130b(this, this);
        m631a(attributeSet, 0, 0);
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3139a = new SparseArray();
        this.f3140b = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.f3141c = 0;
        this.f3142d = 0;
        this.f3143e = Integer.MAX_VALUE;
        this.f3144f = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.f3145g = 257;
        this.f3146h = null;
        this.mConstraintLayoutSpec = null;
        this.f3147i = -1;
        this.f3148j = new HashMap();
        this.f3149k = -1;
        this.f3150l = -1;
        this.f3151m = new SparseArray();
        this.f3153o = new C0130b(this, this);
        m631a(attributeSet, i, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3139a = new SparseArray();
        this.f3140b = new ArrayList(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.f3141c = 0;
        this.f3142d = 0;
        this.f3143e = Integer.MAX_VALUE;
        this.f3144f = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.f3145g = 257;
        this.f3146h = null;
        this.mConstraintLayoutSpec = null;
        this.f3147i = -1;
        this.f3148j = new HashMap();
        this.f3149k = -1;
        this.f3150l = -1;
        this.f3151m = new SparseArray();
        this.f3153o = new C0130b(this, this);
        m631a(attributeSet, i, i2);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int BASELINE = 5;
        public static final int BOTTOM = 4;
        public static final int CHAIN_PACKED = 2;
        public static final int CHAIN_SPREAD = 0;
        public static final int CHAIN_SPREAD_INSIDE = 1;
        public static final int CIRCLE = 8;
        public static final int END = 7;
        public static final int GONE_UNSET = Integer.MIN_VALUE;
        public static final int HORIZONTAL = 0;
        public static final int LEFT = 1;
        public static final int MATCH_CONSTRAINT = 0;
        public static final int MATCH_CONSTRAINT_PERCENT = 2;
        public static final int MATCH_CONSTRAINT_SPREAD = 0;
        public static final int MATCH_CONSTRAINT_WRAP = 1;
        public static final int PARENT_ID = 0;
        public static final int RIGHT = 2;
        public static final int START = 6;
        public static final int TOP = 3;
        public static final int UNSET = -1;
        public static final int VERTICAL = 1;
        public static final int WRAP_BEHAVIOR_HORIZONTAL_ONLY = 1;
        public static final int WRAP_BEHAVIOR_INCLUDED = 0;
        public static final int WRAP_BEHAVIOR_SKIPPED = 3;
        public static final int WRAP_BEHAVIOR_VERTICAL_ONLY = 2;

        /* renamed from: a */
        public boolean f3155a;

        /* renamed from: b */
        public boolean f3156b;
        public int baselineMargin;
        public int baselineToBaseline;
        public int baselineToBottom;
        public int baselineToTop;
        public int bottomToBottom;
        public int bottomToTop;

        /* renamed from: c */
        public boolean f3157c;
        public float circleAngle;
        public int circleConstraint;
        public int circleRadius;
        public boolean constrainedHeight;
        public boolean constrainedWidth;
        public String constraintTag;

        /* renamed from: d */
        public boolean f3158d;
        public String dimensionRatio;

        /* renamed from: e */
        public boolean f3159e;
        public int editorAbsoluteX;
        public int editorAbsoluteY;
        public int endToEnd;
        public int endToStart;

        /* renamed from: f */
        public boolean f3160f;

        /* renamed from: g */
        public int f3161g;
        public int goneBaselineMargin;
        public int goneBottomMargin;
        public int goneEndMargin;
        public int goneLeftMargin;
        public int goneRightMargin;
        public int goneStartMargin;
        public int goneTopMargin;
        public int guideBegin;
        public int guideEnd;
        public float guidePercent;
        public boolean guidelineUseRtl;

        /* renamed from: h */
        public int f3162h;
        public boolean helped;
        public float horizontalBias;
        public int horizontalChainStyle;
        public float horizontalWeight;

        /* renamed from: i */
        public int f3163i;

        /* renamed from: j */
        public int f3164j;

        /* renamed from: k */
        public int f3165k;

        /* renamed from: l */
        public int f3166l;
        public int leftToLeft;
        public int leftToRight;

        /* renamed from: m */
        public float f3167m;
        public int matchConstraintDefaultHeight;
        public int matchConstraintDefaultWidth;
        public int matchConstraintMaxHeight;
        public int matchConstraintMaxWidth;
        public int matchConstraintMinHeight;
        public int matchConstraintMinWidth;
        public float matchConstraintPercentHeight;
        public float matchConstraintPercentWidth;

        /* renamed from: n */
        public int f3168n;

        /* renamed from: o */
        public int f3169o;
        public int orientation;

        /* renamed from: p */
        public float f3170p;

        /* renamed from: q */
        public ConstraintWidget f3171q;
        public int rightToLeft;
        public int rightToRight;
        public int startToEnd;
        public int startToStart;
        public int topToBottom;
        public int topToTop;
        public float verticalBias;
        public int verticalChainStyle;
        public float verticalWeight;
        public int wrapBehaviorInParent;

        @SuppressLint({"ClassVerificationFailure"})
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.guidelineUseRtl = true;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.baselineToTop = -1;
            this.baselineToBottom = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = RecyclerView.f7068F0;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = Integer.MIN_VALUE;
            this.goneTopMargin = Integer.MIN_VALUE;
            this.goneRightMargin = Integer.MIN_VALUE;
            this.goneBottomMargin = Integer.MIN_VALUE;
            this.goneStartMargin = Integer.MIN_VALUE;
            this.goneEndMargin = Integer.MIN_VALUE;
            this.goneBaselineMargin = Integer.MIN_VALUE;
            this.baselineMargin = 0;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.wrapBehaviorInParent = 0;
            this.f3155a = true;
            this.f3156b = true;
            this.f3157c = false;
            this.f3158d = false;
            this.f3159e = false;
            this.f3160f = false;
            this.f3161g = -1;
            this.f3162h = -1;
            this.f3163i = -1;
            this.f3164j = -1;
            this.f3165k = Integer.MIN_VALUE;
            this.f3166l = Integer.MIN_VALUE;
            this.f3167m = 0.5f;
            this.f3171q = new ConstraintWidget();
            this.helped = false;
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
                ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
                ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
                ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
                setMarginStart(marginLayoutParams.getMarginStart());
                setMarginEnd(marginLayoutParams.getMarginEnd());
            }
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                this.guideBegin = layoutParams2.guideBegin;
                this.guideEnd = layoutParams2.guideEnd;
                this.guidePercent = layoutParams2.guidePercent;
                this.guidelineUseRtl = layoutParams2.guidelineUseRtl;
                this.leftToLeft = layoutParams2.leftToLeft;
                this.leftToRight = layoutParams2.leftToRight;
                this.rightToLeft = layoutParams2.rightToLeft;
                this.rightToRight = layoutParams2.rightToRight;
                this.topToTop = layoutParams2.topToTop;
                this.topToBottom = layoutParams2.topToBottom;
                this.bottomToTop = layoutParams2.bottomToTop;
                this.bottomToBottom = layoutParams2.bottomToBottom;
                this.baselineToBaseline = layoutParams2.baselineToBaseline;
                this.baselineToTop = layoutParams2.baselineToTop;
                this.baselineToBottom = layoutParams2.baselineToBottom;
                this.circleConstraint = layoutParams2.circleConstraint;
                this.circleRadius = layoutParams2.circleRadius;
                this.circleAngle = layoutParams2.circleAngle;
                this.startToEnd = layoutParams2.startToEnd;
                this.startToStart = layoutParams2.startToStart;
                this.endToStart = layoutParams2.endToStart;
                this.endToEnd = layoutParams2.endToEnd;
                this.goneLeftMargin = layoutParams2.goneLeftMargin;
                this.goneTopMargin = layoutParams2.goneTopMargin;
                this.goneRightMargin = layoutParams2.goneRightMargin;
                this.goneBottomMargin = layoutParams2.goneBottomMargin;
                this.goneStartMargin = layoutParams2.goneStartMargin;
                this.goneEndMargin = layoutParams2.goneEndMargin;
                this.goneBaselineMargin = layoutParams2.goneBaselineMargin;
                this.baselineMargin = layoutParams2.baselineMargin;
                this.horizontalBias = layoutParams2.horizontalBias;
                this.verticalBias = layoutParams2.verticalBias;
                this.dimensionRatio = layoutParams2.dimensionRatio;
                this.horizontalWeight = layoutParams2.horizontalWeight;
                this.verticalWeight = layoutParams2.verticalWeight;
                this.horizontalChainStyle = layoutParams2.horizontalChainStyle;
                this.verticalChainStyle = layoutParams2.verticalChainStyle;
                this.constrainedWidth = layoutParams2.constrainedWidth;
                this.constrainedHeight = layoutParams2.constrainedHeight;
                this.matchConstraintDefaultWidth = layoutParams2.matchConstraintDefaultWidth;
                this.matchConstraintDefaultHeight = layoutParams2.matchConstraintDefaultHeight;
                this.matchConstraintMinWidth = layoutParams2.matchConstraintMinWidth;
                this.matchConstraintMaxWidth = layoutParams2.matchConstraintMaxWidth;
                this.matchConstraintMinHeight = layoutParams2.matchConstraintMinHeight;
                this.matchConstraintMaxHeight = layoutParams2.matchConstraintMaxHeight;
                this.matchConstraintPercentWidth = layoutParams2.matchConstraintPercentWidth;
                this.matchConstraintPercentHeight = layoutParams2.matchConstraintPercentHeight;
                this.editorAbsoluteX = layoutParams2.editorAbsoluteX;
                this.editorAbsoluteY = layoutParams2.editorAbsoluteY;
                this.orientation = layoutParams2.orientation;
                this.f3155a = layoutParams2.f3155a;
                this.f3156b = layoutParams2.f3156b;
                this.f3157c = layoutParams2.f3157c;
                this.f3158d = layoutParams2.f3158d;
                this.f3161g = layoutParams2.f3161g;
                this.f3162h = layoutParams2.f3162h;
                this.f3163i = layoutParams2.f3163i;
                this.f3164j = layoutParams2.f3164j;
                this.f3165k = layoutParams2.f3165k;
                this.f3166l = layoutParams2.f3166l;
                this.f3167m = layoutParams2.f3167m;
                this.constraintTag = layoutParams2.constraintTag;
                this.wrapBehaviorInParent = layoutParams2.wrapBehaviorInParent;
                this.f3171q = layoutParams2.f3171q;
            }
        }

        public String getConstraintTag() {
            return this.constraintTag;
        }

        public ConstraintWidget getConstraintWidget() {
            return this.f3171q;
        }

        public void reset() {
            ConstraintWidget constraintWidget = this.f3171q;
            if (constraintWidget != null) {
                constraintWidget.reset();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void resolveLayoutDirection(int i) {
            boolean z;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i7 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(i);
            boolean z2 = false;
            if (1 == getLayoutDirection()) {
                z = true;
            } else {
                z = false;
            }
            this.f3163i = -1;
            this.f3164j = -1;
            this.f3161g = -1;
            this.f3162h = -1;
            this.f3165k = this.goneLeftMargin;
            this.f3166l = this.goneRightMargin;
            float f = this.horizontalBias;
            this.f3167m = f;
            int i8 = this.guideBegin;
            this.f3168n = i8;
            int i9 = this.guideEnd;
            this.f3169o = i9;
            float f2 = this.guidePercent;
            this.f3170p = f2;
            if (z) {
                int i10 = this.startToEnd;
                if (i10 != -1) {
                    this.f3163i = i10;
                } else {
                    int i11 = this.startToStart;
                    if (i11 != -1) {
                        this.f3164j = i11;
                    }
                    i2 = this.endToStart;
                    if (i2 != -1) {
                        this.f3162h = i2;
                        z2 = true;
                    }
                    i3 = this.endToEnd;
                    if (i3 != -1) {
                        this.f3161g = i3;
                        z2 = true;
                    }
                    i4 = this.goneStartMargin;
                    if (i4 != Integer.MIN_VALUE) {
                        this.f3166l = i4;
                    }
                    i5 = this.goneEndMargin;
                    if (i5 != Integer.MIN_VALUE) {
                        this.f3165k = i5;
                    }
                    if (z2) {
                        this.f3167m = 1.0f - f;
                    }
                    if (this.f3158d && this.orientation == 1 && this.guidelineUseRtl) {
                        if (f2 == -1.0f) {
                            this.f3170p = 1.0f - f2;
                            this.f3168n = -1;
                            this.f3169o = -1;
                        } else if (i8 != -1) {
                            this.f3169o = i8;
                            this.f3168n = -1;
                            this.f3170p = -1.0f;
                        } else if (i9 != -1) {
                            this.f3168n = i9;
                            this.f3169o = -1;
                            this.f3170p = -1.0f;
                        }
                    }
                }
                z2 = true;
                i2 = this.endToStart;
                if (i2 != -1) {
                }
                i3 = this.endToEnd;
                if (i3 != -1) {
                }
                i4 = this.goneStartMargin;
                if (i4 != Integer.MIN_VALUE) {
                }
                i5 = this.goneEndMargin;
                if (i5 != Integer.MIN_VALUE) {
                }
                if (z2) {
                }
                if (this.f3158d) {
                    if (f2 == -1.0f) {
                    }
                }
            } else {
                int i12 = this.startToEnd;
                if (i12 != -1) {
                    this.f3162h = i12;
                }
                int i13 = this.startToStart;
                if (i13 != -1) {
                    this.f3161g = i13;
                }
                int i14 = this.endToStart;
                if (i14 != -1) {
                    this.f3163i = i14;
                }
                int i15 = this.endToEnd;
                if (i15 != -1) {
                    this.f3164j = i15;
                }
                int i16 = this.goneStartMargin;
                if (i16 != Integer.MIN_VALUE) {
                    this.f3165k = i16;
                }
                int i17 = this.goneEndMargin;
                if (i17 != Integer.MIN_VALUE) {
                    this.f3166l = i17;
                }
            }
            if (this.endToStart == -1 && this.endToEnd == -1 && this.startToStart == -1 && this.startToEnd == -1) {
                int i18 = this.rightToLeft;
                if (i18 != -1) {
                    this.f3163i = i18;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i7 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).rightMargin = i7;
                    }
                } else {
                    int i19 = this.rightToRight;
                    if (i19 != -1) {
                        this.f3164j = i19;
                        if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i7 > 0) {
                            ((ViewGroup.MarginLayoutParams) this).rightMargin = i7;
                        }
                    }
                }
                int i20 = this.leftToLeft;
                if (i20 != -1) {
                    this.f3161g = i20;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin <= 0 && i6 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).leftMargin = i6;
                        return;
                    }
                    return;
                }
                int i21 = this.leftToRight;
                if (i21 != -1) {
                    this.f3162h = i21;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin <= 0 && i6 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).leftMargin = i6;
                    }
                }
            }
        }

        public void setWidgetDebugName(String str) {
            this.f3171q.setDebugName(str);
        }

        public void validate() {
            this.f3158d = false;
            this.f3155a = true;
            this.f3156b = true;
            int i = ((ViewGroup.MarginLayoutParams) this).width;
            if (i == -2 && this.constrainedWidth) {
                this.f3155a = false;
                if (this.matchConstraintDefaultWidth == 0) {
                    this.matchConstraintDefaultWidth = 1;
                }
            }
            int i2 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i2 == -2 && this.constrainedHeight) {
                this.f3156b = false;
                if (this.matchConstraintDefaultHeight == 0) {
                    this.matchConstraintDefaultHeight = 1;
                }
            }
            if (i == 0 || i == -1) {
                this.f3155a = false;
                if (i == 0 && this.matchConstraintDefaultWidth == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.constrainedWidth = true;
                }
            }
            if (i2 == 0 || i2 == -1) {
                this.f3156b = false;
                if (i2 == 0 && this.matchConstraintDefaultHeight == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.constrainedHeight = true;
                }
            }
            if (this.guidePercent != -1.0f || this.guideBegin != -1 || this.guideEnd != -1) {
                this.f3158d = true;
                this.f3155a = true;
                this.f3156b = true;
                if (!(this.f3171q instanceof androidx.constraintlayout.core.widgets.Guideline)) {
                    this.f3171q = new androidx.constraintlayout.core.widgets.Guideline();
                }
                ((androidx.constraintlayout.core.widgets.Guideline) this.f3171q).setOrientation(this.orientation);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.guidelineUseRtl = true;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.baselineToTop = -1;
            this.baselineToBottom = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = RecyclerView.f7068F0;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = Integer.MIN_VALUE;
            this.goneTopMargin = Integer.MIN_VALUE;
            this.goneRightMargin = Integer.MIN_VALUE;
            this.goneBottomMargin = Integer.MIN_VALUE;
            this.goneStartMargin = Integer.MIN_VALUE;
            this.goneEndMargin = Integer.MIN_VALUE;
            this.goneBaselineMargin = Integer.MIN_VALUE;
            this.baselineMargin = 0;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.wrapBehaviorInParent = 0;
            this.f3155a = true;
            this.f3156b = true;
            this.f3157c = false;
            this.f3158d = false;
            this.f3159e = false;
            this.f3160f = false;
            this.f3161g = -1;
            this.f3162h = -1;
            this.f3163i = -1;
            this.f3164j = -1;
            this.f3165k = Integer.MIN_VALUE;
            this.f3166l = Integer.MIN_VALUE;
            this.f3167m = 0.5f;
            this.f3171q = new ConstraintWidget();
            this.helped = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                int i2 = AbstractC0129a.f3214a.get(index);
                switch (i2) {
                    case 1:
                        this.orientation = obtainStyledAttributes.getInt(index, this.orientation);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.circleConstraint);
                        this.circleConstraint = resourceId;
                        if (resourceId == -1) {
                            this.circleConstraint = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.circleRadius);
                        break;
                    case 4:
                        float f = obtainStyledAttributes.getFloat(index, this.circleAngle) % 360.0f;
                        this.circleAngle = f;
                        if (f < RecyclerView.f7068F0) {
                            this.circleAngle = (360.0f - f) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.guideBegin = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideBegin);
                        break;
                    case 6:
                        this.guideEnd = obtainStyledAttributes.getDimensionPixelOffset(index, this.guideEnd);
                        break;
                    case 7:
                        this.guidePercent = obtainStyledAttributes.getFloat(index, this.guidePercent);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.leftToLeft);
                        this.leftToLeft = resourceId2;
                        if (resourceId2 == -1) {
                            this.leftToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.leftToRight);
                        this.leftToRight = resourceId3;
                        if (resourceId3 == -1) {
                            this.leftToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.rightToLeft);
                        this.rightToLeft = resourceId4;
                        if (resourceId4 == -1) {
                            this.rightToLeft = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.rightToRight);
                        this.rightToRight = resourceId5;
                        if (resourceId5 == -1) {
                            this.rightToRight = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.topToTop);
                        this.topToTop = resourceId6;
                        if (resourceId6 == -1) {
                            this.topToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.topToBottom);
                        this.topToBottom = resourceId7;
                        if (resourceId7 == -1) {
                            this.topToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.bottomToTop);
                        this.bottomToTop = resourceId8;
                        if (resourceId8 == -1) {
                            this.bottomToTop = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.bottomToBottom);
                        this.bottomToBottom = resourceId9;
                        if (resourceId9 == -1) {
                            this.bottomToBottom = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.baselineToBaseline);
                        this.baselineToBaseline = resourceId10;
                        if (resourceId10 == -1) {
                            this.baselineToBaseline = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.startToEnd);
                        this.startToEnd = resourceId11;
                        if (resourceId11 == -1) {
                            this.startToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.startToStart);
                        this.startToStart = resourceId12;
                        if (resourceId12 == -1) {
                            this.startToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.endToStart);
                        this.endToStart = resourceId13;
                        if (resourceId13 == -1) {
                            this.endToStart = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.endToEnd);
                        this.endToEnd = resourceId14;
                        if (resourceId14 == -1) {
                            this.endToEnd = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.goneLeftMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneLeftMargin);
                        break;
                    case 22:
                        this.goneTopMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneTopMargin);
                        break;
                    case 23:
                        this.goneRightMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneRightMargin);
                        break;
                    case 24:
                        this.goneBottomMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBottomMargin);
                        break;
                    case 25:
                        this.goneStartMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneStartMargin);
                        break;
                    case 26:
                        this.goneEndMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneEndMargin);
                        break;
                    case 27:
                        this.constrainedWidth = obtainStyledAttributes.getBoolean(index, this.constrainedWidth);
                        break;
                    case 28:
                        this.constrainedHeight = obtainStyledAttributes.getBoolean(index, this.constrainedHeight);
                        break;
                    case 29:
                        this.horizontalBias = obtainStyledAttributes.getFloat(index, this.horizontalBias);
                        break;
                    case 30:
                        this.verticalBias = obtainStyledAttributes.getFloat(index, this.verticalBias);
                        break;
                    case 31:
                        int i3 = obtainStyledAttributes.getInt(index, 0);
                        this.matchConstraintDefaultWidth = i3;
                        if (i3 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i4 = obtainStyledAttributes.getInt(index, 0);
                        this.matchConstraintDefaultHeight = i4;
                        if (i4 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.matchConstraintMinWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinWidth);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinWidth) == -2) {
                                this.matchConstraintMinWidth = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.matchConstraintMaxWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxWidth);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxWidth) == -2) {
                                this.matchConstraintMaxWidth = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.matchConstraintPercentWidth = Math.max(RecyclerView.f7068F0, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentWidth));
                        this.matchConstraintDefaultWidth = 2;
                        break;
                    case 36:
                        try {
                            this.matchConstraintMinHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMinHeight);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMinHeight) == -2) {
                                this.matchConstraintMinHeight = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.matchConstraintMaxHeight = obtainStyledAttributes.getDimensionPixelSize(index, this.matchConstraintMaxHeight);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.matchConstraintMaxHeight) == -2) {
                                this.matchConstraintMaxHeight = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.matchConstraintPercentHeight = Math.max(RecyclerView.f7068F0, obtainStyledAttributes.getFloat(index, this.matchConstraintPercentHeight));
                        this.matchConstraintDefaultHeight = 2;
                        break;
                    default:
                        switch (i2) {
                            case 44:
                                ConstraintSet.m646i(this, obtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.horizontalWeight = obtainStyledAttributes.getFloat(index, this.horizontalWeight);
                                break;
                            case 46:
                                this.verticalWeight = obtainStyledAttributes.getFloat(index, this.verticalWeight);
                                break;
                            case 47:
                                this.horizontalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.verticalChainStyle = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.editorAbsoluteX = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteX);
                                break;
                            case 50:
                                this.editorAbsoluteY = obtainStyledAttributes.getDimensionPixelOffset(index, this.editorAbsoluteY);
                                break;
                            case 51:
                                this.constraintTag = obtainStyledAttributes.getString(index);
                                break;
                            case 52:
                                int resourceId15 = obtainStyledAttributes.getResourceId(index, this.baselineToTop);
                                this.baselineToTop = resourceId15;
                                if (resourceId15 == -1) {
                                    this.baselineToTop = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                int resourceId16 = obtainStyledAttributes.getResourceId(index, this.baselineToBottom);
                                this.baselineToBottom = resourceId16;
                                if (resourceId16 == -1) {
                                    this.baselineToBottom = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                this.baselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.baselineMargin);
                                break;
                            case 55:
                                this.goneBaselineMargin = obtainStyledAttributes.getDimensionPixelSize(index, this.goneBaselineMargin);
                                break;
                            default:
                                switch (i2) {
                                    case 64:
                                        ConstraintSet.m645h(this, obtainStyledAttributes, index, 0);
                                        break;
                                    case 65:
                                        ConstraintSet.m645h(this, obtainStyledAttributes, index, 1);
                                        break;
                                    case 66:
                                        this.wrapBehaviorInParent = obtainStyledAttributes.getInt(index, this.wrapBehaviorInParent);
                                        break;
                                    case 67:
                                        this.guidelineUseRtl = obtainStyledAttributes.getBoolean(index, this.guidelineUseRtl);
                                        break;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
            validate();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.guideBegin = -1;
            this.guideEnd = -1;
            this.guidePercent = -1.0f;
            this.guidelineUseRtl = true;
            this.leftToLeft = -1;
            this.leftToRight = -1;
            this.rightToLeft = -1;
            this.rightToRight = -1;
            this.topToTop = -1;
            this.topToBottom = -1;
            this.bottomToTop = -1;
            this.bottomToBottom = -1;
            this.baselineToBaseline = -1;
            this.baselineToTop = -1;
            this.baselineToBottom = -1;
            this.circleConstraint = -1;
            this.circleRadius = 0;
            this.circleAngle = RecyclerView.f7068F0;
            this.startToEnd = -1;
            this.startToStart = -1;
            this.endToStart = -1;
            this.endToEnd = -1;
            this.goneLeftMargin = Integer.MIN_VALUE;
            this.goneTopMargin = Integer.MIN_VALUE;
            this.goneRightMargin = Integer.MIN_VALUE;
            this.goneBottomMargin = Integer.MIN_VALUE;
            this.goneStartMargin = Integer.MIN_VALUE;
            this.goneEndMargin = Integer.MIN_VALUE;
            this.goneBaselineMargin = Integer.MIN_VALUE;
            this.baselineMargin = 0;
            this.horizontalBias = 0.5f;
            this.verticalBias = 0.5f;
            this.dimensionRatio = null;
            this.horizontalWeight = -1.0f;
            this.verticalWeight = -1.0f;
            this.horizontalChainStyle = 0;
            this.verticalChainStyle = 0;
            this.matchConstraintDefaultWidth = 0;
            this.matchConstraintDefaultHeight = 0;
            this.matchConstraintMinWidth = 0;
            this.matchConstraintMinHeight = 0;
            this.matchConstraintMaxWidth = 0;
            this.matchConstraintMaxHeight = 0;
            this.matchConstraintPercentWidth = 1.0f;
            this.matchConstraintPercentHeight = 1.0f;
            this.editorAbsoluteX = -1;
            this.editorAbsoluteY = -1;
            this.orientation = -1;
            this.constrainedWidth = false;
            this.constrainedHeight = false;
            this.constraintTag = null;
            this.wrapBehaviorInParent = 0;
            this.f3155a = true;
            this.f3156b = true;
            this.f3157c = false;
            this.f3158d = false;
            this.f3159e = false;
            this.f3160f = false;
            this.f3161g = -1;
            this.f3162h = -1;
            this.f3163i = -1;
            this.f3164j = -1;
            this.f3165k = Integer.MIN_VALUE;
            this.f3166l = Integer.MIN_VALUE;
            this.f3167m = 0.5f;
            this.f3171q = new ConstraintWidget();
            this.helped = false;
        }
    }
}
