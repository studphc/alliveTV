package androidx.recyclerview.widget;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.b0 */
/* loaded from: classes.dex */
public final class C0460b0 extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a */
    public boolean f7320a = true;

    /* renamed from: b */
    public final /* synthetic */ ItemTouchHelper f7321b;

    public C0460b0(ItemTouchHelper itemTouchHelper) {
        this.f7321b = itemTouchHelper;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        ItemTouchHelper itemTouchHelper;
        View m1635e;
        RecyclerView.ViewHolder childViewHolder;
        if (this.f7320a && (m1635e = (itemTouchHelper = this.f7321b).m1635e(motionEvent)) != null && (childViewHolder = itemTouchHelper.f7022r.getChildViewHolder(m1635e)) != null) {
            ItemTouchHelper.Callback callback = itemTouchHelper.f7017m;
            RecyclerView recyclerView = itemTouchHelper.f7022r;
            if ((callback.convertToAbsoluteDirection(callback.getMovementFlags(recyclerView, childViewHolder), ViewCompat.getLayoutDirection(recyclerView)) & 16711680) != 0) {
                int pointerId = motionEvent.getPointerId(0);
                int i = itemTouchHelper.f7016l;
                if (pointerId == i) {
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    float x = motionEvent.getX(findPointerIndex);
                    float y = motionEvent.getY(findPointerIndex);
                    itemTouchHelper.f7008d = x;
                    itemTouchHelper.f7009e = y;
                    itemTouchHelper.f7013i = RecyclerView.f7068F0;
                    itemTouchHelper.f7012h = RecyclerView.f7068F0;
                    if (itemTouchHelper.f7017m.isLongPressDragEnabled()) {
                        itemTouchHelper.m1639j(childViewHolder, 2);
                    }
                }
            }
        }
    }
}
