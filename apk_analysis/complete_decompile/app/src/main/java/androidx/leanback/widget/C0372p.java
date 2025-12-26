package androidx.leanback.widget;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import androidx.leanback.widget.Presenter;
import p000.a52;

/* renamed from: androidx.leanback.widget.p */
/* loaded from: classes.dex */
public class C0372p extends Presenter.ViewHolder {

    /* renamed from: b */
    public ObjectAdapter f6335b;

    /* renamed from: c */
    public a52 f6336c;

    /* renamed from: d */
    public Presenter f6337d;

    /* renamed from: e */
    public final ControlBar f6338e;

    /* renamed from: f */
    public final View f6339f;

    /* renamed from: g */
    public final SparseArray f6340g;

    /* renamed from: h */
    public final C0364n f6341h;

    /* renamed from: i */
    public final /* synthetic */ C0376q f6342i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0372p(C0376q c0376q, View view) {
        super(view);
        this.f6342i = c0376q;
        this.f6340g = new SparseArray();
        this.f6339f = view.findViewById(androidx.leanback.R.id.controls_container);
        ControlBar controlBar = (ControlBar) view.findViewById(androidx.leanback.R.id.control_bar);
        this.f6338e = controlBar;
        if (controlBar != null) {
            controlBar.f5605d = c0376q.f6397e;
            controlBar.f5603b = new C0360m(this);
            this.f6341h = new C0364n(this);
            return;
        }
        throw new IllegalStateException("Couldn't find control_bar");
    }

    /* renamed from: a */
    public final void m1500a(int i, ObjectAdapter objectAdapter, Presenter presenter) {
        SparseArray sparseArray = this.f6340g;
        Presenter.ViewHolder viewHolder = (Presenter.ViewHolder) sparseArray.get(i);
        Object obj = objectAdapter.get(i);
        ControlBar controlBar = this.f6338e;
        if (viewHolder == null) {
            viewHolder = presenter.onCreateViewHolder(controlBar);
            sparseArray.put(i, viewHolder);
            presenter.setOnClickListener(viewHolder, new ViewOnClickListenerC0368o(this, i, viewHolder));
        }
        if (viewHolder.view.getParent() == null) {
            controlBar.addView(viewHolder.view);
        }
        presenter.onBindViewHolder(viewHolder, obj);
    }

    /* renamed from: b */
    public int mo1501b(int i, Context context) {
        this.f6342i.getClass();
        if (C0376q.f6392f == 0) {
            C0376q.f6392f = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_controls_child_margin_default);
        }
        int i2 = C0376q.f6392f;
        if (C0376q.f6393g == 0) {
            C0376q.f6393g = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_control_icon_width);
        }
        return C0376q.f6393g + i2;
    }

    /* renamed from: c */
    public ObjectAdapter mo1502c() {
        return this.f6335b;
    }

    /* renamed from: d */
    public final void m1503d(Presenter presenter) {
        int size;
        ObjectAdapter mo1502c = mo1502c();
        if (mo1502c == null) {
            size = 0;
        } else {
            size = mo1502c.size();
        }
        ControlBar controlBar = this.f6338e;
        View focusedChild = controlBar.getFocusedChild();
        if (focusedChild != null && size > 0 && controlBar.indexOfChild(focusedChild) >= size) {
            controlBar.getChildAt(mo1502c.size() - 1).requestFocus();
        }
        for (int childCount = controlBar.getChildCount() - 1; childCount >= size; childCount--) {
            controlBar.removeViewAt(childCount);
        }
        for (int i = 0; i < size && i < 7; i++) {
            m1500a(i, mo1502c, presenter);
        }
        controlBar.f5602a = mo1501b(size, controlBar.getContext());
    }
}
