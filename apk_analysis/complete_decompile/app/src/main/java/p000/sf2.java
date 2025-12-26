package p000;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public final class sf2 extends TouchDelegate {

    /* renamed from: a */
    public final View f26408a;

    /* renamed from: b */
    public final Rect f26409b;

    /* renamed from: c */
    public final Rect f26410c;

    /* renamed from: d */
    public final Rect f26411d;

    /* renamed from: e */
    public final int f26412e;

    /* renamed from: f */
    public boolean f26413f;

    public sf2(View view, Rect rect, Rect rect2) {
        super(rect, view);
        int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f26412e = scaledTouchSlop;
        Rect rect3 = new Rect();
        this.f26409b = rect3;
        Rect rect4 = new Rect();
        this.f26411d = rect4;
        Rect rect5 = new Rect();
        this.f26410c = rect5;
        rect3.set(rect);
        rect4.set(rect);
        int i = -scaledTouchSlop;
        rect4.inset(i, i);
        rect5.set(rect2);
        this.f26408a = view;
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z3 = true;
        if (action != 0) {
            if (action != 1 && action != 2) {
                if (action == 3) {
                    z2 = this.f26413f;
                    this.f26413f = false;
                }
                z = true;
                z3 = false;
            } else {
                z2 = this.f26413f;
                if (z2 && !this.f26411d.contains(x, y)) {
                    z3 = z2;
                    z = false;
                }
            }
            z3 = z2;
            z = true;
        } else {
            if (this.f26409b.contains(x, y)) {
                this.f26413f = true;
                z = true;
            }
            z = true;
            z3 = false;
        }
        if (!z3) {
            return false;
        }
        Rect rect = this.f26410c;
        View view = this.f26408a;
        if (z && !rect.contains(x, y)) {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        } else {
            motionEvent.setLocation(x - rect.left, y - rect.top);
        }
        return view.dispatchTouchEvent(motionEvent);
    }
}
