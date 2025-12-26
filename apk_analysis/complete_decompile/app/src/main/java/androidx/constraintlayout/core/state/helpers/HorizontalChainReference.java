package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;
import p000.w01;

/* loaded from: classes.dex */
public class HorizontalChainReference extends ChainReference {
    public HorizontalChainReference(State state) {
        super(state, State.Helper.HORIZONTAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        Iterator<Object> it = this.mReferences.iterator();
        while (it.hasNext()) {
            this.mHelperState.constraints(it.next()).clearHorizontal();
        }
        Iterator<Object> it2 = this.mReferences.iterator();
        ConstraintReference constraintReference = null;
        ConstraintReference constraintReference2 = null;
        while (it2.hasNext()) {
            Object next = it2.next();
            ConstraintReference constraints = this.mHelperState.constraints(next);
            if (constraintReference2 == null) {
                Object obj = this.mStartToStart;
                if (obj != null) {
                    constraints.startToStart(obj).margin(this.mMarginStart).marginGone(this.mMarginStartGone);
                } else {
                    Object obj2 = this.mStartToEnd;
                    if (obj2 != null) {
                        constraints.startToEnd(obj2).margin(this.mMarginStart).marginGone(this.mMarginStartGone);
                    } else {
                        Object obj3 = this.mLeftToLeft;
                        if (obj3 != null) {
                            constraints.startToStart(obj3).margin(this.mMarginLeft).marginGone(this.mMarginLeftGone);
                        } else {
                            Object obj4 = this.mLeftToRight;
                            if (obj4 != null) {
                                constraints.startToEnd(obj4).margin(this.mMarginLeft).marginGone(this.mMarginLeftGone);
                            } else {
                                String obj5 = constraints.getKey().toString();
                                constraints.startToStart(State.PARENT).margin(Float.valueOf(getPreMargin(obj5))).marginGone(Float.valueOf(m467d(obj5)));
                            }
                        }
                    }
                }
                constraintReference2 = constraints;
            }
            if (constraintReference != null) {
                String obj6 = constraintReference.getKey().toString();
                String obj7 = constraints.getKey().toString();
                constraintReference.endToStart(constraints.getKey()).margin(Float.valueOf(getPostMargin(obj6))).marginGone(Float.valueOf(m466c(obj6)));
                constraints.startToEnd(constraintReference.getKey()).margin(Float.valueOf(getPreMargin(obj7))).marginGone(Float.valueOf(m467d(obj7)));
            }
            float weight = getWeight(next.toString());
            if (weight != -1.0f) {
                constraints.setHorizontalChainWeight(weight);
            }
            constraintReference = constraints;
        }
        if (constraintReference != null) {
            Object obj8 = this.mEndToStart;
            if (obj8 != null) {
                constraintReference.endToStart(obj8).margin(this.mMarginEnd).marginGone(this.mMarginEndGone);
            } else {
                Object obj9 = this.mEndToEnd;
                if (obj9 != null) {
                    constraintReference.endToEnd(obj9).margin(this.mMarginEnd).marginGone(this.mMarginEndGone);
                } else {
                    Object obj10 = this.mRightToLeft;
                    if (obj10 != null) {
                        constraintReference.endToStart(obj10).margin(this.mMarginRight).marginGone(this.mMarginRightGone);
                    } else {
                        Object obj11 = this.mRightToRight;
                        if (obj11 != null) {
                            constraintReference.endToEnd(obj11).margin(this.mMarginRight).marginGone(this.mMarginRightGone);
                        } else {
                            String obj12 = constraintReference.getKey().toString();
                            constraintReference.endToEnd(State.PARENT).margin(Float.valueOf(getPostMargin(obj12))).marginGone(Float.valueOf(m466c(obj12)));
                        }
                    }
                }
            }
        }
        if (constraintReference2 == null) {
            return;
        }
        float f = this.mBias;
        if (f != 0.5f) {
            constraintReference2.horizontalBias(f);
        }
        int i = w01.f28028a[this.mStyle.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    constraintReference2.setHorizontalChainStyle(2);
                    return;
                }
                return;
            }
            constraintReference2.setHorizontalChainStyle(1);
            return;
        }
        constraintReference2.setHorizontalChainStyle(0);
    }
}
