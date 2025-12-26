package androidx.leanback.widget;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public interface MultiActionsProvider {

    /* loaded from: classes.dex */
    public static class MultiAction {

        /* renamed from: a */
        public final long f5921a;

        /* renamed from: b */
        public int f5922b = 0;

        /* renamed from: c */
        public Drawable[] f5923c;

        public MultiAction(long j) {
            this.f5921a = j;
        }

        public Drawable getCurrentDrawable() {
            return this.f5923c[this.f5922b];
        }

        public Drawable[] getDrawables() {
            return this.f5923c;
        }

        public long getId() {
            return this.f5921a;
        }

        public int getIndex() {
            return this.f5922b;
        }

        public void incrementIndex() {
            int i;
            int i2 = this.f5922b;
            if (i2 < this.f5923c.length - 1) {
                i = i2 + 1;
            } else {
                i = 0;
            }
            setIndex(i);
        }

        public void setDrawables(Drawable[] drawableArr) {
            this.f5923c = drawableArr;
            if (this.f5922b > drawableArr.length - 1) {
                this.f5922b = drawableArr.length - 1;
            }
        }

        public void setIndex(int i) {
            this.f5922b = i;
        }
    }

    MultiAction[] getActions();
}
