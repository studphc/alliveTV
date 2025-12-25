package androidx.recyclerview.widget;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* renamed from: androidx.recyclerview.widget.w */
/* loaded from: classes.dex */
public final class C0512w implements RecyclerView.OnItemTouchListener {

    /* renamed from: a */
    public final /* synthetic */ ItemTouchHelper f7513a;

    public C0512w(ItemTouchHelper itemTouchHelper) {
        this.f7513a = itemTouchHelper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int findPointerIndex;
        ItemTouchHelper itemTouchHelper = this.f7513a;
        itemTouchHelper.f7028x.onTouchEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        AbstractC0466d0 abstractC0466d0 = null;
        if (actionMasked == 0) {
            itemTouchHelper.f7016l = motionEvent.getPointerId(0);
            itemTouchHelper.f7008d = motionEvent.getX();
            itemTouchHelper.f7009e = motionEvent.getY();
            VelocityTracker velocityTracker = itemTouchHelper.f7024t;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            itemTouchHelper.f7024t = VelocityTracker.obtain();
            if (itemTouchHelper.f7007c == null) {
                ArrayList arrayList = itemTouchHelper.f7020p;
                if (!arrayList.isEmpty()) {
                    View m1635e = itemTouchHelper.m1635e(motionEvent);
                    int size = arrayList.size() - 1;
                    while (true) {
                        if (size < 0) {
                            break;
                        }
                        AbstractC0466d0 abstractC0466d02 = (AbstractC0466d0) arrayList.get(size);
                        if (abstractC0466d02.f7341e.itemView == m1635e) {
                            abstractC0466d0 = abstractC0466d02;
                            break;
                        }
                        size--;
                    }
                }
                if (abstractC0466d0 != null) {
                    itemTouchHelper.f7008d -= abstractC0466d0.f7345i;
                    itemTouchHelper.f7009e -= abstractC0466d0.f7346j;
                    RecyclerView.ViewHolder viewHolder = abstractC0466d0.f7341e;
                    itemTouchHelper.m1634d(viewHolder, true);
                    if (itemTouchHelper.f7005a.remove(viewHolder.itemView)) {
                        itemTouchHelper.f7017m.clearView(itemTouchHelper.f7022r, viewHolder);
                    }
                    itemTouchHelper.m1639j(viewHolder, abstractC0466d0.f7342f);
                    itemTouchHelper.m1640k(motionEvent, itemTouchHelper.f7019o, 0);
                }
            }
        } else if (actionMasked != 3 && actionMasked != 1) {
            int i = itemTouchHelper.f7016l;
            if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) >= 0) {
                itemTouchHelper.m1632b(motionEvent, actionMasked, findPointerIndex);
            }
        } else {
            itemTouchHelper.f7016l = -1;
            itemTouchHelper.m1639j(null, 0);
        }
        VelocityTracker velocityTracker2 = itemTouchHelper.f7024t;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        if (itemTouchHelper.f7007c != null) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onRequestDisallowInterceptTouchEvent(boolean z) {
        if (!z) {
            return;
        }
        this.f7513a.m1639j(null, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        ItemTouchHelper itemTouchHelper = this.f7513a;
        itemTouchHelper.f7028x.onTouchEvent(motionEvent);
        VelocityTracker velocityTracker = itemTouchHelper.f7024t;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        if (itemTouchHelper.f7016l == -1) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        int findPointerIndex = motionEvent.findPointerIndex(itemTouchHelper.f7016l);
        if (findPointerIndex >= 0) {
            itemTouchHelper.m1632b(motionEvent, actionMasked, findPointerIndex);
        }
        RecyclerView.ViewHolder viewHolder = itemTouchHelper.f7007c;
        if (viewHolder == null) {
            return;
        }
        int i = 0;
        if (actionMasked != 1) {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        int actionIndex = motionEvent.getActionIndex();
                        if (motionEvent.getPointerId(actionIndex) == itemTouchHelper.f7016l) {
                            if (actionIndex == 0) {
                                i = 1;
                            }
                            itemTouchHelper.f7016l = motionEvent.getPointerId(i);
                            itemTouchHelper.m1640k(motionEvent, itemTouchHelper.f7019o, actionIndex);
                            return;
                        }
                        return;
                    }
                    return;
                }
                VelocityTracker velocityTracker2 = itemTouchHelper.f7024t;
                if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
            } else {
                if (findPointerIndex >= 0) {
                    itemTouchHelper.m1640k(motionEvent, itemTouchHelper.f7019o, findPointerIndex);
                    itemTouchHelper.m1637h(viewHolder);
                    RecyclerView recyclerView2 = itemTouchHelper.f7022r;
                    RunnableC0510v runnableC0510v = itemTouchHelper.f7023s;
                    recyclerView2.removeCallbacks(runnableC0510v);
                    runnableC0510v.run();
                    itemTouchHelper.f7022r.invalidate();
                    return;
                }
                return;
            }
        }
        itemTouchHelper.m1639j(null, 0);
        itemTouchHelper.f7016l = -1;
    }
}
