package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.Presenter;

/* renamed from: androidx.leanback.widget.o */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0368o implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ int f6330a;

    /* renamed from: b */
    public final /* synthetic */ Presenter.ViewHolder f6331b;

    /* renamed from: c */
    public final /* synthetic */ C0372p f6332c;

    public ViewOnClickListenerC0368o(C0372p c0372p, int i, Presenter.ViewHolder viewHolder) {
        this.f6332c = c0372p;
        this.f6330a = i;
        this.f6331b = viewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C0372p c0372p = this.f6332c;
        Object obj = c0372p.mo1502c().get(this.f6330a);
        InterfaceC0352k interfaceC0352k = c0372p.f6342i.f6394b;
        if (interfaceC0352k != null) {
            interfaceC0352k.mo1496a(this.f6331b, obj, c0372p.f6336c);
        }
    }
}
