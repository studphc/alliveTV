package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.Iterator;
import p000.v13;

/* loaded from: classes.dex */
public class VerticalChainReference extends ChainReference {
    public VerticalChainReference(State state) {
        super(state, State.Helper.VERTICAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        Iterator<Object> it = this.mReferences.iterator();
        while (it.hasNext()) {
            this.mHelperState.constraints(it.next()).clearVertical();
        }
        Iterator<Object> it2 = this.mReferences.iterator();
        ConstraintReference constraintReference = null;
        ConstraintReference constraintReference2 = null;
        while (it2.hasNext()) {
            Object next = it2.next();
            ConstraintReference constraints = this.mHelperState.constraints(next);
            if (constraintReference2 == null) {
                Object obj = this.mTopToTop;
                if (obj != null) {
                    constraints.topToTop(obj).margin(this.mMarginTop).marginGone(this.mMarginTopGone);
                } else {
                    Object obj2 = this.mTopToBottom;
                    if (obj2 != null) {
                        constraints.topToBottom(obj2).margin(this.mMarginTop).marginGone(this.mMarginTopGone);
                    } else {
                        String obj3 = constraints.getKey().toString();
                        constraints.topToTop(State.PARENT).margin(Float.valueOf(getPreMargin(obj3))).marginGone(Float.valueOf(m467d(obj3)));
                    }
                }
                constraintReference2 = constraints;
            }
            if (constraintReference != null) {
                String obj4 = constraintReference.getKey().toString();
                String obj5 = constraints.getKey().toString();
                constraintReference.bottomToTop(constraints.getKey()).margin(Float.valueOf(getPostMargin(obj4))).marginGone(Float.valueOf(m466c(obj4)));
                constraints.topToBottom(constraintReference.getKey()).margin(Float.valueOf(getPreMargin(obj5))).marginGone(Float.valueOf(m467d(obj5)));
            }
            float weight = getWeight(next.toString());
            if (weight != -1.0f) {
                constraints.setVerticalChainWeight(weight);
            }
            constraintReference = constraints;
        }
        if (constraintReference != null) {
            Object obj6 = this.mBottomToTop;
            if (obj6 != null) {
                constraintReference.bottomToTop(obj6).margin(this.mMarginBottom).marginGone(this.mMarginBottomGone);
            } else {
                Object obj7 = this.mBottomToBottom;
                if (obj7 != null) {
                    constraintReference.bottomToBottom(obj7).margin(this.mMarginBottom).marginGone(this.mMarginBottomGone);
                } else {
                    String obj8 = constraintReference.getKey().toString();
                    constraintReference.bottomToBottom(State.PARENT).margin(Float.valueOf(getPostMargin(obj8))).marginGone(Float.valueOf(m466c(obj8)));
                }
            }
        }
        if (constraintReference2 == null) {
            return;
        }
        float f = this.mBias;
        if (f != 0.5f) {
            constraintReference2.verticalBias(f);
        }
        int i = v13.f27626a[this.mStyle.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    constraintReference2.setVerticalChainStyle(2);
                    return;
                }
                return;
            }
            constraintReference2.setVerticalChainStyle(1);
            return;
        }
        constraintReference2.setVerticalChainStyle(0);
    }
}
