package androidx.leanback.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.leanback.widget.Parallax;
import androidx.recyclerview.widget.RecyclerView;
import p000.g92;
import p000.h92;

/* loaded from: classes.dex */
public class RecyclerViewParallax extends Parallax<ChildPositionProperty> {

    /* renamed from: f */
    public RecyclerView f6075f;

    /* renamed from: g */
    public boolean f6076g;

    /* renamed from: h */
    public final g92 f6077h = new g92(this);

    /* renamed from: i */
    public final h92 f6078i = new h92(0, this);

    /* loaded from: classes.dex */
    public static final class ChildPositionProperty extends Parallax.IntProperty {

        /* renamed from: b */
        public int f6079b;

        /* renamed from: c */
        public int f6080c;

        /* renamed from: d */
        public int f6081d;

        /* renamed from: e */
        public float f6082e;

        public ChildPositionProperty adapterPosition(int i) {
            this.f6079b = i;
            return this;
        }

        public ChildPositionProperty fraction(float f) {
            this.f6082e = f;
            return this;
        }

        public int getAdapterPosition() {
            return this.f6079b;
        }

        public float getFraction() {
            return this.f6082e;
        }

        public int getOffset() {
            return this.f6081d;
        }

        public int getViewId() {
            return this.f6080c;
        }

        public ChildPositionProperty offset(int i) {
            this.f6081d = i;
            return this;
        }

        public ChildPositionProperty viewId(int i) {
            this.f6080c = i;
            return this;
        }
    }

    @Override // androidx.leanback.widget.Parallax
    public float getMaxValue() {
        int width;
        RecyclerView recyclerView = this.f6075f;
        if (recyclerView == null) {
            return RecyclerView.f7068F0;
        }
        if (this.f6076g) {
            width = recyclerView.getHeight();
        } else {
            width = recyclerView.getWidth();
        }
        return width;
    }

    public RecyclerView getRecyclerView() {
        return this.f6075f;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f6075f;
        if (recyclerView2 == recyclerView) {
            return;
        }
        h92 h92Var = this.f6078i;
        g92 g92Var = this.f6077h;
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(g92Var);
            this.f6075f.removeOnLayoutChangeListener(h92Var);
        }
        this.f6075f = recyclerView;
        if (recyclerView != null) {
            recyclerView.getLayoutManager();
            boolean z = false;
            if (RecyclerView.LayoutManager.getProperties(this.f6075f.getContext(), null, 0, 0).orientation == 1) {
                z = true;
            }
            this.f6076g = z;
            this.f6075f.addOnScrollListener(g92Var);
            this.f6075f.addOnLayoutChangeListener(h92Var);
        }
    }

    @Override // androidx.leanback.widget.Parallax
    public void updateValues() {
        RecyclerView.ViewHolder findViewHolderForAdapterPosition;
        for (ChildPositionProperty childPositionProperty : getProperties()) {
            childPositionProperty.getClass();
            RecyclerView recyclerView = this.f6075f;
            if (recyclerView == null) {
                findViewHolderForAdapterPosition = null;
            } else {
                findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(childPositionProperty.f6079b);
            }
            if (findViewHolderForAdapterPosition == null) {
                if (recyclerView != null && recyclerView.getLayoutManager().getChildCount() != 0) {
                    if (recyclerView.findContainingViewHolder(recyclerView.getLayoutManager().getChildAt(0)).getAbsoluteAdapterPosition() < childPositionProperty.f6079b) {
                        m1457a(childPositionProperty.getIndex(), Integer.MAX_VALUE);
                    } else {
                        m1457a(childPositionProperty.getIndex(), Integer.MIN_VALUE);
                    }
                } else {
                    m1457a(childPositionProperty.getIndex(), Integer.MAX_VALUE);
                }
            } else {
                View findViewById = findViewHolderForAdapterPosition.itemView.findViewById(childPositionProperty.f6080c);
                if (findViewById != null) {
                    Rect rect = new Rect(0, 0, findViewById.getWidth(), findViewById.getHeight());
                    recyclerView.offsetDescendantRectToMyCoords(findViewById, rect);
                    float f = RecyclerView.f7068F0;
                    float f2 = 0.0f;
                    while (findViewById != recyclerView && findViewById != null) {
                        if (findViewById.getParent() != recyclerView || !recyclerView.isAnimating()) {
                            float translationX = findViewById.getTranslationX() + f;
                            f2 = findViewById.getTranslationY() + f2;
                            f = translationX;
                        }
                        findViewById = (View) findViewById.getParent();
                    }
                    rect.offset((int) f, (int) f2);
                    if (this.f6076g) {
                        m1457a(childPositionProperty.getIndex(), rect.top + childPositionProperty.f6081d + ((int) (childPositionProperty.f6082e * rect.height())));
                    } else {
                        m1457a(childPositionProperty.getIndex(), rect.left + childPositionProperty.f6081d + ((int) (childPositionProperty.f6082e * rect.width())));
                    }
                }
            }
        }
        super.updateValues();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.leanback.widget.Parallax$IntProperty, androidx.leanback.widget.RecyclerViewParallax$ChildPositionProperty] */
    @Override // androidx.leanback.widget.Parallax
    public ChildPositionProperty createProperty(String str, int i) {
        return new Parallax.IntProperty(str, i);
    }
}
