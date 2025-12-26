package p000;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.google.common.base.Splitter;
import java.util.Iterator;
import kotlinx.coroutines.scheduling.TaskContext;

/* loaded from: classes.dex */
public class tx0 implements em2, TaskContext, mv2, c43 {

    /* renamed from: a */
    public final int f27011a;

    public /* synthetic */ tx0(int i) {
        this.f27011a = i;
    }

    @Override // p000.em2
    /* renamed from: a */
    public Iterator mo92a(Splitter splitter, CharSequence charSequence) {
        return new dm2(this, splitter, charSequence, 3);
    }

    @Override // p000.mv2
    /* renamed from: b */
    public void mo5987b(Canvas canvas, Paint paint, RectF rectF) {
        float f = this.f27011a;
        canvas.drawRoundRect(rectF, f, f, paint);
    }

    @Override // p000.c43
    /* renamed from: c */
    public Animation mo94c(Context context) {
        return AnimationUtils.loadAnimation(context, this.f27011a);
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public int getTaskMode() {
        return this.f27011a;
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public void afterTask() {
    }
}
