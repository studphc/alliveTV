package androidx.constraintlayout.core.state.helpers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.utils.GridCore;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class GridReference extends HelperReference {

    /* renamed from: O */
    public GridCore f2398O;

    /* renamed from: P */
    public int f2399P;

    /* renamed from: Q */
    public int f2400Q;

    /* renamed from: R */
    public int f2401R;

    /* renamed from: S */
    public int f2402S;

    /* renamed from: T */
    public int f2403T;

    /* renamed from: U */
    public int f2404U;

    /* renamed from: V */
    public int f2405V;

    /* renamed from: W */
    public float f2406W;

    /* renamed from: X */
    public float f2407X;

    /* renamed from: Y */
    public String f2408Y;

    /* renamed from: Z */
    public String f2409Z;

    /* renamed from: a0 */
    public String f2410a0;

    /* renamed from: b0 */
    public String f2411b0;

    /* renamed from: c0 */
    public int f2412c0;

    public GridReference(@NonNull State state, @NonNull State.Helper helper) {
        super(state, helper);
        this.f2399P = 0;
        this.f2400Q = 0;
        this.f2401R = 0;
        this.f2402S = 0;
        if (helper == State.Helper.ROW) {
            this.f2404U = 1;
        } else if (helper == State.Helper.COLUMN) {
            this.f2405V = 1;
        }
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        getHelperWidget();
        this.f2398O.setOrientation(this.f2403T);
        int i = this.f2404U;
        if (i != 0) {
            this.f2398O.setRows(i);
        }
        int i2 = this.f2405V;
        if (i2 != 0) {
            this.f2398O.setColumns(i2);
        }
        float f = this.f2406W;
        if (f != RecyclerView.f7068F0) {
            this.f2398O.setHorizontalGaps(f);
        }
        float f2 = this.f2407X;
        if (f2 != RecyclerView.f7068F0) {
            this.f2398O.setVerticalGaps(f2);
        }
        String str = this.f2408Y;
        if (str != null && !str.isEmpty()) {
            this.f2398O.setRowWeights(this.f2408Y);
        }
        String str2 = this.f2409Z;
        if (str2 != null && !str2.isEmpty()) {
            this.f2398O.setColumnWeights(this.f2409Z);
        }
        String str3 = this.f2410a0;
        if (str3 != null && !str3.isEmpty()) {
            this.f2398O.setSpans(this.f2410a0);
        }
        String str4 = this.f2411b0;
        if (str4 != null && !str4.isEmpty()) {
            this.f2398O.setSkips(this.f2411b0);
        }
        this.f2398O.setFlags(this.f2412c0);
        this.f2398O.setPaddingStart(this.f2399P);
        this.f2398O.setPaddingEnd(this.f2400Q);
        this.f2398O.setPaddingTop(this.f2401R);
        this.f2398O.setPaddingBottom(this.f2402S);
        applyBase();
    }

    @Nullable
    public String getColumnWeights() {
        return this.f2409Z;
    }

    public int getColumnsSet() {
        return this.f2405V;
    }

    public int getFlags() {
        return this.f2412c0;
    }

    @Override // androidx.constraintlayout.core.state.HelperReference
    @NonNull
    public HelperWidget getHelperWidget() {
        if (this.f2398O == null) {
            this.f2398O = new GridCore();
        }
        return this.f2398O;
    }

    public float getHorizontalGaps() {
        return this.f2406W;
    }

    public int getOrientation() {
        return this.f2403T;
    }

    public int getPaddingBottom() {
        return this.f2402S;
    }

    public int getPaddingEnd() {
        return this.f2400Q;
    }

    public int getPaddingStart() {
        return this.f2399P;
    }

    public int getPaddingTop() {
        return this.f2401R;
    }

    @Nullable
    public String getRowWeights() {
        return this.f2408Y;
    }

    public int getRowsSet() {
        return this.f2404U;
    }

    @Nullable
    public String getSkips() {
        return this.f2411b0;
    }

    @Nullable
    public String getSpans() {
        return this.f2410a0;
    }

    public float getVerticalGaps() {
        return this.f2407X;
    }

    public void setColumnWeights(@NonNull String str) {
        this.f2409Z = str;
    }

    public void setColumnsSet(int i) {
        if (super.getType() == State.Helper.ROW) {
            return;
        }
        this.f2405V = i;
    }

    public void setFlags(int i) {
        this.f2412c0 = i;
    }

    @Override // androidx.constraintlayout.core.state.HelperReference
    public void setHelperWidget(@Nullable HelperWidget helperWidget) {
        if (helperWidget instanceof GridCore) {
            this.f2398O = (GridCore) helperWidget;
        } else {
            this.f2398O = null;
        }
    }

    public void setHorizontalGaps(float f) {
        this.f2406W = f;
    }

    public void setOrientation(int i) {
        this.f2403T = i;
    }

    public void setPaddingBottom(int i) {
        this.f2402S = i;
    }

    public void setPaddingEnd(int i) {
        this.f2400Q = i;
    }

    public void setPaddingStart(int i) {
        this.f2399P = i;
    }

    public void setPaddingTop(int i) {
        this.f2401R = i;
    }

    public void setRowWeights(@NonNull String str) {
        this.f2408Y = str;
    }

    public void setRowsSet(int i) {
        if (super.getType() == State.Helper.COLUMN) {
            return;
        }
        this.f2404U = i;
    }

    public void setSkips(@NonNull String str) {
        this.f2411b0 = str;
    }

    public void setSpans(@NonNull String str) {
        this.f2410a0 = str;
    }

    public void setVerticalGaps(float f) {
        this.f2407X = f;
    }

    public void setFlags(@NonNull String str) {
        if (str.isEmpty()) {
            return;
        }
        String[] split = str.split("\\|");
        this.f2412c0 = 0;
        for (String str2 : split) {
            String lowerCase = str2.toLowerCase();
            lowerCase.getClass();
            if (lowerCase.equals("subgridbycolrow")) {
                this.f2412c0 |= 1;
            } else if (lowerCase.equals("spansrespectwidgetorder")) {
                this.f2412c0 |= 2;
            }
        }
    }
}
