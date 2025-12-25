package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ChainHead {

    /* renamed from: a */
    public final int f2456a;

    /* renamed from: b */
    public final boolean f2457b;

    /* renamed from: c */
    public boolean f2458c;
    protected ConstraintWidget mFirst;
    protected ConstraintWidget mFirstMatchConstraintWidget;
    protected ConstraintWidget mFirstVisibleWidget;
    protected boolean mHasComplexMatchWeights;
    protected boolean mHasDefinedWeights;
    protected boolean mHasRatio;
    protected boolean mHasUndefinedWeights;
    protected ConstraintWidget mHead;
    protected ConstraintWidget mLast;
    protected ConstraintWidget mLastMatchConstraintWidget;
    protected ConstraintWidget mLastVisibleWidget;
    protected float mTotalWeight = RecyclerView.f7068F0;
    protected ArrayList<ConstraintWidget> mWeightedMatchConstraintsWidgets;
    protected int mWidgetsCount;
    protected int mWidgetsMatchCount;

    public ChainHead(ConstraintWidget constraintWidget, int i, boolean z) {
        this.mFirst = constraintWidget;
        this.f2456a = i;
        this.f2457b = z;
    }

    public void define() {
        int i;
        if (!this.f2458c) {
            int i2 = this.f2456a;
            int i3 = i2 * 2;
            ConstraintWidget constraintWidget = this.mFirst;
            boolean z = false;
            ConstraintWidget constraintWidget2 = constraintWidget;
            boolean z2 = false;
            while (!z2) {
                this.mWidgetsCount++;
                ConstraintWidget constraintWidget3 = null;
                constraintWidget.mNextChainWidget[i2] = null;
                constraintWidget.mListNextMatchConstraintsWidget[i2] = null;
                if (constraintWidget.getVisibility() != 8) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(i2);
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour != dimensionBehaviour2) {
                        constraintWidget.getLength(i2);
                    }
                    constraintWidget.mListAnchors[i3].getMargin();
                    int i4 = i3 + 1;
                    constraintWidget.mListAnchors[i4].getMargin();
                    constraintWidget.mListAnchors[i3].getMargin();
                    constraintWidget.mListAnchors[i4].getMargin();
                    if (this.mFirstVisibleWidget == null) {
                        this.mFirstVisibleWidget = constraintWidget;
                    }
                    this.mLastVisibleWidget = constraintWidget;
                    if (constraintWidget.mListDimensionBehaviors[i2] == dimensionBehaviour2) {
                        int i5 = constraintWidget.mResolvedMatchConstraintDefault[i2];
                        if (i5 == 0 || i5 == 3 || i5 == 2) {
                            this.mWidgetsMatchCount++;
                            float f = constraintWidget.mWeight[i2];
                            if (f > RecyclerView.f7068F0) {
                                this.mTotalWeight += f;
                            }
                            if (constraintWidget.getVisibility() != 8 && constraintWidget.mListDimensionBehaviors[i2] == dimensionBehaviour2 && ((i = constraintWidget.mResolvedMatchConstraintDefault[i2]) == 0 || i == 3)) {
                                if (f < RecyclerView.f7068F0) {
                                    this.mHasUndefinedWeights = true;
                                } else {
                                    this.mHasDefinedWeights = true;
                                }
                                if (this.mWeightedMatchConstraintsWidgets == null) {
                                    this.mWeightedMatchConstraintsWidgets = new ArrayList<>();
                                }
                                this.mWeightedMatchConstraintsWidgets.add(constraintWidget);
                            }
                            if (this.mFirstMatchConstraintWidget == null) {
                                this.mFirstMatchConstraintWidget = constraintWidget;
                            }
                            ConstraintWidget constraintWidget4 = this.mLastMatchConstraintWidget;
                            if (constraintWidget4 != null) {
                                constraintWidget4.mListNextMatchConstraintsWidget[i2] = constraintWidget;
                            }
                            this.mLastMatchConstraintWidget = constraintWidget;
                        }
                        if (i2 == 0) {
                            if (constraintWidget.mMatchConstraintDefaultWidth == 0 && constraintWidget.mMatchConstraintMinWidth == 0) {
                                int i6 = constraintWidget.mMatchConstraintMaxWidth;
                            }
                        } else if (constraintWidget.mMatchConstraintDefaultHeight == 0 && constraintWidget.mMatchConstraintMinHeight == 0) {
                            int i7 = constraintWidget.mMatchConstraintMaxHeight;
                        }
                        if (constraintWidget.mDimensionRatio != RecyclerView.f7068F0) {
                            this.mHasRatio = true;
                        }
                    }
                }
                if (constraintWidget2 != constraintWidget) {
                    constraintWidget2.mNextChainWidget[i2] = constraintWidget;
                }
                ConstraintAnchor constraintAnchor = constraintWidget.mListAnchors[i3 + 1].mTarget;
                if (constraintAnchor != null) {
                    ConstraintWidget constraintWidget5 = constraintAnchor.mOwner;
                    ConstraintAnchor constraintAnchor2 = constraintWidget5.mListAnchors[i3].mTarget;
                    if (constraintAnchor2 != null && constraintAnchor2.mOwner == constraintWidget) {
                        constraintWidget3 = constraintWidget5;
                    }
                }
                if (constraintWidget3 == null) {
                    z2 = true;
                    constraintWidget3 = constraintWidget;
                }
                constraintWidget2 = constraintWidget;
                constraintWidget = constraintWidget3;
            }
            ConstraintWidget constraintWidget6 = this.mFirstVisibleWidget;
            if (constraintWidget6 != null) {
                constraintWidget6.mListAnchors[i3].getMargin();
            }
            ConstraintWidget constraintWidget7 = this.mLastVisibleWidget;
            if (constraintWidget7 != null) {
                constraintWidget7.mListAnchors[i3 + 1].getMargin();
            }
            this.mLast = constraintWidget;
            if (i2 == 0 && this.f2457b) {
                this.mHead = constraintWidget;
            } else {
                this.mHead = this.mFirst;
            }
            if (this.mHasDefinedWeights && this.mHasUndefinedWeights) {
                z = true;
            }
            this.mHasComplexMatchWeights = z;
        }
        this.f2458c = true;
    }

    public ConstraintWidget getFirst() {
        return this.mFirst;
    }

    public ConstraintWidget getFirstMatchConstraintWidget() {
        return this.mFirstMatchConstraintWidget;
    }

    public ConstraintWidget getFirstVisibleWidget() {
        return this.mFirstVisibleWidget;
    }

    public ConstraintWidget getHead() {
        return this.mHead;
    }

    public ConstraintWidget getLast() {
        return this.mLast;
    }

    public ConstraintWidget getLastMatchConstraintWidget() {
        return this.mLastMatchConstraintWidget;
    }

    public ConstraintWidget getLastVisibleWidget() {
        return this.mLastVisibleWidget;
    }

    public float getTotalWeight() {
        return this.mTotalWeight;
    }
}
