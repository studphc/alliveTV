package androidx.core.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.DragStartHelper;
import p000.h60;
import p000.i60;

/* loaded from: classes.dex */
public class DragStartHelper {

    /* renamed from: a */
    public final View f3874a;

    /* renamed from: b */
    public final OnDragStartListener f3875b;

    /* renamed from: c */
    public int f3876c;

    /* renamed from: d */
    public int f3877d;

    /* renamed from: e */
    public boolean f3878e;

    /* renamed from: f */
    public final h60 f3879f = new View.OnLongClickListener() { // from class: h60
        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            return DragStartHelper.this.onLongClick(view);
        }
    };

    /* renamed from: g */
    public final i60 f3880g = new View.OnTouchListener() { // from class: i60
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return DragStartHelper.this.onTouch(view, motionEvent);
        }
    };

    /* loaded from: classes.dex */
    public interface OnDragStartListener {
        boolean onDragStart(@NonNull View view, @NonNull DragStartHelper dragStartHelper);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [h60] */
    /* JADX WARN: Type inference failed for: r0v1, types: [i60] */
    public DragStartHelper(@NonNull View view, @NonNull OnDragStartListener onDragStartListener) {
        this.f3874a = view;
        this.f3875b = onDragStartListener;
    }

    public void attach() {
        h60 h60Var = this.f3879f;
        View view = this.f3874a;
        view.setOnLongClickListener(h60Var);
        view.setOnTouchListener(this.f3880g);
    }

    public void detach() {
        View view = this.f3874a;
        view.setOnLongClickListener(null);
        view.setOnTouchListener(null);
    }

    public void getTouchPosition(@NonNull Point point) {
        point.set(this.f3876c, this.f3877d);
    }

    public boolean onLongClick(@NonNull View view) {
        if (this.f3878e) {
            return true;
        }
        boolean onDragStart = this.f3875b.onDragStart(view, this);
        this.f3878e = onDragStart;
        return onDragStart;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        if (r2 != 3) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (MotionEventCompat.isFromSource(motionEvent, 8194) && (motionEvent.getButtonState() & 1) != 0 && !this.f3878e && (this.f3876c != x || this.f3877d != y)) {
                        this.f3876c = x;
                        this.f3877d = y;
                        boolean onDragStart = this.f3875b.onDragStart(view, this);
                        this.f3878e = onDragStart;
                        return onDragStart;
                    }
                }
            }
            this.f3878e = false;
        } else {
            this.f3876c = x;
            this.f3877d = y;
        }
        return false;
    }
}
