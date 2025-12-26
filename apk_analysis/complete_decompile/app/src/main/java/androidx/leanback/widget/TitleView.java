package androidx.leanback.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.widget.SearchOrbView;
import androidx.leanback.widget.TitleViewAdapter;

/* loaded from: classes.dex */
public class TitleView extends FrameLayout implements TitleViewAdapter.Provider {

    /* renamed from: a */
    public final ImageView f6243a;

    /* renamed from: b */
    public final TextView f6244b;

    /* renamed from: c */
    public final SearchOrbView f6245c;

    /* renamed from: d */
    public int f6246d;

    /* renamed from: e */
    public boolean f6247e;

    /* renamed from: f */
    public final C0406x2 f6248f;

    public TitleView(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public final void m1490a() {
        ImageView imageView = this.f6243a;
        Drawable drawable = imageView.getDrawable();
        TextView textView = this.f6244b;
        if (drawable != null) {
            imageView.setVisibility(0);
            textView.setVisibility(8);
        } else {
            imageView.setVisibility(8);
            textView.setVisibility(0);
        }
    }

    public void enableAnimation(boolean z) {
        boolean z2;
        SearchOrbView searchOrbView = this.f6245c;
        if (z && searchOrbView.hasFocus()) {
            z2 = true;
        } else {
            z2 = false;
        }
        searchOrbView.enableOrbColorAnimation(z2);
    }

    @Nullable
    public Drawable getBadgeDrawable() {
        return this.f6243a.getDrawable();
    }

    @Nullable
    public SearchOrbView.Colors getSearchAffordanceColors() {
        return this.f6245c.getOrbColors();
    }

    @NonNull
    public View getSearchAffordanceView() {
        return this.f6245c;
    }

    @Nullable
    public CharSequence getTitle() {
        return this.f6244b.getText();
    }

    @Override // androidx.leanback.widget.TitleViewAdapter.Provider
    @NonNull
    public TitleViewAdapter getTitleViewAdapter() {
        return this.f6248f;
    }

    public void setBadgeDrawable(@Nullable Drawable drawable) {
        this.f6243a.setImageDrawable(drawable);
        m1490a();
    }

    public void setOnSearchClickedListener(@Nullable View.OnClickListener onClickListener) {
        boolean z;
        int i = 0;
        if (onClickListener != null) {
            z = true;
        } else {
            z = false;
        }
        this.f6247e = z;
        this.f6245c.setOnOrbClickedListener(onClickListener);
        if (!this.f6247e || (this.f6246d & 4) != 4) {
            i = 4;
        }
        this.f6245c.setVisibility(i);
    }

    public void setSearchAffordanceColors(@NonNull SearchOrbView.Colors colors) {
        this.f6245c.setOrbColors(colors);
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.f6244b.setText(charSequence);
        m1490a();
    }

    public void updateComponentsVisibility(int i) {
        this.f6246d = i;
        if ((i & 2) == 2) {
            m1490a();
        } else {
            this.f6243a.setVisibility(8);
            this.f6244b.setVisibility(8);
        }
        int i2 = 4;
        if (this.f6247e && (this.f6246d & 4) == 4) {
            i2 = 0;
        }
        this.f6245c.setVisibility(i2);
    }

    public TitleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, androidx.leanback.R.attr.browseTitleViewStyle);
    }

    public TitleView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6246d = 6;
        this.f6247e = false;
        this.f6248f = new C0406x2(this);
        View inflate = LayoutInflater.from(context).inflate(androidx.leanback.R.layout.lb_title_view, this);
        this.f6243a = (ImageView) inflate.findViewById(androidx.leanback.R.id.title_badge);
        this.f6244b = (TextView) inflate.findViewById(androidx.leanback.R.id.title_text);
        this.f6245c = (SearchOrbView) inflate.findViewById(androidx.leanback.R.id.title_orb);
        setClipToPadding(false);
        setClipChildren(false);
    }
}
