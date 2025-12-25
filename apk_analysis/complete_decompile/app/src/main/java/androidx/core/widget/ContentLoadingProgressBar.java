package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p000.RunnableC1960wv;

/* loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {

    /* renamed from: a */
    public long f4043a;

    /* renamed from: b */
    public boolean f4044b;

    /* renamed from: c */
    public boolean f4045c;

    /* renamed from: d */
    public boolean f4046d;

    /* renamed from: e */
    public final RunnableC1960wv f4047e;

    /* renamed from: f */
    public final RunnableC1960wv f4048f;

    public ContentLoadingProgressBar(@NonNull Context context) {
        this(context, null);
    }

    public void hide() {
        post(new RunnableC1960wv(this, 3));
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks(this.f4047e);
        removeCallbacks(this.f4048f);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f4047e);
        removeCallbacks(this.f4048f);
    }

    public void show() {
        post(new RunnableC1960wv(this, 2));
    }

    public ContentLoadingProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f4043a = -1L;
        this.f4044b = false;
        this.f4045c = false;
        this.f4046d = false;
        this.f4047e = new RunnableC1960wv(this, 0);
        this.f4048f = new RunnableC1960wv(this, 1);
    }
}
