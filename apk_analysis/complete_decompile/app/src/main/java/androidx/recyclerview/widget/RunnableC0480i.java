package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.recyclerview.widget.i */
/* loaded from: classes.dex */
public final class RunnableC0480i implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ ArrayList f7402a;

    /* renamed from: b */
    public final /* synthetic */ DefaultItemAnimator f7403b;

    public RunnableC0480i(DefaultItemAnimator defaultItemAnimator, ArrayList arrayList) {
        this.f7403b = defaultItemAnimator;
        this.f7402a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.f7402a;
        Iterator it = arrayList.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            DefaultItemAnimator defaultItemAnimator = this.f7403b;
            if (hasNext) {
                C0500q c0500q = (C0500q) it.next();
                RecyclerView.ViewHolder viewHolder = c0500q.f7461a;
                defaultItemAnimator.getClass();
                View view = viewHolder.itemView;
                int i = c0500q.f7464d - c0500q.f7462b;
                int i2 = c0500q.f7465e - c0500q.f7463c;
                if (i != 0) {
                    view.animate().translationX(RecyclerView.f7068F0);
                }
                if (i2 != 0) {
                    view.animate().translationY(RecyclerView.f7068F0);
                }
                ViewPropertyAnimator animate = view.animate();
                defaultItemAnimator.f6972p.add(viewHolder);
                animate.setDuration(defaultItemAnimator.getMoveDuration()).setListener(new C0492m(defaultItemAnimator, viewHolder, i, view, i2, animate)).start();
            } else {
                arrayList.clear();
                defaultItemAnimator.f6969m.remove(arrayList);
                return;
            }
        }
    }
}
