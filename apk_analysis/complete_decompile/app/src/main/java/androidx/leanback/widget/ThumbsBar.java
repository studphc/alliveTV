package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ThumbsBar extends LinearLayout {

    /* renamed from: a */
    public int f6228a;

    /* renamed from: b */
    public int f6229b;

    /* renamed from: c */
    public int f6230c;

    /* renamed from: d */
    public int f6231d;

    /* renamed from: e */
    public int f6232e;

    /* renamed from: f */
    public int f6233f;

    /* renamed from: g */
    public final SparseArray f6234g;

    /* renamed from: h */
    public boolean f6235h;

    public ThumbsBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    public final void m1489a() {
        while (getChildCount() > this.f6228a) {
            removeView(getChildAt(getChildCount() - 1));
        }
        while (getChildCount() < this.f6228a) {
            addView(createThumbView(this), new LinearLayout.LayoutParams(this.f6229b, this.f6230c));
        }
        int heroIndex = getHeroIndex();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (heroIndex == i) {
                layoutParams.width = this.f6231d;
                layoutParams.height = this.f6232e;
            } else {
                layoutParams.width = this.f6229b;
                layoutParams.height = this.f6230c;
            }
            childAt.setLayoutParams(layoutParams);
        }
    }

    public void clearThumbBitmaps() {
        for (int i = 0; i < getChildCount(); i++) {
            setThumbBitmap(i, null);
        }
        this.f6234g.clear();
    }

    public View createThumbView(ViewGroup viewGroup) {
        return new ImageView(viewGroup.getContext());
    }

    public int getHeroIndex() {
        return getChildCount() / 2;
    }

    public Bitmap getThumbBitmap(int i) {
        return (Bitmap) this.f6234g.get(i);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int heroIndex = getHeroIndex();
        View childAt = getChildAt(heroIndex);
        int width = (getWidth() / 2) - (childAt.getMeasuredWidth() / 2);
        int measuredWidth = (childAt.getMeasuredWidth() / 2) + (getWidth() / 2);
        childAt.layout(width, getPaddingTop(), measuredWidth, childAt.getMeasuredHeight() + getPaddingTop());
        int measuredHeight = (childAt.getMeasuredHeight() / 2) + getPaddingTop();
        for (int i5 = heroIndex - 1; i5 >= 0; i5--) {
            int i6 = width - this.f6233f;
            View childAt2 = getChildAt(i5);
            childAt2.layout(i6 - childAt2.getMeasuredWidth(), measuredHeight - (childAt2.getMeasuredHeight() / 2), i6, (childAt2.getMeasuredHeight() / 2) + measuredHeight);
            width = i6 - childAt2.getMeasuredWidth();
        }
        while (true) {
            heroIndex++;
            if (heroIndex < this.f6228a) {
                int i7 = measuredWidth + this.f6233f;
                View childAt3 = getChildAt(heroIndex);
                childAt3.layout(i7, measuredHeight - (childAt3.getMeasuredHeight() / 2), childAt3.getMeasuredWidth() + i7, (childAt3.getMeasuredHeight() / 2) + measuredHeight);
                measuredWidth = i7 + childAt3.getMeasuredWidth();
            } else {
                return;
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        if (!this.f6235h) {
            int i3 = measuredWidth - this.f6231d;
            int i4 = ((i3 + r3) - 1) / (this.f6229b + this.f6233f);
            if (i4 < 2) {
                i4 = 2;
            } else if ((i4 & 1) != 0) {
                i4++;
            }
            int i5 = i4 + 1;
            if (this.f6228a != i5) {
                this.f6228a = i5;
                m1489a();
            }
        }
    }

    public void setHeroThumbSize(int i, int i2) {
        boolean z;
        this.f6232e = i2;
        this.f6231d = i;
        int heroIndex = getHeroIndex();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (heroIndex == i3) {
                View childAt = getChildAt(i3);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                boolean z2 = true;
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    z = true;
                } else {
                    z = false;
                }
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                } else {
                    z2 = z;
                }
                if (z2) {
                    childAt.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public void setNumberOfThumbs(int i) {
        this.f6235h = true;
        this.f6228a = i;
        m1489a();
    }

    public void setThumbBitmap(int i, Bitmap bitmap) {
        this.f6234g.put(i, bitmap);
        ((ImageView) getChildAt(i)).setImageBitmap(bitmap);
    }

    public void setThumbSize(int i, int i2) {
        boolean z;
        this.f6230c = i2;
        this.f6229b = i;
        int heroIndex = getHeroIndex();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (heroIndex != i3) {
                View childAt = getChildAt(i3);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                boolean z2 = true;
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    z = true;
                } else {
                    z = false;
                }
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                } else {
                    z2 = z;
                }
                if (z2) {
                    childAt.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public void setThumbSpace(int i) {
        this.f6233f = i;
        requestLayout();
    }

    public ThumbsBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6228a = -1;
        this.f6234g = new SparseArray();
        this.f6235h = false;
        this.f6229b = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_thumbs_width);
        this.f6230c = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_thumbs_height);
        this.f6232e = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_hero_thumbs_width);
        this.f6231d = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_hero_thumbs_height);
        this.f6233f = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_thumbs_margin);
    }
}
