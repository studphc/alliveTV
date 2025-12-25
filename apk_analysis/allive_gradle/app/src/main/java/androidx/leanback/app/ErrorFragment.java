package androidx.leanback.app;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.leanback.R;

@Deprecated
/* loaded from: classes.dex */
public class ErrorFragment extends BrandedFragment {

    /* renamed from: j */
    public ViewGroup f4975j;

    /* renamed from: k */
    public ImageView f4976k;

    /* renamed from: l */
    public TextView f4977l;

    /* renamed from: m */
    public Button f4978m;

    /* renamed from: n */
    public Drawable f4979n;

    /* renamed from: o */
    public CharSequence f4980o;

    /* renamed from: p */
    public String f4981p;

    /* renamed from: q */
    public View.OnClickListener f4982q;

    /* renamed from: r */
    public Drawable f4983r;

    /* renamed from: s */
    public boolean f4984s = true;

    /* renamed from: a */
    public final void m1288a() {
        int i;
        ViewGroup viewGroup = this.f4975j;
        if (viewGroup != null) {
            Drawable drawable = this.f4983r;
            if (drawable != null) {
                viewGroup.setBackground(drawable);
                return;
            }
            Resources resources = viewGroup.getResources();
            if (this.f4984s) {
                i = R.color.lb_error_background_color_translucent;
            } else {
                i = R.color.lb_error_background_color_opaque;
            }
            viewGroup.setBackgroundColor(resources.getColor(i));
        }
    }

    /* renamed from: b */
    public final void m1289b() {
        int i;
        Button button = this.f4978m;
        if (button != null) {
            button.setText(this.f4981p);
            this.f4978m.setOnClickListener(this.f4982q);
            Button button2 = this.f4978m;
            if (TextUtils.isEmpty(this.f4981p)) {
                i = 8;
            } else {
                i = 0;
            }
            button2.setVisibility(i);
            this.f4978m.requestFocus();
        }
    }

    /* renamed from: c */
    public final void m1290c() {
        int i;
        TextView textView = this.f4977l;
        if (textView != null) {
            textView.setText(this.f4980o);
            TextView textView2 = this.f4977l;
            if (TextUtils.isEmpty(this.f4980o)) {
                i = 8;
            } else {
                i = 0;
            }
            textView2.setVisibility(i);
        }
    }

    @Nullable
    public Drawable getBackgroundDrawable() {
        return this.f4983r;
    }

    @Nullable
    public View.OnClickListener getButtonClickListener() {
        return this.f4982q;
    }

    @Nullable
    public String getButtonText() {
        return this.f4981p;
    }

    @Nullable
    public Drawable getImageDrawable() {
        return this.f4979n;
    }

    @Nullable
    public CharSequence getMessage() {
        return this.f4980o;
    }

    public boolean isBackgroundTranslucent() {
        return this.f4984s;
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        int i;
        int i2;
        int i3 = 0;
        View inflate = layoutInflater.inflate(R.layout.lb_error_fragment, viewGroup, false);
        this.f4975j = (ViewGroup) inflate.findViewById(R.id.error_frame);
        m1288a();
        installTitleView(layoutInflater, this.f4975j, bundle);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.image);
        this.f4976k = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f4979n);
            ImageView imageView2 = this.f4976k;
            if (this.f4979n == null) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            imageView2.setVisibility(i2);
        }
        this.f4977l = (TextView) inflate.findViewById(R.id.message);
        m1290c();
        this.f4978m = (Button) inflate.findViewById(R.id.button);
        m1289b();
        TextView textView = this.f4977l;
        Paint paint = new Paint(1);
        paint.setTextSize(textView.getTextSize());
        paint.setTypeface(textView.getTypeface());
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        if (viewGroup != null) {
            i = viewGroup.getResources().getDimensionPixelSize(R.dimen.lb_error_under_image_baseline_margin);
        } else {
            i = 0;
        }
        TextView textView2 = this.f4977l;
        int i4 = i + fontMetricsInt.ascent;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
        marginLayoutParams.topMargin = i4;
        textView2.setLayoutParams(marginLayoutParams);
        if (viewGroup != null) {
            i3 = viewGroup.getResources().getDimensionPixelSize(R.dimen.lb_error_under_message_baseline_margin);
        }
        Button button = this.f4978m;
        int i5 = i3 - fontMetricsInt.descent;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) button.getLayoutParams();
        marginLayoutParams2.topMargin = i5;
        button.setLayoutParams(marginLayoutParams2);
        return inflate;
    }

    @Override // androidx.leanback.app.BrandedFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f4975j.requestFocus();
    }

    public void setBackgroundDrawable(@Nullable Drawable drawable) {
        boolean z;
        this.f4983r = drawable;
        if (drawable != null) {
            int opacity = drawable.getOpacity();
            if (opacity != -3 && opacity != -2) {
                z = false;
            } else {
                z = true;
            }
            this.f4984s = z;
        }
        m1288a();
        m1290c();
    }

    public void setButtonClickListener(@Nullable View.OnClickListener onClickListener) {
        this.f4982q = onClickListener;
        m1289b();
    }

    public void setButtonText(@Nullable String str) {
        this.f4981p = str;
        m1289b();
    }

    public void setDefaultBackground(boolean z) {
        this.f4983r = null;
        this.f4984s = z;
        m1288a();
        m1290c();
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        int i;
        this.f4979n = drawable;
        ImageView imageView = this.f4976k;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
            ImageView imageView2 = this.f4976k;
            if (this.f4979n == null) {
                i = 8;
            } else {
                i = 0;
            }
            imageView2.setVisibility(i);
        }
    }

    public void setMessage(@Nullable CharSequence charSequence) {
        this.f4980o = charSequence;
        m1290c();
    }
}
