package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.recyclerview.widget.j */
/* loaded from: classes.dex */
public final class RunnableC0483j implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ ArrayList f7411a;

    /* renamed from: b */
    public final /* synthetic */ DefaultItemAnimator f7412b;

    public RunnableC0483j(DefaultItemAnimator defaultItemAnimator, ArrayList arrayList) {
        this.f7412b = defaultItemAnimator;
        this.f7411a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.f7411a;
        Iterator it = arrayList.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            DefaultItemAnimator defaultItemAnimator = this.f7412b;
            if (hasNext) {
                RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) it.next();
                defaultItemAnimator.getClass();
                View view = viewHolder.itemView;
                ViewPropertyAnimator animate = view.animate();
                defaultItemAnimator.f6971o.add(viewHolder);
                animate.alpha(1.0f).setDuration(defaultItemAnimator.getAddDuration()).setListener(new C0489l(view, animate, defaultItemAnimator, viewHolder)).start();
            } else {
                arrayList.clear();
                defaultItemAnimator.f6968l.remove(arrayList);
                return;
            }
        }
    }
}
