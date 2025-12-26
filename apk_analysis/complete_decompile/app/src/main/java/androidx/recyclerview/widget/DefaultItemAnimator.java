package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000.xy1;

/* loaded from: classes.dex */
public class DefaultItemAnimator extends SimpleItemAnimator {

    /* renamed from: s */
    public static TimeInterpolator f6963s;

    /* renamed from: h */
    public final ArrayList f6964h = new ArrayList();

    /* renamed from: i */
    public final ArrayList f6965i = new ArrayList();

    /* renamed from: j */
    public final ArrayList f6966j = new ArrayList();

    /* renamed from: k */
    public final ArrayList f6967k = new ArrayList();

    /* renamed from: l */
    public final ArrayList f6968l = new ArrayList();

    /* renamed from: m */
    public final ArrayList f6969m = new ArrayList();

    /* renamed from: n */
    public final ArrayList f6970n = new ArrayList();

    /* renamed from: o */
    public final ArrayList f6971o = new ArrayList();

    /* renamed from: p */
    public final ArrayList f6972p = new ArrayList();

    /* renamed from: q */
    public final ArrayList f6973q = new ArrayList();

    /* renamed from: r */
    public final ArrayList f6974r = new ArrayList();

    /* renamed from: b */
    public static void m1607b(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((RecyclerView.ViewHolder) arrayList.get(size)).itemView.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    @SuppressLint({"UnknownNullness"})
    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        m1611f(viewHolder);
        viewHolder.itemView.setAlpha(RecyclerView.f7068F0);
        this.f6965i.add(viewHolder);
        return true;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.recyclerview.widget.p, java.lang.Object] */
    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    @SuppressLint({"UnknownNullness"})
    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        if (viewHolder == viewHolder2) {
            return animateMove(viewHolder, i, i2, i3, i4);
        }
        float translationX = viewHolder.itemView.getTranslationX();
        float translationY = viewHolder.itemView.getTranslationY();
        float alpha = viewHolder.itemView.getAlpha();
        m1611f(viewHolder);
        int i5 = (int) ((i3 - i) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        viewHolder.itemView.setTranslationX(translationX);
        viewHolder.itemView.setTranslationY(translationY);
        viewHolder.itemView.setAlpha(alpha);
        if (viewHolder2 != null) {
            m1611f(viewHolder2);
            viewHolder2.itemView.setTranslationX(-i5);
            viewHolder2.itemView.setTranslationY(-i6);
            viewHolder2.itemView.setAlpha(RecyclerView.f7068F0);
        }
        ArrayList arrayList = this.f6967k;
        ?? obj = new Object();
        obj.f7454a = viewHolder;
        obj.f7455b = viewHolder2;
        obj.f7456c = i;
        obj.f7457d = i2;
        obj.f7458e = i3;
        obj.f7459f = i4;
        arrayList.add(obj);
        return true;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object, androidx.recyclerview.widget.q] */
    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    @SuppressLint({"UnknownNullness"})
    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.itemView;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) viewHolder.itemView.getTranslationY());
        m1611f(viewHolder);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        ArrayList arrayList = this.f6966j;
        ?? obj = new Object();
        obj.f7461a = viewHolder;
        obj.f7462b = translationX;
        obj.f7463c = translationY;
        obj.f7464d = i3;
        obj.f7465e = i4;
        arrayList.add(obj);
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    @SuppressLint({"UnknownNullness"})
    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        m1611f(viewHolder);
        this.f6964h.add(viewHolder);
        return true;
    }

    /* renamed from: c */
    public final void m1608c() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list) {
        if (list.isEmpty() && !super.canReuseUpdatedViewHolder(viewHolder, list)) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    public final void m1609d(ArrayList arrayList, RecyclerView.ViewHolder viewHolder) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            C0498p c0498p = (C0498p) arrayList.get(size);
            if (m1610e(c0498p, viewHolder) && c0498p.f7454a == null && c0498p.f7455b == null) {
                arrayList.remove(c0498p);
            }
        }
    }

    /* renamed from: e */
    public final boolean m1610e(C0498p c0498p, RecyclerView.ViewHolder viewHolder) {
        boolean z = false;
        if (c0498p.f7455b == viewHolder) {
            c0498p.f7455b = null;
        } else {
            if (c0498p.f7454a != viewHolder) {
                return false;
            }
            c0498p.f7454a = null;
            z = true;
        }
        viewHolder.itemView.setAlpha(1.0f);
        viewHolder.itemView.setTranslationX(RecyclerView.f7068F0);
        viewHolder.itemView.setTranslationY(RecyclerView.f7068F0);
        dispatchChangeFinished(viewHolder, z);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    @SuppressLint({"UnknownNullness"})
    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        view.animate().cancel();
        ArrayList arrayList = this.f6966j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((C0500q) arrayList.get(size)).f7461a == viewHolder) {
                view.setTranslationY(RecyclerView.f7068F0);
                view.setTranslationX(RecyclerView.f7068F0);
                dispatchMoveFinished(viewHolder);
                arrayList.remove(size);
            }
        }
        m1609d(this.f6967k, viewHolder);
        if (this.f6964h.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.f6965i.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
        }
        ArrayList arrayList2 = this.f6970n;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList3 = (ArrayList) arrayList2.get(size2);
            m1609d(arrayList3, viewHolder);
            if (arrayList3.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
        ArrayList arrayList4 = this.f6969m;
        for (int size3 = arrayList4.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList5 = (ArrayList) arrayList4.get(size3);
            int size4 = arrayList5.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((C0500q) arrayList5.get(size4)).f7461a == viewHolder) {
                    view.setTranslationY(RecyclerView.f7068F0);
                    view.setTranslationX(RecyclerView.f7068F0);
                    dispatchMoveFinished(viewHolder);
                    arrayList5.remove(size4);
                    if (arrayList5.isEmpty()) {
                        arrayList4.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        ArrayList arrayList6 = this.f6968l;
        for (int size5 = arrayList6.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList7 = (ArrayList) arrayList6.get(size5);
            if (arrayList7.remove(viewHolder)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(viewHolder);
                if (arrayList7.isEmpty()) {
                    arrayList6.remove(size5);
                }
            }
        }
        this.f6973q.remove(viewHolder);
        this.f6971o.remove(viewHolder);
        this.f6974r.remove(viewHolder);
        this.f6972p.remove(viewHolder);
        m1608c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        ArrayList arrayList = this.f6966j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            C0500q c0500q = (C0500q) arrayList.get(size);
            View view = c0500q.f7461a.itemView;
            view.setTranslationY(RecyclerView.f7068F0);
            view.setTranslationX(RecyclerView.f7068F0);
            dispatchMoveFinished(c0500q.f7461a);
            arrayList.remove(size);
        }
        ArrayList arrayList2 = this.f6964h;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished((RecyclerView.ViewHolder) arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        ArrayList arrayList3 = this.f6965i;
        int size3 = arrayList3.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) arrayList3.get(size3);
            viewHolder.itemView.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
            arrayList3.remove(size3);
        }
        ArrayList arrayList4 = this.f6967k;
        for (int size4 = arrayList4.size() - 1; size4 >= 0; size4--) {
            C0498p c0498p = (C0498p) arrayList4.get(size4);
            RecyclerView.ViewHolder viewHolder2 = c0498p.f7454a;
            if (viewHolder2 != null) {
                m1610e(c0498p, viewHolder2);
            }
            RecyclerView.ViewHolder viewHolder3 = c0498p.f7455b;
            if (viewHolder3 != null) {
                m1610e(c0498p, viewHolder3);
            }
        }
        arrayList4.clear();
        if (!isRunning()) {
            return;
        }
        ArrayList arrayList5 = this.f6969m;
        for (int size5 = arrayList5.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList6 = (ArrayList) arrayList5.get(size5);
            for (int size6 = arrayList6.size() - 1; size6 >= 0; size6--) {
                C0500q c0500q2 = (C0500q) arrayList6.get(size6);
                View view2 = c0500q2.f7461a.itemView;
                view2.setTranslationY(RecyclerView.f7068F0);
                view2.setTranslationX(RecyclerView.f7068F0);
                dispatchMoveFinished(c0500q2.f7461a);
                arrayList6.remove(size6);
                if (arrayList6.isEmpty()) {
                    arrayList5.remove(arrayList6);
                }
            }
        }
        ArrayList arrayList7 = this.f6968l;
        for (int size7 = arrayList7.size() - 1; size7 >= 0; size7--) {
            ArrayList arrayList8 = (ArrayList) arrayList7.get(size7);
            for (int size8 = arrayList8.size() - 1; size8 >= 0; size8--) {
                RecyclerView.ViewHolder viewHolder4 = (RecyclerView.ViewHolder) arrayList8.get(size8);
                viewHolder4.itemView.setAlpha(1.0f);
                dispatchAddFinished(viewHolder4);
                arrayList8.remove(size8);
                if (arrayList8.isEmpty()) {
                    arrayList7.remove(arrayList8);
                }
            }
        }
        ArrayList arrayList9 = this.f6970n;
        for (int size9 = arrayList9.size() - 1; size9 >= 0; size9--) {
            ArrayList arrayList10 = (ArrayList) arrayList9.get(size9);
            for (int size10 = arrayList10.size() - 1; size10 >= 0; size10--) {
                C0498p c0498p2 = (C0498p) arrayList10.get(size10);
                RecyclerView.ViewHolder viewHolder5 = c0498p2.f7454a;
                if (viewHolder5 != null) {
                    m1610e(c0498p2, viewHolder5);
                }
                RecyclerView.ViewHolder viewHolder6 = c0498p2.f7455b;
                if (viewHolder6 != null) {
                    m1610e(c0498p2, viewHolder6);
                }
                if (arrayList10.isEmpty()) {
                    arrayList9.remove(arrayList10);
                }
            }
        }
        m1607b(this.f6973q);
        m1607b(this.f6972p);
        m1607b(this.f6971o);
        m1607b(this.f6974r);
        dispatchAnimationsFinished();
    }

    /* renamed from: f */
    public final void m1611f(RecyclerView.ViewHolder viewHolder) {
        if (f6963s == null) {
            f6963s = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(f6963s);
        endAnimation(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        if (this.f6965i.isEmpty() && this.f6967k.isEmpty() && this.f6966j.isEmpty() && this.f6964h.isEmpty() && this.f6972p.isEmpty() && this.f6973q.isEmpty() && this.f6971o.isEmpty() && this.f6974r.isEmpty() && this.f6969m.isEmpty() && this.f6968l.isEmpty() && this.f6970n.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        long j;
        long j2;
        ArrayList arrayList = this.f6964h;
        boolean isEmpty = arrayList.isEmpty();
        ArrayList arrayList2 = this.f6966j;
        boolean isEmpty2 = arrayList2.isEmpty();
        ArrayList arrayList3 = this.f6967k;
        boolean isEmpty3 = arrayList3.isEmpty();
        ArrayList arrayList4 = this.f6965i;
        boolean isEmpty4 = arrayList4.isEmpty();
        if (isEmpty && isEmpty2 && isEmpty4 && isEmpty3) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) it.next();
            View view = viewHolder.itemView;
            ViewPropertyAnimator animate = view.animate();
            this.f6973q.add(viewHolder);
            animate.setDuration(getRemoveDuration()).alpha(RecyclerView.f7068F0).setListener(new C0486k(view, animate, this, viewHolder)).start();
        }
        arrayList.clear();
        if (!isEmpty2) {
            ArrayList arrayList5 = new ArrayList();
            arrayList5.addAll(arrayList2);
            this.f6969m.add(arrayList5);
            arrayList2.clear();
            RunnableC0480i runnableC0480i = new RunnableC0480i(this, arrayList5);
            if (!isEmpty) {
                ViewCompat.postOnAnimationDelayed(((C0500q) arrayList5.get(0)).f7461a.itemView, runnableC0480i, getRemoveDuration());
            } else {
                runnableC0480i.run();
            }
        }
        if (!isEmpty3) {
            ArrayList arrayList6 = new ArrayList();
            arrayList6.addAll(arrayList3);
            this.f6970n.add(arrayList6);
            arrayList3.clear();
            xy1 xy1Var = new xy1(5, this, arrayList6);
            if (!isEmpty) {
                ViewCompat.postOnAnimationDelayed(((C0498p) arrayList6.get(0)).f7454a.itemView, xy1Var, getRemoveDuration());
            } else {
                xy1Var.run();
            }
        }
        if (!isEmpty4) {
            ArrayList arrayList7 = new ArrayList();
            arrayList7.addAll(arrayList4);
            this.f6968l.add(arrayList7);
            arrayList4.clear();
            RunnableC0483j runnableC0483j = new RunnableC0483j(this, arrayList7);
            if (isEmpty && isEmpty2 && isEmpty3) {
                runnableC0483j.run();
                return;
            }
            long j3 = 0;
            if (!isEmpty) {
                j = getRemoveDuration();
            } else {
                j = 0;
            }
            if (!isEmpty2) {
                j2 = getMoveDuration();
            } else {
                j2 = 0;
            }
            if (!isEmpty3) {
                j3 = getChangeDuration();
            }
            ViewCompat.postOnAnimationDelayed(((RecyclerView.ViewHolder) arrayList7.get(0)).itemView, runnableC0483j, Math.max(j2, j3) + j);
        }
    }
}
