package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.Facade;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public class HelperReference extends ConstraintReference implements Facade {

    /* renamed from: M */
    public final State.Helper f2346M;

    /* renamed from: N */
    public HelperWidget f2347N;
    protected final State mHelperState;
    protected ArrayList<Object> mReferences;

    public HelperReference(State state, State.Helper helper) {
        super(state);
        this.mReferences = new ArrayList<>();
        this.mHelperState = state;
        this.f2346M = helper;
    }

    public HelperReference add(Object... objArr) {
        Collections.addAll(this.mReferences, objArr);
        return this;
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
    }

    public void applyBase() {
        super.apply();
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public ConstraintWidget getConstraintWidget() {
        return getHelperWidget();
    }

    public HelperWidget getHelperWidget() {
        return this.f2347N;
    }

    public State.Helper getType() {
        return this.f2346M;
    }

    public void setHelperWidget(HelperWidget helperWidget) {
        this.f2347N = helperWidget;
    }
}
