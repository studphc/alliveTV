package androidx.recyclerview.widget;

import android.graphics.Rect;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.v */
/* loaded from: classes.dex */
public final class RunnableC0510v implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ ItemTouchHelper f7511a;

    public RunnableC0510v(ItemTouchHelper itemTouchHelper) {
        this.f7511a = itemTouchHelper;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0054, code lost:
    
        if (r12 < 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0077, code lost:
    
        if (r12 > 0) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fc  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        long j;
        int i;
        int i2;
        int i3;
        RecyclerView.ViewHolder viewHolder;
        ItemTouchHelper itemTouchHelper = this.f7511a;
        if (itemTouchHelper.f7007c != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = itemTouchHelper.f7004B;
            if (j2 == Long.MIN_VALUE) {
                j = 0;
            } else {
                j = currentTimeMillis - j2;
            }
            RecyclerView.LayoutManager layoutManager = itemTouchHelper.f7022r.getLayoutManager();
            if (itemTouchHelper.f7003A == null) {
                itemTouchHelper.f7003A = new Rect();
            }
            layoutManager.calculateItemDecorationsForChild(itemTouchHelper.f7007c.itemView, itemTouchHelper.f7003A);
            if (layoutManager.canScrollHorizontally()) {
                int i4 = (int) (itemTouchHelper.f7014j + itemTouchHelper.f7012h);
                i = (i4 - itemTouchHelper.f7003A.left) - itemTouchHelper.f7022r.getPaddingLeft();
                float f = itemTouchHelper.f7012h;
                if (f < RecyclerView.f7068F0) {
                }
                if (f > RecyclerView.f7068F0) {
                    i = ((itemTouchHelper.f7007c.itemView.getWidth() + i4) + itemTouchHelper.f7003A.right) - (itemTouchHelper.f7022r.getWidth() - itemTouchHelper.f7022r.getPaddingRight());
                }
            }
            i = 0;
            if (layoutManager.canScrollVertically()) {
                int i5 = (int) (itemTouchHelper.f7015k + itemTouchHelper.f7013i);
                int paddingTop = (i5 - itemTouchHelper.f7003A.top) - itemTouchHelper.f7022r.getPaddingTop();
                float f2 = itemTouchHelper.f7013i;
                if ((f2 < RecyclerView.f7068F0 && paddingTop < 0) || (f2 > RecyclerView.f7068F0 && (paddingTop = ((itemTouchHelper.f7007c.itemView.getHeight() + i5) + itemTouchHelper.f7003A.bottom) - (itemTouchHelper.f7022r.getHeight() - itemTouchHelper.f7022r.getPaddingBottom())) > 0)) {
                    i2 = paddingTop;
                    if (i != 0) {
                        i = itemTouchHelper.f7017m.interpolateOutOfBoundsScroll(itemTouchHelper.f7022r, itemTouchHelper.f7007c.itemView.getWidth(), i, itemTouchHelper.f7022r.getWidth(), j);
                    }
                    int i6 = i;
                    if (i2 == 0) {
                        i3 = i6;
                        i2 = itemTouchHelper.f7017m.interpolateOutOfBoundsScroll(itemTouchHelper.f7022r, itemTouchHelper.f7007c.itemView.getHeight(), i2, itemTouchHelper.f7022r.getHeight(), j);
                    } else {
                        i3 = i6;
                    }
                    if (i3 != 0 && i2 == 0) {
                        itemTouchHelper.f7004B = Long.MIN_VALUE;
                        return;
                    }
                    if (itemTouchHelper.f7004B == Long.MIN_VALUE) {
                        itemTouchHelper.f7004B = currentTimeMillis;
                    }
                    itemTouchHelper.f7022r.scrollBy(i3, i2);
                    viewHolder = itemTouchHelper.f7007c;
                    if (viewHolder != null) {
                        itemTouchHelper.m1637h(viewHolder);
                    }
                    itemTouchHelper.f7022r.removeCallbacks(itemTouchHelper.f7023s);
                    ViewCompat.postOnAnimation(itemTouchHelper.f7022r, this);
                }
            }
            i2 = 0;
            if (i != 0) {
            }
            int i62 = i;
            if (i2 == 0) {
            }
            if (i3 != 0) {
            }
            if (itemTouchHelper.f7004B == Long.MIN_VALUE) {
            }
            itemTouchHelper.f7022r.scrollBy(i3, i2);
            viewHolder = itemTouchHelper.f7007c;
            if (viewHolder != null) {
            }
            itemTouchHelper.f7022r.removeCallbacks(itemTouchHelper.f7023s);
            ViewCompat.postOnAnimation(itemTouchHelper.f7022r, this);
        }
    }
}
