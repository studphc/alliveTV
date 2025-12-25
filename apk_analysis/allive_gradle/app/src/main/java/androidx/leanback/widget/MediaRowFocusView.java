package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.RecyclerView;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
class MediaRowFocusView extends View {

    /* renamed from: a */
    public final Paint f5918a;

    /* renamed from: b */
    public final RectF f5919b;

    /* renamed from: c */
    public int f5920c;

    public MediaRowFocusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5919b = new RectF();
        Paint paint = new Paint();
        paint.setColor(context.getResources().getColor(androidx.leanback.R.color.lb_playback_media_row_highlight_color));
        this.f5918a = paint;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        this.f5920c = height;
        int height2 = ((height * 2) - getHeight()) / 2;
        RectF rectF = this.f5919b;
        rectF.set(RecyclerView.f7068F0, -height2, getWidth(), getHeight() + height2);
        int i = this.f5920c;
        canvas.drawRoundRect(rectF, i, i, this.f5918a);
    }
}
