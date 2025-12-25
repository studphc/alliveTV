package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.Reference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class GuidelineReference implements Facade, Reference {

    /* renamed from: a */
    public final State f2413a;

    /* renamed from: b */
    public int f2414b;

    /* renamed from: c */
    public Guideline f2415c;

    /* renamed from: d */
    public int f2416d = -1;

    /* renamed from: e */
    public int f2417e = -1;

    /* renamed from: f */
    public float f2418f = RecyclerView.f7068F0;

    /* renamed from: g */
    public Object f2419g;

    public GuidelineReference(State state) {
        this.f2413a = state;
    }

    @Override // androidx.constraintlayout.core.state.helpers.Facade, androidx.constraintlayout.core.state.Reference
    public void apply() {
        this.f2415c.setOrientation(this.f2414b);
        int i = this.f2416d;
        if (i != -1) {
            this.f2415c.setGuideBegin(i);
            return;
        }
        int i2 = this.f2417e;
        if (i2 != -1) {
            this.f2415c.setGuideEnd(i2);
        } else {
            this.f2415c.setGuidePercent(this.f2418f);
        }
    }

    public GuidelineReference end(Object obj) {
        this.f2416d = -1;
        this.f2417e = this.f2413a.convertDimension(obj);
        this.f2418f = RecyclerView.f7068F0;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.helpers.Facade, androidx.constraintlayout.core.state.Reference
    public ConstraintWidget getConstraintWidget() {
        if (this.f2415c == null) {
            this.f2415c = new Guideline();
        }
        return this.f2415c;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public Facade getFacade() {
        return null;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public Object getKey() {
        return this.f2419g;
    }

    public int getOrientation() {
        return this.f2414b;
    }

    public GuidelineReference percent(float f) {
        this.f2416d = -1;
        this.f2417e = -1;
        this.f2418f = f;
        return this;
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void setConstraintWidget(ConstraintWidget constraintWidget) {
        if (constraintWidget instanceof Guideline) {
            this.f2415c = (Guideline) constraintWidget;
        } else {
            this.f2415c = null;
        }
    }

    @Override // androidx.constraintlayout.core.state.Reference
    public void setKey(Object obj) {
        this.f2419g = obj;
    }

    public void setOrientation(int i) {
        this.f2414b = i;
    }

    public GuidelineReference start(Object obj) {
        this.f2416d = this.f2413a.convertDimension(obj);
        this.f2417e = -1;
        this.f2418f = RecyclerView.f7068F0;
        return this;
    }
}
