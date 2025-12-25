package androidx.leanback.widget;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.leanback.widget.Presenter;
import p000.a52;

/* renamed from: androidx.leanback.widget.q */
/* loaded from: classes.dex */
public class C0376q extends Presenter {

    /* renamed from: f */
    public static int f6392f;

    /* renamed from: g */
    public static int f6393g;

    /* renamed from: b */
    public InterfaceC0352k f6394b;

    /* renamed from: c */
    public InterfaceC0356l f6395c;

    /* renamed from: d */
    public final int f6396d;

    /* renamed from: e */
    public boolean f6397e = true;

    public C0376q(int i) {
        this.f6396d = i;
    }

    @Override // androidx.leanback.widget.Presenter
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        C0372p c0372p = (C0372p) viewHolder;
        a52 a52Var = (a52) obj;
        ObjectAdapter objectAdapter = c0372p.f6335b;
        ObjectAdapter objectAdapter2 = a52Var.f43a;
        if (objectAdapter != objectAdapter2) {
            c0372p.f6335b = objectAdapter2;
            if (objectAdapter2 != null) {
                objectAdapter2.registerObserver(c0372p.f6341h);
            }
        }
        Presenter presenter = a52Var.f44b;
        c0372p.f6337d = presenter;
        c0372p.f6336c = a52Var;
        c0372p.m1503d(presenter);
    }

    @Override // androidx.leanback.widget.Presenter
    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new C0372p(this, LayoutInflater.from(viewGroup.getContext()).inflate(this.f6396d, viewGroup, false));
    }

    @Override // androidx.leanback.widget.Presenter
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        C0372p c0372p = (C0372p) viewHolder;
        ObjectAdapter objectAdapter = c0372p.f6335b;
        if (objectAdapter != null) {
            objectAdapter.unregisterObserver(c0372p.f6341h);
            c0372p.f6335b = null;
        }
        c0372p.f6336c = null;
    }
}
