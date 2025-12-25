package p000;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.exoplayer2.video.spherical.OrientationListener$Listener;

/* loaded from: classes.dex */
public final class av2 extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, OrientationListener$Listener {

    /* renamed from: c */
    public final bm2 f7758c;

    /* renamed from: e */
    public final GestureDetector f7760e;

    /* renamed from: a */
    public final PointF f7756a = new PointF();

    /* renamed from: b */
    public final PointF f7757b = new PointF();

    /* renamed from: d */
    public final float f7759d = 25.0f;

    /* renamed from: f */
    public volatile float f7761f = 3.1415927f;

    public av2(Context context, bm2 bm2Var) {
        this.f7758c = bm2Var;
        this.f7760e = new GestureDetector(context, this);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        this.f7756a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // com.google.android.exoplayer2.video.spherical.OrientationListener$Listener
    public final void onOrientationChange(float[] fArr, float f) {
        this.f7761f = -f;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float x = (motionEvent2.getX() - this.f7756a.x) / this.f7759d;
        float y = motionEvent2.getY();
        PointF pointF = this.f7756a;
        float f3 = (y - pointF.y) / this.f7759d;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d = this.f7761f;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        PointF pointF2 = this.f7757b;
        pointF2.x -= (cos * x) - (sin * f3);
        float f4 = (cos * f3) + (sin * x) + pointF2.y;
        pointF2.y = f4;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f4));
        this.f7758c.onScrollChange(this.f7757b);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f7758c.f8095k.performClick();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f7760e.onTouchEvent(motionEvent);
    }
}
