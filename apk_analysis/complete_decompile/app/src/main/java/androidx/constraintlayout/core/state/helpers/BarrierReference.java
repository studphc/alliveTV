package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.HelperWidget;
import p000.AbstractC1758re;

/* loaded from: classes.dex */
public class BarrierReference extends HelperReference {

    /* renamed from: O */
    public State.Direction f2393O;

    /* renamed from: P */
    public int f2394P;

    /* renamed from: Q */
    public Barrier f2395Q;

    public BarrierReference(State state) {
        super(state, State.Helper.BARRIER);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        getHelperWidget();
        int i = AbstractC1758re.f25941a[this.f2393O.ordinal()];
        int i2 = 3;
        if (i != 3 && i != 4) {
            if (i != 5) {
                if (i != 6) {
                    i2 = 0;
                }
            } else {
                i2 = 2;
            }
        } else {
            i2 = 1;
        }
        this.f2395Q.setBarrierType(i2);
        this.f2395Q.setMargin(this.f2394P);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference
    public HelperWidget getHelperWidget() {
        if (this.f2395Q == null) {
            this.f2395Q = new Barrier();
        }
        return this.f2395Q;
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference
    public ConstraintReference margin(Object obj) {
        margin(this.mHelperState.convertDimension(obj));
        return this;
    }

    public void setBarrierDirection(State.Direction direction) {
        this.f2393O = direction;
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference
    public ConstraintReference margin(int i) {
        this.f2394P = i;
        return this;
    }
}
